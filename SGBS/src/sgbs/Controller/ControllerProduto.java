/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageProduto;
import sgbs.Model.Data_access_object.ProdutoDao;
import sgbs.Model.value_object.Produto;
import sgbs.Model.Data_access_object.FamiliaDao;
import sgbs.Model.value_object.Familia;
import sgbs.Model.Data_access_object.SubFamiliaDao;
import sgbs.Model.value_object.SubFamilia;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerProduto {
 Validacao vd;
    Produto fn;
    
    int codigo,codigo_fam,codigo_subfam,qtd;
    String descricao,validade;
    float preco,iva;
    
    public int gerador(){
        ProdutoDao fdao=new ProdutoDao();
        int num=fdao.lastId()+1;
        return num;
    }
    
    public boolean cadastrar(int codigo,int codigo_fam,int codigo_subfam,String descricao,float preco,int qtd,String validade,float iva){
        boolean status=false;
        vd=new Validacao();
       if(vd.valTxt(descricao, 3, 50)&&
               vd.valInt(codigo_fam, 1, 1000)&&vd.valInt(codigo_subfam, 1, 10000)&&
               vd.valFloat(preco, 1, 1000000)){
            
            fn=new Produto(codigo, codigo_fam,codigo_subfam,descricao,preco,qtd,validade,iva);
            ManageProduto mF=new ManageProduto();
            mF.salvar(fn);
            status=true;
     
       }
        return status;
            
    }
    public boolean modificar(int codigo,int codigo_fam,int codigo_subfam,String descricao,float preco,int qtd,String validade,float iva){
       
        vd=new Validacao();
           boolean  status=false;
        if(vd.valTxt(descricao, 3, 50)&&vd.valInt(0, 0,0 )&&vd.valInt(codigo, 1, 1000)&&
               vd.valInt(codigo_fam, 1, 1000)&&vd.valInt(codigo_subfam, 1, 10000)&&
               vd.valFloat(preco, 1, 1000000)){
            fn=new Produto(codigo, codigo_fam,codigo_subfam,descricao,preco,qtd,validade,iva);
            ManageProduto mF=new ManageProduto();
            status=mF.alterar(fn);
            
       }
        return status;
            
    }
    public Vector listar(){
        ControllerFamilia f=new ControllerFamilia();
         ControllerSubFamilia sf=new ControllerSubFamilia();
         Familia familia;
         SubFamilia subFamilia;
         String nomeF="",nomeSF="";
        ProdutoDao fdao=new ProdutoDao();
        int i=0;
        Vector lst=new Vector();
        for(Produto fn:fdao.readAll()){
            familia=f.getFamById(fn.getId_familia());
            subFamilia=sf.getSubFamById(fn.getId_subfamilia());
            nomeF=familia.getNome();
            nomeSF=subFamilia.getSubFamilia_nome();
            
            lst.add(new Object[]{fn.getId_produto(),nomeF,nomeSF,fn.getDescricao(),fn.getPreco_venda(),fn.getQuantidade(),fn.getValidade(),fn.getIva()});
            i++;
        }
        return lst;
    }
    public Produto getFunById(int codigo){
         ProdutoDao fdao=new ProdutoDao();
         Produto f=fdao.getProdutoById(codigo);
         return f;
    }

    public boolean encontrar(int id){
        ManageProduto mF=new ManageProduto();
        Produto fn;
        if(mF.search(id)){
            fn=mF.getProduto();
            this.codigo=fn.getId_produto();
            
         
            return true;
        }
        else{
            return false;
        }
    }
    public boolean remover(int id){ 
        try{
            ProdutoDao fdao=new ProdutoDao();
            boolean scc=fdao.deleteProdutoById(id);
            if(scc){
                return true;
            } else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
                return false;
            }
      
    }

}
