package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5,
            OLETUSKASVATUS = 5;
    private int kasvatuskoko;
    private int[] lukujono;
    private int alkioidenLkm;

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");
        }
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    private void kasvataTaulukkoa() {
        int[] vanhaTaulukko = new int[lukujono.length];
        vanhaTaulukko = lukujono;
        kopioiTaulukko(lukujono, vanhaTaulukko);
        lukujono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(vanhaTaulukko, lukujono);
    }

    public boolean kuuluu(int luku) {
        int on = indexOf(luku);
        if (on > -1) {
            return true;
        } else {
            return false;
        }
    }

    private int indexOf(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = indexOf(luku);
        int apu;
        if (poistettavanIndeksi != -1) {
            lukujono[poistettavanIndeksi] = 0;
            for (int j = poistettavanIndeksi; j < alkioidenLkm - 1; j++) {
                apu = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] mista, int[] mihin) {
        kopioiOsaTaulukko(mista, mihin, mista.length);
    }

    private void kopioiOsaTaulukko(int[] mista, int[] mihin, int viimeinenIndeksi) {
        for (int i = 0; i < viimeinenIndeksi; i++) {
            mihin[i] = mista[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos += lukujono[i];
            if(i < alkioidenLkm - 1) {
                tuotos += ", ";
            }
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        kopioiOsaTaulukko(lukujono, taulu, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko aJoukko, IntJoukko bJoukko) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        yhdisteJoukko.lisaaJoukonJasenet(aJoukko);
        yhdisteJoukko.lisaaJoukonJasenet(bJoukko);
        return yhdisteJoukko;
    }

    private void lisaaJoukonJasenet(IntJoukko lisattavaJoukko) {
        int[] lisattavanTaulu = lisattavaJoukko.toIntArray();
        for (int i = 0; i < lisattavanTaulu.length; i++) {
            this.lisaa(lisattavanTaulu[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko aJoukko, IntJoukko bJoukko) {
        IntJoukko leikkausJoukko = new IntJoukko();
        leikkausJoukko.lisaaMolemmissaJoukkoissaOlevatJasenet(aJoukko, bJoukko);
        return leikkausJoukko;
    }

    private void lisaaMolemmissaJoukkoissaOlevatJasenet(IntJoukko lisattavaJoukko1, IntJoukko lisattavaJoukko2) {
        int[] lisattavanTaulu1 = lisattavaJoukko1.toIntArray();
        int[] lisattavanTaulu2 = lisattavaJoukko2.toIntArray();
        for (int i = 0; i < lisattavanTaulu1.length; i++) {
            for (int j = 0; j < lisattavanTaulu2.length; j++) {
                if (lisattavanTaulu1[i] == lisattavanTaulu2[j]) {
                    this.lisaa(lisattavanTaulu2[j]);
                }
            }
        }
    }

    public static IntJoukko erotus(IntJoukko aJoukko, IntJoukko bJoukko) {
        IntJoukko erotusJoukko = new IntJoukko();
        erotusJoukko.setLukujono(aJoukko.toIntArray());
        erotusJoukko.setAlkioidenLkm(aJoukko.mahtavuus());
        erotusJoukko.poistaJoukonJasenet(bJoukko);
        return erotusJoukko;
    }

    private void poistaJoukonJasenet(IntJoukko poistettavaJoukko) {
        int[] lisattavanTaulu = poistettavaJoukko.toIntArray();
        for (int i = 0; i < lisattavanTaulu.length; i++) {
            this.poista(lisattavanTaulu[i]);
        }
    }

    public int[] getLukujono() {
        return lukujono;
    }

    public void setAlkioidenLkm(int alkioidenLkm) {
        this.alkioidenLkm = alkioidenLkm;
    }

    public void setLukujono(int[] lukujono) {
        this.lukujono = lukujono;
    }
}
