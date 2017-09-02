/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.UplatnicaZaStanarinuDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface UplatnicaZaStanarinuDAO {
    public List<UplatnicaZaStanarinuDTO> stanarineStudente(String JMB);

    public List<UplatnicaZaStanarinuDTO> sveStanarine();

    public boolean dodaj(UplatnicaZaStanarinuDTO uplatnica);

    public boolean azuriraj(UplatnicaZaStanarinuDTO uplatnica);

    public boolean obrisi(UplatnicaZaStanarinuDTO uplatnica);
}
