// Aluno: Davi Martins; Matricula: 885013

#include <stdio.h>
//funcao converte todas as letras para letras minusculas;
char min(char t){
    if(t>='A' && t<='Z'){
        return t+32;
    }
    return t;
}

//funcao recursiva que verifica se é inteiro
int inteiro(char t[], int i){
    if(t[i]=='\0'){
        return 1;
    }
    if(!(t[i]>='0' && t[i]<='9')){
        return 0;
    }
    return inteiro(t, i+1);
 
}

//funcao recursiva que verifica se a entrada e uma palavra composta so por vogais 
int vogal(char t[], int i){
    if(t[i]=='\0'){
        return 1;
    }
    char c=min(t[i]);
    if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u'){
        return 0;
    }
    return vogal(t, i+1);
}
//funcao recursiva que verifica se a entrada e uma palavra composta so por consoantes 
int consoante(char t[], int i){
    if(t[i]=='\0'){
        return 1;
    }
    char c=min(t[i]);
    if ((c < 'a' || c > 'z') || (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
        return 0;
    }
    return consoante(t, i+1);

}
//funcao recursiva que verifica se a entrada e um numero real
int real(char t[], int i, int s){
    if(t[i]=='\0'){
        return 1;
    }
    char c=t[i];
    if( (c < '0' || c > '9') && (c!='.' && c!=',')){
        return 0;
    }
    if(c=='.' || c==','){
        s++;
    }
    if(s>1){
        return 0;
    }
    return real(t, i+1, s);
}

int main() {
    char palavra[1000];
    scanf(" %[^\n]", palavra);

    while (!(palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M' && palavra[3] == '\0')) {

        if (vogal(palavra, 0)) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }

        if (consoante(palavra, 0)) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }

        if (inteiro(palavra, 0)) {
            printf("SIM ");
        } else {
            printf("NAO ");
        }

        if (real(palavra, 0, 0)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf(" %[^\n]", palavra);
    }
    return 0;
}
