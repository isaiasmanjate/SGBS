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
import sgbs.Model.value_object.Funcionario;
import sgbs.Model.value_object.Venda;

/**
 *
 * @author Manjate
 */
public class FuncionarioDao {
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

    public ArrayList<Funcionario> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionario = new ArrayList<>();
        try {
            stnt = con.prepareStatement("Select *  from funcionario");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Funcionario fn = new Funcionario();
                fn.setCodigo(rs.getInt("codigo"));
                fn.setNome(rs.getString("nome"));
                fn.setContacto(rs.getString("contacto"));
                fn.setMorada(rs.getString("morada"));
                fn.setNuit(rs.getLong("nuit"));
                fn.setUsername(rs.getString("username"));
                fn.setPassword(rs.getString("password"));
                fn.setNivel(rs.getByte("nivel"));
                funcionario.add(fn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return funcionario;
    }

    public Funcionario getClienteById(int id) {
        Connection con = ConnectionFactory.getConnection();

        Funcionario fn = new Funcionario();
        ArrayList<Funcionario> funcionario= readAll();

        for (int i = 0; i < funcionario.size(); i++) {
            if (id == funcionario.get(i).getCodigo()) {
                fn.setCodigo(funcionario.get(i).getCodigo());
                fn.setNome(funcionario.get(i).getNome());
                fn.setContacto(funcionario.get(i).getContacto());
                fn.setMorada(funcionario.get(i).getMorada());
                fn.setNuit(funcionario.get(i).getNuit());
                fn.setUsername(funcionario.get(i).getUsername());
                fn.setPassword(funcionario.get(i).getPassword());
                fn.setNivel(funcionario.get(i).getNivel());

                funcionario.add(fn);
            }
        }
        return fn;

    }

    public boolean verifyId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        boolean status = false;

        ArrayList<Funcionario> funcionario = readAll();

        for (int j = 0; j < funcionario.size(); j++) {
            if (id == funcionario.get(j).getCodigo()) {
                status = true;
            }
        }
        return status;

    }
    public boolean deleteFuncionarioById(int id){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        //ResultSet rs=null;
        try {
             
            stnt=con.prepareStatement("Delete from funcionario where codigo= ?");
            stnt.setInt(1, id);
            stnt.executeUpdate();
            return true;
        }  catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection( con, stnt);
        }
         
    }
        public int lastId(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        
        int num = 0;
        ArrayList<Funcionario> func = readAll();
        
        for(int j = 0; j < func.size(); j++){
              if(j == (func.size() - 1))
                  num = func.get(j).getCodigo();
        }
        return num;
    }
}
