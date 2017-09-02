package data.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.SocijalniStatusDAO;
import data.dto.SocijalniStatusDTO;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLSocijalniStatusDAO implements SocijalniStatusDAO {

    @Override
    public int daLiPostojiOvakav(SocijalniStatusDTO soc) {
        List<SocijalniStatusDTO> retVal = socijalniStatusi();
        boolean flag = true;
        for (SocijalniStatusDTO izBaze : retVal) {
            flag = true;
            if (izBaze.isBezJednogRoditelja() != soc.isBezJednogRoditelja()) {
                flag = false;
            }
            if (izBaze.isBezObaRoditelja() != soc.isBezObaRoditelja()) {
                flag = false;
            }
            if (izBaze.isDijetePalogINestalogBorcaRS() != soc.isDijetePalogINestalogBorcaRS()) {
                flag = false;
            }
            if (izBaze.isDijeteRVIVRS() != soc.isDijeteRVIVRS()) {
                flag = false;
            }
            if (izBaze.isInvaliditet() != soc.isInvaliditet()) {
                flag = false;
            }
            if (izBaze.isJedanRoditeljNezaposlen() != soc.isJedanRoditeljNezaposlen()) {
                flag = false;
            }
            if (izBaze.isKorisnikSocijalnePomoci() != soc.isKorisnikSocijalnePomoci()) {
                flag = false;
            }
            if (izBaze.isObaRoditeljaNezaposlena() != soc.isObaRoditeljaNezaposlena()) {
                flag = false;
            }
            if (izBaze.isStudentIzViseclanihPorodica() != soc.isStudentIzViseclanihPorodica()) {
                flag = false;
            }
            if (flag == true) {
                return izBaze.getIdSocijalnogStatusa();
            }
        }
        return -1;
    }

    @Override
    public SocijalniStatusDTO socijalniStatus(int idSocijalnogStatusa) {
        List<SocijalniStatusDTO> retVal = socijalniStatusi();
        for (SocijalniStatusDTO soc : retVal) {
            if (soc.getIdSocijalnogStatusa() == idSocijalnogStatusa) {
                return soc;
            }
        }
        return null;
    }

    @Override
    public List<SocijalniStatusDTO> socijalniStatusi() {
        List<SocijalniStatusDTO> retVal = new ArrayList<SocijalniStatusDTO>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT IdSocijalnogStatusa, BezObaRoditelja, DijetePalogINestalogBorcaRS, "
                + "BezJednogRoditelja, Invaliditet, KorisnikSocijalnePomoci, DijeteRVIVRS, "
                + "ObaRoditeljaNezaposlena, JedanRoditeljNezaposlen, StudentiIzViseclanihPorodica "
                + "FROM socijalni_status "
                + "ORDER BY IdSocijalnogStatusa ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new SocijalniStatusDTO(rs.getInt("IdSocijalnogStatusa"),
                        rs.getBoolean("BezObaRoditelja"), rs.getBoolean("DijetePalogINestalogBorcaRS"),
                        rs.getBoolean("BezJednogRoditelja"), rs.getBoolean("Invaliditet"),
                        rs.getBoolean("KorisnikSocijalnePomoci"), rs.getBoolean("DijeteRVIVRS"),
                        rs.getBoolean("ObaRoditeljaNezaposlena"), rs.getBoolean("JedanRoditeljNezaposlen"),
                        rs.getBoolean("StudentiIzViseclanihPorodica")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSocijalniStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }

    public String dodajSocijalniStatus(SocijalniStatusDTO socijalniStatus) {
        boolean retVal = false;
        Connection conn = null;
        CallableStatement cs = null;

        String uspjelo = "";

        String query = "{CALL dodaj_socijalni_status(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            cs = conn.prepareCall(query);
            cs.setBoolean(1, socijalniStatus.isBezObaRoditelja());
            cs.setBoolean(2, socijalniStatus.isDijetePalogINestalogBorcaRS());
            cs.setBoolean(3, socijalniStatus.isBezJednogRoditelja());
            cs.setBoolean(4, socijalniStatus.isInvaliditet());
            cs.setBoolean(5, socijalniStatus.isKorisnikSocijalnePomoci());
            cs.setBoolean(6, socijalniStatus.isDijeteRVIVRS());
            cs.setBoolean(7, socijalniStatus.isObaRoditeljaNezaposlena());
            cs.setBoolean(8, socijalniStatus.isJedanRoditeljNezaposlen());
            cs.setBoolean(9, socijalniStatus.isStudentIzViseclanihPorodica());
            cs.registerOutParameter(10, Types.BOOLEAN);
            cs.registerOutParameter(11, Types.VARCHAR);

            cs.execute();

            retVal = cs.getBoolean(10);
            if (!retVal) {
                uspjelo = cs.getString(11);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSocijalniStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(cs);
        }
        return uspjelo;
    }

    /* @Override
    public boolean dodajSocijalniStatus(SocijalniStatusDTO socijalniStatus) {
        boolean retVal = false;
	Connection conn = null;
	PreparedStatement ps = null;

        String query = "INSERT INTO socijalni_status(BezObaRoditelja, DijetePalogINestalogBorcaRS, "
                + "BezJednogRoditelja, Invaliditet, KorisnikSocijalnePomoci, "
                + "DijeteRVIVRS, ObaRoditeljaNezaposlena, JedanRoditeljNezaposlen, StudentiIzViseclanihPorodica) VALUES "
		+ "(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
		conn = ConnectionPool.getInstance().checkOut();
                ps = conn.prepareStatement(query);
		ps.setBoolean(1, socijalniStatus.isBezObaRoditelja());
		ps.setBoolean(2, socijalniStatus.isDijetePalogINestalogBorcaRS());
                ps.setBoolean(3, socijalniStatus.isBezJednogRoditelja());
                ps.setBoolean(4, socijalniStatus.isInvaliditet());
                ps.setBoolean(5, socijalniStatus.isKorisnikSocijalnePomoci());
                ps.setBoolean(6, socijalniStatus.isDijeteRVIVRS());
                ps.setBoolean(7, socijalniStatus.isObaRoditeljaNezaposlena());
                ps.setBoolean(8, socijalniStatus.isJedanRoditeljNezaposlen());
                ps.setBoolean(9, socijalniStatus.isStudentIzViseclanihPorodica());

                retVal = ps.executeUpdate() == 1;
	} catch (SQLException e) {
		e.printStackTrace();
                DBUtilities.getInstance().showSQLException(e);
	} catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSocijalniStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
		ConnectionPool.getInstance().checkIn(conn);
                DBUtilities.getInstance().close(ps);
	}
	return retVal;
    }
     */
    @Override
    public boolean azurirajSocijalniStatus(SocijalniStatusDTO socijalniStatus) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE socijalni_status SET "
                + "BezObaRoditelja=? "
                + "DijetePalogINestalogBorcaRS=? "
                + "BezJednogRoditelja=? "
                + "Invaliditet=? "
                + "KorisnikSocijalnePomoci=? "
                + "DijeterRVIVRS=? "
                + "ObaRoditeljaNezaposlena=? "
                + "JedanRoditeljNezaposle=? "
                + "StudentiIzViseclanihPorodica=? "
                + "WHERE IdSocijalnogStatusa=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, socijalniStatus.isBezObaRoditelja());
            ps.setBoolean(2, socijalniStatus.isDijetePalogINestalogBorcaRS());
            ps.setBoolean(3, socijalniStatus.isBezJednogRoditelja());
            ps.setBoolean(4, socijalniStatus.isInvaliditet());
            ps.setBoolean(5, socijalniStatus.isKorisnikSocijalnePomoci());
            ps.setBoolean(6, socijalniStatus.isDijeteRVIVRS());
            ps.setBoolean(7, socijalniStatus.isObaRoditeljaNezaposlena());
            ps.setBoolean(8, socijalniStatus.isJedanRoditeljNezaposlen());
            ps.setBoolean(9, socijalniStatus.isStudentIzViseclanihPorodica());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSocijalniStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean obrisiSocijalniStatus(int idSocijalnogStatusa) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM socijalni_status "
                + "WHERE IdSocijalnogStatusa=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, idSocijalnogStatusa);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSocijalniStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

}
