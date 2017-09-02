/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao.mysql;

import data.dao.UplatnicaZaRecepcijuDAO;
import data.dto.UplatnicaZaRecepcijuDTO;
import data.dto.UplatnicaZaZaduzenjeDTO;
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
public class MySQLUplatnicaZaRecepcijuDAO implements UplatnicaZaRecepcijuDAO{

    @Override
    public List<UplatnicaZaRecepcijuDTO> recepcijeStudenta(String JMB) {
        List<UplatnicaZaRecepcijuDTO> retVal = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


         String query = "SELECT u.IdUplatnice, DatumUplate, IznosUplate, Username, BrojSobe, BrojPaviljona, JMB, SkolskaGodina  "
                + "FROM uplatnica u"
                + "INNER JOIN uplatnica_za_recepciju k ON u.IdUplatnice = k.IdUplatnice "
                + "WHERE k.JMB = ? ";
        
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, JMB);
            

            rs = ps.executeQuery();
            while(rs.next())
            {
                 retVal.add(new UplatnicaZaRecepcijuDTO(rs.getInt("IdUplatnice"), rs.getDate("DatumUplate"),
                        rs.getFloat("IznosUplate"), rs.getString("Username"), rs.getString("JMB"), rs.getInt("BrojSobe"), rs.getShort("BrojPaviljona"), rs.getString("SkolskaGodina")));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        
        return retVal;
    }

    @Override
    public List<UplatnicaZaRecepcijuDTO> sveRecepcije() {
        List<UplatnicaZaRecepcijuDTO> retVal = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT IdUplatnice, DatumUplate, IznosUplate, Username, JMB, BrojSobe, BrojPaviljona, SkolskaGodina  "
                + "FROM uplatnica u"
                + "INNER JOIN uplatnica_za_recepciju k USING(IdUplatnice) "
                + "ORDER BY IdUplatnice ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new UplatnicaZaRecepcijuDTO(rs.getInt("IdUplatnice"), rs.getDate("DatumUplate"),
                        rs.getFloat("IznosUplate"), rs.getString("Username"), rs.getString("JMB"), rs.getInt("BrojSobe"), rs.getShort("BrojPaviljona"), rs.getString("SkolskaGodina")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }

    @Override
    public boolean dodaj(UplatnicaZaRecepcijuDTO uplatnica) {
        boolean retVal2 = false;
        Connection conn2 = null;
        PreparedStatement ps2 = null;

        String query2 = "INSERT INTO uplatnica(IdUplatnice, DatumUplate, IznosUplate, Username) VALUES "
                + "(?, ?, ?, ?) ";
        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setInt(1, uplatnica.getIdUplatnice());
            ps2.setDate(2, uplatnica.getDatumUplate());
            ps2.setFloat(3, uplatnica.getIznosUplate());
            ps2.setString(4, uplatnica.getUsername());

            retVal2 = ps2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn2);
            DBUtilities.getInstance().close(ps2);
        }
            
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO uplatnica_za_recepciju(IdUplatnice, JMB, BrojSobe, BrojPaviljona, SkolskaGodina) VALUES "
                + "(?, ?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uplatnica.getIdUplatnice());
            ps.setString(2, uplatnica.getJMB());
            ps.setInt(3, uplatnica.getBrojSobe());
            ps.setShort(4, uplatnica.getBrojPaviljona());
            ps.setString(5, uplatnica.getSkolskaGodina());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean azuriraj(UplatnicaZaRecepcijuDTO uplatnica) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE uplatnica SET "
                + "DatumUplate=?, "
                + "IznosUplate=?, "
                + "Username=? "
                + "WHERE IdUplatnice=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setDate(1, uplatnica.getDatumUplate());
            ps.setFloat(2, uplatnica.getIznosUplate());
            ps.setString(3, uplatnica.getUsername());
            ps.setInt(4, uplatnica.getIdUplatnice());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        
        
        boolean retVal2 = false;
        Connection conn2 = null;
        PreparedStatement ps2 = null;

        String query2 = "UPDATE uplatnica_za_recepciju SET "
                + "JMB=?, "
                + "BrojSobe=?, "
                + "BrojPaviljona=? "
                + "SkolskaGodina=? "
                + "WHERE IdUplatnice=? ";
        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setString(1, uplatnica.getJMB());
            ps2.setInt(2, uplatnica.getBrojSobe());
            ps2.setShort(3, uplatnica.getBrojPaviljona());
            ps2.setString(4, uplatnica.getSkolskaGodina());
            ps2.setInt(5, uplatnica.getIdUplatnice());

            retVal2 = ps2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal2;
    }

    @Override
    public boolean obrisi(UplatnicaZaRecepcijuDTO uplatnica) {
         boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM uplatanica_za_recepciju "
                + "WHERE IdUplatnice=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uplatnica.getIdUplatnice());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        
        boolean retVal2 = false;
        Connection conn2 = null;
        PreparedStatement ps2 = null;

        String query2 = "DELETE FROM uplatnica "
                + "WHERE IdUplatnice=? ";
        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query);
            ps2.setInt(1, uplatnica.getIdUplatnice());

            retVal2 = ps2.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal2;
    }
    
}
