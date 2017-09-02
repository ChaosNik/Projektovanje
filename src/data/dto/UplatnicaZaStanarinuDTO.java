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
public class UplatnicaZaStanarinuDTO {
    private int idUplatnice;
    private Date datumUplate;
    private float iznosUplate;
    private String username;
    private String JMB;
    private int brojSobe;
    private int mjesec;
    private short brojPaviljona;
    private String skolskaGodina;

    public UplatnicaZaStanarinuDTO(int idUplatnice, Date datumUplate, float iznosUplate, String username, String JMB, int brojSobe, int mjesec, short brojPaviljona, String skolskaGodina) {
        this.idUplatnice = idUplatnice;
        this.datumUplate = datumUplate;
        this.iznosUplate = iznosUplate;
        this.username = username;
        this.JMB = JMB;
        this.brojSobe = brojSobe;
        this.mjesec = mjesec;
        this.brojPaviljona = brojPaviljona;
        this.skolskaGodina = skolskaGodina;
    }

    public UplatnicaZaStanarinuDTO() {
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

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public int getBrojSobe() {
        return brojSobe;
    }

    public void setBrojSobe(int brojSobe) {
        this.brojSobe = brojSobe;
    }

    public int getMjesec() {
        return mjesec;
    }

    public void setMjesec(int mjesec) {
        this.mjesec = mjesec;
    }

    public short getBrojPaviljona() {
        return brojPaviljona;
    }

    public void setBrojPaviljona(short brojPaviljona) {
        this.brojPaviljona = brojPaviljona;
    }

    public String getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(String skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }
    
    
}
