public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void aumentarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmEstoque += quantidade;
        }
    }

    public void diminuirEstoque(int quantidade) {
        if (quantidade > 0 && this.quantidadeEmEstoque >= quantidade) {
            this.quantidadeEmEstoque -= quantidade;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
    
}



public class Main {
	public static void main(String[] args) {
        	Produto produto1 = new Produto("Camisa", 49.99, 10);
        	Produto produto2 = new Produto("Calça", 89.99, 20);

        	produto1.exibirInformacoes();
        	produto1.aumentarEstoque(5);
        	produto1.diminuirEstoque(3);
        	produto1.exibirInformacoes();

        	produto2.exibirInformacoes();
        	produto2.aumentarEstoque(10);
        	produto2.diminuirEstoque(5);
        	produto2.exibirInformacoes();
    	}
}