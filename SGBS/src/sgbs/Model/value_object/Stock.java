/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.value_object;

import java.io.Serializable;

/**
 *
 * @author Manjate
 */
public class Stock implements Serializable {

    int codigo,codigo_produto;
     int codigo_fornecedor;

    String Descricao;
    float preco_compra;
    int quantidade;
    float total;

    public Stock(int codigo,int codigo_produto, int codigo_fornecedor, String Descricao, float preco_compra, int quantidade, float total) {
        this.codigo = codigo;
        this.codigo_produto=codigo_produto;
        this.codigo_fornecedor = codigo_fornecedor;
        this.Descricao = Descricao;
        this.preco_compra = preco_compra;
        this.quantidade = quantidade;
        this.total = total;
    }
    public Stock(){
        
    }

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public int getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(int codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

  

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

 

    public float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
