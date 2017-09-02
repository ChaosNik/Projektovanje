package data.dao;

import java.util.List;

import data.dto.FakultetDTO;

public interface FakultetDAO {

    public FakultetDTO fakultet(String nazivFakulteta);

    public List<FakultetDTO> fakulteti();

    public boolean dodajFakultet(FakultetDTO fakultet);

    public boolean azurirajFakultet(FakultetDTO fakultet);

    public boolean obrisiFakultet(String nazivFakulteta);
}
