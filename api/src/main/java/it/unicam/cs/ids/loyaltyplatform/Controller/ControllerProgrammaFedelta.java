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
        if(searchById(programmaFedelta.getId()))
            throw new IllegalArgumentException("Programma gia inserito");
        listaProgrammi.add(programmaFedelta);
        String query = "";
        if(programmaFedelta instanceof ProgrammaPunti programmaPunti) {
            query = "INSERT INTO programmapunti (id_pp, nome_pp, descrizione_pp, importocostantexpunti, totpunti) VALUES('" + programmaPunti.getId() + "', '" + programmaPunti.getNome() + "', '" + programmaPunti.getDescrizione() + "', '" + programmaPunti.getImportoXCostantePunti() + "', '" + programmaPunti.getTotPunti() + "')";
        }
        if(programmaFedelta instanceof ProgrammaLivelli programmaLivelli) {
            query = "INSERT INTO programmalivelli (id_pl, nome_pl, descrizione_pl, percentualelivelloximporto, puntilivello, livellomax ) VALUES('" + programmaLivelli.getId() + "', '" + programmaLivelli.getNome() + "', '" + programmaLivelli.getDescrizione() + "', '" + programmaLivelli.getPercentualeLivelloXImporto() + "', '" + programmaLivelli.getPuntiLivello()+ "', '" + programmaLivelli.getLivelloMax() + "')";
        }
        DBMSController.insertQuery(query);
    }

    public List<ProgrammaFedelta> visualizzaProgrammiPunti() throws SQLException {
        ResultSet risultato1 = DBMSController.selectAllFromTable("programmaPunti");
        while (risultato1.next()) {
            ProgrammaFedelta programmaFedelta = new ProgrammaPunti(risultato1.getInt("id_programmaPunti"),
                    risultato1.getString("nome_programmaPunti"), risultato1.getString("descrizione_programmaPunti"),
                    risultato1.getInt("valorexpunto"), risultato1.getInt("totpunti"));
            this.listaProgrammi.add(programmaFedelta);
        }
        return this.listaProgrammi;
    }

    private boolean searchById(int id) {
        for(ProgrammaFedelta p : this.listaProgrammi){
            if(p.getId() == id)
                return  true;
        }
        return false;
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
}
