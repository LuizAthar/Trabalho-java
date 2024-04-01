import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidosPizza {
    public static void main(String[] args) {
        List<Pizza> pizzasDisponiveis = new ArrayList<>();
        pizzasDisponiveis.add(new Pizza("Strogonoff", 29.0, "Molho de tomate, Frango, manjericão"));
        pizzasDisponiveis.add(new Pizza("Mussarela", 37.0, "Molho de tomate, mussarela"));
        pizzasDisponiveis.add(new Pizza("Portuguesa", 39.0, "Molho de tomate, Cebola, Presunto"));

        List<Pedido> pedidos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Sistema de Pedidos de Pizza ===");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Cancelar Pedido");
            System.out.println("3. Mostrar Relatório de Pedidos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, pizzasDisponiveis, pedidos);
                    break;
                case 2:
                    cancelarPedido(scanner, pedidos);
                    break;
                case 3:
                    mostrarRelatorioPedidos(pedidos);
                    break;
                case 4:
                    executando = false;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private static void fazerPedido(Scanner scanner, List<Pizza> pizzasDisponiveis, List<Pedido> pedidos) {
        System.out.println("\nFazer Pedido:");
        System.out.println("Escolha uma pizza:");

        for (int i = 0; i < pizzasDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + pizzasDisponiveis.get(i).getNome() + " - R$" + pizzasDisponiveis.get(i).getValor());
        }

        System.out.print("Digite o número da pizza desejada: ");
        int escolhaPizza = scanner.nextInt();
        scanner.nextLine();

        if (escolhaPizza < 1 || escolhaPizza > pizzasDisponiveis.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Pizza pizzaEscolhida = pizzasDisponiveis.get(escolhaPizza - 1);

        System.out.print("Digite o endereço de entrega: ");
        String enderecoEntrega = scanner.nextLine();

        Pedido pedido = new Pedido(pizzaEscolhida, enderecoEntrega);
        pedidos.add(pedido);

        System.out.println("Pedido realizado com sucesso.");
    }

    private static void cancelarPedido(Scanner scanner, List<Pedido> pedidos) {
        System.out.println("\nCancelar Pedido:");
        System.out.print("Digite o número do pedido a ser cancelado: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (numeroPedido < 1 || numeroPedido > pedidos.size()) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        Pedido pedidoCancelado = pedidos.remove(numeroPedido - 1);
        System.out.println("Pedido cancelado: " + pedidoCancelado);
    }

    private static void mostrarRelatorioPedidos(List<Pedido> pedidos) {
        System.out.println("\n=== Relatório de Pedidos ===");
        System.out.println("Total de pedidos realizados: " + pedidos.size());

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
        } else {
            System.out.println("Lista de pedidos:");

            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println((i + 1) + ". " + pedidos.get(i));
            }
        }
    }
}

class Pizza {
    private String nome;
    private double valor;
    private String ingredientes;

    public Pizza(String nome, double valor, String ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor;
    }
}

class Pedido {
    private Pizza pizza;
    private String enderecoEntrega;

    public Pedido(Pizza pizza, String enderecoEntrega) {
        this.pizza = pizza;
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido: " + pizza.getNome() + " - R$" + pizza.getValor() + " | Endereço de Entrega: " + enderecoEntrega;
    }
}
