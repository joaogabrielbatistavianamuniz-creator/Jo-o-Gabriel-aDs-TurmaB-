import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BuscaContato {
    public static String procurarPorNome(String nomeArquivo, String nomeBuscado) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("#");
                if (partes.length >= 4) {
                    String nome = partes[0].trim();
                    if (nome.equalsIgnoreCase(nomeBuscado.trim())) {
                        br.close();
                        return "Nome: " + partes[0] + "\nEmail: " + partes[1] +
                               "\nTelefone: " + partes[2] + "\nCategoria: " + partes[3];
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo de contatos.");
        }
        return null;
    }
}

public class Ex04_Busca {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do contato que deseja procurar: ");
        String nome = input.nextLine();

        String resultado = BuscaContato.procurarPorNome("agenda.txt", nome);

        if (resultado != null) {
            System.out.println("\nContato encontrado:\n" + resultado);
        } else {
            System.out.println("\nContato não encontrado.");
        }

        input.close();
    }
}