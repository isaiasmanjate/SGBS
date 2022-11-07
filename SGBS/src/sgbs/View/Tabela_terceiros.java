package sgbs.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
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
public class Tabela_terceiros {
    private JFrame frame;
    private JPanel global,p_tabelas;
    private JTabbedPane ConjPanel;
    private JTable tabelaCliente, tabelaFornecedor;
    private JLabel l_pesquisar;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_pesquisar;
    
    public Tabela_terceiros() {
        inicializarComponentes();
        configurarFrame(); 
    }
    
    private void inicializarComponentes(){
        frame = new JFrame("Lista de Terceiros");
       frame.setResizable(false);
        
        //Inicializar Pineis
        global = new JPanel();
        p_tabelas = new JPanel();
        
        
        l_pesquisar = new JLabel();
        tf_pesquisar = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        //Inicializar TabbedPan  
        ConjPanel = new JTabbedPane();
        
        //Inicializar tabelas
        String[] c_nomeColunas = {"Codigo", "Nome", "Contacto","E-mail", "Morada", "Nuit"};
        Object [][] c_data  = {
            {"101","Mangue","888888","@gmail.com","Maputo","111111111"},};
        tabelaCliente = new JTable(c_data, c_nomeColunas);
        
        String[] f_nomeColunas = {"Codigo", "Nome", "Contacto","E-mail", "Morada", "Nuit"};
        Object [][] f_data  = {
            {"101","BS-Fornrcedor","888888","@gmail.com","Maputo","111111111"},};
        tabelaFornecedor = new JTable(f_data, f_nomeColunas);
        configurar_tabelas();
    }
    
    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(configurar_JTabbedPane(), BorderLayout.CENTER);
        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        tabelaCliente.getTableHeader().setForeground(new Color(0,0,0));
        tabelaCliente.setRowHeight(20);
        
        //configurar tabela Fornecedor
        tabelaFornecedor.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabelaFornecedor.setFillsViewportHeight(true);
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabelaFornecedor.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaFornecedor.getTableHeader().setOpaque(false);
        tabelaFornecedor.getTableHeader().setBackground(new Color(200, 200, 200));
        tabelaFornecedor.getTableHeader().setForeground(new Color(0,0,0));
        tabelaFornecedor.setRowHeight(20);
    }
    
    private  Component configurar_JTabbedPane(){
        p_tabelas.setLayout(new BorderLayout());
        p_tabelas.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        p_tabelas.add(ConjPanel,BorderLayout.CENTER);
        p_tabelas.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.setBackground(new java.awt.Color(255, 255, 255));
        ConjPanel.addTab("Clientes", configurar_TabelaCliente());
        ConjPanel.addTab("Fornecedores", configurar_TabelaFornecedor());
        
        return p_tabelas;
    }
    
    public Component configurar_TabelaCliente() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabelaCliente);
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
        JScrollPane scrollPane =  new JScrollPane(tabelaFornecedor);
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
        new Tabela_terceiros();
    }
}
