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
import sgbs.Controller.ControllerProduto;
import sgbs.Controller.ControllerStock;

/**
 *
 * @author Ricardo
 */
public class Tabela_Produtos_Venda implements ActionListener {

     JFrame frame;
     JPanel global;
     JTable tabela;
     JLabel l_pesquisar;
     sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_pesquisar;
    sgbs.View.controles.MyButton.MyButtonSubmeter b_selecionar, b_pesquisar;
    DefaultTableModel t;
    JScrollPane s;
    Vector fun;
    Venda venda;

    public Tabela_Produtos_Venda(Venda venda) {
        inicializarComponentes();
        configurarFrame();
        this.venda= venda;
    }

    public void populaProduto() {
        //Popula Familia
        sgbs.Controller.ControllerProduto ctrl = new sgbs.Controller.ControllerProduto();
        sgbs.Model.value_object.Produto f;
        fun = ctrl.listarP();

        for (int i = 0; i < fun.size(); i++) {
            //System.out.println("Ola");
            t.addRow((Object[]) fun.elementAt(i));
            
        }
    }

    public Tabela_Produtos_Venda() {

    }

    private void inicializarComponentes() {
        frame = new JFrame();
        frame.setResizable(false);

        //Inicializar Pineis
        global = new JPanel();

        b_pesquisar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_pesquisar.setText("");
        b_pesquisar.setPreferredSize(new Dimension(30, 28));
        b_pesquisar.setBackground(new java.awt.Color(0, 134, 190));
        b_pesquisar.setForeground(new java.awt.Color(255, 255, 255));
        b_pesquisar.setRadius(20);
        b_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sgbs/View/images/search.png")));
        b_pesquisar.setBorder(null);

        b_selecionar = new sgbs.View.controles.MyButton.MyButtonSubmeter();
        b_selecionar.setText("Selecionar");
        b_selecionar.setPreferredSize(new Dimension(100, 25));
        b_selecionar.setBackground(new java.awt.Color(0, 134, 190));
        b_selecionar.setForeground(new java.awt.Color(255, 255, 255));
        b_selecionar.setRadius(20);
        b_selecionar.setBorder(null);

        l_pesquisar = new JLabel();
        tf_pesquisar = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();

        //Inicializar tabelas
        //Tabela Model
        t = new DefaultTableModel();
        t.addColumn("Codigo");
        t.addColumn("Familia");
        t.addColumn("SubFamilia");
        t.addColumn("Descrição");
        t.addColumn("Preço");
        t.addColumn("Quantidade");

        tabela = new JTable(t);
        s = new JScrollPane(tabela);

        populaProduto();
        configurar_tabelas();
        //eventos
        b_pesquisar.addActionListener(this);
        b_selecionar.addActionListener(this);
       
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
        global.add(configurar_TabelaCliente(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);
        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
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
        tabela.setPreferredScrollableViewportSize(new Dimension(900, 200));
        tabela.setFillsViewportHeight(true);
        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0, 0, 0));
        tabela.setRowHeight(20);
    }

    public Component configurar_TabelaCliente() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.CENTER));
        JScrollPane scrollPane = new JScrollPane(tabela);
        //scrollPane.setPreferredSize(new Dimension(1000, 340));

        tabela.setFocusable(false);
        tabela.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabela.setRowHeight(20);
        tabela.setSelectionBackground(new java.awt.Color(101, 170, 239));
//        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        lista.add(scrollPane);

        return lista;
    }

    public static void main(String[] args) {
        new Tabela_Produtos_Venda(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b_pesquisar) {

            if (!tf_pesquisar.getText().equalsIgnoreCase("")) {
                ControllerProduto ctrc = new ControllerProduto();

                int id = Integer.parseInt(tf_pesquisar.getText());
                boolean scc;

                scc = ctrc.encontrar(id);
                if (scc) {
                    tabela.setRowSelectionInterval(id - 1, id - 1);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não Encontrado!");

                }
            }else{
                 JOptionPane.showMessageDialog(null, "Preencha o campo Pesquisa");
            }

        }
        if(e.getSource()==b_selecionar){
             int index=  tabela.getSelectedRow();
            ControllerProduto ctrl=new ControllerProduto();
             sgbs.Model.value_object.Produto f=ctrl.getFunById(index+1);
             venda.tf_codigo.setText(f.getId_produto()+"");
             venda.tf_descricao.setText(f.getDescricao());
             venda.tf_preco.setText(f.getPreco_venda()+"");
             //stock.tf_preco.setEditable(true);
             venda.b_confirmar.setEnabled(true);
             //stock.tf_qtd.setEditable(true);
             venda.tf_quant.setText("1");
             
         
             
             
             frame.dispose();
        }
    }
}
