/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Automobil;
import domain.DodatnaOprema;
import domain.Marka;
import domain.Racun;
import domain.TipAutomobila;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Sreten
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void logout(Administrator ulogovani) throws Exception {
        sendRequest(Operation.LOGOUT, ulogovani);
    }

    public void addAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.ADD_ADMINISTRATOR, administrator);
    }

    public void addAutomobil(Automobil automobil) throws Exception {
        sendRequest(Operation.ADD_AUTOMOBIL, automobil);
    }
     public void addMarka(Marka marka) throws Exception {
        sendRequest(Operation.ADD_MARKA, marka);
    }

    public void addRacun(Racun racun) throws Exception {
        sendRequest(Operation.ADD_RACUN, racun);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.DELETE_ADMINISTRATOR, administrator);
    }
     public void deleteMarka(Marka marka) throws Exception {
        sendRequest(Operation.DELETE_MARKA, marka);
    }

    public void deleteAutomobil(Automobil automobil) throws Exception {
        sendRequest(Operation.DELETE_AUTOMOBIL, automobil);
    }

    public void updateAdministrator(Administrator administrator) throws Exception {
        sendRequest(Operation.UPDATE_ADMINISTRATOR, administrator);
    }

    public void updateAutomobil(Automobil automobil) throws Exception {
        sendRequest(Operation.UPDATE_AUTOMOBIL, automobil);
    }
    public void updateMarka(Marka marka) throws Exception {
        sendRequest(Operation.UPDATE_MARKA, marka);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }

    public ArrayList<Automobil> getAllAutomobil() throws Exception {
        return (ArrayList<Automobil>) sendRequest(Operation.GET_ALL_AUTOMOBIL, null);
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, null);
    }

    public ArrayList<Marka> getAllMarka() throws Exception {
        return (ArrayList<Marka>) sendRequest(Operation.GET_ALL_MARKA, null);
    }

    public ArrayList<TipAutomobila> getAllTipAutomobila() throws Exception {
        return (ArrayList<TipAutomobila>) sendRequest(Operation.GET_ALL_TIP_AUTOMOBILA, null);
    }

    public ArrayList<DodatnaOprema> getAllDodatnaOprema(Automobil auto) throws Exception {
        return (ArrayList<DodatnaOprema>) sendRequest(Operation.GET_ALL_DODATNA_OPREMA, auto);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

   

}
