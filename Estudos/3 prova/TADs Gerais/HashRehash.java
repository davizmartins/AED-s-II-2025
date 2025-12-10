
public class HashRehash{
    class hashR{
        public int tam;
        public int[] tabela;
        final public int nulo=-1;

        public hashR(int x){
            this.tam=x;
            this.tabela=new int [x];
            for(int i=0; i<tam; i++){
                tabela[i]=nulo;
            }
        }

        public int h(int x){
            return x%tam;
        }

        public int rh(int x){
            return ++x%tam;
        }

        public boolean inserir(int x){
            boolean resp=false;
            if(x!=nulo){
                int p=h(x);
                int r=rh(x);
                if(tabela[p]==nulo){
                    tabela[p]=x;
                    resp=true;
                }else if(tabela[r]==nulo){
                    tabela[r]=x;
                    resp=true;
                }
            }
            return resp;
        }

        public boolean pesquisar(int x){
            boolean resp=false;
            int p=h(x);
            int r=rh(x);
            if(tabela[p]==x){
                resp=true;
            }else if(tabela[p]!=nulo){
                if(tabela[r]==x){
                    resp=true;
                }
            }
            return resp;
        }

    }
}
