package fontes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número total de cavalos na corrida: ");
        int numCavalos = scanner.nextInt();

        String[] nomesCavalos = new String[numCavalos];
        char[] caracteresCavalos = new char[numCavalos];
        String[] apostadores = new String[numCavalos];

        for (int i = 0; i < numCavalos; i++) {
            System.out.println("\nCavalo " + (i + 1));
            System.out.print("Nome do cavalo: ");
            nomesCavalos[i] = scanner.next();

            System.out.print("Caracter do cavalo: ");
            caracteresCavalos[i] = scanner.next().charAt(0);

            System.out.print("Nome do apostador: ");
            apostadores[i] = scanner.next();
        }

        Corrida corrida = new Corrida();
        corrida.iniciarCorrida(nomesCavalos);

        scanner.close();
    }
}