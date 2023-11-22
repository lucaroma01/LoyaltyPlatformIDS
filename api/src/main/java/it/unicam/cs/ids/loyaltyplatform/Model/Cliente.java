package it.unicam.cs.ids.loyaltyplatform.Model;

import it.unicam.cs.ids.loyaltyplatform.Controller.ControllerCarta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends VisitatoreGenerico {

    private List<CartaFedelta> carteFedelta;
    private ControllerCarta controllerCarta;

    public Cliente(String nome, String cognome, String indirizzo, String email, String username, String password, int telefono) {
        super(nome, cognome, indirizzo, email, username, password, telefono);
        this.carteFedelta = new ArrayList<>();
        this.controllerCarta = new ControllerCarta();
    }
}
