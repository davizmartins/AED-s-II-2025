//Aluno: Davi Martins; Matricula: 885013
import java.util.*;

public class somaDigitoRecursiva {

    //Esta funcao e a que realiza a a soma dos digitos ate o 'n' for menor que 10
    public static int sDr(int n, int r){
        if(n < 10){
            r+=n;
            return r;
        }
        int d=n%10;
        return sDr(n/10, r+=d);
        
    }

    //funcao principal que lê ate o ultimo inteiro
    public static void main(String[] args){
        Scanner ent= new Scanner(System.in);
        int n, r=0, s;
        
        while(ent.hasNextInt()){

            n=ent.nextInt();
            s= sDr(n, r);
            System.out.println(s);
        }
    
        ent.close();
    }

}