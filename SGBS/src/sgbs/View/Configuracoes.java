/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ricardo
 */
public class Configuracoes  implements ActionListener {
    private JFrame frame;
    private JPanel global;
    private GridBagConstraints constraints = new GridBagConstraints();
    private sgbs.View.controles.MyButton.MyButtonSubmeter CadastrarFuncionario;
    private sgbs.View.controles.MyButton.MyButtonSubmeter CadastrarClente;
    private sgbs.View.controles.MyButton.MyButtonSubmeter CadastrarFamilia;
    private sgbs.View.controles.MyButton.MyButtonSubmeter CadastrarSubFamilia;
    private sgbs.View.controles.MyButton.MyButtonSubmeter sobre;
    private sgbs.View.controles.MyButton.MyButtonSubmeter versao;
    private javax.swing.JLabel jLabe1;
    private javax.swing.JLabel jLabe2;
    private javax.swing.JLabel jLabe3;
    private javax.swing.JLabel jLabe4;
    private javax.swing.JLabel jLabe5;
    private javax.swing.JLabel jLabe6;
    
    public Configuracoes() {
        inicialializarComponentes();
       // configurarFrame();
    }
    
    private void inicialializarComponentes() {
        frame = new JFrame();
        global = new JPanel();
        
        CadastrarFuncionario = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        CadastrarClente = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        CadastrarFamilia = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        CadastrarSubFamilia = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        sobre = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        versao = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        
        jLabe1 = new javax.swing.JLabel();
        jLabe2 = new javax.swing.JLabel();
        jLabe3 = new javax.swing.JLabel();
        jLabe4 = new javax.swing.JLabel();
        jLabe5 = new javax.swing.JLabel();
        jLabe6 = new javax.swing.JLabel();
        
        CadastrarClente.addActionListener(this);
        CadastrarFamilia.addActionListener(this);
        CadastrarFuncionario.addActionListener(this);
        CadastrarSubFamilia.addActionListener(this);
    }
    public JPanel retornaPainel(){
         global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);

        return global;
    }
    
     private void configurarFrame() {
       
        //frame.setResizable(false);
        //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
     
    private void addGB(JPanel panel, Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }
    private void personalizarComponent() {
        
        jLabe1.setFont(new java.awt.Font("sansserif", 1, 16)); 
        jLabe1.setForeground(new java.awt.Color(255, 255, 255));
        jLabe1.setText("     Cadastrar Funcionario");
        CadastrarFuncionario.setPreferredSize(new Dimension(200, 80));
        CadastrarFuncionario.setBackground(new java.awt.Color(0, 134, 190));
        CadastrarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarFuncionario.add(jLabe1);
        CadastrarFuncionario.setRadius(20);
        CadastrarFuncionario.setBorder(null);
        
        jLabe2.setFont(new java.awt.Font("sansserif", 1, 13)); 
        jLabe2.setForeground(new java.awt.Color(255, 255, 255));
        jLabe2.setText(" Cadastrar Cliente/Fornecedor");
        CadastrarClente.setPreferredSize(new Dimension(200, 80));
        CadastrarClente.setBackground(new java.awt.Color(0, 134, 190));
        CadastrarClente.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarClente.add(jLabe2);
        CadastrarClente.setRadius(20);
        CadastrarClente.setBorder(null);
        
        
        jLabe3.setFont(new java.awt.Font("sansserif", 1, 16)); 
        jLabe3.setForeground(new java.awt.Color(255, 255, 255));
        jLabe3.setText("         Cadastrar Familia");
        CadastrarFamilia.setPreferredSize(new Dimension(200, 80));
        CadastrarFamilia.setBackground(new java.awt.Color(0, 134, 190));
        CadastrarFamilia.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarFamilia.add(jLabe3);
        CadastrarFamilia.setRadius(20);
        CadastrarFamilia.setBorder(null);
        
        jLabe4.setFont(new java.awt.Font("sansserif", 1, 16)); 
        jLabe4.setForeground(new java.awt.Color(255, 255, 255));
        jLabe4.setText("     Cadastrar SubFamilia");
        CadastrarSubFamilia.setPreferredSize(new Dimension(200, 80));
        CadastrarSubFamilia.setBackground(new java.awt.Color(0, 134, 190));
        CadastrarSubFamilia.setForeground(new java.awt.Color(255, 255, 255));
        CadastrarSubFamilia.add(jLabe4);
        CadastrarSubFamilia.setRadius(20);
        CadastrarSubFamilia.setBorder(null);
        
        jLabe5.setFont(new java.awt.Font("sansserif", 1, 16)); 
        jLabe5.setForeground(new java.awt.Color(255, 255, 255));
        jLabe5.setText("                   Sobre");
        sobre.setPreferredSize(new Dimension(200, 80));
        sobre.setBackground(new java.awt.Color(0, 134, 190));
        sobre.setForeground(new java.awt.Color(255, 255, 255));
        sobre.add(jLabe5);
        sobre.setRadius(20);
        sobre.setBorder(null);
        
        jLabe6.setFont(new java.awt.Font("sansserif", 1, 16)); 
        jLabe6.setForeground(new java.awt.Color(255, 255, 255));
        jLabe6.setText("                   Versāo");
        versao.setPreferredSize(new Dimension(200, 80));
        versao.setBackground(new java.awt.Color(0, 134, 190));
        versao.setForeground(new java.awt.Color(255, 255, 255));
        versao.add(jLabe6);
        versao.setRadius(20);
        versao.setBorder(null);
        
        
    }
    
    private Component painelNorte(){
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new Dimension(0, 80));
        return panel;
    }
    
    private Component painelCentro(){
        personalizarComponent();
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(15, 15, 15, 15);
        
        addGB(panel, CadastrarFuncionario, 0, 0);
        addGB(panel, CadastrarClente, 1, 0);
        addGB(panel, CadastrarFamilia, 2, 0);
        
        addGB(panel, CadastrarSubFamilia, 0, 1);
        addGB(panel, sobre, 1, 1);
        addGB(panel, versao, 2, 1);
        
    return panel;
    }
    
    private Component painelSul(){
        JPanel panel = new JPanel();
//        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new Dimension(0, 80));
        return panel;
    }
    
    
    public static void main(String[] args) {
        new Configuracoes();
    }
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==CadastrarClente){
            new Terceiro();
        }else if(e.getSource()==CadastrarFamilia){
            new Familia();
        }else if(e.getSource()==CadastrarFuncionario){
          //  System.out.println("ola");
            new ViewFuncionario();
        }else if(e.getSource()==CadastrarSubFamilia){
            new SubFamilia();
        }
    }
}
