package ohtu.verkkokauppa;

import ohtu.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements PankkiInterfaasi {
    @Autowired
    private KirjanpitoInterfaasi kirjanpito;


    public Pankki(KirjanpitoInterfaasi kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    
    
    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
