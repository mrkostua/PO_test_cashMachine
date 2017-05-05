package RodzajeKart;

import main.Karta;

/**
 * Created by Администратор on 26.04.2017.
 */
public class StudentKarta extends Karta {
    private static String rodzajKarty = "StudentKarta";

    public StudentKarta( int nrKonta, String nazwiskoWlasciciela, String imieWlasciciela) {
        super(rodzajKarty, nrKonta, nazwiskoWlasciciela, imieWlasciciela);
    }
}
