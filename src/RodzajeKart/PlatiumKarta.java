package RodzajeKart;

import main.Karta;

/**
 * @author  Konstantyn PRysiazhnyi on 26.04.2017.
 */
public class PlatiumKarta extends Karta {

    private static String rodzajKarty = "PlatiumKarta";

    public PlatiumKarta( int nrKonta, String nazwiskoWlasciciela, String imieWlasciciela) {
        super(rodzajKarty, nrKonta, nazwiskoWlasciciela, imieWlasciciela);
    }
}
