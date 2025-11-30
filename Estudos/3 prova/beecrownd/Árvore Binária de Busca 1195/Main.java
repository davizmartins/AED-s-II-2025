import java.util.*;

class No{
    public int elemento;
    public No esq, dir;

    public No(int x){
        this.elemento=x;
        this.dir=this.esq=null;
    }
}

class ABB{
    public No raiz;

    public ABB(){
        this.raiz=null;
    }

    public void inserir(int x ){
        raiz=inserirRec(raiz, x);
    }

    public No inserirRec(No i, int x){
        if(i==null){
            i=new No(x);
        }else if(i.elemento>x){
            i.esq=inserirRec(i.esq, x);
        }else if(i.elemento<x){
            i.dir=inserirRec(i.dir, x);
        }else{

        }
        return i;
    }

    public void caminharPre(No i){
        if(i!=null){

            System.out.print(i.elemento+" ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    
    public void caminharCentral(No i){
        if(i!=null){
            caminharCentral(i.esq);
            System.out.print(i.elemento+" ");
            caminharCentral(i.dir);
        }
    }

    public void caminharPos(No i){
        if(i!=null){

            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.print(i.elemento+" ");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner ent=new Scanner(System.in);
        int casos=ent.nextInt();
        int aux=casos;
        int x=1;
        while(aux>0){
            ABB arvore=new ABB();
            int qtd=ent.nextInt();
            while(qtd>0){
                int valor=ent.nextInt();
                arvore.inserir(valor);
                qtd--;
            }
            System.out.println("Case "+x+":");
            System.out.print("Pre.: ");
            arvore.caminharPre(arvore.raiz);
            System.out.println();
            System.out.print("In..: ");
            arvore.caminharCentral(arvore.raiz);
            System.out.println();
            System.out.print("Post: ");
            arvore.caminharPos(arvore.raiz);
            System.out.println();
            System.out.println();
            aux--;
            x++;
        }
        ent.close();
    }
}
