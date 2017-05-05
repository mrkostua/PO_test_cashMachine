package RodzajeKart;

import main.Karta;

public class NormalKarta extends Karta {
    private static String rodzajKarty = "normalnaKarta";

    public NormalKarta( int nrKonta, String nazwiskoWlasciciela, String imieWlasciciela) {
        super(rodzajKarty, nrKonta, nazwiskoWlasciciela, imieWlasciciela);
    }
}
