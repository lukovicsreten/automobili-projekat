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
 * @author Sreten
 */
public class TipAutomobila extends AbstractDomainObject {

    private Long tipAutomobilaID;
    private String naziv;

    @Override
    public String toString() {
        return naziv;
    }

    public TipAutomobila(Long tipAutomobilaID, String naziv) {
        this.tipAutomobilaID = tipAutomobilaID;
        this.naziv = naziv;
    }

    public TipAutomobila() {
    }

    @Override
    public String nazivTabele() {
        return " TipAutomobila ";
    }

    @Override
    public String alijas() {
        return " ta ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipAutomobila ta = new TipAutomobila(rs.getLong("TipAutomobilaID"),
                    rs.getString("Naziv"));

            lista.add(ta);
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
        return " TipAutomobilaID = " + tipAutomobilaID;
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

    public Long getTipAutomobilaID() {
        return tipAutomobilaID;
    }

    public void setTipAutomobilaID(Long tipAutomobilaID) {
        this.tipAutomobilaID = tipAutomobilaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
