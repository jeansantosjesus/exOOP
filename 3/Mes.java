public enum Mes {
    JANEIRO("Janeiro"),
    FEVEREIRO("Fevereiro"),
    MARCO("Março"),
    ABRIL("Abril"),
    MAIO("Maio"),
    JUNHO("Junho"),
    JULHO("Julho"),
    AGOSTO("Agosto"),
    SETEMBRO("Setembro"),
    OUTUBRO("Outubro"),
    NOVEMBRO("Novembro"),
    DEZEMBRO("Dezembro");

    private final String descricao;

    Mes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

class Compromisso {
    private Mes mes;
    private String descricao;

    public Compromisso(Mes mes, String descricao) {
        this.mes = mes;
        this.descricao = descricao;
    }

    public Mes getMes() {
        return mes;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "mes=" + mes.getDescricao() +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

public class Agenda {
    public static void main(String[] args) {
        Compromisso compromisso1 = new Compromisso(Mes.JANEIRO, "Consulta médica");
        Compromisso compromisso2 = new Compromisso(Mes.MARCO, "Reunião de trabalho");
        Compromisso compromisso3 = new Compromisso(Mes.JULHO, "Férias");

        System.out.println(compromisso1);
        System.out.println(compromisso2);
        System.out.println(compromisso3);
    }
}
