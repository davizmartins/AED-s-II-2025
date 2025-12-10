
public class arvoreTrie {
    class NoT {
        public char letra;
        public NoT prox[];
        public int tam = 255;
        public boolean folha;

        public NoT(char c) {
            this.letra = c;
            this.folha = false;
            this.prox = new NoT[tam];
            for (int i = 0; i < tam; i++) {
                prox[i] = null;
            }
        }

        public int h(char c) {
            return (int) c;
        }
    }

    class arvoreT {
        public NoT raiz;

        public arvoreT() {
            this.raiz = new NoT(' ');
        }

        public void inserir(String s) {
            inserir(s, raiz, 0);
        }

        private void inserir(String s, NoT no, int i) {
            if (no.prox[s.charAt(i)] == null) {
                no.prox[s.charAt(i)] = new NoT(s.charAt(i));
                if (i == s.length() - 1) {
                    no.prox[s.charAt(i)].folha = true;
                } else if (i < s.length() - 1) {
                    inserir(s, no.prox[s.charAt(i)], i + 1);
                }
            } else {
                if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
                    inserir(s, no.prox[s.charAt(i)], i + 1);
                } else {
                    System.out.println("ERRO");
                }
            }
        }

        public void mostrar() {
            mostrar("", raiz);
        }

        private void mostrar(String s, NoT no) {
            if (no.folha == true) {
                System.out.println("Palavra: " + (s + no.letra));
            } else {
                for (int i = 0; i < no.prox.length; i++) {
                    if (no.prox[i] != null) {
                        mostrar(s + no.letra, no.prox[i]);
                    }
                }
            }
        }

        public boolean pesquisar(String s) {
            return pesquisar(s, raiz, 0);
        }

        private boolean pesquisar(String s, NoT no, int i) {
            boolean resp;
            if (no.prox[s.charAt(i)] == null) {
                resp = false;

            } else if (i == s.length() - 1 && no.prox[s.charAt(i)].folha == true) {
                resp = true;
            } else if (i < s.length() - 1) {
                resp= pesquisar(s, no.prox[s.charAt(i)], i + 1);
            } else {
                System.out.println("ERRO");
                return false;
            }
            return resp;
        }

    }
}
