package fontes;

public class Cavalo implements Runnable {
    private String nomeCavalo;
    private Corrida corrida;
    private static final int DISTANCIA_CORRIDA = 60;

    public Cavalo(String nomeCavalo, Corrida corrida) {
        this.nomeCavalo = nomeCavalo;
        this.corrida = corrida;
    }

    public void run() {
        for (int i = 0; i < DISTANCIA_CORRIDA; i++) {
            try {
                Thread.sleep((long) (Math.random() * 200)); // Tempo da corrida
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(nomeCavalo.charAt(0)); // Caractere para representar o cavalo
        }

        synchronized (this) {
            corrida.cruzouLinhaChegada(nomeCavalo);
        }
    }
}