package data.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FakultetDTO implements Serializable {

    private String nazivFakulteta;
    private String adresa;
    private int brojDodjeljenihKreveta;

    public FakultetDTO() {
    }

    public FakultetDTO(String nazivFakulteta, String adresa, int brojDodjeljenihKreveta) {
        super();
        this.nazivFakulteta = nazivFakulteta;
        this.adresa = adresa;
        this.brojDodjeljenihKreveta = brojDodjeljenihKreveta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((nazivFakulteta == null) ? 0 : nazivFakulteta.hashCode());
        return result;
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
        FakultetDTO other = (FakultetDTO) obj;
        if (nazivFakulteta == null) {
            if (other.nazivFakulteta != null) {
                return false;
            }
        } else if (!nazivFakulteta.equals(other.nazivFakulteta)) {
            return false;
        }
        return true;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrojDodjeljenihKreveta() {
        return brojDodjeljenihKreveta;
    }

    public void setBrojDodjeljenihKreveta(int brojDodjeljenihKreveta) {
        this.brojDodjeljenihKreveta = brojDodjeljenihKreveta;
    }

    @Override
    public String toString() {
        return nazivFakulteta;
    }

}
