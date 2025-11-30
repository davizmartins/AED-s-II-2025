// Davi Rafael de Oliveira Gurgel Martins - LAB03 - Sort! Sort!! Sort!!! 
import java.util.Scanner;

public class Sort {
    public static void swap(int[] array, int i, int j) { // Troca os valores entre duas posições do array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSort(int[] array, int m) { // Ordenação por seleção com regras customizadas
        for (int i = 0; i < array.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] % m < array[menor] % m) { // Prioriza menor resto da divisão por m
                    menor = j; 
                } else if (array[j] % m == array[menor] % m) {
                    if (array[j] % 2 != 0 && array[menor] % 2 == 0) { // Números ímpares vêm antes dos pares
                        menor = j;
                    } else if (array[j] % 2 != 0 && array[menor] % 2 != 0) { // Ambos ímpares: maior tem precedência
                        if (array[j] > array[menor]) {
                            menor = j;
                        }
                    } else if (array[j] % 2 == 0 && array[menor] % 2 == 0) { // Ambos pares: menor tem precedência
                        if (array[j] < array[menor]) {
                            menor = j;
                        }
                    }
                }
                swap(array, menor, i); 
            }
        }
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        int m, n;
        
        n = scanner.nextInt();
        m = scanner.nextInt();

        while (n != 0 && m != 0) { 

            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            selectionSort(array, m); 

            System.out.println(n + " " + m); // Imprime o cabeçalho com n e m
            
            for (int i = 0; i < n; i++) {
                System.out.println(array[i]);
            }

            n = scanner.nextInt();
            m = scanner.nextInt();
        }
        System.out.println("0 0");
        scanner.close();
    }
}