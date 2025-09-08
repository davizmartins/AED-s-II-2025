import java.util.*;

public lab03{

	public static Scanner ent= new Scanner(System.in);

	public static int[] posicionamento(int[] l; int[] c; int n){
	    int[] u= new int[n];
	    int temp;	
		for(int i=0; i<n; i++){
			temp=l[i];
			for(int j=0; j<n; j++){
				if(c[j]==l[i]){
				   u[i]=j;
				}
			}	
		}
	    return u;
	}

	public static int[] ordenar(int[] u){
	    
	}

	public static void main(String[] args){
		int n, resp;
		int[] largada= new int[n];
		int[] chegada= new int[n];
		while(ent.hasNext()){
			n=ent.nextInt();
			for(int i=0; i<n; i++){
				largada[i]=ent.nextInt();
			}
			for(int j=0; j<n; j++){
				chegada[j]=ent.nextInt();
			}
			resp=ultrapassagem(largada, chegada, n);
			System.out.println(resp);	
		}
	}
}