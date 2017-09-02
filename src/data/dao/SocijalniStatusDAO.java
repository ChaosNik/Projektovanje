package data.dao;

import java.util.List;

import data.dto.SocijalniStatusDTO;

public interface SocijalniStatusDAO {

    public SocijalniStatusDTO socijalniStatus(int idSocijalnogStatusa);

    public int daLiPostojiOvakav(SocijalniStatusDTO soc);

    public List<SocijalniStatusDTO> socijalniStatusi();

    public String dodajSocijalniStatus(SocijalniStatusDTO socijalniStatus);

    public boolean azurirajSocijalniStatus(SocijalniStatusDTO socijalniStatus);

    public boolean obrisiSocijalniStatus(int idSocijalnogStatusa);
}
