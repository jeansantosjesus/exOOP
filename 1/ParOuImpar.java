import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        // Criando um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Pedindo ao usuário para inserir um número inteiro positivo
        System.out.println("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();
        
        // Verificando se o número é par ou ímpar
        if (n % 2 == 0) {
            System.out.println("O número " + n + " é par.");
        } else {
            System.out.println("O número " + n + " é ímpar.");
        }
        
        // Fechando o Scanner
        scanner.close();
    }
}
