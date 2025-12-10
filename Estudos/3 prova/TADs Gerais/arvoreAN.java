
class arvoreAN {
    class No {
        public int elem;
        public No esq, dir;
        public boolean cor;

        public No(int x) {
            this.elem = x;
            this.cor = false;
            this.esq = this.dir = null;
        }
    }

    class arvore {
        public No raiz;

        public arvore() {
            this.raiz = null;
        }

        public void inserir(int x) {
            if (raiz == null) {
                raiz = new No(x);

            } else if (raiz.esq == null && raiz.dir == null) {
                if (x > raiz.elem) {
                    raiz.dir = new No(x);

                } else {
                    raiz.esq = new No(x);
                }
            } else if (raiz.esq == null) {
                if (raiz.elem > x) {
                    raiz.esq = new No(x);
                } else if (raiz.dir.elem > x) {
                    raiz.esq = new No(raiz.elem);
                    raiz.elem = x;
                } else {
                    raiz.esq = new No(raiz.elem);
                    raiz.elem = raiz.dir.elem;
                    raiz.dir.elem = x;
                }
                raiz.esq.cor = raiz.dir.cor = false;
            } else if (raiz.dir == null) {
                if (raiz.elem > x) {
                    raiz.dir = new No(x);
                } else if (raiz.esq.elem < x) {
                    raiz.dir = new No(raiz.elem);
                    raiz.elem = x;
                } else {
                    raiz.dir = new No(raiz.elem);
                    raiz.elem = raiz.esq.elem;
                    raiz.dir.elem = x;
                }
                raiz.esq.cor = raiz.dir.cor = false;
            } else {
                inserirRec(x, null, null, null, raiz);
            }
            raiz.cor = false;
        }

        public void inserirRec(int x, No bisavo, No avo, No pai, No i) {
            if (i == null) {
                if (x > pai.elem) {
                    i = pai.dir = new No(x);
                    i.cor = true;
                } else {
                    i = pai.esq = new No(x);
                    i.cor = true;
                }

                if (pai.cor = true) {
                    balancear(bisavo, avo, pai, i);
                }
            } else {
                if (i.esq != null && i.dir != null && i.dir.cor == true && i.esq.cor == true) {
                    i.cor = true;
                    i.esq.cor = i.dir.cor = false;
                    if (i == raiz) {
                        i.cor = false;
                    } else if (pai.cor == true) {
                        balancear(bisavo, avo, pai, i);
                    }
                }
                if (x > i.elem) {
                    inserirRec(x, avo, pai, i, i.dir);
                } else if (x < i.elem) {
                    inserirRec(x, avo, pai, i, i.esq);
                } else {
                    System.out.println("Erro");
                }
            }
        }

        public boolean pesquisar(int x) {
            return pesquisar(x, raiz);
        }

        public boolean pesquisar(int x, No i) {
            if (i == null) {
                return false;
            } else if (i.elem == x) {
                return true;
            } else if (i.elem > x) {
                return pesquisar(x, i.esq);
            } else {
                return pesquisar(x, i.dir);
            }
        }

        private No rotacaoDir(No no) {
            No noEsq = no.esq;
            No noEsqDir = noEsq.dir;

            noEsq.dir = no;
            no.esq = noEsqDir;

            return noEsq;
        }

        private No rotacaoEsq(No no) {
            No noDir = no.dir;
            No noDirEsq = noDir.esq;

            noDir.esq = no;
            no.dir = noDirEsq;
            return noDir;
        }

        private No rotacaoDirEsq(No no) {
            no.dir = rotacaoDir(no.dir);
            return rotacaoEsq(no);
        }

        private No rotacaoEsqDir(No no) {
            no.esq = rotacaoEsq(no.esq);
            return rotacaoDir(no);
        }

        public void balancear(No bisavo, No avo, No pai, No i) {
            if (pai.cor == true) {
                if (pai.elem > avo.elem) {
                    if (i.elem > pai.elem) {
                        avo = rotacaoEsq(avo);
                    } else {
                        avo = rotacaoDirEsq(avo);
                    }
                } else if (pai.elem < avo.elem) {
                    if (i.elem <pai.elem) {
                        avo = rotacaoDir(avo);
                    } else {
                        avo = rotacaoEsqDir(avo);
                    }
                }
                if (bisavo == null) {
                    raiz = avo;
                } else if (bisavo.elem > avo.elem) {
                    bisavo.esq = avo;
                } else {
                    bisavo.dir = avo;
                }
                avo.cor = false;
                avo.esq.cor = avo.dir.cor = true;
            }

        }
    }
}