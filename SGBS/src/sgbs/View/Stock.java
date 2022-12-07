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
import java.util.Vector;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import sgbs.Controller.ControllerFornecedor;
import sgbs.Controller.ControllerStock;
import sgbs.Model.value_object.Fornecedor;

public class Stock implements ActionListener {

    JFrame frame;
    JPanel global;

    GridBagConstraints constraints = new GridBagConstraints();
    private sgbs.View.controles.combobox.Combobox c_Fornecedor;
    sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_morada, tf_contacto, tf_nuit, tf_codigo, tf_preco, tf_qtd, tf_descricao;
    private JLabel l_Fornecedor, l_morada, l_contacto, l_nuit, l_codigo, l_Descricao, l_Preco_custo, l_qtd, l_icon, l_titulo_frame;
    JButton b_confirmar, b_cancelar, b_terminar, b_procurar;
    private JTable tabela;
    DefaultTableModel t;
    Vector fun;

    public Stock() {
        inicialializarComponentes();
       // configurarFrame();
    }

    public void populaFornecedor() {
        //Popula Familia
        sgbs.Controller.ControllerFornecedor ctrl = new sgbs.Controller.ControllerFornecedor();
        sgbs.Model.value_object.Fornecedor f;
        c_Fornecedor.addItem("");
        int tamanho = ctrl.gerador();
        for (int i = 1; i < tamanho; i++) {
            f = ctrl.getFunById(i);
            c_Fornecedor.addItem(f.getNome());
        }

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
        tf_codigo.setEditable(false);
        tf_descricao = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_descricao.setEditable(false);
        tf_preco = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_preco.setEditable(false);
        tf_qtd = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        tf_qtd.setEditable(false);
        

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
        b_terminar = new JButton("Imprimir");
        b_procurar = new JButton("");
        b_confirmar.setEnabled(false);
        b_terminar.setEnabled(false);
        // b_confirmar.setBorder(null);

        //Inicializar tabela
        t = new DefaultTableModel();
        t.addColumn("Codigo");
        t.addColumn("Cod.Produto");
        t.addColumn("Cod.Fornecedor");
        t.addColumn("Descrição");
        t.addColumn("preço");
        t.addColumn("Quantidade");
        t.addColumn("Total");

        tabela = new JTable(t);
        configurar_tabelas();

        //Listener
        b_cancelar.addActionListener(this);
        b_confirmar.addActionListener(this);
        b_terminar.addActionListener(this);
        b_procurar.addActionListener(this);

        tf_codigo.addActionListener(this);
        populaFornecedor();
        //Eventos
        c_Fornecedor.addActionListener(this);

    }

    private void configurar_tabelas() {
        tabela.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabela.setFillsViewportHeight(true);
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0, 0, 0));
        tabela.setRowHeight(20);
    }

    public void populaProduto() {
        //Popula produto
        sgbs.Controller.ControllerStock ctrl = new sgbs.Controller.ControllerStock();
        sgbs.Model.value_object.Stock f;
        fun = ctrl.listar();

        for (int i = 0; i < fun.size(); i++) {
            //System.out.println("Ola");
            t.addRow((Object[]) fun.elementAt(i));

        }
    }

    public JPanel retornaPainel() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        return global;
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
        constraints.insets = new Insets(2, 2, 3, 2);
        // constraints.fill = GridBagConstraints.BOTH;
        //constraints.weightx=1;
        constraints.weighty = 1;
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
        principal.add(panelB, BorderLayout.SOUTH);

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
        b_procurar.setPreferredSize(new Dimension(25, 20));
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
        if (c_Fornecedor.getSelectedIndex() != 0) {
            int id = c_Fornecedor.getSelectedIndex();
            ControllerFornecedor ctrl = new ControllerFornecedor();
            Fornecedor f;
            f = ctrl.getFunById(id);
            tf_contacto.setText(f.getContacto());
            tf_morada.setText(f.getMorada());
            tf_nuit.setText(f.getNuit() + "");
            //    System.out.println(  c_Fornecedor.getSelectedIndex());
        }

        if (e.getSource() == b_procurar) {
            if (c_Fornecedor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione o fornecedor para avançar");
            } else {
                new Tabela_Produtos(this);
            }
        }
        if (e.getSource() == b_confirmar) {

            ControllerStock ctr = new ControllerStock();
            sgbs.Model.value_object.Stock sf;
            float total = Float.parseFloat(tf_preco.getText()) * Integer.parseInt(tf_qtd.getText());
            boolean scc = false;
            int g = ctr.gerador();

            try {
                //    System.out.println(codigoFamilia + " " + codigoSF + " " + tf_descricao.getText() + " " + preco + tf_validade.getText() + " " + iva);

                scc = ctr.cadastrar(g, Integer.parseInt(tf_codigo.getText()), c_Fornecedor.getSelectedIndex(),
                        tf_descricao.getText(), Float.parseFloat(tf_preco.getText()), Integer.parseInt(tf_qtd.getText()), (float) total);

                //scc=ctr.modificar(Integer.parseInt(tf_codigo.getText()),tf_nome.getText(),tf_contacto.getText(),
                //  tf_morada.getText(),Long.parseLong(tf_nuit.getText()),tf_username.getText(),tf_password.getText(),c_terceiro.getSelectedItem()+"");
                if (scc) {
                     b_terminar.setEnabled(scc);
                    JOptionPane.showMessageDialog(null, "Realizado Com Sucesso!");
                    t.addRow(new Object[]{g, tf_codigo.getText(), c_Fornecedor.getSelectedIndex(), tf_descricao.getText(), Float.parseFloat(tf_preco.getText()), Integer.parseInt(tf_qtd.getText()), total});

                } else {
                    JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO:" + ex);
            }

        }

    }

}
