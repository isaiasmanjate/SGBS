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
public class Vendas {
    private JFrame janela;
    private JPanel globalJPanel, principalJPanel, cimaJPanel, vendasJPanel, listaJPanel, botoesJPanel, totalJPanel,listaPrincJPanel,loginBtnCancel,loginBtnSalvar;
    private JLabel codigoJLabel, descricaoJLabel, precoJLabel, quantJLabel, totalJLabel, totalTotalJLabel, descontoJLabel, submenterJLabel, favicon, venda, loginBtnCancelTxt,loginBtnSalvarTxt;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion codigoTxt,descricaoTxt, precoTxt, quantTxt, totalTxt, totalTotalTxt,descontoTxt;
    private sgbs.View.controles.combobox.Combobox clienteCombo;
    private sgbs.View.controles.MyButton.MyButtonPrim botaoJButton;
    private sgbs.View.controles.MyButton.MyButtonSubmeter submeter;
    JTable tabela;
   
    String[] nomeColunas = {"Codigo", "Descicao", "Preco","Qtd", "Total"};
    Object [][] data  = {
        {"101","Bebida","10,00MT","2.0","20.00MT"},};
    
    
    public Vendas() {
        inicializarComponentes();
        configurarComponentes();
        janela.pack();
        janela.setVisible(true);
    }
    
    public void inicializarComponentes(){
        janela = new JFrame("Produto");
        janela.setResizable(false);
        
            
        
        
        /*  JPanel  */
        globalJPanel = new JPanel();
        principalJPanel = new JPanel();
        cimaJPanel = new JPanel();
        vendasJPanel = new JPanel();
        listaJPanel = new JPanel();
        botoesJPanel = new JPanel();
        totalJPanel = new JPanel();
        listaPrincJPanel = new JPanel();
        loginBtnCancel  = new JPanel();
        loginBtnSalvar  = new JPanel();
        
        /*  JLabel  */
        codigoJLabel = new JLabel();
        descricaoJLabel = new JLabel();
        precoJLabel = new JLabel();
        quantJLabel = new JLabel();
        totalJLabel = new JLabel();
        totalTotalJLabel = new JLabel();
        descontoJLabel = new JLabel();
        submenterJLabel = new JLabel();
        favicon = new JLabel();
        venda = new JLabel();
        loginBtnCancelTxt  = new JLabel();
        loginBtnSalvarTxt  = new JLabel();
        
        /*  TextField   */
        codigoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        descricaoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        precoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        quantTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        totalTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        totalTotalTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        descontoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        /*  ComboBox   */
        clienteCombo = new sgbs.View.controles.combobox.Combobox();  
        
        /*  JButton   */
        botaoJButton = new sgbs.View.controles.MyButton.MyButtonPrim();
        submeter = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        
        configurar_JTable();
    }
    
    private void configurar_JTable() {
        tabela = new JTable(data, nomeColunas);
        tabela.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabela.setFillsViewportHeight(true);
        
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0,0,0));
        tabela.setRowHeight(20);
    }
    
    public void configurarComponentes() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        janela.setLocationRelativeTo(null);
        janela.add(globalJPanel);
        
        globalJPanel.setLayout(new BorderLayout());
        globalJPanel.add(cimaJPanel, BorderLayout.NORTH);
        globalJPanel.add(principalJPanel, BorderLayout.CENTER);
        globalJPanel.add(botoesJPanel, BorderLayout.SOUTH);

        configurar_cimaJPanel();
        configurar_pincipalJPanel();
        configurar_botoesJPanel();     
    }
    private void configurar_cimaJPanel(){
        cimaJPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        cimaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home32.png"))); 
        favicon.setText(" ");
        venda.setFont(new java.awt.Font("Roboto Black", 1, 24));
        venda.setText("Venda");
        venda.setForeground(new java.awt.Color(0, 134, 190));
        venda.setBackground(Color.blue);
            cimaJPanel.add(favicon);
            cimaJPanel.add(venda);
    }
    
    public void configurar_pincipalJPanel(){
        principalJPanel.setLayout(new BorderLayout());
        principalJPanel.add(vendasJPanel, BorderLayout.NORTH);
        principalJPanel.add(listaPrincJPanel, BorderLayout.CENTER);
        
        configurar_vendasJPanel();
        configurar_listaPrincJPanel();
    }
    
    public void configurar_listaPrincJPanel(){
        listaPrincJPanel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),"Lista de Bebidas"));
        listaPrincJPanel.setLayout(new BorderLayout());
        listaPrincJPanel.add(listaJPanel, BorderLayout.NORTH);
        listaPrincJPanel.add(totalJPanel, BorderLayout.LINE_END);
        
        configurarComponentes_listaJPanel();
        configurar_totalJPanel();
    }
    
    public void configurar_vendasJPanel(){
        vendasJPanel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        vendasJPanel.setLayout(new GridBagLayout());
        vendasJPanel.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 2, 10);
        vendasJPanel.setBorder(LineBorder.createGrayLineBorder());
        
        gbc.gridx = 0;
        gbc.gridy = 0; vendasJPanel.add(new JLabel("      ") , gbc);
        /*----------------------------------------------------*/
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        codigoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        codigoJLabel.setText("Codigo");
        gbc.gridy = 1; vendasJPanel.add(codigoJLabel , gbc);
        
        descricaoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        descricaoJLabel.setText("Descricao");
        gbc.gridy = 2; vendasJPanel.add(descricaoJLabel , gbc);
        
        precoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        precoJLabel.setText("Preco");
        gbc.gridy = 3; vendasJPanel.add(precoJLabel , gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        codigoTxt.setForeground(new java.awt.Color(0, 0, 0));
        codigoTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 1; vendasJPanel.add(codigoTxt , gbc);
        
        
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        botaoJButton.setText(".");
        botaoJButton.setPreferredSize(new Dimension(35, 35));
        botaoJButton.setRadius(10);
        gbc.gridy = 1; vendasJPanel.add(botaoJButton , gbc);
        
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        clienteCombo.setPreferredSize(new Dimension(150, 40));
        clienteCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item1", "Item2", "Item3" }));
        clienteCombo.setSelectedIndex(-1);
        clienteCombo.setLabeText("Cliente");
        gbc.gridy = 1; vendasJPanel.add(clienteCombo , gbc);
        
        gbc.gridx = 1;
        precoTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 3; vendasJPanel.add(precoTxt , gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descricaoTxt.setForeground(new java.awt.Color(0, 0, 0));
        descricaoTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 2; vendasJPanel.add(descricaoTxt , gbc);
        
        
        /*-------------------------------------------------------------*/
        
        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridy = 0; vendasJPanel.add(new JLabel("      ") , gbc);
        
        /*-------------------------------------------------------------*/
        
        gbc.gridx = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        quantJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        quantJLabel.setText("Quantidade");
        gbc.gridy = 1; vendasJPanel.add(quantJLabel , gbc);
        
        totalJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        totalJLabel.setText("Total");
        gbc.gridy = 2; vendasJPanel.add(totalJLabel , gbc);
        
        descontoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        descontoJLabel.setText("Desconto");
        gbc.gridy = 3; vendasJPanel.add(descontoJLabel , gbc);
        
        
        gbc.gridx = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        quantTxt.setForeground(new java.awt.Color(0, 0, 0));
        quantTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 1; vendasJPanel.add(quantTxt , gbc);
        
        totalTxt.setForeground(new java.awt.Color(0, 0, 0));
        totalTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 2; vendasJPanel.add(totalTxt , gbc);
        
        descontoTxt.setForeground(new java.awt.Color(0, 0, 0));
        descontoTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 3; vendasJPanel.add(descontoTxt , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        submeter.setText("Submeter");
        submeter.setPreferredSize(new Dimension(90, 35));
        submeter.setRadius(10);
        gbc.gridy = 4; vendasJPanel.add(submeter , gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5; vendasJPanel.add(new JLabel("      ") , gbc);
//        
        
    }
    
    public void configurarComponentes_listaJPanel() {
        listaJPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(650, 140));
        
        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        
        
        
        listaJPanel.add(scrollPane );
    }
    public void configurar_totalJPanel(){
        totalJPanel.setLayout(new GridBagLayout());
        totalJPanel.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 2, 10);
        
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        totalTotalJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        totalTotalJLabel.setText("Total");
        gbc.gridy = 0; totalJPanel.add(totalTotalJLabel , gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        totalTotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        totalTotalTxt.setPreferredSize(new Dimension(100, 35));
        gbc.gridy = 0; totalJPanel.add(totalTotalTxt , gbc);
        
    }
    
    private void configurar_botoesJPanel(){
        botoesJPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        botoesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        
        
        //------------------Configuracao do Botao CANCELAR-------------------
        loginBtnCancel.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnCancelTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        loginBtnCancelTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnCancelTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnCancelTxt.setText("CANCELAR");
        loginBtnCancelTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayoutCancelar = new javax.swing.GroupLayout(loginBtnCancel);
        loginBtnCancel.setLayout(loginBtnLayoutCancelar);
        loginBtnLayoutCancelar.setHorizontalGroup(
            loginBtnLayoutCancelar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnCancelTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayoutCancelar.setVerticalGroup(
            loginBtnLayoutCancelar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnCancelTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        botoesJPanel.add(loginBtnCancel);
        
        //------------Configuracao do Botao SALVAR------------------
        loginBtnSalvar.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnSalvarTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        loginBtnSalvarTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnSalvarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnSalvarTxt.setText("SALVAR");
        loginBtnSalvarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayoutSalvar = new javax.swing.GroupLayout(loginBtnSalvar);
        loginBtnSalvar.setLayout(loginBtnLayoutSalvar);
        loginBtnLayoutSalvar.setHorizontalGroup(
            loginBtnLayoutSalvar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnSalvarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayoutSalvar.setVerticalGroup(
            loginBtnLayoutSalvar.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnSalvarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        
        botoesJPanel.add(loginBtnSalvar);
       
       
        
    }
    
    
    public static void main(String[] args) {
        new Vendas();
    }
}
