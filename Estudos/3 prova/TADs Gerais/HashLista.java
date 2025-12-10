public class HashLista{
    class Celula{
        int elemento;
        Celula prox;

        public Celula(int x){
            this.elemento=x;
            this.prox=null;
        }
    }

    class Lista{
        Celula pri, ult;

        public Lista(){
            this.pri=this.ult=new Celula(-1);
        }

        public void inserir(int x){
            ult.prox=new Celula(x);
            ult=ult.prox;
        }
        
        public boolean pesquisar(int x){
            if(pri==ult) return false;
            Celula i=pri.prox;
            for(;i!=null; i=i.prox){
                if(i.elemento==x){
                    return true;
                }
            }
            return false;
        }
    }

    class hashLista{
        public int nulo=-1;
        public Lista tabela[];
        public int tam;

        public hashLista(int x){
            this.tam=x;
            this.tabela=new Lista[tam];
            for(int i=0; i<tam; i++){
                tabela[i].inserir(nulo);
            }
        }

        public int h(int x){
            return x%tam;
        }

        public boolean inserir(int x){
            boolean resp=false;
            if(x!=nulo){
                int p=h(x);
                tabela[p].inserir(x);
                resp=true;
            }
            return resp;
        }
        
        public boolean pesquisar(int x){
            int p=h(x);
            return tabela[p].pesquisar(x);
        }
    }
        
}