package data.dao;

import java.util.List;

import data.dto.KonkursDTO;

public interface KonkursDAO {

    public KonkursDTO konkurs(String skolskaGodina);

    public String readPDF(String skolskaGodina);

    public List<KonkursDTO> konkursi();

    public boolean dodajKonkurs(KonkursDTO konkurs);

    public boolean azurirajKonkurs(KonkursDTO konkurs);

    public boolean obrisiKonkurs(String skolskaGodina);
}
