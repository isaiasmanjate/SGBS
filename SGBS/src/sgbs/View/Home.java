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
    private JLabel titulo_1, titulo_2, titulo_3;
    private GridBagConstraints constraints = new GridBagConstraints(); 
    private sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient panelGlowingGradient1;
    private sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient panelGlowingGradient2;
    private sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient panelGlowingGradient3;
    private javax.swing.JLabel jLabe1;
    private javax.swing.JLabel jLabe2;
    private javax.swing.JLabel jLabe3;
    private javax.swing.JLabel jLabe4;
    private javax.swing.JLabel jLabe5;
    private javax.swing.JLabel jLabe6;
    private sgbs.View.controles.chart.PieChart pieChart1;
    private sgbs.View.controles.chart.PieChart pieChart2;
    private sgbs.View.controles.chartPanel.chart.BarChart chart;
    private javax.swing.JPanel jPanel1;
    private sgbs.View.controles.chartPanel.panel.PanelGradient panelGradient1;
    private sgbs.View.controles.chartPanel.panel.PanelShadow panelShadow1;
    private javax.swing.JScrollPane ScrollBar;
    int numProduto=0;
    float lucro=0,caixa=0;
    int whisky=0,gin=0,cerveja=0,vinho=0;
    int whiskyS=0,ginS=0,cervejaS=0,vinhoS=0;
    
    public Home() {
        inicialializarComponentes();
       // configurarFrame();
    }
    public void contaProduto(){
             //Popula Familia
        sgbs.Controller.ControllerProduto ctrl = new sgbs.Controller.ControllerProduto();
        sgbs.Model.value_object.Produto f;
        int tamanho = ctrl.gerador();
        for (int i = 1; i < tamanho; i++) {
            numProduto++;
        }
        sgbs.Controller.ControllerVenda ctr = new sgbs.Controller.ControllerVenda();
        sgbs.Model.value_object.Venda v;
        int size = ctr.gerador();
      //  System.out.println(size);
        for (int i = 1; i < size; i++) {
            v=ctr.getVendaById(i);
           // System.out.println(i);
            caixa+=v.getTotal();
           // System.out.println(caixa);
            
        
        }
        sgbs.Controller.ControllerProduto ctrP = new sgbs.Controller.ControllerProduto();
        sgbs.Model.value_object.Produto p;
        int sizes = ctrP.gerador();
        for (int i = 1; i < sizes; i++) {
            p=ctrP.getFunById(i);
           if(1==p.getId_familia()) {
               cerveja++;
           }else if(2==p.getId_familia()){
               vinho++;
           }else if(3==p.getId_familia()){
               whisky++;
           } else if(4==p.getId_familia()){
               gin++;
               
           }          
        
        }

 
        for (int i = 1; i < size; i++) {
            v=ctr.getVendaById(i);
            f=ctrl.getFunById(v.getId_produto());
            
           if(1==f.getId_familia()) {
               cervejaS++;
           }else if(2==f.getId_familia()){
               vinhoS++;
              // System.out.println("ola");
           }else if(3==f.getId_familia()){
               whiskyS++;
           } else if(4==f.getId_familia()){
               ginS++;
               
           }          
        
        }
        
        
        
            
    }
 
    
  
    private void inicialializarComponentes() {
        frame = new JFrame();
        
        //Inicializar LABEL
        titulo_1 = new JLabel();
        titulo_2 = new JLabel();
        titulo_3 = new JLabel();
        jLabe1 = new javax.swing.JLabel();
        jLabe2 = new javax.swing.JLabel();
        jLabe3 = new javax.swing.JLabel();
        jLabe4 = new javax.swing.JLabel();
        jLabe5 = new javax.swing.JLabel();
        jLabe6 = new javax.swing.JLabel();
        
        //Inicializar paineis
        panelGlowingGradient1 = new sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient();
        panelGlowingGradient2 = new sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient();
        panelGlowingGradient3 = new sgbs.View.controles.Jpanel.pggb.PanelGlowingGradient();
        configurarPainel2();
        
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
    
    private void configurarPainel2(){
        contaProduto();
        jLabe1.setFont(new java.awt.Font("sansserif", 1, 26)); 
        jLabe1.setForeground(new java.awt.Color(255, 255, 255));
        jLabe1.setText("  Produtos");
        
        jLabe2.setFont(new java.awt.Font("sansserif", 1, 26)); 
        jLabe2.setForeground(new java.awt.Color(255, 255, 255));
        jLabe2.setText(numProduto+"");
        
       

        
        panelGlowingGradient1.setGradientColor1(new java.awt.Color(221, 65, 65));
        panelGlowingGradient1.setGradientColor2(new java.awt.Color(255, 245, 0));
        panelGlowingGradient1.setShadowSize(15);
        panelGlowingGradient1.setPreferredSize(new Dimension(200, 150));
        
        javax.swing.GroupLayout panelGlowingGradient1Layout = new javax.swing.GroupLayout(panelGlowingGradient1);
        panelGlowingGradient1.setLayout(panelGlowingGradient1Layout);
        panelGlowingGradient1Layout.setHorizontalGroup(
            panelGlowingGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlowingGradient1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelGlowingGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabe1)
                    .addComponent(jLabe2)
                )
                .addGap(30, 30, 30))
        );
        panelGlowingGradient1Layout.setVerticalGroup(
            panelGlowingGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(panelGlowingGradient1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabe1)
                .addGap(10, 10, 10)
                .addComponent(jLabe2)
            )
        );
        
        /*------------------------------------------------------------------------------------------*/
        jLabe3.setFont(new java.awt.Font("sansserif", 1, 26)); 
        jLabe3.setForeground(new java.awt.Color(255, 255, 255));
        jLabe3.setText("Caixa");
        
        jLabe4.setFont(new java.awt.Font("sansserif", 1, 20)); 
        jLabe4.setForeground(new java.awt.Color(255, 255, 255));
        jLabe4.setText(caixa+" MZN");
        
        panelGlowingGradient2.setGradientColor1(new java.awt.Color(221, 65, 65));
        panelGlowingGradient2.setGradientColor2(new java.awt.Color(255, 245, 0));
        panelGlowingGradient2.setShadowSize(15);
        panelGlowingGradient2.setPreferredSize(new Dimension(200, 150));
        
        javax.swing.GroupLayout panelGlowingGradient2Layout = new javax.swing.GroupLayout(panelGlowingGradient2);
        panelGlowingGradient2.setLayout(panelGlowingGradient2Layout);
        panelGlowingGradient2Layout.setHorizontalGroup(
            panelGlowingGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlowingGradient2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelGlowingGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabe3)
                    .addComponent(jLabe4)
                )
                .addGap(30, 30, 30))
        );
        panelGlowingGradient2Layout.setVerticalGroup(
            panelGlowingGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlowingGradient2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabe3)
                .addGap(10, 10, 10)
                .addComponent(jLabe4)
            )
        );
        
        /*-------------------------------------------------------------------------------------------*/
        jLabe5.setFont(new java.awt.Font("sansserif", 1, 26)); // NOI18N
        jLabe5.setForeground(new java.awt.Color(255, 255, 255));
        jLabe5.setText("Lucro");
        
        jLabe6.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabe6.setForeground(new java.awt.Color(255, 255, 255));
        jLabe6.setText("0,00 MZN");
        
        panelGlowingGradient3.setGradientColor1(new java.awt.Color(221, 65, 65));
        panelGlowingGradient3.setGradientColor2(new java.awt.Color(255, 245, 0));
        panelGlowingGradient3.setShadowSize(15);
        panelGlowingGradient3.setPreferredSize(new Dimension(200, 150));
        
        javax.swing.GroupLayout panelGlowingGradient3Layout = new javax.swing.GroupLayout(panelGlowingGradient3);
        panelGlowingGradient3.setLayout(panelGlowingGradient3Layout);
        panelGlowingGradient3Layout.setHorizontalGroup(
            panelGlowingGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlowingGradient3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelGlowingGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabe5)
                    .addComponent(jLabe6)

                )
                .addGap(30, 30, 30))
        );
        panelGlowingGradient3Layout.setVerticalGroup(
            panelGlowingGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlowingGradient3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabe5)
                .addGap(10, 10, 10)
                .addComponent(jLabe6)
//                .addGap(150, 150, 150)
            )
        );
    }
    
    
    
    private void configurarChart(){
        
        //Configurar pieChart1
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.addData(new ModelPieChart("Cerveja", cerveja, new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("Gin", gin, new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("Vinho", vinho, new Color(47, 157, 64)));
        pieChart1.addData(new ModelPieChart("Whisky", whisky, new Color(196, 151, 58)));
        
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
        pieChart2.addData(new ModelPieChart("Cerveja", cervejaS, new Color(23, 126, 238)));
        pieChart2.addData(new ModelPieChart("Gin", ginS, new Color(221, 65, 65)));
        pieChart2.addData(new ModelPieChart("Vinho", vinhoS, new Color(47, 157, 64)));
        pieChart2.addData(new ModelPieChart("Whisky", whiskyS, new Color(196, 151, 58)));
        
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
        panel.setBackground(new java.awt.Color(250, 250, 250));
        panel.setColorGradient(new java.awt.Color(45, 45, 45));
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.HORIZONTAL);

        addGB2(panel, panelGlowingGradient1, 0, 0);
        addGB2(panel, new JLabel("                            "), 1, 0);
        addGB2(panel, panelGlowingGradient2, 2, 0);
        addGB2(panel, new JLabel("                            "), 3, 0);
        addGB2(panel, panelGlowingGradient3, 4, 0);
        
        return panel;
    }
    
    private Component painelCentro(){
        sgbs.View.controles.chartPanel.panel.PanelGradient panel = new sgbs.View.controles.chartPanel.panel.PanelGradient();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setColorGradient(new java.awt.Color(45, 45, 45));
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.HORIZONTAL);
        
 
        titulo_1.setFont(new java.awt.Font("Roboto Black", 1, 25));
        titulo_1.setText("Bebidas Disponiveis");
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
        panel.setGradientType(sgbs.View.controles.chartPanel.panel.PanelGradient.GradientType.HORIZONTAL);
        
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
      //  global.add(painelSul(), BorderLayout.SOUTH);


        ScrollBar.setPreferredSize(new Dimension(900, 2240));
        ScrollBar.setBorder(null);
        
        return global;
    }
    
    public static void main(String[] args) {
     //  new Home();
    }
    
}

