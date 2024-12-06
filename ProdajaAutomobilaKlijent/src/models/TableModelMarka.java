/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;

import domain.Marka;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreten
 */
public class TableModelMarka extends AbstractTableModel implements Runnable {

    private ArrayList<Marka> lista;
    private String[] kolone = {"ID", "Naziv"};
    private String parametar = "";

    public TableModelMarka() {
        try {
            lista = ClientController.getInstance().getAllMarka();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAdministratori.class.getName()).log(Level.SEVERE, null, ex);
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
    public String getColumnName(int column) {
        return kolone[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marka m = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return m.getMarkaID();
            case 1:
                return m.getNaziv();

            default:
                return null;
        }
    }

    public Marka getSelectedMarka(int row) {
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
            Logger.getLogger(TableModelAdministratori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllMarka();
            if (!parametar.equals("")) {
                ArrayList<Marka> novaLista = new ArrayList<>();
                for (Marka m : lista) {
                    if (m.getNaziv().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(m);
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
