package ohtu.verkkokauppa;

import ohtu.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {
    @Autowired
    private VarastoInterfaasi varasto;
    @Autowired
    private PankkiInterfaasi pankki;
    private Ostoskori ostoskori;
    @Autowired
    private ViitegeneraattoriInterfaasi viitegeneraattori;
    private String kaupanTili;
    
    
    public Kauppa() {
        kaupanTili = "33333-44455";
    }

    public Kauppa(VarastoInterfaasi varasto, PankkiInterfaasi pankki, ViitegeneraattoriInterfaasi viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }
    

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
