import java.util.Scanner;

public class ProgramaCarro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a marca do carro:");
        String marca = scanner.nextLine();

        System.out.println("Digite o modelo do carro:");
        String modelo = scanner.nextLine();

        System.out.println("Digite o ano do carro:");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.println("Digite a placa do carro:");
        String placa = scanner.nextLine();

        Carro meuCarro = new Carro(marca, modelo, ano, placa);

        System.out.println("\nInformações do carro cadastradas com sucesso:");
        meuCarro.exibirInfo();

        System.out.println("\nDeseja acelerar o carro? (Digite 'sim' ou 'nao')");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("sim")) {
            meuCarro.acelerar();
        }

        System.out.println("\nDeseja frear o carro? (Digite 'sim' ou 'nao')");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("sim")) {
            meuCarro.frear();
        }

        scanner.close();
    }

    private static class Carro {
        private String marca;
        private String modelo;
        private int ano;
        private String placa;
        private int velocidadeAtual;

        public Carro(String marca, String modelo, int ano, String placa) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.placa = placa;
            this.velocidadeAtual = 0;
        }

        public void acelerar() {
            velocidadeAtual += 10;
            System.out.println("O carro acelerou. Velocidade atual: " + velocidadeAtual + " km/h");
        }

        public void frear() {
            if (velocidadeAtual >= 10) {
                velocidadeAtual -= 10;
                System.out.println("O carro freou. Velocidade atual: " + velocidadeAtual + " km/h");
            } else {
                System.out.println("O carro está parado. Não é possível frear mais.");
            }
        }

        public void exibirInfo() {
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Ano: " + ano);
            System.out.println("Placa: " + placa);
            System.out.println("Velocidade atual: " + velocidadeAtual + " km/h");
        }
    }
}

