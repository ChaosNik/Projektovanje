package data.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MjestoPrebivalistaDTO implements Serializable {

    private int brojPoste;
    private String naziv;
    private double udaljenost;

    public MjestoPrebivalistaDTO() {
    }

    public MjestoPrebivalistaDTO(int brojPoste, String naziv, double udaljenost) {
        this.brojPoste = brojPoste;
        this.naziv = naziv;
        this.udaljenost = udaljenost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.brojPoste;
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
        final MjestoPrebivalistaDTO other = (MjestoPrebivalistaDTO) obj;
        if (this.brojPoste != other.brojPoste) {
            return false;
        }
        return true;
    }

    public int getBrojPoste() {
        return brojPoste;
    }

    public void setBrojPoste(int brojPoste) {
        this.brojPoste = brojPoste;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getUdaljenost() {
        return udaljenost;
    }

    public void setUdaljenost(double udaljenost) {
        this.udaljenost = udaljenost;
    }

}
