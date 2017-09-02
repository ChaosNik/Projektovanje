/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao.mysql;

import data.dao.IzvjestajiDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DulleX
 */
public class MySQLIzvjestajiDAO implements IzvjestajiDAO {

    @Override
    public Vector<Vector<Object>> rezultati() {
        Vector<Vector<Object>> retVal = new Vector<Vector<Object>>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        String query = "SELECT * FROM rezultati_forma ORDER BY BrojOsvojenihBodova DESC";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            cs = conn.prepareCall(query);

            rs = cs.executeQuery();
            while (rs.next()) {
                Vector<Object> red = new Vector<Object>();
                red.add(rs.getInt(1)); // IdPrijave
                red.add(rs.getString(2)); //  JMB
                red.add(rs.getString(3)); // Ime
                red.add(rs.getString(4)); // Prezime
                red.add(rs.getDouble(5)); // BrojOsvojenihBodova
                red.add(rs.getBoolean(6)); // ProsaoNaKonkursu
                red.add(rs.getString(7)); //Skolska godina
                red.add(rs.getString(8)); //Naziv fakulteta
                retVal.add(red);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLIzvjestajiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(cs, rs);
        }
        return retVal;
    }
}
