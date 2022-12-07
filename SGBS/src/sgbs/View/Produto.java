/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import sgbs.Controller.ControllerFamilia;
import sgbs.Controller.ControllerProduto;
import sgbs.Controller.ControllerSubFamilia;

/**
 *
 * @author Ricardo
 */
public class Produto implements ActionListener {

    private GridBagConstraints constraints = new GridBagConstraints();
    private JFrame frame;
    private JPanel global, p_Tabbeb;
    private JLabel l_descricao, l_codigo, l_familia, l_subFamilia, l_tipo, l_iva, l_preco_1, l_validade, l_IVA, l_semIVA, l_comIVA, favicon, l_titulo_frame, loginBtnCancelTxt, loginBtnSalvarTxt, loginBtnSalvarAddTxt, espaco;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_descricao, tf_codigo, tf_preco_11, tf_preco_12, tf_validade;
    private sgbs.View.controles.combo_suggestion.ComboBoxSuggestion c_familia, c_subFamilia, c_tipo, c_iva;
    private JButton b_cancelar, b_terminar;
    private JCheckBox inativoCheck;
    private JTabbedPane ConjPanel;
    JTable tabela;
    DefaultTableModel fn;
    JScrollPane scrollProduto;
    Vector fun;
    ViewFuncionario funcionario;

    public Produto() {
        inicializarComponentes();
        //configurarFrame();

    }
        public void readProduto(){ 
        ControllerProduto ctrl =new ControllerProduto();
         fun=ctrl.listar();
        for(int i=0;i<fun.size();i++)
            fn.addRow((Object[]) fun.elementAt(i));
        
    }

    private void inicializarComponentes() {
        frame = new JFrame("Cadastrar Produto");
        frame.setResizable(false);

        //Inicializar Pineis
        global = new JPanel();
        p_Tabbeb = new JPanel();

        //Inicializar Lables
        l_descricao = new JLabel();
        l_codigo = new JLabel();
        l_familia = new JLabel();
        l_subFamilia = new JLabel();
        l_tipo = new JLabel();
        l_iva = new JLabel();
        l_preco_1 = new JLabel();
        l_validade = new JLabel();
        l_IVA = new JLabel();
        l_semIVA = new JLabel();
        l_comIVA = new JLabel();
        favicon = new JLabel();
        l_titulo_frame = new JLabel();
        espaco = new JLabel();
        loginBtnCancelTxt = new JLabel();
        loginBtnSalvarTxt = new JLabel();
        loginBtnSalvarAddTxt = new JLabel();

        //Inicializar text field
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_codigo = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_preco_11 = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_preco_12 = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_validade = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();

        //Inicializar ComboBox
        c_familia = new sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        c_subFamilia = new sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        c_iva = new sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();
        c_tipo = new sgbs.View.controles.combo_suggestion.ComboBoxSuggestion();

        //add Item to Iva
        c_iva.addItem("0%");
        c_iva.addItem("16%");

        //add item to unidade
        c_tipo.addItem("l");
        c_tipo.addItem("emb");
        c_tipo.addItem("cx");

        //Inicializar Button
        b_cancelar = new JButton("Editar");
        b_terminar = new JButton("Gravar");

        //Inicializar CheckBox 
        inativoCheck = new JCheckBox("Inativo");

        //Inicializar TabbedPan  
        ConjPanel = new JTabbedPane();

        //Inicializar tabelas
        fn = new DefaultTableModel();
        fn.addColumn("Codigo");
        fn.addColumn("Familia");
        fn.addColumn("SubFamilia");
        fn.addColumn("Descrição");
        fn.addColumn("Preço");
        fn.addColumn("Qtd");
        tabela = new JTable(fn);
        
        tf_codigo.setEnabled(false);
        
        scrollProduto = new JScrollPane(tabela);
        configurar_JTable();
        populaFamilia();
        c_familia.addActionListener(this);

        b_terminar.addActionListener(this);
        
         readProduto();

    }

    public void populaFamilia() {
        //Popula Familia
        sgbs.Controller.ControllerFamilia ctrl = new sgbs.Controller.ControllerFamilia();
        sgbs.Model.value_object.Familia f;
        c_familia.addItem("");
        int tamanho = ctrl.gerador();
        for (int i = 1; i < tamanho; i++) {
            f = ctrl.getFamById(i);
            c_familia.addItem(f.getNome());
        }

    }

    public void populaSubFamilia(int idFamilia) {
        sgbs.Controller.ControllerSubFamilia ctrl = new sgbs.Controller.ControllerSubFamilia();
        sgbs.Model.value_object.SubFamilia sf;
        int size = ctrl.gerador();

        for (int i = 1; i < size; i++) {

            sf = ctrl.getSubFamById(i);
            if (idFamilia == sf.getCodigo()) {

                c_subFamilia.addItem(sf.getSubFamilia_nome());
            }
        }
    }

    public JPanel retornaPainel() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(configurar_JTabbedPane(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        return global;
    }

    private void configurarFrame() {
       // retornaPainel();
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
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/produto.png")));
        favicon.setText(" ");
        l_titulo_frame.setFont(new java.awt.Font("Roboto Black", 1, 24));
        l_titulo_frame.setText("Produto");
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

        //adicionar atributos da bebida
        addGB(panel, l_descricao, 0, 1);
        addGB(panel, l_codigo, 0, 2);
        addGB(panel, l_familia, 0, 3);
        addGB(panel, l_subFamilia, 0, 4);
        addGB(panel, l_tipo, 2, 2);
        addGB(panel, l_iva, 2, 3);

        addGB(panel, tf_codigo, 1, 2);
        addGB(panel, c_familia, 1, 3);
        addGB(panel, c_subFamilia, 1, 4);
        addGB(panel, c_tipo, 3, 2);
        addGB(panel, c_iva, 3, 3);

        //adicionar atributos da Preco
        addGB(panelB, l_preco_1, 0, 1);
        addGB(panelB, l_validade, 0, 2);
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panelB, tf_preco_11, 1, 1);
        addGB(panelB, tf_preco_12, 2, 1);
        addGB(panelB, tf_validade, 1, 2);
        //addGB(panelB, tf_preco_22, 2, 2);
        addGB(panelB, espaco, 0, 3);
        constraints.anchor = GridBagConstraints.LINE_END;
        addGB(panelB, l_semIVA, 1, 0);
        addGB(panelB, l_comIVA, 2, 0);

        //adicionar atributo descricao no painel Bebebidas
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addGB(panel, tf_descricao, 1, 1);
        addGB(panel, inativoCheck, 4, 1);

        principal.add(panel, BorderLayout.NORTH);
        principal.add(panelB, BorderLayout.CENTER);

        return principal;
    }

    private void configurar_JTable() {
        tabela.setPreferredScrollableViewportSize(new Dimension(1050, 370));
        tabela.setFillsViewportHeight(true);
        tabela.getTableHeader().setPreferredSize(new Dimension(1200, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0, 0, 0));
        tabela.setRowHeight(20);
    }

    private Component configurar_JTabbedPane() {
        p_Tabbeb.setLayout(new BorderLayout());
        p_Tabbeb.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        p_Tabbeb.add(ConjPanel, BorderLayout.CENTER);
        p_Tabbeb.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.addTab("Cadastro", painelCentro());
        ConjPanel.addTab("Lista", configurar_listaJPanel());

        return p_Tabbeb;
    }

    public Component configurar_listaJPanel() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        // JScrollPane scrollPane = new JScrollPane(tabela);
        // scrollPane.setPreferredSize(new Dimension(750, 340));

        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        lista.add(scrollProduto);

        return lista;
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

    private void personalizarComponent() {

        //Espaco
        espaco.setText("       ");

        //Descricao
        l_descricao.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_descricao.setForeground(new java.awt.Color(0, 0, 0));
        l_descricao.setText("Descrição");
        tf_descricao.setForeground(new java.awt.Color(0, 0, 0));
        tf_descricao.setPreferredSize(new Dimension(150, 35));

        //Codigo
        l_codigo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_codigo.setForeground(new java.awt.Color(0, 0, 0));
        l_codigo.setText("Codigo");
        tf_codigo.setForeground(new java.awt.Color(0, 0, 0));
        tf_codigo.setPreferredSize(new Dimension(150, 35));

        //Famimlia
        l_familia.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_familia.setForeground(new java.awt.Color(0, 0, 0));
        l_familia.setText("Familia");
        c_familia.setForeground(new java.awt.Color(0, 0, 0));
        c_familia.setPreferredSize(new Dimension(150, 35));

        //Sub Familia
        l_subFamilia.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_subFamilia.setForeground(new java.awt.Color(0, 0, 0));
        l_subFamilia.setText("Sub Familia");
        c_subFamilia.setForeground(new java.awt.Color(0, 0, 0));
        c_subFamilia.setPreferredSize(new Dimension(150, 35));

        //Tipo
        l_tipo.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_tipo.setForeground(new java.awt.Color(0, 0, 0));
        l_tipo.setText("Unidade");
        c_tipo.setForeground(new java.awt.Color(0, 0, 0));
        c_tipo.setPreferredSize(new Dimension(150, 35));

        //Iva
        l_iva.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_iva.setForeground(new java.awt.Color(0, 0, 0));
        l_iva.setText("IVA");
        c_iva.setForeground(new java.awt.Color(0, 0, 0));
        c_iva.setPreferredSize(new Dimension(150, 35));

        //Preco Venda 1
        l_preco_1.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_preco_1.setForeground(new java.awt.Color(0, 0, 0));
        l_preco_1.setText("Preço venda 1");
        tf_preco_12.setPreferredSize(new Dimension(150, 35));
        tf_preco_11.setForeground(new java.awt.Color(0, 0, 0));

        //Validade
        l_validade.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_validade.setForeground(new java.awt.Color(0, 0, 0));
        l_validade.setText("Validade");
        tf_validade.setPreferredSize(new Dimension(150, 35));

        //Sem Iva
        l_semIVA.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_semIVA.setForeground(new java.awt.Color(0, 0, 0));
        l_semIVA.setText("s/IVA");

        //Com iva
        l_comIVA.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_comIVA.setForeground(new java.awt.Color(0, 0, 0));
        l_comIVA.setText("IVA Inc.");

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

        //Inativo
        inativoCheck.setFont(new java.awt.Font("Roboto Light", 1, 14));
        inativoCheck.setForeground(new java.awt.Color(0, 0, 0));

    }

    public static void main(String[] args) {
        new Produto();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Calculo de IVA
        float iva = 0;
        if (c_iva.getSelectedIndex() == 1) {
            iva = (float) 0.16;

        }

        int codigoFamilia = 0;
        //Popula Cbo subFamilia
        if (c_familia.getSelectedIndex() != 0) {
            c_subFamilia.removeAllItems();
            String familia = c_familia.getSelectedItem().toString().trim();
            ControllerFamilia ctr = new ControllerFamilia();
            sgbs.Model.value_object.Familia f;
            codigoFamilia = 0;
            int size = ctr.gerador();
            for (int i = 1; i < size; i++) {
                f = ctr.getFamById(i);
                if (f.getNome().equalsIgnoreCase(familia)) {
                    codigoFamilia = f.getCodigo();
                }
            }

            populaSubFamilia(codigoFamilia);
        }

        //Gravar dados na base de dados
        if (e.getSource() == b_terminar) {
            float preco = Float.parseFloat(tf_preco_11.getText()) * iva + Float.parseFloat(tf_preco_11.getText());
            int codigoSF = 0;
            String subfamilia = c_subFamilia.getSelectedItem().toString().trim();
            // System.out.println(subfamilia);
            ControllerSubFamilia ctr = new ControllerSubFamilia();
            sgbs.Model.value_object.SubFamilia sf;
            int size = ctr.gerador();
            //  System.out.println(size);
            for (int i = 1; i < size; i++) {
                sf = ctr.getSubFamById(i);
                if (sf.getSubFamilia_nome().trim().equalsIgnoreCase(subfamilia)) {
                    codigoSF = sf.getCodigo_subfamilia();

                }
            }

            //
            boolean scc = false;
            ControllerProduto ctrl = new ControllerProduto();

            try {
                System.out.println(codigoFamilia + " " + codigoSF + " " + tf_descricao.getText() + " " + preco + tf_validade.getText() + " " + iva);

                if (b_terminar.getText().equalsIgnoreCase("Gravar")) {
                    scc = ctrl.cadastrar(ctrl.gerador(), codigoFamilia, codigoSF,
                            tf_descricao.getText(), preco, 0, tf_validade.getText(), (float) iva);
                } else {

                    //scc=ctr.modificar(Integer.parseInt(tf_codigo.getText()),tf_nome.getText(),tf_contacto.getText(),
                    //  tf_morada.getText(),Long.parseLong(tf_nuit.getText()),tf_username.getText(),tf_password.getText(),c_terceiro.getSelectedItem()+"");
                }
                if (scc) {
                  

                    JOptionPane.showMessageDialog(null, "Realizado Com Sucesso!");
                      tabela.removeAll();
                     configurar_JTable();
                     readProduto();
                     tf_descricao.setText("");
                     tf_preco_11.setText("");
                     tf_validade.setText("");
                   // this.frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO:" + ex);
            }

        }

    }
}
