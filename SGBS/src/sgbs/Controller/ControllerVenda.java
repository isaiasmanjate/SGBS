/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import sgbs.Model.Business_object.ManageVenda;
import sgbs.Model.Data_access_object.VendaDao;
import sgbs.Model.value_object.Venda;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerVenda {
     
    Validacao vd;
    Venda v;
    
    public int gerador(){
        VendaDao fdao=new VendaDao();
        int num=fdao.lastId()+1;
        return num;
    }
    
    public boolean cadastrar(int codigo,int codigo_pro,int codigo_cli,int codigo_fun,String descricao,int qtd,float preco,String validade,float total){
        boolean status=false;
        vd=new Validacao();
       if(vd.valTxt(descricao, 3, 50)&&vd.valInt(0, 0,0 )&&vd.valInt(codigo, 1, 1000)&&
               vd.valInt(codigo_cli, 1, 1000)&&vd.valInt(codigo_fun, 1, 10000)&&
               vd.valFloat(preco, 1, 1000000)){
            
            v=new Venda(codigo, codigo_pro,codigo_cli,codigo_fun,descricao,qtd,preco,validade,total);
            ManageVenda mF=new ManageVenda();
            mF.salvar(v);
            status=true;
     
       }
        return status;
            
    }

    public Vector listar(){
        VendaDao fdao=new VendaDao();
        int i=0;
        Vector lst=new Vector();
        for(Venda fn:fdao.readAll()){
            lst.add(new Object[]{fn.getId_venda(),fn.getId_produto(),fn.getId_cliente(),fn.getId_funcionario(),fn.getDescricao(),fn.getQtd(),fn.getPreco(),fn.getData(),fn.getTotal()});
            i++;
        }
        return lst;
    }
    
}
