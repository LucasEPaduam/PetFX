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
import model.User;

/**
 *
 * @author Lucas Eduardo
 */
public class UserDao {
    private Connection con;
    
    public UserDao(){
        
        this.con = BDFabricaCon.getConnection();
}
    
   public List<User> getListU(){
       
      List<User> usuario = new ArrayList<>();
      String sql = "SELECT * FROM Usuario;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
          
                User user = new User();
                user.setCpfcrmv(rs.getString("cpf_crmv"));
                user.setNomeuser(rs.getString("nome_user"));
                user.setRuaU(rs.getString("rua"));
                user.setNumeroU(rs.getString("numero"));
                user.setCepU(rs.getString("cep"));
                user.setCidadeU(rs.getString("cidade"));
                user.setUFU(rs.getString("UF"));
                user.setTipoUser(rs.getString("tipo_user"));
                user.setSenha(rs.getString("senha"));
                user.setEmailU(rs.getString("email"));
                user.setTelU(rs.getString("tel"));
                usuario.add(user);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return usuario;
   }
        

    
    public boolean insertUser(User user) {

        String sql = "INSERT INTO Usuario (cpf_crmv, nome_user, rua, numero, cep, "
                + "cidade, UF, tipo_user, senha, email, tel)"              
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getCpfcrmv());
            stmt.setString(2, user.getNomeuser());
            stmt.setString(3, user.getRuaU());
            stmt.setString(4, user.getNumeroU());
            stmt.setString(5, user.getCepU());
            stmt.setString(6, user.getCidadeU());
            stmt.setString(7, user.getUFU());
            stmt.setString(8, user.getTipoUser());
            stmt.setString(9, user.getSenha());
            stmt.setString(10,user.getEmailU());
            stmt.setString(11,user.getTelU());
            stmt.execute();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public boolean updateUser(User user) {

        String sql = "UPDATE Usuario SET nome_user = ?, rua = ?, numero = ?, cep = ?," 
                + "cidade = ?, UF = ?, tipo_user = ?, senha = ?, email = ?, tel = ?" +
                                "WHERE cpf_crmv = ?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, user.getNomeuser());
            stmt.setString(2, user.getRuaU());
            stmt.setString(3, user.getNumeroU());
            stmt.setString(4, user.getCepU());
            stmt.setString(5, user.getCidadeU());
            stmt.setString(6, user.getUFU());
            stmt.setString(7, user.getTipoUser());
            stmt.setString(8, user.getSenha());
            stmt.setString(9,user.getEmailU());
            stmt.setString(10,user.getTelU());
            stmt.setString(11, user.getCpfcrmv());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
     public boolean deleteUser(User user) {

        String sql = "DELETE FROM Usuario WHERE cpf_crmv =?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, user.getCpfcrmv());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
     public User pesquisar(String cpfcrmv){
       
      User user = new User();
      String sql = "SELECT * FROM Usuario WHERE cpf_crmv = ?";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpfcrmv);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                                
                user.setCpfcrmv(rs.getString("cpf_crmv"));
                user.setNomeuser(rs.getString("nome_user"));
                user.setRuaU(rs.getString("rua"));
                user.setNumeroU(rs.getString("numero"));
                user.setCepU(rs.getString("cep"));
                user.setCidadeU(rs.getString("cidade"));
                user.setUFU(rs.getString("UF"));
                user.setTipoUser(rs.getString("tipo_user"));
                user.setSenha(rs.getString("senha"));
                user.setEmailU(rs.getString("email"));
                user.setTelU(rs.getString("tel"));
                                
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
               
    return user;
   }
    
      public String codUser(String cpfcrmv) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT cpf_crmv FROM Usuario "
                + "WHERE cpf_crmv='" + cpfcrmv + "';";

            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                userName = rs.getString("cpf_crmv");
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
     
    public boolean alteraSenhaUser(String user, String novaSenha) {

        String sql = "UPDATE Usuario SET senha = ? WHERE cpf_crmv = ?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, novaSenha);
            stmt.setString(2, user);          
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
      
      
      
}
