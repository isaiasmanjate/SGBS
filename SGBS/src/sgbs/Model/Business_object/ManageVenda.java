/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.VendaDao;
import sgbs.Model.Data_access_object.StockDao;
import sgbs.Model.value_object.Venda;


/**
 *
 * @author Manjate
 */
public class ManageVenda {
    StockDao stDAO;
    VendaDao vDAO;
    Venda vd;
    
    
    public boolean salvar(Venda venda){
        vd=venda;
        String sql="insert into Venda values("+vd.getId_venda()+","+vd.getId_produto()+","+vd.getId_cliente()+","+vd.getId_funcionario()+",'"
                +vd.getDescricao()+"',"+vd.getQtd()+","+vd.getPreco()+",'"+vd.getData()+"',"+vd.getTotal()+")";
        vDAO=new VendaDao();
        boolean res=vDAO.create(sql);
        if(res){
       
            String sqlS="Update Stock set quantidade=quantidade-"+vd.getQtd()+",total=total-"+vd.getQtd()+"*preco_compra  where codigo_produto="+vd.getId_produto();
            stDAO=new StockDao();
             boolean status=  stDAO.create(sqlS);  
             if(status) System.out.println("quantidade Actualizado com sucesso na tabela Stock");
           
        }
        return res;
    }
 
}
