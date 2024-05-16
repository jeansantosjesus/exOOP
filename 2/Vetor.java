public class Vetor {
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidadeInicial) {
        elementos = new String[capacidadeInicial];
        tamanho = 0;
    }

    public void insert(String elemento) {
        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public String get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }
        return elementos[posicao];
    }

    public int size() {
        return tamanho;
    }

    private void aumentarCapacidade() {
        String[] novosElementos = new String[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novosElementos[i] = elementos[i];
        }
        elementos = novosElementos;
    }
}


public class Main {

    public static void main(String[] args) {
        Vetor vetor = new Vetor(2);

        vetor.insert("Elemento 1");
        vetor.insert("Elemento 2");
        vetor.insert("Elemento 3");

        System.out.println("Tamanho atual do vetor: " + vetor.size());
        System.out.println("Elemento na posição 0: " + vetor.get(0));
        System.out.println("Elemento na posição 1: " + vetor.get(1));
        System.out.println("Elemento na posição 2: " + vetor.get(2));
        System.out.println("Elemento na posição 3: " + vetor.get(3));
    }

}
