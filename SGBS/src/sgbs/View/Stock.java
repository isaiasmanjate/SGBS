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

public class Stock implements ActionListener {

    JFrame frame;
    JPanel global;

    GridBagConstraints constraints = new GridBagConstraints();
    private sgbs.View.controles.combobox.Combobox c_Fornecedor;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_morada, tf_contacto, tf_nuit, tf_codigo, tf_preco, tf_qtd, tf_descricao;
    private JLabel l_Fornecedor, l_morada, l_contacto, l_nuit, l_codigo, l_Descricao, l_Preco_custo, l_qtd, l_icon, l_titulo_frame;
    private JButton b_confirmar, b_cancelar, b_terminar, b_procurar;
    private JTable tabela;

    public Stock() {
        inicialializarComponentes();
        configurarFrame();
    }

    private void inicialializarComponentes() {
        frame = new JFrame("Entrada de Stock");

        //Inicializar ComboBox
        c_Fornecedor = new sgbs.View.controles.combobox.Combobox();
        c_Fornecedor.setSelectedIndex(-1);
        c_Fornecedor.setLabeText("Fornecedor");

        //Inicializar text field
        tf_morada = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_contacto = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_nuit = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_codigo = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_preco = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_qtd = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();

        //Inicializar Labels
        // l_Fornecedor = new JLabel("Fornecedor");
        l_Descricao = new JLabel("Descrição");
        l_Preco_custo = new JLabel("Preço custo");
        l_codigo = new JLabel("Codigo");
        l_contacto = new JLabel("Contacto");
        l_morada = new JLabel("Morada");
        l_nuit = new JLabel("Nuit");
        l_qtd = new JLabel("Quantidade");
        l_icon = new JLabel();
        l_titulo_frame = new JLabel();

        //Inicializar Botoes
        b_cancelar = new JButton("Cancelar");
        b_confirmar = new JButton("Confirmar");
        b_terminar = new JButton("Gravar");
        b_procurar = new JButton("");
        // b_confirmar.setBorder(null);

        //Inicializar tabela
        String[] header = {"Codigo", "Fornecedor", "Descrição", "Preço", "Qtd", "Total"};
        Object[][] items = {{"001", "CDM", "Bebida", "0,00MT", "1.0", "0,00MT"}};
        tabela = new JTable(items, header);

        //Listener
        b_cancelar.addActionListener(this);
        b_confirmar.addActionListener(this);
        b_terminar.addActionListener(this);
        b_procurar.addActionListener(this);
        
        tf_codigo.addActionListener(this);

    }

    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        frame.add(global);
        //frame.setResizable(false);
        //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Stock();
    }

    private Component painelNorte() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        l_icon.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/Entrada_Stock.png")));
        l_icon.setText(" ");
        l_titulo_frame.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_titulo_frame.setText("Entrada de Stock");
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
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        panelB.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        principal.setBorder(BorderFactory.createTitledBorder("Dados"));

        panelB.setLayout(new GridBagLayout());
        panel.setLayout(new GridBagLayout());
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        constraints.insets = new Insets(12, 10, 0, 10);
        constraints.fill = GridBagConstraints.BOTH;
//        constraints.weightx=1;
//        constraints.weighty=1;
        //adicionar informacoes do fornecedor
        constraints.anchor = GridBagConstraints.LINE_START;

        //addGB(panel, new JLabel(" "), 0, 0);
        addGB(panel, c_Fornecedor, 0, 1);
        addGB(panel, l_contacto, 1, 0);
        addGB(panel, tf_contacto, 1, 1);
        addGB(panel, l_morada, 2, 0);
        addGB(panel, tf_morada, 2, 1);
        addGB(panel, l_nuit, 3, 0);
        addGB(panel, tf_nuit, 3, 1);
        addGB(panel, new JLabel(" "), 0, 2);

        //adicionar atributos da bebida
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;
        addGB(panelB, l_codigo, 0, 0);
        addGB(panelB, tf_codigo, 1, 0);
        addGB(panelB, b_procurar, 2, 0);
        addGB(panelB, l_Descricao, 0, 1);
        addGB(panelB, tf_descricao, 1, 1);
        addGB(panelB, l_Preco_custo, 0, 2);
        addGB(panelB, tf_preco, 1, 2);
        addGB(panelB, l_qtd, 3, 0);
        addGB(panelB, tf_qtd, 3, 1);
        addGB(panelB, b_confirmar, 3, 2);
        addGB(panelB, new JLabel(" "), 3, 3);

        principal.add(panel, BorderLayout.NORTH);
        principal.add(panelB, BorderLayout.CENTER);
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
        // panelB.setLayout(new GridBagLayout());
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelA.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        panelA.setLayout(new BorderLayout());
        panelA.setPreferredSize(new Dimension(500, 150));
        panelA.add(new JScrollPane(tabela));
        principal.add(panelA, BorderLayout.NORTH);

        panelB.add(b_cancelar);
        panelB.add(b_terminar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }

    private void personalizarComponent() {
        //Tabela
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
        //fornecedor
        // l_Fornecedor.setFont(new java.awt.Font("Roboto Light", 1, 14));
        c_Fornecedor.setForeground(new java.awt.Color(0, 0, 0));
        c_Fornecedor.setPreferredSize(new Dimension(150, 32));
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
        tf_nuit.setPreferredSize(new Dimension(150, 30));
        //Codigo
        l_codigo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_codigo.setForeground(new java.awt.Color(0, 0, 0));
        tf_codigo.setPreferredSize(new Dimension(150, 30));
        //Procurar
        b_procurar.setPreferredSize(new Dimension(28, 25));
        b_procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/listagem.png")));
        b_procurar.setBackground(new java.awt.Color(0, 134, 190));

        //Descricao
        l_Descricao.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        tf_descricao.setPreferredSize(new Dimension(150, 30));
        //Preco
        l_Preco_custo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_preco.setForeground(new java.awt.Color(0, 0, 0));
        tf_preco.setPreferredSize(new Dimension(150, 30));
        //Quantidade
        l_qtd.setFont(new java.awt.Font("Roboto Light", 1, 14));
        tf_qtd.setForeground(new java.awt.Color(0, 0, 0));
        tf_qtd.setPreferredSize(new Dimension(150, 30));
        //Confirmar
        b_confirmar.setPreferredSize(new Dimension(100, 25));
        b_confirmar.setBackground(new java.awt.Color(0, 134, 190));
        b_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        //Terminar
        b_terminar.setPreferredSize(new Dimension(150, 25));
        b_terminar.setBackground(new java.awt.Color(0, 134, 190));
        b_terminar.setForeground(new java.awt.Color(255, 255, 255));
        //Cancelar
        b_cancelar.setPreferredSize(new Dimension(150, 25));
        b_cancelar.setBackground(new java.awt.Color(0, 134, 190));
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_cancelar) {
            frame.dispose();
       
       
    }
    }

}
