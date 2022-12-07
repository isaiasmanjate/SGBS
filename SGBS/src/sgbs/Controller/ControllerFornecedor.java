/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageFornecedor;
import sgbs.Model.Data_access_object.FornecedorDao;
import sgbs.Model.value_object.Fornecedor;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerFornecedor {
     Fornecedor fn;
     Validacao vd;
    int codigo;
    String nome, contacto, morada;
    long nuit;

    public int gerador() {
        FornecedorDao fdao = new FornecedorDao();
        int num = fdao.lastId() + 1;
        return num;
    }

    public boolean cadastrar(int codigo, String nome, String contacto, String morada, long nuit) {
        boolean status = false;
        vd = new Validacao();
     //   System.out.println("ola");
        if (vd.valTxt(nome, 3, 50) && vd.valTxt(contacto, 9, 9) && vd.valTxt(morada, 3, 45)
                && vd.valNuit(nuit + "")) {

            fn = new Fornecedor(codigo, nome, contacto, morada, nuit);
            ManageFornecedor mF = new ManageFornecedor();
            mF.salvar(fn);
            status = true;

        }
        return status;

    }

    public boolean modificar(int codigo, String nome, String contacto, String morada, long nuit) {

        vd = new Validacao();
        boolean status = false;
        // if(vd.valTxt(password, 3,20)){
        fn = new Fornecedor(codigo, nome, contacto, morada, nuit);
        ManageFornecedor mF = new ManageFornecedor();
        status = mF.alterar(fn);
        //  }
        return status;

    }

    public Vector listar() {
        FornecedorDao fdao = new FornecedorDao();
        int i = 0;
        Vector lst = new Vector();
        for (Fornecedor fn : fdao.readAll()) {
            lst.add(new Object[]{fn.getCodigo(), fn.getNome(), fn.getContacto(), fn.getMorada(), fn.getNuit()});
            i++;
        }
        return lst;
    }

    public Fornecedor getFunById(int codigo) {
        FornecedorDao fdao = new FornecedorDao();
        Fornecedor f = fdao.getFornecedorById(codigo);
        return f;
    }


    public boolean encontrar(int id) {
        ManageFornecedor mF = new ManageFornecedor();
        Fornecedor fn;
        if (mF.search(id)) {
            fn = mF.getCliente();
            this.codigo = fn.getCodigo();
            this.nome = fn.getNome();

            return true;
        } else {
            return false;
        }
    }

    public boolean remover(int id) {
        try {
            FornecedorDao fdao = new FornecedorDao();
            boolean scc = fdao.deleteFornecedorById(id);
            if (scc) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }
}
