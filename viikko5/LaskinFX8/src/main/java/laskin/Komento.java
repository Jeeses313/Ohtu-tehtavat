package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    void suorita() {
    }

    void paivitaSuoritus(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        paivita(tulostekentta, syotekentta, nollaa, undo, sovelluslogiikka);
        undo.disableProperty().set(false);
    }
    
    void paivitaUndo(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        paivita(tulostekentta, syotekentta, nollaa, undo, sovelluslogiikka);
        undo.disableProperty().set(true);
    }
    
    private void paivita(TextField tulostekentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        int laskunTulos = sovelluslogiikka.tulos();
        syotekentta.setText("");
        tulostekentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
    }

    void peru() {
    }
}
