/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.UplatnicaZaKaznuDTO;
import data.dto.UplatnicaZaStanarinuDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface UplatnicaZaKaznuDAO {
    public List<UplatnicaZaKaznuDTO> kazneStudenta(String JMB);

    public List<UplatnicaZaKaznuDTO> sveKazne();

    public boolean dodaj(UplatnicaZaKaznuDTO stanarina);

    public boolean azuriraj(UplatnicaZaKaznuDTO stanarina);

    public boolean obrisi(UplatnicaZaStanarinuDTO stanarina);
}
