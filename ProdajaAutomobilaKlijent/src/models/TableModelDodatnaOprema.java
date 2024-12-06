/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Automobil;
import domain.DodatnaOprema;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreten
 */
public class TableModelDodatnaOprema extends AbstractTableModel {

    private ArrayList<DodatnaOprema> lista;
    private String[] kolone = {"Rb", "Naziv"};
    private int rb;

    public TableModelDodatnaOprema() {
        lista = new ArrayList<>();
    }

    public TableModelDodatnaOprema(Automobil auto) {
        try {
            lista = ClientController.getInstance().getAllDodatnaOprema(auto);
        } catch (Exception ex) {
            Logger.getLogger(TableModelDodatnaOprema.class.getName()).log(Level.SEVERE, null, ex);
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
        DodatnaOprema dop = lista.get(row);

        switch (column) {
            case 0:
                return dop.getRb();
            case 1:
                return dop.getNaziv();

            default:
                return null;
        }
    }

    public void dodajOpremu(DodatnaOprema dop) {
        rb = lista.size();
        dop.setRb(++rb);
        lista.add(dop);
        fireTableDataChanged();
    }

    public boolean postojiDop(String naziv) {
        for (DodatnaOprema dodatnaOprema : lista) {
            if (dodatnaOprema.getNaziv().equals(naziv)) {
                return true;
            }
        }
        return false;
    }

    public void obrisiDop(int row) {
        lista.remove(row);

        rb = 0;
        for (DodatnaOprema dodatnaOprema : lista) {
            dodatnaOprema.setRb(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<DodatnaOprema> getLista() {
        return lista;
    }

}
