package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.ResultSet;
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
    public List<CartaFedelta> visualizzaCartaFedelta(Cliente c) throws SQLException, ErrorDate {
        String table="cartefedelta";
        ResultSet resultSet= DBMSController.selectAllFromTable(table);
        while (resultSet.next()){
            if(c.getId()== resultSet.getInt("clientiid")){
                ControllerRegistrazione cr= new ControllerRegistrazione();
                cr.visualizzaClienti();
                ControllerPuntoVendita cp= new ControllerPuntoVendita();
                cp.visualizzaPuntoVendita();
                PuntoVendita aggiungiPuntoVendita= cp.findById(resultSet.getString("puntovenditanome_pv"));
                Cliente aggiungiCliente= cr.getById(resultSet.getInt("clientiid"));
                CartaFedelta cf= new CartaFedelta(resultSet.getInt("id_cf"), resultSet.getString("nome_cf"),
                        resultSet.getDate("scadenza_cf"), aggiungiPuntoVendita,
                        aggiungiCliente, resultSet.getInt("punticorrenti"),
                        resultSet.getInt("livellocorrente"), resultSet.getInt("percentualelivello"));
                this.listaCarteFedelta.add(cf);
            }
        }
        return this.listaCarteFedelta;
    }

}
