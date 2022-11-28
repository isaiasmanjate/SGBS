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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sgbs.View.controles.chart.ModelPieChart;
import sgbs.View.controles.chart.PieChart;
import sgbs.View.controles.chartPanel.chart.ModelChart;

/**
 *
 * @author Ricardo
 */
public class Home {
    private JFrame frame;
    private JPanel global;
    private JLabel produto, produto_valor, lucro, lucro_valor, caixa, caixa_valor,titulo_1, titulo_2, titulo_3;
    private GridBagConstraints constraints = new GridBagConstraints();
    private sgbs.View.controles.PanelRound.PanelRound panelRound1;
    private sgbs.View.controles.PanelRound.PanelRound panelRound2;
    private sgbs.View.controles.PanelRound.PanelRound panelRound3;
    private sgbs.View.controles.chart.PieChart pieChart1;
    private sgbs.View.controles.chart.PieChart pieChart2;
    
    //ChartPanel
    private sgbs.View.controles.chartPanel.chart.BarChart chart;
    private javax.swing.JPanel jPanel1;
    private sgbs.View.controles.chartPanel.panel.PanelGradient panelGradient1;
    private sgbs.View.controles.chartPanel.panel.PanelShadow panelShadow1;
    
    private javax.swing.JScrollPane ScrollBar;
    
    public Home() {
        inicialializarComponentes();
        configurarFrame();
    }
    
    private void inicialializarComponentes() {
        frame = new JFrame();
        
        //Inicializar LABEL
        produto = new JLabel();
        produto_valor = new JLabel();
        lucro = new JLabel();
        lucro_valor = new JLabel();
        caixa = new JLabel();
        caixa_valor = new JLabel();
        titulo_1 = new JLabel();
        titulo_2 = new JLabel();
        titulo_3 = new JLabel();
        
        //Inicializar paineis
        panelRound1 = new sgbs.View.controles.PanelRound.PanelRound();
        panelRound2 = new sgbs.View.controles.PanelRound.PanelRound();
        panelRound3 = new sgbs.View.controles.PanelRound.PanelRound();
        configurarPainel();
        
        //Inicializar paineis
        pieChart1 = new sgbs.View.controles.chart.PieChart();
        pieChart2 = new sgbs.View.controles.chart.PieChart();
        configurarChart();
        
        //Inicializar ChartPanel
        chart = new sgbs.View.controles.chartPanel.chart.BarChart();
        jPanel1 = new javax.swing.JPanel();
        panelGradient1 = new sgbs.View.controles.chartPanel.panel.PanelGradient();
        panelShadow1 = new sgbs.View.controles.chartPanel.panel.PanelShadow();
        configurarChartPanel();
    }
    
    private void configurarFrame() {
        global = new JPanel();
        global.setBackground(new java.awt.Color(255, 255, 255));
        ScrollBar = new javax.swing.JScrollPane(global);
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);


        ScrollBar.setPreferredSize(new Dimension(900, 2240));
        ScrollBar.setBorder(null);
        frame.add(ScrollBar);
        //frame.setResizable(false);
        //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
    
    
    
    private void configurarPainel(){
        // Configuracoa do PanelRound1
        panelRound1.setBackground(new java.awt.Color(0, 134, 190));
        
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        
        // Configuracoa do PanelRound2
        panelRound2.setBackground(new java.awt.Color(0, 134, 190));
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        
        // Configuracoa do PanelRound2
        panelRound3.setBackground(new java.awt.Color(0, 134, 190));
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);

        javax.swing.GroupLayout pane2Round2Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(pane2Round2Layout);
        pane2Round2Layout.setHorizontalGroup(
            pane2Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        pane2Round2Layout.setVerticalGroup(
            pane2Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

    }
    
    private void configurarChart(){
        
        //Configurar pieChart1
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.addData(new ModelPieChart("Cerveja", 150, new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("Vodka", 100, new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("vinho", 45, new Color(47, 157, 64)));
        pieChart1.addData(new ModelPieChart("Wisck", 60, new Color(196, 151, 58)));
        
        pieChart1.setFont(new java.awt.Font("sansserif", 1, 12)); 
        
        javax.swing.GroupLayout pane1Round2Layout = new javax.swing.GroupLayout(pieChart1);
        pieChart1.setLayout(pane1Round2Layout);
        pane1Round2Layout.setHorizontalGroup(
            pane1Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        pane1Round2Layout.setVerticalGroup(
            pane1Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        
        //Configurar pieChart2
        pieChart2.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart2.addData(new ModelPieChart("Cerveja", 150, new Color(23, 126, 238)));
        pieChart2.addData(new ModelPieChart("Vodka", 100, new Color(221, 65, 65)));
        pieChart2.addData(new ModelPieChart("vinho", 76, new Color(47, 157, 64)));
        pieChart2.addData(new ModelPieChart("Wisck", 60, new Color(196, 151, 58)));
        
        pieChart2.setFont(new java.awt.Font("sansserif", 1, 12)); 
        
        javax.swing.GroupLayout pane2Round2Layout = new javax.swing.GroupLayout(pieChart2);
        pieChart2.setLayout(pane2Round2Layout);
        pane2Round2Layout.setHorizontalGroup(
            pane2Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        pane2Round2Layout.setVerticalGroup(
            pane2Round2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
    }
    
    private void configurarChartPanel(){
        chart.setTitle("Chart Data");
        chart.addLegend("Vodka", Color.decode("#f5af19"), Color.decode("#f12711"));
        chart.addLegend("vinho", Color.decode("#a044ff"), Color.decode("#6a3093"));
        chart.addLegend("Profit", Color.decode("#38ef7d"), Color.decode("#11998e"));
        chart.addLegend("Cerveja", Color.decode("#0575E6"), Color.decode("#021B79"));
        chart.addData(new ModelChart("January", new double[]{89, 200, 80, 500}));
        chart.addData(new ModelChart("February", new double[]{600, 150, 90, 750}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("May", new double[]{350, 150, 300, 540}));
        chart.addData(new ModelChart("June", new double[]{450, 500, 700, 900}));
        chart.start();
        
        panelGradient1.setBackground(new java.awt.Color(255, 30, 30));
        panelGradient1.setColorGradient(new java.awt.Color(45, 45, 45));
        panelGradient1.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.DIAGONAL_1);

        panelShadow1.setBackground(new java.awt.Color(15, 15, 15));
        panelShadow1.setColorGradient(new java.awt.Color(30, 30, 30));
        panelShadow1.setGradientType(sgbs.View.controles.chartPanel.panel.PanelShadow.GradientType.DIAGONAL_2);
        panelShadow1.setRadius(5);
        
        panelShadow1.setSize(200, 400);
        
        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(118, 118, 118))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );
    }
    
    
    private void addGB(JPanel panel, Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }
    private void addGB2(sgbs.View.controles.chartPanel.panel.PanelGradient panel, Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }
    
    private Component painelNorte() {
        sgbs.View.controles.chartPanel.panel.PanelGradient panel = new sgbs.View.controles.chartPanel.panel.PanelGradient();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setColorGradient(new java.awt.Color(45, 45, 45));
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.DIAGONAL_2);
//        constraints.insets = new Insets(50, 2, 50, 2);
        
        produto.setFont(new java.awt.Font("Roboto Black", 1, 34));
        produto.setText("Produtos");
        produto.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound prod1 = new sgbs.View.controles.PanelRound.PanelRound();
        prod1.setLayout(new FlowLayout(FlowLayout.CENTER));
        prod1.setBackground(new java.awt.Color(0, 134, 190));
        prod1.setRoundBottomRight(50);
        prod1.setRoundTopLeft(50);
        prod1.add(produto);
        
        String n_produto = "167";
        produto_valor.setFont(new java.awt.Font("Roboto Black", 1, 45));
        produto_valor.setText(n_produto);
        produto_valor.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound prod2 = new sgbs.View.controles.PanelRound.PanelRound();
        prod2.setLayout(new FlowLayout(FlowLayout.CENTER));
        prod2.setBackground(new java.awt.Color(0, 134, 190));
        prod2.setRoundBottomRight(50);
        prod2.setRoundTopLeft(50);
        prod2.add(produto_valor);
        
        panelRound1.setLayout(new BorderLayout());
        panelRound1.add(prod1, BorderLayout.NORTH);
        panelRound1.add(prod2, BorderLayout.CENTER);
        panelRound1.setPreferredSize(new Dimension(180, 180));
        
        /*-------------------------------------------
                            CAIXA
        --------------------------------------------*/
        caixa.setFont(new java.awt.Font("Roboto Black", 1, 34));
        caixa.setText("Caixa");
        caixa.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound caixa1 = new sgbs.View.controles.PanelRound.PanelRound();
        caixa1.setLayout(new FlowLayout(FlowLayout.CENTER));
        caixa1.setBackground(new java.awt.Color(0, 134, 190));
        caixa1.setRoundBottomRight(50);
        caixa1.setRoundTopLeft(50);
        caixa1.add(caixa);
        
        String n_caixa = "14355.00 MZN";
        caixa_valor.setFont(new java.awt.Font("Roboto Black", 1, 25));
        caixa_valor.setText(n_caixa);
        caixa_valor.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound caixa2 = new sgbs.View.controles.PanelRound.PanelRound();
        caixa2.setLayout(new FlowLayout(FlowLayout.CENTER));
        caixa2.setBackground(new java.awt.Color(0, 134, 190));
        caixa2.setRoundBottomRight(50);
        caixa2.setRoundTopLeft(50);
        caixa2.add(caixa_valor);
        
        panelRound2.setLayout(new BorderLayout());
        panelRound2.add(caixa1, BorderLayout.NORTH);
        panelRound2.add(caixa2, BorderLayout.CENTER);
        panelRound2.setPreferredSize(new Dimension(180, 180));
        
        /*-------------------------------------------
                            CAIXA
        --------------------------------------------*/
        lucro.setFont(new java.awt.Font("Roboto Black", 1, 34));
        lucro.setText("Lucros");
        lucro.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound lucro1 = new sgbs.View.controles.PanelRound.PanelRound();
        lucro1.setLayout(new FlowLayout(FlowLayout.CENTER));
        lucro1.setBackground(new java.awt.Color(0, 134, 190));
        lucro1.setRoundBottomRight(50);
        lucro1.setRoundTopLeft(50);
        lucro1.add(lucro);
        
        String n_lucro = "4355.00 MZN";
        lucro_valor.setFont(new java.awt.Font("Roboto Black", 1, 25));
        lucro_valor.setText(n_lucro);
        lucro_valor.setForeground(new java.awt.Color(255, 255, 255));
        sgbs.View.controles.PanelRound.PanelRound lucro2 = new sgbs.View.controles.PanelRound.PanelRound();
        lucro2.setLayout(new FlowLayout(FlowLayout.CENTER));
        lucro2.setBackground(new java.awt.Color(0, 134, 190));
        lucro2.setRoundBottomRight(50);
        lucro2.setRoundTopLeft(50);
        lucro2.add(lucro_valor);
        
        panelRound3.setLayout(new BorderLayout());
        panelRound3.add(lucro1, BorderLayout.NORTH);
        panelRound3.add(lucro2, BorderLayout.CENTER);
        panelRound3.setPreferredSize(new Dimension(180, 180));
        
        addGB2(panel, panelRound1, 0, 0);
        addGB2(panel, new JLabel("                            "), 1, 0);
        addGB2(panel, panelRound2, 2, 0);
        addGB2(panel, new JLabel("                            "), 3, 0);
        addGB2(panel, panelRound3, 4, 0);
//        addGB2(panel, new JLabel("                            "), 5, 0);
//        addGB2(panel, new JLabel("                            "), 6, 0);
        return panel;
    }
    
    private Component painelCentro(){
        sgbs.View.controles.chartPanel.panel.PanelGradient panel = new sgbs.View.controles.chartPanel.panel.PanelGradient();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setColorGradient(new java.awt.Color(45, 45, 45));
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.DIAGONAL_2);
        
 
        titulo_1.setFont(new java.awt.Font("Roboto Black", 1, 25));
        titulo_1.setText("Bebidas Desponiveis");
        titulo_1.setForeground(new java.awt.Color(0, 0, 0));
        
        titulo_2.setFont(new java.awt.Font("Roboto Black", 1, 25));
        titulo_2.setText("Bebidas Saida");
        titulo_2.setForeground(new java.awt.Color(0, 0, 0));
        
        addGB2(panel, new JLabel("                            "), 0, 0);
        addGB2(panel, titulo_1, 0, 1);
        addGB2(panel, pieChart1, 0, 2);
        addGB2(panel, new JLabel("                            "), 1, 0);
        addGB2(panel, titulo_2, 1, 1);
        addGB2(panel, pieChart2, 1, 2);
        return panel;
    }
    
    private Component painelSul(){
        sgbs.View.controles.chartPanel.panel.PanelGradient panel = new sgbs.View.controles.chartPanel.panel.PanelGradient();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setColorGradient(new java.awt.Color(45, 45, 45));
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.DIAGONAL_1);
        
        titulo_3.setFont(new java.awt.Font("Roboto Black", 1, 25));
        titulo_3.setText("Grafico de Vendas");
        titulo_3.setForeground(new java.awt.Color(0, 0, 0));
        
        addGB2(panel, titulo_3, 0, 0);
        addGB2(panel, chart, 0, 1);
        addGB2(panel, panelShadow1, 0, 2);
        return panel;
    }
    
    
    public Component retornaPainel(){
        global = new JPanel();
        global.setBackground(new java.awt.Color(255, 255, 255));
        ScrollBar = new javax.swing.JScrollPane(global);
        global.setLayout(new BorderLayout());
        global.add(painelNorte(), BorderLayout.NORTH);
        global.add(painelCentro(), BorderLayout.CENTER);
        global.add(painelSul(), BorderLayout.SOUTH);


        ScrollBar.setPreferredSize(new Dimension(900, 2240));
        ScrollBar.setBorder(null);
        
        return global;
    }
    
    public static void main(String[] args) {
        new Home();
    }
    
}

