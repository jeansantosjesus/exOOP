
import java.util.Scanner;

public class Midia {
    private int codigo;
    private double preco;
    private String nome;

    public Midia() {
    }

    public Midia(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return "Midia";
    }

    public String getDetalhes() {
        return "Código: " + codigo + ", Preço: " + preco + ", Nome: " + nome;
    }

    public void printDados() {
        System.out.println(getTipo() + ": " + getDetalhes());
    }

    public void inserirDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código: ");
        setCodigo(scanner.nextInt());
        System.out.print("Digite o preço: ");
        setPreco(scanner.nextDouble());
        scanner.nextLine(); // Consumir a nova linha deixada por nextDouble()
        System.out.print("Digite o nome: ");
        setNome(scanner.nextLine());
    }
}



public class DVD extends Midia {
    private int nFaixas;

    public DVD() {
    }

    public DVD(int codigo, double preco, String nome, int nFaixas) {
        super(codigo, preco, nome);
        this.nFaixas = nFaixas;
    }

    public int getNFaixas() {
        return nFaixas;
    }

    public void setNFaixas(int nFaixas) {
        this.nFaixas = nFaixas;
    }

    @Override
    public String getTipo() {
        return "DVD";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + ", Número de faixas: " + nFaixas;
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de faixas: ");
        setNFaixas(scanner.nextInt());
    }
}



public class CD extends Midia {
    private int nMusicas;

    public CD() {
    }

    public CD(int codigo, double preco, String nome, int nMusicas) {
        super(codigo, preco, nome);
        this.nMusicas = nMusicas;
    }

    public int getNMusicas() {
        return nMusicas;
    }

    public void setNMusicas(int nMusicas) {
        this.nMusicas = nMusicas;
    }

    @Override
    public String getTipo() {
        return "CD";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + ", Número de músicas: " + nMusicas;
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de músicas: ");
        setNMusicas(scanner.nextInt());
    }
}




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Midia> midias = new ArrayList<>();

        while (true) {
            System.out.println("Cadastro de Mídia");
            System.out.println("1. Adicionar DVD");
            System.out.println("2. Adicionar CD");
            System.out.println("3. Listar Mídias");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    DVD dvd = new DVD();
                    dvd.inserirDados();
                    midias.add(dvd);
                    break;
                case 2:
                    CD cd = new CD();
                    cd.inserirDados();
                    midias.add(cd);
                    break;
                case 3:
                    for (Midia midia : midias) {
                        midia.printDados();
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}