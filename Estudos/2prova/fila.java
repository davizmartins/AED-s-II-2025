class Celula{
    public int elemento;
    public Celula prox;

    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.elemento=x;
        this.prox=null;
    }
}
public class fila {

    public Celula primeiro, ultimo;

    public fila(){
        Celula c = new Celula();
        primeiro=c;
        ultimo=primeiro;
    }

    public void inserirFim(int x){
        Celula c=new Celula(x);
        ultimo.prox=c;
        ultimo=c;
        c=null;
    }

    public int removerInicio(){
        if(primeiro==ultimo){
            System.out.println("Erro, Fila vazia.");
            return -1;
        }
        Celula aux=primeiro;
        int i = primeiro.prox.elemento;
        primeiro=primeiro.prox;
        aux=aux.prox=null;
        return i;
    }

    public void mostrar(){
        Celula i=primeiro.prox;
        System.out.print("[");
        while(i!=null){
            System.out.print(i.elemento+" ");
            i=i.prox;
        }
        System.out.println("]");
    }
}
