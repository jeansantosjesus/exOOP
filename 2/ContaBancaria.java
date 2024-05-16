//Classe Main

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Alice", 1000.0, 12345);
        ContaBancaria conta2 = new ContaBancaria("Bob", 67890);

        conta1.depositar(500.0);
        conta1.sacar(200.0);

        conta2.depositar(1500.0);
        conta2.sacar(300.0);

        System.out.println("Conta 1 - Titular: " + conta1.getTitular() + ", Saldo: " + conta1.getSaldo() + ", Número da Conta: " + conta1.getNumeroConta());
        System.out.println("Conta 2 - Titular: " + conta2.getTitular() + ", Saldo: " + conta2.getSaldo() + ", Número da Conta: " + conta2.getNumeroConta());
    }
}



//Class ContaBancaria

public class ContaBancaria {
    private String titular;
    private double saldo;
    private int numeroConta;

    public ContaBancaria(String titular, double saldo, int numeroConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public ContaBancaria(String titular, int numeroConta) {
        this(titular, 0.0, numeroConta);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

}
