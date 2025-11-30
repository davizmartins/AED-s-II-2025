import java.util.*;

public class Main {

    static class Pacote {
        String texto; 
        int numero;   

        Pacote(String texto, int numero) {
            this.texto = texto;
            this.numero = numero;
        }
    }

    public static void ordenar(Pacote[] p, int n) {
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (p[j].numero < p[menor].numero) {
                    menor = j;
                }
            }
            Pacote aux = p[i];
            p[i] = p[menor];
            p[menor] = aux;
        }
    }

    public static void printar(Pacote[] p, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(p[i].texto);
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String inicio = sc.next();

            if (!inicio.equals("1")) {
                break;
            }

            Pacote[] pac = new Pacote[1000]; 
            int qtd = 0;

            while (sc.hasNext()) {
                String token = sc.next();

                if (token.equals("0")) {
                    break;
                }

                String numStr = sc.next(); 
                int num = Integer.parseInt(numStr);

                String linhaCompleta = token + " " + numStr; 
                pac[qtd++] = new Pacote(linhaCompleta, num);
            }

            ordenar(pac, qtd);
            printar(pac, qtd);
        }

        sc.close();
    }
}
