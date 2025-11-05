import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Tabuáda2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número da tabuada pra abrir: ");
        int numero = input.nextInt();

        String arquivo = "tabuada_" + numero + ".txt";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha;
            System.out.println("\nTabuada de " + numero + ":");
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            leitor.close();
        } catch (IOException e) {
            System.out.println("Não foi possível abrir o arquivo.");
            System.out.println("Tente gerar a tabuada primeiro com o Ex01.");
        }

        input.close();
    }
}