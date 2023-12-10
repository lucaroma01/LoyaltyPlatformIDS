package it.unicam.cs.ids.loyaltyplatform.Model;

import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.SQLException;
import java.util.Date;
public class CartaDiCredito {
    private int numeroCarta;

    private Date dateScadenza;

    private String CVV;

    private String pin;
    private double saldoCarta;
    public CartaDiCredito(int numeroCarta, Date dateScadenza, String CVV, String pin) throws ErrorDate {
        if (pin.length() == 5 && CVV.length() == 3) {
            this.numeroCarta = numeroCarta;
            this.dateScadenza = dateScadenza;
            this.CVV = CVV;
            this.pin = pin;
            this.saldoCarta=0;
        }
    }

    public CartaDiCredito(int numeroCarta, Date dateScadenza, String CVV, String pin, double saldoCarta) {
        if (pin.length() == 5 && CVV.length() == 3) {
            this.numeroCarta = numeroCarta;
            this.dateScadenza = dateScadenza;
            this.CVV = CVV;
            this.pin = pin;
            this.saldoCarta = saldoCarta;
        }
    }
    public void incrementaSaldo(int importoAggiunto) throws SQLException {
        this.saldoCarta+=importoAggiunto;
        double incremento=this.saldoCarta;
        String query="UPDATE cartadicredito SET saldocarta = '" +incremento+ "' WHERE id_cc = '" + this.getNumeroCarta() + "'";
        DBMSController.insertQuery(query);
    }

    public void decrementaSaldo(int importoDetratto) throws SQLException {
        this.saldoCarta -= importoDetratto;
        double decremento = this.saldoCarta;
        String query = "UPDATE cartadicredito SET saldocarta = '" + decremento + "' WHERE id_cc = '" + this.getNumeroCarta() + "'";
        DBMSController.insertQuery(query);
    }
        public int getNumeroCarta() {
        return numeroCarta;
    }

    public Date getDateScadenza() {
        return dateScadenza;
    }

    public String getCVV() {
        return CVV;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldoCarta() {
        return saldoCarta;
    }
}
