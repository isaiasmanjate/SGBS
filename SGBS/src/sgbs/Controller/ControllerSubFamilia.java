/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import sgbs.Model.Business_object.ManageSubFamilia;
import sgbs.Model.Data_access_object.SubFamiliaDao;
import sgbs.Model.value_object.SubFamilia;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerSubFamilia {
     Validacao vd;
    
    int codigo;
    String nome , descricao;
    SubFamilia fm;
    
    
    public int gerador() {
        SubFamiliaDao fdao = new SubFamiliaDao();
        int num = fdao.lastId() + 1;
        return num;
    }

    public boolean cadastrar(int codigo, String nome, String descricao,int codigoFam) {
        boolean status = false;
        vd = new Validacao();
  
        if (vd.valTxt(nome, 2, 50) && vd.valTxt(descricao, 2, 50) ) {

            fm = new SubFamilia(codigo, nome,descricao,codigoFam);
            ManageSubFamilia mF = new ManageSubFamilia();
            mF.salvar(fm);
            status = true;

        }
        return status;

    }
    
    public Vector listar() {
        SubFamiliaDao fdao = new SubFamiliaDao();
        int i = 0;
        Vector lst = new Vector();
        for (SubFamilia fn : fdao.readAll()) {
            lst.add(new Object[]{fn.getCodigo_subfamilia(), fn.getSubFamilia_nome(), fn.getSubfamilia_descricao(),fn.getCodigo()});
            i++;
        }
        return lst;
    }

    public SubFamilia getSubFamById(int codigo) {
        SubFamiliaDao fdao = new SubFamiliaDao();
        SubFamilia f = fdao.getSubFamiliaById(codigo);
        return f;
    }
}
