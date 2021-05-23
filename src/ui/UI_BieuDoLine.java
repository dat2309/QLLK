package ui;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class UI_BieuDoLine extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel pnlSouthBD;
	public UI_BieuDoLine() {
		buildUI();
	}
	private void buildUI() {
		pnlSouthBD = new JPanel();
		pnlSouthBD.setPreferredSize(new Dimension(1600,600));
		pnlSouthBD.setBackground(Color.WHITE);
	}
	
	public void setBietDo(String title, double[] loiNhuan, String[] tenNhanVien, String[] trucX  ) {
		pnlSouthBD.removeAll();//Dòng quan trọng
		
		JFreeChart barChart = ChartFactory.createLineChart(
		         title,           
		         null,            
		         "VND",            
		         createDataset(loiNhuan,tenNhanVien,trucX),          
		         PlotOrientation.VERTICAL,           
		         true, true, false);
		         
		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 1570 , 580) );        
		setContentPane(chartPanel); 
		
		
		
		pnlSouthBD.add(chartPanel);
	}
	
    private static CategoryDataset createDataset(double[] loiNhuan, String[] tenNhanVien, String[] trucX ) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i < trucX.length;i++) {
        	dataset.addValue(loiNhuan[i], tenNhanVien[i], trucX[i]);
        }
        return dataset;
    }
}
