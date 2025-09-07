//Aluno: Davi Martins Matricula: 885013
import java.util.*;

public class Main{

    static Random gerador = new Random(4);

    //Função que verifica a condição de parada "FIM"
    public static boolean fim(String s) {
        if (s.length() != 3) return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // Função para alterar a linha de entrada
    public static String alterar(String s) {
        String r = "";

        // sorteia duas letras minúsculas
        char x = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        char y = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

        // Substitui todas as ocorrências da primeira letra sorteada pela segunda letra sorteada
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == x) {
                r += y;
            } else {
                r += c;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        String str = ent.nextLine();

        while (!fim(str)) {
            System.out.println(alterar(str));
            str = ent.nextLine();
        }

        ent.close();
    }
}
