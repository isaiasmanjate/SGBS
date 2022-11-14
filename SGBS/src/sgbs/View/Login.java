package sgbs.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sgbs.Controller.ControllerFuncionario;

/**
 *
 * @author Ricardo
 */
public class Login implements ActionListener {

    private JFrame janela;
    private JPanel pGlobal, pPrincipal, loginBtn, loginBtnCancel, pBotoes, pCima;
    private JLabel TitleLabel, favicon, loginBtnTxt, loginBtnCancelTxt;
    private sgbs.View.controles.textfield.PasswordField passTxt;
    private sgbs.View.controles.textfield.TextField userTxt;
    private JButton b_confirmar,b_cancelar;

    public Login() {
        inicializarComponentes();
        configurarComponentes();

        janela.setVisible(true);
        b_confirmar.addActionListener(this);

    }

    public void inicializarComponentes() {
        janela = new JFrame("Login");
        janela.setResizable(false);
         
        
        b_cancelar=new JButton("Cancelar");
        b_confirmar=new JButton("Confirmar");
        pGlobal = new JPanel();
        pPrincipal = new JPanel();
        pBotoes = new JPanel();
        pBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
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

        janela.add(pGlobal);

        pGlobal.setLayout(new BorderLayout());
        pGlobal.add(pCima, BorderLayout.NORTH);
        pGlobal.add(pPrincipal, BorderLayout.CENTER);
        pGlobal.add(pBotoes, BorderLayout.SOUTH);

        configurar_pCima();
        configurar_pPrincipal();
        configurar_pBotoes();
        janela.pack();
        janela.setLocationRelativeTo(null);
    }

    private void configurar_pCima() {
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
        gbc.gridy = 1;
        pPrincipal.add(passTxt, gbc);

        userTxt.setLabelText("Nome do Usuario");
        gbc.gridx = 1;
        userTxt.setPreferredSize(new Dimension(190, 50));
        gbc.gridy = 0;
        pPrincipal.add(userTxt, gbc);

        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridheight = 2;
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/user.png")));
        gbc.gridy = 0;
        pPrincipal.add(favicon, gbc);

    }

    private void configurar_pBotoes() {
        
         //Cancelar
        b_cancelar.setPreferredSize(new Dimension(100, 25));
        b_cancelar.setBackground(new java.awt.Color(0, 134, 190));
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        //Gravar
         b_confirmar.setPreferredSize(new Dimension(100, 25));
        b_confirmar.setBackground(new java.awt.Color(0, 134, 190));
        b_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        
        pBotoes.add(b_cancelar);
        pBotoes.add(b_confirmar);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_confirmar){
            ControllerFuncionario ctrl=new ControllerFuncionario();
            char[] password=passTxt.getPassword();
            String pass="";
            for(int i=0;i<password.length;i++){
                pass+=password[i]+"";
            }
            
            boolean login;
            login=ctrl.login(userTxt.getText(),pass.trim());
            if(login){
             Menu m=new Menu();
             m.b_utlizador.setText(userTxt.getText());
             janela.dispose(); 
             
            }else{
                
                passTxt.setText("");
               JOptionPane.showMessageDialog(null, "Credências Incorretos!");  
            }
            
       

        }
        

    }
}
