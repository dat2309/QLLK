package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class UI_BieuDo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel pnlSouthBD;
	public UI_BieuDo() {
		buildUI();
	}
	public void buildUI() {
		pnlSouthBD = new JPanel();
		pnlSouthBD.setPreferredSize(new Dimension(1600,600));
		pnlSouthBD.setBackground(Color.WHITE);
	}
	public void setBietDo(String title, Double[] doanhThu, Double[] loiNhuan, Double[] loiNhuanTrungBinh, String[] trucX ) {
		pnlSouthBD.removeAll();//Dòng quan trọng
		
		JFreeChart barChart = ChartFactory.createBarChart(
		         title,           
		         null,            
		         "Triệu VND",            
		         createDataset(doanhThu,loiNhuan,loiNhuanTrungBinh,trucX),          
		         PlotOrientation.HORIZONTAL,           
		         true, true, false);
		         
		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 1570 , 580) );        
		setContentPane(chartPanel); 
		
		barChart.getTitle().setFont(new Font("Times new roman", 0, 28));
		barChart.getLegend().setItemFont(new Font("Times new roman", 0, 15));
		
		BarRenderer ren = (BarRenderer) barChart.getCategoryPlot().getRenderer();
		ren.setSeriesPaint(0, Color.decode("#4287f5"));
		ren.setSeriesPaint(1, Color.decode("#42f55a"));
		ren.setSeriesPaint(2, Color.decode("#f54242"));
		ren.setBarPainter(new StandardBarPainter());
		
		
		pnlSouthBD.add(chartPanel);
	}
	
    private static CategoryDataset createDataset(Double[] doanhThu, Double[] loiNhuan, Double[] loiNhuanTrungBinh, String[] trucX ) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i < trucX.length;i++) {
        	dataset.addValue(doanhThu[i]/1000000, "Doanh thu", trucX[i]);
        	dataset.addValue(loiNhuan[i]/1000000, "Lợi nhuận", trucX[i]);
        	dataset.addValue(loiNhuanTrungBinh[i]/1000000, "Lợi nhuận trung bình", trucX[i]);
        }
        return dataset;
    }
}
