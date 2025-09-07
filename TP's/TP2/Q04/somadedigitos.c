//Aluno: Davi Martins; Matricula:885013
#include <stdio.h>
//funcao que realiza a soma dos digitos de um numero de maneira recursiva
int somaDigitoRecursiva(int n, int s){
    if(n==0){
        return s;
    }
    int r=n%10;
    s+=r;
    n/=10;
    return somaDigitoRecursiva(n,s);
}
//funcao principal
int main() {
    int n, r;
    int s=0;
    char fim[]="FIM";
    char str[100];
    scanf("%s", str);
    while(strcmp(str,fim) != 0){
        sscanf(str, "%d", &n);
        r=somaDigitoRecursiva(n,s);
        printf("%d\n", r);
        s=0;
        scanf("%s", str);
    }
    return 0;
}
