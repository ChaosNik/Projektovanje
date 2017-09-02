package data.dao.mysql;

import data.dao.DAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.PrijavaNaKonkursDAO;
import data.dto.MjestoPrebivalistaDTO;
import data.dto.PrijavaNaKonkursDTO;
import data.dto.SocijalniStatusDTO;
import java.sql.CallableStatement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLPrijavaNaKonkursDAO implements PrijavaNaKonkursDAO {

    @Override
    public PrijavaNaKonkursDTO prijava(String JMB, String skolskaGodina) {
        List<PrijavaNaKonkursDTO> retVal = prijave(skolskaGodina);
        for (PrijavaNaKonkursDTO prijava : retVal) {
            if (prijava.getJMB().equals(JMB) && prijava.getSkolskaGodina().equals(skolskaGodina)) {
                return prijava;
            }
        }
        return null;
    }

    @Override
    public PrijavaNaKonkursDTO prijava(int idPrijave, String skolskaGodina) {
        List<PrijavaNaKonkursDTO> retVal = prijave(skolskaGodina);
        for (PrijavaNaKonkursDTO prijava : retVal) {
            if (prijava.getIdPrijave() == idPrijave) {
                return prijava;
            }

        }
        return null;
    }

    @Override
    public List<PrijavaNaKonkursDTO> prijave(String skolskaGodina) {
        List<PrijavaNaKonkursDTO> retVal = new ArrayList<PrijavaNaKonkursDTO>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT IdPrijave, SkolskaGodina, JMB, IdSocijalnogStatusa, GodinaStudija, "
                + "ProsjekOcjena, BrojPoste, NazivFakulteta, BrojObnovljenihGodina, Napomena, "
                + "Username, Telefon, Email, KazneniBodovi, BrojOdslusanihIspita, BrojPolozenihIspita "
                + "FROM prijava_na_konkurs "
                + "WHERE SkolskaGodina=? "
                + "ORDER BY SkolskaGodina, NazivFakulteta, IdPrijave ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, skolskaGodina);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new PrijavaNaKonkursDTO(rs.getInt("IdPrijave"), rs.getString("SkolskaGodina"),
                        rs.getString("JMB"), rs.getInt("IdSocijalnogStatusa"), rs.getShort("GodinaStudija"),
                        rs.getDouble("ProsjekOcjena"), rs.getInt("BrojPoste"), rs.getString("NazivFakulteta"),
                        rs.getShort("BrojObnovljenihGodina"), rs.getString("Napomena"), rs.getString("Username"),
                        rs.getString("Telefon"), rs.getString("Email"), rs.getDouble("KazneniBodovi"), rs.getInt("BrojOdslusanihIspita"), rs.getInt("BrojPolozenihIspita")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLPrijavaNaKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }

    @Override
    public double dodajPrijavu(PrijavaNaKonkursDTO prijava) {
        double brojBodova = 0;
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO prijava_na_konkurs(SkolskaGodina, JMB, "
                + "IdSocijalnogStatusa, GodinaStudija, ProsjekOcjena, brojPoste, NazivFakulteta, "
                + "BrojObnovljenihGodina, Napomena, Username, Telefon, Email, KazneniBodovi, BrojOdslusanihIspita, BrojPolozenihIspita) VALUE"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, prijava.getSkolskaGodina());
            ps.setString(2, prijava.getJMB());
            ps.setInt(3, prijava.getIdSocijalnogStatusa());
            ps.setShort(4, prijava.getGodinaStudija());
            ps.setDouble(5, prijava.getProsjekOcjena());
            ps.setInt(6, prijava.getBrojPoste());
            ps.setString(7, prijava.getNazivFakulteta());
            ps.setShort(8, prijava.getBrojObnovljenihGodina());
            ps.setString(9, prijava.getNapomena());
            ps.setString(10, prijava.getUsername());
            ps.setString(11, prijava.getTelefon());
            ps.setString(12, prijava.getEmail());
            ps.setDouble(13, prijava.getKazneniBodovi());
            ps.setInt(14, prijava.getBrojOdslusanihIspita());
            ps.setInt(15, prijava.getBrojPolozenihIspita());

            retVal = ps.executeUpdate() == 1;

            PrijavaNaKonkursDTO izBaze = prijava(prijava.getJMB(), prijava.getSkolskaGodina());

            brojBodova = bodujPrijavu(izBaze.getSkolskaGodina(), izBaze.getJMB());

        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLPrijavaNaKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return brojBodova;
    }

    public double bodujPrijavu(String skolskaGodina, String JMB) {

        /* double brojBodova = 0;
    double bezObaRoditelja = 12;
    double dijetePalogINestalogBorcaRS = 10;
    double bezJednogRoditelja = 6;
    double invaliditet = 8;
    double dijeteRVIVRS = 8;
    double korisnikSocijalnePomoci = 5;
    double obaRoditeljaNezaposlena = 1;
    double jedanRoditeljNezaposlen = 0.5;
    double studentiIzViseclanihPorodica =  2;
    
    double jednomObnovioGodinu = -1;
    double dvaputObnovioGodinu = -3;
    double triputObnovioGodinu = -5;
    double visePutaObnovioGodinu = -10;
    
    double viseOd200KM = 0.9;
    double viseOd100KM = 0.6;
    double viseOd30KM = 0.3;*/
        ResourceBundle bundle = PropertyResourceBundle.getBundle("data.dao.mysql.BodovanjePrijava");
        double bezObaRoditelja = Double.parseDouble(bundle.getString("bezObaRoditelja"));
        double dijetePalogINestalogBorcaRS = Double.parseDouble(bundle.getString("dijetePalogINestalogBorcaRS"));
        double bezJednogRoditelja = Double.parseDouble(bundle.getString("bezJednogRoditelja"));
        double invaliditet = Double.parseDouble(bundle.getString("invaliditet"));
        double dijeteRVIVRS = Double.parseDouble(bundle.getString("dijeteRVIVRS"));
        double korisnikSocijalnePomoci = Double.parseDouble(bundle.getString("korisnikSocijalnePomoci"));
        double obaRoditeljaNezaposlena = Double.parseDouble(bundle.getString("obaRoditeljaNezaposlena"));
        double jedanRoditeljNezaposlen = Double.parseDouble(bundle.getString("jedanRoditeljNezaposlen"));
        double studentiIzViseclanihPorodica = Double.parseDouble(bundle.getString("studentiIzViseclanihPorodica"));
        double jednomObnovioGodinu = Double.parseDouble(bundle.getString("jednomObnovioGodinu"));
        double dvaputObnovioGodinu = Double.parseDouble(bundle.getString("dvaputObnovioGodinu"));
        double triputObnovioGodinu = Double.parseDouble(bundle.getString("triputObnovioGodinu"));
        double visePutaObnovioGodinu = Double.parseDouble(bundle.getString("visePutaObnovioGodinu"));
        double viseOd200KM = Double.parseDouble(bundle.getString("viseOd200KM"));
        double viseOd100KM = Double.parseDouble(bundle.getString("viseOd100KM"));
        double viseOd30KM = Double.parseDouble(bundle.getString("viseOd30KM"));
        double faktorZaGodinuStudija = Double.parseDouble(bundle.getString("faktorZaGodinuStudija"));
        double faktorZaProsjekOcjenaPrvaGodina = Double.parseDouble(bundle.getString("faktorZaProsjekPrvaGodina"));
        double faktorZaProsjekOcjenaOstaleGodine = Double.parseDouble(bundle.getString("faktorZaProsjekOstaleGodine"));

        double brojBodova = 0;

        PrijavaNaKonkursDTO pri = prijava(JMB, skolskaGodina);
        SocijalniStatusDTO soc = DAOFactory.getDAOFactory().getSocijalniStatusDAO().socijalniStatus(pri.getIdSocijalnogStatusa());
        MjestoPrebivalistaDTO mjesto = DAOFactory.getDAOFactory().getMjestoPrebivalistaDAO().mjestoPrebivalista(pri.getBrojPoste());

        if (soc != null && mjesto != null) {
            if (soc.isBezJednogRoditelja()) {
                brojBodova += bezJednogRoditelja;
            }
            if (soc.isBezObaRoditelja()) {
                brojBodova += bezObaRoditelja;
            }
            if (soc.isDijetePalogINestalogBorcaRS()) {
                brojBodova += dijetePalogINestalogBorcaRS;
            }
            if (soc.isDijeteRVIVRS()) {
                brojBodova += dijeteRVIVRS;
            }
            if (soc.isInvaliditet()) {
                brojBodova += invaliditet;
            }
            if (soc.isJedanRoditeljNezaposlen()) {
                brojBodova += jedanRoditeljNezaposlen;
            }
            if (soc.isKorisnikSocijalnePomoci()) {
                brojBodova += korisnikSocijalnePomoci;
            }
            if (soc.isObaRoditeljaNezaposlena()) {
                brojBodova += obaRoditeljaNezaposlena;
            }
            if (soc.isStudentIzViseclanihPorodica()) {
                brojBodova += studentiIzViseclanihPorodica;
            }

            if (pri.getBrojObnovljenihGodina() > 3) {
                brojBodova += visePutaObnovioGodinu;
            } else if (pri.getBrojObnovljenihGodina() == 3) {
                brojBodova += triputObnovioGodinu;
            } else if (pri.getBrojObnovljenihGodina() == 2) {
                brojBodova += dvaputObnovioGodinu;
            } else if (pri.getBrojObnovljenihGodina() == 1) {
                brojBodova += jednomObnovioGodinu;
            }

            if (mjesto.getUdaljenost() > 200) {
                brojBodova += viseOd200KM;
            } else if (mjesto.getUdaljenost() > 100) {
                brojBodova += viseOd100KM;
            } else if (mjesto.getUdaljenost() > 30) {
                brojBodova += viseOd30KM;
            }

            if (pri.getBrojOdslusanihIspita() != 0) {
                brojBodova += ((double) pri.getBrojPolozenihIspita() / (double) pri.getBrojOdslusanihIspita());
            }

            if (pri.getGodinaStudija() > 1) {
                brojBodova += pri.getProsjekOcjena() * faktorZaProsjekOcjenaOstaleGodine;
            } else {
                brojBodova += pri.getProsjekOcjena() * faktorZaProsjekOcjenaPrvaGodina;
            }

            brojBodova += pri.getGodinaStudija() * faktorZaGodinuStudija;
            brojBodova -= pri.getKazneniBodovi();

        }

        double retVal = -1;
        Connection conn = null;
        CallableStatement cs = null;

        String query = "{CALL azurirajRezultat(?, ?)}";
        try {
            try {
                conn = ConnectionPool.getInstance().checkOut();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLPrijavaNaKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DecimalFormat df = new DecimalFormat("####0.00");
            double rez = Double.parseDouble(df.format(brojBodova));
            cs = conn.prepareCall(query);
            cs.setInt(1, pri.getIdPrijave());
            cs.setDouble(2, rez);

            cs.execute();
            //retVal = cs.getDouble(3);
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(cs);
        }
        return brojBodova;
    }

    @Override
    public double azurirajPrijavu(PrijavaNaKonkursDTO prijava) {
        boolean retVal = false;
        double brojBodova = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE prijava_na_konkurs SET "
                + "JMB=?, "
                + "IdSocijalnogStatusa=?, "
                + "GodinaStudija=?, "
                + "ProsjekOcjena=?, "
                + "BrojPoste=?, "
                + "NazivFakulteta=?, "
                + "BrojObnovljenihGodina=?, "
                + "Napomena=?, "
                + "Username=?, "
                + "Telefon=?, "
                + "Email=?, "
                + "KazneniBodovi=?, "
                + "BrojOdslusanihIspita=?, "
                + "BrojPolozenihIspita=? "
                + "WHERE IdPrijave=? ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, prijava.getJMB());
            ps.setInt(2, prijava.getIdSocijalnogStatusa());
            ps.setShort(3, prijava.getGodinaStudija());
            ps.setDouble(4, prijava.getProsjekOcjena());
            ps.setInt(5, prijava.getBrojPoste());
            ps.setString(6, prijava.getNazivFakulteta());
            ps.setShort(7, prijava.getBrojObnovljenihGodina());
            ps.setString(8, prijava.getNapomena());
            ps.setString(9, prijava.getUsername());
            ps.setString(10, prijava.getTelefon());
            ps.setString(11, prijava.getEmail());
            ps.setDouble(12, prijava.getKazneniBodovi());
            ps.setInt(13, prijava.getBrojOdslusanihIspita());
            ps.setInt(14, prijava.getBrojPolozenihIspita());
            ps.setInt(15, prijava.getIdPrijave());

            retVal = ps.executeUpdate() == 1;

            PrijavaNaKonkursDTO izBaze = prijava(prijava.getJMB(), prijava.getSkolskaGodina());

            brojBodova = bodujPrijavu(izBaze.getSkolskaGodina(), izBaze.getJMB());
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLPrijavaNaKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return brojBodova;
    }

    @Override
    public boolean obrisiPrijavu(int idPrijave) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM prijava_na_konkurs "
                + "WHERE IdPrijave=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idPrijave);

            retVal = ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLPrijavaNaKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

}
