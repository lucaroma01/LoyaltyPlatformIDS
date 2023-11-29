package it.unicam.cs.ids.loyaltyplatform.Model;

public class PuntoVendita {

    private int id;
    private String nomePuntoVendita;
    private String indirizzo;
    private TitolarePuntoVendita titolare;

    public PuntoVendita(int id, String nomePuntoVendita, String indirizzo, TitolarePuntoVendita titolare) {
        this.id = id;
        this.nomePuntoVendita = nomePuntoVendita;
        this.indirizzo = indirizzo;
        this.titolare = titolare;
    }

    public String getNomePuntoVendita() {
        return nomePuntoVendita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public TitolarePuntoVendita getTitolare() {
        return titolare;
    }

    public int getId() {
        return id;
    }
}
