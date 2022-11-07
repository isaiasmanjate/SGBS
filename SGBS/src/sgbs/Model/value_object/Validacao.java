/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.value_object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Manjate
 */
public class Validacao {
    private int inteiro;
    private float decimal;
    private String txt;
    private BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    
    public Validacao(){
        inteiro=0;
        decimal=0;
        txt=null;
    }
    
    public boolean valInt(int num, int ii, int ss){
        inteiro=num;
        if(inteiro<ii || inteiro>ss){
            return false;
        }else
            return true;
    }
    
    public boolean valFloat(float num, int ii, int ss){
        decimal=num;
        if(decimal<ii || decimal>ss){
            return false;
        }else
            return true;
    }
    
    public boolean valNuit(String num) {
        txt=num;
        if(txt.length()<13 || txt.length()>13){
            return false;
        }else
            return true;
    }
    
    
    public boolean valTxt(String tt, int ii, int ss){
        this.txt=tt;
        if(txt.length()<ii || txt.length()>ss){
            return false;
        }
        return true;
    }
}



