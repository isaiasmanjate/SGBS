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
public class Pessoa implements Serializable{
    int codigo;
    String nome,contacto,morada;
    long nuit;

    public Pessoa(int codigo, String nome, String contacto, String morada, long nuit) {
        this.codigo = codigo;
        this.nome = nome;
        this.contacto = contacto;
        this.morada = morada;
        this.nuit = nuit;
    }
    public Pessoa(){
        
    }

    public long getNuit() {
        return nuit;
    }

    public void setNuit(long nuit) {
        this.nuit = nuit;
    }

    public Pessoa( int codigo,String nome, String morada, String contacto) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.contacto = contacto;
     
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
 
}
