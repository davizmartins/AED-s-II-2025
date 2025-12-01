#include <stdio.h>
#include <stdlib.h>

typedef struct {
    char nome[31];
    int valor;
    int anterior;
    int proxima;
} Crianca;

int main() {
    int n;

    while (scanf("%d", &n) == 1) {
        if (n == 0) {
            break;
        }

        Crianca v[100];
        int i;

        for (i = 0; i < n; i++) {
            scanf("%s %d", v[i].nome, &v[i].valor);
        }

        for (i = 0; i < n; i++) {
            v[i].anterior = (i - 1 + n) % n;
            v[i].proxima = (i + 1) % n;
        }

        int indiceAtual = 0;
        int qtd = n;

        while (qtd > 1) {
            int valor = v[indiceAtual].valor;
            int j;

            if (valor % 2 != 0) {
                for (j = 0; j < valor; j++) {
                    indiceAtual = v[indiceAtual].proxima;
                }
            } else {
                for (j = 0; j < valor; j++) {
                    indiceAtual = v[indiceAtual].anterior;
                }
            }

            int ant = v[indiceAtual].anterior;
            int prox = v[indiceAtual].proxima;
            v[ant].proxima = prox;
            v[prox].anterior = ant;
            qtd--;
        }

        indiceAtual = v[indiceAtual].proxima;
        printf("Vencedor(a): %s\n", v[indiceAtual].nome);
    }

    return 0;
}
