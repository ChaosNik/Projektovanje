/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dto;

/**
 *
 * @author Aco
 */
public class SobaDTO {
    protected int brojSobe;
    protected int brojPaviljona;
    protected int brojKreveta;
    protected int brojSlobodnihKreveta;
    protected boolean apsolventskaSoba;
    
    public SobaDTO(int brojSobe, int brojPaviljona, int brojKreveta, int brojSlKreveta, boolean apsSoba){
        this.brojSobe = brojSobe;
        this.brojPaviljona = brojPaviljona;
        this.brojKreveta = brojKreveta;
        this.brojSlobodnihKreveta = brojSlKreveta;
        this.apsolventskaSoba = apsSoba;
    }
    public int getBrojSobe(){
        return this.brojSobe;
    }
    public int getBrojPaviljona(){
        return this.brojPaviljona;
    }
    public int getBrojKreveta(){
        return this.brojKreveta;
    }
    public int getBrojSlobodnihKreveta(){
        return this.brojSlobodnihKreveta;
    }
    public boolean getApsolventskaSoba(){
        return this.apsolventskaSoba;
    }
}
