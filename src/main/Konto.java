package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Konstantyn Prysiazhnyi
 */
public class Konto {
    private int nrKonta =0;
    private String nazwiskoWlasciciela="";
    private String imieWlasciciela="";
    private int dostepneSrodke = 0;

    public int getDostepneSrodke() {
        return dostepneSrodke;
    }
//private int[] listIstniejacychKont = {22,111,333,444,555,666};

    private List<Transakcja> transakcjiNaOdzielnymKoncieList = new ArrayList<>();


    public void setDostepneSrodke(int dostepneSrodke) {
        this.dostepneSrodke = this.dostepneSrodke + dostepneSrodke;
    }

    public int getNrKonta() {
        return nrKonta;
    }

    public Konto(int nrKonta, String nazwiskoWlasciciela, String imieWlasciciela, int dostepneSrodke) {
        this.nrKonta = nrKonta;
        this.nazwiskoWlasciciela = nazwiskoWlasciciela;
        this.imieWlasciciela = imieWlasciciela;
        this.dostepneSrodke = dostepneSrodke;
    }

    public boolean wplataSrodkow(int nrKontaWplaty,int wplata){
        dostepneSrodke = dostepneSrodke + wplata;
        transakcjiNaOdzielnymKoncieList.add(new Transakcja(nrKontaWplaty));
        return true;
    }

    /*rivate boolean czyKontoIstnieje(int nrKonta){
        for(int i : listIstniejacychKont){
            if(i == nrKonta)
                return true;
        }
        return false;
    }*/

    public boolean wyplataSrodkow(int wyplata,int nrKontaWyplaty){
        if(wyplata>dostepneSrodke){
            System.out.println("brakuje srodkow na koncie");
            return false;
        }else {
            dostepneSrodke = dostepneSrodke - wyplata;
            System.out.println("opercja success");
            transakcjiNaOdzielnymKoncieList.add(new Transakcja(nrKontaWyplaty));
            return true;
        }
    }

    public void przelewNaInneKonto(Konto kontoCelowe, int przelew, int nrKontaPrzelewu){
        if(kontoCelowe != null) {
            kontoCelowe.setDostepneSrodke(przelew);
            System.out.println("przelew na konto :" + kontoCelowe.getNrKonta());
            transakcjiNaOdzielnymKoncieList.add(new Transakcja(nrKontaPrzelewu));
        }
    }

    public void wyswietlWszystkieTransakcje(){
        System.out.println("wszystkie transakcje zrobione z konta " + nrKonta);
        for (Transakcja t : transakcjiNaOdzielnymKoncieList){
            System.out.println("\n " + t);
        }
    }

    @Override
    public String toString() {
        return "main.Konto{ " +
                "nrKonta=" + nrKonta +
                ", nazwiskoWlasciciela='" + nazwiskoWlasciciela + '\'' +
                ", imieWlasciciela='" + imieWlasciciela + '\'' +
                ", dostepneSrodke=" + dostepneSrodke +
                ", transakcjiNaOdzielnymKoncieList=" + transakcjiNaOdzielnymKoncieList +
                '}';
    }
}
