//Aluno: DAVI MARTINS; Matricula: 885013
import java.util.Scanner;

public class Algebraboolean {

    // funcao para lidar com as operação AND
    private static String eOp(String exp) {
        String res = "";

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'a'
                    && (exp.charAt(i + 4) == '1' || exp.charAt(i + 4) == '0')
                    && (exp.charAt(i + 6) == '1' || exp.charAt(i + 6) == '0')) {

                if (exp.charAt(i + 7) == ')') {
                    res += (exp.charAt(i + 4) == '1' && exp.charAt(i + 6) == '1') ? 1 : 0;
                    i += 7;
                } else if (exp.charAt(i + 9) == ')') {
                    res += (exp.charAt(i + 4) == '1' && exp.charAt(i + 6) == '1'
                            && exp.charAt(i + 8) == '1') ? 1 : 0;
                    i += 9;
                } else if (exp.charAt(i + 11) == ')') {
                    res += (exp.charAt(i + 4) == '1' && exp.charAt(i + 6) == '1'
                            && exp.charAt(i + 8) == '1' && exp.charAt(i + 10) == '1') ? 1 : 0;
                    i += 11;
                } else {
                    res += exp.charAt(i);
                }
            } else {
                res += exp.charAt(i);
            }
        }
        return res;
    }

    //funcao para lidar com as operação OR
    private static String ouOp(String exp) {
        String res = "";

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'o' && exp.charAt(i + 1) == 'r'
                    && (exp.charAt(i + 3) == '1' || exp.charAt(i + 3) == '0')
                    && (exp.charAt(i + 5) == '1' || exp.charAt(i + 5) == '0')) {

                if (exp.charAt(i + 6) == ')') {
                    res += (exp.charAt(i + 3) == '1' || exp.charAt(i + 5) == '1') ? 1 : 0;
                    i += 6;
                } else if (exp.charAt(i + 8) == ')') {
                    res += (exp.charAt(i + 3) == '1' || exp.charAt(i + 5) == '1'
                            || exp.charAt(i + 7) == '1') ? 1 : 0;
                    i += 8;
                } else if (exp.charAt(i + 10) == ')') {
                    res += (exp.charAt(i + 3) == '1' || exp.charAt(i + 5) == '1'
                            || exp.charAt(i + 7) == '1' || exp.charAt(i + 9) == '1') ? 1 : 0;
                    i += 10;
                }
            } else {
                res += exp.charAt(i);
            }
        }
        return res;
    }

    // funcao para lidar com as operação NOT
    private static String naoOp(String exp) {
        String res = "";

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'n' && (exp.charAt(i + 4) == '1' || exp.charAt(i + 4) == '0')) {
                res += (exp.charAt(i + 4) == '1') ? 0 : 1;
                i += 5;
            } else {
                res += exp.charAt(i);
            }
        }
        return res;
    }

    //funcao para lidar com as trocas A, B, C por valores
    private static String substVal(int[] vals, String exp) {
        String res = "";

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != ' ') {
                if (exp.charAt(i) == 'A') {
                    res += vals[0];
                } else if (exp.charAt(i) == 'B') {
                    res += vals[1];
                } else if (exp.charAt(i) == 'C') {
                    res += vals[2];
                } else {
                    res += exp.charAt(i);
                }
            }
        }
        return res;
    }

    // funcao que calcula expressão booleana
    private static String calcExp(String exp) {
        int qtdPar = 0;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                qtdPar++;
            }
        }

        char[] ordem = new char[qtdPar];

        for (int i = 0; i < exp.length() - 2; i++) {
            if (exp.charAt(i + 2) == 't') {
                ordem[--qtdPar] = 'n';
            } else if (exp.charAt(i + 2) == 'd') {
                ordem[--qtdPar] = 'e';
            } else if (exp.charAt(i + 1) == 'r') {
                ordem[--qtdPar] = 'o';
            }
        }

        for (int i = 0; i < ordem.length; i++) {
            if (ordem[i] == 'e') {
                exp = eOp(exp);
            } else if (ordem[i] == 'n') {
                exp = naoOp(exp);
            } else {
                exp = ouOp(exp);
            }
        }
        return exp;
    }

    // funcao para Fim do programa
    public static boolean acabou(int v) {
        return v == 0;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        int qtd = ent.nextInt();
        String exp;
        int[] vals = new int[3];

        while (!acabou(qtd)) {
            for (int i = 0; i < qtd; i++) {
                vals[i] = ent.nextInt();
            }

            exp = ent.nextLine();
            exp = substVal(vals, exp);
            exp = calcExp(exp);

            System.out.println(exp);

            qtd = ent.nextInt();
        }

        ent.close();
    }
}
