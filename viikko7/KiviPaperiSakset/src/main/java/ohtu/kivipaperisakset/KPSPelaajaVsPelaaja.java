package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Peli {

    private static final Scanner scanner = new Scanner(System.in);

    public KPSPelaajaVsPelaaja() {};

    @Override
    protected String teeTokanSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}