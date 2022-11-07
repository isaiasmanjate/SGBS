/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.value_object;

/**
 *
 * @author Manjate
 */
public class SubFamilia extends Familia {
       int codigo_subfamilia;
       String SubFamilia_nome;
       String subFamilia_descricao;
       
    public SubFamilia(int codigo, String familia,String descricao,int codigo_subfamilia,String SubFamilia_nome,String subFamilia_descricao) {
        super(codigo, familia, descricao);
        this.codigo_subfamilia=codigo_subfamilia;
        this.subFamilia_descricao=subFamilia_descricao;
    }

    public int getCodigo_subfamilia() {
        return codigo_subfamilia;
    }

    public void setCodigo_subfamilia(int codigo_subfamilia) {
        this.codigo_subfamilia = codigo_subfamilia;
    }

    public String getSubfamilia_descricao() {
        return subFamilia_descricao;
    }

    public void setSubfamilia_descricao(String subfamilia_descricao) {
        this.subFamilia_descricao=subfamilia_descricao;
    }

     
    public SubFamilia(){
    
    }

    public String getSubFamilia_nome() {
        return SubFamilia_nome;
    }

    public void setSubFamilia_nome(String SubFamilia_nome) {
        this.SubFamilia_nome = SubFamilia_nome;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    



   

  
    
    
    
}
