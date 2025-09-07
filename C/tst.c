#include <stdio.h>
#include <string.h>
#include <stdbool.h>


bool isPalindromo(char s[]) {
    int i = 0;
    int j = strlen(s) - 1;

    while (i < j) {
        if (s[i] != s[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

int main() {
    char linha[1000];

    while (1) {
        fgets(linha, sizeof(linha), stdin);

        linha[strcspn(linha, "\n")] = '\0';


        if (strcmp(linha, "FIM") == 0) {
            break;
        }

        if (isPalindromo(linha)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
