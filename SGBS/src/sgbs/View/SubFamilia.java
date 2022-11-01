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
    private JFrame janela;
    private JPanel pGlobal,pPrincipal,pBotoCancelar,pBotoGravar,gravarBtn,cancelarBtn,terminarBtn,pBotaoTerminar, cimaJPanel;
    private JLabel subFamiliaLabel,descricaoLabel,gravarBtnTxt,cancelarBtnTxt,terminarBtnTxt, codigoJLabel,FamiliaJLabel, favicon, produto;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion subFamiliaTxt,descricaoTxt, codigoTxt;
    private sgbs.View.controles.combo_suggestion.ComboBoxSuggestion familiaCombo;
    
    private SubFamilia () {
        inicializarComponentes();
        configurarComponentes();
        janela.pack();
        janela.setVisible(true);
        
    }
    
    private void inicializarComponentes(){
        janela = new JFrame("Criacao de Sub-Familia");
        janela.setResizable(false);
        
        pGlobal = new JPanel();
        pPrincipal = new JPanel();
        pBotoCancelar = new JPanel();
        pBotoGravar = new JPanel();
        gravarBtn = new JPanel();
        cancelarBtn = new JPanel();
        terminarBtn = new JPanel();
        pBotaoTerminar = new JPanel();
        cimaJPanel = new JPanel();
        
        subFamiliaLabel = new JLabel();
        descricaoLabel = new JLabel();
        gravarBtnTxt = new JLabel();
        cancelarBtnTxt = new JLabel();
        terminarBtnTxt = new JLabel();
        codigoJLabel = new JLabel();
        FamiliaJLabel = new JLabel();
        produto = new JLabel();
        favicon = new JLabel();
                
        subFamiliaTxt = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        descricaoTxt = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        codigoTxt = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        familiaCombo  = new  sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        
    }
    
    public void configurarComponentes() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        janela.setLocationRelativeTo(null);
        janela.add(pGlobal);
        
        pGlobal.setLayout(new BorderLayout());
        pGlobal.add(cimaJPanel, BorderLayout.NORTH);
        pGlobal.add(pPrincipal, BorderLayout.CENTER);
        pGlobal.add(pBotaoTerminar, BorderLayout.SOUTH);

        configurar_cimaJPanel();
        configurar_pPrincipal();
        configurar_pBotoes(); 
        configurar_pBotaoTerminar();
        configurar_pBotoGravar();
    }
    
    public void configurar_cimaJPanel(){
        cimaJPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        cimaJPanel.setBackground(new java.awt.Color(255, 255, 255));
        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home32.png"))); 
        favicon.setText(" ");
        produto.setFont(new java.awt.Font("Roboto Black", 1, 24));
        produto.setText("Criar Sub Familia");
        produto.setForeground(new java.awt.Color(0, 134, 190));
        produto.setBackground(Color.blue);
            cimaJPanel.add(favicon);
            cimaJPanel.add(produto);
    }
    
    private void configurar_pPrincipal() {
        pPrincipal.setLayout(new GridBagLayout());
        pPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        
        gbc.gridx = 0;
        gbc.gridy = 0; pPrincipal.add(new JLabel("             "), gbc);
        gbc.gridy = 1; pPrincipal.add(new JLabel(""), gbc);
        gbc.gridy = 2; pPrincipal.add(new JLabel(""), gbc);
        gbc.gridy = 5; pPrincipal.add(new JLabel(""), gbc);
        gbc.gridy = 6; pPrincipal.add(new JLabel(""), gbc);
        gbc.gridx = 3;
        gbc.gridy = 0; pPrincipal.add(new JLabel("                 "), gbc);
        gbc.gridx = 4;
        gbc.gridy = 0; pPrincipal.add(new JLabel("    "), gbc);
        
        codigoJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        codigoJLabel.setText("Codigo");
        gbc.gridx = 1;
        gbc.gridy = 3; pPrincipal.add(codigoJLabel , gbc);
        
        gbc.gridx = 2;
        codigoTxt.setPreferredSize(new Dimension(190, 35));
        gbc.gridy = 3; pPrincipal.add(codigoTxt , gbc);
        
        
        FamiliaJLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        FamiliaJLabel.setText("Familia");
        gbc.gridx = 1;
        gbc.gridy = 4; pPrincipal.add(FamiliaJLabel , gbc);
        
        gbc.gridx = 2;
        familiaCombo.setPreferredSize(new Dimension(190, 35));
        gbc.gridy = 4; pPrincipal.add(familiaCombo , gbc);
        
        subFamiliaLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        subFamiliaLabel.setText("Sub Familia");
        gbc.gridx = 1;
        gbc.gridy = 5; pPrincipal.add(subFamiliaLabel , gbc);
        
        gbc.gridx = 2;
        subFamiliaTxt.setPreferredSize(new Dimension(190, 35));
        gbc.gridy = 5; pPrincipal.add(subFamiliaTxt , gbc);
        
        descricaoLabel.setFont(new java.awt.Font("Roboto Light", 1, 14));
        descricaoLabel.setText("Descricao");
        gbc.gridx = 1;
        gbc.gridy = 6; pPrincipal.add(descricaoLabel , gbc);
        
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        descricaoTxt.setPreferredSize(new Dimension(390, 35));
        gbc.gridy = 6; pPrincipal.add(descricaoTxt , gbc);
        
        
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.gridy = 9; pPrincipal.add(pBotoGravar , gbc);
        gbc.gridx = 4;
        gbc.gridy = 9; pPrincipal.add(pBotoCancelar , gbc);
    }
    
    
    private void configurar_pBotoGravar(){
        pBotoGravar.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pBotoGravar.setBackground(new java.awt.Color(255, 255, 255));
        
        gravarBtn.setBackground(new java.awt.Color(0, 134, 190));

        gravarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        gravarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        gravarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gravarBtnTxt.setText("GRAVAR");
        gravarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(gravarBtn);
        gravarBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gravarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gravarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        
        pBotoGravar.add(gravarBtn);
    }
    
    
     private void configurar_pBotoes(){
        pBotoCancelar.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pBotoCancelar.setBackground(new java.awt.Color(255, 255, 255));

        cancelarBtn.setBackground(new java.awt.Color(0, 134, 190));

        cancelarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        cancelarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelarBtnTxt.setText("CANCELAR");
        cancelarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayout2 = new javax.swing.GroupLayout(cancelarBtn);
        cancelarBtn.setLayout(loginBtnLayout2);
        loginBtnLayout2.setHorizontalGroup(
            loginBtnLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayout2.setVerticalGroup(
            loginBtnLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pBotoCancelar.add(cancelarBtn);
    }
     
     
    private void configurar_pBotaoTerminar(){
        pBotaoTerminar.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        pBotaoTerminar.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pBotaoTerminar.setBackground(new java.awt.Color(255, 255, 255));
        
        terminarBtn.setBackground(new java.awt.Color(0, 134, 190));

        terminarBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        terminarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        terminarBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        terminarBtnTxt.setText("TERMINAR");
        terminarBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(terminarBtn);
        terminarBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(terminarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(terminarBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        
        pBotaoTerminar.add(terminarBtn);
     }
    
    public static void main(String[] args) {
        new SubFamilia();
    }
}
