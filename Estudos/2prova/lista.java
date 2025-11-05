
class ListaSimples {
    public Celula primeiro;
    public Celula ultimo;

    public ListaSimples() {
        Celula c = new Celula(0);
        primeiro = ultimo = c;
    }

    public int tamanho() {
        Celula i = primeiro;
        int cont = 0;
        for (; i != null; i = i.prox) {
            cont++;
        }
        return cont;
    }

    public void inserirInicio(int x) {
        Celula c = new Celula(x);
        c.prox = primeiro.prox;
        primeiro.prox = c;
        if(primeiro==ultimo) ultimo=c;
    }

    public void inserirFim(int x) {
        Celula c = new Celula(x);
        ultimo.prox = c;
        ultimo = c;

    }

    public void inserir(int x, int pos) throws Exception { // Inserir(6, 2)
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro");
        } else if (pos == 0) {
            inserirInicio(x);

        } else if (pos == tamanho) {
            inserirFim(x);
        } else {

            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public int removerFim() {
        if (ultimo == primeiro) {
            return 0;
        }
        Celula i = primeiro;
        for (; i.prox != ultimo; i = i.prox);
        int remov = ultimo.elemento;
        ultimo = i;
        i.prox = null;
        i = null;
        return remov;
    }

    public int removerInicio() {
        if (primeiro == ultimo) {
            System.out.println("erro");
            return 0;
        }
        Celula tmp=primeiro;
        primeiro = primeiro.prox;
        int remov = primeiro.elemento;
        tmp.prox=tmp=null;
        return remov;
    }

    public int remover(int pos) {
        int remov, tam = tamanho();
        if (primeiro == ultimo || pos < 0 || pos >= tam) {
            return -1;
        } else if (pos == 0) {
            remov = removerInicio();
        } else if (pos == tam - 1) {
            remov = removerFim();
        } else {
            Celula c = primeiro;
            for (int i = 0; i < pos; i++) {
                c = c.prox;
            }
            Celula tmp = c.prox;
            c.prox = c.prox.prox;
            remov = tmp.elemento;
            tmp.prox = c = tmp = null;
        }
        return remov;

    }

}

class Celula {

    public int elemento;
    public Celula prox;

    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

public class lista {

}
