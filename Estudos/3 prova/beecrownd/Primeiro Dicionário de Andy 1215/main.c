#include <stdio.h>

int ehLetra(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        return 1;
    }
    return 0;
}

char paraMinusculo(char c) {
    if (c >= 'A' && c <= 'Z') {
        return c + ('a' - 'A');
    }
    return c;
}

int tamanhoString(char s[]) {
    int i = 0;
    while (s[i] != '\0') {
        i++;
    }
    return i;
}

int comparaStrings(char a[], char b[]) {
    int i = 0;
    while (a[i] != '\0' && b[i] != '\0') {
        if (a[i] != b[i]) {
            return a[i] - b[i];
        }
        i++;
    }
    return tamanhoString(a) - tamanhoString(b);
}

void copiaString(char destino[], char origem[]) {
    int i = 0;
    while (origem[i] != '\0') {
        destino[i] = origem[i];
        i++;
    }
    destino[i] = '\0';
}

int main() {
    char palavras[5000][205];
    int qtdPalavras = 0;

    char palavra[205];
    int indice = 0;

    int ch;
    int i, j;

    while ((ch = getchar()) != EOF) {
        if (ehLetra(ch)) {
            if (indice < 204) {
                palavra[indice] = paraMinusculo((char)ch);
                indice++;
            }
        } else {
            if (indice > 0) {
                palavra[indice] = '\0';

                int existe = 0;
                for (i = 0; i < qtdPalavras; i++) {
                    if (comparaStrings(palavras[i], palavra) == 0) {
                        existe = 1;
                        break;
                    }
                }

                if (!existe && qtdPalavras < 5000) {
                    copiaString(palavras[qtdPalavras], palavra);
                    qtdPalavras++;
                }

                indice = 0;
            }
        }
    }

    if (indice > 0) {
        palavra[indice] = '\0';

        int existe = 0;
        for (i = 0; i < qtdPalavras; i++) {
            if (comparaStrings(palavras[i], palavra) == 0) {
                existe = 1;
                break;
            }
        }

        if (!existe && qtdPalavras < 5000) {
            copiaString(palavras[qtdPalavras], palavra);
            qtdPalavras++;
        }
    }

    for (i = 0; i < qtdPalavras - 1; i++) {
        int posMenor = i;
        for (j = i + 1; j < qtdPalavras; j++) {
            if (comparaStrings(palavras[j], palavras[posMenor]) < 0) {
                posMenor = j;
            }
        }
        if (posMenor != i) {
            char aux[205];
            copiaString(aux, palavras[i]);
            copiaString(palavras[i], palavras[posMenor]);
            copiaString(palavras[posMenor], aux);
        }
    }

    for (i = 0; i < qtdPalavras; i++) {
        printf("%s\n", palavras[i]);
    }

    return 0;
}
