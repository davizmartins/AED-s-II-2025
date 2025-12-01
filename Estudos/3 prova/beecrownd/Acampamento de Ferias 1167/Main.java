import java.util.*;

public class Main {

    public static class Crianca {
        public String nome;
        public int valor;
        public int anterior;
        public int proxima;

        public Crianca(String nome, int valor) {
            this.nome = nome;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        while (ent.hasNextInt()) {
            int n = ent.nextInt();
            if (n == 0) {
                break;
            }

            Crianca[] v = new Crianca[n];

            for (int i = 0; i < n; i++) {
                String nome = ent.next();
                int valor = ent.nextInt();
                v[i] = new Crianca(nome, valor);
            }

            for (int i = 0; i < n; i++) {
                v[i].anterior = (i - 1 + n) % n;
                v[i].proxima = (i + 1) % n;
            }

            int indiceAtual = 0;
            int qtd = n;

            while (qtd > 1) {
                int valor = v[indiceAtual].valor;

                if (valor % 2 != 0) {
                    for (int j = 0; j < valor; j++) {
                        indiceAtual = v[indiceAtual].proxima;
                    }
                } else {
                    for (int j = 0; j < valor; j++) {
                        indiceAtual = v[indiceAtual].anterior;
                    }
                }

                int ant = v[indiceAtual].anterior;
                int prox = v[indiceAtual].proxima;
                v[ant].proxima = prox;
                v[prox].anterior = ant;
                qtd--;
            }

            indiceAtual = v[indiceAtual].proxima;
            System.out.println("Vencedor(a): " + v[indiceAtual].nome);
        }

        ent.close();
    }
}
