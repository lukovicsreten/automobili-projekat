/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sreten
 */
public class Racun extends AbstractDomainObject {

    private Long racunID;
    private Date datumVreme;
    private double cenaBezPDV;
    private double PDV;
    private double konacnaCena;
    private Automobil automobil;
    private Administrator administrator;

    public Racun(Long racunID, Date datumVreme, double cenaBezPDV, double PDV, double konacnaCena, Automobil automobil, Administrator administrator) {
        this.racunID = racunID;
        this.datumVreme = datumVreme;
        this.cenaBezPDV = cenaBezPDV;
        this.PDV = PDV;
        this.konacnaCena = konacnaCena;
        this.automobil = automobil;
        this.administrator = administrator;
    }

    public Racun() {
    }

    @Override
    public String nazivTabele() {
        return " Racun ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN AUTOMOBIL AUTO ON (AUTO.AUTOMOBILID = R.AUTOMOBILID) "
                + "JOIN MARKA M ON (M.MARKAID = AUTO.MARKAID) "
                + "JOIN TIPAUTOMOBILA TA ON (TA.TIPAUTOMOBILAID = AUTO.TIPAUTOMOBILAID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = R.ADMINISTRATORID)";
               
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            TipAutomobila ta = new TipAutomobila(rs.getLong("TipAutomobilaID"),
                    rs.getString("ta.Naziv"));

            Marka m = new Marka(rs.getLong("MarkaID"),
                    rs.getString("m.Naziv"));

            Automobil auto = new Automobil(rs.getLong("automobilID"),
                    rs.getString("model"), rs.getInt("godinaProizvodnje"),
                    rs.getInt("kilometraza"), rs.getString("motor"),
                    rs.getString("opis"), rs.getDouble("cena"), m, ta, null);

            Racun r = new Racun(rs.getLong("racunID"), rs.getTimestamp("datumVreme"),
                    rs.getDouble("cenaBezPDV"), rs.getDouble("PDV"),
                    rs.getDouble("konacnaCena"), auto, a);

            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, cenaBezPDV, PDV, konacnaCena, automobilID, administratorID) ";
    }

    @Override
    public String uslov() {
        return " racunID = " + racunID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', "
                + " " + cenaBezPDV + ", "
                + " " + PDV + ", " + konacnaCena + ", " + automobil.getAutomobilID()
                + ", " + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        if(automobil == null){
            return "";
        }
        return " WHERE AUTO.AUTOMOBILID = " + automobil.getAutomobilID();
    }

    public Long getRacunID() {
        return racunID;
    }

    public void setRacunID(Long racunID) {
        this.racunID = racunID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public double getPDV() {
        return PDV;
    }

    public void setPDV(double PDV) {
        this.PDV = PDV;
    }

    public double getKonacnaCena() {
        return konacnaCena;
    }

    public void setKonacnaCena(double konacnaCena) {
        this.konacnaCena = konacnaCena;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
