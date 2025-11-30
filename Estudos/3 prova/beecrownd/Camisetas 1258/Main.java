import java.util.*;

public class Main {

    static class Camisa {
        public String cor;
        public String tamanho;
        public String nome;
        public int nCor;
        public int nTam;

        public Camisa(String cr, String nm, String c, int x, int y) {
            this.cor = cr;
            this.nome = nm;
            this.tamanho = c;
            this.nCor = x;
            this.nTam = y;
        }
    }

    public static int nmrCor(String cr) {
        if (cr.equals("vermelho")) {
            return 1;
        }
        return 0;
    }

    public static int nmrTam(String cr) {
        if (cr.equals("P")) {
            return 0;
        } else if (cr.equals("M")) {
            return 1;
        }
        return 2;
    }

    public static void printar(Camisa[] c, int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.println(c[i].cor + " " + c[i].tamanho + " " + c[i].nome);
        }
    }

    public static int comparaNome(String a, String b) {
        int n = Math.min(a.length(), b.length());

        for (int i = 0; i < n; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return a.length() - b.length();
    }

    public static int comparar(Camisa c1, Camisa c2) {
        if (c1.nCor != c2.nCor) {
            return c1.nCor - c2.nCor;
        } else if (c1.nTam != c2.nTam) {
            return c1.nTam - c2.nTam;
        }
        return comparaNome(c1.nome, c2.nome);
    }

    public static void ordenar(Camisa[] cms, int x) {
        for (int i = 0; i < x - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < x; j++) {
                if (comparar(cms[j], cms[menor]) < 0) {
                    menor = j;
                }
            }
            Camisa aux = cms[i];
            cms[i] = cms[menor];
            cms[menor] = aux;
        }
    }

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);
        int qtd = ent.nextInt();
        while (qtd != 0) {
            Camisa[] cms = new Camisa[1000];
            ent.nextLine();
            for (int aux = 0; aux < qtd; aux++) {
                String nome = ent.nextLine();
                String corTam = ent.nextLine();
                String[] partes = corTam.split(" ");
                int x, y;
                x = nmrCor(partes[0]);
                y = nmrTam(partes[1]);
                cms[aux] = new Camisa(partes[0], nome, partes[1], x, y);
            }
            ordenar(cms, qtd);
            printar(cms, qtd);
            System.out.println();
            qtd = ent.nextInt();
        }
        ent.close();
    }
}