import java.util.Random;

public class SerieLimitada {
    private static final int maximoDeInstancias = 100000; // Defina o máximo de instâncias desejado
    private static int contador = 0;
    private int numeroSerie;

    public SerieLimitada() {
        if (contador < maximoDeInstancias) {
            contador++;
            gerarNumeroSerie();
        } else {
            throw new IllegalStateException("Limite máximo de instâncias atingido.");
        }
    }

    private void gerarNumeroSerie() {
        Random random = new Random();
        numeroSerie = random.nextInt(maximoDeInstancias) + 1;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }
}


public class Main {

public static void main(String[] args) {
        try {
            SerieLimitada serie1 = new SerieLimitada();
            SerieLimitada serie2 = new SerieLimitada();
            SerieLimitada serie3 = new SerieLimitada();
            SerieLimitada serie4 = new SerieLimitada();
            SerieLimitada serie5 = new SerieLimitada();

            System.out.println("Número de série 1: " + serie1.getNumeroSerie());
            System.out.println("Número de série 2: " + serie2.getNumeroSerie());
            System.out.println("Número de série 3: " + serie3.getNumeroSerie());
            System.out.println("Número de série 4: " + serie4.getNumeroSerie());
            System.out.println("Número de série 5: " + serie5.getNumeroSerie());

            // Tentativa de criar mais uma instância além do limite máximo
            SerieLimitada serieExtra = new SerieLimitada();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

}
