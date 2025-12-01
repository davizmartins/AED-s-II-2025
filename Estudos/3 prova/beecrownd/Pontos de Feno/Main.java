import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int qtdPalavras = entrada.nextInt(); 
        int qtdDescricoes = entrada.nextInt(); 

        String[] dicionario = new String[qtdPalavras];
        int[] pontos = new int[qtdPalavras];

        for (int i = 0; i < qtdPalavras; i++) {
            dicionario[i] = entrada.next(); 
            pontos[i] = entrada.nextInt(); 
        }

        for (int i = 0; i < qtdDescricoes; i++) {
            int totalPontos = 0;

            while (true) {
                String palavra = entrada.next(); 
                if (palavra.equals(".")) {
                    break;
                }

                for (int j = 0; j < qtdPalavras; j++) {
                    if (dicionario[j].equals(palavra)) {
                        totalPontos += pontos[j];
                        break; 
                    }
                }
            }

            System.out.println(totalPontos);
        }

        entrada.close();
    }
}