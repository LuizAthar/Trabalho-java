import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Sistema de Gerenciamento de Estoque ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Mostrar Relatório de Estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, estoque);
                    break;
                case 2:
                    atualizarProduto(scanner, estoque);
                    break;
                case 3:
                    removerProduto(scanner, estoque);
                    break;
                case 4:
                    mostrarRelatorioEstoque(estoque);
                    break;
                case 5:
                    executando = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private static void adicionarProduto(Scanner scanner, List<Produto> estoque) {
        System.out.println("\nAdicionar Produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, codigo, preco, quantidade);
        estoque.add(produto);

        System.out.println("Produto adicionado ao estoque com sucesso.");
    }

    private static void atualizarProduto(Scanner scanner, List<Produto> estoque) {
        System.out.println("\nAtualizar Produto:");
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Produto produto = buscarProdutoPorCodigo(codigo, estoque);
        if (produto != null) {
            System.out.print("Novo nome (atual: " + produto.getNome() + "): ");
            String novoNome = scanner.nextLine();
            System.out.print("Novo preço (atual: " + produto.getPreco() + "): ");
            double novoPreco = scanner.nextDouble();
            System.out.print("Nova quantidade em estoque (atual: " + produto.getQuantidade() + "): ");
            int novaQuantidade = scanner.nextInt();

            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            produto.setQuantidade(novaQuantidade);

            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void removerProduto(Scanner scanner, List<Produto> estoque) {
        System.out.println("\nRemover Produto:");
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo, estoque);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Produto removido do estoque.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static Produto buscarProdutoPorCodigo(int codigo, List<Produto> estoque) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private static void mostrarRelatorioEstoque(List<Produto> estoque) {
        System.out.println("\n=== Relatório de Estoque ===");
        System.out.println("Produtos disponíveis:");

        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            for (Produto produto : estoque) {
                System.out.println(produto);
            }
        }
    }
}

class Produto {
    private String nome;
    private int codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, int codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Código: " + codigo + ", Preço: " + preco + ", Quantidade em Estoque: " + quantidade;
    }
}
