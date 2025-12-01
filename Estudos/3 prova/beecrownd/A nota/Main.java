import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] freq = new int[100001]; 

        for (int i = 0; i < N; i++) {
            int nota = sc.nextInt();
            if (nota >= 0 && nota <= 100000) {
                freq[nota]++;
            }
        }

        long soma = 0;
        

        for (int nota = 100000; nota >= 0 && K > 0; nota--) {
            while (freq[nota] > 0 && K > 0) {
                soma += nota;
                freq[nota]--;
                K--;
            }
        }

        System.out.println(soma);
        sc.close();
    }
}