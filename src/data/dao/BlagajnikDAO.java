/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.BlagajnikDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface BlagajnikDAO {

    public BlagajnikDTO blagajnik(String username);

    public List<BlagajnikDTO> blagajnici();

    public boolean dodajBlagajnika(BlagajnikDTO blagajnik);

    public boolean azurirajBlagajnika(BlagajnikDTO blagajnik, String stariUsername);

    public boolean obrisiBlagajnika(String username);

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt);
}
