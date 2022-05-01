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
public class Exame {
    
    private String codigoE;       
    private String nomeE;
    private String precoE;

    public Exame() {
    }
    
    

    public Exame(String codigoE, String nomeE, String precoE) {
        this.codigoE = codigoE;
        this.nomeE = nomeE;
        this.precoE = precoE;
    }
    
    

    public String getCodigoE() {
        return codigoE;
    }

    public void setCodigoE(String codigoE) {
        this.codigoE = codigoE;
    }

    public String getNomeE() {
        return nomeE;
    }

    public void setNomeE(String nomeE) {
        this.nomeE = nomeE;
    }

    public String getPrecoE() {
        return precoE;
    }

    public void setPrecoE(String precoE) {
        this.precoE = precoE;
    }
    
    
    
}
