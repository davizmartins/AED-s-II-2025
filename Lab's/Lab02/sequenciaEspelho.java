//Aluno:Davi Martins; Matricula:885013
import java.util.*;

public class sequenciaEspelho{
	
    public static Scanner ent = new Scanner(System.in);    
	//funcao que faz a sequencia do numero inicial ao numero final
    public static String sequenciar(int num, int limite, String sequencia){
		if(num==1+limite){
	    	return sequencia;
		}else{
			sequencia+=num;
    		return sequenciar(num+1, limite, sequencia);
    	}
    }

    public static void main(String[] args){
		int num, lim;
		String sequencia="";
		String r="";
		while (ent.hasNextInt()) {
			num =ent.nextInt();
			lim=ent.nextInt();
			r=sequenciar(num, lim, sequencia);
			System.out.print(r);
		
			for(int i=r.length()-1;i>=0;i--){
				if(i==0){
					System.out.println(r.charAt(i));
				}else{
					System.out.print(r.charAt(i));
				}
			}
			r="";
			sequencia="";
		}
    }
}

