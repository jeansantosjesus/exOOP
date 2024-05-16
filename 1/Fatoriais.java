import java.util.Scanner;

public class Fatoriais {
    public static void main(String[] args) {
        // Criando um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pedindo ao usuário para inserir o valor de n
        System.out.println("Digite um número inteiro positivo n: ");
        int n = scanner.nextInt();

        // Criando um array para armazenar a sequência de números
        int[] numeros = new int[n];

        // Lendo a sequência de n números inteiros positivos
        System.out.println("Digite " + n + " números inteiros positivos:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        // Calculando e imprimindo o fatorial de cada número na sequência
        System.out.println("Os fatoriais dos números fornecidos são:");
        for (int i = 0; i < n; i++) {
            System.out.println("Fatorial de " + numeros[i] + " é " + fatorial(numeros[i]));
        }

        // Fechando o Scanner
        scanner.close();
    }

    // Função para calcular o fatorial de um número
    public static long fatorial(int num) {
        long resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
