/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sgbs.Connection.ConnectionFactory;
import sgbs.Model.value_object.Logs;

/**
 *
 * @author Manjate
 */
public class LogsDao {
     public boolean create(String sql){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        try{
            stnt=con.prepareStatement(sql);
            stnt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con,stnt);
        }
    }
     public ArrayList<Logs> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Logs> logs = new ArrayList();
        try {
            stnt = con.prepareStatement("Select * from Logs");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Logs  lg = new Logs();
              lg.setCodigo(rs.getInt("codigo"));
              lg.setData(rs.getString("data_ocorrencia"));
              lg.setDescricao(rs.getString("descricao"));
              lg.setCodigo_funcionario(rs.getInt("codigo_funcionario"));
              logs.add(lg);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return logs;
    }
     
}
