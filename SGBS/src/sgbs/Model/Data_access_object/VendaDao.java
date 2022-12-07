/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Data_access_object;

/**
 *
 * @author Manjate
 */
import java.sql.*;
import java.util.ArrayList;
import sgbs.Model.value_object.Venda;
import sgbs.Connection.ConnectionFactory;

public class VendaDao {
    
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
    public ArrayList<Venda> readAll(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        ArrayList<Venda> venda=new ArrayList<>();
        try{
        stnt=con.prepareStatement("Select * from vendas");
        rs=stnt.executeQuery();
        while(rs.next()){
            Venda v=new Venda();
            v.setId_venda(rs.getInt("codigo"));
            v.setId_produto(rs.getInt("codigo_produto"));
            v.setId_cliente(rs.getInt("codigo_cliente"));
            v.setId_funcionario(rs.getInt("codigo_funcionario"));
            v.setDescricao(rs.getString("descricao"));
            v.setQtd(rs.getInt("quantidade"));
            v.setPreco(rs.getFloat("Preco_venda"));
            v.setData(rs.getString("data_venda"));
            v.setTotal(rs.getFloat("total"));
            
            venda.add(v);
        }
        
        }catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }finally{
            ConnectionFactory.closeConnection(con,stnt,rs);
        }
        return venda;
        
        
    }
    public int lastId(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        
        int num = 0;
        ArrayList<Venda> func = readAll();
        
        for(int j = 0; j < func.size(); j++){
              if(j == (func.size() - 1))
                  num = func.get(j).getId_venda();
        }
        return num;
    }
    public Venda getVendaById(int id) {
        ArrayList<Venda> produto = readAll();
        Venda p = new Venda();

        for (int i = 0; i < produto.size(); i++) {
            if (id == produto.get(i).getId_venda()) {
                p.setId_produto(produto.get(i).getId_produto());
                p.setData(produto.get(i).getData());
                p.setDescricao(produto.get(i).getDescricao());
                p.setId_funcionario(produto.get(i).getId_funcionario());
                p.setId_cliente(produto.get(i).getId_cliente());
                p.setId_venda(produto.get(i).getId_venda());
                p.setPreco(produto.get(i).getPreco());
                p.setQtd(produto.get(i).getQtd());
                p.setTotal(produto.get(i).getTotal());

            }
        }
        return p;
    }
}
