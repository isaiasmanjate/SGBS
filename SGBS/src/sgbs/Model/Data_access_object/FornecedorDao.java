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
import java.util.logging.Level;
import java.util.logging.Logger;
import sgbs.Connection.ConnectionFactory;
import sgbs.Model.value_object.Fornecedor;

/**
 *
 * @author Manjate
 */
public class FornecedorDao {
   public boolean create(String sql) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        try {
            stnt = con.prepareStatement(sql);
            stnt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro :" + ex.getMessage());
            return false;

        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }

    public ArrayList<Fornecedor> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> fornecedor = new ArrayList<>();
        try {
            stnt = con.prepareStatement("Select *  from fornecedor");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Fornecedor fc = new Fornecedor();
                fc.setCodigo(rs.getInt("codigo"));
                fc.setNome(rs.getString("nome"));
                fc.setContacto(rs.getString("contacto"));
                fc.setMorada(rs.getString("morada"));
                fc.setNuit(rs.getLong("nuit"));
                fornecedor.add(fc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return fornecedor;
    }

    public Fornecedor getFornecedorById(int id) {
        Connection con = ConnectionFactory.getConnection();

        Fornecedor fc= new Fornecedor();
        ArrayList<Fornecedor> fornecedor = readAll();

        for (int i = 0; i < fornecedor.size(); i++) {
            if (id == fornecedor.get(i).getCodigo()) {
                fc.setCodigo(fornecedor.get(i).getCodigo());
                fc.setNome(fornecedor.get(i).getNome());
                fc.setContacto(fornecedor.get(i).getContacto());
                fc.setMorada(fornecedor.get(i).getMorada());
                fc.setNuit(fornecedor.get(i).getNuit());

               
            }
        } fornecedor.add(fc);
        return fc;

    }

    public boolean verifyId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        boolean status = false;

        ArrayList<Fornecedor> fornecedor = readAll();

        for (int j = 0; j < fornecedor.size(); j++) {
            if (id == fornecedor.get(j).getCodigo()) {
                status = true;
            }
        }
        return status;

    }
    public boolean deleteFornecedorById(int id){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        try {
             
            stnt=con.prepareStatement("Delete from fornecedor where codigo = ?");
            stnt.setInt(1, id);
            stnt.executeUpdate();
            return true;
        }  catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection( con, stnt, rs);
        }
         
    } 
         public int lastId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;

        int num = 0;
        ArrayList<Fornecedor> func = readAll();

        for (int j = 0; j < func.size(); j++) {
            if (j == (func.size() - 1)) {
                num = func.get(j).getCodigo();
            }
        }
        return num;
    }
}
