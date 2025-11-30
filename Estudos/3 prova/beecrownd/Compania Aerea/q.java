import java.util.*;

public class q {

    public static int comparaCodigos(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());

        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return s1.length() - s2.length();
    }

    static class Voo {
        public String codigo;
        public String origem;
        public String destino;
        public String data;
        public String hora;

        public Voo(String cd, String org, String dst, String dt, String hora) {
            this.codigo = cd;
            this.data = dt;
            this.hora = hora;
            this.origem = org;
            this.destino = dst;
        }
    }

    static class No {
        public Voo elemento;
        public No esq, dir;

        public No(Voo v) {
            this.elemento = v;
            this.dir = this.esq = null;
        }
    }

    static class ABP {
        public No raiz;

        public ABP() {
            this.raiz = null;
        }

        public void inserir(Voo x) {
            raiz = inserirRec(raiz, x);
        }

        public No inserirRec(No i, Voo x) {
            if (i == null) {
                return i = new No(x);
            }else if(comparaCodigos(i.elemento.codigo, x.codigo)>0){
                i.esq=inserirRec(i.esq, x);
            }else if(comparaCodigos(i.elemento.codigo, x.codigo)<0){
                i.dir=inserirRec(i.dir, x);
            }else{
                
            }
            return i;
        }

        public void caminharPos(No i){
            if(i!=null){
                caminharPos(i.esq);
                caminharPos(i.dir);
                System.out.println(i.elemento.codigo+" "+i.elemento.origem+" "+i.elemento.destino+" "+i.elemento.data+" "+i.elemento.hora);
            }
        }
    }

    public static void main(String []args){
        Scanner ent=new Scanner(System.in);
        ABP arvoreVoo= new ABP();
        String fim="FIM";
        String entrada=ent.nextLine();
        while (!entrada.equals(fim)) {
            entrada.trim();
            String [] partes= entrada.split(",");
            String cd=partes[0];
            String org=partes[1];
            String dest=partes[2];
            String data=partes[3];
            String hora=partes[4];
            
            Voo v= new Voo(cd, org, dest, data, hora);

            arvoreVoo.inserir(v);
            entrada=ent.nextLine();
        }

        arvoreVoo.caminharPos(arvoreVoo.raiz);
        ent.close();
    }

}