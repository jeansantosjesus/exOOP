abstract class ObjetoGeometrico {
    public abstract void inicializar();
    public abstract void mostrarDados();
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

class Circulo extends ObjetoGeometrico {
    private double x, y, raio;

    public Circulo(double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    @Override
    public void inicializar() {
        // Implementação para inicializar o círculo
    }

    @Override
    public void mostrarDados() {
        System.out.println("Círculo [Centro: (" + x + ", " + y + "), Raio: " + raio + "]");
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

class Retangulo extends ObjetoGeometrico {
    private double lado1, lado2;

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public void inicializar() {
        // Implementação para inicializar o retângulo
    }

    @Override
    public void mostrarDados() {
        System.out.println("Retângulo [Lado 1: " + lado1 + ", Lado 2: " + lado2 + "]");
    }

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (lado1 + lado2);
    }
}

class Triangulo extends ObjetoGeometrico {
    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public void inicializar() {
        // Implementação para inicializar o triângulo
    }

    @Override
    public void mostrarDados() {
        System.out.println("Triângulo [Lado 1: " + lado1 + ", Lado 2: " + lado2 + ", Lado 3: " + lado3 + "]");
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}

public class Main {
    public static void main(String[] args) {
        ObjetoGeometrico circulo = new Circulo(0, 0, 5);
        circulo.mostrarDados();
        System.out.println("Área do Círculo: " + circulo.calcularArea());
        System.out.println("Perímetro do Círculo: " + circulo.calcularPerimetro());

        ObjetoGeometrico retangulo = new Retangulo(4, 7);
        retangulo.mostrarDados();
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
        System.out.println("Perímetro do Retângulo: " + retangulo.calcularPerimetro());

        ObjetoGeometrico triangulo = new Triangulo(3, 4, 5);
        triangulo.mostrarDados();
        System.out.println("Área do Triângulo: " + triangulo.calcularArea());
        System.out.println("Perímetro do Triângulo: " + triangulo.calcularPerimetro());
    }
}
