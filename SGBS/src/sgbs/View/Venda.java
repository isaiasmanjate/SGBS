package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ricardo
 */
public class Venda implements ActionListener{
     private GridBagConstraints constraints = new GridBagConstraints();
    private JFrame frame;
    private JPanel global ;
    private JLabel l_codigo, l_descricao, l_preco, l_quant, l_total, l_totalTotal, l_desconto, favicon, l_titulo_frame, espaco;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_codigo, tf_descricao, tf_preco, tf_quant, tf_total, tf_totalTotal, tf_desconto;
    private sgbs.View.controles.combobox.Combobox c_cliente;
    private JButton b_confirmar,  b_cancelar, b_terminar, b_procurar;
    JTable tabela;
    
    
    public Venda() {
        inicializarComponentes();
        configurarFrame();
    }
    
    public void inicializarComponentes(){
        frame = new JFrame();
        frame.setResizable(false);
        
        /*  JPanel  */
        global = new JPanel();

        /*  JLabel  */
        l_codigo = new JLabel();
        l_descricao = new JLabel();
        l_preco = new JLabel();
        l_quant = new JLabel();
        l_total = new JLabel();
        l_totalTotal = new JLabel();
        l_desconto = new JLabel();
        favicon = new JLabel();
        l_titulo_frame = new JLabel();
        espaco = new JLabel();
        
        /*  TextField   */
        tf_codigo = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_preco = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_quant = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_total = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_totalTotal = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_desconto = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        /*  ComboBox   */
        c_cliente = new sgbs.View.controles.combobox.Combobox();
        c_cliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item1", "Item2", "Item3" }));
        c_cliente.setSelectedIndex(-1);
        c_cliente.setLabeText("Cliente");

        //Inicializar Botoes
        b_cancelar = new JButton("Cancelar");
        b_confirmar = new JButton("Confirmar");
        b_terminar = new JButton("Terminar");
        b_procurar = new JButton(":::");
        
        //Inicializar tabela
        String[] nomeColunas = {"Codigo", "Descicao", "Preco","Qtd", "Total"};
        Object [][] data  = {
            {"101","Bebida","10,00MT","2.0","20.00MT"},};
        tabela = new JTable(data, nomeColunas);
        configurar_JTable();
        //Action Listener
        b_procurar.addActionListener(this);
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
        l_titulo_frame.setText("Vendas");
        l_titulo_frame.setForeground(new java.awt.Color(0, 134, 190));
       // l_titulo_frame.setBackground(Color.blue);
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
        panel.setPreferredSize(new Dimension(750, 220));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(12, 10, 0, 10);
//        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_END;
        
        //adicionar atributos da Venda
        addGB(panel, l_codigo, 0, 0);
        addGB(panel, l_descricao, 0, 1);
        addGB(panel, l_preco, 0, 2);
        addGB(panel, l_quant, 4, 0);
        addGB(panel, l_total, 4, 1);
        addGB(panel, l_desconto, 4, 2);
        
        addGB(panel, tf_codigo, 1, 0);
        addGB(panel, b_procurar, 2, 0);
        addGB(panel, c_cliente, 3, 0);
        
        addGB(panel, tf_quant, 5, 0);
        addGB(panel, tf_total, 5, 1);
        addGB(panel, tf_desconto, 5, 2);
        addGB(panel, b_confirmar, 5, 3);
        
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panel, tf_descricao, 1, 1);
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panel, tf_preco, 1, 2);
        
        
        panelB.add(configurar_listaPrincJPanel());

        principal.add(panel, BorderLayout.NORTH);
        principal.add(panelB, BorderLayout.CENTER);
        
        return principal;
    }
    
    private void personalizarComponent() {
        
        //Espaco
        espaco.setText("       ");
        
        //Codigo
        l_codigo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_codigo.setForeground(new java.awt.Color(0, 0, 0));
        l_codigo.setText("Codigo");
        tf_codigo.setForeground(new java.awt.Color(0, 0, 0));
        tf_codigo.setPreferredSize(new Dimension(100, 35));
        
        //Descricao
        l_descricao.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_descricao.setForeground(new java.awt.Color(0, 0, 0));
        l_descricao.setText("Descrição");
        tf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        tf_descricao.setPreferredSize(new Dimension(100, 35));
        
        //Preco
        l_preco.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_preco.setForeground(new java.awt.Color(0, 0, 0));
        l_preco.setText("Preço");
        tf_preco.setForeground(new java.awt.Color(0, 0, 0));
        tf_preco.setPreferredSize(new Dimension(100, 35));
        
        //Procurar
        //b_cancelar.setPreferredSize(new Dimension(150, 25));
        b_procurar.setBackground(new java.awt.Color(0, 134, 190));
        b_procurar.setForeground(new java.awt.Color(255, 255, 255));
       // b_cancelar.setPreferredSize(new Dimension(100, 30));
        
        //Quantidade
        l_quant.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_quant.setForeground(new java.awt.Color(0, 0, 0));
        l_quant.setText("Quantidade");
        tf_quant.setForeground(new java.awt.Color(0, 0, 0));
        tf_quant.setPreferredSize(new Dimension(100, 35));
        
        //Total
        l_total.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_total.setForeground(new java.awt.Color(0, 0, 0));
        l_total.setText("Total unit.");
        tf_total.setForeground(new java.awt.Color(0, 0, 0));
        tf_total.setPreferredSize(new Dimension(100, 35));
        
        //Total Total
        l_totalTotal.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_totalTotal.setForeground(new java.awt.Color(0, 0, 0));
        l_totalTotal.setText("Total");
        tf_totalTotal.setForeground(new java.awt.Color(0, 0, 0));
        tf_totalTotal.setPreferredSize(new Dimension(100, 35));
        
        //Desconto
        l_desconto.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_desconto.setForeground(new java.awt.Color(0, 0, 0));
        l_desconto.setText("Desconto(%)");
        tf_desconto.setForeground(new java.awt.Color(0, 0, 0));
        tf_desconto.setPreferredSize(new Dimension(100, 35));
        
        //Desconto
        c_cliente.setPreferredSize(new Dimension(150, 40));
        
         //Confirmar
        b_confirmar.setPreferredSize(new Dimension(100, 25));
         b_confirmar.setBackground(new java.awt.Color(0, 134, 190));
        b_confirmar.setForeground(new java.awt.Color(255, 255, 255));
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
    
    
    private void configurar_JTable() {
        tabela.setPreferredScrollableViewportSize(new Dimension(740, 150));
        tabela.setFillsViewportHeight(true);
        
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0,0,0));
        tabela.setRowHeight(20);
    }
    
    
    public Component configurar_listaPrincJPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),"Lista de itens"));
        panel.setLayout(new BorderLayout());
        panel.add(configurar_scrollPane(), BorderLayout.NORTH);
        panel.add(configurar_totalJPanel(), BorderLayout.LINE_END);
        
        return panel;
    }
    
   
    public Component configurar_scrollPane() {
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(750, 140));
        
        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);     
        panel.add(scrollPane );
        
        return panel;
    }
    public Component configurar_totalJPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(2, 10, 2, 10);
        constraints.anchor = GridBagConstraints.LINE_START;
        addGB(panel, l_totalTotal, 0, 0);
        addGB(panel, tf_totalTotal, 2, 0);
        
        return panel;
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
        panelB.add(b_cancelar);
        panelB.add(b_terminar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }
    
    
    public static void main(String[] args) {
        new Venda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_procurar){
            new Tabela_Produtos();
        }
    }
}
