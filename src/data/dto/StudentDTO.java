package data.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class StudentDTO implements Serializable {

    private String JMB;
    private String ime;
    private String prezime;
    private Date datumRodjenja;

    public StudentDTO() {
    }

    public StudentDTO(String JMB, String ime, String prezime, Date datumRodjenja) {
        this.JMB = JMB;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.JMB);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentDTO other = (StudentDTO) obj;
        if (!Objects.equals(this.JMB, other.JMB)) {
            return false;
        }
        return true;
    }

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

}
