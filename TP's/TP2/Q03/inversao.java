//Aluno:DAVI MARTINS; Matricula:885013
import java.util.*;

public class inversao {
    //funcao verificadora para a palavra de saida
    public static boolean fim(String s) {
        if (s.length() != 3)
            return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
    //funcao que serve para inverter a string lida
    public static String inverter(String s, int n) {
        String f = "";
        char c;
        for (int i = n - 1; i >= 0; i--) {
            c = s.charAt(i);
            f += c;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        String s = "";
        s = ent.nextLine();
        int n = s.length();
        while (!fim(s)) {

            System.out.println(inverter(s, n));
            s = ent.nextLine();
            n = s.length();

        }
        ent.close();
    }
}