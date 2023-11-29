package it.unicam.cs.ids.loyaltyplatform.Model;

import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerCarta;
import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerPuntoVendita;

public class CommessoPuntoVendita extends VisitatoreGenerico{
    private final ControllerPuntoVendita controllerPuntoVendita;
    private final ControllerCarta controllerCarta;
    private PuntoVendita puntoVendita;
    public CommessoPuntoVendita(String nome, String cognome, String indirizzo, String email, String username, String password, int telefono, PuntoVendita puntoVendita) {
        super(nome, cognome, indirizzo,email, username, password, telefono);
        this.puntoVendita=puntoVendita;
        this.controllerPuntoVendita=new ControllerPuntoVendita();
        this.controllerCarta= new ControllerCarta();
    }
    public CommessoPuntoVendita(int id, String nome, String cognome, String indirizzo, String email, String username, String password, int telefono, PuntoVendita puntoVendita) {
        super(id, nome, cognome, indirizzo, email, username, password, telefono);
        this.puntoVendita = puntoVendita;
        this.controllerPuntoVendita=new ControllerPuntoVendita();
        this.controllerCarta= new ControllerCarta();
    }
    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }
}
