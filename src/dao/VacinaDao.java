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
import model.Vacina;

/**
 *
 * @author Lucas Eduardo
 */
public class VacinaDao {
    
     private Connection con;
    
    public VacinaDao(){
        
        this.con = BDFabricaCon.getConnection();
       
}
    
     public List<Vacina> getListVacina(){
       
      List<Vacina> tiposVacinas = new ArrayList<>();
      String sql = "SELECT * FROM petVacina ORDER BY nome;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Vacina vacina = new Vacina();
                vacina.setCodigoV(rs.getString("codigo"));
                vacina.setNomeV(rs.getString("nome"));
                vacina.setPrecoV(rs.getString("preco"));
                
                tiposVacinas.add(vacina);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return tiposVacinas;
   }
        
    
    
    public boolean insertVacina(Vacina vacina) {

        String sql = "INSERT INTO petVacina (codigo, nome, preco)VALUES (?,?,?)";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, vacina.getCodigoV());
            stmt.setString(2, vacina.getNomeV());
            stmt.setString(3, vacina.getPrecoV());
            
            stmt.execute();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean updateVacina(Vacina vacina) {

        String sql = "UPDATE petVacina SET nome = ?, preco = ? WHERE codigo =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, vacina.getNomeV());
            stmt.setString(2, vacina.getPrecoV());
            stmt.setString(3, vacina.getCodigoV());
            
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
     public boolean deleteVacina(Vacina vacina) {

        String sql = "DELETE FROM petVacina WHERE codigo =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, vacina.getCodigoV());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
     public String codVacina(String codVacina) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT codigo FROM petVacina "
                + "WHERE codigo='" + codVacina + "';";

            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                userName = rs.getString("codigo");
            }

        } catch (SQLException ex) {
            
            
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userName;
    }
    
     public Vacina pesquisar(String codVacina){
       
      Vacina vacina = new Vacina();
      String sql = "SELECT * FROM petVacina WHERE codigo = ?";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codVacina);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                                
                vacina.setCodigoV(rs.getString("codigo"));
                vacina.setNomeV(rs.getString("nome"));
                vacina.setPrecoV(rs.getString("preco"));
                
                                
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
               
    return vacina;
   }
    
    
    
    
    
}
