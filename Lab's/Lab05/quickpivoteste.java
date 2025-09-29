import java.util.*;
import java.util.Random;

public class quickpivoteste {
    public static Scanner ent = new Scanner(System.in);
    public static long movimentos = 0;
    public static long comparacoes = 0;

    public static void resetCounters() {
        movimentos = 0;
        comparacoes = 0;
    }

    public static void crescente(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        movimentos += 3; // cada troca = 3 atribuições
    }

    // ---------- QUICK SORTS ----------
    public static void quickSortFirst(int esq, int dir, int[] arr) {
        int i = esq, j = dir;
        int pivo = arr[esq];
        while (i <= j) {
            comparacoes++;
            while (arr[i] < pivo) {
                i++;
                comparacoes++;
            }
            comparacoes++;
            while (arr[j] > pivo) {
                j--;
                comparacoes++;
            }
            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        if (esq < j) quickSortFirst(esq, j, arr);
        if (i < dir) quickSortFirst(i, dir, arr);
    }

    public static void quickSortLast(int esq, int dir, int[] arr) {
        int i = esq, j = dir;
        int pivo = arr[dir];
        while (i <= j) {
            comparacoes++;
            while (arr[i] < pivo) {
                i++;
                comparacoes++;
            }
            comparacoes++;
            while (arr[j] > pivo) {
                j--;
                comparacoes++;
            }
            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        if (esq < j) quickSortLast(esq, j, arr);
        if (i < dir) quickSortLast(i, dir, arr);
    }

    public static void quickSortRandom(int esq, int dir, int[] arr) {
        int i = esq, j = dir;
        Random rando = new Random();
        int rand = rando.nextInt(dir - esq + 1) + esq;
        int pivo = arr[rand];
        while (i <= j) {
            comparacoes++;
            while (arr[i] < pivo) {
                i++;
                comparacoes++;
            }
            comparacoes++;
            while (arr[j] > pivo) {
                j--;
                comparacoes++;
            }
            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        if (esq < j) quickSortRandom(esq, j, arr);
        if (i < dir) quickSortRandom(i, dir, arr);
    }

    public static void quickSortMedianofThree(int esq, int dir, int[] arr) {
        int i = esq, j = dir;
        int pivo1 = arr[esq];
        int pivo2 = arr[(esq + dir) / 2];
        int pivo3 = arr[dir];
        int pivo;

        if ((pivo1 > pivo2 && pivo1 < pivo3) || (pivo1 > pivo3 && pivo1 < pivo2)) {
            pivo = pivo1;
        } else if ((pivo2 > pivo3 && pivo2 < pivo1) || (pivo2 > pivo1 && pivo2 < pivo3)) {
            pivo = pivo2;
        } else {
            pivo = pivo3;
        }

        while (i <= j) {
            comparacoes++;
            while (arr[i] < pivo) {
                i++;
                comparacoes++;
            }
            comparacoes++;
            while (arr[j] > pivo) {
                j--;
                comparacoes++;
            }
            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }
        if (esq < j) quickSortMedianofThree(esq, j, arr);
        if (i < dir) quickSortMedianofThree(i, dir, arr);
    }

    // ---------- TESTES ----------
    public static void runTest(String nome, int[] original, int tipo) {
        int[] arr = Arrays.copyOf(original, original.length);
        resetCounters();
        long start = System.nanoTime();

        switch (tipo) {
            case 1 -> quickSortFirst(0, arr.length - 1, arr);
            case 2 -> quickSortLast(0, arr.length - 1, arr);
            case 3 -> quickSortRandom(0, arr.length - 1, arr);
            case 4 -> quickSortMedianofThree(0, arr.length - 1, arr);
        }

        long end = System.nanoTime();
        System.out.printf("%-18s | %7d | %12d | %12d | %12d%n",
                nome, arr.length, (end - start), comparacoes, movimentos);
    }

    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000};
        Random rand = new Random();

        System.out.printf("%-18s | %7s | %12s | %12s | %12s%n",
                "Estratégia", "Tamanho", "Tempo(ns)", "Comparações", "Movimentos");
        System.out.println("-------------------------------------------------------------------------------");

        for (int n : tamanhos) {
            int[] base = new int[n];
            crescente(base);
            for (int i = 0; i < base.length; i++) {
                swap(i, rand.nextInt(base.length), base); // embaralha
            }

            runTest("Primeiro pivô", base, 1);
            runTest("Último pivô", base, 2);
            runTest("Pivô aleatório", base, 3);
            runTest("Mediana de três", base, 4);
        }
    }
}

