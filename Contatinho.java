import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Contato {
    private String nome;
    private String email;
    private String telefone;
    private String categoria;

    public Contato(String nome, String email, String telefone, String categoria) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + "#" + email + "#" + telefone + "#" + categoria;
    }
}

class Agenda {
    private ArrayList<Contato> lista;

    public Agenda() {
        lista = new ArrayList<>();
    }

    public void adicionar(Contato c) {
        lista.add(c);
    }

    public void ordenarPorNome() {
        Collections.sort(lista, Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));
    }

    public void salvarEmArquivo(String nomeArquivo) {
        ordenarPorNome();
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            for (Contato c : lista) {
                fw.write(c.toString() + "\n");
            }
            fw.close();
            System.out.println("Contatos salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar a agenda.");
        }
    }

    public void mostrarLista() {
        for (Contato c : lista) {
            System.out.println(c.toString());
        }
    }
}

public class Contatinho {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();

        System.out.println("Cadastro de Contatinhos");
        System.out.print("Quantos contatos deseja adicionar? ");
        int qtd = input.nextInt();
        input.nextLine(); // limpar buffer

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nContato " + (i + 1));
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Telefone: ");
            String telefone = input.nextLine();
            System.out.print("Categoria: ");
            String categoria = input.nextLine();

            Contato c = new Contato(nome, email, telefone, categoria);
            agenda.adicionar(c);
        }

        agenda.salvarEmArquivo("agenda.txt");
        System.out.println("\nLista salva com sucesso!");
        input.close();
    }
}