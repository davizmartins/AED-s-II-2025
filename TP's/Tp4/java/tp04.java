//Aluno: Davi Martins, Matricula: 885013

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Game {
    private int id;
    private String name;
    private String data;
    private int owners;
    private float price;
    private String[] languages;
    private int mScore;
    private float uScore;
    private int conq;
    private String[] publisher;
    private String[] dev;
    private String[] categories;
    private String[] generos;
    private String[] tags;

    public Game() {
    }

    // Construtor com todos os dados do jogo
    public Game(int id, String name, String data, int owners, float price, String[] languages, int mScore, float uScore,
            int conq, String[] publisher, String[] dev, String[] categories, String[] generos, String[] tags) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.owners = owners;
        this.price = price;
        this.languages = languages;
        this.mScore = mScore;
        this.uScore = uScore;
        this.conq = conq;
        this.publisher = publisher;
        this.dev = dev;
        this.categories = categories;
        this.generos = generos;
        this.tags = tags;
    }

    // Getters (pegar valores dos atributos)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public int getOwners() {
        return owners;
    }

    public float getPrice() {
        return price;
    }

    public String[] getLanguages() {
        return languages;
    }

    public int getMScore() {
        return mScore;
    }

    public float getUScore() {
        return uScore;
    }

    public int getConq() {
        return conq;
    }

    public String[] getPublisher() {
        return publisher;
    }

    public String[] getDev() {
        return dev;
    }

    public String[] getCategories() {
        return categories;
    }

    public String[] getGeneros() {
        return generos;
    }

    public String[] getTags() {
        return tags;
    }

    // Setters (mudar valores dos atributos)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOwners(int owners) {
        this.owners = owners;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setMScore(int mScore) {
        this.mScore = mScore;
    }

    public void setUScore(float uScore) {
        this.uScore = uScore;
    }

    public void setConq(int conq) {
        this.conq = conq;
    }

    public void setPublisher(String[] publisher) {
        this.publisher = publisher;
    }

    public void setDev(String[] dev) {
        this.dev = dev;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String takeArray(String[] arr) {
        if (arr == null)
            return "[]";
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i < arr.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // Mostra todos os dados do jogo em uma única linha
    @Override
    public String toString() {
        String separador = " ## ";
        return "=> " +
                this.id + separador +
                this.name + separador +
                this.data + separador +
                this.owners + separador +
                this.price + separador +
                takeArray(this.languages) + separador +
                this.mScore + separador +
                this.uScore + separador +
                this.conq + separador +
                takeArray(this.publisher) + separador +
                takeArray(this.dev) + separador +
                takeArray(this.categories) + separador +
                takeArray(this.generos) + separador +
                takeArray(this.tags) + " ##";
    }
}

// Classe principal do programa
public class tp04 {

    // Arruma a data do CSV e transforma pro formato dd/MM/yyyy
    public static String formatarData(String dataCsv) {
        String dataLimpa = dataCsv.replace("\"", "").trim();
        String[] partes = dataLimpa.split(" ");
        String mesNome, dia, ano;

        if (partes.length == 3) {
            mesNome = partes[0];
            dia = partes[1].replace(",", "");
            ano = partes[2];
        } else if (partes.length == 2) {
            mesNome = partes[0];
            dia = "01";
            ano = partes[1];
        } else if (partes.length == 1 && !partes[0].isEmpty()) {
            mesNome = "Jan";
            dia = "01";
            ano = partes[0];
        } else {
            return "sem data";
        }

        String numeroMes;
        switch (mesNome) {
            case "Jan":
                numeroMes = "01";
                break;
            case "Feb":
                numeroMes = "02";
                break;
            case "Mar":
                numeroMes = "03";
                break;
            case "Apr":
                numeroMes = "04";
                break;
            case "May":
                numeroMes = "05";
                break;
            case "Jun":
                numeroMes = "06";
                break;
            case "Jul":
                numeroMes = "07";
                break;
            case "Aug":
                numeroMes = "08";
                break;
            case "Sep":
                numeroMes = "09";
                break;
            case "Oct":
                numeroMes = "10";
                break;
            case "Nov":
                numeroMes = "11";
                break;
            case "Dec":
                numeroMes = "12";
                break;
            default:
                numeroMes = "01";
        }

        if (dia.length() == 1) {
            dia = "0" + dia;
        }
        return dia + "/" + numeroMes + "/" + ano;
    }

    // Limpa o texto e transforma em um array 
    public static String[] ajustarArray(String texto) {
        String textoLimpo = texto.replace("\"", "").trim();
        if (textoLimpo.isEmpty()) {
            return new String[0];
        }
        String[] array = textoLimpo.split(",");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }

    // Converte uma linha do arquivo CSV em um objeto Game completo
    public static Game converterParaGame(String linha) {
        String[] partes = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        int id = Integer.parseInt(partes[0]);
        String nome = partes[1].replace("\"", "");
        String data = formatarData(partes[2]);
        int owners = Integer.parseInt(partes[3].replace("\"", "").split("-")[0]);
        float price = Float.parseFloat(partes[4]);

        String[] languages = ajustarArray(partes[5].replace("[", "").replace("]", "").replace("'", ""));
        int mScore = partes[6].isEmpty() ? -1 : Integer.parseInt(partes[6]);
        float uScore = (partes[7].isEmpty() || partes[7].equalsIgnoreCase("tbd")) ? -1.0f : Float.parseFloat(partes[7]);
        int conq = partes[8].isEmpty() ? 0 : Integer.parseInt(partes[8]);

        String[] publisher = ajustarArray(partes[9]);
        String[] dev = ajustarArray(partes[10]);
        String[] categories = ajustarArray(partes[11]);
        String[] generos = ajustarArray(partes[12]);
        String[] tags = ajustarArray(partes[13]);

        return new Game(id, nome, data, owners, price, languages, mScore, uScore, conq, publisher, dev, categories,
                generos, tags);
    }

    // Função principal do programa (lê, armazena e busca os jogos)
    public static void main(String[] args) {
        String caminhoArquivo = "/tmp/games.csv";
        int totalJogos = 0;

        // Conta quantas linhas tem no arquivo
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(caminhoArquivo), "UTF-8"))) {
            leitor.readLine();
            while (leitor.readLine() != null) {
                totalJogos++;
            }
        } catch (IOException e) {
            return;
        }

        Game[] games = new Game[totalJogos];
        int i = 0;

        // Lê o arquivo e guarda os jogos no vetor
        try (BufferedReader leitorArq = new BufferedReader(new InputStreamReader(new FileInputStream(caminhoArquivo), "UTF-8"))) {
            leitorArq.readLine();
            String linha;
            while ((linha = leitorArq.readLine()) != null) {
                if (i < totalJogos) {
                    games[i] = converterParaGame(linha);
                    i++;
                }
            }
        } catch (IOException e) {
        }

        // Faz a busca dos jogos pelo id
        Scanner entrada = new Scanner(System.in);
        while (entrada.hasNextLine()) {
            String linhaEntrada = entrada.nextLine();

            if (linhaEntrada.trim().isEmpty()) {
                continue;
            }

            if (linhaEntrada.equalsIgnoreCase("FIM")) {
                break;
            }

            try {
                int idBusca = Integer.parseInt(linhaEntrada);
                for (int k = 0; k < games.length; k++) {
                    if (games[k] != null && games[k].getId() == idBusca) {
                        System.out.println(games[k].toString());
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // ignora entradas inválidas
            }
        }
        entrada.close();
    }
}
