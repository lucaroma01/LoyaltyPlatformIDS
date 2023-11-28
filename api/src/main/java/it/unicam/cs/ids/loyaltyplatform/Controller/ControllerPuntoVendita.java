package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;

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
}
