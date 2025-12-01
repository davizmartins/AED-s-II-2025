import java.util.Scanner;

public class Main {

    public static boolean ehLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static char paraMinusculo(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + ('a' - 'A'));
        }
        return c;
    }

    public static int comparaStrings(String a, String b) {
        int tamA = a.length();
        int tamB = b.length();
        int limite = tamA < tamB ? tamA : tamB;

        for (int i = 0; i < limite; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return tamA - tamB;
    }

    public static int adicionaPalavra(String palavra, String[] palavras, int qtd) {
        boolean existe = false;
        for (int i = 0; i < qtd; i++) {
            if (comparaStrings(palavras[i], palavra) == 0) {
                existe = true;
                break;
            }
        }
        if (!existe && qtd < 5000) {
            palavras[qtd] = palavra;
            qtd++;
        }
        return qtd;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] palavras = new String[5000];
        int qtdPalavras = 0;

        String palavraAtual = "";

        while (entrada.hasNextLine()) {
            String linha = entrada.nextLine();

            for (int i = 0; i < linha.length(); i++) {
                char c = linha.charAt(i);

                if (ehLetra(c)) {
                    palavraAtual = palavraAtual + paraMinusculo(c);
                } else {
                    if (palavraAtual.length() > 0) {
                        qtdPalavras = adicionaPalavra(palavraAtual, palavras, qtdPalavras);
                        palavraAtual = "";
                    }
                }
            }

            if (palavraAtual.length() > 0) {
                qtdPalavras = adicionaPalavra(palavraAtual, palavras, qtdPalavras);
                palavraAtual = "";
            }
        }

        for (int i = 0; i < qtdPalavras - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < qtdPalavras; j++) {
                if (comparaStrings(palavras[j], palavras[posMenor]) < 0) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                String aux = palavras[i];
                palavras[i] = palavras[posMenor];
                palavras[posMenor] = aux;
            }
        }

        for (int i = 0; i < qtdPalavras; i++) {
            System.out.println(palavras[i]);
        }

        entrada.close();
    }
}
