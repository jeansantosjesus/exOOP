import java.util.Scanner;

public class PrimeiroUltimoDigitoIgual {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();

        String numeroStr = Integer.toString(n);

        char primeiroDigito = numeroStr.charAt(0);
        char ultimoDigito = numeroStr.charAt(numeroStr.length() - 1);

        if (primeiroDigito == ultimoDigito) {
            System.out.println("O primeiro e o último dígitos do número " + n + " são iguais.");
        } else {
            System.out.println("O primeiro e o último dígitos do número " + n + " são diferentes.");
        }

        scanner.close();
    }
}
