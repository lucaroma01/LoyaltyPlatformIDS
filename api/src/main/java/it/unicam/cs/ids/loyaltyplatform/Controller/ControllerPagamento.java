package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;

import java.util.ArrayList;
import java.util.List;
public class ControllerPagamento {

    private TitolarePuntoVendita titolarePuntoVendita;

    private List<CartaDiCredito> listaCartaDiCredito;

    public ControllerPagamento() {
        this.listaCartaDiCredito= new ArrayList<>();
    }
}
