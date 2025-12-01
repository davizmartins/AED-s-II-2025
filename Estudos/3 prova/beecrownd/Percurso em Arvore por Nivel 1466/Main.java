import java.util.Scanner;

class No {
    int valor;
    No esq, dir;

    public No(int v) {
        this.valor = v;
        this.esq = null;
        this.dir = null;
    }
}

class Arvore {
    No raiz;

    public Arvore() {
        raiz = null;
    }

    public void inserir(int x) {
        raiz = inserirRec(raiz, x);
    }

    private No inserirRec(No i, int x) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.valor) {
            i.esq = inserirRec(i.esq, x);
        } else if (x > i.valor) {
            i.dir = inserirRec(i.dir, x);
        }
        return i;
    }

    public void percursoNivel() {
        if (raiz == null) {
            System.out.println();
            return;
        }

        No[] fila = new No[600]; 
        int inicio = 0;
        int fim = 0;

        fila[fim++] = raiz;

        boolean primeiro = true;

        while (inicio < fim) {
            No atual = fila[inicio++];

            if (!primeiro) {
                System.out.print(" ");
            }
            System.out.print(atual.valor);
            primeiro = false;

            if (atual.esq != null) {
                fila[fim++] = atual.esq;
            }
            if (atual.dir != null) {
                fila[fim++] = atual.dir;
            }
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        int casos = ent.nextInt();

        for (int c = 1; c <= casos; c++) {
            int n = ent.nextInt();

            Arvore arvore = new Arvore();

            for (int i = 0; i < n; i++) {
                int x = ent.nextInt();
                arvore.inserir(x);
            }

            System.out.println("Case " + c + ":");
            arvore.percursoNivel();
            System.out.println();
        }

        ent.close();
    }
}
