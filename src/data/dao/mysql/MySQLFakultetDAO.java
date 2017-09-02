package data.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.FakultetDAO;
import data.dto.FakultetDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLFakultetDAO implements FakultetDAO {

    @Override
    public List<FakultetDTO> fakulteti() {
        List<FakultetDTO> retVal = new ArrayList<FakultetDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT NazivFakulteta, Adresa, BrojDodjeljenihKreveta "
                + "FROM fakultet "
                + "ORDER BY NazivFakulteta ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new FakultetDTO(rs.getString("NazivFakulteta"), rs.getString("Adresa"), rs.getInt("BrojDodjeljenihKreveta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLFakultetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }

    @Override
    public boolean dodajFakultet(FakultetDTO fakultet) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO fakultet VALUES "
                + "(?, ?, ?) ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, fakultet.getNazivFakulteta());
            ps.setString(2, fakultet.getAdresa());
            ps.setInt(3, fakultet.getBrojDodjeljenihKreveta());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLFakultetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean azurirajFakultet(FakultetDTO fakultet) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE fakultet SET "
                + "Adresa=?, "
                + "BrojDodjeljenihKreveta=? "
                + "WHERE NazivFakulteta=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, fakultet.getAdresa());
            ps.setInt(2, fakultet.getBrojDodjeljenihKreveta());
            ps.setString(3, fakultet.getNazivFakulteta());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLFakultetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean obrisiFakultet(String nazivFakulteta) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM fakultet "
                + "WHERE NazivFakulteta=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, nazivFakulteta);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLFakultetDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public FakultetDTO fakultet(String nazivFakulteta) {
        List<FakultetDTO> retVal = fakulteti();
        for (FakultetDTO fakultet : retVal) {
            if (fakultet.getNazivFakulteta().equals(nazivFakulteta)) {
                return fakultet;
            }
        }
        return null;
    }

}
