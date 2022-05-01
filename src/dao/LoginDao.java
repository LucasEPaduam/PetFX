/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bdcon.BDFabricaCon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Eduardo
 */
public class LoginDao {
    
    public String login(String usuario, String senha) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT cpf_crmv FROM Usuario "
                + "WHERE cpf_crmv='" + usuario + "' AND "
                + "senha ='" + senha + "';";

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
    
}
