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
import sgbs.Model.value_object.Cliente;
import sgbs.Connection.ConnectionFactory;

/**
 *
 * @author Manjate
 */
public class ClienteDao {

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

    public ArrayList<Cliente> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Cliente> cliente = new ArrayList<>();
        try {
            stnt = con.prepareStatement("Select *  from clientes");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setCodigo(rs.getInt("codigo"));
                cl.setNome(rs.getString("nome"));
                cl.setContacto(rs.getString("contacto"));
                cl.setMorada(rs.getString("morada"));
                cl.setNuit(rs.getLong("nuit"));
                cliente.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return cliente;
    }

    public Cliente getClienteById(int id) {
        Connection con = ConnectionFactory.getConnection();

        Cliente cl = new Cliente();
        ArrayList<Cliente> cliente = readAll();

        for (int i = 0; i < cliente.size(); i++) {
            if (id == cliente.get(i).getCodigo()) {
                cl.setCodigo(cliente.get(i).getCodigo());
                cl.setNome(cliente.get(i).getNome());
                cl.setContacto(cliente.get(i).getContacto());
                cl.setMorada(cliente.get(i).getMorada());
                cl.setNuit(cliente.get(i).getNuit());

                cliente.add(cl);
            }
        }
        return cl;

    }

    public boolean verifyId(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        boolean status = false;

        ArrayList<Cliente> cliente = readAll();

        for (int j = 0; j < cliente.size(); j++) {
            if (id == cliente.get(j).getCodigo()) {
                status = true;
            }
        }
        return status;

    }
    public boolean deleteClienteById(int id){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        try {
             
            stnt=con.prepareStatement("Delete from cliente where codigo = ?");
            stnt.setInt(1, id);
            stnt.executeUpdate();
            return true;
        }  catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection( con, stnt, rs);
        }
         
    }

}
