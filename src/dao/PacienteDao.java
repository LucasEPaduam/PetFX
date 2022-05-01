/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdcon.BDFabricaCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Paciente;

/**
 *
 * @author Lucas Eduardo
 */
public class PacienteDao {
    
    private Connection con;
    
    public PacienteDao(){
        
        this.con = BDFabricaCon.getConnection();
}
    
   public List<Paciente> getList(){
       
      List<Paciente> paciente = new ArrayList<>();
      String sql = "SELECT * FROM Paciente ORDER BY nomepet;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Paciente pac = new Paciente();
                pac.setCodigopet(rs.getString("codigopet"));
                pac.setNomepet(rs.getString("nomepet"));
                pac.setRaca(rs.getString("raca"));
                pac.setPeso(rs.getString("peso"));
                pac.setSexo(rs.getString("sexo"));
                pac.setCpfdono(rs.getString("cpfdono"));
                pac.setNomedono(rs.getString("nomedono"));
                pac.setRua(rs.getString("rua"));
                pac.setNumero(rs.getString("numero"));
                pac.setCep(rs.getString("cep"));
                pac.setCidade(rs.getString("cidade"));
                pac.setUF(rs.getString("UF"));
                pac.setEmail(rs.getString("email"));
                pac.setTelefone(rs.getString("telefone"));
                paciente.add(pac);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return paciente;
   }
        
    
    
    public boolean insertPac(Paciente paciente) {

        String sql = "INSERT INTO Paciente (codigopet, nomepet, raca, idade, peso, sexo," 
            + "cpfdono, nomedono, rua, numero, cep, cidade, UF, email, telefone)" +
              "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, paciente.getCodigopet());
            stmt.setString(2, paciente.getNomepet());
            stmt.setString(3, paciente.getRaca());
            stmt.setString(4, paciente.getIdade());
            stmt.setString(5, paciente.getPeso());
            stmt.setString(6, paciente.getSexo());
            stmt.setString(7, paciente.getCpfdono());
            stmt.setString(8, paciente.getNomedono());
            stmt.setString(9, paciente.getRua());
            stmt.setString(10, paciente.getNumero());
            stmt.setString(11, paciente.getCep());
            stmt.setString(12, paciente.getCidade());
            stmt.setString(13, paciente.getUF());
            stmt.setString(14, paciente.getEmail());
            stmt.setString(15, paciente.getTelefone());
            stmt.execute();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean updatePac(Paciente paciente) {

        String sql = "UPDATE Paciente SET nomepet = ?, raca = ?, idade = ?, peso = ?, sexo = ?," 
            + "cpfdono = ?, nomedono = ?, rua = ?, numero = ?, cep = ?, cidade = ?, UF = ?, email = ?, telefone = ?" +
              "WHERE codigopet =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, paciente.getNomepet());
            stmt.setString(2, paciente.getRaca());
            stmt.setString(3, paciente.getIdade());
            stmt.setString(4, paciente.getPeso());
            stmt.setString(5, paciente.getSexo());
            stmt.setString(6, paciente.getCpfdono());
            stmt.setString(7, paciente.getNomedono());
            stmt.setString(8, paciente.getRua());
            stmt.setString(9, paciente.getNumero());
            stmt.setString(10, paciente.getCep());
            stmt.setString(11, paciente.getCidade());
            stmt.setString(12, paciente.getUF());
            stmt.setString(13, paciente.getEmail());
            stmt.setString(14, paciente.getTelefone());
            stmt.setString(15, paciente.getCodigopet());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
     public boolean deletePac(Paciente paciente) {

        String sql = "DELETE FROM Paciente WHERE codigopet =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, paciente.getCodigopet());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(PacienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
     public String codPac(String codpet) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT codigopet FROM Paciente "
                + "WHERE codigopet='" + codpet + "';";

            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                userName = rs.getString("codigopet");
            }

        } catch (SQLException ex) {
            
            
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
                
                if(st != null){
                    st.close();
                }
                
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userName;
    }
    
     public Paciente pesquisar(String codpet){
       
      Paciente pac = new Paciente();
      String sql = "SELECT * FROM Paciente WHERE codigopet = ?";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codpet);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                                
                pac.setCodigopet(rs.getString("codigopet"));
                pac.setNomepet(rs.getString("nomepet"));
                pac.setRaca(rs.getString("raca"));
                pac.setIdade(rs.getString("idade"));
                pac.setPeso(rs.getString("peso"));
                pac.setSexo(rs.getString("sexo"));
                pac.setCpfdono(rs.getString("cpfdono"));
                pac.setNomedono(rs.getString("nomedono"));
                pac.setRua(rs.getString("rua"));
                pac.setNumero(rs.getString("numero"));
                pac.setCep(rs.getString("cep"));
                pac.setCidade(rs.getString("cidade"));
                pac.setUF(rs.getString("UF"));
                pac.setEmail(rs.getString("email"));
                pac.setTelefone(rs.getString("telefone"));
                                
            }else{
                return null;
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }      
               
    return pac;
   }
}
