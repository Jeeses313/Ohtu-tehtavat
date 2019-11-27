package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    private TextField tulostekentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovelluslogiikka;
    private int edellinenArvo;

    public Erotus(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        this.tulostekentta = tulostekentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovelluslogiikka = sovelluslogiikka;
    }

    @Override
    void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.edellinenArvo = arvo;
        sovelluslogiikka.miinus(arvo);
        super.paivitaSuoritus(tulostekentta, syotekentta, nollaa, undo, sovelluslogiikka);
    }
    
    @Override
    void peru() {
        sovelluslogiikka.plus(edellinenArvo);
        super.paivitaUndo(tulostekentta, syotekentta, nollaa, undo, sovelluslogiikka);
    }

}
