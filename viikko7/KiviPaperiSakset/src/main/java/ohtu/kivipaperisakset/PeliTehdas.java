package ohtu.kivipaperisakset;

public class PeliTehdas {
    public static Peli luoPeli(String peliMuoto) {
        if(peliMuoto.equals("a")) {
            return new KPSPelaajaVsPelaaja();
        } else if(peliMuoto.equals("b")) {
            return new KPSTekoaly();
        } else if(peliMuoto.equals("c")) {
            return new KPSParempiTekoaly();
        }
        return null;
    }
}
