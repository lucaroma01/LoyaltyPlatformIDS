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

    public void addProgrammaFedelta(ProgrammaFedelta programmaFedelta) {
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
    }

    private boolean searchById(int id) {
        for(ProgrammaFedelta p : this.listaProgrammi){
            if(p.getId() == id)
                return  true;
        }
        return false;
    }
}
