package data.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import data.dao.KonkursniRadnikDAO;
import data.dto.KonkursniRadnikDTO;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLKonkursniRadnikDAO implements KonkursniRadnikDAO {

    @Override
    public KonkursniRadnikDTO konkursniRadnik(String username) {
        List<KonkursniRadnikDTO> retVal = konkursniRadnici();
        for (KonkursniRadnikDTO konk : retVal) {
            if (username.equals(konk.getUsername())) {
                return konk;
            }
        }
        return null;
    }

    @Override
    public List<KonkursniRadnikDTO> konkursniRadnici() {
        List<KonkursniRadnikDTO> retVal = new ArrayList<KonkursniRadnikDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Username "
                + "FROM konkursni_radnik "
                + "ORDER BY Username ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new KonkursniRadnikDTO(rs.getString("Username")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }

        Connection conn2 = null;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        String query2 = "SELECT Username, PasswordHash, Salt, Ime, Prezime, JMB, DatumKreiranjaNaloga, ValidanNalog "
                + "FROM radnik "
                + "ORDER BY Username ASC ";

        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                for (KonkursniRadnikDTO konk : retVal) {
                    if (konk.getUsername().equals(rs2.getString("Username"))) {
                        konk.setPasswordHash(rs2.getString("PasswordHash"));
                        konk.setSalt(rs2.getString("Salt"));
                        konk.setIme(rs2.getString("Ime"));
                        konk.setPrezime(rs2.getString("Prezime"));
                        konk.setJMB(rs2.getString("JMB"));
                        konk.setDatumKreiranjaNaloga(rs2.getDate("DatumKreiranjaNaloga"));
                        konk.setValidanNalog(rs2.getBoolean("ValidanNalog"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }

        return retVal;
    }

    @Override
    public boolean dodajKonkursnogRadnika(KonkursniRadnikDTO konkursniRadnik) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO radnik(Username, PasswordHash, Salt, Ime, Prezime, JMB, "
                + "DatumKreiranjaNaloga, ValidanNalog) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, konkursniRadnik.getUsername());
            ps.setString(2, konkursniRadnik.getPasswordHash());
            ps.setString(3, konkursniRadnik.getSalt());
            ps.setString(4, konkursniRadnik.getIme());
            ps.setString(5, konkursniRadnik.getPrezime());
            ps.setString(6, konkursniRadnik.getJMB());
            ps.setDate(7, konkursniRadnik.getDatumKreiranjaNaloga());
            ps.setBoolean(8, konkursniRadnik.isValidanNalog());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        boolean retVal2 = false;
        Connection conn2 = null;
        PreparedStatement ps2 = null;

        String query2 = "INSERT INTO konkursni_radnik VALUES "
                + "(?) ";

        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setString(1, konkursniRadnik.getUsername());

            retVal2 = ps2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        return (retVal && retVal2);
    }

    @Override
    public boolean azurirajKonkursnogRadnika2(KonkursniRadnikDTO konkursniRadnik) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE radnik SET "
                + "PasswordHASH=?, "
                + "Salt=?, "
                + "Ime=?, "
                + "Prezime=?, "
                + "JMB=?, "
                + "DatumKreiranjaNaloga=?, "
                + "ValidanNalog=? "
                + "WHERE Username=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, konkursniRadnik.getPasswordHash());
            ps.setString(2, konkursniRadnik.getSalt());
            ps.setString(3, konkursniRadnik.getIme());
            ps.setString(4, konkursniRadnik.getPrezime());
            ps.setString(5, konkursniRadnik.getJMB());
            ps.setDate(6, konkursniRadnik.getDatumKreiranjaNaloga());
            ps.setBoolean(7, konkursniRadnik.isValidanNalog());
            ps.setString(8, konkursniRadnik.getUsername());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        return retVal;
    }

    @Override
    public boolean azurirajKonkursnogRadnika(KonkursniRadnikDTO konkursniRadnik, String stariUsername) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE radnik SET "
                + "PasswordHASH=?, "
                + "Salt=?, "
                + "Ime=?, "
                + "Prezime=?, "
                + "JMB=?, "
                + "DatumKreiranjaNaloga=?, "
                + "ValidanNalog=? "
                + "WHERE Username=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, konkursniRadnik.getPasswordHash());
            ps.setString(2, konkursniRadnik.getSalt());
            ps.setString(3, konkursniRadnik.getIme());
            ps.setString(4, konkursniRadnik.getPrezime());
            ps.setString(5, konkursniRadnik.getJMB());
            ps.setDate(6, konkursniRadnik.getDatumKreiranjaNaloga());
            ps.setBoolean(7, konkursniRadnik.isValidanNalog());
            ps.setString(8, stariUsername);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        return retVal;
    }

    @Override
    public boolean obrisiKonkursnogRadnika(String username) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM konkursni_radnik "
                + "WHERE Username=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        boolean retVal2 = false;
        Connection conn2 = null;
        PreparedStatement ps2 = null;

        String query2 = "DELETE FROM radnik "
                + "WHERE Username=? ";

        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setString(1, username);

            retVal2 = ps2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }

        return (retVal && retVal2);
    }

    @Override
    public String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return generatedPassword;
    }

}
