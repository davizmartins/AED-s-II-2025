#include <stdio.h>
#include <string.h>

int comparaStrings(char s1[], char s2[]) {
    int i = 0;
    while (s1[i] != '\0' && s2[i] != '\0' && s1[i] == s2[i]) {
        i++;
    }
    return (int)(s1[i] - s2[i]);  // 0 se iguais, <0 se s1<s2, >0 se s1>s2
}

int ehMelhor(char nomeNovo[], int nivelNovo, int deusNovo, int mortesNovo,
             char nomeMelhor[], int nivelMelhor, int deusMelhor, int mortesMelhor) {

    if (nivelNovo != nivelMelhor) {
        return nivelNovo > nivelMelhor;
    }

    if (deusNovo != deusMelhor) {
        return deusNovo > deusMelhor;
    }

    if (mortesNovo != mortesMelhor) {
        return mortesNovo < mortesMelhor;
    }

    return (comparaStrings(nomeNovo, nomeMelhor) < 0);
}

int main() {
    int quantidadeSeres;

    while (scanf("%d", &quantidadeSeres) == 1) {
        char melhorNome[110];
        int melhorNivel = 0;
        int melhorDeus = 0;
        int melhorMortes = 0;
        int temMelhor = 0;

        int i;
        for (i = 0; i < quantidadeSeres; i++) {
            char nome[110];
            int nivel, deus, mortes;

            scanf("%s %d %d %d", nome, &nivel, &deus, &mortes);

            if (!temMelhor) {
                strcpy(melhorNome, nome);
                melhorNivel = nivel;
                melhorDeus = deus;
                melhorMortes = mortes;
                temMelhor = 1;
            } else if (ehMelhor(nome, nivel, deus, mortes,
                                melhorNome, melhorNivel, melhorDeus, melhorMortes)) {
                strcpy(melhorNome, nome);
                melhorNivel = nivel;
                melhorDeus = deus;
                melhorMortes = mortes;
            }
        }

        printf("%s\n", melhorNome);
    }

    return 0;
}
