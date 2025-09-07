import java.util.*;

public class espelho {
    public static int[] espelhar(int n, int f){
        int t = (n - f + 1);
        int[] v = new int[t];
        for(int i = 0; i < t; i++){
           v[i] = f + i; // Preenche do menor para o maior
        }
        return v;
    }
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int n, f;
        n = ent.nextInt();
        f = ent.nextInt();
        int t = (n - f + 1);
        int[] v = espelhar(n, f);
        for(int j = 0; j < t; j++){
            System.out.print(v[j]);
        }
        for(int k = t - 1; k >= 0; k--){
            System.out.print(v[k]);
        }
        System.out.print("\n");
        ent.close();
    }    
}
