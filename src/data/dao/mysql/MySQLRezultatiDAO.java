package data.dao.mysql;

import data.dao.DAOFactory;
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
import data.dao.RezultatiDAO;
import data.dto.PrijavaNaKonkursDTO;
import data.dto.RezultatiDTO;

public class MySQLRezultatiDAO implements RezultatiDAO {

    @Override
    public RezultatiDTO rezultat(int idPrijave) {
        List<RezultatiDTO> retVal = rezultati();
        for (RezultatiDTO rez : retVal) {
            if ((rez.getIdPrijave() == idPrijave)) {
                return rez;
            }
        }
        return null;
    }

    @Override
    public List<RezultatiDTO> rezultati() {
        List<RezultatiDTO> retVal = new ArrayList<RezultatiDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT BrojOsvojenihBodova, ProsaoNaKonkursu, IdPrijave "
                + "FROM rezultati "
                + "ORDER BY BrojOsvojenihBodova ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new RezultatiDTO(rs.getDouble("BrojOsvojenihBodova"), rs.getBoolean("ProsaoNaKonkursu"), rs.getInt("IdPrijave")));
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

    public List<RezultatiDTO> rezultati(String skolskaGodina) {
        List<RezultatiDTO> retVal = new ArrayList<RezultatiDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT BrojOsvojenihBodova, ProsaoNaKonkursu, IdPrijave "
                + "FROM rezultati "
                + "ORDER BY BrojOsvojenihBodova ASC ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                PrijavaNaKonkursDTO rezultat = DAOFactory.getDAOFactory().getPrijavaNaKonkursDAO().prijava(rs.getInt("IdPrijave"), skolskaGodina);
                if (rezultat != null) {
                    retVal.add(new RezultatiDTO(rs.getDouble("BrojOsvojenihBodova"), rs.getBoolean("ProsaoNaKonkursu"), rs.getInt("IdPrijave")));
                }

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

    public boolean azurirajRezultat(RezultatiDTO rez) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE rezultati SET "
                + "ProsaoNaKonkursu=? "
                + "WHERE IdPrijave=? ";

        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, rez.isProsaoNaKonkursu());
            ps.setInt(2, rez.getIdPrijave());

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
