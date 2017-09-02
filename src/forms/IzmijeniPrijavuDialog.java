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
import data.dto.SocijalniStatusDTO;
import data.dto.StudentDTO;
import static java.lang.Math.abs;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DulleX
 */
public class IzmijeniPrijavuDialog extends javax.swing.JDialog {

    String jmb;
    String skolskaGodina;
    int id;

    public IzmijeniPrijavuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public IzmijeniPrijavuDialog(java.awt.Frame parent, boolean modal, String jmb, String skolskaGodina) {
        super(parent, modal);
        initComponents();
        this.jmb = jmb;
        this.skolskaGodina = skolskaGodina;
        this.id = -1;

        PrijavaNaKonkursDTO prijava = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().prijava(jmb, skolskaGodina);
        StudentDTO student = DAOFactory.getDAOFactory().getStudentDAO().student(prijava.getJMB());
        MjestoPrebivalistaDTO mjesto = DAOFactory.getDAOFactory().getMjestoPrebivalistaDAO().mjestoPrebivalista(prijava.getBrojPoste());
        SocijalniStatusDTO soc = DAOFactory.getDAOFactory().getSocijalniStatusDAO().socijalniStatus(prijava.getIdSocijalnogStatusa());

        skolskaGodinaField.setText(skolskaGodina);
        JMBField.setText(jmb);
        skolskaGodinaField.setEditable(false);
        JMBField.setEditable(false);
        idPrijaveField.setText(String.valueOf(prijava.getIdPrijave()));
        idPrijaveField.setEditable(false);

        brojOdslusanihField2.setText(String.valueOf(prijava.getBrojOdslusanihIspita()));
        brojPolozenihField2.setText(String.valueOf(prijava.getBrojPolozenihIspita()));
        imeField2.setText(student.getIme());
        prezimeField2.setText(student.getPrezime());
        fakultetField2.setText(prijava.getNazivFakulteta());
        brojPosteField2.setText(String.valueOf(prijava.getBrojPoste()));
        godinaStudijaField2.setText(String.valueOf(prijava.getGodinaStudija()));
        prosjekOcjenaField2.setText(String.valueOf(prijava.getProsjekOcjena()));
        brojObnovljenihGodinaField2.setText(String.valueOf(prijava.getBrojObnovljenihGodina()));
        telefonField2.setText(prijava.getTelefon());
        emailField2.setText(prijava.getEmail());
        kazneniBodoviField2.setText(String.valueOf(prijava.getKazneniBodovi()));
        napomenaText.setText(prijava.getNapomena());
        nazivFakultetaCombo.removeAllItems();
        List<FakultetDTO> lista = DAOFactory.getDAOFactory().getFakultetDAO().fakulteti();

        for (FakultetDTO faks : lista) {
            nazivFakultetaCombo.addItem(faks.getNazivFakulteta());
        }

        brojPolozenihField2.setEditable(false);
        brojOdslusanihField2.setEditable(false);
        imeField2.setEditable(false);
        prezimeField2.setEditable(false);
        fakultetField2.setEditable(false);
        brojPosteField2.setEditable(false);
        godinaStudijaField2.setEditable(false);
        prosjekOcjenaField2.setEditable(false);
        brojObnovljenihGodinaField2.setEditable(false);
        telefonField2.setEditable(false);
        emailField2.setEditable(false);
        kazneniBodoviField2.setEditable(false);

        bezObaRoditeljaCheck1.setSelected(soc.isBezObaRoditelja());
        dijetePalogINestalogCheck1.setSelected(soc.isDijetePalogINestalogBorcaRS());
        bezJednogRoditeljaCheck1.setSelected(soc.isBezJednogRoditelja());
        invaliditetCheck1.setSelected(soc.isInvaliditet());
        korisnikSocijalnePomociCheck1.setSelected(soc.isKorisnikSocijalnePomoci());
        dijeteRVIVRSCheck1.setSelected(soc.isDijeteRVIVRS());
        obaRoditeljaNezaposlenaCheck1.setSelected(soc.isObaRoditeljaNezaposlena());
        jedanRoditeljNezaposlenCheck1.setSelected(soc.isJedanRoditeljNezaposlen());
        studentIzViseclanePorodiceCheck1.setSelected(soc.isStudentIzViseclanihPorodica());

        bezObaRoditeljaCheck2.setSelected(soc.isBezObaRoditelja());
        dijetePalogINestalogCheck2.setSelected(soc.isDijetePalogINestalogBorcaRS());
        bezJednogRoditeljaCheck2.setSelected(soc.isBezJednogRoditelja());
        invaliditetCheck2.setSelected(soc.isInvaliditet());
        korisnikSocijalnePomociCheck2.setSelected(soc.isKorisnikSocijalnePomoci());
        dijeteRVIVRSCheck2.setSelected(soc.isDijeteRVIVRS());
        obaRoditeljaNezaposlenaCheck2.setSelected(soc.isObaRoditeljaNezaposlena());
        jedanRoditeljNezaposlenCheck2.setSelected(soc.isJedanRoditeljNezaposlen());
        studentIzViseclanePorodiceCheck2.setSelected(soc.isStudentIzViseclanihPorodica());

        bezObaRoditeljaCheck2.setEnabled(false);
        bezJednogRoditeljaCheck2.setEnabled(false);
        invaliditetCheck2.setEnabled(false);
        korisnikSocijalnePomociCheck2.setEnabled(false);
        dijetePalogINestalogCheck2.setEnabled(false);
        obaRoditeljaNezaposlenaCheck2.setEnabled(false);
        jedanRoditeljNezaposlenCheck2.setEnabled(false);
        studentIzViseclanePorodiceCheck2.setEnabled(false);
        dijeteRVIVRSCheck2.setEnabled(false);

    }

    public IzmijeniPrijavuDialog(java.awt.Frame parent, boolean modal, int id, String skolskaGodina) {
        super(parent, modal);
        initComponents();
        this.id = id;
        this.skolskaGodina = skolskaGodina;
        this.jmb = null;

        PrijavaNaKonkursDTO prijava = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().prijava(id, skolskaGodina);
        StudentDTO student = DAOFactory.getDAOFactory().getStudentDAO().student(prijava.getJMB());
        MjestoPrebivalistaDTO mjesto = DAOFactory.getDAOFactory().getMjestoPrebivalistaDAO().mjestoPrebivalista(prijava.getBrojPoste());
        SocijalniStatusDTO soc = DAOFactory.getDAOFactory().getSocijalniStatusDAO().socijalniStatus(prijava.getIdSocijalnogStatusa());

        skolskaGodinaField.setText(skolskaGodina);
        JMBField.setText(prijava.getJMB());
        skolskaGodinaField.setEditable(false);
        JMBField.setEditable(false);
        idPrijaveField.setText(String.valueOf(prijava.getIdPrijave()));
        idPrijaveField.setEditable(false);

        brojOdslusanihField2.setText(String.valueOf(prijava.getBrojOdslusanihIspita()));
        brojPolozenihField2.setText(String.valueOf(prijava.getBrojPolozenihIspita()));
        imeField2.setText(student.getIme());
        prezimeField2.setText(student.getPrezime());
        fakultetField2.setText(prijava.getNazivFakulteta());
        brojPosteField2.setText(String.valueOf(prijava.getBrojPoste()));
        godinaStudijaField2.setText(String.valueOf(prijava.getGodinaStudija()));
        prosjekOcjenaField2.setText(String.valueOf(prijava.getProsjekOcjena()));
        brojObnovljenihGodinaField2.setText(String.valueOf(prijava.getBrojObnovljenihGodina()));
        telefonField2.setText(prijava.getTelefon());
        emailField2.setText(prijava.getEmail());
        kazneniBodoviField2.setText(String.valueOf(prijava.getKazneniBodovi()));
        napomenaText.setText(prijava.getNapomena());
        nazivFakultetaCombo.removeAllItems();
        List<FakultetDTO> lista = DAOFactory.getDAOFactory().getFakultetDAO().fakulteti();

        for (FakultetDTO faks : lista) {
            nazivFakultetaCombo.addItem(faks.getNazivFakulteta());
        }

        brojPolozenihField2.setEditable(false);
        brojOdslusanihField2.setEditable(false);
        imeField2.setEditable(false);
        prezimeField2.setEditable(false);
        fakultetField2.setEditable(false);
        brojPosteField2.setEditable(false);
        godinaStudijaField2.setEditable(false);
        prosjekOcjenaField2.setEditable(false);
        brojObnovljenihGodinaField2.setEditable(false);
        telefonField2.setEditable(false);
        emailField2.setEditable(false);
        kazneniBodoviField2.setEditable(false);

        bezObaRoditeljaCheck1.setSelected(soc.isBezObaRoditelja());
        dijetePalogINestalogCheck1.setSelected(soc.isDijetePalogINestalogBorcaRS());
        bezJednogRoditeljaCheck1.setSelected(soc.isBezJednogRoditelja());
        invaliditetCheck1.setSelected(soc.isInvaliditet());
        korisnikSocijalnePomociCheck1.setSelected(soc.isKorisnikSocijalnePomoci());
        dijeteRVIVRSCheck1.setSelected(soc.isDijeteRVIVRS());
        obaRoditeljaNezaposlenaCheck1.setSelected(soc.isObaRoditeljaNezaposlena());
        jedanRoditeljNezaposlenCheck1.setSelected(soc.isJedanRoditeljNezaposlen());
        studentIzViseclanePorodiceCheck1.setSelected(soc.isStudentIzViseclanihPorodica());

        bezObaRoditeljaCheck2.setSelected(soc.isBezObaRoditelja());
        dijetePalogINestalogCheck2.setSelected(soc.isDijetePalogINestalogBorcaRS());
        bezJednogRoditeljaCheck2.setSelected(soc.isBezJednogRoditelja());
        invaliditetCheck2.setSelected(soc.isInvaliditet());
        korisnikSocijalnePomociCheck2.setSelected(soc.isKorisnikSocijalnePomoci());
        dijeteRVIVRSCheck2.setSelected(soc.isDijeteRVIVRS());
        obaRoditeljaNezaposlenaCheck2.setSelected(soc.isObaRoditeljaNezaposlena());
        jedanRoditeljNezaposlenCheck2.setSelected(soc.isJedanRoditeljNezaposlen());
        studentIzViseclanePorodiceCheck2.setSelected(soc.isStudentIzViseclanihPorodica());

        bezObaRoditeljaCheck2.setEnabled(false);
        bezJednogRoditeljaCheck2.setEnabled(false);
        invaliditetCheck2.setEnabled(false);
        korisnikSocijalnePomociCheck2.setEnabled(false);
        dijetePalogINestalogCheck2.setEnabled(false);
        obaRoditeljaNezaposlenaCheck2.setEnabled(false);
        jedanRoditeljNezaposlenCheck2.setEnabled(false);
        studentIzViseclanePorodiceCheck2.setEnabled(false);
        dijeteRVIVRSCheck2.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imeField = new javax.swing.JTextField();
        prezimeField = new javax.swing.JTextField();
        ee = new javax.swing.JLabel();
        brojPosteField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idPrijaveField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JMBField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        skolskaGodinaField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        godinaStudijaField = new javax.swing.JTextField();
        prosjekOcjenaField = new javax.swing.JTextField();
        brojObnovljenihGodinaField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kazneniBodoviField = new javax.swing.JTextField();
        prikaziBazuMjestaPrebivalistaButton = new javax.swing.JButton();
        e = new javax.swing.JLabel();
        imeField2 = new javax.swing.JTextField();
        prezimeField2 = new javax.swing.JTextField();
        brojPosteField2 = new javax.swing.JTextField();
        fakultetField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        godinaStudijaField2 = new javax.swing.JTextField();
        prosjekOcjenaField2 = new javax.swing.JTextField();
        brojObnovljenihGodinaField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        telefonField2 = new javax.swing.JTextField();
        emailField2 = new javax.swing.JTextField();
        kazneniBodoviField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bezObaRoditeljaCheck2 = new javax.swing.JCheckBox();
        dijetePalogINestalogCheck2 = new javax.swing.JCheckBox();
        bezJednogRoditeljaCheck2 = new javax.swing.JCheckBox();
        invaliditetCheck2 = new javax.swing.JCheckBox();
        korisnikSocijalnePomociCheck2 = new javax.swing.JCheckBox();
        dijeteRVIVRSCheck2 = new javax.swing.JCheckBox();
        obaRoditeljaNezaposlenaCheck2 = new javax.swing.JCheckBox();
        jedanRoditeljNezaposlenCheck2 = new javax.swing.JCheckBox();
        studentIzViseclanePorodiceCheck2 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        bezObaRoditeljaCheck1 = new javax.swing.JCheckBox();
        dijetePalogINestalogCheck1 = new javax.swing.JCheckBox();
        bezJednogRoditeljaCheck1 = new javax.swing.JCheckBox();
        invaliditetCheck1 = new javax.swing.JCheckBox();
        korisnikSocijalnePomociCheck1 = new javax.swing.JCheckBox();
        dijeteRVIVRSCheck1 = new javax.swing.JCheckBox();
        obaRoditeljaNezaposlenaCheck1 = new javax.swing.JCheckBox();
        jedanRoditeljNezaposlenCheck1 = new javax.swing.JCheckBox();
        studentIzViseclanePorodiceCheck1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        sacuvajButton = new javax.swing.JButton();
        odustaniButton = new javax.swing.JButton();
        nazivFakultetaCombo = new javax.swing.JComboBox<>();
        napomenaText = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        brojOdslusanihIspitaField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        brojPolozenihIspitaField = new javax.swing.JTextField();
        brojOdslusanihField2 = new javax.swing.JTextField();
        brojPolozenihField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Izmijeni prijavu");
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        ee.setText("Broj pošte:");

        brojPosteField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brojPosteFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Godina studija:");

        jLabel8.setText("Prosjek ocjena:");

        jLabel1.setText("Id prijave:");

        jLabel9.setText("Broj obnovljenih godina:");

        jLabel3.setText("Školska godina:");

        jLabel10.setText("Telefon:");

        jLabel11.setText("Email:");

        godinaStudijaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godinaStudijaFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Ime:");

        jLabel5.setText("Prezime:");

        jLabel6.setText("Fakultet");

        jLabel12.setText("Kazneni bodovi:");

        prikaziBazuMjestaPrebivalistaButton.setText("Prikaži bazu mjesta prebivališta");
        prikaziBazuMjestaPrebivalistaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prikaziBazuMjestaPrebivalistaButtonActionPerformed(evt);
            }
        });

        e.setText("JMB:");

        jLabel13.setText("Stare vrijednosti:");

        jLabel14.setText("Stare vrijednosti:");

        jLabel15.setText("Stare vrijednosti:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Socijalni status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        bezObaRoditeljaCheck2.setText("Bez oba roditelja");

        dijetePalogINestalogCheck2.setText("Dijete palog i nestalog borca RS");

        bezJednogRoditeljaCheck2.setText("Bez jednog roditelja");

        invaliditetCheck2.setText("Invaliditet");

        korisnikSocijalnePomociCheck2.setText("Korisnik socijalne pomoci");

        dijeteRVIVRSCheck2.setText("Dijete RVI VRS");

        obaRoditeljaNezaposlenaCheck2.setText("Oba roditelja nezaposlena");
        obaRoditeljaNezaposlenaCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obaRoditeljaNezaposlenaCheck2ActionPerformed(evt);
            }
        });

        jedanRoditeljNezaposlenCheck2.setText("Jedan roditelj nezaposlen");

        studentIzViseclanePorodiceCheck2.setText("Student iz višečlane porodice");
        studentIzViseclanePorodiceCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIzViseclanePorodiceCheck2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bezObaRoditeljaCheck2)
                    .addComponent(dijetePalogINestalogCheck2)
                    .addComponent(bezJednogRoditeljaCheck2)
                    .addComponent(invaliditetCheck2)
                    .addComponent(korisnikSocijalnePomociCheck2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dijeteRVIVRSCheck2)
                    .addComponent(obaRoditeljaNezaposlenaCheck2)
                    .addComponent(jedanRoditeljNezaposlenCheck2)
                    .addComponent(studentIzViseclanePorodiceCheck2))
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bezObaRoditeljaCheck2)
                    .addComponent(dijeteRVIVRSCheck2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dijetePalogINestalogCheck2)
                    .addComponent(obaRoditeljaNezaposlenaCheck2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bezJednogRoditeljaCheck2)
                    .addComponent(jedanRoditeljNezaposlenCheck2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(invaliditetCheck2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(korisnikSocijalnePomociCheck2))
                    .addComponent(studentIzViseclanePorodiceCheck2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Socijalni status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        bezObaRoditeljaCheck1.setText("Bez oba roditelja");

        dijetePalogINestalogCheck1.setText("Dijete palog i nestalog borca RS");

        bezJednogRoditeljaCheck1.setText("Bez jednog roditelja");

        invaliditetCheck1.setText("Invaliditet");

        korisnikSocijalnePomociCheck1.setText("Korisnik socijalne pomoci");

        dijeteRVIVRSCheck1.setText("Dijete RVI VRS");

        obaRoditeljaNezaposlenaCheck1.setText("Oba roditelja nezaposlena");
        obaRoditeljaNezaposlenaCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obaRoditeljaNezaposlenaCheck1ActionPerformed(evt);
            }
        });

        jedanRoditeljNezaposlenCheck1.setText("Jedan roditelj nezaposlen");

        studentIzViseclanePorodiceCheck1.setText("Student iz višečlane porodice");
        studentIzViseclanePorodiceCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIzViseclanePorodiceCheck1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bezObaRoditeljaCheck1)
                    .addComponent(dijetePalogINestalogCheck1)
                    .addComponent(bezJednogRoditeljaCheck1)
                    .addComponent(invaliditetCheck1)
                    .addComponent(korisnikSocijalnePomociCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dijeteRVIVRSCheck1)
                    .addComponent(obaRoditeljaNezaposlenaCheck1)
                    .addComponent(jedanRoditeljNezaposlenCheck1)
                    .addComponent(studentIzViseclanePorodiceCheck1))
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bezObaRoditeljaCheck1)
                    .addComponent(dijeteRVIVRSCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dijetePalogINestalogCheck1)
                    .addComponent(obaRoditeljaNezaposlenaCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bezJednogRoditeljaCheck1)
                    .addComponent(jedanRoditeljNezaposlenCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(invaliditetCheck1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(korisnikSocijalnePomociCheck1))
                    .addComponent(studentIzViseclanePorodiceCheck1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Stare vrijednosti:");

        jLabel16.setText("Nove vrijednosti:");

        sacuvajButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sacuvajButton.setText("Sačuvaj");
        sacuvajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacuvajButtonActionPerformed(evt);
            }
        });

        odustaniButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odustaniButton.setText("Odustani");
        odustaniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odustaniButtonActionPerformed(evt);
            }
        });

        jLabel17.setText("Broj odslušanih ispita:");

        jLabel18.setText("Broj položenih ispita:");

        jLabel19.setText("Stare vrijednosti:");

        jLabel20.setText("Napomena:");

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Ako se ništa ne unese");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("u polja koja odgovaraju");

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("novim vrijednostima,");

        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("onda ostaju stare vrijednosti");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kazneniBodoviField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kazneniBodoviField2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(ee))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(e)
                                            .addComponent(jLabel1))))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JMBField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idPrijaveField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(prikaziBazuMjestaPrebivalistaButton)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(brojOdslusanihIspitaField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(brojOdslusanihField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(brojPolozenihIspitaField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(brojPolozenihField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(prosjekOcjenaField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(prosjekOcjenaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(godinaStudijaField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel14)
                                                            .addComponent(godinaStudijaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(imeField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prezimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(prezimeField2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                                            .addComponent(imeField2))
                                                        .addGap(124, 124, 124)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel7)
                                                            .addComponent(jLabel8)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(210, 210, 210)
                                                        .addComponent(jLabel9)))
                                                .addGap(4, 4, 4)
                                                .addComponent(brojObnovljenihGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(brojObnovljenihGodinaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(emailField2))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel15)
                                                        .addComponent(telefonField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(brojPosteField, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                                    .addComponent(nazivFakultetaCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(brojPosteField2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                                    .addComponent(fakultetField2))))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(napomenaText, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22))
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel25)
                                    .addComponent(sacuvajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(odustaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {odustaniButton, sacuvajButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPrijaveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prikaziBazuMjestaPrebivalistaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(brojOdslusanihIspitaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brojOdslusanihField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(brojPolozenihIspitaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brojPolozenihField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JMBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(skolskaGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(godinaStudijaField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(godinaStudijaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(imeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prezimeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prezimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(brojPosteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(ee)
                                    .addComponent(brojPosteField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brojObnovljenihGodinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(brojObnovljenihGodinaField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fakultetField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nazivFakultetaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(prosjekOcjenaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(prosjekOcjenaField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(sacuvajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(odustaniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefonField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kazneniBodoviField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(kazneniBodoviField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(napomenaText, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {odustaniButton, sacuvajButton});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brojPosteFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brojPosteFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brojPosteFieldActionPerformed

    private void godinaStudijaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godinaStudijaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_godinaStudijaFieldActionPerformed

    private void prikaziBazuMjestaPrebivalistaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziBazuMjestaPrebivalistaButtonActionPerformed

        TabelaDialog nova = new TabelaDialog(new KonkursniRadnikForm(), true);
        nova.setVisible(true);

    }//GEN-LAST:event_prikaziBazuMjestaPrebivalistaButtonActionPerformed

    private void obaRoditeljaNezaposlenaCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obaRoditeljaNezaposlenaCheck2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obaRoditeljaNezaposlenaCheck2ActionPerformed

    private void studentIzViseclanePorodiceCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIzViseclanePorodiceCheck2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIzViseclanePorodiceCheck2ActionPerformed

    private void obaRoditeljaNezaposlenaCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obaRoditeljaNezaposlenaCheck1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obaRoditeljaNezaposlenaCheck1ActionPerformed

    private void studentIzViseclanePorodiceCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIzViseclanePorodiceCheck1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIzViseclanePorodiceCheck1ActionPerformed

    private void sacuvajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacuvajButtonActionPerformed
        try {

            String jmb = JMBField.getText();

            int godinaStudija = 0;
            if (godinaStudijaField.getText().isEmpty()) {
                godinaStudija = Integer.parseInt(godinaStudijaField2.getText());
            } else {
                godinaStudija = Integer.parseInt(godinaStudijaField.getText());
                if (godinaStudija > 10 || godinaStudija < 1) {
                    KonkursniRadnikForm.pozoviOptionPane(this, "Pogrešno unijeta godina studija.", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            double prosjekOcjena = 0;
            if (prosjekOcjenaField.getText().isEmpty()) {
                prosjekOcjena = Double.parseDouble(prosjekOcjenaField2.getText());
            } else {
                prosjekOcjena = Double.parseDouble(prosjekOcjenaField.getText());
                if (prosjekOcjena > 10 || prosjekOcjena < 1) {
                    KonkursniRadnikForm.pozoviOptionPane(this, "Greška pri unosu prosječne ocjene.", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            int brojPoste = 0;
            if (brojPosteField.getText().isEmpty()) {
                brojPoste = Integer.parseInt(brojPosteField2.getText());
            } else {
                brojPoste = Integer.parseInt(brojPosteField.getText());
            }

            int brojPolozenihIspita = 0;
            if (brojPolozenihIspitaField.getText().isEmpty()) {
                brojPolozenihIspita = Integer.parseInt(brojPolozenihField2.getText());
            } else {
                brojPolozenihIspita = Integer.parseInt(brojPolozenihIspitaField.getText());
            }

            int brojOdslusanihIspita = 0;
            if (brojOdslusanihIspitaField.getText().isEmpty()) {
                brojOdslusanihIspita = Integer.parseInt(brojOdslusanihField2.getText());
            } else {
                brojOdslusanihIspita = Integer.parseInt(brojOdslusanihIspitaField.getText());
            }

            String nazivFakulteta = (String) nazivFakultetaCombo.getSelectedItem();

            short brojObnovljenihGodina = 0;
            if (brojObnovljenihGodinaField.getText().isEmpty()) {
                brojObnovljenihGodina = Short.parseShort(brojObnovljenihGodinaField2.getText());
            } else {
                brojObnovljenihGodina = Short.parseShort(brojObnovljenihGodinaField.getText());
            }

            String telefon = "";
            if (telefonField.getText().isEmpty()) {
                telefon = telefonField2.getText();
            } else {
                telefon = telefonField.getText();
            }

            String email;
            if (emailField.getText().isEmpty()) {
                email = emailField2.getText();
            } else {
                email = emailField.getText();
            }

            String napomena = napomenaText.getText();
            String username = LoginForm.username;

            double kazneniBodovi = 0;
            if (kazneniBodoviField.getText().isEmpty()) {
                kazneniBodovi = abs(Double.parseDouble(kazneniBodoviField2.getText()));
            } else {
                kazneniBodovi = abs(Double.parseDouble(kazneniBodoviField.getText()));
            }

            String skolskaGodina = skolskaGodinaField.getText();

            if (!skolskaGodina.matches("\\d{4}/\\d{4}")) {
                KonkursniRadnikForm.pozoviOptionPane(this, "Pogrešno unijeta školska godina. Potreban format je xxxx/yyyy.", "Greška!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SocijalniStatusDTO socijalniStatus = new SocijalniStatusDTO();
            socijalniStatus.setBezJednogRoditelja(bezJednogRoditeljaCheck1.isSelected());
            socijalniStatus.setBezObaRoditelja(bezObaRoditeljaCheck1.isSelected());
            socijalniStatus.setDijetePalogINestalogBorcaRS(dijetePalogINestalogCheck1.isSelected());
            socijalniStatus.setDijeteRVIVRS(dijeteRVIVRSCheck1.isSelected());
            socijalniStatus.setInvaliditet(invaliditetCheck1.isSelected());
            socijalniStatus.setJedanRoditeljNezaposlen(jedanRoditeljNezaposlenCheck1.isSelected());
            socijalniStatus.setKorisnikSocijalnePomoci(korisnikSocijalnePomociCheck1.isSelected());
            socijalniStatus.setObaRoditeljaNezaposlena(obaRoditeljaNezaposlenaCheck1.isSelected());
            socijalniStatus.setStudentIzViseclanihPorodica(studentIzViseclanePorodiceCheck1.isSelected());

            int idSocijalnogStatusa = -1;

            int postojiLi = DAOFactory.getDAOFactory().getSocijalniStatusDAO().daLiPostojiOvakav(socijalniStatus);
            if (postojiLi == -1) {
                DAOFactory.getDAOFactory().getSocijalniStatusDAO().dodajSocijalniStatus(socijalniStatus);
                idSocijalnogStatusa = DAOFactory.getDAOFactory().getSocijalniStatusDAO().daLiPostojiOvakav(socijalniStatus);
            } else {
                idSocijalnogStatusa = postojiLi;
            }

            socijalniStatus.setIdSocijalnogStatusa(idSocijalnogStatusa);

            String ime;
            String prezime;

            if (!imeField.getText().isEmpty() || !prezimeField.getText().isEmpty()) {
                if (imeField.getText().isEmpty()) {
                    ime = imeField2.getText();
                } else {
                    ime = imeField.getText();
                }

                if (prezimeField.getText().isEmpty()) {
                    prezime = prezimeField2.getText();
                } else {
                    prezime = prezimeField.getText();
                }

                StudentDTO stari = DAOFactory.getDAOFactory().getStudentDAO().student(JMBField.getText());
                StudentDTO novi = new StudentDTO(JMBField.getText(), ime, prezime, stari.getDatumRodjenja());
                DAOFactory.getDAOFactory().getStudentDAO().azurirajStudenta(novi);
            }

            PrijavaNaKonkursDTO novaPrijava = new PrijavaNaKonkursDTO();
            novaPrijava.setIdPrijave(Integer.parseInt(idPrijaveField.getText()));
            novaPrijava.setBrojObnovljenihGodina(brojObnovljenihGodina);
            novaPrijava.setBrojPoste(brojPoste);
            novaPrijava.setEmail(email);
            novaPrijava.setGodinaStudija((short) godinaStudija);
            novaPrijava.setIdSocijalnogStatusa(idSocijalnogStatusa);
            novaPrijava.setJMB(jmb);
            novaPrijava.setKazneniBodovi(kazneniBodovi);
            novaPrijava.setNapomena(napomena);
            novaPrijava.setNazivFakulteta(nazivFakulteta);
            novaPrijava.setProsjekOcjena(prosjekOcjena);
            novaPrijava.setSkolskaGodina(skolskaGodina);
            novaPrijava.setTelefon(telefon);
            novaPrijava.setUsername(username);
            novaPrijava.setBrojPolozenihIspita(brojPolozenihIspita);
            novaPrijava.setBrojOdslusanihIspita(brojOdslusanihIspita);

            double brojBodova = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().azurirajPrijavu(novaPrijava);

            KonkursniRadnikForm.pozoviOptionPane(this, "Novi broj bodova prijave je " + brojBodova, "", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            KonkursniRadnikForm.pozoviOptionPane(this, "Greška pri unosu.", "Greška!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();
    }//GEN-LAST:event_sacuvajButtonActionPerformed

    private void odustaniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odustaniButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_odustaniButtonActionPerformed

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
            java.util.logging.Logger.getLogger(IzmijeniPrijavuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzmijeniPrijavuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzmijeniPrijavuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzmijeniPrijavuDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IzmijeniPrijavuDialog dialog = new IzmijeniPrijavuDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField JMBField;
    private javax.swing.JCheckBox bezJednogRoditeljaCheck1;
    private javax.swing.JCheckBox bezJednogRoditeljaCheck2;
    private javax.swing.JCheckBox bezObaRoditeljaCheck1;
    private javax.swing.JCheckBox bezObaRoditeljaCheck2;
    private javax.swing.JTextField brojObnovljenihGodinaField;
    private javax.swing.JTextField brojObnovljenihGodinaField2;
    private javax.swing.JTextField brojOdslusanihField2;
    private javax.swing.JTextField brojOdslusanihIspitaField;
    private javax.swing.JTextField brojPolozenihField2;
    private javax.swing.JTextField brojPolozenihIspitaField;
    private javax.swing.JTextField brojPosteField;
    private javax.swing.JTextField brojPosteField2;
    private javax.swing.JCheckBox dijetePalogINestalogCheck1;
    private javax.swing.JCheckBox dijetePalogINestalogCheck2;
    private javax.swing.JCheckBox dijeteRVIVRSCheck1;
    private javax.swing.JCheckBox dijeteRVIVRSCheck2;
    private javax.swing.JLabel e;
    private javax.swing.JLabel ee;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField emailField2;
    private javax.swing.JTextField fakultetField2;
    private javax.swing.JTextField godinaStudijaField;
    private javax.swing.JTextField godinaStudijaField2;
    private javax.swing.JTextField idPrijaveField;
    private javax.swing.JTextField imeField;
    private javax.swing.JTextField imeField2;
    private javax.swing.JCheckBox invaliditetCheck1;
    private javax.swing.JCheckBox invaliditetCheck2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox jedanRoditeljNezaposlenCheck1;
    private javax.swing.JCheckBox jedanRoditeljNezaposlenCheck2;
    private javax.swing.JTextField kazneniBodoviField;
    private javax.swing.JTextField kazneniBodoviField2;
    private javax.swing.JCheckBox korisnikSocijalnePomociCheck1;
    private javax.swing.JCheckBox korisnikSocijalnePomociCheck2;
    private javax.swing.JTextField napomenaText;
    private javax.swing.JComboBox<String> nazivFakultetaCombo;
    private javax.swing.JCheckBox obaRoditeljaNezaposlenaCheck1;
    private javax.swing.JCheckBox obaRoditeljaNezaposlenaCheck2;
    private javax.swing.JButton odustaniButton;
    private javax.swing.JTextField prezimeField;
    private javax.swing.JTextField prezimeField2;
    private javax.swing.JButton prikaziBazuMjestaPrebivalistaButton;
    private javax.swing.JTextField prosjekOcjenaField;
    private javax.swing.JTextField prosjekOcjenaField2;
    private javax.swing.JButton sacuvajButton;
    private javax.swing.JTextField skolskaGodinaField;
    private javax.swing.JCheckBox studentIzViseclanePorodiceCheck1;
    private javax.swing.JCheckBox studentIzViseclanePorodiceCheck2;
    private javax.swing.JTextField telefonField;
    private javax.swing.JTextField telefonField2;
    // End of variables declaration//GEN-END:variables
}
