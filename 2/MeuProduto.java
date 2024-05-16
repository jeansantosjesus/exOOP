public class Produto {
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private double margemLucro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda < precoCusto) {
            System.out.println("O preço de venda não pode ser inferior ao preço de custo.");
        } else {
            this.precoVenda = precoVenda;
            calcularMargemLucro();
        }
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    private void calcularMargemLucro() {
        this.margemLucro = this.precoVenda - this.precoCusto;
    }

    public double getMargemLucroPorcentagem() {
        if (precoCusto > 0) {
            return (margemLucro / precoCusto) * 100;
        } else {
            return 0;
        }
    }

}

public class Main {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Produto produto = new Produto();

        System.out.print("Informe o nome do produto: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Informe o preço de custo do produto: ");
        produto.setPrecoCusto(scanner.nextDouble());

        System.out.print("Informe o preço de venda do produto: ");
        produto.setPrecoVenda(scanner.nextDouble());

        System.out.println("Margem de lucro em moeda: " + produto.getMargemLucro());
        System.out.println("Margem de lucro em percentual: " + produto.getMargemLucroPorcentagem() + "%");

        scanner.close();
    }

}