/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.value_object;

/**
 *
 * @author Manjate
 */
public class Logs {
    int codigo,codigo_funcionario;String descricao,data;

    public Logs(int codigo,int codigo_funcionario, String descricao, String data) {
        this.codigo=codigo;
        this.codigo_funcionario = codigo_funcionario;
        this.descricao = descricao;
        this.data = data;
    }
    public Logs(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    

    public int getCodigo_funcionario() {
        return codigo_funcionario;
    }

    public void setCodigo_funcionario(int codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
