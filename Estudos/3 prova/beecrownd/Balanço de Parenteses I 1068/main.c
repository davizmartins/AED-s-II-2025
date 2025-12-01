#include <stdio.h>
#include <stdlib.h>
 
int main() {
    char linha[1000];
    
    while(fgets(linha, sizeof(linha), stdin) != NULL){
        int balance = 0;
        
        int ok = 1;
        
        for(int i=0; linha[i]!= '\0' && linha[i] != '\n'; i++){
            if(linha[i] == '('){
                balance++;
            } else if (linha[i] == ')'){
                if(balance == 0){
                    ok = 0;
                    break;
                } else {
                    balance--;
                }
            }
        }
        if( ok && balance == 0) {
            printf("correct\n");
        } else {
            printf("incorrect\n");
        }
    }
    return 0;
}