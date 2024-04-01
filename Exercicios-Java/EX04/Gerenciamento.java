import java.util.Scanner;

class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.nivel = 1;
    }

    public void aumentarPontuacao(int pontos) {
        pontuacao += pontos;
        verificarNivel();
    }

    private void verificarNivel() {
        if (pontuacao >= 100) {
            nivel++;
            pontuacao -= 100;
        }
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
    }
}

public class Gerenciamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do jogador:");
        String nomeJogador = scanner.nextLine();

        Jogador jogador = new Jogador(nomeJogador);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Aumentar Pontuação");
            System.out.println("2 - Exibir Informações do Jogador");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de pontos a adicionar:");
                    int pontos = scanner.nextInt();
                    jogador.aumentarPontuacao(pontos);
                    break;
                case 2:
                    jogador.exibirInfo();
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
