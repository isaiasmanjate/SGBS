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
import sgbs.Model.value_object.Familia;
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
     public int lastId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        int num = 0;
        ArrayList<SubFamilia> func = readAll();

        for (int j = 0; j < func.size(); j++) {
            if (j == (func.size() - 1)) {
                num = func.get(j).getCodigo_subfamilia();
            }
        }
        return num;
    }
     public SubFamilia getSubFamiliaById(int id) {
        Connection con = ConnectionFactory.getConnection();

        SubFamilia fam = new SubFamilia();
        ArrayList<SubFamilia> familia = readAll();

        for (int i = 0; i < familia.size(); i++) {
            if (id == familia.get(i).getCodigo_subfamilia()) {
                fam.setCodigo_subfamilia(familia.get(i).getCodigo_subfamilia());
                fam.setSubFamilia_nome(familia.get(i).getSubFamilia_nome());
                fam.setSubfamilia_descricao(familia.get(i).getSubfamilia_descricao());
                fam.setCodigo(familia.get(i).getCodigo());
           
               
            }
        }
         familia.add(fam);
        return fam;

    }
        public boolean verifyId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        boolean status = false;

        ArrayList<SubFamilia> familia = readAll();

        for (int j = 0; j < familia.size(); j++) {
            if (id == familia.get(j).getCodigo_subfamilia()) {
                status = true;
            }
        }
        return status;

    }
    
}
