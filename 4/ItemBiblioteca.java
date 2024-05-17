abstract class ItemBiblioteca {
    protected String titulo;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void mostrarDetalhes();
}

class Livro extends ItemBiblioteca {
    private String situacao;

    public Livro(String titulo) {
        super(titulo);
        this.situacao = "disponível";
    }

    public String getSituacao() {
        return situacao;
    }

    public void emprestar() {
        if ("disponível".equals(situacao)) {
            situacao = "emprestado";
            System.out.println("Livro " + titulo + " foi emprestado.");
        } else {
            System.out.println("Livro " + titulo + " já está emprestado.");
        }
    }

    public void devolver() {
        if ("emprestado".equals(situacao)) {
            situacao = "disponível";
            System.out.println("Livro " + titulo + " foi devolvido.");
        } else {
            System.out.println("Livro " + titulo + " não está emprestado.");
        }
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Livro [Título: " + titulo + ", Situação: " + situacao + "]");
    }
}

class Periodico extends ItemBiblioteca {
    private int numeroVolume;

    public Periodico(String titulo, int numeroVolume) {
        super(titulo);
        this.numeroVolume = numeroVolume;
    }

    public int getNumeroVolume() {
        return numeroVolume;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Periódico [Título: " + titulo + ", Número do Volume: " + numeroVolume + "]");
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Java Programming");
        Livro livro2 = new Livro("Data Structures");
        Periodico periodico1 = new Periodico("Science Journal", 45);
        Periodico periodico2 = new Periodico("Tech Monthly", 12);

        livro1.mostrarDetalhes();
        livro2.mostrarDetalhes();
        periodico1.mostrarDetalhes();
        periodico2.mostrarDetalhes();

        livro1.emprestar();
        livro1.mostrarDetalhes();

        livro1.devolver();
        livro1.mostrarDetalhes();

        livro2.emprestar();
        livro2.mostrarDetalhes();
    }
}
