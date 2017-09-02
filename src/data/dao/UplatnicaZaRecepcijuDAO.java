/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.UplatnicaZaRecepcijuDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface UplatnicaZaRecepcijuDAO {
    public List<UplatnicaZaRecepcijuDTO> recepcijeStudenta(String JMB);

    public List<UplatnicaZaRecepcijuDTO> sveRecepcije();

    public boolean dodaj(UplatnicaZaRecepcijuDTO uplatnica);

    public boolean azuriraj(UplatnicaZaRecepcijuDTO uplatnica);

    public boolean obrisi(UplatnicaZaRecepcijuDTO uplatnica);
}
