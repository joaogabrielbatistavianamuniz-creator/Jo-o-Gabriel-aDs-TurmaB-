import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tabuáda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe um número pra gerar a tabuada: ");
        int numero = input.nextInt();

        String arquivo = "tabuada_" + numero + ".txt";

        try {
            FileWriter fw = new FileWriter(arquivo);
            for (int i = 1; i <= 10; i++) {
                fw.write(numero + " x " + i + " = " + (numero * i) + "\n");
            }
            fw.close();
            System.out.println("Arquivo criado com sucesso: " + arquivo);
        } catch (IOException erro) {
            System.out.println("Deu erro ao salvar a tabuada.");
        }

        input.close();
    }
}