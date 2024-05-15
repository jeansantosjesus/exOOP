import java.util.Scanner;

public class NumeroTriangular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número natural: ");
        int n = scanner.nextInt();

        boolean isTriangular = false;

        for (int i = 1; i * (i + 1) * (i + 2) <= n; i++) {
            if (i * (i + 1) * (i + 2) == n) {
                isTriangular = true;
                break;
            }
        }

        if (isTriangular) {
            System.out.println(n + " é um número triangular.");
        } else {
            System.out.println(n + " não é um número triangular.");
        }

        scanner.close();
    }
}
