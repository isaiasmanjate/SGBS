package sgbs.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import sgbs.Controller.ControllerFamilia;
/**
 *
 * @author Ricardo
 */

    
    public class Familia  implements ActionListener{
      private GridBagConstraints constraints = new GridBagConstraints();
    private JFrame frame;
    private JPanel global;
    private JLabel l_familia,l_descricao, favicon, l_titulo_frame, espaco;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_familia,tf_descricao;
    private JButton b_gravar, b_cancelar, b_terminar;
    
    public Familia() {
        inicializarComponentes();
        configurarFrame();
        
    }
    
    private void inicializarComponentes(){
        frame = new JFrame("Criacao de Familia");
        frame.setResizable(false);
        
        global = new JPanel();
        
        l_familia = new JLabel();
        l_descricao = new JLabel();
        l_titulo_frame = new JLabel();
        favicon = new JLabel();
        espaco = new JLabel();
        
        tf_familia = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        //Inicializar Botoes
        b_cancelar = new JButton("Cancelar");
        b_gravar = new JButton("Gravar");
        b_terminar = new JButton("Terminar");
        
        //Evento
        b_gravar.addActionListener(this);
    }
    
    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);
   
        frame.setVisible(true);
    }
    
    private Component painelNorte() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/familia.png")));
        favicon.setText(" ");
        l_titulo_frame.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_titulo_frame.setText("Familia");
        l_titulo_frame.setForeground(new java.awt.Color(0, 134, 190));
        panel.add(favicon);
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
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        panelB.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        panelB.setLayout(new GridBagLayout());
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(550, 150));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(12, 10, 0, 10);
//        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_END;
        
        //adicionar atributos da Familia
        addGB(panel, espaco, 2, 0);
        addGB(panel, l_familia, 0, 0);
        addGB(panel, l_descricao, 0, 1);
        addGB(panel, tf_familia, 1, 0);
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panel, tf_descricao, 1, 1);
        
        panelB.add(b_gravar);
        panelB.add(espaco);
        panelB.add(b_cancelar);
        
        principal.add(panel, BorderLayout.NORTH);
        principal.add(panelB, BorderLayout.LINE_END);
        
        return principal;
        
        
    }
    
    private void personalizarComponent() {
        
        //Espaco
        espaco.setText("   ");
        
        //Descricao
        l_descricao.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_descricao.setForeground(new java.awt.Color(0, 0, 0));
        l_descricao.setText("Descrição");
        tf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        tf_descricao.setPreferredSize(new Dimension(390, 35));
        
        //Familia
        l_familia.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_familia.setForeground(new java.awt.Color(0, 0, 0));
        l_familia.setText("Nome");
        tf_familia.setForeground(new java.awt.Color(0, 0, 0));
        tf_familia.setPreferredSize(new Dimension(190, 35));
        
        //Confirmar
        b_gravar.setPreferredSize(new Dimension(100, 25));
        b_gravar.setBackground(new java.awt.Color(0, 134, 190));
        b_gravar.setForeground(new java.awt.Color(255, 255, 255));
        b_gravar.setPreferredSize(new Dimension(100, 30));
        //Terminar
        b_terminar.setPreferredSize(new Dimension(150, 25));
        b_terminar.setBackground(new java.awt.Color(0, 134, 190));
        b_terminar.setForeground(new java.awt.Color(255, 255, 255));
        b_terminar.setPreferredSize(new Dimension(100, 30));
        //Cancelar
        b_cancelar.setPreferredSize(new Dimension(150, 25));
        b_cancelar.setBackground(new java.awt.Color(0, 134, 190));
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        b_cancelar.setPreferredSize(new Dimension(100, 30));
    }
    
    private Component painelSul() {
        personalizarComponent();
        constraints.insets = new Insets(2, 10, 2, 10);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;

        JPanel principal = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
//        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        panelB.add(b_terminar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }
    public static void main(String[] args) {
        new Familia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_gravar){
        
            boolean scc=false;
             ControllerFamilia ctr=new ControllerFamilia();
            
            try{
                if(b_gravar.getText().equalsIgnoreCase("Gravar")){
                    
                scc=ctr.cadastrar(ctr.gerador(),tf_familia.getText(),tf_descricao.getText());
                }
                if(scc){
                        
                        JOptionPane.showMessageDialog(null, "Realizado Com Sucesso!");
                        //this.frame.dispose();
                        tf_descricao.setText("");
                        tf_familia.setText("");
                } else{
                        JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "ERRO:"+ex);
            }
       
        }
        }
    }


