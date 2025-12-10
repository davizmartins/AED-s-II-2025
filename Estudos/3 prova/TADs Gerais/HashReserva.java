
public class HashReserva {

    class hash{
        public int[] tabela;
        public int tam1,tam2, tam, reserva;
        final int nulo=-1;

        public hash(int x, int y){
            this.tam1=x;
            this.tam2=y;
            this.reserva=0;
            this.tam=tam1+tam2;
            this.tabela= new int[tam];
            for(int i=0; i<tam; i++){
                tabela[i]=nulo;
            }
        }

        public int h(int x){
            return x%tam;
        }

        public boolean inserir(int x){
            boolean resp=false;
            if(x!=nulo){
                int p=h(x);
                if(tabela[p]==nulo){
                    tabela[p]=x;
                    resp=true;
                }else if(reserva>tam2){
                    tabela[tam2+reserva]=x;
                    reserva++;
                    resp=true;
                }
            }
            return resp;
        }

        public boolean pesquisar(int x){
            boolean resp=false;
            int p=h(x);
            if(tabela[p]==x){
                resp=true;
            }else if(tabela[p]!=nulo){
                for(int i=0;i<reserva;i++){
                    if(tabela[i+tam2]==x){
                        resp=true;
                        i=reserva;
                    }
                }
            }
            return resp;
        }
    }
    
}
