import java.util.*;

public class Main {

    static class Hash {
        int[] tabela;
        int padrao = -1;
        int tam;
        int soma; 

        public Hash(int x) {
            this.tam = x;
            this.tabela = new int[x];
            for (int i = 0; i < x; i++) {
                tabela[i] = padrao;
            }
            this.soma = 0;
        }

        private int h(int elemento) {
            return elemento % tam;
        }

        public void inserir(int elemento) {
            int pos = h(elemento);
            tabela[pos] = elemento; 
            soma += elemento;       
        }

        public int getSoma() {
            return soma;
        }
    }

    public static int obterValor(int linha, String str) {
        int valor = 0;
        for (int i = 0; i < str.length(); i++) {     
            int c = str.charAt(i) - 'A';             
            valor += linha + c + i;                  
        }
        return valor;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        int casos = ent.nextInt();

        while (casos > 0) {
            int qtdLinhas = ent.nextInt();
            ent.nextLine();

            Hash hs = new Hash(qtdLinhas);

            for (int i = 0; i < qtdLinhas; i++) {
                String entrada = ent.nextLine().trim();
                int valor = obterValor(i, entrada);
                hs.inserir(valor);
            }

            System.out.println(hs.getSoma());

            casos--;
        }

        ent.close();
    }
}
