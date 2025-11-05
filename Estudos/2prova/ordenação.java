public class ordenação {
    public void swap(int[] v, int i, int j){
        int tmp= v[i];
        v[i]=v[j];
        v[j]=tmp;
    }

    public void insertion(int[] v){
        int tam=v.length;
        for(int i=1; i<tam;i++){
            int tmp=v[i];
            int j=i-1;
            while(j>=0 && tmp<v[j]){
                v[j+1]=v[j];
                j--;
            }
            v[j+1]=tmp;
        }
    }

    public void selection(int[] v){
        int tam=v.length;
        for(int i=0;i<tam;i++){
            int menor=i;
            for(int j=i+1; j<tam; j++){
                if(v[menor]>v[j]){
                    menor=j;
                }
            }
            swap(v, menor, i);
        }
    }

    public void bubble(int[] v) {
        boolean troca = true;
        int tam = v.length;

        for (int i = 0; i < tam - 1 && troca; i++) {
            troca = false;
            for (int j = 0; j < tam - i - 1; j++) {
                if (v[j] > v[j + 1]) {
                    swap(v, j, j + 1);
                    troca = true;
                }
            }
        }
    }

    public void quickSort(int[] v, int esq, int dir){
        int i=esq; int j=dir; int pivo=v[(i+j)/2];
        while(i<=j){
            while(v[i]<pivo){
                i++;
            }
            while(v[j]>pivo){
                j--;
            }
            if(i<=j){
                swap(v, i, j);
                i++;
                j--;
            }
        }
        if(j>esq){quickSort(v, esq, j);}
        if(i<dir){quickSort(v, i, dir);}
    }

    public void merge(int[] v){
        int tam =v.length;
        if(tam<2) return;
        int meio= tam/2;
        int[] parteDir= new int[tam-meio];
        int[] parteEsq= new int[meio];
        for(int i=0; i<meio; i++){
            parteEsq[i]= v[i];
        }
        for(int j=meio; j<tam; j++){
            parteDir[j-meio]=v[j];
        }
        
        merge(parteEsq);
        merge(parteDir);
        intercalar(v, parteEsq, parteDir);
    }

    public void intercalar(int[]v, int[]pE, int[]pD){
        int tamE=pE.length, tamD=pD.length;
        int i=0, j=0, k=0;

        while(i<tamE && j<tamD){
            if(pD[j]>pE[i]){
                v[k]=pE[i];
                k++; i++;
            }else{
                v[k]=pD[j];
                j++; k++;
            }
        }

        while(i<tamE){
            v[k]=pE[i];
            i++; k++;
        }
        while(j<tamD){
            v[k]=pD[j];
            k++; j++;
        }
    }

    public void heap(int[]v){
        int tam=v.length;
        for(int i=2;i<=tam;i++){
            construtor(v,i);
        }
        int n=tam;
        while(n>1){
            swap(v, n--, 1);
            reconstruir(v, n);
        }
    }
    public void construtor(int[]v, int n){
        for(int i=n; n>1 && v[i]>v[i/2]; i/=2){
            swap(v, i,i/2);
        }
    }
    public void reconstruir(int[]v, int n){
        int i=1;
        while(hasFilho(i, n)==true){
            int filho=getMaiorFilho(v,i,n);
            if(v[filho]>v[i]){
                swap(v, i, filho);
                i=filho;
            }else{
                i=n;
            }
        }
    }


    public boolean hasFilho( int i, int tam){
        if(i<=tam/2) return true;
        return false;
    }

    public int getMaiorFilho(int[]v, int i, int tam){
        if(i*2==tam || v[i*2]>v[i]){
            return i*2;
        }else{
            return 2*i+1;
        }
    }
        
}



    
