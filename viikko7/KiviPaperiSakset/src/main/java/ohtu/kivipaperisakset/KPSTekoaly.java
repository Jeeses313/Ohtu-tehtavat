package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Peli {

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly = new Tekoaly();
    
    public KPSTekoaly() {
    }

    @Override
    protected String teeTokanSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}