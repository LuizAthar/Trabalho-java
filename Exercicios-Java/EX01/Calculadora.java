import java.util.Scanner;

public class Calculadora {
    
    public static double adicionar(double num1, double num2) {
        return num1 + num2;
    }
    
    public static double subtrair(double num1, double num2) {
        return num1 - num2;
    }
    
    public static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
    
    public static double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return Double.NaN;
        } else {
            return num1 / num2;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número:");
        double num1 = scanner.nextDouble();
        
        System.out.println("Digite o segundo número:");
        double num2 = scanner.nextDouble();
        
        System.out.println("Escolha a operação:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        int operacao = scanner.nextInt();
        
        double resultado;
        
        switch (operacao) {
            case 1:
                resultado = adicionar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case 2:
                resultado = subtrair(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case 3:
                resultado = multiplicar(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case 4:
                resultado = dividir(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            default:
                System.out.println("Operação inválida.");
        }
        
        scanner.close();
    }
}
