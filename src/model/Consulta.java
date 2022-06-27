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
    private String idadeCon;
    private String obsCon;
    private String vacina1;
    private String vacina2;
    private String vacina3;
    private String remedio1;
    private String remedio2;
    private String remedio3;
    private String exame1;
    private String exame2;
    private String exame3;

    public Consulta() {
    }

    public Consulta(String dataCon, String horaCon, String codigopet, String nomepet, String cpfcrmv, String nomeUser, String pesoCon, String idadeCon, String obsCon, String vacina1, String vacina2, String vacina3, String remedio1, String remedio2, String remedio3, String exame1, String exame2, String exame3) {
        this.dataCon = dataCon;
        this.horaCon = horaCon;
        this.codigopet = codigopet;
        this.nomepet = nomepet;
        this.cpfcrmv = cpfcrmv;
        this.nomeUser = nomeUser;
        this.pesoCon = pesoCon;
        this.idadeCon = idadeCon;
        this.obsCon = obsCon;
        this.vacina1 = vacina1;
        this.vacina2 = vacina2;
        this.vacina3 = vacina3;
        this.remedio1 = remedio1;
        this.remedio2 = remedio2;
        this.remedio3 = remedio3;
        this.exame1 = exame1;
        this.exame2 = exame2;
        this.exame3 = exame3;
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

    public String getVacina1() {
        return vacina1;
    }

    public void setVacina1(String vacina1) {
        this.vacina1 = vacina1;
    }

    public String getRemedio1() {
        return remedio1;
    }

    public void setRemedio1(String remedio1) {
        this.remedio1 = remedio1;
    }

    public String getExame1() {
        return exame1;
    }

    public void setExame1(String exame1) {
        this.exame1 = exame1;
    }

    public String getVacina2() {
        return vacina2;
    }

    public void setVacina2(String vacina2) {
        this.vacina2 = vacina2;
    }

    public String getRemedio2() {
        return remedio2;
    }

    public void setRemedio2(String remedio2) {
        this.remedio2 = remedio2;
    }

    public String getExame2() {
        return exame2;
    }

    public void setExame2(String exame2) {
        this.exame2 = exame2;
    }

    public String getVacina3() {
        return vacina3;
    }

    public void setVacina3(String vacina3) {
        this.vacina3 = vacina3;
    }

    public String getRemedio3() {
        return remedio3;
    }

    public void setRemedio3(String remedio3) {
        this.remedio3 = remedio3;
    }

    public String getExame3() {
        return exame3;
    }

    public void setExame3(String exame3) {
        this.exame3 = exame3;
    }

}
