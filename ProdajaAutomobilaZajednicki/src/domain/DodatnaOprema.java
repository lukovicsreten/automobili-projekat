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
public class DodatnaOprema extends AbstractDomainObject {

    private Automobil automobil;
    private int rb;
    private String naziv;

    public DodatnaOprema(Automobil automobil, int rb, String naziv) {
        this.automobil = automobil;
        this.rb = rb;
        this.naziv = naziv;
    }

    public DodatnaOprema() {
    }

    @Override
    public String nazivTabele() {
        return " DodatnaOprema ";
    }

    @Override
    public String alijas() {
        return " dop ";
    }

    @Override
    public String join() {
        return " JOIN AUTOMOBIL AUTO ON (AUTO.AUTOMOBILID = DOP.AUTOMOBILID) "
                + "JOIN MARKA M ON (M.MARKAID = AUTO.MARKAID) "
                + "JOIN TIPAUTOMOBILA TA ON (TA.TIPAUTOMOBILAID = AUTO.TIPAUTOMOBILAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipAutomobila ta = new TipAutomobila(rs.getLong("TipAutomobilaID"),
                    rs.getString("ta.Naziv"));

            Marka m = new Marka(rs.getLong("MarkaID"),
                    rs.getString("m.Naziv"));

            Automobil auto = new Automobil(rs.getLong("automobilID"),
                    rs.getString("model"), rs.getInt("godinaProizvodnje"),
                    rs.getInt("kilometraza"), rs.getString("motor"),
                    rs.getString("opis"), rs.getDouble("cena"), m, ta, null);

            DodatnaOprema dop = new DodatnaOprema(auto, rs.getInt("rb"), rs.getString("naziv"));
            
            lista.add(dop);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (automobilID, rb, naziv) ";
    }

    @Override
    public String uslov() {
        return " automobilID = " + automobil.getAutomobilID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + automobil.getAutomobilID() + ", " + rb + ", "
                + "'" + naziv + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return " WHERE AUTO.AUTOMOBILID = " + automobil.getAutomobilID();
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
