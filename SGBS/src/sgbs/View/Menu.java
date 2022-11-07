/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgbs.View;

/**
 *
 * @author Manjate
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Menu implements ActionListener {

    JFrame frame;
    JPanel Global;

    JButton b_home, b_vendas, b_terceiros, b_artigos, b_listagens, b_configuracoes, b_stock, b_sair, b_home_closed, b_utlizador;
    GridBagConstraints constraints = new GridBagConstraints();
    Color cor = new Color(0, 134, 190);
    Color color = new Color(255, 255, 255);
    Color corPainel = new Color(60, 63, 65);
    JLabel l_logotipo;

    //Stock stock=new Stock();
    public Menu() {
        inicializarComponents();
        configurarFrame();

    }

    private void inicializarComponents() {
        frame = new JFrame("Sistema de Gestão de Bottle Store");

        //Inicializar Botoes
        b_home = new JButton("Página inicial");
        b_vendas = new JButton("Vendas");
        b_terceiros = new JButton("Terceiros");
        b_artigos = new JButton("Artigos");
        b_listagens = new JButton("Listagens");
        b_home_closed = new JButton();
        b_configuracoes = new JButton("Configurações");
        b_stock = new JButton("Estoque");
        b_sair = new JButton("Sair");
        b_utlizador = new JButton("manjate");

        //Action Listener
        b_stock.addActionListener(this);
        b_home.addActionListener(this);
        b_sair.addActionListener(this);
        b_utlizador.addActionListener(this);
        b_configuracoes.addActionListener(this);
        b_listagens.addActionListener(this);
        b_vendas.addActionListener(this);
        b_artigos.addActionListener(this);
        b_terceiros.addActionListener(this);
        b_home_closed.addActionListener(this);
        

        //Label
        l_logotipo = new JLabel("Alex Bottle Store");

      
    }

    private void configurarFrame() {
        Global = new JPanel();
        Global.setLayout(new BorderLayout());
        Global.add(westPainel(), BorderLayout.WEST);
        Global.add(northPainel(), BorderLayout.NORTH);
        Global.setBackground(color);
        frame.add(Global);
        frame.setFont(new java.awt.Font("Roboto Light", 1, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private Component northPainel() {
        JPanel principal = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
        panelB.add(b_utlizador);
        panelA.add(l_logotipo);

        principal.setLayout(new BorderLayout());
        principal.setBackground(corPainel);
        panelB.setBackground(corPainel);
        panelA.setBackground(corPainel);
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));

        principal.add(panelB, BorderLayout.EAST);
        principal.add(panelA, BorderLayout.WEST);
        principal.setVisible(true);
        return principal;
    }

    private void personalizarBotoes() {
        Font ft = new Font("Courier", Font.BOLD, 16);
        Font ftl = new Font("Ravie", Font.BOLD, 30);
        //Artigos
        b_artigos.setPreferredSize(new Dimension(200, 30));
        b_artigos.setBackground(cor);
        b_artigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/artigos.png")));
        b_artigos.setFont((ft));
        b_artigos.setForeground(new java.awt.Color(255, 255, 255));
        b_artigos.setBorder(null);
        b_artigos.setHorizontalAlignment(SwingConstants.LEFT);

        //User
        b_utlizador.setBackground(corPainel);
        b_utlizador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/utilizador.png")));
        b_utlizador.setFont((ft));
        b_utlizador.setForeground(cor);
        b_utlizador.setBorder(null);
        b_utlizador.setHorizontalAlignment(SwingConstants.LEFT);

        //Definicoes
        b_configuracoes.setPreferredSize(new Dimension(200, 30));
        b_configuracoes.setBackground(cor);
        b_configuracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/configuracoes.png")));
        b_configuracoes.setFont((ft));
        b_configuracoes.setForeground(new java.awt.Color(255, 255, 255));
        b_configuracoes.setBorder(null);
        b_configuracoes.setHorizontalAlignment(SwingConstants.LEFT);
        //Home
        b_home.setPreferredSize(new Dimension(200, 30));
        b_home.setHorizontalAlignment(SwingConstants.LEFT);
        b_home.setBackground(cor);
        b_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home.png")));
        b_home.setFont((ft));
        b_home.setForeground(new java.awt.Color(255, 255, 255));
        b_home.setBorder(null);

        //Listagem
        b_listagens.setPreferredSize(new Dimension(200, 30));
        b_listagens.setBackground(cor);
        b_listagens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/listagem.png")));
        b_listagens.setFont((ft));
        b_listagens.setForeground(new java.awt.Color(255, 255, 255));
        b_listagens.setBorder(null);
        b_listagens.setHorizontalAlignment(SwingConstants.LEFT);
        //Home_closed
        b_home_closed.setBackground(cor);
        b_home_closed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/home_closed.png")));
        b_home_closed.setFont((ft));
        b_home_closed.setForeground(new java.awt.Color(255, 255, 255));
        b_home_closed.setBorder(null);

        //Exit
        b_sair.setPreferredSize(new Dimension(200, 30));
        b_sair.setBackground(cor);
        b_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/LogOff.png")));
        b_sair.setFont((ft));
        b_sair.setForeground(new java.awt.Color(255, 255, 255));
        b_sair.setBorder(null);
        b_sair.setHorizontalAlignment(SwingConstants.LEFT);
        //Stock
        b_stock.setPreferredSize(new Dimension(200, 30));
        b_stock.setBackground(cor);
        b_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/Entrada_.png")));
        b_stock.setFont((ft));
        b_stock.setForeground(new java.awt.Color(255, 255, 255));
        b_stock.setBorder(null);
        b_stock.setHorizontalAlignment(SwingConstants.LEFT);

        //Terceiros
        b_terceiros.setPreferredSize(new Dimension(200, 30));
        b_terceiros.setBackground(cor);
        b_terceiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/terceiros.png")));
        b_terceiros.setFont((ft));
        b_terceiros.setForeground(new java.awt.Color(255, 255, 255));
        b_terceiros.setBorder(null);
        b_terceiros.setHorizontalAlignment(SwingConstants.LEFT);

        //Vendas
        b_vendas.setPreferredSize(new Dimension(200, 30));
        b_vendas.setBackground(cor);
        b_vendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/vendas.png")));
        b_vendas.setFont((ft));
        b_vendas.setForeground(new java.awt.Color(255, 255, 255));
        b_vendas.setBorder(null);
        b_vendas.setHorizontalAlignment(SwingConstants.LEFT);

        //LogoTipo
        l_logotipo.setBackground(corPainel);
        l_logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/Logo_home.png")));
        l_logotipo.setFont((ftl));
        l_logotipo.setForeground(new java.awt.Color(255, 255, 255));
        l_logotipo.setBorder(null);
        l_logotipo.setHorizontalAlignment(SwingConstants.LEFT);

    }

    private Component westPainel() {

        constraints.insets = new Insets(0, 0, 20, 0);
        personalizarBotoes();
        JPanel panel = new JPanel();
        JPanel principal = new JPanel();
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane.setBackground(cor);
        pane.setBorder(null);
        pane.add(b_home_closed);
        principal.setLayout(new BorderLayout());
        principal.setBackground(cor);
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        panel.setLayout(new GridBagLayout());
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.setBackground(cor);
        addGB(panel, b_home, 0, 0);
        addGB(panel, b_vendas, 0, 1);
        addGB(panel, b_artigos, 0, 2);
        addGB(panel, b_terceiros, 0, 3);
        addGB(panel, b_listagens, 0, 4);
        addGB(panel, b_stock, 0, 5);
        addGB(panel, b_configuracoes, 0, 6);
        addGB(panel, new JLabel(" "), 0, 7);
        addGB(panel, new JLabel(" "), 0, 8);
        addGB(panel, b_sair, 0, 9);
        principal.add(panel, BorderLayout.CENTER);
        principal.add(pane, BorderLayout.NORTH);
        principal.setEnabled(false);
        return principal;

    }

    private void addGB(JPanel panel, Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);

    }

    public static void main(String[] args) {
        new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_stock) {
             new Stock();
        }else if(e.getSource()==b_artigos){
            new Produto();
        }else if(e.getSource()==b_utlizador){
            new Login();
            frame.dispose();
        }else if(e.getSource()==b_terceiros){
            new Terceiro();
        }else if(e.getSource()==b_sair){
            frame.dispose();
        }else if(e.getSource()==b_vendas){
            new Venda();
        }
            
    }

}
