/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao.mysql;

import data.dao.DAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.SobaDAO;
import data.dto.SobaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aco
 */
public class MySQLSobaDAO implements SobaDAO{
    @Override
    public SobaDTO soba(int brojSobe, int brojPaviljona){
        List<SobaDTO> retVal = sobe();
        for (SobaDTO soba : retVal) {
            if (soba.getBrojSobe() == brojSobe && soba.getBrojPaviljona() == brojPaviljona) {
                return soba;
            }
        }
        return null;
    }
    
    @Override 
    public List<SobaDTO> sobe(){
        List<SobaDTO> retVal = new ArrayList<SobaDTO>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT BrojSobe, BrojPaviljona, BrojKreveta, BrojSlobodnihKreveta, ApsolventskaSoba "
                + "FROM soba "
                + "ORDER BY BrojSobe ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new SobaDTO(rs.getInt("BrojSobe"), rs.getInt("BrojPaviljona"),
                        rs.getInt("BrojKreveta"), rs.getInt("BrojSlobodnihKreveta"), 
                        rs.getBoolean("ApsolventskaSoba")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSobaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }
    @Override 
    public boolean dodajSobu(SobaDTO soba){
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO soba VALUES "
                + "(?, ?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, soba.getBrojSobe());
            ps.setInt(2, soba.getBrojPaviljona());
            ps.setInt(3, soba.getBrojKreveta());
            ps.setInt(4, soba.getBrojSlobodnihKreveta());
            ps.setBoolean(5, soba.getApsolventskaSoba());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLSobaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }
    
    @Override
    public boolean azurirajSobu(SobaDTO soba) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE soba SET "
                + "BrojKreveta=? "
                + "BrojSlobodnihKreveta=? "
                + "ApsolventskaSoba=? "
                + "WHERE BrojSobe=? && BrojPaviljona=? "; // DA LI MOZE OVAKO???
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, soba.getBrojKreveta());
            ps.setInt(2, soba.getBrojSlobodnihKreveta());
            ps.setBoolean(3, soba.getApsolventskaSoba());
            ps.setInt(4, soba.getBrojSobe());
            ps.setInt(5, soba.getBrojPaviljona());
            

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
    public boolean obrisiSobu(int brojSobe, int brojPaviljona) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM soba "
                + "WHERE BrojSobe=? && BrojPaviljona=?";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, brojSobe);
            ps.setInt(2, brojPaviljona);

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
}
