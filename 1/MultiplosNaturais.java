import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MultiplosNaturais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Digite um número inteiro positivo n );
        int n = scanner.nextInt();

        System.out.println(Digite um número natural não nulo i );
        int i = scanner.nextInt();

        System.out.println(Digite um número natural não nulo j );
        int j = scanner.nextInt();

        SetInteger multiplos = new TreeSet();

        int contador = 0;
        int num = 0;

         Encontrando os n primeiros múltiplos de i ou j
        while (contador  n) {
            if (num % i == 0  num % j == 0) {
                multiplos.add(num);
                contador++;
            }
            num++;
        }

        
        System.out.println(Os primeiros  + n +  números naturais que são múltiplos de  + i +  ou  + j +  ou de ambos são);
        for (int multiplo  multiplos) {
            System.out.print(multiplo +  );
        }

        scanner.close();
    }
}
