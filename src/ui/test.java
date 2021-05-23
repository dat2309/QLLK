package ui;

import java.net.MalformedURLException;

import java.sql.Connection;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import dao.Database;



public class test {
	public static int col=0;
	public static String tenNhanVien="";
	public static String maNhanVien="";
	public static int loaiNhanVien=0;
	public static int thue=5;
	public static DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws MalformedURLException {
      
        JWindow window = new JWindow();
        window.getContentPane().add(
            new JLabel("", new ImageIcon(("./anh/loading.gif")), SwingConstants.CENTER));
        window.setSize(600, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        UI_DangNhap fm = new UI_DangNhap();
        fm.setVisible(true);
       
		@SuppressWarnings("unused")
		Connection con=Database.getInstance().getConnection();
    }
}
