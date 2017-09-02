package data.dto;

import java.util.Objects;

public class RezultatiDTO {

    private double brojOsvojenihBodova;
    private boolean prosaoNaKonkursu;
    private int idPrijave;

    public RezultatiDTO() {
    }

    public RezultatiDTO(double brojOsvojenihBodova, boolean prosaoNaKonkursu, int idPrijave) {
        this.brojOsvojenihBodova = brojOsvojenihBodova;
        this.prosaoNaKonkursu = prosaoNaKonkursu;
        this.idPrijave = idPrijave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idPrijave;
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
        final RezultatiDTO other = (RezultatiDTO) obj;
        if (this.idPrijave != other.idPrijave) {
            return false;
        }
        return true;
    }

    public double getBrojOsvojenihBodova() {
        return brojOsvojenihBodova;
    }

    public void setBrojOsvojenihBodova(double brojOsvojenihBodova) {
        this.brojOsvojenihBodova = brojOsvojenihBodova;
    }

    public boolean isProsaoNaKonkursu() {
        return prosaoNaKonkursu;
    }

    public void setProsaoNaKonkursu(boolean prosaoNaKonkursu) {
        this.prosaoNaKonkursu = prosaoNaKonkursu;
    }

    public int getIdPrijave() {
        return idPrijave;
    }

    public void setIdPrijave(int idPrijave) {
        this.idPrijave = idPrijave;
    }

}
