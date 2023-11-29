package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerRegistrazione {

    private List<TitolarePuntoVendita> titolariAttivita;
    private List<Cliente> clienti;
    private Banca banca;

    public ControllerRegistrazione() {
        this.titolariAttivita = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.banca = new Banca();
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
        if(banca.verificaPagamento(t) == StatoPagamento.PAGATO){
            String query = "UPDATE titolari SET abilitato = 'true' WHERE id_t = '" + t.getId() + "'";
            DBMSController.insertQuery(query);
        } else throw new ErrorDate("In attesa del pagamento");
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

    public void registrazioneCliente(Cliente c) throws SQLException {
        if (validazioneDati(c)) {
            String query = "INSERT INTO clienti (id_c, nome_c, cognome_c, indirizzo_c, email_c, username_c, password_c, telefono_c) VALUES('" + c.getId() + "','" + c.getNome() + "','" + c.getCognome() + "','" + c.getIndirizzo() + "','" + c.getEmail() + "','" + c.getUsername() + "' ,'" + c.getPassword() + "' ,'" + c.getTelefono() + "' )";
            DBMSController.insertQuery(query);
        }
    }

    public List<Cliente> visualizzaClienti() throws SQLException, ErrorDate {
        String t = "titolari";
        ResultSet resultSet = DBMSController.selectAllFromTable(t);
        while(resultSet.next()){
            Cliente c = new Cliente(resultSet.getInt("id_c"),
                    resultSet.getString("nome_c"),  resultSet.getString("cognome_c"),
                    resultSet.getString("indirizzo_c"), resultSet.getString("email_c"),
                    resultSet.getString("username_c"), resultSet.getString("password_c"),
                    resultSet.getInt("telefono_c"));
            this.clienti.add(c);
        }
        return clienti;
    }

    public Cliente searchById(int id) throws SQLException, ErrorDate {
        visualizzaClienti();
        for(Cliente c : this.clienti){
            if(c.getId() == id)
                return c;
        }
        return null;
    }

}
