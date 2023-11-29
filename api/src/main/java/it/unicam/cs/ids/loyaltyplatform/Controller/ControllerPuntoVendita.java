package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControllerPuntoVendita {

    private Set<ProgrammaFedelta> listaProgrammi;
    private List<Cliente> listaClienti;
    private Set<PuntoVendita> listaPuntoVendita;

    private int countPunti;
    private int countLivelli;

    public ControllerPuntoVendita() {
        this.listaProgrammi= new HashSet<>();
        this.listaClienti= new ArrayList<>();
        this.listaPuntoVendita=new HashSet<>();
        countPunti=0;
        countLivelli=0;
    }

    public Set<ProgrammaFedelta> getListaProgrammi() {
        return listaProgrammi;
    }

    public int getCountPunti() {
        return countPunti;
    }

    public int getCountLivelli() {
        return countLivelli;
    }

    /**
     * Metodo che visualizza il programma a
     * punti del titolare della proprio punto vendita
     * @return il set dei programmi a punti
     * @throws SQLException
     */
    public Set<ProgrammaFedelta> visualizzaProgrammiPuntiTitolare(PuntoVendita pv) throws SQLException {
        String table="programmapuntititolare";
        ResultSet resultset= DBMSController.selectAllFromTable(table);
        while (resultset.next()){
            int id_titolare=resultset.getInt("titolariid_t");
            if(id_titolare==pv.getTitolare().getId()) {
                ProgrammaFedelta pp = new ProgrammaPunti(resultset.getInt("id_ppt"), resultset.getString("nome_ppt"),
                        resultset.getString("descrizione_ppt"),
                        resultset.getInt("valorexpunto_ppt"), resultset.getInt("totpunti_ppt"));
                this.listaProgrammi.add(pp);
                countPunti++;
            }
        }
        return this.listaProgrammi;
    }

    /**
     * Metodo che visualizza il programma a
     * livelli del titolare della proprio punto vendita
     * @return il set dei programmi a punti
     * @throws SQLException
     */
    public Set<ProgrammaFedelta> visualizzaProgrammiLivelliTitolare(PuntoVendita pv) throws SQLException {
        String table="programmalivellititolare";
        ResultSet resultset= DBMSController.selectAllFromTable(table);
        while (resultset.next()){
            int id_titolare=resultset.getInt("titolariid_t");
            if(id_titolare==pv.getTitolare().getId()) {
                ProgrammaFedelta pp = new ProgrammaLivelli(resultset.getInt("id_plt"), resultset.getString("nome_plt"),
                        resultset.getString("descrizione_plt"),
                        resultset.getInt("livellomax_plt"), resultset.getInt("puntitot_plt"),
                        resultset.getInt("valorexpercentualelivello_plt"));
                this.listaProgrammi.add(pp);
                countLivelli++;
            }
        }
        return this.listaProgrammi;
    }

    public void addPuntoVendita(PuntoVendita pv) throws ErrorDate,SQLException {
        for(PuntoVendita p: this.listaPuntoVendita){
            if(findById(pv.getNomePuntoVendita()).equals(p.getNomePuntoVendita())){
                throw new ErrorDate("Il punto vendita é gia esistente");
            }
        }
        String query="INSERT INTO puntovendita (nome_pv, indirizzo_pv, titolariid_t ) VALUES('" + pv.getNomePuntoVendita() + "','" + pv.getIndirizzo() + "','" + pv.getTitolare().getId() + "')";
        DBMSController.insertQuery(query);
    }

    public PuntoVendita findById(String nome){
        PuntoVendita puntoVendita = null;
        for (PuntoVendita pv : this.listaPuntoVendita) {
            if (pv.getNomePuntoVendita().equals(nome))
                puntoVendita=pv;
        }
        if (puntoVendita == null) {
            throw new NullPointerException();
        }
        return puntoVendita;
    }
}
