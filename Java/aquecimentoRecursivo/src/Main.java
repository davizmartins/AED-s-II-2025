import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner ent=new Scanner (System.in);
        String p;
        p = ent.nextLine();
        contador(p);
    }

    public static int contador(String n) {
        if(n.equals("FIM")){
            return 0;
        }
        Scanner ent=new Scanner (System.in);
        int c=0;

        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) >= 'A' && n.charAt(i)<= 'Z') {
                c++;
            }
        }
        System.out.println(c);
        n = ent.nextLine();
        return contador(n);
    }

}