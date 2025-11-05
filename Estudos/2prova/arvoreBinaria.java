class No{
    public No esq, dir;
    public int elemento;
    
    public No(int x){
        this(x, null, null);
    }

    public No(int x, No esq, No dir){
        this.elemento=x;
        this.esq=esq;
        this.dir=dir;
    }
}

class Arvore{
    public No raiz;

    public Arvore(){
        this.raiz=null;
    }

    public void inserir(int x){
        raiz=inserirRec(x,raiz);
    }

    public No inserirRec(int x, No i){
        if(i==null){
            i=new No(x);
        }else if(i.elemento>x){
            i.esq=inserirRec(x, i.esq);
        }else if(i.elemento<x){
            i.dir=inserirRec(x, i.dir);
        }else{
            System.out.println("Erro");
        }
        return i;
    }

    public void inserirPai(int x){
        if(raiz==null){
            raiz=new No(x);
        }else if(x<raiz.elemento){
            inserirPaiRec(x,raiz.esq, raiz);
        }else if(x>raiz.elemento){
            inserirPaiRec(x,raiz.dir, raiz);
        }else{
            System.out.println("Erro");
        }
    }
    
    public void inserirPaiRec(int x, No i, No pai){
        if(i==null){
            if(x>pai.elemento){
                pai.dir=new No(x);
            }else if(x<pai.elemento){
                pai.esq=new No(x);
            }
        }else if(i.elemento<x){
            inserirPaiRec(x, i.dir, i);
        }else if(i.elemento>x){
            inserirPaiRec(x, i.esq, i);
        }else{
            System.out.println("Erro");
        }
    }

    public boolean pesquisar(int x){
       return pesquisar(x,this.raiz);
    }

    public boolean pesquisar(int x, No i){
        boolean resp= false;
        if(i==null){
            resp= false;
        }else if(i.elemento==x){
            resp= true;
        }else if(x<i.elemento){
            resp= pesquisar(x, i.esq);
        }else{
            resp= pesquisar(x, i.dir);
        }
        return resp;
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

    public void caminharPre(No i){
        if(i!=null){
            System.out.print(i.elemento+" ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void caminharCentralDecrescente(No i){
        if(i!=null){
            caminharCentralDecrescente(i.dir);
            System.out.print(i.elemento+" ");
            caminharCentralDecrescente(i.esq);
        }
    }

    public void remover(int x){
       raiz= removerRec(x, raiz);
    }

    public No removerRec(int x, No i){
        if(i==null){
            return null;
        }else if(x<i.elemento){
            i.esq=removerRec(x, i.esq);
        }else if(x>i.elemento){
           i.dir=removerRec(x, i.dir);
        }else if(i.dir==null){
            i=i.esq;
        }else if(i.esq==null){
            i=i.dir;
        }else{
            i.esq=maiorEsquerda(i,i.esq);
        }
        return i;
    }

    public No maiorEsquerda(No i, No j){
        if(j.dir==null){
            i.elemento=j.elemento;
            j=j.esq;
        }else{
            j.dir=maiorEsquerda(i, j.dir);
        }
        return j;
    }

    public int getMaior(){
        return getMaiorRec(this.raiz);
    }

    public int getMaiorRec(No i){
        if(i.dir==null){
            return i.elemento;
        }else{
            return getMaiorRec(i.dir);
        }
    }

    public int altura(){
        return alturaRec(raiz);
    }
    public int alturaRec(No i){
        if(i==null){return -1;}
        int a=0, b=0;
        No e=i.esq, d=i.dir;
        while(e.esq!=null){
            e=e.esq;
            a++;
        }
        while(d.dir!=null){
            d=d.dir;
            b++;
        }
        int altura=(a>b)? a:b;
        if(a==b){
            return a;
        }else{
            return altura;
        }
    }

    public int somar(){
        return somarR(raiz);
    }

    public int somarR(No i){
        if(i==null){
            return 0;
        }
        return i.elemento+ somarR(i.esq) + somarR(i.dir);
    }

    public int pares(){
        return paresR(raiz);
    }

    public int paresR(No i){
        if(i!=null){
            if(i.elemento % 2==0){
                return 1+ paresR(i.dir)+paresR(i.esq);
            }else{
                return 0+paresR(i.dir)+paresR(i.esq);
            }
        }
        return 0;
    }
    
    public boolean div(){
        return div11(raiz);
    }

    public boolean div11(No i){
        boolean resp;
        if(i==null){
            resp=false;
        }else if(i.elemento %11==0){
            resp=true;

        }else{
            resp= div11(i.esq) || div11(i.dir);
        }
        return resp;
    }

}



public class arvoreBinaria {
    
}
