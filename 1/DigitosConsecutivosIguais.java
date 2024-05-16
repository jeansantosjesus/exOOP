import java.util.Scanner;

public class DigitosConsecutivosIguais {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite um número inteiro positivo: ");
    int n = scanner.nextInt();

    String converterParaString = Integer.toString(n);
    boolean temDigitosConsecutivosIguais = false;
    
    for(int i = 0; i < converterParaString.length() - 1; i++) {
      if(converterParaString.charAt(i) == converterParaString.charAt(i + 1)) {
        temDigitosConsecutivosIguais = true;
        break;
      }
    }

    if(temDigitosConsecutivosIguais) {
      System.out.println("O número " + n + " possui digitos consecutivos iguais.");
    } else {
      System.out.println("O número " + n + " não possui digitos consecutivos iguais.");
    }


    
    scanner.close();
  }
}
