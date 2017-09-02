package data.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.MjestoPrebivalistaDAO;
import data.dto.MjestoPrebivalistaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLMjestoPrebivalistaDAO implements MjestoPrebivalistaDAO {

    @Override
    public boolean postojiLiIstoOvakvo(int brojPoste, String naziv, double udaljenost) {
        MjestoPrebivalistaDTO mjesto = mjestoPrebivalista(brojPoste);
        if (mjesto == null) {
            return false;
        }

        if ((mjesto.getBrojPoste() == brojPoste) && (mjesto.getNaziv().equals(naziv)) && (mjesto.getUdaljenost() == udaljenost)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MjestoPrebivalistaDTO mjestoPrebivalista(int brojPoste) {
        List<MjestoPrebivalistaDTO> retVal = mjestaPrebivalista();
        for (MjestoPrebivalistaDTO mjesto : retVal) {
            if (mjesto.getBrojPoste() == brojPoste) {
                return mjesto;
            }
        }
        return null;
    }

    @Override
    public List<MjestoPrebivalistaDTO> mjestaPrebivalista() {
        List<MjestoPrebivalistaDTO> retVal = new ArrayList<MjestoPrebivalistaDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT BrojPoste, Naziv, Udaljenost "
                + "FROM mjesto_prebivalista "
                + "ORDER BY Naziv ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new MjestoPrebivalistaDTO(rs.getInt("BrojPoste"), rs.getString("Naziv"), rs.getDouble("Udaljenost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLMjestoPrebivalistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps, rs);
        }
        return retVal;
    }

    @Override
    public boolean dodajMjestoPrebivalista(MjestoPrebivalistaDTO mjestoPrebivalista) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO mjesto_prebivalista VALUES "
                + "(?, ?, ?) ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, mjestoPrebivalista.getBrojPoste());
            ps.setString(2, mjestoPrebivalista.getNaziv());
            ps.setDouble(3, mjestoPrebivalista.getUdaljenost());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLMjestoPrebivalistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean azurirajMjestoPrebivalista(MjestoPrebivalistaDTO mjestoPrebivalista) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE mjesto_prebivalista SET "
                + "Naziv=?, "
                + "Udaljenost=? "
                + "WHERE BrojPoste=? ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, mjestoPrebivalista.getNaziv());
            ps.setDouble(2, mjestoPrebivalista.getUdaljenost());
            ps.setInt(3, mjestoPrebivalista.getBrojPoste());

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            DBUtilities.getInstance().showSQLException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLMjestoPrebivalistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }

    @Override
    public boolean obrisiMjestoPrebivalista(int brojPoste) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM mjesto_prebivalista "
                + "WHERE BrojPoste=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setInt(1, brojPoste);

            retVal = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLMjestoPrebivalistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionPool.getInstance().checkIn(conn);
            DBUtilities.getInstance().close(ps);
        }
        return retVal;
    }
}
