package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Peli {
    private static final Scanner scanner = new Scanner(System.in);
    private String ekanSiirto;
    private String tokanSiirto;
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        teeSiirrot();
        while(onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();  
            teeSiirrot();
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    };
    
    private void teeSiirrot() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
        tokanSiirto = teeTokanSiirto(ekanSiirto);
    }
    
    protected abstract String teeTokanSiirto(String ekanSiirto);
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
