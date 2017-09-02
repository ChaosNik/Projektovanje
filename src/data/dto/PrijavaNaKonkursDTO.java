package data.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class PrijavaNaKonkursDTO implements Serializable {

    private int idPrijave;
    private String skolskaGodina;
    private String JMB;
    private int idSocijalnogStatusa;
    private short godinaStudija;
    private double prosjekOcjena;
    private int brojPoste;
    private String nazivFakulteta;
    private short brojObnovljenihGodina;
    private String napomena;
    private String username;
    private String telefon;
    private String email;
    private double kazneniBodovi;
    private int brojOdslusanihIspita;
    private int brojPolozenihIspita;

    public PrijavaNaKonkursDTO() {
    }

    public PrijavaNaKonkursDTO(int idPrijave, String skolskaGodina, String JMB, int idSocijalnogStatusa, short godinaStudija, double prosjekOcjena, int brojPoste, String nazivFakulteta, short brojObnovljenihGodina, String napomena, String username, String telefon, String email, double kazneniBodovi, int brojOdslusanihIspita, int brojPolozenihIspita) {
        this.idPrijave = idPrijave;
        this.skolskaGodina = skolskaGodina;
        this.JMB = JMB;
        this.idSocijalnogStatusa = idSocijalnogStatusa;
        this.godinaStudija = godinaStudija;
        this.prosjekOcjena = prosjekOcjena;
        this.brojPoste = brojPoste;
        this.nazivFakulteta = nazivFakulteta;
        this.brojObnovljenihGodina = brojObnovljenihGodina;
        this.napomena = napomena;
        this.username = username;
        this.telefon = telefon;
        this.email = email;
        this.kazneniBodovi = kazneniBodovi;
        this.brojOdslusanihIspita = brojOdslusanihIspita;
        this.brojPolozenihIspita = brojPolozenihIspita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idPrijave;
        hash = 17 * hash + Objects.hashCode(this.skolskaGodina);
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
        final PrijavaNaKonkursDTO other = (PrijavaNaKonkursDTO) obj;
        if (this.idPrijave != other.idPrijave) {
            return false;
        }
        if (!Objects.equals(this.skolskaGodina, other.skolskaGodina)) {
            return false;
        }
        return true;
    }

    public int getBrojOdslusanihIspita() {
        return brojOdslusanihIspita;
    }

    public void setBrojOdslusanihIspita(int brojOdslusanihIspita) {
        this.brojOdslusanihIspita = brojOdslusanihIspita;
    }

    public int getBrojPolozenihIspita() {
        return brojPolozenihIspita;
    }

    public void setBrojPolozenihIspita(int brojPolozenihIspita) {
        this.brojPolozenihIspita = brojPolozenihIspita;
    }

    public int getIdPrijave() {
        return idPrijave;
    }

    public void setIdPrijave(int idPrijave) {
        this.idPrijave = idPrijave;
    }

    public String getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(String skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public int getIdSocijalnogStatusa() {
        return idSocijalnogStatusa;
    }

    public void setIdSocijalnogStatusa(int idSocijalnogStatusa) {
        this.idSocijalnogStatusa = idSocijalnogStatusa;
    }

    public short getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(short godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public double getProsjekOcjena() {
        return prosjekOcjena;
    }

    public void setProsjekOcjena(double prosjekOcjena) {
        this.prosjekOcjena = prosjekOcjena;
    }

    public int getBrojPoste() {
        return brojPoste;
    }

    public void setBrojPoste(int brojPoste) {
        this.brojPoste = brojPoste;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public short getBrojObnovljenihGodina() {
        return brojObnovljenihGodina;
    }

    public void setBrojObnovljenihGodina(short brojObnovljenihGodina) {
        this.brojObnovljenihGodina = brojObnovljenihGodina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getKazneniBodovi() {
        return kazneniBodovi;
    }

    public void setKazneniBodovi(double kazneniBodovi) {
        this.kazneniBodovi = kazneniBodovi;
    }

}
