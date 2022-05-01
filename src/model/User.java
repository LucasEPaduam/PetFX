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
public class User {
    
        private String cpfcrmv;       
        private String nomeuser;
        private String ruaU;
        private String numeroU;
        private String cepU;
        private String cidadeU;
        private String UFU;
        private String tipoUser;
        private String senha;
        private String emailU;
        private String telU;

    public User() {
    }

    public User(String cpfcrmv) {
        this.cpfcrmv = cpfcrmv;
    }
        
        

    public User(String cpfcrmv, String nomeuser, String ruaU, String numeroU, String cepU, String cidadeU, String UFU, String tipoUser, String senha, String emailU, String telU) {
        this.cpfcrmv = cpfcrmv;
        this.nomeuser = nomeuser;
        this.ruaU = ruaU;
        this.numeroU = numeroU;
        this.cepU = cepU;
        this.cidadeU = cidadeU;
        this.UFU = UFU;
        this.tipoUser = tipoUser;
        this.senha = senha;
        this.emailU = emailU;
        this.telU = telU;
    }
        
        

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getTelU() {
        return telU;
    }

    public void setTelU(String telU) {
        this.telU = telU;
    }

    
        
        

    public String getCpfcrmv() {
        return cpfcrmv;
    }

    public void setCpfcrmv(String cpfcrmv) {
        this.cpfcrmv = cpfcrmv;
    }

    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    public String getRuaU() {
        return ruaU;
    }

    public void setRuaU(String ruaU) {
        this.ruaU = ruaU;
    }

    public String getNumeroU() {
        return numeroU;
    }

    public void setNumeroU(String numeroU) {
        this.numeroU = numeroU;
    }

    public String getCepU() {
        return cepU;
    }

    public void setCepU(String cepU) {
        this.cepU = cepU;
    }

    public String getCidadeU() {
        return cidadeU;
    }

    public void setCidadeU(String cidadeU) {
        this.cidadeU = cidadeU;
    }

    public String getUFU() {
        return UFU;
    }

    public void setUFU(String UFU) {
        this.UFU = UFU;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
        
        
        
        
        
        
        
    
}


