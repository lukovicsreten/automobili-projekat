/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;

import domain.Racun;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreten
 */
public class TableModelRacuni extends AbstractTableModel implements Runnable {

    private ArrayList<Racun> lista;
    private String[] kolone = {"ID", "Automobil", "Konacna cena"};
    private String parametar = "";

    public TableModelRacuni() {
        try {
            lista = ClientController.getInstance().getAllRacun();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRacuni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* public TableModelRacuni(Automobil automobil) {
        try {
            lista = ClientController.getInstance().getAllRacun(automobil);
        } catch (Exception ex) {
            Logger.getLogger(TableModelRacuni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

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
        Racun r = lista.get(row);

        switch (column) {
            case 0:
                return r.getRacunID();
            case 1:
                return r.getAutomobil();
            case 2:
                return r.getKonacnaCena() + "€";

            default:
                return null;
        }
    }

    public Racun getSelectedRacun(int row) {
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
            Logger.getLogger(TableModelRacuni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllRacun();
            if (!parametar.equals("")) {
                ArrayList<Racun> novaLista = new ArrayList<>();
                for (Racun r : lista) {
                    if (r.getAutomobil().getModel().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(r);
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
