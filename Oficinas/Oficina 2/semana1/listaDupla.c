#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int elemento;
    CelulaD *prox;
    CelulaD *ant;    
}CelulaD;

CelulaD *novaCelulaD(int elemento){
    CelulaD *nova= ((CelulaD*)malloc(sizeof(CelulaD)));
    nova->elemento=elemento;
    nova->prox=nova->ant= NULL;
    return nova;
}

CelulaD* primeiro;
CelulaD* ultimo;

void criarLista(){
    primeiro= novaCelulaD(-1);
    ultimo=primeiro;
}

void inserirInicio(int x){
    CelulaD *tmp = novaCelulaD(x);
    tmp->ant=primeiro;
    tmp->prox=primeiro->prox;
    primeiro->prox=tmp;
    if(primeiro==ultimo){
        ultimo=tmp;
    }else{
        tmp->prox->ant= tmp; 
    }
    tmp= free;
}

void inserirFim(int x){
    CelulaD *tmp= novaCelulaD(x);
    tmp->ant=ultimo;
    ultimo->prox=tmp;
    ultimo=ultimo->prox;
    tmp=free;
}

void removerInicio(){
    primeiro->prox->ant=NULL;
    primeiro->prox->prox=NULL;
    primeiro->prox->prox->ant=NULL;
}