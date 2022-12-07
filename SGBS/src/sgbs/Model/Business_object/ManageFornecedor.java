/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.FornecedorDao;
import sgbs.Model.value_object.Fornecedor;

/**
 *
 * @author Manjate
 */
public class ManageFornecedor {
     Fornecedor cl;
    FornecedorDao cDAO;
    
    public boolean salvar(Fornecedor cliente){
        cl=cliente;
        String sql="insert into Fornecedor values("+cl.getCodigo()+",'"+cl.getNome()+"','"+cl.getContacto()+"','"+cl.getMorada()+"',"+cl.getNuit()+")";
        cDAO=new FornecedorDao();
        boolean res=cDAO.create(sql);
     
        return res;
    }
    
    public boolean alterar(Fornecedor cliente){
        cl=cliente;
        String sql="Update Fornecedor set nome='"+cl.getNome()+"',contacto='"+cl.getNome()+"',morada='"+cl.getMorada()+"',nuit="+cl.getNuit();
        cDAO=new FornecedorDao();
        boolean res=cDAO.create(sql);
        
        return res;
    }
    
    public boolean search(int id){
        cDAO=new FornecedorDao();
        boolean resp=cDAO.verifyId(id);
        if(resp){
            cl=cDAO.getFornecedorById(id);
            return true;
        }
        else
            return false;
    }

    public Fornecedor getCliente() {
        return cl;
    }
    
}
