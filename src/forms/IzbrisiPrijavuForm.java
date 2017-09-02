/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import data.dao.DAOFactory;
import data.dto.PrijavaNaKonkursDTO;
import data.dto.StudentDTO;
import static forms.PregledPrijavaSkolskeGodineDialog.skolskaGodina;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DulleX
 */
public class IzbrisiPrijavuForm extends javax.swing.JFrame {

    /**
     * Creates new form IzbrisiPrijavuForm
     */
    public IzbrisiPrijavuForm() {
        initComponents();
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
        JMBField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        skolskaGodinaField = new javax.swing.JTextField();
        prikaziSvePrijaveButton = new javax.swing.JButton();
        prikaziPrijavuButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        idPrijaveField2 = new javax.swing.JTextField();
        izbrisiButton = new javax.swing.JButton();
        nazadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Izbriši prijavu");
        setMaximumSize(new java.awt.Dimension(365, 450));
        setMinimumSize(new java.awt.Dimension(365, 450));
        setPreferredSize(new java.awt.Dimension(365, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("JMB:");

        jLabel2.setText("Školska godina:");

        prikaziSvePrijaveButton.setText("Prikaži sve prijave školske godine");
        prikaziSvePrijaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prikaziSvePrijaveButtonActionPerformed(evt);
            }
        });

        prikaziPrijavuButton.setText("Prikaži prijavu");
        prikaziPrijavuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prikaziPrijavuButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Izbrisati"));

        jLabel3.setText("Id prijave:");

        idPrijaveField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPrijaveField2ActionPerformed(evt);
            }
        });

        izbrisiButton.setText("Izbriši");
        izbrisiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izbrisiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(izbrisiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(idPrijaveField2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idPrijaveField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(izbrisiButton)
                .addContainerGap())
        );

        nazadButton.setText("Nazad");
        nazadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prikaziPrijavuButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(55, 55, 55)
                            .addComponent(JMBField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nazadButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prikaziSvePrijaveButton))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(prikaziSvePrijaveButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JMBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(prikaziPrijavuButton)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nazadButton)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prikaziSvePrijaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziSvePrijaveButtonActionPerformed
        String skolskaGodinaa = skolskaGodinaField.getText();

        if (!skolskaGodinaa.matches("\\d{4}/\\d{4}")) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Pogrešno unijeta školska godina.Potreban format je xxxx/yyyy.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PregledPrijavaSkolskeGodineDialog novi = new PregledPrijavaSkolskeGodineDialog(this, true, skolskaGodinaa);
        novi.setVisible(true);

    }//GEN-LAST:event_prikaziSvePrijaveButtonActionPerformed

    private void idPrijaveField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPrijaveField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPrijaveField2ActionPerformed

    private void prikaziPrijavuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziPrijavuButtonActionPerformed
        String skolskaGodinaa = skolskaGodinaField.getText();

        if (!skolskaGodinaa.matches("\\d{4}/\\d{4}")) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Pogrešno unijeta školska godina. Potreban format je xxxx/yyyy", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String jmb = JMBField.getText();
        if (jmb.length() != 13) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Greška pri unosu JMB.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StudentDTO student = DAOFactory.getDAOFactory().getStudentDAO().student(jmb);
        if (student == null) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Nepostojeći JMB.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PrijavaNaKonkursDTO prijava = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().prijava(jmb, skolskaGodina);
        if (prijava == null) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Ne postoji prijava za datu kombinaciju JMB i školske godine.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PregledJednePrijaveDialog novi = new PregledJednePrijaveDialog(this, true, skolskaGodinaa, jmb);
        novi.setVisible(true);


    }//GEN-LAST:event_prikaziPrijavuButtonActionPerformed

    private void izbrisiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izbrisiButtonActionPerformed

        String broj;
        boolean flag = false;
        try {
            broj = idPrijaveField2.getText();
            int idPrijave = Integer.parseInt(broj);

            flag = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().obrisiPrijavu(idPrijave);
        } catch (Exception e) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Greška pri unosu ID-a.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (flag) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Uspješno obrisana prijava broj " + broj, "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            KonkursniRadnikForm.pozoviOptionPane(this, "Ne postoji prijava sa tim id brojem.", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_izbrisiButtonActionPerformed

    private void nazadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazadButtonActionPerformed
        setVisible(false);
        new KonkursniRadnikForm().setVisible(true);
    }//GEN-LAST:event_nazadButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setIconImage(new ImageIcon(getClass().getResource("/Icons/DeleteIcon.png")).getImage());
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(IzbrisiPrijavuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzbrisiPrijavuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzbrisiPrijavuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzbrisiPrijavuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IzbrisiPrijavuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JMBField;
    private javax.swing.JTextField idPrijaveField2;
    private javax.swing.JButton izbrisiButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nazadButton;
    private javax.swing.JButton prikaziPrijavuButton;
    private javax.swing.JButton prikaziSvePrijaveButton;
    private javax.swing.JTextField skolskaGodinaField;
    // End of variables declaration//GEN-END:variables
}
