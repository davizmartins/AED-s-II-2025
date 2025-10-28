#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
    int elemento;
    struct Celula* esq;
    struct Celula* dir;
}Celula;

typedef struct ArvoreB{
    Celula  *raiz;
}ArvoreB;

Celula* novaCelula(int x){
    Celula *c = (Celula*) malloc(1*sizeof(Celula));
    c->elemento=x;
    c->esq= NULL;
    c->dir= NULL;
    return c;
}

ArvoreB* newArvore(){
    ArvoreB *a= (ArvoreB*)malloc(sizeof(ArvoreB));
    a->raiz=NULL;
    return a;
}

Celula* inserirRec(int x, Celula *c){
    if(c==NULL){
        c=novaCelula(x);
    }else if(x > c->elemento){
       c->dir= inserirRec(x,c->dir);
    }else{
        c->esq =inserirRec(x, c->esq);
    }
    return c;
}

void inserir(int x, ArvoreB* a){
    a->raiz=inserirRec(x,a->raiz);
}

void preordem(Celula* i){
    if(i != NULL){
        printf("%d ",i->elemento);
        preordem(i->esq);
        preordem(i->dir);
    }else{
        return;
    }
}

void imprimir(ArvoreB *a){
    preordem(a->raiz);
}

int main(){
    ArvoreB *a= newArvore();
    int v[6]={13, 2, 7, 8, 0, 90 };
    for(int i=0; i<7; i++){
        inserir(v[i], a);
    }
    imprimir(a);
}