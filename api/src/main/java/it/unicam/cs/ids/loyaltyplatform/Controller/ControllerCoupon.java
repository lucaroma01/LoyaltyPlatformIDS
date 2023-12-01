package it.unicam.cs.ids.loyaltyplatform.Controller;

import it.unicam.cs.ids.loyaltyplatform.Model.*;
import it.unicam.cs.ids.loyaltyplatform.Services.DBMSController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerCoupon {

    private List<Coupon> listaCoupon;

    public ControllerCoupon() {
        this.listaCoupon = new ArrayList<Coupon>();
    }

    public List<Coupon> getListaCoupon() {
        return listaCoupon;
    }

    public void addCoupon(Coupon c) throws SQLException {
        String query = "INSERT INTO coupon (programpuntititolareid_ppt, id_coupon, nome_coupon, costopunti) VALUES('" + c.getPp().getId() + "','" + c.getIdCoupon() + "','" + c.getNomeCoupon() + "', '" + c.getCostoPunti() + "')";
        DBMSController.insertQuery(query);
    }

    public List<Coupon> viusalizzaCoupon(PuntoVendita pv) throws SQLException, ErrorDate {
        String table = "coupon";
        ResultSet resultSet =  DBMSController.selectAllFromTable(table);
        while(resultSet.next()){
            ControllerRegistrazione cr = new ControllerRegistrazione();
            ControllerPuntoVendita cpv = new ControllerPuntoVendita();
            cr.visualizzaClienti();
            Cliente cliente = cr.getById(resultSet.getInt("clienteid"));
            cpv.visualizzaProgrammiPuntiTitolare(pv);
            cpv.visualizzaProgrammiLivelliTitolare(pv);
            ProgrammaFedelta pf = cpv.searchById(resultSet.getInt("id_ppt"));
            if(pf instanceof ProgrammaPunti pp) {
                Coupon c = new Coupon(resultSet.getInt("id_coupon"), resultSet.getString("nome_coupon"),
                        resultSet.getInt("costopunti"), pp, cliente);
                this.listaCoupon.add(c);
            }
        }
        return this.listaCoupon;
    }

    public Coupon searchById(int id) {
        Coupon coupon = null;
        for(Coupon c : this.listaCoupon){
            if(c.getIdCoupon() == id)
                coupon = c;
        }
        return coupon;
    }

    @Override
    public String toString() {
        String string ="";
        for (Coupon coupon : listaCoupon ){
            string += "id: ["+coupon.getIdCoupon()+"] \n" +
                    "nome: ["+coupon.getNomeCoupon()+"] \n" +
                    "costo punti: ["+coupon.getCostoPunti()+"]\n" +
                    "id del programma di appartenenza: "+coupon+"\n" +
                    "id del cliente che ha riscattato il coupon: "+coupon+"" +
                    "------------------------------------\n";
        }
        return string;
    }
}
