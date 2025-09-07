#include <stdio.h>

int contador(char n[]){
 int c=0;
 int i=0;
 while(n[i]!='\0'){
    if(n[i] >= 'A' && n[i] <= 'Z'){
        c++;
    }
    i++;
 }
 return c;
}

int main (){
    char p[50];
    char f[]="FIM\n";

    fgets(p, 50, stdin);

    while(strcmp(p,f) != 0){

        printf("%d\n", contador(p));
        fgets(p, 50, stdin) ;
    }
return 0;
}
