/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Controller;

import java.util.Vector;
import javax.swing.JOptionPane;
import sgbs.Model.Business_object.ManageFuncionario;
import sgbs.Model.Data_access_object.FuncionarioDao;
import sgbs.Model.value_object.Funcionario;
import sgbs.Model.value_object.Validacao;

/**
 *
 * @author Manjate
 */
public class ControllerProduto {
       public int gerador(){
        FuncionarioDao fdao=new FuncionarioDao();
        int num=fdao.lastId()+1;
        return num;
    }
    
//    public boolean cadastrar(int codigo,String nome,String contacto,String morada,long nuit,String username,String password,String nivel){
//        boolean status=false;
//        vd=new Validacao();
//        System.out.println("ola");
//       if(vd.valTxt(nome, 3, 50)&&vd.valTxt(contacto, 9, 9)&&vd.valTxt(morada, 3, 45)&&
//               vd.valNuit(nuit+"")&&vd.valTxt(username, 3, 20)&&vd.valTxt(password, 3, 20)){
//            
//            fn=new Funcionario(codigo, nome, contacto,morada,nuit,username,password,nivel);
//            ManageFuncionario mF=new ManageFuncionario();
//            mF.salvar(fn);
//            status=true;
//     
//       }
//        return status;
//            
//    }
//    public boolean modificar(int codigo,String nome,String contacto,String morada,long nuit,String username,String password,String nivel){
//       
//        vd=new Validacao();
//           boolean  status=false;
//       // if(vd.valTxt(password, 3,20)){
//            fn=new Funcionario(codigo, nome, contacto,morada,nuit,username,password,nivel);
//            ManageFuncionario mF=new ManageFuncionario();
//            status=mF.alterar(fn);
//      //  }
//        return status;
//            
//    }
//    public Vector listar(){
//        FuncionarioDao fdao=new FuncionarioDao();
//        int i=0;
//        Vector lst=new Vector();
//        for(Funcionario fn:fdao.readAll()){
//            lst.add(new Object[]{fn.getCodigo(),fn.getNome(),fn.getContacto(),fn.getMorada(),fn.getNuit(),fn.getUsername(),fn.getPassword(),fn.getNivel()});
//            i++;
//        }
//        return lst;
//    }
//    public Funcionario getFunById(int codigo){
//         FuncionarioDao fdao=new FuncionarioDao();
//         Funcionario f=fdao.getFuncionarioById(codigo);
//         return f;
//    }
//    public boolean login(String username,String password){
//        FuncionarioDao fdao=new FuncionarioDao();
//        boolean status;
//        status=fdao.login(username, password);
//        return status;
//    }
//    public boolean encontrar(int id){
//        ManageFuncionario mF=new ManageFuncionario();
//        Funcionario fn;
//        if(mF.search(id)){
//            fn=mF.getFuncionario();
//            this.codigo=fn.getCodigo();
//            this.nome=fn.getNome();
//         
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    public boolean remover(int id){ 
//        try{
//            FuncionarioDao fdao=new FuncionarioDao();
//            boolean scc=fdao.deleteFuncionarioById(id);
//            if(scc){
//                return true;
//            } else{
//                    return false;
//                }
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Erro: "+e);
//                return false;
//            }
//      
//    }
}
