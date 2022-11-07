/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.Model.value_object;

/**
 *
 * @author Manjate
 */
public class Caixa {

    float total;
    float valor_actual;

    public Caixa(float total,float valor_actual) {
        this.total=total;
        this.valor_actual = valor_actual;
    }
    public Caixa(){}

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getValor_actual() {
        return valor_actual;
    }

    public void setValor_actual(float valor_actual) {
        this.valor_actual = valor_actual;
    }



}
