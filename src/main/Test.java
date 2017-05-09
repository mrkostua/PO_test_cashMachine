package main;

import java.time.LocalDate;

/**
 * @author Konstantyn Prysiazhnyi
 */
public class Test {

    public static void main(String[] args) {
        //dziedziczenie wystepuje w Karta po nim dziedzicza 3 karty ktore roznia się swoim rodzajem
        //kompozycja wystepuje w klasie Bankomat jak tworzy sie objekt

        Konto konto = new Konto(2222,"Kowasli","Piotr",400);
        Konto konto1 = new Konto(3333,"Prysiaz","Konstan",700);
        Konto konto2 = new Konto(4444,"Antonion","Markus",9000);
        Bankomat bankomat = new Bankomat(1);
        bankomat.addWplate(konto,100);
        bankomat.addWyplate(konto,300);
        System.out.println("\n dostepne srodki po dzialaniu" +konto.getDostepneSrodke() + "\n");
        System.out.println(" bankomat :" + bankomat.toString());

        System.out.println("\n");
        Bankomat bankomat0 = new Bankomat(0);

        bankomat0.addPrzelew(konto1,100,konto);
        bankomat0.wydrukujTransakcje(LocalDate.now(),111);
        System.out.println("\n");
        bankomat0.addWyplate(konto2,1000);
        bankomat0.addWplate(konto2,300);
        System.out.println(bankomat0);
        bankomat.wydrukujTransakcje(LocalDate.now().minusDays(1),111);

        System.out.println("\n Resetowanie wszystkich transakcji w danym bankomacie dostepne" +
                " tylko za pomoca kodu autoryzacjyjnego ");
        bankomat.resetowanieTransakcji(111);


        System.out.println("\n Wyswietlanie wszystkich transakcji na okreslonym koncie :" + konto2.toString());
        konto2.wyswietlWszystkieTransakcje();
    }

}
