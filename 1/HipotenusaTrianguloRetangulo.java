import java.util.Scanner;

public class HipotenusaTrianguloRetangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro positivo n: ");
        int n = scanner.nextInt();

        System.out.println("Os comprimentos de hipotenusa entre 1 e " + n + " são:");
        for (int c = 1; c <= n; c++) {
            if (ehHipotenusa(c)) {
                System.out.println(c);
            }
        }

        scanner.close();
    }

    public static boolean ehHipotenusa(int h) {
        for (int a = 1; a < h; a++) {
            for (int b = a; b < h; b++) {
                if (a * a + b * b == h * h) {
                    return true;
                }
            }
        }
        return false;
    }
}
