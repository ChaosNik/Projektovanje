package data.dao;

import java.util.List;

import data.dto.PrijavaNaKonkursDTO;

public interface PrijavaNaKonkursDAO {

    public PrijavaNaKonkursDTO prijava(String JMB, String skolskaGodina);

    public PrijavaNaKonkursDTO prijava(int idPrijave, String skolskaGodina);

    public double bodujPrijavu(String skolskaGodina, String JMB);

    public List<PrijavaNaKonkursDTO> prijave(String skolskaGodina);

    public double dodajPrijavu(PrijavaNaKonkursDTO prijava);

    public double azurirajPrijavu(PrijavaNaKonkursDTO prijava);

    public boolean obrisiPrijavu(int idPrijave);
}
