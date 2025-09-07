// Aluno : Davi Martins; Matricula:885013
import java.util.*;
public class CiframentoCesar {

    //Função para verificar se chegou a palavra de parada(FIM).
    public static boolean fim (String s) {
        if (s.length() != 3) return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Função que realiza o processo de ciframento do cesar.
    public static String ciframento(String str){
        int n= str.length();
        String v= "";
        char c;
        for(int i=0; i<n; i++){
            c = str.charAt(i);
            c+=3;
            v+=c;
        }
        return v;
    }

    public static void main(String[] args){
        Scanner ent =new Scanner(System.in);
        String str;
        str = ent.nextLine();
        while(!fim(str)){
            System.out.println(ciframento(str));
            str = ent.nextLine();
        }
        ent.close();
    }
}