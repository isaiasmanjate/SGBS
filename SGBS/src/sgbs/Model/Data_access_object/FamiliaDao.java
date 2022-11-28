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
import sgbs.Model.value_object.Cliente;
import sgbs.Model.value_object.Familia;
import sgbs.Model.value_object.Funcionario;

/**
 *
 * @author Manjate
 */
public class FamiliaDao {
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
     public ArrayList<Familia> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Familia> familia = new ArrayList();
        try {
            stnt = con.prepareStatement("Select * from familia");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Familia  fm = new Familia();
              fm.setCodigo(rs.getInt("codigo"));
              fm.setNome(rs.getString("nome"));
              fm.setDescricao(rs.getString("descricao"));
              familia.add(fm);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return familia;
    }
     public int lastId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        int num = 0;
        ArrayList<Familia> func = readAll();
        for (int j = 0; j < func.size(); j++) {
            if (j == (func.size() - 1)) {
                num = func.get(j).getCodigo();
            }
        }
        return num;
    }
        public Familia getFamiliaById(int id) {
        Connection con = ConnectionFactory.getConnection();

        Familia fam = new Familia();
        ArrayList<Familia> familia = readAll();

        for (int i = 0; i < familia.size(); i++) {
            if (id == familia.get(i).getCodigo()) {
                fam.setCodigo(familia.get(i).getCodigo());
                fam.setNome(familia.get(i).getNome());
                fam.setDescricao(familia.get(i).getDescricao());
           
             
              //  System.out.println("Ola");
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

        ArrayList<Familia> familia = readAll();

        for (int j = 0; j < familia.size(); j++) {
            if (id == familia.get(j).getCodigo()) {
                status = true;
            }
        }
        return status;

    }
    
}
