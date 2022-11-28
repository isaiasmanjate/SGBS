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
import sgbs.Model.value_object.Produto;
import sgbs.Model.value_object.Stock;

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
      public ArrayList<Stock> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Stock> stock = new ArrayList<>();
        try {
            stnt = con.prepareStatement("Select *  from Stock");
            rs = stnt.executeQuery();
            while (rs.next()) {
               Stock sc= new Stock();
                sc.setCodigo(rs.getInt("codigo"));
                sc.setCodigo_produto(rs.getInt("codigo_produto"));
                sc.setCodigo_fornecedor(rs.getInt("codigo_fornecedor"));
                sc.setDescricao(rs.getString("descricao"));
                sc.setPreco_compra(rs.getFloat("preco_compra"));
                sc.setQuantidade(rs.getInt("quantidade"));
                sc.setTotal(rs.getFloat("total"));
                
                stock.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return stock;
    }
       public int lastId(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        
        int num = 0;
        ArrayList<Stock> func = readAll();
        
        for(int j = 0; j < func.size(); j++){
              if(j == (func.size() - 1))
                  num = func.get(j).getCodigo();
        }
        return num;
    }
     
     
}
