/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Marka extends AbstractDomainObject {
    
    private Long markaID;
    private String naziv;

    @Override
    public String toString() {
        return naziv;
    }

    public Marka(Long markaID, String naziv) {
        this.markaID = markaID;
        this.naziv = naziv;
    }

    public Marka() {
    }
    
    @Override
    public String nazivTabele() {
        return " Marka ";
    }

    @Override
    public String alijas() {
        return " m ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Marka m = new Marka(rs.getLong("MarkaID"),
                    rs.getString("Naziv"));

            lista.add(m);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Naziv) ";
    }

    @Override
    public String uslov() {
        return " markaID = " + markaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return " '" + naziv + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Naziv = '" + naziv + "' ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    public Long getMarkaID() {
        return markaID;
    }

    public void setMarkaID(Long markaID) {
        this.markaID = markaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
}
