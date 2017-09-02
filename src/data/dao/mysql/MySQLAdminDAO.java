/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao.mysql;

import data.dao.AdminDAO;
import data.dto.AdminDTO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DulleX
 */
public class MySQLAdminDAO implements AdminDAO {

    @Override
    public AdminDTO admin(String username) {
        List<AdminDTO> retVal = admini();
        for (AdminDTO konk : retVal) {
            if (username.equals(konk.getUsername())) {
                return konk;
            }
        }
        return null;
    }

    @Override
    public List<AdminDTO> admini() {
        List<AdminDTO> retVal = new ArrayList<AdminDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Username "
                + "FROM administrator "
                + "ORDER BY Username ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new AdminDTO(rs.getString("Username")));
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
                for (AdminDTO adm : retVal) {
                    if (adm.getUsername().equals(rs2.getString("Username"))) {
                        adm.setPasswordHash(rs2.getString("PasswordHash"));
                        adm.setSalt(rs2.getString("Salt"));
                        adm.setIme(rs2.getString("Ime"));
                        adm.setPrezime(rs2.getString("Prezime"));
                        adm.setJMB(rs2.getString("JMB"));
                        adm.setDatumKreiranjaNaloga(rs2.getDate("DatumKreiranjaNaloga"));
                        adm.setValidanNalog(rs2.getBoolean("ValidanNalog"));
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
    public boolean dodajAdmina(AdminDTO admin) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO radnik(Username, PasswordHash, Salt, Ime, Prezime, JMB, "
                + "DatumKreiranjaNaloga, ValidanNalog) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPasswordHash());
            ps.setString(3, admin.getSalt());
            ps.setString(4, admin.getIme());
            ps.setString(5, admin.getPrezime());
            ps.setString(6, admin.getJMB());
            ps.setDate(7, admin.getDatumKreiranjaNaloga());
            ps.setBoolean(8, admin.isValidanNalog());

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

        String query2 = "INSERT INTO administrator VALUES "
                + "(?) ";

        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setString(1, admin.getUsername());

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
    public boolean azurirajAdmina(AdminDTO admin, String stariUsername) {
        boolean retVal3 = false;
        Connection conn3 = null;
        PreparedStatement ps3 = null;

        String query3 = "DELETE FROM administrator "
                + "WHERE Username=? ";
        try {
            conn3 = ConnectionPool.getInstance().checkOut();
            ps3 = conn3.prepareStatement(query3);
            ps3.setString(1, stariUsername);

            retVal3 = ps3.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLKonkursniRadnikDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn3);
            DBUtilities.getInstance().close(ps3);
        }

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
                + "ValidanNalog=?, "
                + "Username=? "
                + "WHERE Username=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, admin.getPasswordHash());
            ps.setString(2, admin.getSalt());
            ps.setString(3, admin.getIme());
            ps.setString(4, admin.getPrezime());
            ps.setString(5, admin.getJMB());
            ps.setDate(6, admin.getDatumKreiranjaNaloga());
            ps.setBoolean(7, admin.isValidanNalog());
            ps.setString(8, admin.getUsername());
            ps.setString(9, stariUsername);

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

        String query2 = "INSERT INTO administrator VALUES "
                + "(?) ";

        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setString(1, admin.getUsername());

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
    public boolean obrisiAdmina(String username) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM administrator "
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
