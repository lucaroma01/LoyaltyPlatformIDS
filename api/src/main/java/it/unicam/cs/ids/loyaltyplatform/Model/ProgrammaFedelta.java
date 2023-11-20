package it.unicam.cs.ids.loyaltyplatform.Model;

public class ProgrammaFedelta {
    
    private final int id;
    private String nome;
    private String descrizione;
    
    public ProgrammaFedelta(String nome, String descrizione){
        this.id = randomInt();
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public ProgrammaFedelta(int id, String nome, String descrizione){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }


    private int randomInt() {
        double randomInRange = Math.random() * 1000;
        return (int) randomInRange;
    }


}
