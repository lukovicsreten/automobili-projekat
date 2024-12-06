/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import FormAdministrator.FormNoviAdministrator;
import FormAdministrator.FormPretragaAdministratora;
import FormAutomobil.FormNoviAutomobil;
import FormAutomobil.FormPretragaAutomobila;
import FormMarka.FormNovaMarka;
import FormMarka.FormPretragaMarka;
import FormRacun.FormPretragaRacuna;
import controller.ClientController;
import domain.Administrator;
import domain.Automobil;
import domain.Racun;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelAdministratori;
import models.TableModelTipovi;
import session.Session;

/**
 *
 * @author Sreten
 */
public class MainForm extends javax.swing.JFrame {

    private Administrator ulogovani;
    private double cenaBezPDV;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.ulogovani = Session.getInstance().getUlogovani();
        lblUlogovani.setText("Ulogovani administrator: " + ulogovani);
        setTitle("Klijentska forma");
        txtCenaBezPDV.setEditable(false);
        txtKonacnaCena.setEditable(false);
        txtPDV.setEditable(false);
        txtPDV.setText("20%");
        popuniAutomobile();
         TableModelTipovi model = new TableModelTipovi();
        Thread th = new Thread(model);
        th.start();
        tbltipovi.setModel(model);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Da li ste sigurni da zelite da se odjavite?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    try {
                        ClientController.getInstance().logout(ulogovani);
                        System.exit(0);
                    } catch (Exception ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        lblUlogovani = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbAutomobil = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCenaBezPDV = new javax.swing.JTextField();
        txtPDV = new javax.swing.JTextField();
        txtKonacnaCena = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltipovi = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miNoviAutomobil = new javax.swing.JMenuItem();
        miPretragaAutomobila = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        miNovaMarka = new javax.swing.JMenuItem();
        miPretragaMarke = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        miPretragaRacuna = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Racun"));

        jLabel1.setText("Automobil:");

        cmbAutomobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAutomobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAutomobilItemStateChanged(evt);
            }
        });

        jLabel2.setText("Cena bez PDV:");

        jLabel3.setText("PDV:");

        jLabel4.setText("Konacna cena:");

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sacuvaj racun");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAutomobil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCenaBezPDV)
                    .addComponent(txtPDV, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addComponent(txtKonacnaCena, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbAutomobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCenaBezPDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKonacnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbltipovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbltipovi);

        jMenu6.setText("Administrator");

        jMenuItem9.setText("Novi administrator");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuItem10.setText("Pretraga administratora");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        jMenu8.setText("Automobil");

        miNoviAutomobil.setText("Novi automobil");
        miNoviAutomobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviAutomobilActionPerformed(evt);
            }
        });
        jMenu8.add(miNoviAutomobil);

        miPretragaAutomobila.setText("Pretraga automobila");
        miPretragaAutomobila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaAutomobilaActionPerformed(evt);
            }
        });
        jMenu8.add(miPretragaAutomobila);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Marka");

        miNovaMarka.setText("Nova marka");
        miNovaMarka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovaMarkaActionPerformed(evt);
            }
        });
        jMenu9.add(miNovaMarka);

        miPretragaMarke.setText("Pretraga marke");
        miPretragaMarke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaMarkeActionPerformed(evt);
            }
        });
        jMenu9.add(miPretragaMarke);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Racun");

        miPretragaRacuna.setText("Pretraga racuna");
        miPretragaRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaRacunaActionPerformed(evt);
            }
        });
        jMenu10.add(miPretragaRacuna);

        jMenuBar1.add(jMenu10);

        jMenu7.setText("Odjava");

        miOdjava.setText("Odjavi se");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu7.add(miOdjava);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUlogovani)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if (ulogovani.getAdministratorID() == 1) {
            new FormNoviAdministrator(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Samo glavni administrator ima pristup "
                    + "ovoj operaciji!");
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (ulogovani.getAdministratorID() == 1) {
            new FormPretragaAdministratora(this, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Samo glavni administrator ima pristup "
                    + "ovoj operaciji!");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().logout(ulogovani);
                new LoginForma().setVisible(true);
                Session.getInstance().setUlogovani(null);
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_miOdjavaActionPerformed

    private void miNoviAutomobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviAutomobilActionPerformed
        new FormNoviAutomobil(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviAutomobilActionPerformed

    private void miPretragaAutomobilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaAutomobilaActionPerformed
        new FormPretragaAutomobila(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaAutomobilaActionPerformed

    private void miNovaMarkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovaMarkaActionPerformed
        new FormNovaMarka(this, true).setVisible(true);
    }//GEN-LAST:event_miNovaMarkaActionPerformed

    private void miPretragaMarkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaMarkeActionPerformed
        new FormPretragaMarka(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaMarkeActionPerformed

    private void miPretragaRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaRacunaActionPerformed
        new FormPretragaRacuna(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaRacunaActionPerformed

    private void cmbAutomobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAutomobilItemStateChanged
        
        if(cmbAutomobil.getSelectedItem() != null){
            Automobil automobil = (Automobil) cmbAutomobil.getSelectedItem();
            cenaBezPDV = automobil.getCena();
            txtCenaBezPDV.setText(String.valueOf(automobil.getCena()) + "€");
            txtKonacnaCena.setText(String.valueOf(automobil.getCena() * 1.2) + "€");
        }
        
    }//GEN-LAST:event_cmbAutomobilItemStateChanged

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        
        try {
            Automobil automobil = (Automobil) cmbAutomobil.getSelectedItem();
            
            Racun racun = new Racun(null, new Date(), cenaBezPDV, 20, cenaBezPDV * 1.2,
                    automobil, ulogovani);
            
            ClientController.getInstance().addRacun(racun);
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan racun!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbAutomobil;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNovaMarka;
    private javax.swing.JMenuItem miNoviAutomobil;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaAutomobila;
    private javax.swing.JMenuItem miPretragaMarke;
    private javax.swing.JMenuItem miPretragaRacuna;
    private javax.swing.JTable tbltipovi;
    private javax.swing.JTextField txtCenaBezPDV;
    private javax.swing.JTextField txtKonacnaCena;
    private javax.swing.JTextField txtPDV;
    // End of variables declaration//GEN-END:variables

    private void popuniAutomobile() {
        try {
            ArrayList<Automobil> automobili = ClientController.getInstance().getAllAutomobil();

            cmbAutomobil.removeAllItems();

            for (Automobil automobil : automobili) {
                cmbAutomobil.addItem(automobil);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}