/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.ProdutoDao;
import sgbs.Model.value_object.Produto;

/**
 *
 * @author Manjate
 */
public class ManageProduto {
      Produto pr;
    ProdutoDao pDAO;
    
    public boolean salvar(Produto produto){
        pr=produto;
        String sql="insert into Produto values("+pr.getId_produto()+","+pr.getId_familia()+","+pr.getId_subfamilia()+",'"+pr.getDescricao()+"',"+pr.getPreco_venda()+","+pr.getQuantidade()+","+pr.getValidade()+","+pr.getIva()+")";
        pDAO=new ProdutoDao();
        boolean res=pDAO.create(sql);
        return res;
    }
    
    public boolean alterar(Produto produto){
        pr=produto;
        String sql="Update Produto set codigo_produto="+pr.getId_produto()+",codigo_familia="+pr.getId_familia()+",codigo_subfamilia ="+pr.getId_subfamilia()+",descricao="+pr.getDescricao()
                +",preco_venda="+pr.getPreco_venda()+",quantidade="+pr.getQuantidade()+", validade= "+pr.getQuantidade()+", iva="+pr.getIva();
        pDAO=new ProdutoDao();
        boolean res=pDAO.create(sql);
        return res;
    }
    
    public boolean search(int id){
        pDAO=new ProdutoDao();
        boolean resp=pDAO.verifyId(id);
        if(resp){
            pr=pDAO.getProdutoById(id);
            return true;
        }
        else
            return false;
    }

    public Produto getProduto() {
        return pr;
    }
}
