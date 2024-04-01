import java.util.Scanner;

class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar saque.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Banco{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do titular da conta:");
        String nomeTitular = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saindo do programa");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Por favor, tente novamente.");
            }
        }
    }
}
