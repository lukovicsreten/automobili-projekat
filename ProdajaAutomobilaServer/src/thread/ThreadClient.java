/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Automobil;
import domain.Marka;
import domain.Racun;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Sreten
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) request.getData());
                    break;
                case Operation.ADD_AUTOMOBIL:
                    ServerController.getInstance().addAutomobil((Automobil) request.getData());
                    break;
                case Operation.ADD_RACUN:
                    ServerController.getInstance().addRacun((Racun) request.getData());
                    break;
                case Operation.ADD_MARKA:
                    ServerController.getInstance().addMarka((Marka) request.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) request.getData());
                    break;
                case Operation.DELETE_AUTOMOBIL:
                    ServerController.getInstance().deleteAutomobil((Automobil) request.getData());
                    break;
                case Operation.DELETE_MARKA:
                    ServerController.getInstance().deleteMarka((Marka) request.getData());
                    break;
                case Operation.UPDATE_ADMINISTRATOR:
                    ServerController.getInstance().updateAdministrator((Administrator) request.getData());
                    break;
                case Operation.UPDATE_AUTOMOBIL:
                    ServerController.getInstance().updateAutomobil((Automobil) request.getData());
                    break;
                case Operation.UPDATE_MARKA:
                    ServerController.getInstance().updateMarka((Marka) request.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_AUTOMOBIL:
                    response.setData(ServerController.getInstance().getAllAutomobil());
                    break;
                case Operation.GET_ALL_DODATNA_OPREMA:
                    response.setData(ServerController.getInstance().getAllDodatnaOprema((Automobil) request.getData()));
                    break;
                case Operation.GET_ALL_MARKA:
                    response.setData(ServerController.getInstance().getAllMarka());
                    break;
                case Operation.GET_ALL_RACUN:
                    response.setData(ServerController.getInstance().getAllRacun());
                    break;
                case Operation.GET_ALL_TIP_AUTOMOBILA:
                    response.setData(ServerController.getInstance().getAllTipAutomobila());
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator admin = ServerController.getInstance().login(administrator);
                    response.setData(admin);
                    break;
                case Operation.LOGOUT:
                    Administrator ulogovani = (Administrator) request.getData();
                    ServerController.getInstance().logout(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(ex);
        }
        return response;
    }

}
