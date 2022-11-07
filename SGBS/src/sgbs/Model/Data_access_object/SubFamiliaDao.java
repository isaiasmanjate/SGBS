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
import sgbs.Model.value_object.SubFamilia;

/**
 *
 * @author Manjate
 */
public class SubFamiliaDao {
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
     public ArrayList<SubFamilia> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<SubFamilia> subFamilia = new ArrayList();
        try {
            stnt = con.prepareStatement("Select * from Subfamilia");
            rs = stnt.executeQuery();
            while (rs.next()) {
                SubFamilia  sfm = new SubFamilia();
              sfm.setCodigo_subfamilia(rs.getInt("codigo_subfamilia"));
              sfm.setSubFamilia_nome(rs.getString("nome"));
              sfm.setSubfamilia_descricao(rs.getString("Subfamilia_descricao"));
              sfm.setCodigo(rs.getInt("codigo_familia"));
              
              subFamilia.add(sfm);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return subFamilia;
    }
}
