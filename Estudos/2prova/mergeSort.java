import java.util.*;

public class mergeSort {
    public static void mergeSort(int[] v) {
        int tam = v.length;

        if (tam < 2) {
            return;
        }

        int meio = tam / 2;
        int[] parteEsquerda = new int[meio];
        int[] parteDireita = new int[tam - meio];

        for (int i = 0; i < meio; i++) {
            parteEsquerda[i] = v[i];
        }
        for (int i = meio; i < tam; i++) {
            parteDireita[i - meio] = v[i];
        }

        mergeSort(parteEsquerda);
        mergeSort(parteDireita);

        intercalar(v, parteEsquerda, parteDireita);
    }

    public static void intercalar(int[] v, int[] parteEsquerda, int[] parteDireita) {
        int tamEsq = parteEsquerda.length;
        int tamDir = parteDireita.length;

        int i = 0, j = 0, k = 0;

        while (i < tamEsq && j < tamDir) {
            if (parteEsquerda[i] <= parteDireita[j]) {
                v[k] = parteEsquerda[i];
                i++;
            } else {
                v[k] = parteDireita[j];
                j++;
            }
            k++;
        }

        while (i < tamEsq) {
            v[k] = parteEsquerda[i];
            i++;
            k++;
        }

        while (j < tamDir) {
            v[k] = parteDireita[j];
            j++;
            k++;
        }

    }
}