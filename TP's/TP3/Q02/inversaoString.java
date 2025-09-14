//Aluno: Davi Martins; Matricula: 885013
import java.util.*;

public class inversaoString {
    //funcao verificadora para a palavra de saida
    public static boolean fim(String s) {
        if (s.length() != 3)
            return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    //função que adiciona os caracteres de tras pra fremte e concatena a uma nova string
    public static String inversorRecursivo(String s, int i, String r){
        if(i==0){
            r+=s.charAt(i);
            r+='\0';
            return r;
        }
        char c;
        c=s.charAt(i);
        r+=c;
        return inversorRecursivo(s, --i, r);
    }
    public static void main(String[] args){
        Scanner ent= new Scanner(System.in);
        String str= "";
        String r="";
        int i=0;
        str=ent.nextLine();
        while(!(fim(str))){
            i=str.length()-1;
            r=inversorRecursivo(str, i, r);
            System.out.println(r);
            r="";
            str=ent.nextLine();
        }
        ent.close();
    }
}