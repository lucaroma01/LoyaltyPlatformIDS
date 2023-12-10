package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;
import it.unicam.cs.ids.loyaltyplatform.Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControllerProgrammaFedelta {

    private List<ProgrammaFedelta> listaProgrammi;

    public ControllerProgrammaFedelta() {
        this.listaProgrammi = new ArrayList<>();
    }

    public void addProgrammaFedelta(ProgrammaFedelta programmaFedelta) throws SQLException {
        if(searchById(programmaFedelta.getId()) == programmaFedelta)
            throw new IllegalArgumentException("Programma gia inserito");
        listaProgrammi.add(programmaFedelta);
        String query = "";
        if(programmaFedelta instanceof ProgrammaPunti programmaPunti) {
            query = "INSERT INTO programmapunti (id_pp, nome_pp, descrizione_pp, importoxcostantepunti, totpunti) VALUES('" + programmaPunti.getId() + "', '" + programmaPunti.getNome() + "', '" + programmaPunti.getDescrizione() + "', '" + programmaPunti.getImportoXCostantePunti() + "', '" + programmaPunti.getTotPunti() + "')";
        }
        if(programmaFedelta instanceof ProgrammaLivelli programmaLivelli) {
            query = "INSERT INTO programmalivelli (id_pl, nome_pl, descrizione_pl, percentualelivelloximporto, puntilivello, livellomax ) VALUES('" + programmaLivelli.getId() + "', '" + programmaLivelli.getNome() + "', '" + programmaLivelli.getDescrizione() + "', '" + programmaLivelli.getPercentualeLivelloXImporto() + "', '" + programmaLivelli.getPuntiLivello()+ "', '" + programmaLivelli.getLivelloMax() + "')";
        }
        DBMSController.insertQuery(query);
    }

    public List<ProgrammaFedelta> visualizzaProgrammiPunti() throws SQLException {
        ResultSet risultato1 = DBMSController.selectAllFromTable("programmaPunti");
        while (risultato1.next()) {
            ProgrammaFedelta programmaFedelta = new ProgrammaPunti(risultato1.getInt("id_pp"),
                    risultato1.getString("nome_pp"), risultato1.getString("descrizione_pp"),
                    risultato1.getInt("importoxcostantepunti"), risultato1.getInt("totpunti"));
            this.listaProgrammi.add(programmaFedelta);
        }
        return this.listaProgrammi;
    }
    public List<ProgrammaFedelta> visualizzaProgrammiLivelli() throws SQLException {
        ResultSet risultato1 = DBMSController.selectAllFromTable("programmaLivelli");
        while (risultato1.next()) {
            ProgrammaFedelta programmaFedelta = new ProgrammaLivelli(risultato1.getInt("id_pl"),
                    risultato1.getString("nome_pl"), risultato1.getString("descrizione_pl"),
                    risultato1.getInt("livellomax"), risultato1.getInt("totpunti"),
                    risultato1.getInt("percentualelivelloximporto"));
            this.listaProgrammi.add(programmaFedelta);
        }
        return this.listaProgrammi;
    }

    public ProgrammaFedelta searchById(int id) throws SQLException{
        ProgrammaFedelta programmaFedelta = null;
        for(ProgrammaFedelta p : this.listaProgrammi){
            if(p.getId() == id)
                programmaFedelta = p;
        }
        if(programmaFedelta == null)
            throw new NullPointerException();
        return programmaFedelta;
    }
    public boolean removeById(int id) throws SQLException {
        for (ProgrammaFedelta p : this.listaProgrammi) {
            if (id == p.getId())
                this.listaProgrammi.remove(p);
            String query = "";
            if (p instanceof ProgrammaPunti programmaPunti) {
                query = "DELETE FROM programmapunti WHERE nome_pp='" + programmaPunti.getNome() + "'";
            } else if (p instanceof ProgrammaLivelli programmaLivelli) {
                query = "DELETE FROM programmalivelli WHERE nome_pl='" + programmaLivelli.getNome() + "';";
            }
            DBMSController.removeQuery(query);
            return true;
        }
        return false;
    }

    public void addProgrammiTitolari(TitolarePuntoVendita t, int id) throws SQLException, ErrorDate {
        if (searchById(id) != null) {
            if (searchById(id) instanceof ProgrammaPunti pp) {
                String query = "INSERT INTO programpuntititolare (id_ppt, nome_ppt, descrizione_ppt, importoxcostantepunti_ppt, totpunti_ppt, titolariid) VALUES('" + pp.getId() + "','" + pp.getNome() + "','" + pp.getDescrizione() + "', '" + pp.getImportoXCostantePunti() + "', '" + pp.getTotPunti() + "', '" + t.getId() + "')";
                DBMSController.insertQuery(query);
            } else if (searchById(id) instanceof ProgrammaLivelli pl) {
                String query = "INSERT INTO programlivellititolare (id_plt, nome_plt, descrizione_plt, livellomax_plt, puntilivello, percentualelivelloximporto_plt, titolariid) VALUES('" + pl.getId() + "','" + pl.getNome() + "','" + pl.getDescrizione() + "', '" + pl.getLivelloMax() + "', '" + pl.getPuntiLivello() + "', '" + pl.getPercentualeLivelloXImporto() + "', '" + t.getId() + "')";
                DBMSController.insertQuery(query);
            }
        }else  throw new ErrorDate();
    }

    @Override
    public String toString() {
        String string ="";
        for (ProgrammaFedelta pf : listaProgrammi ){
            string+= "id: ["+pf.getId()+"] \n" +
                    "nome: ["+pf.getNome()+"] \n" +
                    "descrizione: ["+pf.getDescrizione()+"]\n" +
                    "------------------------------------\n";
        }
        return string;
    }

    public void updateProgrammaGestore(ProgrammaFedelta pf) throws SQLException, ErrorDate {
        if (searchById(pf.getId()) != null) {
            if (searchById(pf.getId()) instanceof ProgrammaPunti pp) {
                String query = "UPDATE programpunti SET importoxcostantepunti = '" + pp.getImportoXCostantePunti() + "',totpunti = '" + pp.getTotPunti() + "' WHERE id_pp = '" + pp.getId() + "'";
                DBMSController.insertQuery(query);
            } else if (searchById(pf.getId()) instanceof ProgrammaLivelli pl) {
                String query = "UPDATE programlivelli SET livellomax = '" + pl.getLivelloMax() + "',puntilivello = '" + pl.getPuntiLivello() + "', percentualeLivelloXImporto ='" + pl.getPercentualeLivelloXImporto() + "' WHERE id_pl = '" + pl.getId() + "'";
                DBMSController.insertQuery(query);
            }
        } else throw new ErrorDate();

    }

}
