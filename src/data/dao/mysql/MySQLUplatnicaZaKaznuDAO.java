/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao.mysql;

import data.dao.UplatnicaZaKaznuDAO;
import data.dto.UplatnicaZaKaznuDTO;
import data.dto.UplatnicaZaStanarinuDTO;
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
public class MySQLUplatnicaZaKaznuDAO implements UplatnicaZaKaznuDAO{

    @Override
    public List<UplatnicaZaKaznuDTO> kazneStudenta(String JMB) {
        List<UplatnicaZaKaznuDTO> retVal = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


         String query = "SELECT IdUplatnice, DatumUplate, IznosUplate, Username, IdKazne  "
                + "FROM uplatnica u"
                + "INNER JOIN uplatnica_za_kaznu k USING(IdUplatnice) "
                + "INNER JOIN kazna t ON k.IdKazne = t.IdKazne"
                + "WHERE JMB = ? ";
        
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, JMB);
            

            rs = ps.executeQuery();
            while(rs.next())
            {
                 retVal.add(new UplatnicaZaKaznuDTO(rs.getInt("IdUplatnice"), rs.getDate("DatumUplate"),
                        rs.getFloat("IznosUplate"), rs.getString("Username"), rs.getInt("IdKazne")));
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
    public List<UplatnicaZaKaznuDTO> sveKazne() {
        List<UplatnicaZaKaznuDTO> retVal = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT IdUplatnice, DatumUplate, IznosUplate, Username, IdKazne  "
                + "FROM uplatnica u"
                + "INNER JOIN uplatnica_za_kaznu k USING(IdUplatnice) "
                + "ORDER BY IdUplatnice ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new UplatnicaZaKaznuDTO(rs.getInt("IdUplatnice"), rs.getDate("DatumUplate"),
                        rs.getFloat("IznosUplate"), rs.getString("Username"), rs.getInt("IdKazne")));
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
    public boolean dodaj(UplatnicaZaKaznuDTO uplatnica) {
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

        String query = "INSERT INTO uplatnica_za_kaznu(IdKazne, IdUplatnice) VALUES "
                + "(?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uplatnica.getIdKazne());
            ps.setInt(2, uplatnica.getIdUplatnice());

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
    public boolean azuriraj(UplatnicaZaKaznuDTO uplatnica) {
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

        String query2 = "UPDATE uplatnica_za_kaznu SET "
                + "IdKazne=? "
                + "WHERE IdUplatnice=? ";
        try {
            conn2 = ConnectionPool.getInstance().checkOut();
            ps2 = conn2.prepareStatement(query2);
            ps2.setInt(1, uplatnica.getIdKazne());
            ps2.setInt(2, uplatnica.getIdUplatnice());

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
    public boolean obrisi(UplatnicaZaStanarinuDTO uplatnica) {
         boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM uplatnica_za_kaznu "
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
