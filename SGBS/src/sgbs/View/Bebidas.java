/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ricardo
 */
public class Bebidas {
    private JFrame janela;
    private JPanel globalJPanel,principalJPanel, bebidasJPanel, precoJPanel,botoesJPanel, botoesCimaJPanel,botoesBaixoJPanel,cimaJPanel, loginBtnCancel,loginBtnSalvar,loginBtnSalvarAdd, loginBtnCancel_1,loginBtnSalvar_1, TabbebJPanel,listaJPanel;
    private JLabel descricaoJLabel, codigoJLabel, familiaJLabel, subFamiliaJLabel, tipoJLabel, ivaJLabel,preco_1JLabel,preco_2JLabel,IVAJLabe,semIVAJLabe, comIVAJLabel, favicon, produto,loginBtnCancelTxt,loginBtnSalvarTxt,loginBtnSalvarAddTxt,loginBtnCancelTxt_1,loginBtnSalvarTxt_1;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion descricaoTxt, codigoTxt,preco_11JTxt, preco_12JTxt, preco_21JTxt, preco_22JTxt;
    private sgbs.View.controles.combo_suggestion.ComboBoxSuggestion familiaCombo,subFamiliaCombo, tipoCombo,ivaCombo;
    private JCheckBox  inativoCheck;
    private JTabbedPane ConjPanel;
    JTable tabela;
   
    String[] nomeColunas = {"Codigo", "Descicao", "Famlia","SubFamilia", "Tipo", "Preco 1", "Preco 2"};
    Object [][] data  = {
        {"101","Bebida","10,00MT","2.0","20.00MT","20.00MT","20.00MT"},};
    
    public Bebidas() {
        inicializarComponentes();
        configurarComponentes();
        janela.pack();
        janela.setVisible(true);
    }
    
    private void inicializarComponentes(){
        janela = new JFrame("Cadastrar Bebidas");
        janela.setResizable(false);
        
        /*  JPanel  */
        globalJPanel = new JPanel();
        principalJPanel = new JPanel();
        bebidasJPanel = new JPanel();
        precoJPanel = new JPanel();
        botoesJPanel = new JPanel();
        botoesCimaJPanel = new JPanel();
        botoesBaixoJPanel = new JPanel();
        cimaJPanel = new JPanel();
        loginBtnCancel  = new JPanel();
        loginBtnSalvar  = new JPanel();
        loginBtnSalvarAdd  = new JPanel();
        TabbebJPanel  = new JPanel();
        listaJPanel  = new JPanel();
        
        /* Label */ 
        descricaoJLabel = new JLabel();
        codigoJLabel = new JLabel();
        familiaJLabel = new JLabel();
        subFamiliaJLabel = new JLabel();
        tipoJLabel = new JLabel();
        ivaJLabel = new JLabel();
        preco_1JLabel = new JLabel();
        preco_2JLabel = new JLabel();
        IVAJLabe = new JLabel();
        semIVAJLabe = new JLabel();
        comIVAJLabel = new JLabel();
        favicon = new JLabel();
        produto = new JLabel();
        loginBtnCancelTxt  = new JLabel();
        loginBtnSalvarTxt  = new JLabel();
        loginBtnSalvarAddTxt  = new JLabel();
        
        /* TextField */
        descricaoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        codigoTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        preco_11JTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        preco_12JTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        preco_21JTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        preco_22JTxt  = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        /* ComboBox */
        familiaCombo  = new  sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        subFamiliaCombo  = new  sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        ivaCombo  = new  sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        tipoCombo  = new  sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        
        /* CheckBox */
        inativoCheck  = new JCheckBox("Inativo");
        
        /*  JTabbedPan  */
        ConjPanel = new JTabbedPane();
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
        globalJPanel.add(TabbebJPanel, BorderLayout.CENTER);
        globalJPanel.add(botoesJPanel, BorderLayout.SOUTH);

        configurar_cimaJPanel();
        configurar_botoesJPanel(); 
        configurar_JTabbedPane();
    }
    
    public void configurar_cimaJPanel(){
        
        cimaJPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        cimaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home32.png"))); 
        favicon.setText(" ");
        produto.setFont(new java.awt.Font("Roboto Black", 1, 24));
        produto.setText("Bebidas");
        produto.setForeground(new java.awt.Color(0, 134, 190));
        produto.setBackground(Color.blue);
            cimaJPanel.add(favicon);
            cimaJPanel.add(produto);
    }
    private void configurar_JTabbedPane(){
        TabbebJPanel.setLayout(new BorderLayout());
        TabbebJPanel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        JTabbedPane dd = new JTabbedPane();
        TabbebJPanel.add(ConjPanel,BorderLayout.CENTER);
        TabbebJPanel.setBackground(new java.awt.Color(255, 255, 255));
        
        ConjPanel.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.addTab("Cadastro", principalJPanel);
        ConjPanel.addTab("Lista", listaJPanel);

        configurar_pincipalJPanel();
        configurar_listaJPanel();
    }
    
    public void configurar_pincipalJPanel(){
        principalJPanel.setLayout(new BorderLayout());
        principalJPanel.add(bebidasJPanel, BorderLayout.NORTH);
        principalJPanel.add(precoJPanel, BorderLayout.CENTER);
        
        configurar_bebidasJPanel();
        configurar_precoJPanel();
    }
    
    public void configurar_bebidasJPanel(){
        bebidasJPanel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        bebidasJPanel.setLayout(new GridBagLayout());
        bebidasJPanel.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 20, 2, 20);
        
        gbc.gridx = 0;
        gbc.gridy = 0; bebidasJPanel.add(new JLabel("      ") , gbc);
        
        /*-------------------------------------------------------------*/
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        descricaoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        descricaoJLabel.setText("Descricao");
        gbc.gridy = 1; bebidasJPanel.add(descricaoJLabel , gbc);
        
        codigoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        codigoJLabel.setText("Codigo");
        gbc.gridy = 2; bebidasJPanel.add(codigoJLabel , gbc);
        
        familiaJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        familiaJLabel.setText("Familia");
        gbc.gridy = 3; bebidasJPanel.add(familiaJLabel , gbc);
        
        subFamiliaJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        subFamiliaJLabel.setText("Sub Familia");
        gbc.gridy = 4; bebidasJPanel.add(subFamiliaJLabel , gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        codigoTxt.setForeground(new java.awt.Color(0, 0, 0));
        codigoTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 2; bebidasJPanel.add(codigoTxt , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        familiaCombo.setForeground(new java.awt.Color(0, 0, 0));
        familiaCombo.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 3; bebidasJPanel.add(familiaCombo , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        subFamiliaCombo.setForeground(new java.awt.Color(0, 0, 0));
        subFamiliaCombo.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 4; bebidasJPanel.add(subFamiliaCombo , gbc);
        
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        tipoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tipoJLabel.setText("Tipo");
        gbc.gridy = 2; bebidasJPanel.add(tipoJLabel , gbc);
        
        ivaJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        ivaJLabel.setText("IVA");
        gbc.gridy = 3; bebidasJPanel.add(ivaJLabel , gbc);
        
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        tipoCombo.setForeground(new java.awt.Color(0, 0, 0));
        tipoCombo.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 2; bebidasJPanel.add(tipoCombo , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        ivaCombo.setForeground(new java.awt.Color(0, 0, 0));
        ivaCombo.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 3; bebidasJPanel.add(ivaCombo , gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        descricaoTxt.setForeground(new java.awt.Color(0, 0, 0));
        descricaoTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 1; bebidasJPanel.add(descricaoTxt , gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1; bebidasJPanel.add(inativoCheck , gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5; bebidasJPanel.add(new JLabel("      ") , gbc);
    }
    
    public void configurar_precoJPanel(){
        precoJPanel.setBorder(new TitledBorder(LineBorder.createGrayLineBorder(),"Preco"));
        precoJPanel.setLayout(new GridBagLayout());
        precoJPanel.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 20, 2, 20);
        
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        preco_1JLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        preco_1JLabel.setText("Preco venda 1");
        gbc.gridy = 2; precoJPanel.add(preco_1JLabel , gbc);
        
        preco_2JLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        preco_2JLabel.setText("Preco venda 2");
        gbc.gridy = 3; precoJPanel.add(preco_2JLabel , gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        preco_11JTxt.setForeground(new java.awt.Color(0, 0, 0));
        preco_11JTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 2; precoJPanel.add(preco_11JTxt , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        preco_21JTxt.setForeground(new java.awt.Color(0, 0, 0));
        preco_21JTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 3; precoJPanel.add(preco_21JTxt , gbc);
        
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        preco_12JTxt.setForeground(new java.awt.Color(0, 0, 0));
        preco_12JTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 2; precoJPanel.add(preco_12JTxt , gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        preco_22JTxt.setForeground(new java.awt.Color(0, 0, 0));
        preco_22JTxt.setPreferredSize(new Dimension(150, 35));
        gbc.gridy = 3; precoJPanel.add(preco_22JTxt , gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        semIVAJLabe.setFont(new java.awt.Font("Roboto Light", 1, 14));
        semIVAJLabe.setText("s/IVA");
        gbc.gridy = 1; precoJPanel.add(semIVAJLabe , gbc);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        comIVAJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        comIVAJLabel.setText("IVA Inc.");
        gbc.gridy = 1; precoJPanel.add(comIVAJLabel , gbc);
        
    }
    
    public void configurar_listaJPanel() {
        listaJPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(750, 340));
        
        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        
        
        
        listaJPanel.add(scrollPane );
    }
    
    public void configurar_botoesJPanel(){
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
        
         //------------Configuracao do Botao SALVARAdd------------------
        loginBtnSalvarAdd.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnSalvarAddTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        loginBtnSalvarAddTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnSalvarAddTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnSalvarAddTxt.setText("SALVAR e ADD NOVO");
        loginBtnSalvarAddTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayoutSalvarAdd = new javax.swing.GroupLayout(loginBtnSalvarAdd);
        loginBtnSalvarAdd.setLayout(loginBtnLayoutSalvarAdd);
        loginBtnLayoutSalvarAdd.setHorizontalGroup(
            loginBtnLayoutSalvarAdd.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnSalvarAddTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayoutSalvarAdd.setVerticalGroup(
            loginBtnLayoutSalvarAdd.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnSalvarAddTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        
        botoesJPanel.add(loginBtnSalvarAdd);
    }
    
    
    
    public static void main(String[] args) {
        new Bebidas();
    }
}
