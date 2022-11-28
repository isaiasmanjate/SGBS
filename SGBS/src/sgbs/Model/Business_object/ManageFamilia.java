/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.FamiliaDao;
import sgbs.Model.value_object.Familia;

/**
 *
 * @author Manjate
 */
public class ManageFamilia {
    
     Familia fn;
    FamiliaDao fDAO;
    
    public boolean salvar(Familia familia){
        fn=familia;
        String sql="insert into Familia values("+fn.getCodigo()+",'"+fn.getNome()+"','"+fn.getDescricao()+"')";
        fDAO=new FamiliaDao();
        boolean res=fDAO.create(sql);
     
        return res;
    }
    
    
    
    
}
