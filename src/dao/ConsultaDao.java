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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Agendamento;
import model.Consulta;
import petFX.ConsultaTela;

/**
 *
 * @author Lucas Eduardo
 */
public class ConsultaDao {

    private Connection con;

    public ConsultaDao() {

        this.con = BDFabricaCon.getConnection();

    }

    public boolean insertConsulta(Consulta consulta) {

        String sql = "insert into consulta (data_con, hora_con, codigopet, nomepet, cpf_crmv,"
                + "nome_user,peso_con,idade_con,obs_con,vacina1,vacina2,vacina3,"
                + "remedio1,remedio2,remedio3,exame1,exame2,exame3)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, consulta.getDataCon());
            stmt.setString(2, consulta.getHoraCon());
            stmt.setString(3, consulta.getCodigopet());
            stmt.setString(4, consulta.getNomepet());
            stmt.setString(5, consulta.getCpfcrmv());
            stmt.setString(6, consulta.getNomeUser());
            stmt.setString(7, consulta.getPesoCon());
            stmt.setString(8, consulta.getIdadeCon());
            stmt.setString(9, consulta.getObsCon());
            stmt.setString(10, consulta.getVacina1());
            stmt.setString(11, consulta.getVacina2());
            stmt.setString(12, consulta.getVacina3());
            stmt.setString(13, consulta.getRemedio1());
            stmt.setString(14, consulta.getRemedio2());
            stmt.setString(15, consulta.getRemedio3());
            stmt.setString(16, consulta.getExame1());
            stmt.setString(17, consulta.getExame2());
            stmt.setString(18, consulta.getExame3());
            

            stmt.execute();
            return true;

        } catch (SQLException ex) {
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

}
