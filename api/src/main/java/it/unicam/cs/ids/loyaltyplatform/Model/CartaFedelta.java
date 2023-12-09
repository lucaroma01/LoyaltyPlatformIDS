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

    public CartaFedelta(String nomeCarta, Date scadenza, PuntoVendita cartaPuntoVendita, Cliente cliente){
        this.id=randomInt();
        this.nomeCarta = nomeCarta;
        this.puntoVendita = puntoVendita;
        this.cliente = cliente;
    }

    public CartaFedelta(String nomeCarta, PuntoVendita cartaPuntoVendita, Cliente cliente, int puntiCorrenti, int livelliCorrenti, int percentualeLivello) {
        this.id=randomInt();
        this.nomeCarta = nomeCarta;
        this.puntoVendita = puntoVendita;
        this.cliente = cliente;
        this.puntiCorrenti = puntiCorrenti;
        this.livelloAttuale = livelloAttuale;
        this.percentualeLivello = percentualeLivello;
    }

    public CartaFedelta(int id, String nomeCarta, Date scadenza, PuntoVendita cartaPuntoVendita, Cliente cliente, int puntiCorrenti, int livelliCorrenti, int percentualeLivello) {
        this.id = id;
        this.nomeCarta = nomeCarta;
        this.scadenza = scadenza;
        this.puntoVendita = puntoVendita;
        this.cliente = cliente;
        this.puntiCorrenti = puntiCorrenti;
        this.livelloAttuale = livelloAttuale;
        this.percentualeLivello = percentualeLivello;
    }

    private int randomInt(){
        double doubleRandom=Math.random()*6000;
        int intRandom= (int) doubleRandom;
        return intRandom;
    }

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
