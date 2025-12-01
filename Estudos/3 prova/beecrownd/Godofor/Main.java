

import java.util.*;

public class Main {

    public static boolean ehMelhor(String nomeNovo, int nivelNovo, int deusNovo, int mortesNovo,
                                    String nomeMelhor, int nivelMelhor, int deusMelhor, int mortesMelhor) {

        if (nivelNovo != nivelMelhor) {
            return nivelNovo > nivelMelhor;
        }

        if (deusNovo != deusMelhor) {
            return deusNovo > deusMelhor;
        }

        if (mortesNovo != mortesMelhor) {
            return mortesNovo < mortesMelhor;
        }

        return nomeNovo.compareTo(nomeMelhor) < 0;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (entrada.hasNextInt()) {
            int quantidadeSeres = entrada.nextInt();

            String melhorNome = null;
            int melhorNivel = 0;
            int melhorDeus = 0;
            int melhorMortes = 0;

            for (int i = 0; i < quantidadeSeres; i++) {

                String nome = entrada.next();
                int nivel = entrada.nextInt();
                int deus = entrada.nextInt();
                int mortes = entrada.nextInt();

                if (melhorNome == null) {
                    melhorNome = nome;
                    melhorNivel = nivel;
                    melhorDeus = deus;
                    melhorMortes = mortes;
                } else if (ehMelhor(nome, nivel, deus, mortes,
                                    melhorNome, melhorNivel, melhorDeus, melhorMortes)) {
                    melhorNome = nome;
                    melhorNivel = nivel;
                    melhorDeus = deus;
                    melhorMortes = mortes;
                }
            }

            System.out.println(melhorNome);
        }

        entrada.close();
    }
}