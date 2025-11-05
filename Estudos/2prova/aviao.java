import java.util.*;

class Celula {
    public String elemento;
    public Celula prox;

    public Celula(String e) {
        this.elemento = e;
        this.prox = null;
    }
}

class Fila{
    public Celula primeiro, ultimo;
    public Fila(){
        this.primeiro=new Celula("");
        this.ultimo=this.primeiro;
    }

    public void inserirFim(String e){
        Celula c= new Celula(e);
        ultimo.prox=c;
        ultimo=c;
        c=null;
    }

    public void mostrar(){
        Celula aux=primeiro.prox;
        while(aux!=null){
            System.out.print(aux.elemento+" ");
            aux=aux.prox;
        }
    }
}

public class aviao {
    public static void main(String[] args) {
        Scanner ent=new Scanner(System.in);
        String[] leste= new String[100];
        String[] oeste= new String[100];
        String[] sul= new String[100];
        String[] norte= new String[100];
        int n=ent.nextInt();
        int sl=0, nt=0, l=0, o=0;
        while(n!=0){
            if(n==-4){
                String s=ent.nextLine();
                leste[l]=s;
                l++;
            }else if(n==-3){
                String s=ent.nextLine();
                norte[nt]=s;
                nt++;
            }else if(n==-2){

            }else{

            }
                
        }
    }
}
