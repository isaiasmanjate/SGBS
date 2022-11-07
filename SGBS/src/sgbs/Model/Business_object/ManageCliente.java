/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

/**
 *
 * @author Manjate
 */
import sgbs.Model.Data_access_object.ClienteDao;
import sgbs.Model.value_object.Cliente;

public class ManageCliente {
     Cliente cl;
    ClienteDao cDAO;
    
    public boolean salvar(Cliente cliente){
        cl=cliente;
        String sql="insert into Cliente values("+cl.getCodigo()+",'"+cl.getNome()+"','"+cl.getContacto()+"','"+cl.getMorada()+"',"+cl.getNuit()+")";
        cDAO=new ClienteDao();
        boolean res=cDAO.create(sql);
     
        return res;
    }
    
    public boolean alterar(Cliente cliente){
        cl=cliente;
        String sql="Update cliente set nome='"+cl.getNome()+"',contacto='"+cl.getNome()+"',morada='"+cl.getMorada()+"',nuit="+cl.getNuit();
        cDAO=new ClienteDao();
        boolean res=cDAO.create(sql);
        
        return res;
    }
    
    public boolean search(int id){
        cDAO=new ClienteDao();
        boolean resp=cDAO.verifyId(id);
        if(resp){
            cl=cDAO.getClienteById(id);
            return true;
        }
        else
            return false;
    }

    public Cliente getCliente() {
        return cl;
    }
    
    
}
