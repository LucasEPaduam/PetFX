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
import model.Agendamento;

/**
 *
 * @author Lucas Eduardo
 */
public class AgendamentoDao {
    
    private Connection con;
    
    public AgendamentoDao(){
        
        this.con = BDFabricaCon.getConnection();
       
}
    
     public List<Agendamento> getListAgendamentos(){
       
      List<Agendamento> agendamentos = new ArrayList<>();
      String sql = "SELECT * FROM agendamento ORDER BY data_con;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Agendamento ag = new Agendamento();
                ag.setDataCon(rs.getString("data_con"));
                ag.setHoraCon(rs.getString("hora_con"));
                ag.setCodigopet(rs.getString("codigopet"));
                ag.setNomepet(rs.getString("nomepet"));
                ag.setCpfcrmv(rs.getString("cpf_crmv"));
                ag.setNomeUser(rs.getString("nome_User"));
                
                agendamentos.add(ag);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return agendamentos;
   }
        
    
    
    public boolean insertAgendamento(Agendamento agendamento) {

        String sql = "insert into agendamento (data_con, hora_con, codigopet, nomepet, cpf_crmv, nome_user)"
                                              + "values(?,?,?,?,?,?)";
        
        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, agendamento.getHoraCon());
            stmt.setString(2, agendamento.getHoraCon());
            stmt.setString(3, agendamento.getCodigopet());
            stmt.setString(4, agendamento.getNomepet());
            stmt.setString(5, agendamento.getCpfcrmv());
            stmt.setString(6, agendamento.getNomeUser());
            stmt.execute();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(AgendamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(AgendamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
   
    
     public boolean deleteAgendamento(Agendamento agendamento) {

        String sql = "DELETE FROM agendamento WHERE data_con = ? AND hora_con = ?";

        
        try{
                
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, agendamento.getDataCon());
            stmt.setString(2, agendamento.getHoraCon());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
            
        }catch (SQLException ex) {
            Logger.getLogger(AgendamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                if (con != null) {
                    con.close();
                   }
            } catch (SQLException ex) {
                Logger.getLogger(AgendamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
     
    
    
     public List<Agendamento> getListAgendamentosDia(){
       
      List<Agendamento> agendamentos = new ArrayList<>();
      String sql = "SELECT * FROM agendamento WHERE data_con = curdate() ORDER BY data_con;";
      
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                Agendamento ag = new Agendamento();
                ag.setDataCon(rs.getString("data_con"));
                ag.setHoraCon(rs.getString("hora_con"));
                ag.setCodigopet(rs.getString("codigopet"));
                ag.setNomepet(rs.getString("nomepet"));
                ag.setCpfcrmv(rs.getString("cpf_crmv"));
                ag.setNomeUser(rs.getString("nome_User"));
                
                agendamentos.add(ag);                
            }
            stmt.close();
            rs.close();
            con.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }      
               
    return agendamentos;
   }
}
