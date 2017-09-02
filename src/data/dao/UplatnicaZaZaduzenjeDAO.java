/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.UplatnicaZaZaduzenjeDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface UplatnicaZaZaduzenjeDAO {
    public List<UplatnicaZaZaduzenjeDTO> zaduzenjaStudenta(String JMB);

    public List<UplatnicaZaZaduzenjeDTO> svaZaduzenja();

    public boolean dodaj(UplatnicaZaZaduzenjeDTO uplatnica);

    public boolean azuriraj(UplatnicaZaZaduzenjeDTO uplatnica);

    public boolean obrisi(UplatnicaZaZaduzenjeDTO uplatnica);
}
