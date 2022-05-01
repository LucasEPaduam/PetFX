/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Eduardo
 */
public class BDconMySQL extends BDcon {

   
    
     public BDconMySQL(){
        
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.porta = 3306;
        this.servidor = "localhost";
        this.bd = "petFX";
        this.usuario = "root";
        this.senha = "";
    }
    
    @Override
    public Connection getConnection() { 
        
        try {
            Class.forName(driver);
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(getURL(), usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDconMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            
          Logger.getLogger(BDconMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }

    @Override
    public String getURL() {
        
        return "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bd
                + "?useTimezone=true&serverTimezone=UTC";
        
    }
    
}
