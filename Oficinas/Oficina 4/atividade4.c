#include <stdio.h>
#include <stdlib.h>

typedef struct Celula{
    struct Celula * prox;
    char *nome;
}Celula;

Celula  *newCelula(char *nm){
    Celula *c = (Celula*) malloc(sizeof(Celula));
    c->prox=NULL;
    c->nome = nm;
    return c;
}

typedef struct lista{
    Celula *primeiro, *ultimo;
}lista;

lista *newLista(){
    lista *l=(lista*)malloc(sizeof(lista));
    l->primeiro=l->ultimo=NULL;
    return l;
}

void inserirLista(char *nm, lista *pl){
    Celula *nova=newCelula(nm);
    if(pl->primeiro==NULL){
        pl->primeiro=nova;
        pl->ultimo=nova;
    }else{
        pl->ultimo->prox=nova;
        pl->ultimo=nova;
    }
    //implementar insercao na lista
    // Celula* nova = newCelula(nm);
    // nova->prox = pl->ultimo
    // pl->ultimo = nova
}

typedef struct No{
    struct No* esq, * dir;
    int dd;
    lista* pl;
}No; 

No* newNo(int num){
    No *no=(No*)malloc(sizeof(No));
    no->dd=num;
    no->esq=no->dir=NULL;
    no->pl=newLista();
    return no;
}

typedef struct Arvore{
    struct No* raiz;
}Arvore;

Arvore* newArvore(){
    Arvore *a=(Arvore*)malloc(sizeof(Arvore));
    a->raiz=NULL;
    return a;
}

void inserirRecNo(char *nm, int num, No* no){
    if(no->dd == num){
        inserirLista(nm, no->pl);
        //inserir nm na lista no->pl
    }else if(no->dd>num){
        inserirRecNo(nm, num, no->esq);
    }else{
        inserirRecNo(nm, num, no->dir);
    }
}

void inserirNo(char *nm, int num, Arvore *a){
    inserirRecNo(nm, num, a->raiz);
}

No* inserirRecArvore(int x, No *no){
    if(no==NULL){
        no=newNo(x);
    }else if(x>no->dd){
        no->dir =inserirRecArvore(x,no->dir);
    }else if(x<no->dd){
        no->esq=inserirRecArvore(x, no->esq);
    }
    return no;
}

void inserirArvore(int x, Arvore *a){
    inserirRecArvore(x, a->raiz);
}


int main(){
    Arvore *a= newArvore();

}
