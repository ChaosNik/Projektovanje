/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import java.util.List;
import data.dto.SobaDTO;
/**
 *
 * @author Aco
 */
public interface SobaDAO {
    public SobaDTO soba(int brojSobe, int brojPaviljona);

    public List<SobaDTO> sobe();

    public boolean dodajSobu(SobaDTO soba);

    public boolean azurirajSobu(SobaDTO soba);

    public boolean obrisiSobu(int brojSobe, int brojPaviljona);
}
