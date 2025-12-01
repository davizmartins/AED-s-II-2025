#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[105];
    int peso;
    int idade;
    double altura;
} Rena;

int compara_nome(char *a, char *b) {
    int i = 0;
    int tamA = strlen(a);
    int tamB = strlen(b);
    int limite = (tamA < tamB) ? tamA : tamB;

    for (i = 0; i < limite; i++) {
        if (a[i] != b[i]) {
            return (int)(a[i] - b[i]);
        }
    }
    return tamA - tamB;
}

int comparar(Rena *r1, Rena *r2) {
    if (r1->peso != r2->peso) {
        return r2->peso - r1->peso;  // peso decrescente
    }
    if (r1->idade != r2->idade) {
        return r1->idade - r2->idade; // idade crescente
    }
    if (r1->altura < r2->altura) {
        return -1;
    } else if (r1->altura > r2->altura) {
        return 1;
    }
    return compara_nome(r1->nome, r2->nome); // nome crescente
}

void ordenar(Rena v[], int n) {
    int i, j;
    for (i = 0; i < n - 1; i++) {
        int melhor = i;
        for (j = i + 1; j < n; j++) {
            if (comparar(&v[j], &v[melhor]) < 0) {
                melhor = j;
            }
        }
        if (melhor != i) {
            Rena aux = v[i];
            v[i] = v[melhor];
            v[melhor] = aux;
        }
    }
}

int main() {
    int T;
    int caso;

    if (scanf("%d", &T) != 1) {
        return 0;
    }

    for (caso = 1; caso <= T; caso++) {
        int N, M;
        int i;

        scanf("%d %d", &N, &M);

        Rena renas[1005];

        for (i = 0; i < N; i++) {
            scanf("%s %d %d %lf", renas[i].nome, &renas[i].peso,
                  &renas[i].idade, &renas[i].altura);
        }

        ordenar(renas, N);

        printf("CENARIO {%d}\n", caso);
        for (i = 0; i < M; i++) {
            printf("%d - %s\n", i + 1, renas[i].nome);
        }
    }

    return 0;
}
