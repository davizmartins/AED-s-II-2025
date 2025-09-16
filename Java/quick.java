import java.util.*;

public class quick {
    public static int[] array = { 0, 1, 5, 3, 15, 16, 9, 10, 4, 3, 30, 5, 20, 48, 71, 82 };

    public static void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void quicksort(int esq, int dir) {
        int i = esq, j = dir, pivo = array[(esq + dir) / 2];
        System.out.println("Pivot escolhido: " + pivo);

        while (i <= j) {
            // Comparações lado esquerdo
            while (true) {
                System.out.println("cmp(" + array[i] + "," + pivo + ")");
                if (array[i] < pivo) {
                    i++;
                } else {
                    break;
                }
            }

            // Comparações lado direito
            while (true) {
                System.out.println("cmp(" + array[j] + "," + pivo + ")");
                if (array[j] > pivo) {
                    j--;
                } else {
                    break;
                }
            }

            // Swap quando i <= j
            if (i <= j) {
                if (i != j) {
                    System.out.println("swap(" + array[i] + "," + array[j] + ")");
                }
                swap(i, j);
                i++;
                j--;
            }
        }

        System.out.println("\n1 pontos(" +esq+ "," + j +")");

        if (esq < j) {
            quicksort(esq, j);
        }
        System.out.println("\n2 pontos(" + i + "," + dir + ")");

        if (i < dir) {
            quicksort(i, dir);
        }
    }

    public static void main(String[] args) {
        
        quicksort(0, array.length - 1);

        System.out.println("\nVetor final ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
