/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas Eduardo
 */
public class Remedio {
    
        private String codigoR;       
        private String nomeR;
        private String precoR;

    public Remedio() {
    }
        
        

    public Remedio(String codigoR, String nomeR, String precoR) {
        this.codigoR = codigoR;
        this.nomeR = nomeR;
        this.precoR = precoR;
    }
        
    
    public String getCodigoR() {
        return codigoR;
    }

    public void setCodigoR(String codigoR) {
        this.codigoR = codigoR;
    }

    public String getNomeR() {
        return nomeR;
    }

    public void setNomeR(String nomeR) {
        this.nomeR = nomeR;
    }

    public String getPrecoR() {
        return precoR;
    }

    public void setPrecoR(String precoR) {
        this.precoR = precoR;
    }
        
        
        
        
        
        
        
    
}
