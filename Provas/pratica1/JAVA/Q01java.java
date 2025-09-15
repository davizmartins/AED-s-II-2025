import java.util.*;

public class Q01java{
    public static int n=0;
    public static void Push(int[] p, int v){
        if(n==p.length){
            System.out.println("EMPTY");
        }
        p[n]=v;
        n++;
    }
    public static void Min(int[] p, int menor){
        for(int i=0; i<n; i++){
            menor=p[i];
            for(int j=0; j<n; j++){
                if(menor>p[j]){
                    menor=p[j];
                }
            }
        }

        System.out.println(menor);
    }
    public static void POP(int[] p, int r){
        if(n==0){
            System.out.println("EMPTY");
        }
        r=p[n];
        n--;
    }
    public static void main(String[] args){
    	Scanner ent=new Scanner(System.in);
        int nopera, k=0, menor=0, valor, removido=0;
        int[] pilha=new int[106];
        String acao;
        nopera=ent.nextInt();
        while(k<nopera){
            acao=ent.next();
            if(acao.equals("PUSH")){
                valor=ent.nextInt();
                Push(pilha, valor);
            }else if(acao.equals("MIN")){
                Min(pilha, menor);
            }else if(acao.equals("POP")){
                POP(pilha, removido);
            }
            k++;
        }
    
        ent.close();
    }
}



