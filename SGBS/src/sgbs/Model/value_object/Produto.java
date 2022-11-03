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
public class Produto implements Serializable{
   int id_produto,id_familia,id_subfamilia;
   String descricao;
   float preco_venda;
   int quantidade;
   String validade;
   float iva;

    public Produto( int id_produto,int id_familia,int id_subfamilia,String descricao, float preco_venda, int quantidade,String validade,float iva) {
        this.id_produto = id_produto;
        this.id_familia=id_familia;
        this.id_subfamilia=id_subfamilia;
        this.descricao = descricao;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
        this.validade=validade;
        this.iva=iva;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public int getId_subfamilia() {
        return id_subfamilia;
    }

    public void setId_subfamilia(int id_subfamilia) {
        this.id_subfamilia = id_subfamilia;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
   
}
