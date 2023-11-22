package it.unicam.cs.ids.loyaltyplatform.Model;

import java.sql.SQLException;
import java.util.Date;

public class CartaFedelta {

    private int id;
    private String nomeCarta;
    private Date scadenza;
    private PuntoVendita puntoVendita;
    private Cliente cliente;
    private int puntiCorrenti;
    private int livelloAttuale;

    private int percentualeLivello;

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public int getPuntiCorrenti() {
        return puntiCorrenti;
    }

    public void setPuntiCorrenti(int puntiCorrenti) {
        this.puntiCorrenti = puntiCorrenti;
    }

    public int getLivelloAttuale() {
        return livelloAttuale;
    }

    public void setLivelloAttuale(int livelloAttuale) {
        this.livelloAttuale = livelloAttuale;
    }

    public int getId() {
        return id;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getPercentualeLivello() {
        return percentualeLivello;
    }

    public void setPercentualeLivello(int percentualeLivello) {
        this.percentualeLivello = percentualeLivello;
    }
}
