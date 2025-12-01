#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int *tabela;
    int tam;
    int padrao;
    int soma;
} Hash;

void inicializarHash(Hash *h, int tamanho) {
    int i;
    h->tam = tamanho;
    h->padrao = -1;
    h->soma = 0;
    h->tabela = (int*) malloc(tamanho * sizeof(int));
    for (i = 0; i < tamanho; i++) {
        h->tabela[i] = h->padrao;
    }
}

int funcaoHash(Hash *h, int elemento) {
    if (h->tam == 0) return 0;
    return elemento % h->tam;
}

void inserirHash(Hash *h, int elemento) {
    int pos = funcaoHash(h, elemento);
    h->tabela[pos] = elemento;  
    h->soma += elemento;        
}

int obterValor(int linha, char texto[]) {
    int i = 0;
    int valor = 0;
    while (texto[i] != '\0') {
        int posLetra = texto[i] - 'A';  
        valor += linha + posLetra + i;  
        i++;
    }
    return valor;
}

int main() {
    int casos;
    int i;

    if (scanf("%d", &casos) != 1) {
        return 0;
    }

    while (casos > 0) {
        int qtdLinhas;
        scanf("%d", &qtdLinhas);

        Hash h;
        inicializarHash(&h, qtdLinhas);

        for (i = 0; i < qtdLinhas; i++) {
            char texto[60];
            scanf("%s", texto);  

            int valor = obterValor(i, texto);
            inserirHash(&h, valor);
        }

        printf("%d\n", h.soma);

        free(h.tabela);
        casos--;
    }

    return 0;
}
