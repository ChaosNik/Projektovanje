/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.dto.AdminDTO;
import java.util.List;

/**
 *
 * @author DulleX
 */
public interface AdminDAO {

    public AdminDTO admin(String username);

    public List<AdminDTO> admini();

    public boolean dodajAdmina(AdminDTO admin);

    public boolean azurirajAdmina(AdminDTO admin, String stariUsername);

    public boolean obrisiAdmina(String username);

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt);
}
