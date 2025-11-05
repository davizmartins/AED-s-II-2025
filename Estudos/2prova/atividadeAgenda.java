


public class atividadeAgenda {
    
    public boolean pesquisar(String nome){
        char c=nome.charAt(0);
        return pesquisarRec(c, nome, raiz);
    }
    
    public boolean pesquisarRec(char c, String nome, No i){
        if(c==i.letra){
            return pesquisarNome(nome, i.arvoreNomes);
        }else if(c>i.letra){
            return pesquisarRec(c, nome, i.dir);
        }else if(c<i.letra){
            return pesquisarRec(c, nome, i.esq);
        }else{
            return false;
        }
    }

    public boolean pesquisarNome(String nome, NoNome a){
        while (a != null){
            int cmp = nome.compareTo(a.elemento); 
            if (cmp == 0) return true;
            a = (cmp < 0) ? a.esq : a.dir;
        }
        return false;
    }


    public void inserir(String nome){
        char c=nome.charAt(0);
        raiz =inserirRec(c, raiz, nome);
    }

    public No inserirRec(char c, No i, String nome){
        if(i==null){
            No n = new No(c);
            n.arvoreNomes = inserirNome(nome, null);
            return n;
        }
        if(c==i.letra){
            i.arvoreNomes=inserirNome(nome, i.arvoreNomes);
        }else if(c>i.letra){
            i.dir=inserirRec(c, i.dir, nome);
        }else{
            i.esq=inserirRec(c, i.esq, nome);
        }
        return i;
    }

    public void inserirNome(String nome, NoNomes i){
        if(i==null){
            i=new NoNomes(nome);
        }else if(i.elemento.compareTo(nome)<0){
            i.esq=inserirNome(nome, i.esq);
        }else if(i.elemento.compareTo(nome)>0){
            i.dir=inserirNome(nome, i.dir);
        }else{
            System.out.println("Erro");
        }
    }
}
