import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner ent=new Scanner (System.in);
        String p;


        p = ent.nextLine();

        while(!p.equals("FIM")){

            System.out.println(contador(p));
            p = ent.nextLine();
        }
    }

    public static int contador(String n) {
        int c=0;

        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) >= 'A' && n.charAt(i)<= 'Z') {
                c++;
            }
        }
        return c;
    }

}