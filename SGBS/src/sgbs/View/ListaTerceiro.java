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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ListaTerceiro {

    JTable tabelaF, tabelaC;
    JTabbedPane pane;
    JButton b_cancelar, b_selecionar,b_procurar;
    JFrame frame;
    JPanel global;

    public ListaTerceiro() {
        inicializarComponent();
        configurarFrame();
    }

    private void inicializarComponent() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        
        //Botoes
//        b_cancelar=new JButton("Cancelar");
//        b_selecionar=new JButton("Selecionar");
        b_procurar=new JButton("");
        
        
        frame = new JFrame("Lista de terceiros");
        String[] Header = {"Codigo", "Nome", "Contacto", "Morada", "Nuit"};
        Object[][] dados = {{"001", "Isaias Manjate", "848322321", "Maputo", "1132323244"}};
        tabelaF = new JTable(dados, Header);
        tabelaC = new JTable(dados, Header);
        p1.add(new JScrollPane(tabelaF));
        p2.add(new JScrollPane(tabelaC));

        pane = new JTabbedPane();

        configurar_JTabbedPane(p1, p2);
    }

    private Component configurar_JTabbedPane(Component tabelaC, Component tabelaF) {
        
        JPanel panel = new JPanel();
        JPanel p=new JPanel();
        panel.setLayout(new BorderLayout());
        pane.addTab("Cliente", tabelaC);
        pane.addTab("Fornecedor", tabelaF);
        b_cancelar=new JButton("Cancelar");
        b_selecionar=new JButton("Selecionar");
        p.add(b_cancelar);
        p.add(b_selecionar);
        
        panel.add(pane, BorderLayout.NORTH);
        panel.add(p,BorderLayout.EAST);

        return panel;
    }

    private void configurarFrame() {
        global = new JPanel();
        global.setLayout(new BorderLayout());
        global.add(pane, BorderLayout.CENTER);

        frame.add(global);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ListaTerceiro();
    }

}
