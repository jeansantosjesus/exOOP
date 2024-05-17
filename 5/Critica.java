public class Critica {
    private String usuario;
    private int avaliacao;
    private String comentario;

    public Critica(String usuario, int avaliacao, String comentario) {
        this.usuario = usuario;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario + ", Avaliação: " + avaliacao + ", Comentário: " + comentario;
    }
}


import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private String diretor;
    private List<String> elenco;
    private String genero;
    private String classificacaoIndicativa;
    private List<Critica> criticas;

    public Filme(String titulo, String diretor, List<String> elenco, String genero, String classificacaoIndicativa) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.elenco = elenco;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.criticas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public List<String> getElenco() {
        return elenco;
    }

    public String getGenero() {
        return genero;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void adicionarCritica(Critica critica) {
        criticas.add(critica);
    }

    public double calcularMediaAvaliacoes() {
        int soma = 0;
        for (Critica critica : criticas) {
            soma += critica.getAvaliacao();
        }
        return criticas.isEmpty() ? 0 : (double) soma / criticas.size();
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Diretor: " + diretor + ", Gênero: " + genero + ", Classificação Indicativa: " + classificacaoIndicativa;
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoFilmes {
    private List<Filme> filmes;

    public SistemaGerenciamentoFilmes() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void adicionarCritica(String tituloFilme, Critica critica) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(tituloFilme)) {
                filme.adicionarCritica(critica);
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    public void listarFilmes() {
        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    public void listarCriticas(String tituloFilme) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(tituloFilme)) {
                System.out.println("Críticas para " + tituloFilme + ":");
                for (Critica critica : filme.getCriticas()) {
                    System.out.println(critica);
                }
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    public void recomendarFilmes(String genero) {
        System.out.println("Filmes recomendados no gênero " + genero + ":");
        for (Filme filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(filme);
            }
        }
    }

    public static void main(String[] args) {
        SistemaGerenciamentoFilmes sistema = new SistemaGerenciamentoFilmes();
        Scanner scanner = new Scanner(System.in);

        
        List<String> elenco1 = List.of("Ator 1", "Atriz 1");
        List<String> elenco2 = List.of("Ator 2", "Atriz 2");

        sistema.adicionarFilme(new Filme("Filme 1", "Diretor 1", elenco1, "Ação", "12 anos"));
        sistema.adicionarFilme(new Filme("Filme 2", "Diretor 2", elenco2, "Comédia", "14 anos"));

        sistema.listarFilmes();

        sistema.adicionarCritica("Filme 1", new Critica("Usuario1", 4, "Ótimo filme!"));
        sistema.adicionarCritica("Filme 1", new Critica("Usuario2", 5, "Excelente!"));

        sistema.listarCriticas("Filme 1");

        sistema.recomendarFilmes("Ação");
        sistema.recomendarFilmes("Comédia");

        System.out.println("Média de avaliações de Filme 1: " + sistema.filmes.get(0).calcularMediaAvaliacoes());
    }
}