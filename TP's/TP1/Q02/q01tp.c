//Aluno: Davi Martins Matricula: 885013

#include <stdio.h>
#include <string.h>

//Funcao recurssiva que verifica se a palavra é um palindromo, tem como parada o meio da string, pois a comparação ocorre das pontas ao meio 
int verificadorRecursivo(char s[], int m, int i, int count, int n){
  if(count==m/2){
    return 0;
  }else{
    if(s[i]==s[n]){
        count++;
        return verificadorRecursivo(s, m, i+1, count, n-1);
    }else{
        return 1;
    }
  }
}

int main(){
    int resp;
    char str[100];
    fgets(str, sizeof(str), stdin);
    //retira a ação da tecla enter da string, ja que ela considera como um char, e troca pelo fim de toda string. 
    str[strcspn(str, "\n")] = '\0';
    //Laço que chama a função recurssiva e printa se a palavra é ou não um palindromo 
    while(strcmp(str, "FIM") != 0){
        int n= strlen(str);
        int m=n, i=0, count=0;
        n--;
        resp=verificadorRecursivo(str, m, i, count, n);
        if(resp==0){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = '\0';

    }
}
