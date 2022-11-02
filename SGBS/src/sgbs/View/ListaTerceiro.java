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
    JButton b_cancelar, b_selecionar;
    JLabel procuar;
    JFrame frame;
    JPanel global;

    public ListaTerceiro() {
        inicializarComponent();
        configurarFrame();
    }

    private void inicializarComponent() {
        frame=new JFrame("Lista de terceiros");
        String[] Header = {"Codigo", "Nome", "Contacto", "Morada", "Nuit"};
        Object[][] dados = {{"001", "Isaias Manjate", "848322321", "Maputo", "1132323244"}};
        tabelaF = new JTable(dados, Header);
        tabelaC = new JTable(dados, Header);

        pane = new JTabbedPane();
        configurar_JTabbedPane(tabelaC, tabelaF);
    }

    private void configurar_JTabbedPane(JTable tabelaC, JTable tabelaF) {
        pane.setLayout(new BorderLayout());
        pane.setBorder(new TitledBorder(LineBorder.createGrayLineBorder()));
        pane.setBackground(new java.awt.Color(255, 255, 255));

        pane.setBackground(new java.awt.Color(255, 255, 255));
        pane.addTab("Cliente", tabelaC);
        pane.addTab("Fornecedor", tabelaF);

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
