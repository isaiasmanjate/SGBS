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
public class Funcionario extends Pessoa implements Serializable{
       String username,password;
       byte nivel;

    public Funcionario(int codigo, String nome, String contacto, String morada, long nuit,String username,String password,byte nivel) {
        super(codigo, nome, contacto, morada, nuit);
        this.username=username;
        this.password=password;
        this.nivel=nivel;
    }
    public Funcionario(){
        
    }

    public long getNuit() {
        return nuit;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public void setNuit(long nuit) {
        this.nuit = nuit;
    }
 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
