#include <stdio.h>
#include <stdlib.h>

typedef struct No {
    int valor;
    struct No *esq;
    struct No *dir;
} No;

No* novoNo(int x) {
    No *n = (No*) malloc(sizeof(No));
    n->valor = x;
    n->esq = NULL;
    n->dir = NULL;
    return n;
}

No* inserir(No *raiz, int x) {
    if (raiz == NULL) {
        raiz = novoNo(x);
    } else if (x < raiz->valor) {
        raiz->esq = inserir(raiz->esq, x);
    } else if (x > raiz->valor) {
        raiz->dir = inserir(raiz->dir, x);
    }
    return raiz;
}

void liberar(No *raiz) {
    if (raiz != NULL) {
        liberar(raiz->esq);
        liberar(raiz->dir);
        free(raiz);
    }
}

void percursoNivel(No *raiz, int n) {
    No *fila[600];
    int inicio = 0;
    int fim = 0;
    int primeiro = 1;

    if (raiz != NULL) {
        fila[fim++] = raiz;
    }

    while (inicio < fim) {
        No *atual = fila[inicio++];
        if (!primeiro) {
            printf(" ");
        }
        printf("%d", atual->valor);
        primeiro = 0;

        if (atual->esq != NULL) {
            fila[fim++] = atual->esq;
        }
        if (atual->dir != NULL) {
            fila[fim++] = atual->dir;
        }
    }

    printf("\n");
}

int main() {
    int casos;
    int i, j;

    if (scanf("%d", &casos) != 1) {
        return 0;
    }

    for (i = 1; i <= casos; i++) {
        int n;
        scanf("%d", &n);

        No *raiz = NULL;

        for (j = 0; j < n; j++) {
            int x;
            scanf("%d", &x);
            raiz = inserir(raiz, x);
        }

        printf("Case %d:\n", i);
        percursoNivel(raiz, n);
        printf("\n");

        liberar(raiz);
    }

    return 0;
}
