package it.unicam.cs.ids.loyaltyplatform.Model;

public class ProgrammaLivelli extends ProgrammaFedelta {

    private int percentualeLivelloXImporto;
    private int puntiLivello;
    private int livelloMax;

    public  ProgrammaLivelli(int id, String nome, String descrizione, int percentualeLivelloXImporto, int puntiLivello, int livelloMax) {
        super(id, nome, descrizione);
        this.percentualeLivelloXImporto = percentualeLivelloXImporto;
        this.puntiLivello = puntiLivello;
        this.livelloMax = livelloMax;
    }

    public int getPercentualeLivelloXImporto() {
        return percentualeLivelloXImporto;
    }

    public int getPuntiLivello() {
        return puntiLivello;
    }

    public int getLivelloMax() {
        return livelloMax;
    }
    public void setLivelloMax(int livelloMax) {
        this.livelloMax = livelloMax;
    }

    public void setPuntiLivello(int puntiLivello) {
        this.puntiLivello = puntiLivello;
    }

    public void setPercentualeLivelloXImporto(int percentualeLivelloXImporto) {
        this.percentualeLivelloXImporto = percentualeLivelloXImporto;
    }
}
