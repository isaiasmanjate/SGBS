package sgbs.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Ricardo
 */
public class SubFamilia {
   
       private GridBagConstraints constraints = new GridBagConstraints();
    private JFrame frame;
    private JPanel global;
    private JLabel l_codigo, l_familia,l_descricao, l_subFamilia, favicon, l_titulo_frame, espaco;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_codigo, tf_subFamilia,tf_descricao;
    private JButton b_gravar, b_cancelar, b_terminar;
    private sgbs.View.controles.combo_suggestion.ComboBoxSuggestion c_familia;
    
    private SubFamilia() {
        inicializarComponentes();
        configurarFrame();
        
    }
    
    private void inicializarComponentes(){
        frame = new JFrame("Criacao de Sub Familia");
        frame.setResizable(false);
        
        global = new JPanel();
        
        l_codigo = new JLabel();
        l_familia = new JLabel();
        l_subFamilia = new JLabel();
        l_descricao = new JLabel();
        l_titulo_frame = new JLabel();
        favicon = new JLabel();
        espaco = new JLabel();
        
        tf_codigo = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_subFamilia = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        //Inicializar Botoes
        b_cancelar = new JButton("Cancelar");
        b_gravar = new JButton("Gravar");
        b_terminar = new JButton("Terminar");
        
        c_familia = new sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
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
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home32.png")));
        favicon.setText(" ");
        l_titulo_frame.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_titulo_frame.setText("Sub Familia");
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
        panel.setPreferredSize(new Dimension(590, 230));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(12, 10, 0, 10);
//        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_END;
        
        //adicionar atributos da Familia
        addGB(panel, espaco, 2, 0);
        addGB(panel, l_codigo, 0, 0);
        addGB(panel, l_familia, 0, 1);
        addGB(panel, l_subFamilia, 0, 2);
        addGB(panel, l_descricao, 0, 3);
        addGB(panel, tf_codigo, 1, 0);
        addGB(panel, c_familia, 1, 1);
        addGB(panel, tf_subFamilia, 1, 2);
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panel, tf_descricao, 1, 3);
        
        panelB.add(b_gravar);
        panelB.add(espaco);
        panelB.add(b_cancelar);
        
        principal.add(panel, BorderLayout.NORTH);
        principal.add(panelB, BorderLayout.LINE_END);
        
        return principal;
        
        
    }
    
    private void personalizarComponent() {
        
        //Espaco
        espaco.setText("     ");
        
        //Descricao
        l_codigo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_codigo.setForeground(new java.awt.Color(0, 0, 0));
        l_codigo.setText("Codigo");
        tf_codigo.setForeground(new java.awt.Color(0, 0, 0));
        tf_codigo.setPreferredSize(new Dimension(190, 35));
        
        //Descricao
        l_descricao.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_descricao.setForeground(new java.awt.Color(0, 0, 0));
        l_descricao.setText("Descrição");
        tf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        tf_descricao.setPreferredSize(new Dimension(390, 35));
        
        //Familia Sub Familia
        l_subFamilia.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_subFamilia.setForeground(new java.awt.Color(0, 0, 0));
        l_subFamilia.setText("Nome");
        tf_subFamilia.setForeground(new java.awt.Color(0, 0, 0));
        tf_subFamilia.setPreferredSize(new Dimension(190, 35));
        
        //Familia 
        l_familia.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_familia.setForeground(new java.awt.Color(0, 0, 0));
        l_familia.setText("Familia");
        c_familia.setPreferredSize(new Dimension(190, 35));
        
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
        new SubFamilia();
    }
}
