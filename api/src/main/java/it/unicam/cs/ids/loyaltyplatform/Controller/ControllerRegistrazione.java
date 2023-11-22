package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.ErrorDate;
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

    public void addTitolarePuntoVendita(TitolarePuntoVendita t) throws SQLException, ErrorDate {
        String query = "UPDATE titolari SET abilitato = 'true' WHERE id_t = '" + t.getId() + "'";
        DBMSController.insertQuery(query);
    }

    public List<TitolarePuntoVendita> getAllAbilitati() throws SQLException, ErrorDate {
        String t = "titolari";
        ResultSet resultSet = DBMSController.selectAllFromTable(t);
        while(resultSet.next()){
            TitolarePuntoVendita titolare = new TitolarePuntoVendita(resultSet.getInt("id_t"),
                    resultSet.getString("nome_t"),  resultSet.getString("cognome_t"),
                    resultSet.getString("indirizzo_t"), resultSet.getString("email_t"),
                    resultSet.getString("username_t"), resultSet.getString("password_t"),
                    resultSet.getInt("telefono_t"), resultSet.getBoolean("abilitato"));
            this.titolariAttivita.add(titolare);
        }
        return titolariAttivita;
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
