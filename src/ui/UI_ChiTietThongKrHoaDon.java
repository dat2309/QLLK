package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import dao.Database;

public class UI_ChiTietThongKrHoaDon extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	public JPanel pnlSouth;

	public UI_ChiTietThongKrHoaDon() {
		buildUI();
	}

	public void buildUI() {
		pnlSouth = new JPanel();
		
		pnlSouth.setBackground(Color.WHITE);
		pnlSouth.setVisible(false);

		
		String [] header = {"Ngày lập","Mã hóa đơn","Nhân viên lập","Khách hàng","Giá trị HĐ","Thuế","Lợi nhuận"};
		
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		scroll = new JScrollPane(table);
		pnlSouth.add(scroll);
		
		scroll.setPreferredSize(new Dimension(1580,580));
		
		scroll.setBackground(Color.WHITE);
		
		table.setBackground(Color.WHITE);
		table.setRowHeight(40);
		
		table.getTableHeader().setBackground(Color.decode("#3289fa"));
		table.getTableHeader().setFont(new Font("Times new roman", Font.BOLD, 20));
		table.getTableHeader().setForeground(Color.WHITE);
		
		table.setFont(new Font("Times new roman", Font.HANGING_BASELINE, 15));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.getTableHeader().setReorderingAllowed(false);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);

		
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		
	}
	
	@SuppressWarnings("static-access")
	public void setGiaTriThongKeNgay(String ngayBD,String ngayKT) {
		tableModel.getDataVector().removeAllElements(); // Dòng quan trọng
		
		try {
			tableModel.setRowCount(0);
			Connection con=Database.getInstance().getConnection();
			String sql="select  hd.ngaylap,hd.mahoadon, nv.hoten,kh.hoten,  sum(ct.dongia*ct.soluong*1.05) as tongcong,sum(ct.dongia*ct.soluong*0.05) as thue, sum(ct.dongia*ct.soluong)- sum(lk.dongiagoc*ct.soluong) as loinhuan\r\n"
					+ "from hoadon hd\r\n"
					+ "inner join cthd ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG\r\n"
					+ "inner join linhkien lk on lk.malinhkien = ct.malinhkien\r\n"
					+ "where hd.ngaylap BETWEEN ? and ?\r\n"
					+ "group by hd.mahoadon,hd.ngaylap,nv.hoten,kh.hoten";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setDate(1,java.sql.Date.valueOf(ngayBD));
			stm.setDate(2,java.sql.Date.valueOf(ngayKT));
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String nl=rs.getDate(1).toString();
				String ma=rs.getString(2);
				String nv=rs.getString(3);
				String kh=rs.getString(4);
				Double gthd=rs.getDouble(5);
				Double thue=rs.getDouble(6);
				Double ln=rs.getDouble(7);
				tableModel.addRow(new Object[] {nl,ma,nv,kh,test.formatter.format(gthd)+" VND",test.formatter.format(thue)+" VND",test.formatter.format(ln)+" VND"});
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("static-access")
	public void setGiaTriThongKeThang(String ngayBD, String ngayKT) {
		tableModel.getDataVector().removeAllElements(); // Dòng quan trọng
		try {
			tableModel.setRowCount(0);
			Connection con=Database.getInstance().getConnection();
			String sql="select  hd.ngaylap,hd.mahoadon, nv.hoten,kh.hoten,  sum(ct.dongia*ct.soluong*1.05) as tongcong,sum(ct.dongia*ct.soluong*0.05) as thue, sum(ct.dongia*ct.soluong)- sum(lk.dongiagoc*ct.soluong) as loinhuan\r\n"
					+ "from hoadon hd\r\n"
					+ "inner join cthd ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG\r\n"
					+ "inner join linhkien lk on lk.malinhkien = ct.malinhkien\r\n"
					+ "where DATEADD(month, DATEDIFF(month, 0, hd.ngaylap), 0) between DATEADD(month, DATEDIFF(month, 0, ?), 0)  and DATEADD(month, DATEDIFF(month, 0, ?), 0)"
					+ "group by hd.mahoadon,hd.ngaylap,nv.hoten,kh.hoten";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setDate(1,java.sql.Date.valueOf(ngayBD));
			stm.setDate(2,java.sql.Date.valueOf(ngayKT));
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String nl=rs.getDate(1).toString();
				String ma=rs.getString(2);
				String nv=rs.getString(3);
				String kh=rs.getString(4);
				Double gthd=rs.getDouble(5);
				Double thue=rs.getDouble(6);
				Double ln=rs.getDouble(7);
				tableModel.addRow(new Object[] {nl,ma,nv,kh,test.formatter.format(gthd)+" VND",test.formatter.format(thue)+" VND",test.formatter.format(ln)+" VND"});
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("static-access")
	public void setGiaTriThongKeNam(String ngayBD, String ngayKT) {
		tableModel.getDataVector().removeAllElements(); // Dòng quan trọng
		try {
			tableModel.setRowCount(0);
			Connection con=Database.getInstance().getConnection();
			String sql="select  hd.ngaylap,hd.mahoadon, nv.hoten,kh.hoten,  sum(ct.dongia*ct.soluong*1.05) as tongcong,sum(ct.dongia*ct.soluong*0.05) as thue, sum(ct.dongia*ct.soluong)- sum(lk.dongiagoc*ct.soluong) as loinhuan\r\n"
					+ "from hoadon hd\r\n"
					+ "inner join cthd ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG\r\n"
					+ "inner join linhkien lk on lk.malinhkien = ct.malinhkien\r\n"
					+ "where DATEADD(year, DATEDIFF(year, 0, hd.ngaylap), 0) between DATEADD(year, DATEDIFF(year, 0, ?), 0)  and DATEADD(month, DATEDIFF(month, 0, ?), 0)"
					+ "group by hd.mahoadon,hd.ngaylap,nv.hoten,kh.hoten";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setDate(1,java.sql.Date.valueOf(ngayBD));
			stm.setDate(2,java.sql.Date.valueOf(ngayKT));
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String nl=rs.getDate(1).toString();
				String ma=rs.getString(2);
				String nv=rs.getString(3);
				String kh=rs.getString(4);
				Double gthd=rs.getDouble(5);
				Double thue=rs.getDouble(6);
				Double ln=rs.getDouble(7);
				tableModel.addRow(new Object[] {nl,ma,nv,kh,test.formatter.format(gthd)+" VND",test.formatter.format(thue)+" VND",test.formatter.format(ln)+" VND"});
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
