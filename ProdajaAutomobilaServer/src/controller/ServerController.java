/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;

import domain.Administrator;
import domain.Automobil;
import domain.DodatnaOprema;
import domain.Marka;
import domain.Racun;
import domain.TipAutomobila;
import java.sql.SQLException;
import java.util.ArrayList;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOUpdateAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.automobil.SOAddAutomobil;
import so.automobil.SODeleteAutomobil;
import so.automobil.SOGetAllAutomobil;
import so.automobil.SOUpdateAutomobil;
import so.dodatna_oprema.SOGetAllDodatnaOprema;
import so.login.SOLogin;

import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.tip_automobila.SOGetAllTipAutomobila;
import so.marka.SOAddMarka;
import so.marka.SODeleteMarka;
import so.marka.SOGetAllMarka;
import so.marka.SOUpdateMarka;

/**
 *
 * @author Sreten
 */
public class ServerController {

    private static ServerController instance;
    private ArrayList<Administrator> ulogovaniAdministratori = new ArrayList<>();

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public ArrayList<Administrator> getUlogovaniAdministratori() {
        return ulogovaniAdministratori;
    }

    public void setUlogovaniAdministratori(ArrayList<Administrator> ulogovaniAdministratori) {
        this.ulogovaniAdministratori = ulogovaniAdministratori;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        (new SOAddAdministrator()).templateExecute(administrator);
    }

    public void addMarka(Marka marka) throws Exception {
        (new SOAddMarka()).templateExecute(marka);
    }

    public void addAutomobil(Automobil automobil) throws Exception {
        (new SOAddAutomobil()).templateExecute(automobil);
    }

    public void addRacun(Racun racun) throws Exception {
        (new SOAddRacun()).templateExecute(racun);
    }

    public void deleteAutomobil(Automobil automobil) throws Exception {
        (new SODeleteAutomobil()).templateExecute(automobil);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        (new SODeleteAdministrator()).templateExecute(administrator);
    }

    public void deleteMarka(Marka marka) throws Exception {
        (new SODeleteMarka()).templateExecute(marka);
    }

    public void updateAutomobil(Automobil automobil) throws Exception {
        (new SOUpdateAutomobil()).templateExecute(automobil);
    }

    public void updateAdministrator(Administrator administrator) throws Exception {
        (new SOUpdateAdministrator()).templateExecute(administrator);
    }

    public void updateMarka(Marka marka) throws Exception {
        (new SOUpdateMarka()).templateExecute(marka);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Automobil> getAllAutomobil() throws Exception {
        SOGetAllAutomobil so = new SOGetAllAutomobil();
        
      
        
        so.templateExecute(new Automobil());
        return so.getLista();
    }

    public ArrayList<Marka> getAllMarka() throws Exception {
        SOGetAllMarka so = new SOGetAllMarka();
        so.templateExecute(new Marka());
        return so.getLista();
    }

    public ArrayList<TipAutomobila> getAllTipAutomobila() throws Exception {
        SOGetAllTipAutomobila so = new SOGetAllTipAutomobila();
        so.templateExecute(new TipAutomobila());
        return so.getLista();
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        
       // Racun r = new Racun();
        //r.setAutomobil(automobil);
        
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public ArrayList<DodatnaOprema> getAllDodatnaOprema(Automobil automobil) throws Exception {
        SOGetAllDodatnaOprema so = new SOGetAllDodatnaOprema();
        
        DodatnaOprema dop = new DodatnaOprema();
        dop.setAutomobil(automobil);
        
        so.templateExecute(dop);
        return so.getLista();
    }

    public void logout(Administrator ulogovani) {
        ulogovaniAdministratori.remove(ulogovani);
    }

    public ArrayList<TipAutomobila> vratiTipoveAutomobila() throws SQLException {
        return DBBroker.getInstance().vratiSveTipove();
    }

   

}
