#include <stdio.h>
#include <stdlib.h>

typedef struct No {
    char letra;
    struct No *esq;
    struct No *dir;
} No;

No* novoNo(char letra) {
    No *temp = (No*) malloc(sizeof(No));
    temp->letra = letra;
    temp->esq = NULL;
    temp->dir = NULL;
    return temp;
}

No* inserirRec(No *raiz, char valor) {
    if (raiz == NULL) {
        raiz = novoNo(valor);
    } else if (valor < raiz->letra) {
        raiz->esq = inserirRec(raiz->esq, valor);
    } else if (valor > raiz->letra) {
        raiz->dir = inserirRec(raiz->dir, valor);
    }
    return raiz;
}

int buscarRec(No *raiz, char valor) {
    if (raiz == NULL) {
        return 0;
    } else if (valor == raiz->letra) {
        return 1;
    } else if (valor < raiz->letra) {
        return buscarRec(raiz->esq, valor);
    } else {
        return buscarRec(raiz->dir, valor);
    }
}

void percursoInfixa(No *raiz) {
    if (raiz != NULL) {
        percursoInfixa(raiz->esq);
        printf("%c ", raiz->letra);
        percursoInfixa(raiz->dir);
    }
}

void percursoPrefixa(No *raiz) {
    if (raiz != NULL) {
        printf("%c ", raiz->letra);
        percursoPrefixa(raiz->esq);
        percursoPrefixa(raiz->dir);
    }
}

void percursoPosfixa(No *raiz) {
    if (raiz != NULL) {
        percursoPosfixa(raiz->esq);
        percursoPosfixa(raiz->dir);
        printf("%c ", raiz->letra);
    }
}

int main() {
    No *raiz = NULL;
    char comando[20];

    while (scanf("%s", comando) != EOF) {
        if (comando[0] == 'I') {
            if (comando[1] == 'N') {
                percursoInfixa(raiz);
                printf("\n");
            } else {
                char letra;
                scanf(" %c", &letra);
                raiz = inserirRec(raiz, letra);
            }
        } else if (comando[0] == 'P') {
            if (comando[1] == 'R') {
                percursoPrefixa(raiz);
                printf("\n");
            } else if (comando[1] == 'O') {
                percursoPosfixa(raiz);
                printf("\n");
            } else {
                char letra;
                scanf(" %c", &letra);
                if (buscarRec(raiz, letra)) {
                    printf("%c existe\n", letra);
                } else {
                    printf("%c nao existe\n", letra);
                }
            }
        }
    }

    return 0;
}
