import java.util.*;

public class Main {

    static class No {
        char letra;
        No esquerda, direita;

        public No(char letra) {
            this(letra, null, null);
        }

        public No(char letra, No esquerda, No direita) {
            this.letra = letra;
            this.esquerda = esquerda;
            this.direita = direita;
        }
    }

    static class Arvore {
        No raiz;

        public Arvore() {
            this.raiz = null;
        }

        public void inserir(char valor) {
            this.raiz = inserirRec(valor, raiz);
        }

        private No inserirRec(char valor, No noAtual) {
            if (noAtual == null) {
                noAtual = new No(valor);
            } else if (valor < noAtual.letra) {
                noAtual.esquerda = inserirRec(valor, noAtual.esquerda);
            } else if (valor > noAtual.letra) {
                noAtual.direita = inserirRec(valor, noAtual.direita);
            } else {
                // já existe, não faz nada
            }
            return noAtual;
        }

        public void percursoCentral() {
            percursoCentral(raiz);
        }

        private void percursoCentral(No noAtual) {
            if (noAtual != null) {
                percursoCentral(noAtual.esquerda);
                System.out.print(noAtual.letra + " ");
                percursoCentral(noAtual.direita);
            }
        }

        public void percursoPre() {
            percursoPre(raiz);
        }

        private void percursoPre(No noAtual) {
            if (noAtual != null) {
                System.out.print(noAtual.letra + " ");
                percursoPre(noAtual.esquerda);
                percursoPre(noAtual.direita);
            }
        }

        public void percursoPos() {
            percursoPos(raiz);
        }

        private void percursoPos(No noAtual) {
            if (noAtual != null) {
                percursoPos(noAtual.esquerda);
                percursoPos(noAtual.direita);
                System.out.print(noAtual.letra + " ");
            }
        }

        public boolean buscar(char valor) {
            return buscarRec(valor, raiz);
        }

        private boolean buscarRec(char valor, No noAtual) {
            boolean achou;
            if (noAtual == null) {
                achou = false;
            } else if (valor == noAtual.letra) {
                achou = true;
            } else if (valor < noAtual.letra) {
                achou = buscarRec(valor, noAtual.esquerda);
            } else {
                achou = buscarRec(valor, noAtual.direita);
            }
            return achou;
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Arvore arvore = new Arvore();

        while (entrada.hasNextLine()) {

            String linha = entrada.nextLine();

            if (linha.length() == 0) continue;

            if (linha.charAt(0) == 'I' && linha.charAt(1) == ' ') {
                String[] partes = linha.split(" ");
                char letra = partes[1].charAt(0);
                arvore.inserir(letra);

            } else if (linha.charAt(0) == 'I' && linha.charAt(1) == 'N') {
                arvore.percursoCentral();
                System.out.println();

            } else if (linha.charAt(0) == 'P' && linha.charAt(1) == 'R') {
                arvore.percursoPre();
                System.out.println();

            } else if (linha.charAt(0) == 'P' && linha.charAt(1) == 'O') {
                arvore.percursoPos();
                System.out.println();

            } else {
                String[] partes = linha.split(" ");
                char letra = partes[1].charAt(0);
                boolean achou = arvore.buscar(letra);
                if (achou) {
                    System.out.println(letra + " existe");
                } else {
                    System.out.println(letra + " nao existe");
                }
            }
        }

        entrada.close();
    }
}
