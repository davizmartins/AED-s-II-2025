//Aluno: Davi Martins, Matricula: 885013

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

    // Construtor completo para inicializar um objeto com todos os dados
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

    // Getters para acessar os atributos privados
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

    // Setters para modificar os atributos privados
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

    // Método auxiliar para converter arrays em Strings formatadas.
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

    // Cria uma representação em String completa do objeto Game, útil para testes e
    // impressão.

    @Override
    public String toString() {
        // Define o separador para facilitar o sop
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

// Classe principal que executa a leitura, processamento e busca dos dados dos
// jogos
public class tp04 {

    // Converte a data do formato CSV para 'dd/MM/yyyy', tratando casos incompletos.
    public static String formatDate(String csvDate) {
        String cleanDate = csvDate.replace("\"", "").trim();
        String[] parts = cleanDate.split(" ");
        String monthName, day, year;

        // Lógica para tratar os 3 formatos de data possíveis.
        if (parts.length == 3) {
            monthName = parts[0];
            day = parts[1].replace(",", "");
            year = parts[2];
        } else if (parts.length == 2) {
            monthName = parts[0];
            day = "01";
            year = parts[1];
        } else if (parts.length == 1 && !parts[0].isEmpty()) {
            monthName = "Jan";
            day = "01";
            year = parts[0];
        } else {
            return "sem data";
        }

        // Converte o nome do mês para seu número correspondente.
        String monthNumber;
        switch (monthName) {
            case "Jan":
                monthNumber = "01";
                break;
            case "Feb":
                monthNumber = "02";
                break;
            case "Mar":
                monthNumber = "03";
                break;
            case "Apr":
                monthNumber = "04";
                break;
            case "May":
                monthNumber = "05";
                break;
            case "Jun":
                monthNumber = "06";
                break;
            case "Jul":
                monthNumber = "07";
                break;
            case "Aug":
                monthNumber = "08";
                break;
            case "Sep":
                monthNumber = "09";
                break;
            case "Oct":
                monthNumber = "10";
                break;
            case "Nov":
                monthNumber = "11";
                break;
            case "Dec":
                monthNumber = "12";
                break;
            default:
                monthNumber = "01";
        }

        // Garante que o dia sempre tenha dois dígitos.
        if (day.length() == 1) {
            day = "0" + day;
        }
        return day + "/" + monthNumber + "/" + year;
    }

    // Método auxiliar que remove aspas, divide a String por vírgulas e limpa
    // espaços de cada elemento.
    public static String[] ajustarArray(String text) {
        String cleanedText = text.replace("\"", "").trim();
        if (cleanedText.isEmpty()) {
            return new String[0]; // Retorna um array vazio se o campo não tiver nada.
        }
        String[] array = cleanedText.split(",");
        // Loop para remover espaços em branco de cada item do array.
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }

    // Função que converte uma linha do CSV em um objeto Game.
    public static Game parseGame(String str) {
        // Regex para dividir a linha CSV, ignorando vírgulas dentro de aspas.
        String[] partes = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        int id = Integer.parseInt(partes[0]);
        String nome = partes[1].replace("\"", "");
        String data = formatDate(partes[2]);
        int owners = Integer.parseInt(partes[3].replace("\"", "").split("-")[0]);
        float price = Float.parseFloat(partes[4]);

        // Usa um método auxiliar para limpar e dividir campos que são listas em formato
        // de String.
        String[] languages = ajustarArray(partes[5].replace("[", "").replace("]", "").replace("'", ""));
        int mScore = partes[6].isEmpty() ? -1 : Integer.parseInt(partes[6]);
        float uScore = (partes[7].isEmpty() || partes[7].equalsIgnoreCase("tbd")) ? -1.0f : Float.parseFloat(partes[7]);
        int conq = partes[8].isEmpty() ? 0 : Integer.parseInt(partes[8]);

        String[] publisher = ajustarArray(partes[9]);
        String[] dev = ajustarArray(partes[10]);
        String[] categories = ajustarArray(partes[11]);
        String[] generos = ajustarArray(partes[12]);
        String[] tags = ajustarArray(partes[13]);

        // Retorna um novo objeto Game com todos os dados tratados.
        return new Game(id, nome, data, owners, price, languages, mScore, uScore, conq, publisher, dev, categories,
                generos, tags);
    }

    // Método principal que executa o programa.
    public static void main(String[] args) {
    String filePath = "/tmp/games.csv";
    int totalGames = 0;
    
    // ETAPA 1: Contagem de linhas com o encoding correto
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
        br.readLine();
        while (br.readLine() != null) {
            totalGames++;
        }
    } catch (IOException e) {
        // Erros de arquivo geralmente não devem imprimir nada no stdout para o juiz online.
        // e.printStackTrace(); // Bom para depuração, mas comente para a entrega final.
        return;
    }

    Game[] games = new Game[totalGames];
    int i = 0;
    
    // ETAPA 2: Preenchimento do array com o encoding correto
    try (BufferedReader arqReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
        arqReader.readLine();
        String linha;
        while ((linha = arqReader.readLine()) != null) {
            if (i < totalGames) {
                games[i] = parseGame(linha);
                i++;
            }
        }
    } catch (IOException e) {
        // e.printStackTrace();
    }

    // ETAPA 3: Loop de busca (sem impressões extras)
    Scanner ent = new Scanner(System.in);
    while (ent.hasNextLine()) {
        String entrada = ent.nextLine();

        if (entrada.trim().isEmpty()) {
            continue;
        }

        if (entrada.equalsIgnoreCase("FIM")) {
            break;
        }

        try {
            int idDeBusca = Integer.parseInt(entrada);
            for (int k = 0; k < games.length; k++) {
                if (games[k] != null && games[k].getId() == idDeBusca) {
                    System.out.println(games[k].toString());
                    break;
                }
            }
        } catch (NumberFormatException e) {
            // Ignora entradas inválidas, não imprime nada.
        }
    }
    ent.close();

    }

}
