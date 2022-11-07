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
public class Tabela_Produtos {
    private JFrame frame;
    private JPanel global;
    private JTable tabela;
    private JLabel l_pesquisar;
    private sgbs.View.controles.textfield_suggestion.TextFieldSuggestion tf_pesquisar;
    
    public Tabela_Produtos() {
        inicializarComponentes();
        configurarFrame(); 
    }
    
     private void inicializarComponentes(){
        frame = new JFrame();
        frame.setResizable(false);
        
        //Inicializar Pineis
        global = new JPanel();
        
        
        l_pesquisar = new JLabel();
        tf_pesquisar = new sgbs.View.controles.textfield_suggestion.TextFieldSuggestion();
        
        //Inicializar tabelas
        String[] c_nomeColunas = {"Codigo", "Descrição", "Famlia","SubFamilia", "Validade","Preço" ,"Qtd"};
        Object [][] c_data  = {
            {" "," "," "," "," "," "," "}};
        tabela = new JTable(c_data, c_nomeColunas);
        configurar_tabelas(); 
    }
     
    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(configurar_TabelaCliente(), BorderLayout.CENTER);
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

        principal.add(panelB, BorderLayout.CENTER);

        return principal;
    }
    
    private void configurar_tabelas() {
        tabela.setPreferredScrollableViewportSize(new Dimension(660, 150));
        tabela.setFillsViewportHeight(true);
//        tabela.getTableHeader().setPreferredSize(new Dimension(890, 35));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.getTableHeader().setBackground(new Color(200, 200, 200));
        tabela.getTableHeader().setForeground(new Color(0,0,0));
        tabela.setRowHeight(20);
    }
    
    public Component configurar_TabelaCliente() {
        JPanel lista = new JPanel();
        lista.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane =  new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(750, 340));
        
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
        new Tabela_Produtos();
    }

}
