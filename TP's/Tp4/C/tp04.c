#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Tamanhos máximos para buffers de strings, para evitar estouros de memória.
#define MAX_LINE_SIZE 2048
#define MAX_FIELD_SIZE 512

// Em C, usamos uma struct para agrupar os dados, similar a uma classe sem métodos.
typedef struct {
    int id;
    char* name;
    char* data;
    int owners;
    float price;
    char** languages;
    int languages_count; // C não sabe o tamanho de um array, então precisamos guardar.
    int mScore;
    float uScore;
    int conq;
    char** publisher;
    int publisher_count;
    char** dev;
    int dev_count;
    char** categories;
    int categories_count;
    char** generos;
    int generos_count;
    char** tags;
    int tags_count;
} Game;

// Função para imprimir um array de strings, similar ao takeArray do Java.
void print_string_array(char** arr, int count) {
    printf("[");
    for (int i = 0; i < count; i++) {
        printf("%s%s", arr[i], (i == count - 1) ? "" : ", ");
    }
    printf("]");
}

// Função para imprimir um único jogo, similar ao toString.
void print_game(Game* g) {
    printf("=> %d ## %s ## %s ## %d ## %.2f ## ", g->id, g->name, g->data, g->owners, g->price);
    print_string_array(g->languages, g->languages_count);
    printf(" ## %d ## %.1f ## %d ## ", g->mScore, g->uScore, g->conq);
    print_string_array(g->publisher, g->publisher_count);
    printf(" ## ");
    print_string_array(g->dev, g->dev_count);
    printf(" ## ");
    print_string_array(g->categories, g->categories_count);
    printf(" ## ");
    print_string_array(g->generos, g->generos_count);
    printf(" ## ");
    print_string_array(g->tags, g->tags_count);
    printf(" ##\n");
}

// Função crucial em C: libera toda a memória alocada para um jogo.
void free_game(Game* g) {
    free(g->name);
    free(g->data);
    for (int i = 0; i < g->languages_count; i++) free(g->languages[i]);
    free(g->languages);
    for (int i = 0; i < g->publisher_count; i++) free(g->publisher[i]);
    free(g->publisher);
    for (int i = 0; i < g->dev_count; i++) free(g->dev[i]);
    free(g->dev);
    for (int i = 0; i < g->categories_count; i++) free(g->categories[i]);
    free(g->categories);
    for (int i = 0; i < g->generos_count; i++) free(g->generos[i]);
    free(g->generos);
    for (int i = 0; i < g->tags_count; i++) free(g->tags[i]);
    free(g->tags);
}

// Função auxiliar para duplicar uma string, alocando nova memória.
// Muito útil para evitar que todas as variáveis apontem para o mesmo lugar.
char* strdup(const char* s) {
    char* new_str = malloc(strlen(s) + 1);
    if (new_str) {
        strcpy(new_str, s);
    }
    return new_str;
}

// Implementação do "split" para arrays de strings
char** split_string(const char* text, const char* delim, int* count) {
    char* text_copy = strdup(text);
    char** result = NULL;
    char* token = strtok(text_copy, delim);
    *count = 0;
    while (token) {
        // Realoca o array de ponteiros para caber mais um
        result = realloc(result, sizeof(char*) * (*count + 1));
        // Remove espaços em branco no início/fim do token
        while (*token == ' ') token++;
        char* end = token + strlen(token) - 1;
        while (end > token && *end == ' ') end--;
        *(end + 1) = '\0';
        
        result[*count] = strdup(token);
        (*count)++;
        token = strtok(NULL, delim);
    }
    free(text_copy);
    return result;
}

// Função para formatar a data (lógica simplificada para C)
char* format_date(const char* csv_date) {
    // Esta é uma implementação simplificada. Uma versão completa seria mais complexa.
    // Para o escopo do trabalho, vamos apenas copiar o valor limpando as aspas.
    char* clean_date = strdup(csv_date);
    // Remove aspas
    char* ptr = strchr(clean_date, '"');
    while(ptr) {
        memmove(ptr, ptr + 1, strlen(ptr));
        ptr = strchr(ptr, '"');
    }
    // A lógica de conversão dd/mm/aaaa pode ser adicionada aqui se necessário.
    return clean_date;
}

// A função mais complexa: faz o parse da linha CSV.
void parse_game(Game* game, char* line) {
    // Em C, é mais seguro percorrer a linha manualmente do que usar um regex complexo.
    char buffer[MAX_FIELD_SIZE];
    int field_index = 0;
    int buffer_pos = 0;
    bool in_quotes = false;

    for (int i = 0; line[i] != '\0'; i++) {
        if (line[i] == '"') {
            in_quotes = !in_quotes;
        } else if (line[i] == ',' && !in_quotes) {
            buffer[buffer_pos] = '\0'; // Finaliza a string do campo

            // Preenche o campo correspondente no struct Game
            switch (field_index) {
                case 0: game->id = atoi(buffer); break;
                case 1: game->name = strdup(buffer); break;
                case 2: game->data = format_date(buffer); break;
                case 3: game->owners = atoi(strtok(buffer, "-")); break;
                case 4: game->price = atof(buffer); break;
                case 5: { // Bloco para tratar os idiomas
                    char* langs = strdup(buffer);
                    char* p = langs;
                    while ((p = strchr(p, '\''))) *p = ' ';
                    memmove(langs, langs + 1, strlen(langs));
                    langs[strlen(langs)-1] = '\0';
                    game->languages = split_string(langs, ",", &game->languages_count);
                    free(langs);
                    break;
                }
                case 6: game->mScore = (strlen(buffer) == 0) ? -1 : atoi(buffer); break;
                case 7: game->uScore = (strlen(buffer) == 0 || strcmp(buffer, "tbd") == 0) ? -1.0f : atof(buffer); break;
                case 8: game->conq = (strlen(buffer) == 0) ? 0 : atoi(buffer); break;
                case 9: game->publisher = split_string(buffer, ",", &game->publisher_count); break;
                case 10: game->dev = split_string(buffer, ",", &game->dev_count); break;
                case 11: game->categories = split_string(buffer, ",", &game->categories_count); break;
                case 12: game->generos = split_string(buffer, ",", &game->generos_count); break;
            }
            buffer_pos = 0;
            field_index++;
        } else {
            if (buffer_pos < MAX_FIELD_SIZE - 1) {
                buffer[buffer_pos++] = line[i];
            }
        }
    }
    // Trata o último campo (tags)
    buffer[buffer_pos] = '\0';
    game->tags = split_string(buffer, ",", &game->tags_count);
}

int main() {
    char* filePath = "D:\\Faculdade\\2°Periodo\\Aeds II\\AED-s-II-2025\\TP's\\Tp4\\tmp\\games.csv";
    FILE* file;
    char line[MAX_LINE_SIZE];
    int totalGames = 0;

    // ETAPA 1: Contagem das linhas
    file = fopen(filePath, "r");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para contagem");
        return 1;
    }
    fgets(line, sizeof(line), file); // Pula o cabeçalho
    while (fgets(line, sizeof(line), file)) {
        totalGames++;
    }
    fclose(file);

    // ETAPA 2: Alocação de memória e preenchimento
    Game* games = malloc(sizeof(Game) * totalGames);
    int i = 0;

    file = fopen(filePath, "r");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo para leitura");
        free(games);
        return 1;
    }
    fgets(line, sizeof(line), file); // Pula o cabeçalho
    while (fgets(line, sizeof(line), file)) {
        // Remove o \n do final da linha lida por fgets
        line[strcspn(line, "\r\n")] = 0;
        if (i < totalGames) {
            parse_game(&games[i], line);
            i++;
        }
    }
    fclose(file);

    // ETAPA 3: Leitura da entrada e busca
    char input_line[MAX_FIELD_SIZE];
    while (fgets(input_line, sizeof(input_line), stdin)) {
        input_line[strcspn(input_line, "\r\n")] = 0; // Remove \n
        if (strcmp(input_line, "FIM") == 0) {
            break;
        }
        
        int id_to_find = atoi(input_line);
        for (int k = 0; k < totalGames; k++) {
            if (games[k].id == id_to_find) {
                print_game(&games[k]);
                break;
            }
        }
    }

    // ETAPA FINAL E MAIS IMPORTANTE: Liberar toda a memória alocada
    for (int k = 0; k < totalGames; k++) {
        free_game(&games[k]);
    }
    free(games);

    return 0;
}