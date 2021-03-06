/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

import java.sql.Date;
import java.util.Objects;

public class AdminDTO {

    private String username;
    private String passwordHash;
    private String salt;
    private String ime;
    private String prezime;
    private String JMB;
    private Date datumKreiranjaNaloga;
    private boolean validanNalog;

    public AdminDTO(String username) {
        this.username = username;
    }

    public AdminDTO(String username, String passwordHash, String salt, String ime, String prezime, String JMB, Date datumKreiranjaNaloga, boolean validanNalog) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.ime = ime;
        this.prezime = prezime;
        this.JMB = JMB;
        this.datumKreiranjaNaloga = datumKreiranjaNaloga;
        this.validanNalog = validanNalog;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdminDTO other = (AdminDTO) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJMB() {
        return JMB;
    }

    public void setJMB(String JMB) {
        this.JMB = JMB;
    }

    public Date getDatumKreiranjaNaloga() {
        return datumKreiranjaNaloga;
    }

    public void setDatumKreiranjaNaloga(Date datumKreiranjaNaloga) {
        this.datumKreiranjaNaloga = datumKreiranjaNaloga;
    }

    public boolean isValidanNalog() {
        return validanNalog;
    }

    public void setValidanNalog(boolean validanNalog) {
        this.validanNalog = validanNalog;
    }

}
