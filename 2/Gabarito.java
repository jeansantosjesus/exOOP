//Classe Gabarito

public class Gabarito {
    private char[] respostas;

    public Gabarito(char[] respostas) {
        if (respostas.length != 15) {
            throw new IllegalArgumentException("O gabarito deve conter exatamente 15 respostas.");
        }
        this.respostas = respostas;
    }

    public char respostaQuestao(int numeroQuestao) {
        if (numeroQuestao < 1 || numeroQuestao > 15) {
            throw new IllegalArgumentException("Número de questão inválido. Deve ser entre 1 e 15.");
        }
        return respostas[numeroQuestao - 1];
    }
}

//Classe Prova

public class Prova {
    private Gabarito gabarito;
    private char[] respostasAluno;
    private int questaoAtual;

    public Prova(Gabarito gabarito) {
        this.gabarito = gabarito;
        this.respostasAluno = new char[15];
        this.questaoAtual = 0;
    }

    public void respostaAluno(char resposta) {
        if (questaoAtual >= 15) {
            throw new IllegalStateException("Todas as questões já foram respondidas.");
        }
        respostasAluno[questaoAtual] = resposta;
        questaoAtual++;
    }

    public int acertos() {
        int acertos = 0;
        for (int i = 0; i < 15; i++) {
            if (respostasAluno[i] == gabarito.respostaQuestao(i + 1)) {
                acertos++;
            }
        }
        return acertos;
    }

    public double nota() {
        double nota = 0;
        for (int i = 0; i < 15; i++) {
            if (respostasAluno[i] == gabarito.respostaQuestao(i + 1)) {
                if (i < 10) {
                    nota += 0.5;
                } else {
                    nota += 1;
                }
            }
        }
        return nota;
    }

    public double maior(Prova outraProva) {
        int acertosEstaProva = this.acertos();
        int acertosOutraProva = outraProva.acertos();

        if (acertosEstaProva > acertosOutraProva) {
            return this.nota();
        } else if (acertosEstaProva < acertosOutraProva) {
            return outraProva.nota();
        } else {
            double notaEstaProva = this.nota();
            double notaOutraProva = outraProva.nota();

            if (notaEstaProva > notaOutraProva) {
                return notaEstaProva;
            } else if (notaEstaProva < notaOutraProva) {
                return notaOutraProva;
            } else {
                return notaEstaProva;
            }
        }
    }
}


//Classe Main

public class Main {
    public static void main(String[] args) {
        // Definindo o gabarito
        char[] respostasGabarito = {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};
        Gabarito gabarito = new Gabarito(respostasGabarito);

        // Criando uma prova para um aluno
        Prova prova1 = new Prova(gabarito);
        prova1.respostaAluno('A');
        prova1.respostaAluno('B');
        prova1.respostaAluno('C');
        prova1.respostaAluno('D');
        prova1.respostaAluno('E');
        prova1.respostaAluno('A');
        prova1.respostaAluno('B');
        prova1.respostaAluno('C');
        prova1.respostaAluno('D');
        prova1.respostaAluno('E');
        prova1.respostaAluno('A');
        prova1.respostaAluno('B');
        prova1.respostaAluno('C');
        prova1.respostaAluno('D');
        prova1.respostaAluno('E');

        // Criando uma outra prova para outro aluno
        Prova prova2 = new Prova(gabarito);
        prova2.respostaAluno('A');
        prova2.respostaAluno('B');
        prova2.respostaAluno('A');
        prova2.respostaAluno('D');
        prova2.respostaAluno('E');
        prova2.respostaAluno('A');
        prova2.respostaAluno('B');
        prova2.respostaAluno('C');
        prova2.respostaAluno('D');
        prova2.respostaAluno('E');
        prova2.respostaAluno('A');
        prova2.respostaAluno('B');
        prova2.respostaAluno('D');
        prova2.respostaAluno('D');
        prova2.respostaAluno('E');

        // Calculando e exibindo os resultados
        System.out.println("Nota do aluno 1: " + prova1.nota());
        System.out.println("Nota do aluno 2: " + prova2.nota());
        System.out.println("Aluno com maior nota: " + prova1.maior(prova2));
    }
}