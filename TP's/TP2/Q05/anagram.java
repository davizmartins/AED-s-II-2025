//Aluno: Davi Martins Matricula:885013
import java.util.*;

public class anagram {
    // A função verifica se chegou ao fim das execuções
    public static boolean fim(String s) {
        if (s.length() != 3) return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // Função que transforma tudo em maiúsculo manualmente
    public static String maiuscula(String str) {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }
            r += c;
        }
        return r;
    }

    // Função para ordenar a string usando um algoritmo de ordenação manual (Bubble Sort)
    public static String ordenar(String str) {
        char[] arr = new char[str.length()];

        // Copia os caracteres da string para o array
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        // Ordena o array
        for (int rep = 0; rep < arr.length - 1; rep++) {
            for (int i = 0; i < arr.length - (rep + 1); i++) {
                if (arr[i] > arr[i + 1]) {
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        
        // Constrói a nova string a partir do array ordenado
        String resultado = "";
        for (int i = 0; i < arr.length; i++) {
            resultado += arr[i];
        }
        return resultado;
    }

    // Função que verifica se as palavras são anagramas (comparando as strings ordenadas)
    public static boolean verificador(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        String str = ent.next();
        
        while (!fim(str)) {
            // Ignora o separador -
            ent.next();
            String str2 = ent.next();

            str = maiuscula(str);
            str2 = maiuscula(str2);

            str = ordenar(str);
            str2 = ordenar(str2);

            if (verificador(str, str2)) {
                System.out.println("SIM");
            } else {
                System.out.println("N\u00C3O");
            }

            if (ent.hasNext()) {
                str = ent.next();
            } else {
                break;
            }
        }
        ent.close();
    }
}