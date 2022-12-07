package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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
import javax.swing.text.DefaultCaret;
import sgbs.Controller.ControllerCliente;
import sgbs.Controller.ControllerFornecedor;
import sgbs.Model.value_object.Cliente;
import sgbs.Model.value_object.Fornecedor;

/**
 *
 * @author Ricardo
 */
public class Tabela_terceiros implements ActionListener {

    private JFrame frame;
    private JPanel global, p_tabelas;
    private JTabbedPane ConjPanel;
    private JTable tabelaCliente, tabelaFornecedor;
    private JLabel l_pesquisar;
    DefaultTableModel fn1, fn2;
    JScrollPane scrollClient, scrollFornecedor;
    Vector fun1, fun2;
    Terceiro terceiro;

    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_pesquisar;
    sgbs.View.controles.MyButton.MyButtonSubmeter b_selecionar, b_pesquisar;

    public Tabela_terceiros(Terceiro t) {
        inicializarComponentes();
        configurarFrame();
        terceiro=t;

    }

    private void inicializarComponentes() {
        frame = new JFrame("Lista de Terceiros");
        frame.setResizable(false);

        //Inicializar Pineis
        global = new JPanel();
        p_tabelas = new JPanel();

        b_selecionar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_selecionar.setText("Selecionar");
        b_selecionar.setPreferredSize(new Dimension(100, 25));
        b_selecionar.setBackground(new java.awt.Color(0, 134, 190));
        b_selecionar.setForeground(new java.awt.Color(255, 255, 255));
        b_selecionar.setRadius(20);
        b_selecionar.setBorder(null);

        l_pesquisar = new JLabel();
        tf_pesquisar = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();

        //Inicializar TabbedPan  
        ConjPanel = new JTabbedPane();

        //Inicializar tabelas
        fn1 = new DefaultTableModel();
        fn1.addColumn("Codigo");
        fn1.addColumn("Nome");
        fn1.addColumn("Contacto");
        fn1.addColumn("Morada");
        fn1.addColumn("Nuit");

        fn2 = new DefaultTableModel();
        fn2.addColumn("Codigo");
        fn2.addColumn("Nome");
        fn2.addColumn("Contacto");
        fn2.addColumn("Morada");
        fn2.addColumn("Nuit");

        b_pesquisar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_pesquisar.setText("");
        b_pesquisar.setPreferredSize(new Dimension(30, 28));
        b_pesquisar.setBackground(new java.awt.Color(0, 134, 190));
        b_pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        b_pesquisar.setRadius(20);
        b_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/search.png")));
        b_pesquisar.setBorder(null);

        tabelaCliente = new JTable(fn1);
        tabelaFornecedor = new JTable(fn2);
        scrollClient = new JScrollPane(tabelaCliente);
        scrollFornecedor = new JScrollPane(tabelaFornecedor);
        readFornecedor();
        readFCliente();
        ///eventos
        b_pesquisar.addActionListener(this);
        b_selecionar.addActionListener(this);

        configurar_tabelas();
    }

    public void readFornecedor() {
        ControllerFornecedor ctrl = new ControllerFornecedor();
        fun2 = ctrl.listar();
        for (int i = 0; i < fun2.size(); i++) {
            fn2.addRow((Object[]) fun2.elementAt(i));
        }

    }

    public void readFCliente() {
        ControllerCliente ctrl = new ControllerCliente();
        fun1 = ctrl.listar();
        for (int i = 0; i < fun1.size(); i++) {
            fn1.addRow((Object[]) fun1.elementAt(i));
        }

    }

    private Component painelSul() {
        personalizarComponent();

        JPanel principal = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
//        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        // panelB.add(l_pesquisar);
        panelB.add(b_selecionar);

        principal.add(panelB, BorderLayout.EAST);

        return principal;
    }

    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(configurar_JTabbedPane(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
    public Tabela_terceiros(){
        
    }

    private void personalizarComponent() {
        //Descricao
        l_pesquisar.setFont(new java.awt.Font("Roboto Light", 1, 14));
        l_pesquisar.setForeground(new java.awt.Color(0, 0, 0));
        l_pesquisar.setText("Pesquisar");
        tf_pesquisar.setForeground(new java.awt.Color(0, 0, 0));
        tf_pesquisar.setPreferredSize(new Dimension(150, 35));
    }

    private Component painelNorte() {
        personalizarComponent();

        JPanel principal = new JPanel();
        JPanel panelB = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
//        principal.setBorder(BorderFactory.createTitledBorder("Lista de bebidas"));
        principal.setBackground(new java.awt.Color(255, 255, 255));
        panelB.setBackground(new java.awt.Color(255, 255, 255));
        panelB.add(l_pesquisar);
        panelB.add(tf_pesquisar);
        panelB.add(b_pesquisar);

        principal.add(panelB, BorderLayout.CENTER);

        return principal;
    }

    private void configurar_tabelas() {
        //configurar tabela cliente
        tabelaCliente.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabelaCliente.setFillsViewportHeight(true);
//        tabelaCliente.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabelaCliente.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaCliente.getTableHeader().setOpaque(false);
        tabelaCliente.getTableHeader().setBackground(new Color(200, 200, 200));
        tabelaCliente.getTableHeader().setForeground(new Color(0, 0, 0));
        tabelaCliente.setRowHeight(20);

        //configurar tabela Fornecedor
        tabelaFornecedor.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabelaFornecedor.setFillsViewportHeight(true);
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabelaFornecedor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaFornecedor.getTableHeader().setOpaque(false);
        tabelaFornecedor.getTableHeader().setBackground(new Color(200, 200, 200));
        tabelaFornecedor.getTableHeader().setForeground(new Color(0, 0, 0));
        tabelaFornecedor.setRowHeight(20);
    }

    private Component configurar_JTabbedPane() {
        p_tabelas.setLayout(new BorderLayout());
        p_tabelas.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        p_tabelas.add(ConjPanel, BorderLayout.CENTER);
        p_tabelas.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.addTab("Clientes", configurar_TabelaCliente());
        ConjPanel.addTab("Fornecedores", configurar_TabelaFornecedor());

        return p_tabelas;
    }

    public Component configurar_TabelaCliente() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane = new JScrollPane(tabelaCliente);
        scrollPane.setPreferredSize(new Dimension(750, 340));

        tabelaCliente.setFocusable(false);
        tabelaCliente.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaCliente.setRowHeight(20);
        tabelaCliente.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        lista.add(scrollPane);

        return lista;
    }

    public Component configurar_TabelaFornecedor() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane = new JScrollPane(tabelaFornecedor);
        scrollPane.setPreferredSize(new Dimension(750, 340));

        tabelaFornecedor.setFocusable(false);
        tabelaFornecedor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaFornecedor.setRowHeight(20);
        tabelaFornecedor.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabelaFornecedor.getTableHeader().setReorderingAllowed(false);
        lista.add(scrollPane);

        return lista;
    }

    public static void main(String[] args) {
        new Tabela_terceiros(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b_pesquisar) {

            if (!tf_pesquisar.getText().equalsIgnoreCase("")) {
                ControllerCliente ctrc = new ControllerCliente();
                ControllerFornecedor ctrg = new ControllerFornecedor();

                int id = Integer.parseInt(tf_pesquisar.getText());
                boolean scc;
                if (ConjPanel.getSelectedIndex() == 0) {
                    scc = ctrc.encontrar(id);
                    if (scc) {
                        tabelaCliente.setRowSelectionInterval(id - 1, id - 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não Encontrado!");

                    }

                }else{
                          scc = ctrc.encontrar(id);
                    if (scc) {
                        tabelaCliente.setRowSelectionInterval(id - 1, id - 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Fornecedor não Encontrado!");

                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Campo pesquisa vazio!");
            }
        }
        if(b_selecionar==e.getSource()){
               if (ConjPanel.getSelectedIndex() == 0){
               int index=  tabelaCliente.getSelectedRow();
            ControllerCliente ctrl=new ControllerCliente();
             Cliente f=ctrl.getFunById(index+1);
             terceiro.tf_codigo.setText(f.getCodigo()+"");
             terceiro.tf_contacto.setText(f.getContacto());
             terceiro.tf_nome.setText(f.getNome());
             terceiro.tf_morada.setText(f.getMorada());
             terceiro.tf_nuit.setText(f.getNuit()+"");
            // terceiro.b_gravar.setText("Editar");
             terceiro.c_terceiro.setSelectedIndex(2);
             
             frame.dispose();
            
               }else{
                       int index=  tabelaFornecedor.getSelectedRow();
            ControllerFornecedor ctrl=new ControllerFornecedor();
             Fornecedor f=ctrl.getFunById(index+1);
             terceiro.tf_codigo.setText(f.getCodigo()+"");
             terceiro.tf_contacto.setText(f.getContacto());
             terceiro.tf_nome.setText(f.getNome());
             terceiro.tf_morada.setText(f.getMorada());
             terceiro.tf_nuit.setText(f.getNuit()+"");
             terceiro.c_terceiro.setSelectedIndex(1);
            // terceiro.b_gravar.setText("Editar");
             
             
             frame.dispose(); 
               }
            
      
        }
    }
}
