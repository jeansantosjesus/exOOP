import java.util.HashMap;
import java.util.Map;

public class Aluno {
    private String nome;
    private int idade;
    private Turma turma;
    private Map<Disciplina, Double> notas;

    public Aluno(String nome, int idade, Turma turma) {
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
        this.notas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setNota(Disciplina disciplina, double nota) {
        notas.put(disciplina, nota);
    }

    public double getNota(Disciplina disciplina) {
        return notas.getOrDefault(disciplina, 0.0);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas.values()) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public boolean isAprovado() {
        return calcularMedia() >= 6.0;
    }
}


import java.util.List;

public class Professor {
    private String nome;
    private List<Disciplina> disciplinas;
    private int cargaHoraria;

    public Professor(String nome, List<Disciplina> disciplinas, int cargaHoraria) {
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void exibirHorarios() {
        System.out.println("Horários das disciplinas ministradas pelo professor " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome() + " - " + disciplina.getHorario());
        }
    }
}


public class Disciplina {
    private String nome;
    private String horario;

    public Disciplina(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }
}


import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private List<Aluno> alunos;

    public Turma(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void exibirInformacoes() {
        System.out.println("Turma: " + nome);
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + " - Idade: " + aluno.getIdade());
        }
    }

    public void listarAlunosAprovados() {
        System.out.println("Alunos aprovados da turma " + nome + ":");
        for (Aluno aluno : alunos) {
            if (aluno.isAprovado()) {
                System.out.println(aluno.getNome());
            }
        }
    }

    public void listarAlunosReprovados() {
        System.out.println("Alunos reprovados da turma " + nome + ":");
        for (Aluno aluno : alunos) {
            if (!aluno.isAprovado()) {
                System.out.println(aluno.getNome());
            }
        }
    }
}


import java.util.Arrays;

public class SistemaGerenciamentoEscola {
    public static void main(String[] args) {
        
        Disciplina matematica = new Disciplina("Matemática", "Segunda-feira 10:00");
        Disciplina portugues = new Disciplina("Português", "Terça-feira 11:00");
        Disciplina ciencia = new Disciplina("Ciências", "Quarta-feira 14:00");

       
        Professor profJoao = new Professor("João", Arrays.asList(matematica, ciencia), 20);
        Professor profMaria = new Professor("Maria", Arrays.asList(portugues), 10);


        Turma turmaA = new Turma("Turma A");

      
        Aluno aluno1 = new Aluno("Carlos", 15, turmaA);
        Aluno aluno2 = new Aluno("Ana", 14, turmaA);

        
        turmaA.adicionarAluno(aluno1);
        turmaA.adicionarAluno(aluno2);

        
        aluno1.setNota(matematica, 7.0);
        aluno1.setNota(portugues, 8.5);
        aluno1.setNota(ciencia, 6.0);

        aluno2.setNota(matematica, 5.0);
        aluno2.setNota(portugues, 4.5);
        aluno2.setNota(ciencia, 7.0);

        
        turmaA.exibirInformacoes();

        
        turmaA.listarAlunosAprovados();
        turmaA.listarAlunosReprovados();

        
        profJoao.exibirHorarios();
        profMaria.exibirHorarios();
    }
}