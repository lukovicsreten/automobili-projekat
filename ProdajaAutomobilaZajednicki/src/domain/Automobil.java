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
public class Automobil extends AbstractDomainObject {

    private Long automobilID;
    private String model;
    private int godinaProizvodnje;
    private int kilometraza;
    private String motor;
    private String opis;
    private double cena;
    private Marka marka;
    private TipAutomobila tipAutomobila;
    private ArrayList<DodatnaOprema> listaDodatneOpreme;

    @Override
    public String toString() {
        return marka + " " + model + " (" + tipAutomobila + ", " + kilometraza + "km, "
                + godinaProizvodnje + ", " + motor + ", Cena: " + cena + "€)";
    }

    public Automobil(Long automobilID, String model, int godinaProizvodnje, int kilometraza, String motor, 
            String opis, double cena, Marka marka, TipAutomobila tipAutomobila, ArrayList<DodatnaOprema> listaDodatneOpreme) {
        this.automobilID = automobilID;
        this.model = model;
        this.godinaProizvodnje = godinaProizvodnje;
        this.kilometraza = kilometraza;
        this.motor = motor;
        this.opis = opis;
        this.cena = cena;
        this.marka = marka;
        this.tipAutomobila = tipAutomobila;
        this.listaDodatneOpreme = listaDodatneOpreme;
    }

    public Automobil() {
    }

    @Override
    public String nazivTabele() {
        return " Automobil ";
    }

    @Override
    public String alijas() {
        return " auto ";
    }

    @Override
    public String join() {
        return " JOIN MARKA M ON (M.MARKAID = AUTO.MARKAID) "
                + "JOIN TIPAUTOMOBILA TA ON (TA.TIPAUTOMOBILAID = AUTO.TIPAUTOMOBILAID) "
               ;
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

            lista.add(auto);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (model, godinaProizvodnje, kilometraza, motor, opis, cena, markaID, "
                + "tipAutomobilaID) ";
    }

    @Override
    public String uslov() {
        return " automobilID = " + automobilID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + model + "', " + godinaProizvodnje + ", "
                + " " + kilometraza + ", '" + motor + "', '" + opis + "', "
                + cena + ", " + marka.getMarkaID() + ", " + tipAutomobila.getTipAutomobilaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " kilometraza = " + kilometraza + ", "
                + "opis = '" + opis + "', cena = " + cena + " ";
    }

    @Override
    public String uslovZaSelect() {
        if(marka == null){
            return "";
        }
        return " WHERE M.MARKAID = " + marka.getMarkaID();
    }

    public Long getAutomobilID() {
        return automobilID;
    }

    public void setAutomobilID(Long automobilID) {
        this.automobilID = automobilID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public int getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(int kilometraza) {
        this.kilometraza = kilometraza;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public TipAutomobila getTipAutomobila() {
        return tipAutomobila;
    }

    public void setTipAutomobila(TipAutomobila tipAutomobila) {
        this.tipAutomobila = tipAutomobila;
    }

    public ArrayList<DodatnaOprema> getListaDodatneOpreme() {
        return listaDodatneOpreme;
    }

    public void setListaDodatneOpreme(ArrayList<DodatnaOprema> listaDodatneOpreme) {
        this.listaDodatneOpreme = listaDodatneOpreme;
    }

}
