/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import sgbs.Controller.ControllerFuncionario;

/**
 *
 * @author Manjate
 */
public class ViewFuncionario  implements ActionListener{
      JFrame frame;
    JPanel global;

    GridBagConstraints constraints = new GridBagConstraints();
    sgbs.View.controles.combobox.Combobox c_terceiro;
    sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_morada, tf_contacto, tf_nuit, tf_codigo, tf_nome,tf_username,tf_password;
    JLabel l_terceiro, l_morada, l_contacto, l_nuit, l_codigo, l_icon, l_titulo_frame, l_nome,l_username,l_password;
    sgbs.View.controles.MyButton.MyButtonSubmeter b_cancelar, b_lista, b_terminar, b_gravar, b_apagar;
    String s_terceiro[] = {" ", "0", "1"};

    public ViewFuncionario() {
        inicialializarComponentes();
        configurarFrame();
    }
     

    private void inicialializarComponentes() {
        frame = new JFrame("Cadastro do terceiro");

        //Inicializar ComboBox
        c_terceiro = new sgbs.View.controles.combobox.Combobox();
        c_terceiro.setSelectedIndex(-1);
        c_terceiro.setModel(new javax.swing.DefaultComboBoxModel(s_terceiro));
        c_terceiro.setLabeText("Nivel");

        //Inicializar text field
        tf_morada = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_contacto = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_nuit = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_codigo = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_nome = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_username = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_password = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();

        //Inicializar Labels
        l_codigo = new JLabel("Codigo");
        l_contacto = new JLabel("Contacto");
        l_morada = new JLabel("Morada");
        l_nuit = new JLabel("Nuit");
        l_icon = new JLabel();
        l_titulo_frame = new JLabel();
        l_password = new JLabel("Password");
        l_username = new JLabel("Username");
        l_nome = new JLabel("Nome");

        //Inicializar Botoes
        b_cancelar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_lista = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_terminar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_gravar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_apagar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        //b_lista.setBorder(new RoundedBorder(20));

        
        //Eventos
        b_gravar.addActionListener(this);
        b_cancelar.addActionListener(this);
        c_terceiro.addActionListener(this);
        b_lista.addActionListener(this);
        b_apagar.addActionListener(this);
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
         global=retornaPainel();
        frame.add(global);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
       // frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ViewFuncionario();
    }

    private Component painelNorte() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        l_icon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/add_User.png")));
        l_icon.setText(" ");
        l_titulo_frame.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_titulo_frame.setText("Cadastrar Funcionario");
        l_titulo_frame.setForeground(new java.awt.Color(0, 134, 190));
        // l_titulo_frame.setBackground(Color.blue);
        panel.add(l_icon);
        panel.add(l_titulo_frame);

        return panel;
    }

    private void addGB(JPanel panel, Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }

    private Component painelCentro() {
        personalizarComponent();

        JPanel principal = new JPanel();
        JPanel panel = new JPanel();
        principal.setLayout(new BorderLayout());

        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        panel.setLayout(new GridBagLayout());
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(2, 2, 0, 10);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;

        addGB(panel, c_terceiro, 0, 1);
        addGB(panel, l_codigo, 0, 2);
        addGB(panel, tf_codigo, 0, 3);
        addGB(panel, l_contacto, 2, 0);
        addGB(panel, tf_contacto, 2, 1);
        addGB(panel, l_nome, 3, 0);
        addGB(panel, tf_nome, 3, 1);
        addGB(panel, b_lista, 1, 1);
        addGB(panel, l_morada, 3, 2);
        addGB(panel, tf_morada, 3, 3);
        addGB(panel, l_nuit, 2, 2);
        addGB(panel, tf_nuit, 2, 3);
        
        addGB(panel, l_username, 2, 4);
        addGB(panel, tf_username, 2, 5);
        addGB(panel, l_password, 3, 4);
        addGB(panel, tf_password, 3, 5);
        
        addGB(panel, new JLabel(" "), 0,6);

        principal.add(panel, BorderLayout.NORTH);
        return principal;
    }

    private Component painelSul() {
        personalizarComponent();
        constraints.insets = new Insets(2, 10, 2, 10);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;

        JPanel principal = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());

        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelA.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        panelA.setLayout(new BorderLayout());
        panelA.setPreferredSize(new Dimension(500, 150));

        panelB.add(b_cancelar);
        panelB.add(b_terminar);
        panelB.add(b_apagar);
        panelB.add(b_gravar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }

    private void personalizarComponent() {
        //fornecedor
        // l_Fornecedor.setFont(new java.awt.Font("Roboto Light", 1, 14));
        c_terceiro.setForeground(new java.awt.Color(0, 0, 0));
        c_terceiro.setPreferredSize(new Dimension(150, 32));
        //contacto
        l_contacto.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_contacto.setForeground(new java.awt.Color(0, 0, 0));
        tf_contacto.setPreferredSize(new Dimension(150, 30));
        //morada
        l_morada.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_morada.setForeground(new java.awt.Color(0, 0, 0));
        tf_morada.setPreferredSize(new Dimension(150, 30));
        //nuit
        l_nuit.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_nuit.setForeground(new java.awt.Color(0, 0, 0));
        tf_nuit.setPreferredSize(new Dimension(150, 35));
        
        //Username
        l_username.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_username.setForeground(new java.awt.Color(0, 0, 0));
        tf_username.setPreferredSize(new Dimension(150, 35));
        
        //password
        l_password.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_password.setForeground(new java.awt.Color(0, 0, 0));
        tf_password.setPreferredSize(new Dimension(150, 35));
                
        //Codigo
       // tf_codigo.setEditable(false);
        l_codigo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_codigo.setForeground(new java.awt.Color(0, 0, 0));
        tf_codigo.setPreferredSize(new Dimension(150, 30));
        tf_codigo.setEditable(false);
        //Procurar
        b_apagar.setPreferredSize(new Dimension(100, 25));
        b_apagar.setBackground(new java.awt.Color(0, 134, 190));
        b_apagar.setForeground(new java.awt.Color(255, 255, 255));
        b_apagar.setText("Apagar");
        b_apagar.setRadius(20);
        b_apagar.setBorder(null);
        //nome
        l_nome.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_nome.setForeground(new java.awt.Color(0, 0, 0));
        tf_nome.setPreferredSize(new Dimension(150, 30));

        //Lista Terceiro
        b_lista.setPreferredSize(new Dimension(30, 25));
        b_lista.setBackground(new java.awt.Color(0, 134, 190));
        b_lista.setForeground(new java.awt.Color(255, 255, 255));
        b_lista.setText("");
        b_lista.setRadius(2);
        b_cancelar.setBorder(null);
        b_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/listagem.png")));
        //Terminar
        b_terminar.setPreferredSize(new Dimension(100, 25));
        b_terminar.setBackground(new java.awt.Color(0, 134, 190));
        b_terminar.setForeground(new java.awt.Color(255, 255, 255));
        b_terminar.setText("Terminar");
        b_terminar.setRadius(20);
        b_terminar.setBorder(null);
        //Cancelar
        b_cancelar.setPreferredSize(new Dimension(100, 25));
        b_cancelar.setBackground(new java.awt.Color(0, 134, 190));
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        b_cancelar.setText("Cancelar");
        b_cancelar.setRadius(20);
        b_cancelar.setBorder(null);
        //Gravar
        b_gravar.setPreferredSize(new Dimension(100, 25));
        b_gravar.setBackground(new java.awt.Color(0, 134, 190));
        b_gravar.setForeground(new java.awt.Color(255, 255, 255));
        b_gravar.setText("Gravar");
        b_gravar.setRadius(20);
        b_gravar.setBorder(null);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_gravar){
          
            boolean scc=false;
             ControllerFuncionario ctr=new ControllerFuncionario();
            try{
                if(b_gravar.getText().equalsIgnoreCase("Gravar")){
                    
                scc=ctr.cadastrar(ctr.gerador(),tf_nome.getText(),tf_contacto.getText(),
                        tf_morada.getText(),Long.parseLong(tf_nuit.getText()),tf_username.getText(),tf_password.getText(),c_terceiro.getSelectedItem()+"");
                }else{
                                      

                scc=ctr.modificar(Integer.parseInt(tf_codigo.getText()),tf_nome.getText(),tf_contacto.getText(),
                        tf_morada.getText(),Long.parseLong(tf_nuit.getText()),tf_username.getText(),tf_password.getText(),c_terceiro.getSelectedItem()+"");
                    this.frame.dispose();
                }
                if(scc){
                        
                        JOptionPane.showMessageDialog(null, "Realizado Com Sucesso!");
                        
                        //this.frame.dispose();
                } else{
                        JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERRO:"+ex);
            }
       
        }
        if(e.getSource()==b_cancelar){
            int yes_no=JOptionPane.showConfirmDialog(null, "Tem Certeza?","Confirm",JOptionPane.YES_NO_OPTION);
            if(yes_no==JOptionPane.YES_OPTION){
                frame.dispose();
            }
        }
        if(e.getSource()==b_lista){
            new Tabela_Funcionario(this);
            //frame.dispose();
        }
        if(e.getSource()==b_apagar){
             boolean status=false;
       ControllerFuncionario ctr=new ControllerFuncionario();
       int codigo=Integer.parseInt(tf_codigo.getText());
        status=ctr.remover(codigo);
       if(status){
        frame.dispose();
        JOptionPane.showMessageDialog(null, "Removido Com Sucesso!");
        //frame.dispose();
 
       }
            
        }
        
        
    }
}
