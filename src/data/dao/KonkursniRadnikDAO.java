package data.dao;

import java.util.List;

import data.dto.KonkursniRadnikDTO;

public interface KonkursniRadnikDAO {

    public KonkursniRadnikDTO konkursniRadnik(String username);

    public List<KonkursniRadnikDTO> konkursniRadnici();

    public boolean dodajKonkursnogRadnika(KonkursniRadnikDTO konkursniRadnik);

    public boolean azurirajKonkursnogRadnika(KonkursniRadnikDTO konkursniRadnik, String stariUsername);

    public boolean obrisiKonkursnogRadnika(String username);

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt);

    public boolean azurirajKonkursnogRadnika2(KonkursniRadnikDTO konkursniRadnik);

}
