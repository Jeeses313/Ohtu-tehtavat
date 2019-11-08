
package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface KirjanpitoInterfaasi {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
