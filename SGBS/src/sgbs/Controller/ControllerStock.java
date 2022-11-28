/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageStock;
import sgbs.Model.Data_access_object.StockDao;
import sgbs.Model.value_object.Stock;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerStock {
    Validacao vd;
    Stock fn;
    
    int codigo,codigo_for,codigo_prod,qtd;
    String descricao;
    float preco,total;
    
    public int gerador(){
        StockDao fdao=new StockDao();
        int num=fdao.lastId()+1;
        return num;
    }
    
    public boolean cadastrar(int codigo,int codigo_prod,int codigo_for,String descricao,float preco,int qtd,float total){
        
        boolean status=false;
        vd=new Validacao();
        
       if(vd.valTxt(descricao, 3, 50)&&vd.valInt(0, 0,0 )&&vd.valInt(codigo, 1, 1000)&&
               vd.valInt(codigo_for, 1, 1000)&&vd.valInt(codigo_prod, 1, 10000)&&
               vd.valFloat(preco, 1, 1000000)){
            
            fn=new Stock(codigo, codigo_prod,codigo_for,descricao,preco,qtd,total);
            ManageStock mF=new ManageStock();
            mF.salvar(fn);
            status=true;
     
       }
        return status;
            
    }

    public Vector listar(){
        StockDao fdao=new StockDao();
        int i=0;
        Vector lst=new Vector();
        for(Stock fn:fdao.readAll()){
            lst.add(new Object[]{fn.getCodigo(),fn.getCodigo_produto(),fn.getCodigo_fornecedor(),fn.getDescricao(),fn.getPreco_compra(),fn.getQuantidade(),fn.getQuantidade(),fn.getTotal()});
            i++;
        }
        return lst;
    }
   
    
    
}
