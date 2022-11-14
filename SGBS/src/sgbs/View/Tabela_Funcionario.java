/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import sgbs.Controller.ControllerFuncionario;
import sgbs.Model.value_object.Funcionario;
import sgbs.Model.value_object.Pessoa;

/**
 *
 * @author Manjate
 */
public class Tabela_Funcionario implements ActionListener{
    private JFrame frame;
    private JPanel global;
    private JTable tabela;
    private JLabel l_pesquisar;
    JScrollPane scrollClient;
    DefaultTableModel fn;
      Vector fun;
      
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_pesquisar;
    sgbs.View.controles.MyButton.MyButtonSubmeter b_selecionar,b_pesquisar;
    
    public Tabela_Funcionario() {
        inicializarComponentes();
        configurarFrame(); 
        }
    
     private void inicializarComponentes(){
        frame = new JFrame("Lista Funcionario");
        frame.setResizable(false);
        
        //Inicializar Pineis
        global = new JPanel();
        
        //init botao
        l_pesquisar = new JLabel();
        tf_pesquisar = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        b_selecionar=new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_selecionar.setText("Selecionar");
        b_selecionar.setPreferredSize(new Dimension(100, 25));
        b_selecionar.setBackground(new java.awt.Color(0, 134, 190));
        b_selecionar.setForeground(new java.awt.Color(255, 255, 255));
        b_selecionar.setRadius(20);
        b_selecionar.setBorder(null);
        
        b_pesquisar=new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_pesquisar.setText("");
        b_pesquisar.setPreferredSize(new Dimension(30, 28));
        b_pesquisar.setBackground(new java.awt.Color(0, 134, 190));
        b_pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        b_pesquisar.setRadius(20);
        b_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/search.png")));
        b_pesquisar.setBorder(null);
        
        //Inicializar tabelas
        fn=new DefaultTableModel();
        fn.addColumn("Codigo");
        fn.addColumn("Nome");
        fn.addColumn("Contacto");
        fn.addColumn("Morada");
        fn.addColumn("Nuit");
        fn.addColumn("Username");
        fn.addColumn("Password");
        fn.addColumn("Nivel");
        
        
    
        ControllerFuncionario ctrl=new ControllerFuncionario();
        b_selecionar.addActionListener(this);
        b_pesquisar.addActionListener(this);
       
         //
  
       tabela = new JTable(fn);
       scrollClient=new JScrollPane(tabela);
        readFuncionario();
        configurar_tabelas(); 
 
    }
     
    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(configurar_TabelaCliente(), BorderLayout.CENTER);
        global.add(painelSul(),BorderLayout.SOUTH);
        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);
   
        frame.setVisible(true);
    }
    
    private void personalizarComponent() {
        //Descricao
        l_pesquisar.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_pesquisar.setForeground(new java.awt.Color(0, 0, 0));
        l_pesquisar.setText("Pesquisar");
        tf_pesquisar.setForeground(new java.awt.Color(0, 0, 0));
        tf_pesquisar.setPreferredSize(new Dimension(150, 35));
    }
      public void readFuncionario(){ 
        ControllerFuncionario ctrl =new ControllerFuncionario();
         fun=ctrl.listar();
        for(int i=0;i<fun.size();i++)
            fn.addRow((Object[]) fun.elementAt(i));
        
    }
    
    private Component painelNorte() {
        personalizarComponent();

        JPanel principal = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
//        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        panelB.add(l_pesquisar);
        panelB.add(tf_pesquisar);
        panelB.add(b_pesquisar);

        principal.add(panelB, BorderLayout.CENTER);

        return principal;
    }
    private Component painelSul() {
        personalizarComponent();

        JPanel principal = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
//        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
       // panelB.add(l_pesquisar);
        panelB.add(b_selecionar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }
    
    private void configurar_tabelas() {
        tabela.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabela.setFillsViewportHeight(true);
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0,0,0));
        tabela.setRowHeight(20);
    }
    
    public Component configurar_TabelaCliente() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(750, 340));
        
        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        lista.add(scrollPane);
        
        return lista;
    }
    
    public static void main(String[] args) {
        new Tabela_Funcionario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_selecionar){
            int index=  tabela.getSelectedRow();
            ViewFuncionario funcionario=new ViewFuncionario();
            ControllerFuncionario ctrl=new ControllerFuncionario();
             Funcionario f=ctrl.getFunById(index+1);
             funcionario.tf_codigo.setText(f.getCodigo()+"");
             funcionario.tf_contacto.setText(f.getContacto());
             funcionario.tf_nome.setText(f.getNome());
             funcionario.tf_morada.setText(f.getMorada());
             funcionario.tf_password.setText(f.getPassword());
             funcionario.tf_username.setText(f.getUsername());
             funcionario.tf_nuit.setText(f.getNuit()+"");
             if(f.getNivel().equalsIgnoreCase("0"))
               funcionario.c_terceiro.setSelectedIndex(1);
             else
                funcionario.c_terceiro.setSelectedIndex(2);
             funcionario.b_gravar.setText("Editar");
             
             
             frame.dispose();
            
            
            
      
        }
         if(e.getSource()==b_pesquisar){
            int id=Integer.parseInt(tf_pesquisar.getText());
            boolean scc;
          
                ControllerFuncionario ctr=new ControllerFuncionario();
                scc= ctr.encontrar(id);
                if(scc){
                    tabela.setRowSelectionInterval(id-1, id-1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Funcionário não Encontrado!");
               
         }
        }
    }
    

}
