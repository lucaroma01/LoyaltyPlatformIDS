package it.unicam.cs.ids.loyaltyplatform.Model;

public class ProgrammaPunti extends ProgrammaFedelta{

    private int importoXCostantePunti;
    private int totPunti;

    public ProgrammaPunti(int id, String nome, String descrizione, int importoXCostantePunti, int totPunti) {
        super( id,nome, descrizione);
        this.importoXCostantePunti = importoXCostantePunti;
        this.totPunti = totPunti;
    }

    public int getImportoXCostantePunti() {
        return importoXCostantePunti;
    }
    public void setImportoXCostantePunti(int importoXCostantePunti) {
        this.importoXCostantePunti = importoXCostantePunti;
    }

    public void setTotPunti(int totPunti) {
        this.totPunti = totPunti;
    }

    public int getTotPunti() {
        return totPunti;
    }
}
