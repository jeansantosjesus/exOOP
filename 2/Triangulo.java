//Classe triangulo

public class Triangulo {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double calcularPerimetro() {
        double hipotenusa = Math.sqrt((base * base) + (altura * altura));
        return base + altura + hipotenusa;
    }
}



//Classe Main

public class Main {

    public static void main(String[] args) {
        Triangulo triangulo1 = new Triangulo(3.0, 4.0);
        Triangulo triangulo2 = new Triangulo(5.0, 12.0);

        System.out.println("Triângulo 1 - Base: " + triangulo1.getBase() + ", Altura: " + triangulo1.getAltura());
        System.out.println("Área: " + triangulo1.calcularArea());
        System.out.println("Perímetro: " + triangulo1.calcularPerimetro());

        System.out.println("Triângulo 2 - Base: " + triangulo2.getBase() + ", Altura: " + triangulo2.getAltura());
        System.out.println("Área: " + triangulo2.calcularArea());
        System.out.println("Perímetro: " + triangulo2.calcularPerimetro());
    }
}