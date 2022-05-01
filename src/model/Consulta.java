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
public class Consulta {
    
    
        private String dataCon;       
        private String horaCon;
        private String codigopet;
        private String nomepet;
        private String cpfcrmv;
        private String nomeUser;
        private String pesoCon;  

    public Consulta(String dataCon, String horaCon, String codigopet, String nomepet, String cpfcrmv, String nomeUser) {
        this.dataCon = dataCon;
        this.horaCon = horaCon;
        this.codigopet = codigopet;
        this.nomepet = nomepet;
        this.cpfcrmv = cpfcrmv;
        this.nomeUser = nomeUser;
    }
        
        

    public String getDataCon() {
        return dataCon;
    }

    public void setDataCon(String dataCon) {
        this.dataCon = dataCon;
    }

    public String getHoraCon() {
        return horaCon;
    }

    public void setHoraCon(String horaCon) {
        this.horaCon = horaCon;
    }

    public String getCodigopet() {
        return codigopet;
    }

    public void setCodigopet(String codigopet) {
        this.codigopet = codigopet;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
    }

    public String getCpfcrmv() {
        return cpfcrmv;
    }

    public void setCpfcrmv(String cpfcrmv) {
        this.cpfcrmv = cpfcrmv;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getPesoCon() {
        return pesoCon;
    }

    public void setPesoCon(String pesoCon) {
        this.pesoCon = pesoCon;
    }

    public String getIdadeCon() {
        return idadeCon;
    }

    public void setIdadeCon(String idadeCon) {
        this.idadeCon = idadeCon;
    }

    public String getObsCon() {
        return obsCon;
    }

    public void setObsCon(String obsCon) {
        this.obsCon = obsCon;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }
        private String idadeCon;
        private String obsCon;
        private String vacina;
        private String remedio;
        private String exame;
    
    
    
    
    
    
    
    
}
