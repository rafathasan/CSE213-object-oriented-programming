/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author rafikhan
 */
public class CreateFreeChart {
    static public JFreeChart createLineChart(String title, String x, String y, DefaultCategoryDataset set, JPanel panel){
        
        JFreeChart lineChart = ChartFactory.createLineChart(title, x, y, set, PlotOrientation.VERTICAL, false, true, false); 
        
        lineChart.getTitle().setPaint(Color.black);     
        lineChart.setBackgroundPaint(Color.WHITE);
        
        CategoryPlot cp = lineChart.getCategoryPlot();
        
        cp.setBackgroundPaint(Color.white);       
        cp.setRangeGridlinePaint(Color.blue);
        NumberAxis rangeAxis = (NumberAxis) cp.getRangeAxis();

        rangeAxis.setTickUnit(new NumberTickUnit(1));
        
        
        ChartPanel cPanel= new ChartPanel(lineChart);
        
        panel.setLayout(new BorderLayout());
        panel.removeAll();
        panel.add(cPanel,BorderLayout.CENTER);
        panel.validate();
        return lineChart;
    }
    
    static public void createBarChart(String title, String x, String y, DefaultCategoryDataset set, JPanel panel){
        
        JFreeChart barchart = ChartFactory.createBarChart3D(title, x, y, set, PlotOrientation.VERTICAL, true, true, false); 
        
        barchart.getTitle().setPaint(Color.black);  
        barchart.setBackgroundPaint(Color.WHITE);
        
        CategoryPlot cp = barchart.getCategoryPlot(); 
        NumberAxis rangeAxis = (NumberAxis) cp.getRangeAxis();
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        
        cp.setBackgroundPaint(Color.white);       
        cp.setRangeGridlinePaint(Color.blue);

        ChartPanel cPanel= new ChartPanel(barchart); 
        
        panel.setLayout(new BorderLayout());
        panel.removeAll();
        panel.add(cPanel,BorderLayout.CENTER);
        panel.validate();
    }
    
    static public void createPieChart(String title, DefaultPieDataset pieSet, JPanel panel){
        JFreeChart piechart = ChartFactory.createPieChart(title, pieSet, true, true, true);  
       
        piechart.getTitle().setPaint(Color.BLACK);
        piechart.setBackgroundPaint(Color.GRAY);
      
        PiePlot p=(PiePlot)piechart.getPlot();
        p.setBackgroundPaint(Color.white);        
      
        ChartPanel cPanel= new ChartPanel(piechart);
        
        panel.setLayout(new BorderLayout());
        panel.removeAll();
        panel.add(cPanel,BorderLayout.CENTER);
        panel.validate();
    }
}
