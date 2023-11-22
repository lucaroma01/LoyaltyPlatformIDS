package it.unicam.cs.ids.loyaltyplatform.Model;

import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerProgrammaFedelta;
import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerRegistrazione;

public class TitolarePuntoVendita extends VisitatoreGenerico{
    private final ControllerRegistrazione effettuaRegistrazione;

    private final ControllerProgrammaFedelta creaProgrammaFedelta;

    private boolean abilitato;
    private CartaDiCredito carta;

    public TitolarePuntoVendita(int id, String nome, String cognome, String indirizzo, String emailBusiness, String username, String password, int telefono,boolean abilitato, CartaDiCredito carta) {
        super(id, nome, cognome, indirizzo, emailBusiness, username, password, telefono);
        this.carta = carta;
        this.abilitato=abilitato;
        this.effettuaRegistrazione= new ControllerRegistrazione();
        this.creaProgrammaFedelta= new ControllerProgrammaFedelta();
    }

    public TitolarePuntoVendita(int id, String nome, String cognome, String indirizzo, String email, String username, String password, int telefono, boolean abilitato) {
        super(id, nome, cognome, indirizzo, email, username, password, telefono);
        this.abilitato=abilitato;
        this.effettuaRegistrazione= new ControllerRegistrazione();
        this.creaProgrammaFedelta= new ControllerProgrammaFedelta();
    }

    public TitolarePuntoVendita(String nome, String cognome, String indirizzo, String email, String username, String password, int telefono) {
        super(nome, cognome, indirizzo, email, username, password, telefono);
        this.abilitato=false;
        this.effettuaRegistrazione= new ControllerRegistrazione();
        this.creaProgrammaFedelta= new ControllerProgrammaFedelta();
    }

    public CartaDiCredito getCarta() {
        return carta;
    }

    public boolean isAbilitato() {
        return abilitato;
    }
}
