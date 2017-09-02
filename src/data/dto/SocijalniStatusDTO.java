package data.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SocijalniStatusDTO implements Serializable {

    private int idSocijalnogStatusa;
    private boolean bezObaRoditelja;
    private boolean dijetePalogINestalogBorcaRS;
    private boolean bezJednogRoditelja;
    private boolean invaliditet;
    private boolean korisnikSocijalnePomoci;
    private boolean dijeteRVIVRS;
    private boolean obaRoditeljaNezaposlena;
    private boolean jedanRoditeljNezaposlen;
    private boolean studentIzViseclanihPorodica;

    public SocijalniStatusDTO() {
    }

    public SocijalniStatusDTO(int idSocijalnogStatusa, boolean bezObaRoditelja, boolean dijetePalogINestalogBorcaRS, boolean bezJednogRoditelja, boolean invaliditet, boolean korisnikSocijalnePomoci, boolean dijeteRVIVRS, boolean obaRoditeljaNezaposlena, boolean jedanRoditeljNezaposlen, boolean studentIzViseclanihPorodica) {
        this.idSocijalnogStatusa = idSocijalnogStatusa;
        this.bezObaRoditelja = bezObaRoditelja;
        this.dijetePalogINestalogBorcaRS = dijetePalogINestalogBorcaRS;
        this.bezJednogRoditelja = bezJednogRoditelja;
        this.invaliditet = invaliditet;
        this.korisnikSocijalnePomoci = korisnikSocijalnePomoci;
        this.dijeteRVIVRS = dijeteRVIVRS;
        this.obaRoditeljaNezaposlena = obaRoditeljaNezaposlena;
        this.jedanRoditeljNezaposlen = jedanRoditeljNezaposlen;
        this.studentIzViseclanihPorodica = studentIzViseclanihPorodica;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idSocijalnogStatusa;
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
        final SocijalniStatusDTO other = (SocijalniStatusDTO) obj;
        if (this.idSocijalnogStatusa != other.idSocijalnogStatusa) {
            return false;
        }
        return true;
    }

    public int getIdSocijalnogStatusa() {
        return idSocijalnogStatusa;
    }

    public void setIdSocijalnogStatusa(int idSocijalnogStatusa) {
        this.idSocijalnogStatusa = idSocijalnogStatusa;
    }

    public boolean isBezObaRoditelja() {
        return bezObaRoditelja;
    }

    public void setBezObaRoditelja(boolean bezObaRoditelja) {
        this.bezObaRoditelja = bezObaRoditelja;
    }

    public boolean isDijetePalogINestalogBorcaRS() {
        return dijetePalogINestalogBorcaRS;
    }

    public void setDijetePalogINestalogBorcaRS(boolean dijetePalogINestalogBorcaRS) {
        this.dijetePalogINestalogBorcaRS = dijetePalogINestalogBorcaRS;
    }

    public boolean isBezJednogRoditelja() {
        return bezJednogRoditelja;
    }

    public void setBezJednogRoditelja(boolean bezJednogRoditelja) {
        this.bezJednogRoditelja = bezJednogRoditelja;
    }

    public boolean isInvaliditet() {
        return invaliditet;
    }

    public void setInvaliditet(boolean invaliditet) {
        this.invaliditet = invaliditet;
    }

    public boolean isKorisnikSocijalnePomoci() {
        return korisnikSocijalnePomoci;
    }

    public void setKorisnikSocijalnePomoci(boolean korisnikSocijalnePomoci) {
        this.korisnikSocijalnePomoci = korisnikSocijalnePomoci;
    }

    public boolean isDijeteRVIVRS() {
        return dijeteRVIVRS;
    }

    public void setDijeteRVIVRS(boolean dijeteRVIVRS) {
        this.dijeteRVIVRS = dijeteRVIVRS;
    }

    public boolean isObaRoditeljaNezaposlena() {
        return obaRoditeljaNezaposlena;
    }

    public void setObaRoditeljaNezaposlena(boolean obaRoditeljaNezaposlena) {
        this.obaRoditeljaNezaposlena = obaRoditeljaNezaposlena;
    }

    public boolean isJedanRoditeljNezaposlen() {
        return jedanRoditeljNezaposlen;
    }

    public void setJedanRoditeljNezaposlen(boolean jedanRoditeljNezaposlen) {
        this.jedanRoditeljNezaposlen = jedanRoditeljNezaposlen;
    }

    public boolean isStudentIzViseclanihPorodica() {
        return studentIzViseclanihPorodica;
    }

    public void setStudentIzViseclanihPorodica(boolean studentIzViseclanihPorodica) {
        this.studentIzViseclanihPorodica = studentIzViseclanihPorodica;
    }

}
