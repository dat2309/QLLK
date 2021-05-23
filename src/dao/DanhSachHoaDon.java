package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;

import entity.HoaDon;
import ui.test;



public class DanhSachHoaDon {
	ArrayList<HoaDon> ds;
	HoaDon hd;
	public DanhSachHoaDon() {
		ds=new ArrayList<HoaDon>();
		hd=new HoaDon();
	}
	

	public ArrayList<HoaDon> docTuBang(){
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="select *from hoadon";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				Date ngaylap=rs.getDate(4);
				String nv=rs.getString(2);
				String kh=rs.getString(3);
				HoaDon s=new HoaDon(ma,kh,nv,ngaylap);
				ds.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@SuppressWarnings("finally")
	public boolean themHoaDon(String manv, String makh) {
		@SuppressWarnings("static-access")
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO HOADON (MANHANVIEN,MAKHACHHANG,NGAYLAP)VALUES(?,?,GETDATE())");	
			stmt.setString(1,manv);
			stmt.setString(2, makh);	
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	public DefaultTableModel docTableQLHD(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã hóa đơn","Ngày lập","Tên nhân viên","Tên khách hàng","Tổng số lượng","Tổng tiền hàng","Thuế","Tổng cộng"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) hd.mahoadon, hd.ngaylap, nv.hoten, kh.hoten, ct.tongSL,ct.dongia,ct.tongtien\r\n"
					+ "from hoadon hd \r\n"
					+ "inner join (select mahoadon,sum(dongia*soluong*1.05) as tongtien,sum(soluong) as tongSL,sum(dongia*soluong) as dongia from CTHD group by mahoadon) ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				Date ngaylap=rs.getDate(2);
				String nv=rs.getString(3);
				String kh=rs.getString(4);
				int sl=rs.getInt(5);
				Double dg=rs.getDouble(6);
				Double tt=rs.getDouble(7);
				String[] rowData= {ma,ngaylap+"",nv,kh,sl+"",test.formatter.format(dg)+" VND",test.thue+" %",test.formatter.format(tt)+" VND"};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public String[] docTextFieldQLHD(String mahd){
		String[] rowData= {};
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="\r\n"
					+ "select hd.mahoadon, hd.ngaylap, nv.manhanvien, nv.hoten, kh.makhachhang,kh.hoten, ct.tongSL,ct.dongia,ct.tongtien\r\n"
					+ "from hoadon hd \r\n"
					+ "inner join (select mahoadon,sum(dongia*soluong*1.05) as tongtien,sum(soluong) as tongSL,sum(dongia*soluong) as dongia from CTHD group by mahoadon) ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG\r\n"
					+ "where hd.mahoadon=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,mahd);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				Date ngaylap=rs.getDate(2);
				String manv=rs.getString(3);
				String nv=rs.getString(4);
				String makh=rs.getString(5);
				String kh=rs.getString(6);
				int sl=rs.getInt(7);
				Double dg=rs.getDouble(8);
				Double tt=rs.getDouble(9);
				String[] rowData2= {ma,ngaylap+"",manv,nv,makh,kh,sl+"",test.formatter.format(dg)+" VND",test.thue+" %",test.formatter.format(tt)+" VND"};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	public DefaultTableModel locHD(String tennv,String tenkh,String bd,String kt){
		DefaultTableModel tableModel;
		String[] headers= {"Mã hóa đơn","Ngày lập","Tên nhân viên","Tên khách hàng","Tổng số lượng","Tổng tiền hàng","Thuế","Tổng cộng"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="select hd.mahoadon, hd.ngaylap, nv.hoten,kh.hoten, ct.tongSL,ct.dongia,ct.tongtien\r\n"
					+ "from hoadon hd \r\n"
					+ "inner join (select mahoadon,sum(dongia*soluong*1.05) as tongtien,sum(soluong) as tongSL,sum(dongia*soluong) as dongia from CTHD group by mahoadon) ct on ct.mahoadon=hd.mahoadon\r\n"
					+ "inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien\r\n"
					+ "inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG\r\n"
					+ "where nv.hoten like ? and kh.hoten like ? and  hd.ngaylap BETWEEN ? and ?";
			//if bd.equals("")
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+tennv+"%");
			stm.setString(2,"%"+tenkh+"%");
			stm.setDate(3,java.sql.Date.valueOf(bd));
			stm.setDate(4,java.sql.Date.valueOf(kt));
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				Date ngaylap=rs.getDate(2);
				String nv=rs.getString(3);
				String kh=rs.getString(4);
				int sl=rs.getInt(5);
				Double dg=rs.getDouble(6);
				Double tt=rs.getDouble(7);
				String[] rowData= {ma,ngaylap+"",nv,kh,sl+"",test.formatter.format(dg)+" VND",test.thue+" %",test.formatter.format(tt)+" VND"};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
	
	
}
