//Aluno: Davi Martins; Matrícula: 885013
import java.util.*;
    public class Main{

    //Função para verificar se chegou na palavra de parada(FIM).
    public static boolean fim (String s) {
        if (s.length() != 3) return false;
        return (s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //função que verifica se a palavra é um palindromo.
    public static boolean palindromoTeste (String s){
        int n= s.length();
        int m=n;
        n--;
        int i=0;
        // o looping tem parada na metade da palavra pois a verificação ocorre das pontas ao meio.
        for(;i<m/2; i++){
            if(s.charAt(i)==s.charAt(n)){
               n--;
            }else{
              return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner ent =new Scanner(System.in);
        String str;
        //string de parada.
        boolean resp;
        str = ent.nextLine();
        //O looping ocorre até achar a palavra de parada.
        while(!fim(str)) {
            resp= palindromoTeste(str);
            if(resp){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            str = ent.nextLine();
        }
        ent.close();
    }
}