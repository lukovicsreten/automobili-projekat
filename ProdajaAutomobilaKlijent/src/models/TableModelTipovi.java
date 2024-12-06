/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Administrator;
import domain.TipAutomobila;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreten
 */
public class TableModelTipovi extends AbstractTableModel implements Runnable {

    private ArrayList<TipAutomobila> lista;
    private String[] kolone = {"ID", "naziv"};
    private String parametar = "";

    public TableModelTipovi() {
        try {
            lista = ClientController.getInstance().getAllTipAutomobila();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTipovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        TipAutomobila ta= lista.get(row);

        switch (column) {
            case 0:
                return ta.getTipAutomobilaID();
            case 1:
                return ta.getNaziv();
           

            default:
                return null;
        }
    }

    public TipAutomobila getSelectedAdministrator(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
               // refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTipovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
      //  refreshTable();
    }

   /* public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTipAutomobila();
            if (!parametar.equals("")) {
                ArrayList<Administrator> novaLista = new ArrayList<>();
                for (Administrator a : lista) {
                    if (a.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || a.getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || a.getUsername().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(a);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

}
