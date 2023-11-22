package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.TitolarePuntoVendita;
import it.unicam.cs.ids.loyaltyplatform.Model.VisitatoreGenerico;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerRegistrazione {

    private List<TitolarePuntoVendita> titolariAttivita;


    public ControllerRegistrazione() {
        this.titolariAttivita = new ArrayList<>();
    }
    public List<TitolarePuntoVendita> getTitolariAttivita() {
        return titolariAttivita;
    }

    public void registrazioneTitolare(TitolarePuntoVendita t) throws SQLException {
        if (validazioneDati(t)) {
            String query = "INSERT INTO titolari (id_t, nome_t, cognome_t, indirizzo_t, email_t, username_t, password, abilitato, telefono_t) VALUES('" + t.getId() + "','" + t.getNome() + "','" + t.getCognome() + "','" + t.getIndirizzo() + "','" + t.getEmail() + "','" + t.getUsername() + "' ,'" + t.getPassword() + "' ,'" + t.isAbilitato() + "', '" + t.getTelefono() + "' )";
            DBMSController.insertQuery(query);
        }
    }

    /**
     * metodo per controllare se i dati inseriti sono corretti
     *
     * @param utente
     * @return true se i dati sono corretti, false altrimenti.
     */
    private boolean validazioneDati(VisitatoreGenerico utente) {
        if (utente.getNome() == null || utente.getEmail() == null || utente.getUsername() == null || utente.getPassword() == null) {
            return false;
        }
        return true;
    }
}
