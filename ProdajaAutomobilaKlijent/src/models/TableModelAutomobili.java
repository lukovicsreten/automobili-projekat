/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Automobil;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreten
 */
public class TableModelAutomobili extends AbstractTableModel implements Runnable {

    private ArrayList<Automobil> lista;
    private String[] kolone = {"ID", "Tip automobila", "Marka", "Model",
        "Godina proizvodnje", "Kilometraza", "Cena"};
    private String parametar = "";

    public TableModelAutomobili() {
        try {
            lista = ClientController.getInstance().getAllAutomobil();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAutomobili.class.getName()).log(Level.SEVERE, null, ex);
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
        Automobil a = lista.get(row);

        switch (column) {
            case 0:
                return a.getAutomobilID();
            case 1:
                return a.getTipAutomobila();
            case 2:
                return a.getMarka();
            case 3:
                return a.getModel();
            case 4:
                return a.getGodinaProizvodnje();
            case 5:
                return a.getKilometraza() + "km";
            case 6:
                return a.getMotor();
            case 7:
                return a.getCena() + "€";
           
            default:
                return null;
        }
    }

    public Automobil getSelectedAutomobil(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelAutomobili.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllAutomobil();
            if (!parametar.equals("")) {
                ArrayList<Automobil> novaLista = new ArrayList<>();
                for (Automobil a : lista) {
                    if (a.getModel().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(a);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
