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
public class Vacina {
    
    private String codigoV;       
    private String nomeV;
    private String precoV;

    public Vacina() {
    }
    
    

    public Vacina(String codigoV, String nomeV, String precoV) {
        this.codigoV = codigoV;
        this.nomeV = nomeV;
        this.precoV = precoV;
    }
    
    
    public String getCodigoV() {
        return codigoV;
    }

    public void setCodigoV(String codigoV) {
        this.codigoV = codigoV;
    }

    public String getNomeV() {
        return nomeV;
    }

    public void setNomeV(String nomeV) {
        this.nomeV = nomeV;
    }

    public String getPrecoV() {
        return precoV;
    }

    public void setPrecoV(String precoV) {
        this.precoV = precoV;
    }
    
    
    
    
}
