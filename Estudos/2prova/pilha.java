class Celula{
    public int elemento;
    public Celula prox;

    public Celula(int x){
        this.elemento=x;
        this.prox=null;
    }
}
public class pilha{
    public Celula topo;

    public pilha(){
        topo=null;
    }

    public void push(int x){
        Celula tmp= new Celula(x);
        tmp.prox=topo;
        topo= tmp;
        tmp=null;        
    }

    public int pop() {
        if(topo==null){
            System.out.println("Erro");
            return -1;
        }
        Celula i= topo;
        int remov=topo.elemento;
        topo=topo.prox;
        i.prox=i=null;
        return remov;
    }

    public void mostrar(){
        Celula tmp=topo;
        System.out.print("[");
        while(tmp!=null){
            System.out.print(tmp.elemento+" ");
            tmp=tmp.prox;
        }
        System.out.println("]");
    } 

}
