import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

abstract class Pessoa {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String titulacaoAcademica;
    private String instituicao;
    private String senha;

    public Pessoa(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.titulacaoAcademica = titulacaoAcademica;
        this.instituicao = instituicao;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}

class Participante extends Pessoa {
    private boolean inscricaoValidada;

    public Participante(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
        this.inscricaoValidada = false;
    }

    public boolean isInscricaoValidada() {
        return inscricaoValidada;
    }

    public void validarInscricao() {
        this.inscricaoValidada = true;
    }

    public void invalidarInscricao() {
        this.inscricaoValidada = false;
    }
}

abstract class Organizador extends Pessoa {
    public Organizador(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
    }
}

class ProgramChair extends Organizador {
    public ProgramChair(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
    }
}

class GeneralChair extends Organizador {
    public GeneralChair(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
    }
}

abstract class Especialista extends Pessoa {
    private String areaEspecialidade;

    public Especialista(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha, String areaEspecialidade) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha);
        this.areaEspecialidade = areaEspecialidade;
    }

    public String getAreaEspecialidade() {
        return areaEspecialidade;
    }
}

class Autor extends Especialista {
    public Autor(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha, String areaEspecialidade) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha, areaEspecialidade);
    }
}

class Revisor extends Especialista {
    public Revisor(String cpf, String nome, Date dataNascimento, String titulacaoAcademica, String instituicao, String senha, String areaEspecialidade) {
        super(cpf, nome, dataNascimento, titulacaoAcademica, instituicao, senha, areaEspecialidade);
    }
}

class Artigo {
    private int id;
    private String titulo;
    private String abstractText;
    private String palavrasChave;
    private int quantidadePaginas;
    private Date dataSubmissao;
    private List<Autor> autores;
    private List<Revisor> revisores;
    private List<String> avaliacoes;
    private boolean aceito;

    public Artigo(int id, String titulo, String abstractText, String palavrasChave, int quantidadePaginas, Date dataSubmissao) {
        this.id = id;
        this.titulo = titulo;
        this.abstractText = abstractText;
        this.palavrasChave = palavrasChave;
        this.quantidadePaginas = quantidadePaginas;
        this.dataSubmissao = dataSubmissao;
        this.autores = new ArrayList<>();
        this.revisores = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.aceito = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public Date getDataSubmissao() {
        return dataSubmissao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Revisor> getRevisores() {
        return revisores;
    }

    public List<String> getAvaliacoes() {
        return avaliacoes;
    }

    public void adicionarAutor(Autor autor) {
        if (autores.size() < 5) {
            autores.add(autor);
        }
    }

    public void adicionarRevisor(Revisor revisor) {
        if (revisores.size() < 5) {
            revisores.add(revisor);
        }
    }

    public void adicionarAvaliacao(String avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public boolean isAceito() {
        return aceito;
    }

    public void aceitar() {
        this.aceito = true;
    }

    public void rejeitar() {
        this.aceito = false;
    }
}

class CBPOOSystem {
    private List<Participante> participantes;
    private List<Organizador> organizadores;
    private List<Especialista> especialistas;
    private List<Artigo> artigos;
    private Pessoa usuarioAtual;
    private Scanner scanner;

    public CBPOOSystem() {
        this.participantes = new ArrayList<>();
        this.organizadores = new ArrayList<>();
        this.especialistas = new ArrayList<>();
        this.artigos = new ArrayList<>();
        this.usuarioAtual = null;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Fazer login");
            System.out.println("2. Inscrever participante");
            System.out.println("3. Validar inscrição de participante (General Chair)");
            System.out.println("4. Invalidar inscrição de participante (General Chair)");
            System.out.println("5. Emitir certificado para participante (General Chair)");
            System.out.println("6. Submeter artigo");
            System.out.println("7. Enviar avaliação de artigo (Revisor)");
            System.out.println("8. Ver avaliações de um artigo");
            System.out.println("9. Aceitar artigo (Program Chair)");
            System.out.println("10. Rejeitar artigo (Program Chair)");
            System.out.println("11. Listar artigos aceitos em ordem alfabética");
            System.out.println("12. Listar artigos negados em ordem alfabética");
            System.out.println("13. Ver dados de um artigo");
            System.out.println("14. Listar participantes do evento em ordem alfabética");
            System.out.println("15. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    inscreverParticipante();
                    break;
                case 3:
                    if (usuarioAtual instanceof GeneralChair) {
                        validarInscricaoParticipante();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 4:
                    if (usuarioAtual instanceof GeneralChair) {
                        invalidarInscricaoParticipante();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 5:
                    if (usuarioAtual instanceof GeneralChair) {
                        emitirCertificado();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 6:
                    submeterArtigo();
                    break;
                case 7:
                    if (usuarioAtual instanceof Revisor) {
                        enviarAvaliacao();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 8:
                    verAvaliacoes();
                    break;
                case 9:
                    if (usuarioAtual instanceof ProgramChair) {
                        aceitarArtigo();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 10:
                    if (usuarioAtual instanceof ProgramChair) {
                        rejeitarArtigo();
                    } else {
                        System.out.println("Acesso negado.");
                    }
                    break;
                case 11:
                    listarArtigosAceitos();
                    break;
                case 12:
                    listarArtigosNegados();
                    break;
                case 13:
                    verDadosArtigo();
                    break;
                case 14:
                    listarParticipantes();
                    break;
                case 15:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void fazerLogin() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        usuarioAtual = autenticarUsuario(cpf, senha);
        if (usuarioAtual != null) {
            System.out.println("Login bem-sucedido.");
        } else {
            System.out.println("CPF ou senha incorretos.");
        }
    }

    private Pessoa autenticarUsuario(String cpf, String senha) {
        for (Participante p : participantes) {
            if (p.getCpf().equals(cpf) && p.verificarSenha(senha)) {
                return p;
            }
        }
        for (Organizador o : organizadores) {
            if (o.getCpf().equals(cpf) && o.verificarSenha(senha)) {
                return o;
            }
        }
        for (Especialista e : especialistas) {
            if (e.getCpf().equals(cpf) && e.verificarSenha(senha)) {
                return e;
            }
        }
        return null;
    }

    private void inscreverParticipante() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        Date dataNascimento = new Date(scanner.nextLine());
        System.out.print("Titulação Acadêmica: ");
        String titulacao = scanner.nextLine();
        System.out.print("Instituição: ");
        String instituicao = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Participante participante = new Participante(cpf, nome, dataNascimento, titulacao, instituicao, senha);
        participantes.add(participante);
        System.out.println("Inscrição pendente de validação.");
    }

    private void validarInscricaoParticipante() {
        System.out.print("CPF do participante: ");
        String cpf = scanner.nextLine();
        Participante participante = buscarParticipante(cpf);
        if (participante != null) {
            participante.validarInscricao();
            System.out.println("Inscrição validada.");
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private void invalidarInscricaoParticipante() {
        System.out.print("CPF do participante: ");
        String cpf = scanner.nextLine();
        Participante participante = buscarParticipante(cpf);
        if (participante != null) {
            participante.invalidarInscricao();
            System.out.println("Inscrição invalidada.");
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    private void emitirCertificado() {
        System.out.print("CPF do participante: ");
        String cpf = scanner.nextLine();
        Participante participante = buscarParticipante(cpf);
        if (participante != null && participante.isInscricaoValidada()) {
            System.out.println("Certificado emitido para " + participante.getNome());
        } else {
            System.out.println("Participante não encontrado ou inscrição não validada.");
        }
    }

    private Participante buscarParticipante(String cpf) {
        for (Participante p : participantes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    private void submeterArtigo() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Abstract: ");
        String abstractText = scanner.nextLine();
        System.out.print("Palavras-Chave: ");
        String palavrasChave = scanner.nextLine();
        System.out.print("Quantidade de Páginas: ");
        int quantidadePaginas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data de Submissão (dd/MM/yyyy): ");
        Date dataSubmissao = new Date(scanner.nextLine());
        Artigo artigo = new Artigo(id, titulo, abstractText, palavrasChave, quantidadePaginas, dataSubmissao);

        System.out.print("Quantidade de Autores: ");
        int quantidadeAutores = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < quantidadeAutores; i++) {
            System.out.print("CPF do Autor " + (i + 1) + ": ");
            String cpfAutor = scanner.nextLine();
            Autor autor = buscarAutor(cpfAutor);
            if (autor != null) {
                artigo.adicionarAutor(autor);
            } else {
                System.out.println("Autor não encontrado.");
            }
        }

        artigos.add(artigo);
        System.out.println("Artigo submetido.");
    }

    private Autor buscarAutor(String cpf) {
        for (Especialista e : especialistas) {
            if (e instanceof Autor && e.getCpf().equals(cpf)) {
                return (Autor) e;
            }
        }
        return null;
    }

    private void enviarAvaliacao() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Avaliação: ");
        String avaliacao = scanner.nextLine();
        Artigo artigo = buscarArtigo(id);
        if (artigo != null && artigo.getRevisores().contains((Revisor) usuarioAtual)) {
            artigo.adicionarAvaliacao(avaliacao);
            System.out.println("Avaliação enviada.");
        } else {
            System.out.println("Artigo não encontrado ou acesso negado.");
        }
    }

    private Artigo buscarArtigo(int id) {
        for (Artigo a : artigos) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    private void verAvaliacoes() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Artigo artigo = buscarArtigo(id);
        if (artigo != null) {
            if (usuarioAtual instanceof ProgramChair) {
                for (String avaliacao : artigo.getAvaliacoes()) {
                    System.out.println("Avaliação: " + avaliacao);
                }
            } else if (usuarioAtual instanceof Revisor && artigo.getRevisores().contains((Revisor) usuarioAtual)) {
                for (String avaliacao : artigo.getAvaliacoes()) {
                    System.out.println("Avaliação: " + avaliacao);
                }
            } else if (usuarioAtual instanceof Autor && artigo.getAutores().contains((Autor) usuarioAtual)) {
                for (String avaliacao : artigo.getAvaliacoes()) {
                    System.out.println("Avaliação: " + avaliacao);
                }
            } else {
                System.out.println("Acesso negado.");
            }
        } else {
            System.out.println("Artigo não encontrado.");
        }
    }

    private void aceitarArtigo() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Artigo artigo = buscarArtigo(id);
        if (artigo != null) {
            artigo.aceitar();
            System.out.println("Artigo aceito.");
        } else {
            System.out.println("Artigo não encontrado.");
        }
    }

    private void rejeitarArtigo() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Artigo artigo = buscarArtigo(id);
        if (artigo != null) {
            artigo.rejeitar();
            System.out.println("Artigo rejeitado.");
        } else {
            System.out.println("Artigo não encontrado.");
        }
    }

    private void listarArtigosAceitos() {
        List<Artigo> artigosAceitos = artigos.stream().filter(Artigo::isAceito).collect(Collectors.toList());
        artigosAceitos.sort((a1, a2) -> a1.getTitulo().compareToIgnoreCase(a2.getTitulo()));
        for (Artigo artigo : artigosAceitos) {
            System.out.println("ID: " + artigo.getId() + ", Título: " + artigo.getTitulo());
        }
    }

    private void listarArtigosNegados() {
        List<Artigo> artigosNegados = artigos.stream().filter(a -> !a.isAceito()).collect(Collectors.toList());
        artigosNegados.sort((a1, a2) -> a1.getTitulo().compareToIgnoreCase(a2.getTitulo()));
        for (Artigo artigo : artigosNegados) {
            System.out.println("ID: " + artigo.getId() + ", Título: " + artigo.getTitulo());
        }
    }

    private void verDadosArtigo() {
        System.out.print("ID do Artigo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Artigo artigo = buscarArtigo(id);
        if (artigo != null) {
            System.out.println("Título: " + artigo.getTitulo());
            System.out.println("Abstract: " + artigo.getAbstractText());
            System.out.println("Palavras-Chave: " + artigo.getPalavrasChave());
            System.out.println("Quantidade de Páginas: " + artigo.getQuantidadePaginas());
            System.out.println("Data de Submissão: " + artigo.getDataSubmissao());
        } else {
            System.out.println("Artigo não encontrado.");
        }
    }

    private void listarParticipantes() {
        List<Participante> participantesValidos = participantes.stream().filter(Participante::isInscricaoValidada).collect(Collectors.toList());
        participantesValidos.sort((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
        for (Participante participante : participantesValidos) {
            System.out.println("CPF: " + participante.getCpf() + ", Nome: " + participante.getNome());
        }
    }

    public static void main(String[] args) {
        CBPOOSystem sistema = new CBPOOSystem();
        sistema.menu();
    }
}
