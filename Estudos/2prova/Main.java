import java.io.IOException;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {
        class Celula{
            public Celula dir, esq, sup, inf;
            public int elemento;
            public Celula(int e){
                this.esq=this.dir=this.sup=this.inf=null;
                this.elemento=e;
            }
        }
        class Matriz{
            public Celula inicio;
            public int linha, coluna;
            public Matriz(int l, int c){
                if(l==0 || c==0){System.out.println("Erro!");
                    
                }else{
                    this.linha=l;
                    this.coluna=c;
                    this.inicio=new Celula(1);
                    Celula atual=inicio;
                    int valor=2;
                    for(int i=1; i<c; i++){
                        atual.dir=new Celula(valor++);
                        atual.dir.esq=atual;
                        atual=atual.dir;    
                    }
                    Celula acima=inicio;
                    for(int j=1; j<l; j++){
                        Celula inicioLinha= new Celula(valor++);
                        acima.inf=inicioLinha;
                        inicioLinha.sup=acima;
                    
                        Celula a=acima, b=inicioLinha;
                        for(int i=1; i<c;i++){
                            b.dir=new Celula(valor++);
                            b.dir.esq=b;
                            b=b.dir;
                        
                            a=a.dir;
                            a.inf=b;
                            b.sup=a;
                        }
                        acima=acima.inf;
                    }
                }
            }
            public void caminhasDuke(int l, int c){
                Celula cel=inicio;
                for(int i=0; i<l-1; i++){
                    cel=cel.inf;
                }
                for(int j=0; j<c-1; j++){
                    cel=cel.dir;
                }
            }
 
         }
        
}
