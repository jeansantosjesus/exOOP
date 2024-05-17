import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class Veiculo {
    private String modelo;
    private String placa;
    private int anoFabricacao;
    private double capacidadeCarga;
    private List&lt;Manutencao&gt; manutencoes;
    private List&lt;Entrega&gt; entregas;

    public Veiculo(String modelo, String placa, int anoFabricacao, double capacidadeCarga) {
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeCarga = capacidadeCarga;
        this.manutencoes = new ArrayList&lt;&gt;();
        this.entregas = new ArrayList&lt;&gt;();
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void adicionarManutencao(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }

    public void adicionarEntrega(Entrega entrega) {
        entregas.add(entrega);
    }

    public List&lt;Manutencao&gt; getManutencoes() {
        return manutencoes;
    }

    public List&lt;Entrega&gt; getEntregas() {
        return entregas;
    }
}

class Caminhao extends Veiculo {
    public Caminhao(String modelo, String placa, int anoFabricacao, double capacidadeCarga) {
        super(modelo, placa, anoFabricacao, capacidadeCarga);
    }
}

class Van extends Veiculo {
    public Van(String modelo, String placa, int anoFabricacao, double capacidadeCarga) {
        super(modelo, placa, anoFabricacao, capacidadeCarga);
    }
}

class Carro extends Veiculo {
    public Carro(String modelo, String placa, int anoFabricacao, double capacidadeCarga) {
        super(modelo, placa, anoFabricacao, capacidadeCarga);
    }
}

class Manutencao {
    private Date data;
    private String descricao;

    public Manutencao(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }
}

class Entrega {
    private Date data;
    private double carga;
    private String destino;
    private boolean urgente;

    public Entrega(Date data, double carga, String destino, boolean urgente) {
        this.data = data;
        this.carga = carga;
        this.destino = destino;
        this.urgente = urgente;
    }

    public Date getData() {
        return data;
    }

    public double getCarga() {
        return carga;
    }

    public String getDestino() {
        return destino;
    }

    public boolean isUrgente() {
        return urgente;
    }
}

class SistemaGestaoFrota {
    private List&lt;Veiculo&gt; frota;

    public SistemaGestaoFrota() {
        this.frota = new ArrayList&lt;&gt;();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        frota.add(veiculo);
    }

    public void registrarManutencao(Veiculo veiculo, Manutencao manutencao) {
        veiculo.adicionarManutencao(manutencao);
    }

    public boolean agendarEntrega(Veiculo veiculo, Entrega entrega) {
        if (veiculo.getCapacidadeCarga() &gt;= entrega.getCarga()) {
            veiculo.adicionarEntrega(entrega);
            return true;
        }
        return false;
    }

    public void rastrearVeiculo(Veiculo veiculo) {
        System.out.println("Rastreamento do Veículo: " + veiculo.getPlaca());
        System.out.println("Status das Entregas:");
        for (Entrega entrega : veiculo.getEntregas()) {
            System.out.println("Destino: " + entrega.getDestino() + ", Data: " + entrega.getData() + ", Urgente: " + entrega.isUrgente());
        }
    }

    public void gerarRelatorios() {
        System.out.println("Relatórios de Desempenho da Frota:");
        for (Veiculo veiculo : frota) {
            System.out.println("Veículo: " + veiculo.getPlaca() + " - " + veiculo.getModelo());
            System.out.println("Total de Manutenções: " + veiculo.getManutencoes().size());
            System.out.println("Total de Entregas: " + veiculo.getEntregas().size());
        }
    }

    public List&lt;Veiculo&gt; getFrota() {
        return frota;
    }

    public static void main(String[] args) {
        SistemaGestaoFrota sistema = new SistemaGestaoFrota();

        Veiculo caminhao1 = new Caminhao("Volvo FH", "ABC-1234", 2018, 30000);
        Veiculo van1 = new Van("Mercedes Sprinter", "XYZ-5678", 2020, 5000);
        Veiculo carro1 = new Carro("Fiat Toro", "DEF-9012", 2021, 1000);

        sistema.cadastrarVeiculo(caminhao1);
        sistema.cadastrarVeiculo(van1);
        sistema.cadastrarVeiculo(carro1);

        Manutencao manutencao1 = new Manutencao(new Date(), "Troca de óleo");
        sistema.registrarManutencao(caminhao1, manutencao1);

        Entrega entrega1 = new Entrega(new Date(), 20000, "São Paulo", true);
        boolean sucessoEntrega1 = sistema.agendarEntrega(caminhao1, entrega1);
        System.out.println("Agendamento de Entrega 1: " + (sucessoEntrega1 ? "Sucesso" : "Falha"));

        Entrega entrega2 = new Entrega(new Date(), 6000, "Rio de Janeiro", false);
        boolean sucessoEntrega2 = sistema.agendarEntrega(van1, entrega2);
        System.out.println("Agendamento de Entrega 2: " + (sucessoEntrega2 ? "Sucesso" : "Falha"));

        sistema.rastrearVeiculo(caminhao1);

        sistema.gerarRelatorios();
    }
}