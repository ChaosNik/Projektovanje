package data.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.StudentDAO;
import data.dto.StudentDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLStudentDAO implements StudentDAO {

    @Override
    public StudentDTO student(String JMB) {
        List<StudentDTO> retVal = studenti();
        for (StudentDTO stud : retVal) {
            if (stud.getJMB().equals(JMB)) {
                return stud;
            }
        }
        return null;
    }

    @Override
    public List<StudentDTO> studenti() {
        List<StudentDTO> retVal = new ArrayList<StudentDTO>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT JMB, Ime, Prezime, DatumRodjenja "
                + "FROM student "
                + "ORDER BY Prezime ASC ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                retVal.add(new StudentDTO(rs.getString("JMB"), rs.getString("Ime"),
                        rs.getString("Prezime"), rs.getDate("DatumRodjenja")));
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
    public boolean dodajStudenta(StudentDTO student) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "INSERT INTO student VALUES "
                + "(?, ?, ?, ?) ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, student.getJMB());
            ps.setString(2, student.getIme());
            ps.setString(3, student.getPrezime());
            ps.setDate(4, student.getDatumRodjenja());

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
    public boolean azurirajStudenta(StudentDTO student) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "UPDATE student SET "
                + "Ime=?, "
                + "Prezime=?, "
                + "DatumRodjenja=? "
                + "WHERE JMB=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, student.getIme());
            ps.setString(2, student.getPrezime());
            ps.setDate(3, student.getDatumRodjenja());
            ps.setString(4, student.getJMB());

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
    public boolean obrisiStudenta(String JMB) {
        boolean retVal = false;
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM student "
                + "WHERE JMB=? ";
        try {
            conn = ConnectionPool.getInstance().checkOut();
            ps = conn.prepareStatement(query);
            ps.setString(1, JMB);

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
