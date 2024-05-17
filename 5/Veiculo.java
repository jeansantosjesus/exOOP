public abstract class Veiculo {
    protected String placa;
    protected long horaEntrada;
    protected long horaSaida;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setHoraEntrada(long horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSaida(long horaSaida) {
        this.horaSaida = horaSaida;
    }

    public abstract double calcularTarifa();
}


public class Carro extends Veiculo {
    private static final double TARIFA_POR_HORA = 5.0;

    public Carro(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifa() {
        long duracao = (horaSaida - horaEntrada) / (1000 * 60 * 60); // duração em horas
        return duracao * TARIFA_POR_HORA;
    }
}


public class Moto extends Veiculo {
    private static final double TARIFA_POR_HORA = 3.0;

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifa() {
        long duracao = (horaSaida - horaEntrada) / (1000 * 60 * 60); // duração em horas
        return duracao * TARIFA_POR_HORA;
    }
}


public class Caminhao extends Veiculo {
    private static final double TARIFA_POR_HORA = 10.0;

    public Caminhao(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifa() {
        long duracao = (horaSaida - horaEntrada) / (1000 * 60 * 60); // duração em horas
        return duracao * TARIFA_POR_HORA;
    }
}


import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Veiculo> veiculosEstacionados;
    private List<Veiculo> veiculosDoDia;
    private double lucroDoDia;

    public Estacionamento() {
        this.veiculosEstacionados = new ArrayList<>();
        this.veiculosDoDia = new ArrayList<>();
        this.lucroDoDia = 0.0;
    }

    public void entradaVeiculo(Veiculo veiculo) {
        veiculo.setHoraEntrada(System.currentTimeMillis());
        veiculosEstacionados.add(veiculo);
    }

    public void saidaVeiculo(String placa) {
        for (Veiculo veiculo : veiculosEstacionados) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida(System.currentTimeMillis());
                double tarifa = veiculo.calcularTarifa();
                lucroDoDia += tarifa;
                veiculosDoDia.add(veiculo);
                veiculosEstacionados.remove(veiculo);
                System.out.println("Veículo " + placa + " saiu. Tarifa: R$ " + tarifa);
                return;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado.");
    }

    public void listarVeiculosDoDia() {
        System.out.println("Veículos que entraram e saíram hoje:");
        for (Veiculo veiculo : veiculosDoDia) {
            System.out.println("Placa: " + veiculo.getPlaca());
        }
    }

    public void listarVeiculosEstacionados() {
        System.out.println("Veículos estacionados:");
        for (Veiculo veiculo : veiculosEstacionados) {
            System.out.println("Placa: " + veiculo.getPlaca());
        }
    }

    public double getLucroDoDia() {
        return lucroDoDia;
    }
}


import java.util.Scanner;

public class SistemaGerenciamentoEstacionamento {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Entrada de veículo");
            System.out.println("2. Saída de veículo");
            System.out.println("3. Listar veículos estacionados");
            System.out.println("4. Listar veículos do dia");
            System.out.println("5. Ver lucro do dia");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo de veículo (carro, moto, caminhao): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();

                    Veiculo veiculo;
                    switch (tipo.toLowerCase()) {
                        case "carro":
                            veiculo = new Carro(placa);
                            break;
                        case "moto":
                            veiculo = new Moto(placa);
                            break;
                        case "caminhao":
                            veiculo = new Caminhao(placa);
                            break;
                        default:
                            System.out.println("Tipo de veículo inválido.");
                            continue;
                    }

                    estacionamento.entradaVeiculo(veiculo);
                    System.out.println("Veículo " + placa + " entrou.");
                    break;

                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    String placaSaida = scanner.nextLine();
                    estacionamento.saidaVeiculo(placaSaida);
                    break;

                case 3:
                    estacionamento.listarVeiculosEstacionados();
                    break;

                case 4:
                    estacionamento.listarVeiculosDoDia();
                    break;

                case 5:
                    System.out.println("Lucro do dia: R$ " + estacionamento.getLucroDoDia());
                    break;

                case 6:
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}