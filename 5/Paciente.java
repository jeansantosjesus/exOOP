import java.util.ArrayList;
import java.util.List;

class Paciente {
    private String nome;
    private String email;

    public Paciente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

class Especialidade {
    private String nome;

    public Especialidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Medico {
    private String nome;
    private Especialidade especialidade;
    private List&lt;Consulta&gt; agenda;

    public Medico(String nome, Especialidade especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.agenda = new ArrayList&lt;&gt;();
    }

    public String getNome() {
        return nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public boolean verificarDisponibilidade(String horario) {
        for (Consulta consulta : agenda) {
            if (consulta.getHorario().equals(horario)) {
                return false;
            }
        }
        return true;
    }

    public void adicionarConsulta(Consulta consulta) {
        agenda.add(consulta);
    }
}

class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String horario;
    private String tipo;

    public Consulta(Paciente paciente, Medico medico, String horario, String tipo) {
        this.paciente = paciente;
        this.medico = medico;
        this.horario = horario;
        this.tipo = tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }
}

class SistemaAgendamento {
    private List&lt;Paciente&gt; pacientes;
    private List&lt;Medico&gt; medicos;

    public SistemaAgendamento() {
        this.pacientes = new ArrayList&lt;&gt;();
        this.medicos = new ArrayList&lt;&gt;();
    }

    public Paciente cadastrarPaciente(String nome, String email) {
        Paciente paciente = new Paciente(nome, email);
        pacientes.add(paciente);
        return paciente;
    }

    public Medico cadastrarMedico(String nome, Especialidade especialidade) {
        Medico medico = new Medico(nome, especialidade);
        medicos.add(medico);
        return medico;
    }

    public Consulta agendarConsulta(Paciente paciente, Medico medico, String horario, String tipo) {
        if (medico.verificarDisponibilidade(horario)) {
            Consulta consulta = new Consulta(paciente, medico, horario, tipo);
            medico.adicionarConsulta(consulta);
            return consulta;
        } else {
            return null;
        }
    }

    public void enviarLembrete(Consulta consulta) {
        System.out.println("Lembrete: Consulta " + consulta.getTipo() + " agendada para " + consulta.getHorario() +
                " com Dr(a). " + consulta.getMedico().getNome() + " para o paciente " + consulta.getPaciente().getNome() + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaAgendamento sistema = new SistemaAgendamento();

        Especialidade cardiologia = new Especialidade("Cardiologia");
        Especialidade dermatologia = new Especialidade("Dermatologia");

        Medico medico1 = sistema.cadastrarMedico("Dr. João", cardiologia);
        Medico medico2 = sistema.cadastrarMedico("Dra. Maria", dermatologia);

        Paciente paciente1 = sistema.cadastrarPaciente("Ana Silva", "ana.silva@example.com");
        Paciente paciente2 = sistema.cadastrarPaciente("Carlos Sousa", "carlos.sousa@example.com");

        Consulta consulta1 = sistema.agendarConsulta(paciente1, medico1, "2024-05-20 10:00", "Presencial");
        Consulta consulta2 = sistema.agendarConsulta(paciente2, medico2, "2024-05-21 14:00", "Telemedicina");

        if (consulta1 != null) {
            sistema.enviarLembrete(consulta1);
        } else {
            System.out.println("Não foi possível agendar a consulta para Ana Silva.");
        }

        if (consulta2 != null) {
            sistema.enviarLembrete(consulta2);
        } else {
            System.out.println("Não foi possível agendar a consulta para Carlos Sousa.");
        }
    }
}