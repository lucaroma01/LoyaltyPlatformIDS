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


}
