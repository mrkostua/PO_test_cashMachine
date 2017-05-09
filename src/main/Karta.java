package main;

/**
 * @author  Konstantyn PRysiazhnyi on 26.04.2017.
 */
public class Karta {
    private int nrKarty =0;
    private String nazwiskoWlasciciela="";
    private String imieWlasciciela="";
    private String rodzajKarty="";

    public Karta(String rodzajKarty,int nrKonta, String nazwiskoWlasciciela, String imieWlasciciela) {
        this.rodzajKarty = rodzajKarty;
        this.nrKarty = nrKonta;
        this.nazwiskoWlasciciela = nazwiskoWlasciciela;
        this.imieWlasciciela = imieWlasciciela;
    }

    @Override
    public String toString() {
        return "main.Karta{ " +
                " rodzaj karty : " + rodzajKarty +
                " nrKarty= " + nrKarty +
                ", nazwiskoWlasciciela= '" + nazwiskoWlasciciela + '\'' +
                ", imieWlasciciela= '" + imieWlasciciela + '\'' +
                '}';
    }

}
