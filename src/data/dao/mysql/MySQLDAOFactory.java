package data.dao.mysql;

import data.dao.UplatnicaZaStanarinuDAO;
import data.dao.DAOFactory;
import data.dao.FakultetDAO;
import data.dao.IzvjestajiDAO;
import data.dao.KonkursDAO;
import data.dao.MjestoPrebivalistaDAO;
import data.dao.PrijavaNaKonkursDAO;
import data.dao.SocijalniStatusDAO;
import data.dao.StudentDAO;
import data.dao.KonkursniRadnikDAO;
import data.dao.RezultatiDAO;
import data.dao.AdminDAO;
import data.dao.BlagajnikDAO;
import data.dao.UplatnicaZaKaznuDAO;
import data.dao.UplatnicaZaRecepcijuDAO;
import data.dao.UplatnicaZaZaduzenjeDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public RezultatiDAO getRezultatiDAO() {
        return new MySQLRezultatiDAO();
    }

    @Override
    public FakultetDAO getFakultetDAO() {
        return new MySQLFakultetDAO();
    }

    @Override
    public KonkursDAO getKonkursDAO() {
        return new MySQLKonkursDAO();
    }

    @Override
    public MjestoPrebivalistaDAO getMjestoPrebivalistaDAO() {
        return new MySQLMjestoPrebivalistaDAO();
    }

    @Override
    public PrijavaNaKonkursDAO getPrijavaNaKonkursDAO() {
        return new MySQLPrijavaNaKonkursDAO();
    }

    @Override
    public SocijalniStatusDAO getSocijalniStatusDAO() {
        return new MySQLSocijalniStatusDAO();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }

    @Override
    public KonkursniRadnikDAO getKonkursniRadnikDAO() {
        return new MySQLKonkursniRadnikDAO();
    }

    @Override
    public AdminDAO getAdminDAO() {
        return new MySQLAdminDAO();
    }

    @Override
    public BlagajnikDAO getBlagajnikDAO() {
        return new MySQLBlagajnikDAO();
    }

    @Override
    public IzvjestajiDAO getIzvjestajiDAO() {
        return new MySQLIzvjestajiDAO();
    }
    
    @Override
    public UplatnicaZaStanarinuDAO getUplatnicaZaStanarinuDAO()
    {
        return new MySQLUplatnicaZaStanarinuDAO();
    }

    @Override
    public UplatnicaZaZaduzenjeDAO getUplatnicaZaZaduzenjeDAO() {
        return new MySQLUplatnicaZaZaduzenjeDAO();
    }

    @Override
    public UplatnicaZaKaznuDAO getUplatnicaZaKaznuDAO() {
        return new MySQLUplatnicaZaKaznuDAO();
    }

    @Override
    public UplatnicaZaRecepcijuDAO getUplatnicaZaRecepcijuDAO() {
        return new MySQLUplatnicaZaRecepcijuDAO();
    }
    
    
}
