/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageCliente;
import sgbs.Model.Data_access_object.ClienteDao;
import sgbs.Model.value_object.Cliente;
import sgbs.Model.value_object.Funcionario;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerCliente {

    Validacao vd;

    public Validacao getVd() {
        return vd;
    }

    public void setVd(Validacao vd) {
        this.vd = vd;
    }

    public Cliente getFn() {
        return fn;
    }

    public void setFn(Cliente fn) {
        this.fn = fn;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public long getNuit() {
        return nuit;
    }

    public void setNuit(long nuit) {
        this.nuit = nuit;
    }
    Cliente fn;

    int codigo;
    String nome, contacto, morada;
    long nuit;

    public int gerador() {
        ClienteDao fdao = new ClienteDao();
        int num = fdao.lastId() + 1;
        return num;
    }

    public boolean cadastrar(int codigo, String nome, String contacto, String morada, long nuit) {
        boolean status = false;
        vd = new Validacao();
        System.out.println("ola");
        if (vd.valTxt(nome, 3, 50) && vd.valTxt(contacto, 9, 9) && vd.valTxt(morada, 3, 45)
                && vd.valNuit(nuit + "")) {

            fn = new Cliente(codigo, nome, contacto, morada, nuit);
            ManageCliente mF = new ManageCliente();
            mF.salvar(fn);
            status = true;

        }
        return status;

    }

    public boolean modificar(int codigo, String nome, String contacto, String morada, long nuit) {

        vd = new Validacao();
        boolean status = false;
        // if(vd.valTxt(password, 3,20)){
        fn = new Cliente(codigo, nome, contacto, morada, nuit);
        ManageCliente mF = new ManageCliente();
        status = mF.alterar(fn);
        //  }
        return status;

    }

    public Vector listar() {
        ClienteDao fdao = new ClienteDao();
        int i = 0;
        Vector lst = new Vector();
        for (Cliente fn : fdao.readAll()) {
            lst.add(new Object[]{fn.getCodigo(), fn.getNome(), fn.getContacto(), fn.getMorada(), fn.getNuit()});
            i++;
        }
        return lst;
    }

    public Cliente getFunById(int codigo) {
        ClienteDao fdao = new ClienteDao();
        Cliente f = fdao.getClienteById(codigo);
        return f;
    }


    public boolean encontrar(int id) {
        ManageCliente mF = new ManageCliente();
        Cliente fn;
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
            ClienteDao fdao = new ClienteDao();
            boolean scc = fdao.deleteClienteById(id);
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
