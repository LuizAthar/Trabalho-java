import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + ano);
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Livro> colecao = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Exibir informações de um livro");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o nome do autor:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ano de publicação:");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    Livro livro = new Livro(titulo, autor, ano);
                    colecao.add(livro);
                    System.out.println("Livro adicionado à coleção.");
                    break;
                case 2:
                    System.out.println("Digite o índice do livro que deseja visualizar:");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < colecao.size()) {
                        colecao.get(indice).exibirInfo();
                    } else {
                        System.out.println("Índice inválido. Por favor, tente novamente.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
