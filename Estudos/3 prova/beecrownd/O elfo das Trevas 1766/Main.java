import java.util.*;

public class Main {

    public static class Rena {
        public String nome;
        public int peso;
        public int idade;
        public double altura;

        public Rena(String nome, int peso, int idade, double altura) {
            this.nome = nome;
            this.peso = peso;
            this.idade = idade;
            this.altura = altura;
        }
    }

    public static int comparaNome(String a, String b) {
        int tamA = a.length();
        int tamB = b.length();
        int limite = (tamA < tamB) ? tamA : tamB;

        for (int i = 0; i < limite; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return tamA - tamB;
    }

    public static int comparar(Rena r1, Rena r2) {
        if (r1.peso != r2.peso) {
            return r2.peso - r1.peso; // peso decrescente
        }
        if (r1.idade != r2.idade) {
            return r1.idade - r2.idade; // idade crescente
        }
        if (r1.altura < r2.altura) {
            return -1;
        } else if (r1.altura > r2.altura) {
            return 1;
        }
        return comparaNome(r1.nome, r2.nome); // nome crescente
    }

    public static void ordenar(Rena[] v, int n) {
        for (int i = 0; i < n - 1; i++) {
            int melhor = i;
            for (int j = i + 1; j < n; j++) {
                if (comparar(v[j], v[melhor]) < 0) {
                    melhor = j;
                }
            }
            if (melhor != i) {
                Rena aux = v[i];
                v[i] = v[melhor];
                v[melhor] = aux;
            }
        }
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        int T = ent.nextInt();
        for (int caso = 1; caso <= T; caso++) {
            int N = ent.nextInt();
            int M = ent.nextInt();

            Rena[] renas = new Rena[N];

            for (int i = 0; i < N; i++) {
                String nome = ent.next();
                int peso = ent.nextInt();
                int idade = ent.nextInt();
                double altura = ent.nextDouble();
                renas[i] = new Rena(nome, peso, idade, altura);
            }

            ordenar(renas, N);

            System.out.println("CENARIO {" + caso + "}");
            for (int i = 0; i < M; i++) {
                System.out.println((i + 1) + " - " + renas[i].nome);
            }
        }

        ent.close();
    }
}
