package data.dao;

import data.dao.mysql.MySQLDAOFactory;

public abstract class DAOFactory {

    public abstract FakultetDAO getFakultetDAO();

    public abstract RezultatiDAO getRezultatiDAO();

    public abstract KonkursDAO getKonkursDAO();

    public abstract MjestoPrebivalistaDAO getMjestoPrebivalistaDAO();

    public abstract PrijavaNaKonkursDAO getPrijavaNaKonkursDAO();

    public abstract SocijalniStatusDAO getSocijalniStatusDAO();

    public abstract StudentDAO getStudentDAO();

    public abstract KonkursniRadnikDAO getKonkursniRadnikDAO();

    public abstract BlagajnikDAO getBlagajnikDAO();

    public abstract IzvjestajiDAO getIzvjestajiDAO();

    public abstract AdminDAO getAdminDAO();

    public abstract UplatnicaZaStanarinuDAO getUplatnicaZaStanarinuDAO();
    
    public abstract UplatnicaZaZaduzenjeDAO getUplatnicaZaZaduzenjeDAO();
    
    public abstract UplatnicaZaKaznuDAO getUplatnicaZaKaznuDAO();
    
    public abstract UplatnicaZaRecepcijuDAO getUplatnicaZaRecepcijuDAO();
         
    
    public static DAOFactory getDAOFactory() {
        return new MySQLDAOFactory();
    }
}
