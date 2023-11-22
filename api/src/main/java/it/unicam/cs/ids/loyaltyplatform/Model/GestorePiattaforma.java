package it.unicam.cs.ids.loyaltyplatform.Model;


public class GestorePiattaforma extends VisitatoreGenerico {


    private static int costoAdesionePiattaforma = 1000;

    public GestorePiattaforma(String nome, String cognome, String indirizzo, String email, String username, String password, int telefono) {
        super(nome, cognome, indirizzo, email, username, password, telefono);

    }

    public static int getCostoAdesionePiattaforma() {
        return costoAdesionePiattaforma;
    }

}