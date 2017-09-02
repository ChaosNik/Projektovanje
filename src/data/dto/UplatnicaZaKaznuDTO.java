/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

import java.sql.Date;

/**
 *
 * @author DulleX
 */
public class UplatnicaZaKaznuDTO {
    private int idUplatnice;
    private Date datumUplate;
    private float iznosUplate;
    private String username;
    private int idKazne;

    public UplatnicaZaKaznuDTO(int idUplatnice, Date datumUplate, float iznosUplate, String username, int idKazne) {
        this.idUplatnice = idUplatnice;
        this.datumUplate = datumUplate;
        this.iznosUplate = iznosUplate;
        this.username = username;
        this.idKazne = idKazne;
    }

    public UplatnicaZaKaznuDTO() {
    }

    public int getIdUplatnice() {
        return idUplatnice;
    }

    public void setIdUplatnice(int idUplatnice) {
        this.idUplatnice = idUplatnice;
    }

    public Date getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(Date datumUplate) {
        this.datumUplate = datumUplate;
    }

    public float getIznosUplate() {
        return iznosUplate;
    }

    public void setIznosUplate(float iznosUplate) {
        this.iznosUplate = iznosUplate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdKazne() {
        return idKazne;
    }

    public void setIdKazne(int idKazne) {
        this.idKazne = idKazne;
    }
    
    
    
}
