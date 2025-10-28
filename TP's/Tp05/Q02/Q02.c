//Aluno: Davi Martins / Matricula: 885013
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <locale.h>
#include <time.h>


#define TAMMAXLINHA 4096
#define TAMMAXCAMPO 1024
int comparacoes = 0;
int movimentacoes = 0;

typedef struct {
    int id;
    char *name;
    char *data;
    int owners;
    float price;
    char **languages;     int languagesCount;
    int mScore;
    float uScore;
    int conq;
    char **publisher;     int publisherCount;
    char **dev;           int devCount;
    char **categories;    int categoriesCount;
    char **generos;       int generosCount;
    char **tags;          int tagsCount;
} Game;

// Duplica uma string 
char* copiaStr(const char* s) {
    char* nova = malloc(strlen(s) + 1);
    if (nova) strcpy(nova, s);
    return nova;
}

// tira espaços do final
void tiraEspacosFim(char* s) {
    int i = strlen(s) - 1;
    while (i >= 0 && isspace((unsigned char)s[i])) {
        s[i] = '\0';
        i--;
    }
}

// avança espaços no início
void pulaEspacos(char** s) {
    while (**s && isspace((unsigned char)**s)) (*s)++;
}

// compara ignorando maiúsc/minúsc
int igualIgnoreCase(const char* a, const char* b) {
    while (*a && *b) {
        if (tolower(*a) != tolower(*b)) return 0;
        a++; b++;
    }
    return *a == *b;
}

// limpa colchetes, aspas e deixa vírgulas formatadas
void limparLista(char* s) {
    char* w = s;
    for (char* r = s; *r; r++) {
        if (*r == '[' || *r == ']' || *r == '"' || *r == '\'') continue;
        *w++ = *r;
    }
    *w = '\0';

    char temp[TAMMAXCAMPO * 2];
    int j = 0;
    for (int i = 0; s[i] && j + 2 < sizeof(temp); i++) {
        if (s[i] == ',') {
            temp[j++] = ',';
            if (s[i + 1] && s[i + 1] != ' ') temp[j++] = ' ';
        } else temp[j++] = s[i];
    }
    temp[j] = '\0';
    strcpy(s, temp);
}

// divide uma string em partes (por vírgula)
char** separarString(const char* texto, const char* delim, int* qtd) {
    *qtd = 0;
    if (!texto || !*texto) return NULL;
    char* copia = copiaStr(texto);
    char* token = strtok(copia, delim);
    char** lista = NULL;

    while (token) {
        char* p = token;
        pulaEspacos(&p);
        tiraEspacosFim(p);
        if (*p) {
            lista = realloc(lista, sizeof(char*) * (*qtd + 1));
            lista[*qtd] = copiaStr(p);
            (*qtd)++;
        }
        token = strtok(NULL, delim);
    }
    free(copia);
    return lista;
}

// imprime lista de strings
void printLista(char** lista, int qtd) {
    printf("[");
    for (int i = 0; i < qtd; i++) {
        printf("%s%s", lista[i], (i == qtd - 1) ? "" : ", ");
    }
    printf("]");
}

// libera memória da lista
void freeLista(char*** lista, int* qtd) {
    if (*lista) {
        for (int i = 0; i < *qtd; i++) free((*lista)[i]);
        free(*lista);
    }
    *lista = NULL;
    *qtd = 0;
}

// formata datas tipo "MMM d, yyyy" para "dd/MM/yyyy"
char* formatarData(const char* dataCsv) {
    char tmp[TAMMAXCAMPO];
    int j = 0;
    for (int i = 0; dataCsv[i] && j + 1 < sizeof(tmp); i++) {
        if (dataCsv[i] != '"') tmp[j++] = dataCsv[i];
    }
    tmp[j] = '\0';

    char buf[TAMMAXCAMPO];
    strcpy(buf, tmp);
    char *mes = NULL, *dia = NULL, *ano = NULL;
    char* p = buf;
    pulaEspacos(&p);
    if (!*p) return copiaStr("sem data");

    char* espaco = strchr(p, ' ');
    if (espaco) {
        *espaco = '\0';
        mes = p;
        char* resto = espaco + 1;
        pulaEspacos(&resto);

        char* virgula = strchr(resto, ',');
        if (virgula) {
            *virgula = '\0';
            dia = resto;
            ano = virgula + 1;
            pulaEspacos(&ano);
        } else {
            dia = "01";
            ano = resto;
        }
    } else {
        mes = "Jan";
        dia = "01";
        ano = p;
    }

    int m = 1;
    if (!strcmp(mes, "Jan")) m = 1; else if (!strcmp(mes, "Feb")) m = 2;
    else if (!strcmp(mes, "Mar")) m = 3; else if (!strcmp(mes, "Apr")) m = 4;
    else if (!strcmp(mes, "May")) m = 5; else if (!strcmp(mes, "Jun")) m = 6;
    else if (!strcmp(mes, "Jul")) m = 7; else if (!strcmp(mes, "Aug")) m = 8;
    else if (!strcmp(mes, "Sep")) m = 9; else if (!strcmp(mes, "Oct")) m = 10;
    else if (!strcmp(mes, "Nov")) m = 11; else if (!strcmp(mes, "Dec")) m = 12;

    int d = atoi(dia);
    int y = atoi(ano);
    char out[16];
    sprintf(out, "%02d/%02d/%04d", d, m, y);
    return copiaStr(out);
}

// lê uma linha CSV e transforma em struct Game
void lerGame(Game* g, const char* linha) {
    char campo[TAMMAXCAMPO];
    int pos = 0, idx = 0;
    bool emAspas = false;

    *g= (Game){0};  //ele reseta pra 0 todos os campos de forma definida em C
    g->mScore = -1; g->uScore = -1.0f; g->conq = 0;

    for (int i = 0;; i++) {
        char c = linha[i];
        bool fim = (c == '\0');

        if (!fim && c == '"') {
            emAspas = !emAspas;
            continue;
        }

        if (fim || (c == ',' && !emAspas)) {
            campo[pos] = '\0';
            switch (idx) {
                case 0: g->id = atoi(campo); break;
                case 1: g->name = copiaStr(campo); break;
                case 2: g->data = formatarData(campo); break;
                case 3: {
                    char temp[TAMMAXCAMPO]; strcpy(temp, campo);
                    char* h = strchr(temp, '-'); if (h) *h = '\0';
                    g->owners = atoi(temp);
                } break;
                case 4: g->price = atof(campo); break;
                case 5: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->languages = separarString(temp, ",", &g->languagesCount);
                } break;
                case 6: g->mScore = (campo[0] ? atoi(campo) : -1); break;
                case 7: g->uScore = (!campo[0] || igualIgnoreCase(campo, "tbd")) ? -1.0f : atof(campo); break;
                case 8: g->conq = (campo[0] ? atoi(campo) : 0); break;
                case 9: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->publisher = separarString(temp, ",", &g->publisherCount);
                } break;
                case 10: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->dev = separarString(temp, ",", &g->devCount);
                } break;
                case 11: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->categories = separarString(temp, ",", &g->categoriesCount);
                } break;
                case 12: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->generos = separarString(temp, ",", &g->generosCount);
                } break;
                case 13: {
                    char temp[TAMMAXCAMPO]; strncpy(temp, campo, sizeof(temp)); temp[sizeof(temp)-1] = '\0';
                    limparLista(temp);
                    g->tags = separarString(temp, ",", &g->tagsCount);
                } break;
            }
            idx++; pos = 0;
            if (fim) break;
        } else if (pos + 1 < TAMMAXCAMPO) {
            campo[pos++] = c;
        }
    }
}

// imprime jogo no formato certo
void printGame(const Game* g) {
    printf("=> %d ## %s ## %s ## %d ## %.2f ## ",
           g->id, g->name, g->data, g->owners, g->price);
    printLista(g->languages, g->languagesCount);
    printf(" ## %d ## %.1f ## %d ## ", g->mScore, g->uScore, g->conq);
    printLista(g->publisher, g->publisherCount);
    printf(" ## ");
    printLista(g->dev, g->devCount);
    printf(" ## ");
    printLista(g->categories, g->categoriesCount);
    printf(" ## ");
    printLista(g->generos, g->generosCount);
    printf(" ## ");
    printLista(g->tags, g->tagsCount);
    printf(" ##\n");
}

// libera memória do jogo
void freeGame(Game* g) {
    free(g->name);
    free(g->data);
    freeLista(&g->languages, &g->languagesCount);
    freeLista(&g->publisher, &g->publisherCount);
    freeLista(&g->dev, &g->devCount);
    freeLista(&g->categories, &g->categoriesCount);
    freeLista(&g->generos, &g->generosCount);
    freeLista(&g->tags, &g->tagsCount);
}

//Função para ordenar o array em ordem alfabetica
void ordenarNome(Game **g, int n) {
     for (int i = 0; i < (n - 1); i++) {
        int menor = i;
        for (int j = (i + 1); j < n; j++) {
            comparacoes++;
            if (strcmp(g[j]->name, g[menor]->name) < 0) {
                menor = j;
            }
        }
        if (menor != i) {
            Game* temp = g[i];
            g[i] = g[menor];
            g[menor] = temp;
            movimentacoes += 3;
        }
    }
}

int main() {
    setlocale(LC_NUMERIC, "C"); // garante ponto em floats (7.99)
    const char* caminho = "games.csv";

    // 1) Carrega o CSV
    FILE* arq = fopen(caminho, "r");
    if (!arq) { perror("Erro ao abrir /tmp/games.csv"); return 1; }

    char linha[TAMMAXLINHA];
    int total = 0;

    if (fgets(linha, sizeof(linha), arq)) {
        while (fgets(linha, sizeof(linha), arq)) total++;
    }
    fclose(arq);

    Game* jogos = (Game*) malloc(sizeof(Game) * (total > 0 ? total : 1));
    int i = 0;

    arq = fopen(caminho, "r");
    if (!arq) { perror("Erro ao reabrir /tmp/games.csv"); free(jogos); return 1; }

    // pula cabeçalho
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq)) {
        linha[strcspn(linha, "\r\n")] = 0;
        if (i < total) {
            lerGame(&jogos[i], linha);
            i++;
        }
    }
    fclose(arq);

    // 2) Lê e busca jogos pelo ID e armazena em um novo array de jogosOrdenados
    Game** jogosOrdenados = (Game**) malloc(sizeof(Game*) * (total));
    char entrada[TAMMAXCAMPO];
    int aux=0;
    while (fgets(entrada, sizeof(entrada), stdin)) {
        entrada[strcspn(entrada, "\r\n")] = 0; // remove \n e \r
        if (entrada[0] == '\0') continue;      // ignora linha vazia
        if (strcmp(entrada, "FIM") == 0) break;
        
        int id = atoi(entrada);
        for (int k = 0; k < i; k++) {
            if (jogos[k].id == id) {
                jogosOrdenados[aux] = &jogos[k];
                aux++;
                break; // se IDs não repetem, pode sair
            }
        }
    }

    // 3) chama a função para ordenar o array em ordem alfabetica
    clock_t inicio = clock();
    for(int x=0; x<1000; x++){
        ordenarNome(jogosOrdenados, aux);
    }
    clock_t fim = clock();
    double tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;


    // 4) Imprime os jogos na ordem solicitada
    for (int k = 0; k < aux; k++) {
        printGame(jogosOrdenados[k]);
    }
    
    // Criar arquivo de log
    FILE *logf = fopen("885013_selecao.txt", "w");
    if (logf) {
        fprintf(logf, "885013\t %d\t %d\t %.6f\n", comparacoes, movimentacoes, tempo);
        fclose(logf);
    }

    // 5) Libera memória
    for (int k = 0; k < i; k++){
        freeGame(&jogos[k]);
    }
    free(jogosOrdenados); 
    free(jogos);
    return 0;
}
