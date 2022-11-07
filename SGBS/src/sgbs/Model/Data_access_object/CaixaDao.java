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
import sgbs.Model.value_object.Caixa;

/**
 *
 * @author Manjate
 */
public class CaixaDao {
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
     public ArrayList<Caixa> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Caixa> caixa = new ArrayList();
        try {
            stnt = con.prepareStatement("Select * from familia");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Caixa  cx = new Caixa();
             cx.setTotal(rs.getFloat("total"));
             cx.setValor_actual(rs.getFloat("valor_actual"));
             
             caixa.add(cx);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return caixa;
    }
}
