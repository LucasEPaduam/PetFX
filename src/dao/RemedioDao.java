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
import model.Remedio;


/**
 *
 * @author Lucas Eduardo
 */
public class RemedioDao {
    
    private Connection con;
    
    public RemedioDao(){
        
        this.con = BDFabricaCon.getConnection();
       
}
    
     public List<Remedio> getListRemedio(){
       
      List<Remedio> tiposRemedio = new ArrayList<>();
      String sql = "SELECT * FROM petRemedio ORDER BY nome;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Remedio remedio = new Remedio();
                remedio.setCodigoR(rs.getString("codigo"));
                remedio.setNomeR(rs.getString("nome"));
                remedio.setPrecoR(rs.getString("preco"));
                
                tiposRemedio.add(remedio);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return tiposRemedio;
   }
        
    
    
    public boolean insertRemedio(Remedio remedio) {

        
        
        try{
            
            String sql = "INSERT INTO petRemedio (codigo, nome, preco)VALUES (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, remedio.getCodigoR());
            stmt.setString(2, remedio.getNomeR());
            stmt.setString(3, remedio.getPrecoR());
            
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
    
    public boolean updateRemedio(Remedio remedio) {

        String sql = "UPDATE petRemedio SET nome = ?, preco = ? WHERE codigo =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, remedio.getNomeR());
            stmt.setString(2, remedio.getPrecoR());
            stmt.setString(3, remedio.getCodigoR());
            
            
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
    
     public boolean deleteRemedio(Remedio remedio) {

        String sql = "DELETE FROM petRemedio WHERE codigo =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, remedio.getCodigoR());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(RemedioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(RemedioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
     public String codRemedio(String codRemedio) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT codigo FROM petRemedio "
                + "WHERE codigo='" + codRemedio + "';";

            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                userName = rs.getString("codigo");
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
    
     public Remedio pesquisar(String codRemedio){
       
      Remedio remedio = new Remedio();
      String sql = "SELECT * FROM petRemedio WHERE codigo = ?";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codRemedio);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                                
                remedio.setCodigoR(rs.getString("codigo"));
                remedio.setNomeR(rs.getString("nome"));
                remedio.setPrecoR(rs.getString("preco"));
                
                                
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
               
    return remedio;
   }
    
    
}
