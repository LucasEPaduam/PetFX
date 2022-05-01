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
public class Paciente {
    
        private String codigopet;       
        private String nomepet;
        private String raca;
        private String idade;
        private String peso;
        private String sexo;
        private String cpfdono;        
        private String nomedono;
        private String rua;
        private String numero;
        private String cep;
        private String cidade;
        private String UF;
        private String email;
        private String telefone;
        private String pesquisa;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Paciente() {
    }

    public Paciente(String codigopet) {
        this.codigopet = codigopet;
    }
        
        

    public Paciente(String codigopet, String nomepet, String raca, String idade, String peso, String sexo, String cpfdono, String nomedono, String rua, String numero, String cep, String cidade, String UF, String email, String telefone) {
        this.codigopet = codigopet;
        this.nomepet = nomepet;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
        this.cpfdono = cpfdono;
        this.nomedono = nomedono;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.UF = UF;
        this.email = email;
        this.telefone = telefone;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpfdono() {
        return cpfdono;
    }

    public void setCpfdono(String cpfdono) {
        this.cpfdono = cpfdono;
    }

    public String getNomedono() {
        return nomedono;
    }

    public void setNomedono(String nomedono) {
        this.nomedono = nomedono;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
        
        
    
}
