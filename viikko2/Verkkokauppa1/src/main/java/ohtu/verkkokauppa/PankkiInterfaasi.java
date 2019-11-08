
package ohtu.verkkokauppa;

public interface PankkiInterfaasi {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
