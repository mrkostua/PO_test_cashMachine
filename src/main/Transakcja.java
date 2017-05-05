package main;

import java.time.LocalDate;

/**
 * @author Konstantyn Prysiazhnyi
 */
public class Transakcja {
    private int nrKonta = 0;
    private LocalDate data;

    public int getNrKonta() {
        return nrKonta;
    }

    public LocalDate getData() {
        return data;
    }

    public Transakcja(int nrKonta  ) {
        this.nrKonta = nrKonta;
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {
        return "main.Transakcja{" +
                "nrKonta=" + nrKonta +
                ", data=" + data +
                '}';
    }
}
