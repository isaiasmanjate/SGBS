
package sgbs.View;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Ricardo
 */
public class Login extends javax.swing.JFrame{
    private JFrame janela;
    private JPanel pGlobal,pPrincipal,loginBtn,loginBtnCancel,pBotoes,pCima;
    private JLabel TitleLabel,favicon,loginBtnTxt,loginBtnCancelTxt;
    private sgbs.View.controles.textfield.PasswordField passTxt ;
    private sgbs.View.controles.textfield.TextField userTxt;
    
    public Login() {
        inicializarComponentes();
        configurarComponentes();
        janela.pack();
        janela.setVisible(true);
        
    }
    
    public void inicializarComponentes(){
        janela = new JFrame("Login");
        janela.setResizable(false);
        
        pGlobal = new JPanel();
        pPrincipal = new JPanel();
        pBotoes = new JPanel();
        pCima = new JPanel();
        loginBtn = new JPanel();
        loginBtnCancel = new JPanel();
        TitleLabel = new JLabel();
        favicon = new JLabel();
        loginBtnTxt = new JLabel();
        loginBtnCancelTxt = new JLabel();
        passTxt = new sgbs.View.controles.textfield.PasswordField();
        userTxt = new sgbs.View.controles.textfield.TextField();
       
    }
    
    public void configurarComponentes() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        janela.setLocationRelativeTo(null);
        janela.add(pGlobal);
        
        pGlobal.setLayout(new BorderLayout());
         pGlobal.add(pCima, BorderLayout.NORTH);
        pGlobal.add(pPrincipal, BorderLayout.CENTER);
        pGlobal.add(pBotoes, BorderLayout.SOUTH);

        configurar_pCima();
        configurar_pPrincipal();
        configurar_pBotoes();     
    }
    
    
    private void configurar_pCima(){
        pCima.setLayout(new FlowLayout(FlowLayout.CENTER));
        pCima.setBackground(new java.awt.Color(255, 255, 255));
        TitleLabel.setFont(new java.awt.Font("Roboto Black", 1, 24));
        TitleLabel.setText("Login");
            pCima.add(TitleLabel);
    }
    
    private void configurar_pPrincipal() {
        pPrincipal.setLayout(new GridBagLayout());
        pPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 20, 2, 20);


        passTxt.setLabelText("Palavra Passe");
        passTxt.setShowAndHide(true);
        gbc.gridx = 1;
        passTxt.setPreferredSize(new Dimension(190, 50));
        gbc.gridy = 1; pPrincipal.add(passTxt , gbc);

        userTxt.setLabelText("Nome do Usuario");
        gbc.gridx = 1;
        userTxt.setPreferredSize(new Dimension(190, 50));
        gbc.gridy = 0; pPrincipal.add(userTxt , gbc);
        
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridheight = 2;
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/user.png"))); 
        gbc.gridy = 0; pPrincipal.add(favicon , gbc);
    
    }
    
    private void configurar_pBotoes(){
        pBotoes.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pBotoes.setBackground(new java.awt.Color(255, 255, 255));
        
        //------------Configuracao do Botao ENTRAR------------------
        loginBtn.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        
        pBotoes.add(loginBtn);
       
        
         //------------------Configuracao do Botao CANCELAR-------------------
        loginBtnCancel.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnCancelTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 10));
        loginBtnCancelTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnCancelTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnCancelTxt.setText("CANCELAR");
        loginBtnCancelTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        javax.swing.GroupLayout loginBtnLayout2 = new javax.swing.GroupLayout(loginBtnCancel);
        loginBtnCancel.setLayout(loginBtnLayout2);
        loginBtnLayout2.setHorizontalGroup(
            loginBtnLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnCancelTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        loginBtnLayout2.setVerticalGroup(
            loginBtnLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnCancelTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pBotoes.add(loginBtnCancel);
    }
    
//    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {
//        if (userTxt.getText().equals("Nome do usuario")) {
//            userTxt.setText("");
//            userTxt.setForeground(Color.black);
//        }
//        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
//            passTxt.setText("********");
//            passTxt.setForeground(Color.gray);
//        }
//    }
//    
//    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {
//        if (String.valueOf(passTxt.getPassword()).equals("********")) {
//            passTxt.setText("");
//            passTxt.setForeground(Color.black);
//        }
//        if (userTxt.getText().isEmpty()) {
//            userTxt.setText("Nome do usuario");
//            userTxt.setForeground(Color.gray);
//        }
//    }
    
    public static void main(String[] args) {
        new Login();
    }
}
