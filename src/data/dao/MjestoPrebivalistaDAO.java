package data.dao;

import java.util.List;

import data.dto.MjestoPrebivalistaDTO;

public interface MjestoPrebivalistaDAO {

    public MjestoPrebivalistaDTO mjestoPrebivalista(int brojPoste);

    public boolean postojiLiIstoOvakvo(int brojPoste, String naziv, double udaljenost);

    public List<MjestoPrebivalistaDTO> mjestaPrebivalista();

    public boolean dodajMjestoPrebivalista(MjestoPrebivalistaDTO mjestoPrebivalista);

    public boolean azurirajMjestoPrebivalista(MjestoPrebivalistaDTO mjestoPrebivalista);

    public boolean obrisiMjestoPrebivalista(int brojPoste);
}
