package it.unicam.cs.ids.loyaltyplatform.Model;

import java.sql.SQLException;
import java.util.Date;
public class CartaDiCredito {
    private int numeroCarta;

    private Date dateScadenza;

    private int CVV;

    private int pin;
    private double saldoCarta;
    public CartaDiCredito(int numeroCarta, Date dateScadenza, int CVV, int pin) throws ErrorDate {
        if (pin==5 && CVV==3) {
            this.numeroCarta = numeroCarta;
            this.dateScadenza = dateScadenza;
            this.CVV = CVV;
            this.pin = pin;
            this.saldoCarta=0;
        }
    }

    public CartaDiCredito(int numeroCarta, Date dateScadenza, int CVV, int pin, double saldoCarta) {
        if (pin==5 && CVV==3) {
            this.numeroCarta = numeroCarta;
            this.dateScadenza = dateScadenza;
            this.CVV = CVV;
            this.pin = pin;
            this.saldoCarta = saldoCarta;
        }
    }

}
