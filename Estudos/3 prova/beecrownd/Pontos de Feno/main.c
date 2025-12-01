#include <stdio.h>

int comparaStrings(char s1[], char s2[]) {
    int i = 0;

    while (s1[i] != '\0' && s2[i] != '\0' && s1[i] == s2[i]) {
        i++;
    }

    return (int)(s1[i] - s2[i]);  // 0 se forem iguais
}

int main() {
    int qtdPalavras, qtdDescricoes;
    int i, j;

    if (scanf("%d %d", &qtdPalavras, &qtdDescricoes) != 2) {
        return 0;
    }

    char dicionario[1005][105];
    int pontos[1005];

    for (i = 0; i < qtdPalavras; i++) {
        scanf("%s %d", dicionario[i], &pontos[i]);
    }

    for (i = 0; i < qtdDescricoes; i++) {
        int totalPontos = 0;

        while (1) {
            char palavra[105];
            scanf("%s", palavra);

            if (comparaStrings(palavra, ".") == 0) {
                break;
            }

            for (j = 0; j < qtdPalavras; j++) {
                if (comparaStrings(dicionario[j], palavra) == 0) {
                    totalPontos += pontos[j];
                    break;
                }
            }
        }

        printf("%d\n", totalPontos);
    }

    return 0;
}
