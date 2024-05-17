public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPay();

    public void printPay() {
        System.out.println(name + ": " + getPay());
    }

    public abstract void insertData();
}



import java.util.Scanner;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return salary;
    }

    @Override
    public void insertData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o salário: ");
        setSalary(scanner.nextDouble());
    }
}



import java.util.Scanner;

public class Hourly extends Employee {
    private double hourlyRate;
    private double hours;

    public Hourly(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = 0;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHours() {
        return hours;
    }

    public void addHours(double hours) {
        this.hours += hours;
    }

    @Override
    public double getPay() {
        return hourlyRate * hours;
    }

    @Override
    public void insertData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a taxa horária: ");
        setHourlyRate(scanner.nextDouble());
        System.out.print("Digite o número de horas trabalhadas: ");
        addHours(scanner.nextDouble());
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("1. Adicionar Empregado Assalariado");
            System.out.println("2. Adicionar Empregado Horista");
            System.out.println("3. Calcular Folha Salarial");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do empregado assalariado: ");
                    String salariedName = scanner.nextLine();
                    Salaried salaried = new Salaried(salariedName, 0);
                    salaried.insertData();
                    employees.add(salaried);
                    break;
                case 2:
                    System.out.print("Digite o nome do empregado horista: ");
                    String hourlyName = scanner.nextLine();
                    Hourly hourly = new Hourly(hourlyName, 0);
                    hourly.insertData();
                    employees.add(hourly);
                    break;
                case 3:
                    double totalPayroll = 0;
                    for (Employee employee : employees) {
                        employee.printPay();
                        totalPayroll += employee.getPay();
                    }
                    System.out.println("Gasto total com a folha salarial: " + totalPayroll);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}