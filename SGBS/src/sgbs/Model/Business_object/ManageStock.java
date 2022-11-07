/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.StockDao;
import sgbs.Model.value_object.Stock;
import sgbs.Model.Data_access_object.ProdutoDao;
import sgbs.Model.value_object.Produto;
/**
 *
 * @author Manjate
 */
public class ManageStock {
    
    Stock st;
    StockDao stDAO;
    
    public boolean salvar(Stock stock){
        st=stock;
        String sql="insert into Stock values("+st.getCodigo()+","+st.getCodigo_produto()+","+st.getCodigo_fornecedor()+",'"
                +st.getDescricao()+"',"+st.getPreco_compra()+","+st.getQuantidade()+","+st.getTotal()+")";
        stDAO=new StockDao();
        boolean res=stDAO.create(sql);
        if(res){
            ProdutoDao prDAO;
            String sqlP="Update produto set quantidade=quantidade+"+st.getQuantidade()+" where codigo="+st.getCodigo_produto();
            prDAO=new ProdutoDao();
        
            boolean status= prDAO.create(sqlP);  
             if(status) System.out.println("quantidade Actualizado com sucesso na tabela Produto");
        }
        return res;
        
    }

    
}
