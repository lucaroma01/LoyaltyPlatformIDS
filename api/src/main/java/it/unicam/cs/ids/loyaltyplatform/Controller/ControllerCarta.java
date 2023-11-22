package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerCarta {

    private List<CartaFedelta> listaCarteFedelta;

    public ControllerCarta() {
        this.listaCarteFedelta = new ArrayList<>();
    }

    public CartaFedelta searchById(int id) {
        CartaFedelta cartaFedelta = null;
        for(CartaFedelta c : this.listaCarteFedelta){
            if(c.getId() == id)
                cartaFedelta = c;
        }
        if(cartaFedelta == null)
            return null;
        return  cartaFedelta;
    }

    public void addCartaFedelta(CartaFedelta c) throws SQLException, ErrorDate {
        if(searchById(c.getId()) == null){
            String query = "INSERT INTO cartafedelta (id_cf, nome_cf, scadenza_cf, punticorrenti, livellocorrente, percentualelivello, nomepuntovendita, clienteid) VALUES('" + c.getId() + "', '" + c.getNomeCarta() + "', '" +c.getScadenza() + "', '" + c.getPuntiCorrenti() + "', '" + c.getLivelloAttuale() + "', '" + c.getPercentualeLivello() + "', '" + c.getPuntoVendita().getNomePuntoVendita() + "', '" + c.getCliente().getId() + "')";
            DBMSController.insertQuery(query);
        }
        else throw new ErrorDate("Carta esistente");
    }


}
