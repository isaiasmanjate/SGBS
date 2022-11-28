/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.Business_object;

import sgbs.Model.Data_access_object.SubFamiliaDao;
import sgbs.Model.value_object.SubFamilia;

/**
 *
 * @author Manjate
 */
public class ManageSubFamilia {
     SubFamilia fn;
    SubFamiliaDao fDAO;
    
    public boolean salvar(SubFamilia familia){
        fn=familia;
        String sql="insert into subfamilia values("+fn.getCodigo_subfamilia()+",'"+fn.getSubFamilia_nome()+"','"+fn.getSubFamilia_descricao()+"',"+fn.getCodigo()+")";
        fDAO=new SubFamiliaDao();
        boolean res=fDAO.create(sql);
     
        return res;
    }
    
    
}
