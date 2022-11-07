/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sgbs.Model.value_object.Produto;
import sgbs.Connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Manjate
 */
public class ProdutoDao {

    public boolean create(String sql) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement(sql);
            stnt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }

    public ArrayList<Produto> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;
        ResultSet rs = null;
        ArrayList<Produto> produto = new ArrayList();
        try {
            stnt = con.prepareStatement("Select * from produto");
            rs = stnt.executeQuery();
            while (rs.next()) {
                Produto pr = new Produto();
                pr.setId_produto(rs.getInt("codigo"));
                pr.setId_familia(rs.getInt("codigo_familia"));
                pr.setId_subfamilia(rs.getInt("codigo_subFamilia"));
                pr.setDescricao(rs.getString("descricao"));
                pr.setPreco_venda(rs.getFloat("preco_venda"));
                pr.setQuantidade(rs.getInt("quantidade"));
                pr.setValidade(rs.getString("validade"));
                pr.setIva(rs.getFloat("iva"));

                produto.add(pr);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stnt, rs);
        }
        return produto;
    }
        public int lastId(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stnt=null;
        ResultSet rs=null;
        
        int num = 0;
        ArrayList<Produto> func = readAll();
        
        for(int j = 0; j < func.size(); j++){
              if(j == (func.size() - 1))
                  num = func.get(j).getId_produto();
        }
        return num;
    }

    public Produto getProdutoById(int id) {
        ArrayList<Produto> produto = readAll();
        Produto p = new Produto();

        for (int i = 0; i < produto.size(); i++) {
            if (id == produto.get(i).getId_produto()) {
                p.setId_produto(produto.get(i).getId_produto());
                p.setId_familia(produto.get(i).getId_familia());
                p.setId_subfamilia(produto.get(i).getId_subfamilia());
                p.setDescricao(produto.get(i).getDescricao());
                p.setPreco_venda(produto.get(i).getPreco_venda());
                p.setValidade(produto.get(i).getValidade());
                p.setQuantidade(produto.get(i).getQuantidade());
                p.setIva(produto.get(i).getIva());

            }
        }
        return p;
    }

    public Produto getProdutoByDescricao(String descricao) {
        ArrayList<Produto> produto = readAll();
        Produto p = new Produto();

        for (int i = 0; i < produto.size(); i++) {
            if (descricao.equalsIgnoreCase(produto.get(i).getDescricao())) {
                p.setId_produto(produto.get(i).getId_produto());
                p.setId_familia(produto.get(i).getId_familia());
                p.setId_subfamilia(produto.get(i).getId_subfamilia());
                p.setDescricao(produto.get(i).getDescricao());
                p.setPreco_venda(produto.get(i).getPreco_venda());
                p.setValidade(produto.get(i).getValidade());
                p.setQuantidade(produto.get(i).getQuantidade());
                p.setIva(produto.get(i).getIva());
            }
        }
        return p;

    }

    public boolean deleteProdutoById(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        try {
            stnt = con.prepareStatement("delete from produto where codigo=?");
            stnt.setInt(1, id);
            stnt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }
    }

    public boolean verifyId(int id) {
        boolean status = false;
        ArrayList<Produto> produto = readAll();
        for (int i = 0; i < produto.size(); i++) {
            if (id == produto.get(i).getId_produto()) {
                status = true;
            }
        }
        return status;
    }
    

}
