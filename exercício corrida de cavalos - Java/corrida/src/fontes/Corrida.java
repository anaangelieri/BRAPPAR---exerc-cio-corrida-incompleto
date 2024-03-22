package fontes;

import java.util.ArrayList;
import java.util.List;

public class Corrida {
    private List<String> cavalos;
    private String vencedor;

    public Corrida() {
        this.cavalos = new ArrayList<>();
    }

    public synchronized void cruzouLinhaChegada(String cavalo) {
        if (vencedor == null) {
            vencedor = cavalo;
            System.out.println("\nO vencedor é: " + cavalo);
        }
    }

    public void iniciarCorrida(String[] nomesCavalos) {
        System.out.println("A corrida começou!\n");

        Thread[] threadsCavalos = new Thread[nomesCavalos.length];

        for (int i = 0; i < nomesCavalos.length; i++) {
            Cavalo c = new Cavalo(nomesCavalos[i], this);
            cavalos.add(nomesCavalos[i]);
            threadsCavalos[i] = new Thread(c);
            threadsCavalos[i].start();
        }

        for (Thread t : threadsCavalos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
