/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.ClienteDao;
import sgbs.Model.Data_access_object.FuncionarioDao;
import sgbs.Model.value_object.Funcionario;

/**
 *
 * @author Manjate
 */
public class ManageFuncionario {


     Funcionario fn;
    FuncionarioDao fDAO;
    
    public boolean salvar(Funcionario funcionario){
        fn=funcionario;
        String sql="insert into Funcionario values("+fn.getCodigo()+",'"+fn.getNome()+"','"+fn.getContacto()+"','"+fn.getMorada()+"',"+fn.getNuit()+",'"+fn.getUsername()+"','"+fn.getPassword()+"','"+fn.getNivel()+"')";
        fDAO=new FuncionarioDao();
        boolean res=fDAO.create(sql);
     
        return res;
    }
    
    public boolean alterar(Funcionario fn){
        
        String sql="Update Funcionario set nome='"+fn.getNome()+"',contacto='"+fn.getContacto()+"',morada='"+fn.getMorada()+"',nuit="+fn.getNuit()+",username='"+fn.getUsername()+"',password='"+fn.getPassword()+"',nivel='"+fn.getNivel()+"' where codigo="+fn.getCodigo();
        fDAO=new FuncionarioDao();
        boolean res=fDAO.create(sql);
        
        return res;
    }
    
    public boolean search(int id){
        fDAO=new FuncionarioDao();
        boolean resp=fDAO.verifyId(id);
        if(resp){
            fn=fDAO.getFuncionarioById(id);
            return true;
        }
        else
            return false;
    }

    public Funcionario getFuncionario() {
        return fn;
    }
    
    
}


