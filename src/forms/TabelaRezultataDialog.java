/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import data.dao.DAOFactory;
import data.dto.FakultetDTO;
import data.dto.MjestoPrebivalistaDTO;
import data.dto.PrijavaNaKonkursDTO;
import data.dto.RezultatiDTO;
import data.dto.StudentDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DulleX
 */
public class TabelaRezultataDialog extends javax.swing.JDialog {

    private Vector<Object> kolone;
    private Vector<Vector<Object>> podaci;

    private String skolskaGodina;

    /**
     * Creates new form TabelaRezultataDialog
     */

    public TabelaRezultataDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public TabelaRezultataDialog(java.awt.Frame parent, boolean modal, String skolskaGodina) {
        super(parent, modal);
        initComponents();
        this.skolskaGodina = skolskaGodina;
        fakultetCombo.removeAllItems();

        List<FakultetDTO> lista = DAOFactory.getDAOFactory().getFakultetDAO().fakulteti();
        for (FakultetDTO faks : lista) {
            fakultetCombo.addItem(faks.getNazivFakulteta());
        }

        FakultetDTO faks = lista.get(0);
        fakultetCombo.setSelectedIndex(0);
        skolskaGodinaField.setText(skolskaGodina);

        podaci = DAOFactory.getDAOFactory().getIzvjestajiDAO().rezultati();
        String pom = "";
        int i = 1;

        DefaultTableModel model;

        for (Vector<Object> red : podaci) {
            int idPrijave = (int) red.get(0);
            String JMB = (String) red.get(1);
            String ime = (String) red.get(2);
            String prezime = (String) red.get(3);
            double brojOsvojenihBodova = (double) red.get(4);
            boolean prosaoNaKonkursu = (boolean) red.get(5);
            String sg = (String) red.get(6); //skolska godina
            String nazivFaks = (String) red.get(7); //naziv faksa

            if (sg.equals(skolskaGodina) && faks.equals(nazivFaks)) {
                if (prosaoNaKonkursu) {
                    pom = "Da";
                } else {
                    pom = "Ne";
                }
                Object[] row = {i++, JMB, ime, prezime, brojOsvojenihBodova, pom};

                model = (DefaultTableModel) tabela.getModel();

                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fakultetCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        skolskaGodinaField = new javax.swing.JTextField();
        ucitajButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rezultati");
        setResizable(false);

        jLabel1.setText("Fakultet:");

        fakultetCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Školska godina:");

        ucitajButton.setText("Učitaj");
        ucitajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucitajButtonActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Redni broj", "JMB", "Ime", "Prezime", "Broj bodova", "Prošao na konkursu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fakultetCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(ucitajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fakultetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ucitajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ucitajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucitajButtonActionPerformed
        DefaultTableModel model;
        model = (DefaultTableModel) tabela.getModel();

        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        if (!skolskaGodinaField.getText().matches("\\d{4}/\\d{4}")) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Greška pri unosu školske godine. Potreban format je xxxx/yyyy.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String pom = "";
        int i = 1;

        FakultetDTO faks = DAOFactory.getDAOFactory().getFakultetDAO().fakultet((String) fakultetCombo.getSelectedItem());

        for (Vector<Object> red : podaci) {
            int idPrijave = (int) red.get(0);
            String JMB = (String) red.get(1);
            String ime = (String) red.get(2);
            String prezime = (String) red.get(3);
            double brojOsvojenihBodova = (double) red.get(4);
            boolean prosaoNaKonkursu = (boolean) red.get(5);
            String sg = (String) red.get(6); //skolska godina
            String nazivFaks = (String) red.get(7); //naziv faksa

            if (sg.equals(skolskaGodina) && ((String) fakultetCombo.getSelectedItem()).equals(nazivFaks)) {
                if (prosaoNaKonkursu) {
                    pom = "Da";
                } else {
                    pom = "Ne";
                }
                Object[] row = {i++, JMB, ime, prezime, brojOsvojenihBodova, pom};

                model = (DefaultTableModel) tabela.getModel();

                model.addRow(row);
            }
        }
    }//GEN-LAST:event_ucitajButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelaRezultataDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaRezultataDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaRezultataDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaRezultataDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TabelaRezultataDialog dialog = new TabelaRezultataDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fakultetCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField skolskaGodinaField;
    private javax.swing.JTable tabela;
    private javax.swing.JButton ucitajButton;
    // End of variables declaration//GEN-END:variables
}