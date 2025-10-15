import java.util.*;

class Celula{
    public int elemento;
    public Celula prox;
    
    public Celula(){
        this(0);
    }

    public Celula(int e){
        this.elemento=e;
        this.prox=null;
    }
}

class Lista{
    public Celula primeiro;
    public Celula ultimo;
    public int tam=0;

    public Lista(){
        primeiro=ultimo= new Celula();
    }

    public void inserirFim(int x){
        Celula tmp= new Celula(x);
        ultimo.prox=tmp;
        ultimo=tmp;
        tmp.prox=null;
        tmp=null;
        tam++;
    }

    public void mostrar(){
        Celula aux=primeiro;
        while(aux!=null){
            System.out.print(aux.elemento+" ");
            aux=aux.prox;
        }
        System.out.println("");
    }

    public void Metodo(){
        Celula k=primeiro.prox;
        while(k!=null){
            int num=k.elemento;
            if(k.elemento % 2==0){
                num/=2;
                Celula tmp=new Celula(num);
                tmp.prox=k.prox;
                k.prox=tmp;
                tmp=null;
            }
            k=k.prox;
        }
    }
}

public class exercicio{
    public static int[] vet={4,3,2,74};
    public static void main(String args[]) {
        Lista lista = new Lista();
        for(int i=0; i<4; i++){
            lista.inserirFim(vet[i]);
        }
        lista.mostrar();

        lista.Metodo();
        lista.mostrar();
    }
}