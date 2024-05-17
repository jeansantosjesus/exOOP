import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Cliente {
    private String cpf;
    private String nome;
    private Date dataNascimento;

    public Cliente(String cpf, String nome, Date dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente [CPF: " + cpf + ", Nome: " + nome + ", Data de Nascimento: " + dataNascimento + "]";
    }
}

class Transacao {
    private String tipo;
    private double valor;
    private Date data;

    public Transacao(String tipo, double valor, Date data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Transacao [Tipo: " + tipo + ", Valor: " + valor + ", Data: " + data + "]";
    }
}

abstract class ContaBancaria {
    protected String identificador;
    protected String agencia;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> transacoes;

    public ContaBancaria(String identificador, String agencia, Cliente cliente) {
        this.identificador = identificador;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Transacao("Depósito", valor, new Date()));
    }

    public abstract void sacar(double valor);

    public List<Transacao> getTransacoesDesde(Date data) {
        List<Transacao> resultado = new ArrayList<>();
        for (Transacao t : transacoes) {
            if (!t.getData().before(data)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "ContaBancaria [Identificador: " + identificador + ", Agencia: " + agencia + ", Cliente: " + cliente + ", Saldo: " + saldo + "]";
    }
}

class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String identificador, String agencia, Cliente cliente) {
        super(identificador, agencia, cliente);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", valor, new Date()));
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    private static final double TAXA_SAQUE = 0.05;
    private static final double TAXA_RENDIMENTO = 0.04;

    public ContaPoupanca(String identificador, String agencia, Cliente cliente) {
        super(identificador, agencia, cliente);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor * (1 + TAXA_SAQUE);
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            transacoes.add(new Transacao("Saque", valor, new Date()));
        } else {
            System.out.println("Saldo insuficiente para saque com taxa.");
        }
    }

    public void aplicarRendimentos() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        transacoes.add(new Transacao("Rendimento", rendimento, new Date()));
    }
}

public class Banco {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("12345678901", "João Silva", new Date(90, 4, 15));
        Cliente cliente2 = new Cliente("98765432109", "Maria Oliveira", new Date(85, 2, 10));

        ContaCorrente contaCorrente = new ContaCorrente("0001", "Agencia1", cliente1);
        ContaPoupanca contaPoupanca = new ContaPoupanca("0002", "Agencia2", cliente2);

        contaCorrente.depositar(1000);
        contaPoupanca.depositar(2000);

        contaCorrente.sacar(200);
        contaPoupanca.sacar(300);

        contaPoupanca.aplicarRendimentos();

        System.out.println(contaCorrente);
        System.out.println(contaPoupanca);

        System.out.println("Transações da Conta Corrente desde 01/01/2024:");
        for (Transacao t : contaCorrente.getTransacoesDesde(new Date(124, 0, 1))) {
            System.out.println(t);
        }

        System.out.println("Transações da Conta Poupança desde 01/01/2024:");
        for (Transacao t : contaPoupanca.getTransacoesDesde(new Date(124, 0, 1))) {
            System.out.println(t);
        }
    }
}
 