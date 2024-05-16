//Classe Aluno

import java.time.LocalDate;

public class Aluno {
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;

    public Aluno(String nome, String matricula, LocalDate dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Matrícula: " + matricula + ", Data de Nascimento: " + dataNascimento;
    }
}


//Classe Turma

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private String nomeDisciplina;
    private List<Aluno> alunos;

    public Turma(String codigo, String nomeDisciplina) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.alunos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Disciplina: " + nomeDisciplina;
    }
}


//Classe DiaAula

import java.time.LocalDateTime;

public class DiaAula {
    private LocalDateTime dataHora;
    private Turma turma;
    private String conteudoMinistrado;

    public DiaAula(LocalDateTime dataHora, Turma turma, String conteudoMinistrado) {
        this.dataHora = dataHora;
        this.turma = turma;
        this.conteudoMinistrado = conteudoMinistrado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Turma getTurma() {
        return turma;
    }

    public String getConteudoMinistrado() {
        return conteudoMinistrado;
    }

    @Override
    public String toString() {
        return "Data e Hora: " + dataHora + ", Turma: " + turma + ", Conteúdo Ministrado: " + conteudoMinistrado;
    }
}


//Classe Frequencia

public class Frequencia {
    private Aluno aluno;
    private DiaAula diaAula;
    private boolean presente;

    public Frequencia(Aluno aluno, DiaAula diaAula, boolean presente) {
        this.aluno = aluno;
        this.diaAula = diaAula;
        this.presente = presente;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public DiaAula getDiaAula() {
        return diaAula;
    }

    public boolean isPresente() {
        return presente;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.getNome() + ", Dia Aula: " + diaAula.getDataHora() + ", Presente: " + presente;
    }
}


//Classe Nota


public class Nota {
    private Aluno aluno;
    private Turma turma;
    private double valor;

    public Nota(Aluno aluno, Turma turma, double valor) {
        this.aluno = aluno;
        this.turma = turma;
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.getNome() + ", Turma: " + turma.getCodigo() + ", Nota: " + valor;
    }
}


//Classe Principal com Menu


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDiario {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<DiaAula> diasAula = new ArrayList<>();
    private List<Frequencia> frequencias = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();

    public static void main(String[] args) {
        SistemaDiario sistema = new SistemaDiario();
        sistema.executar();
    }

    private void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    registrarAluno(scanner);
                    break;
                case 2:
                    registrarTurma(scanner);
                    break;
                case 3:
                    registrarDiaAula(scanner);
                    break;
                case 4:
                    registrarNota(scanner);
                    break;
                case 5:
                    registrarFrequencia(scanner);
                    break;
                case 6:
                    identificarAlunosPresentes(scanner);
                    break;
                case 7:
                    mostrarFrequenciaAluno(scanner);
                    break;
                case 8:
                    mostrarNotaAluno(scanner);
                    break;
                case 9:
                    listarAlunosTurma(scanner);
                    break;
                case 10:
                    listarTurmas();
                    break;
                case 11:
                    listarFrequenciasTurma(scanner);
                    break;
                case 12:
                    listarNotasTurma(scanner);
                    break;
                case 13:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 13);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Registrar um aluno");
        System.out.println("2. Registrar uma turma");
        System.out.println("3. Registrar um dia-aula");
        System.out.println("4. Registrar uma nota");
        System.out.println("5. Registrar uma frequência");
        System.out.println("6. Identificar alunos presentes em um dia-aula e turma");
        System.out.println("7. Mostrar quantidade de presenças e faltas de um aluno em uma turma");
        System.out.println("8. Mostrar a nota de um aluno em uma turma");
        System.out.println("9. Listar os alunos inscritos em uma turma");
        System.out.println("10. Listar as turmas");
        System.out.println("11. Listar total de faltas e presenças por aluno em uma turma");
        System.out.println("12. Listar notas por aluno em uma turma");
        System.out.println("13. Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }

    private void registrarAluno(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Data de Nascimento (yyyy-MM-dd): ");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        Aluno aluno = new Aluno(nome, matricula, dataNascimento);
        alunos.add(aluno);
        System.out.println("Aluno registrado com sucesso!");
    }

    private void registrarTurma(Scanner scanner) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome da Disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        Turma turma = new Turma(codigo, nomeDisciplina);
        turmas.add(turma);
        System.out.println("Turma registrada com sucesso!");
    }

    private void registrarDiaAula(Scanner scanner) {
        System.out.print("Data e Hora (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();
        System.out.print("Conteúdo Ministrado: ");
        String conteudoMinistrado = scanner.nextLine();

        Turma turma = encontrarTurma(codigoTurma);
        if (turma != null) {
            DiaAula diaAula = new DiaAula(dataHora, turma, conteudoMinistrado);
            diasAula.add(diaAula);
            System.out.println("Dia-aula registrado com sucesso!");
        } else {
            System.out.println("Turma não encontrada!");
        }
    }

    private void registrarNota(Scanner scanner) {
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();
        System.out.print("Nota: ");
        double valor = scanner.nextDouble();

        Aluno aluno = encontrarAluno(matricula);
        Turma turma = encontrarTurma(codigoTurma);
        if (aluno != null && turma != null) {
            Nota nota = new Nota(aluno, turma, valor);
            notas.add(nota);
            System.out.println("Nota registrada com sucesso!");
        } else {
            System.out.println("Aluno ou Turma não encontrada!");
        }
    }

    private void registrarFrequencia(Scanner scanner) {
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Data e Hora da Aula (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Aluno aluno = encontrarAluno(matricula);
        DiaAula diaAula = encontrarDiaAula(dataHora);
        if (aluno != null && diaAula != null) {
            System.out.print("Presente (true/false): ");
            boolean presente = scanner.nextBoolean();

            Frequencia frequencia = new Frequencia(aluno, diaAula, presente);
            frequencias.add(frequencia);
            System.out.println("Frequência registrada com sucesso!");
        } else {
            System.out.println("Aluno ou Dia-aula não encontrado!");
        }
    }

    private void identificarAlunosPresentes(Scanner scanner) {
        System.out.print("Data e Hora da Aula (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        DiaAula diaAula = encontrarDiaAula(dataHora);
        if (diaAula != null && diaAula.getTurma().getCodigo().equals(codigoTurma)) {
            System.out.println("Alunos presentes:");
            for (Frequencia frequencia : frequencias) {
                if (frequencia.getDiaAula().equals(diaAula) && frequencia.isPresente()) {
                    System.out.println(frequencia.getAluno().getNome());
                }
            }
        } else {
            System.out.println("Turma ou Dia-aula não encontrado!");
        }
    }

    private void mostrarFrequenciaAluno(Scanner scanner) {
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Aluno aluno = encontrarAluno(matricula);
        Turma turma = encontrarTurma(codigoTurma);
        if (aluno != null && turma != null) {
            int presencas = 0;
            int faltas = 0;
            for (Frequencia frequencia : frequencias) {
                if (frequencia.getAluno().equals(aluno) && frequencia.getDiaAula().getTurma().equals(turma)) {
                    if (frequencia.isPresente()) {
                        presencas++;
                    } else {
                        faltas++;
                    }
                }
            }
            System.out.println("Presenças: " + presencas + ", Faltas: " + faltas);
        } else {
            System.out.println("Aluno ou Turma não encontrado!");
        }
    }

    private void mostrarNotaAluno(Scanner scanner) {
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Aluno aluno = encontrarAluno(matricula);
        Turma turma = encontrarTurma(codigoTurma);
        if (aluno != null && turma != null) {
            for (Nota nota : notas) {
                if (nota.getAluno().equals(aluno) && nota.getTurma().equals(turma)) {
                    System.out.println("Nota: " + nota.getValor());
                    return;
                }
            }
            System.out.println("Nota não encontrada!");
        } else {
            System.out.println("Aluno ou Turma não encontrado!");
        }
    }

    private void listarAlunosTurma(Scanner scanner) {
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Turma turma = encontrarTurma(codigoTurma);
        if (turma != null) {
            System.out.println("Alunos na Turma:");
            for (Aluno aluno : turma.getAlunos()) {
                System.out.println(aluno.getNome());
            }
        } else {
            System.out.println("Turma não encontrada!");
        }
    }

    private void listarTurmas() {
        System.out.println("Turmas:");
        for (Turma turma : turmas) {
            System.out.println(turma);
        }
    }

    private void listarFrequenciasTurma(Scanner scanner) {
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Turma turma = encontrarTurma(codigoTurma);
        if (turma != null) {
            System.out.println("Frequências na Turma:");
            for (Aluno aluno : turma.getAlunos()) {
                int presencas = 0;
                int faltas = 0;
                for (Frequencia frequencia : frequencias) {
                    if (frequencia.getAluno().equals(aluno) && frequencia.getDiaAula().getTurma().equals(turma)) {
                        if (frequencia.isPresente()) {
                            presencas++;
                        } else {
                            faltas++;
                        }
                    }
                }
                System.out.println(aluno.getNome() + " - Presenças: " + presencas + ", Faltas: " + faltas);
            }
        } else {
            System.out.println("Turma não encontrada!");
        }
    }

    private void listarNotasTurma(Scanner scanner) {
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Turma turma = encontrarTurma(codigoTurma);
        if (turma != null) {
            System.out.println("Notas na Turma:");
            for (Nota nota : notas) {
                if (nota.getTurma().equals(turma)) {
                    System.out.println(nota.getAluno().getNome() + " - Nota: " + nota.getValor());
                }
            }
        } else {
            System.out.println("Turma não encontrada!");
        }
    }

    private Aluno encontrarAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    private Turma encontrarTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    private DiaAula encontrarDiaAula(LocalDateTime dataHora) {
        for (DiaAula diaAula : diasAula) {
            if (diaAula.getDataHora().equals(dataHora)) {
                return diaAula;
            }
        }
        return null;
    }
}