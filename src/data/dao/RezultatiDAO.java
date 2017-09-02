package data.dao;

import java.util.List;

import data.dto.RezultatiDTO;

public interface RezultatiDAO {

    public RezultatiDTO rezultat(int idPrijave);

    public List<RezultatiDTO> rezultati();

    public List<RezultatiDTO> rezultati(String skolskaGodina);

    public boolean azurirajRezultat(RezultatiDTO rez);

}
