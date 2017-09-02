package data.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KonkursDTO implements Serializable {

    private int skolskaGodina;
    private byte[] tekstKonkursa;
    private String format;
    private int brojPrijava;

    public KonkursDTO() {
    }

    public KonkursDTO(int skolskaGodina, byte[] tekstKonkursa, String format, int brojPrijava) {
        this.skolskaGodina = skolskaGodina;
        this.tekstKonkursa = tekstKonkursa;
        this.format = format;
        this.brojPrijava = brojPrijava;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.skolskaGodina;
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
        final KonkursDTO other = (KonkursDTO) obj;
        if (this.skolskaGodina != other.skolskaGodina) {
            return false;
        }
        return true;
    }

    public int getBrojPrijava() {
        return brojPrijava;
    }

    public void setBrojPrijava(int brojPrijava) {
        this.brojPrijava = brojPrijava;
    }

    public int getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(int skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public byte[] getTekstKonkursa() {
        return tekstKonkursa;
    }

    public void setTekstKonkursa(byte[] tekstKonkursa) {
        this.tekstKonkursa = tekstKonkursa;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
