#include <stdio.h>

int contador(char n[], char f[]){
    if(strcmp(n,f) == 0){
        return 0;
    }

    int c=0;
    int i=0;
    while(n[i]!='\0'){
    if(n[i] >= 'A' && n[i] <= 'Z'){
        c++;
    }
    i++;
    }
    printf("%d\nd",c);
    fgets(n, 50, stdin);
    return contador(n,f);
}

int main (){
    char p[50];
    char f[]="FIM\n";
    fgets(p, 50, stdin);
    contador(p,f);
    return 0;
}

