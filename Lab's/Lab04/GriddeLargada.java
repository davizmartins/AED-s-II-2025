//Aluno:Davi Martins; Matricula:885013
import java.util.*;

public class  GriddeLargada {

    public static Scanner ent = new Scanner(System.in);

    // Função que calcula a posição de cada carro da largada em relação à chegada
    // Complexidade: O(n^2) (dois laços aninhados)
    public static int[] posicionamento(int[] l, int[] c, int n) {
        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c[j] == l[i]) {
                    u[i] = j;
                    break; 
                }
            }
        }
        return u;
    }

    // Função que ordena o vetor u e conta o número de trocas realizadas
    // Cada troca equivale a uma ultrapassagem mínima
    // Complexidade: O(n^2) no pior caso 
    public static int ordenar(int[] u) {
        boolean troca = true;
        int tam = u.length;
        int temp, count = 0;
        for (int rep = 0; rep < tam && troca; rep++) {
            troca = false;
            for (int j = 0; j < tam - (rep + 1); j++) {
                if (u[j] > u[j + 1]) {
                    temp = u[j];
                    u[j] = u[j + 1];
                    u[j + 1] = temp;
                    troca = true;
                    count++;
                }
            }
        }
        return count;
    }

    // Programa principal
    // Complexidade total: O(n^2) + O(n^2) = O(n^2)
    public static void main(String[] args) {
        while (ent.hasNext()) {
            int n = ent.nextInt();
            int[] largada = new int[n];
            int[] chegada = new int[n];

            for (int i = 0; i < n; i++) {
                largada[i] = ent.nextInt();
            }

            for (int j = 0; j < n; j++) {
                chegada[j] = ent.nextInt();
            }

            int[] v = posicionamento(largada, chegada, n);
            System.out.println(ordenar(v));
        }
    }
}
