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
import model.Exame;
import model.Remedio;

/**
 *
 * @author Lucas Eduardo
 */
public class ExameDao {

    private Connection con;

    public ExameDao() {

        this.con = BDFabricaCon.getConnection();

    }

    public List<Exame> getList() {

        List<Exame> tiposExames = new ArrayList<>();
        String sql = "SELECT * FROM petExame ORDER BY nome;";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Exame ex = new Exame();
                ex.setCodigoE(rs.getString("codigo"));
                ex.setNomeE(rs.getString("nome"));
                ex.setPrecoE(rs.getString("preco"));

                tiposExames.add(ex);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }

        return tiposExames;
    }

    public boolean insertExame(Exame exame) {

        String sql = "INSERT INTO petExame (codigo, nome, preco)VALUES (?,?,?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, exame.getCodigoE());
            stmt.setString(2, exame.getNomeE());
            stmt.setString(3, exame.getPrecoE());

            stmt.execute();
            return true;

        } catch (SQLException ex) {
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

    public boolean updateExame(Exame exame) {

        String sql = "UPDATE petExame SET nome = ?, preco = ? WHERE codigo =?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, exame.getNomeE());
            stmt.setString(2, exame.getPrecoE());
            stmt.setString(3, exame.getCodigoE());

            stmt.execute();
            stmt.close();
            con.close();
            return true;

        } catch (SQLException ex) {
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

    public boolean deleteExame(Exame exame) {

        String sql = "DELETE FROM petExame WHERE codigo =?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, exame.getCodigoE());
            stmt.execute();
            stmt.close();
            con.close();
            return true;

        } catch (SQLException ex) {
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

    public String codExame(String codExame) {

        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        String userName = null;

        try {
            con = BDFabricaCon.getConnection();
            String sql = "SELECT codigo FROM petExame "
                    + "WHERE codigo='" + codExame + "';";

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

                if (st != null) {
                    st.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userName;
    }

    public Exame pesquisar(String codExame) {

        Exame exame = new Exame();
        String sql = "SELECT * FROM petExame WHERE codigo = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codExame);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                exame.setCodigoE(rs.getString("codigo"));
                exame.setNomeE(rs.getString("nome"));
                exame.setPrecoE(rs.getString("preco"));

            } else {
                return null;
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return exame;
    }

    public List<String> getListNomeExames() {

        List<String> exList = new ArrayList<>();

        String sql = "SELECT nome FROM petExame ORDER BY nome";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Exame ex = new Exame();
                ex.setNomeE(rs.getString("nome"));

                exList.add(ex.getNomeE());
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO, PEQUISA NÃO REALIZADA");
            return null;
        }

        return exList;

    }

}
