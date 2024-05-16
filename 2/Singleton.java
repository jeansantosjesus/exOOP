public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Instância única de Singleton criada!");
    }
}

public class Main {

	public static void main(String[] args) {
        	Singleton singleton1 = Singleton.getInstance();
        	Singleton singleton2 = Singleton.getInstance();
        	System.out.println("singleton1 == singleton2: " + (singleton1 == singleton2));
        	singleton1.showMessage();
    }
}
