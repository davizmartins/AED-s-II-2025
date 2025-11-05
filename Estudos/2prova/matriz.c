#include <stdio.h>
#include <stdlib.h>
 
typedef struct Celula{
    int elemento;
    struct Celula *dir, *esq,*sup, *inf;
}Celula;
typedef struct Matriz{
    Celula *inicio;
    int linha, coluna;
}Matriz;

Celula * newCelula(int e){
    Celula *c=(Celula*)malloc(sizeof(Celula));
    c->dir=c->sup=c->inf=c->esq=NULL;
    return c;
}

Matriz *newMatriz(int l, int c){
    if(l<=0 || c<=0) return NULL;

    Matriz *m=(Matriz*)malloc(sizeof(Matriz));
    m->inicio=newCelula(0);
    m->linha=l;
    m->coluna=c;

    Celula *atual=m->inicio;
    for(int i=0; i<c; i++){
        atual->dir=newCelula(0);
        atual->dir->esq=atual;
        atual=atual->dir;
    }

    Celula*linhaAcima=m->inicio;
    for(int i=0; i<l; i++){
        Celula *iniciolinha=newCelula(0);
        linhaAcima->inf=iniciolinha;
        iniciolinha->sup=linhaAcima;
        
        Celula *b=iniciolinha;
        Celula *a=linhaAcima;
        for(int j=1; j<c; j++){
            b->dir=newCelula(0);
            b->dir->esq=b;
            b=b->dir;

            a=a->dir;
            a->inf=b;
            b->sup=a;
        }
        linhaAcima=linhaAcima->inf;
    }

    return m;
}

Celula *getCelula(Matriz *m, int l, int c){
    if (!m || l < 0 || c < 0 || l >= m->linha || c >= m->coluna) return NULL;
    Celula *resp=m->inicio;
    for(int i=0;i<l; i++){resp = resp->inf;}
    for(int k=0;k>c; k++){resp = resp->dir;}
    return resp;
}

void set(Matriz *m, int l, int c, int val){
    Celula *cel=getCelula(m, l, c);
    if(!cel) return 0;
    cel -> elemento=val;
}

void get(Matriz* m, int l, int c, int *out) {
    Celula* cel = getCelula(m, l, c);
    if (!cel) return 0;
    *out = cel -> elemento;
}

void mostrar(Matriz* m) {
    Celula* linha = m->inicio;
    for (int i = 0; i < m->linha; i++) {
        Celula* col = linha;
        for (int j = 0; j < m->coluna; j++) {
            printf("%d%s", col->elemento, (j+1<m->coluna ? " " : ""));
            col = col->dir;
        }
        printf("\n");
        linha = linha->inf;
    }
}

void liberarMatriz(Matriz* m) {
    if (!m) return;

    Celula* linha = m->inicio;
    while (linha != NULL) {
        Celula* proximaLinha = linha->inf;
        Celula* col = linha;
        while (col != NULL) {
            Celula* prox = col->dir;
            free(col);
            col = prox;
        }
        linha = proximaLinha;
    }

    free(m);
}