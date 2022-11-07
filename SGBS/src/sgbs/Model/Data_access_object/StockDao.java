/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sgbs.Connection.ConnectionFactory;

/**
 *
 * @author Manjate
 */
public class StockDao {
    
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
     
}
