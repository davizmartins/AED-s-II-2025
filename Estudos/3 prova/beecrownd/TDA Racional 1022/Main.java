import java.util.*;

public class Main {
    public static int mdc(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int resp = a % b;
            a = b;
            b = resp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int num = ent.nextInt();
        while (num > 0) {
            int N1, N2, D1, D2, nmr1, nmr2;
            char sinal;
            N1 = ent.nextInt();
            ent.next();
            D1 = ent.nextInt();
            sinal = ent.next().charAt(0);
            N2 = ent.nextInt();
            ent.next();
            D2 = ent.nextInt();
            if (sinal == '+') {
                nmr1 = (N1 * D2 + N2 * D1);
                nmr2 = (D1 * D2);
                int md = mdc(nmr1, nmr2);
                System.out.println(nmr1 + "/" + nmr2 + " = " + (nmr1 / md) + "/" + (nmr2 / md));

            } else if (sinal == '-') {
                nmr1 = (N1 * D2 - N2 * D1);
                nmr2 = (D1 * D2);
                int md = mdc(nmr1, nmr2);
                System.out.println(nmr1 + "/" + nmr2 + " = " + (nmr1 / md) + "/" + (nmr2 / md));
            } else if (sinal == '*') {
                nmr1 = (N1 * N2);
                nmr2 = (D1 * D2);
                int md = mdc(nmr1, nmr2);
                System.out.println(nmr1 + "/" + nmr2 + " = " + (nmr1 / md) + "/" + (nmr2 / md));

            } else {
                nmr1 = (N1 * D2);
                nmr2 = (N2 * D1);
                int md = mdc(nmr1, nmr2);
                System.out.println(nmr1 + "/" + nmr2 + " = " + (nmr1 / md) + "/" + (nmr2 / md));

            }
            num--;
        }
        ent.close();
    }
}
