import java.util.*;

class Vizinho{
    public String nome;
    public String[] vizinhos;
    public int[] distancia;
    public int n;


    public Vizinho(int qtd, String nm){
        nome= nm;
        vizinhos= new String[qtd];
        distancia= new int[qtd];
        n = 0;
    }

    public void inserirVizinho(String s, int km) throws Exception {
        if(n >= vizinhos.length || n>= distancia.length){
           throw new Exception("Erro ao inserir!");
        }
        
        vizinhos[n] = s;
        distancia[n]= km;
        n++;
    }

}



public class menordistancia{
    public static Scanner ent=new Scanner(System.in);
    public static void main(String[] args) {
        int linhas;
        int dist;
        int cd;
        String nm, dest;
        cd=ent.nextInt();
        linhas=ent.nextInt();
        Vizinho[] vizinhos= new Vizinho[cd];
        for(int i=0; i<cd; i++){
            nm=ent.next();
            vizinhos[i]=new Vizinho(cd,nm);
        }

        for(int i=0; i<linhas; i++){
            nm=ent.next();
            dest=ent.next();
            dist=ent.nextInt();

        }
    }
}