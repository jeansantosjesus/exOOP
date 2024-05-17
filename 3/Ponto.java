public class Ponto {
    private double x;
    private double y;

    
    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    // Construtor que recebe coordenadas x e y
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    public Ponto(Ponto outroPonto) {
        this.x = outroPonto.x;
        this.y = outroPonto.y;
    }

    
    public void desloca(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Método desloca que recebe um objeto da classe Ponto
    public void desloca(Ponto ponto) {
        this.x += ponto.x;
        this.y += ponto.y;
    }

   
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    
    public void setPonto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPonto(Ponto ponto) {
        this.x = ponto.x;
        this.y = ponto.y;
    }

    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

public class Main {

    public static void main(String[] args) {
        
        Ponto ponto1 = new Ponto(); // Usando construtor sem parâmetros
        Ponto ponto2 = new Ponto(3, 5); // Usando construtor que recebe coordenadas
        Ponto ponto3 = new Ponto(ponto2); // Usando construtor que inicializa através de outro Ponto

        System.out.println("Ponto 1: " + ponto1);
        System.out.println("Ponto 2: " + ponto2);
        System.out.println("Ponto 3: " + ponto3);

        ponto1.desloca(2, -1); // Desloca ponto1 utilizando coordenadas
        System.out.println("Ponto 1 após deslocamento: " + ponto1);

        Ponto deslocamento = new Ponto(-1, 2);
        ponto2.desloca(deslocamento); // Desloca ponto2 utilizando um objeto Ponto
        System.out.println("Ponto 2 após deslocamento: " + ponto2);
    }

}
