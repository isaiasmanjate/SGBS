/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageCliente;
import sgbs.Model.Business_object.ManageFamilia;
import sgbs.Model.Business_object.ManageFuncionario;
import sgbs.Model.Data_access_object.ClienteDao;
import sgbs.Model.Data_access_object.FamiliaDao;
import sgbs.Model.value_object.Cliente;
import sgbs.Model.value_object.Familia;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerFamilia {
    Validacao vd;
    
    int codigo;
    String nome , descricao;
    Familia fm;
    
    
    public int gerador() {
        FamiliaDao fdao = new FamiliaDao();
        int num = fdao.lastId() + 1;
        return num;
    }

    public boolean cadastrar(int codigo, String nome, String descricao) {
        boolean status = false;
        vd = new Validacao();
  
        if (vd.valTxt(nome, 3, 500) && vd.valTxt(descricao, 3, 100) ) {

            fm = new Familia(codigo, nome,descricao);
            ManageFamilia mF = new ManageFamilia();
            mF.salvar(fm);
            status = true;

        }
        return status;

    }
    
    public Vector listar() {
        FamiliaDao fdao = new FamiliaDao();
        int i = 0;
        Vector lst = new Vector();
        for (Familia fn : fdao.readAll()) {
            lst.add(new Object[]{fn.getCodigo(), fn.getNome(), fn.getDescricao()});
            i++;
        }
        return lst;
    }

    public Familia getFamById(int codigo) {
        FamiliaDao fdao = new FamiliaDao();
        Familia f = fdao.getFamiliaById(codigo);
        return f;
    }

}
