class Celula {
    public Celula prox, ant;
    public int elemento;

    public Celula() {
        this(0);
    }

    public Celula(int x) {
        this.elemento = x;
        this.ant = this.prox = null;
    }
}

public class listaDupla {
    public Celula primeiro, ultimo;

    public listaDupla() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int tamanho() {
        Celula i = primeiro.prox;
        int count = 0;
        while (i != null) {
            i = i.prox;
            count++;
        }
        return count;
    }

    public void inserirInicio(int x) {
        Celula c = new Celula(x);
        c.ant = primeiro;
        c.prox = primeiro.prox;
        if (primeiro == ultimo) {
            ultimo = c;
        } else {
            c.prox.ant = c;
        }
        primeiro.prox = c;
        c = null;
    }

    public void inserirFim(int x) {
        Celula c = new Celula(x);
        c.ant = ultimo;
        ultimo.prox = c;
        ultimo = c;
        c = null;
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            return -1;
        }
        Celula i = primeiro.prox;
        int remov = i.elemento;
        primeiro.prox = i.prox;

        if(i.prox!=null){
            primeiro.prox.ant = primeiro;
        }else{
            ultimo=primeiro;
        }

        i.prox = i.ant = i = null;
        return remov;
    }

    public int removerFim() {
        if (primeiro == ultimo) {
            System.out.println("Erro");
            return -1;
        }
        Celula i = ultimo;
        int tmp = i.elemento;
        ultimo = i.ant;
        ultimo.prox = null;
        i.ant = null;
        i.prox = null;

        return tmp;
    }

    public void inserir(int x, int pos) {
        int tam = tamanho();
        if (pos > tam || pos < 0) {
            System.out.println("Erro");
            return;
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tam) {
            inserirFim(x);
        } else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            Celula tmp = new Celula(x);
            tmp.ant = i;
            tmp.prox = i.prox;

            i.prox.ant = tmp;
            i.prox = tmp;
            tmp = i = null;
        }

    }

    public int remover(int pos) {
        int elemento, tamanho = tamanho();
        if (primeiro == ultimo) {
            System.out.println("erro");
            return -1;
        }
        else if (pos < 0 || pos >= tamanho) {
            System.out.println("erro");
            return -1;
        }
        else if (pos == 0) {
            elemento = removerInicio();
        }
        else if (pos == tamanho - 1) {
            elemento = removerFim();
        }
        else {
            // Caminha até a célula que será removida
            Celula i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox);

            // Faz o anterior apontar para o próximo do removido
            i.ant.prox = i.prox;
            // Faz o próximo apontar para o anterior do removido
            i.prox.ant = i.ant;

            elemento = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }
        return elemento; 
    }

    public void mostrar(){
        if(primeiro==ultimo){
            System.out.println("Vazia");
            return;
        }
        Celula i=primeiro.prox;
        
        System.out.println("[");

        while(i!=null){
            System.out.println(i.elemento+" ");
            i=i.prox;
        }
        System.out.println("]");

    }
}
