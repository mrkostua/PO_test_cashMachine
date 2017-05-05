package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Konstantyn Prysiazhnyi
 */
public class Bankomat {
    private static final int kodAutotzacyjny = 111;

    private int numerTrasakcji = 0;
    public static final String[] naleznoscDoBanku = {"Millenium","ZlotyBank","MegaBank"};
    private static final String nazwaBanku = naleznoscDoBanku[1];
    private static final String lokalizacja = "bankomat 2 Warszawska 2 ";
    private List<Transakcja> transakcjaList = new ArrayList<>();

    private int doKtoregoNalezy = 0;


    /**
     *
     * @param doKtoregoNalezy bank do ktorego nalezy
     */
    public Bankomat(int doKtoregoNalezy){
        this.doKtoregoNalezy = doKtoregoNalezy;
        System.out.println(naleznoscDoBanku[doKtoregoNalezy]);
    }

    @Override
    public String toString() {
        String wszystko = "";
        System.out.println("wszystkie transakcje zrobione z konta " );
        for (Transakcja t : transakcjaList){
            wszystko =" \n " + wszystko + t.toString();
        }
        wszystko += "\n ilosc wszystkich transakcji to :" +   numerTrasakcji++;
        return wszystko;
    }

    public void wydrukujTransakcje(LocalDate localDate,int kodAutotzacyjny){
        if(kodAutotzacyjny == 111) {
            String wyswietl = "";
            if (transakcjaList.size() == 0 || transakcjaList == null) {
                wyswietl = "zadne bilety nie zostale kupione lista jest pusata";
            } else {
                for (Transakcja b : transakcjaList) {
                    if (localDate.equals(b.getData()))
                        wyswietl += "\n " + b;
                }
            }
            System.out.println("	Wszystkie transakcje realizowane : " + localDate + " " + wyswietl);
        }else
            System.out.println("nie masz uprawien");
    }

    public boolean resetowanieTransakcji(int kodAutoryzacyjny){
        if(kodAutotzacyjny == 111) {
            transakcjaList=null;
        }else
            System.out.println("nie masz uprawien");

        return false;
    }


    public void addWplate(Konto konto,int sumaWplata){
        if(doKtoregoBankuNalezy()){
            konto.wplataSrodkow(konto.getNrKonta(),sumaWplata);
        }else {
            int result = sumaWplata/5;
            result = result * 100 + sumaWplata;
            konto.wplataSrodkow(konto.getNrKonta(),result );
            numerTrasakcji++;
        }


        transakcjaList.add(new Transakcja(konto.getNrKonta()));
        wydrukujTransakcje(new Transakcja(konto.getNrKonta()),sumaWplata);
    }

    public void addWyplate(Konto konto, int sumaWyplata){
        if(doKtoregoBankuNalezy()){
            konto.wyplataSrodkow(konto.getNrKonta(),sumaWyplata);
        }else {
            int result = sumaWyplata/5;
            result = result * 100 + sumaWyplata;
            konto.wyplataSrodkow(konto.getNrKonta(), result );

        }
        transakcjaList.add(new Transakcja(konto.getNrKonta()));
        numerTrasakcji++;
        wydrukujTransakcje(new Transakcja(konto.getNrKonta()),sumaWyplata);
    }


    //transakcj nalezy do  innego banku (5% od sumy transk zabiera bank)dolicza do transk 5 %
    private boolean doKtoregoBankuNalezy(){
        if(naleznoscDoBanku[doKtoregoNalezy].equals(nazwaBanku)){
            return true;
        } else
            return  false;
    }

    public void addPrzelew(Konto konto, int przelew, Konto kontoCelowe){
        if(doKtoregoBankuNalezy()){
            konto.przelewNaInneKonto(kontoCelowe,przelew,kontoCelowe.getNrKonta());
        }else {
            int result = przelew/5;
            result = result * 100 + przelew;
            konto.przelewNaInneKonto(kontoCelowe,result,kontoCelowe.getNrKonta());
        }
        transakcjaList.add(new Transakcja(konto.getNrKonta()));

        numerTrasakcji++;
        wydrukujTransakcje(new Transakcja(konto.getNrKonta()),przelew);
    }

    private void wydrukujTransakcje(Transakcja transakcja, int suma){
        System.out.println("Transakcja " + numerTrasakcji);
        System.out.println( " data :" +transakcja.getData() + " nr konta " + transakcja.getNrKonta() + " suma :" + suma);
    }

}
