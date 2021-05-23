package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.NhanVien;




public class DanhSachNhanVien {
	ArrayList<NhanVien> ds;
	NhanVien nv;
	public DanhSachNhanVien() {
		ds=new ArrayList<NhanVien>();
		nv=new NhanVien();
	}
	@SuppressWarnings("static-access")
	public ArrayList<NhanVien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhanvien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String cmnd=rs.getString(3);
				String gt=rs.getString(4);
				String sdt=rs.getString(5);
				String diachi=rs.getString(6);
				int loai=rs.getInt(7);
				String matkhau=rs.getString(6);
				NhanVien s=new NhanVien(ma,ten,cmnd,gt,sdt,diachi,loai,matkhau);
			
				ds.add(s);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@SuppressWarnings({ "static-access", "finally" })
	public boolean themNhanVien(String ten, String cmnd, String gt, String sdt, String dc, int l,String mk) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO NHANVIEN (HOTEN,CMND,GIOITINH,SODIENTHOAI,DIACHI,LOAINHANVIEN,MATKHAU) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1,ten);
			stmt.setString(2,cmnd);
			stmt.setString(3,gt);
			stmt.setString(4,sdt);
			stmt.setString(5,dc);
			stmt.setInt(6,l);
			stmt.setString(7,mk);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	@SuppressWarnings("static-access")
	public DefaultTableModel docTableQLNV(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã nhân viên","Họ tên","CMND","Giới tính","Số điện thoại","Địa chỉ","Loại nhân viên"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) *from nhanvien order by manhanvien desc";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String cmnd=rs.getString(3);
				String gioitinh=rs.getString(4);
				String sodienthoai=rs.getString(5);
				String diachi=rs.getString(6);
				int loai=rs.getInt(7);
				String loainv="Quản lý";
				if (loai==1) loainv="Nhân viên";
				String[] rowData= {ma,ten,cmnd,gioitinh,sodienthoai,diachi,loainv};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
	@SuppressWarnings("static-access")
	public String[] docTextFieldQLNV(String manv){
		String[] rowData= {};
		try {
			
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhanvien\r\n"
					+ "where manhanvien=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,manv);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String cmnd=rs.getString(3);
				String gioitinh=rs.getString(4);
				String sodienthoai=rs.getString(5);
				String diachi=rs.getString(6);
				int loai=rs.getInt(7);
				String loainv="Quản lý";
				if (loai==1) loainv="Nhân viên";
				String matkhau=rs.getString(8);
				String[] rowData2= {ma,ten,cmnd,gioitinh,sodienthoai,diachi,loainv,matkhau};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	@SuppressWarnings({ "static-access", "finally" })
	public boolean suaNhanVien(String ten, String cmnd, String gt, String sdt, String dc, String loai,String ma,String matkhau) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		int l=0;
		if (loai.equals("Nhân viên")) l=1;
		try {
		
			stmt=con.prepareStatement("update nhanvien set hoten=?, cmnd=?,gioitinh=?,sodienthoai=?,diachi=?,loainhanvien=?,matkhau=? where manhanvien=?");
			stmt.setString(1,ten);
			stmt.setString(2,cmnd);
			stmt.setString(3,gt);
			stmt.setString(4,sdt);
			stmt.setString(5,dc);
			stmt.setInt(6,l);
			stmt.setString(7,matkhau);
			stmt.setString(8,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	@SuppressWarnings("static-access")
	public DefaultTableModel locNV(String ten,String diachi,String sodienthoai,String cmnd){
		DefaultTableModel tableModel;
		String[] headers= {"Mã nhân viên","Họ tên","CMND","Giới tính","Số điện thoại","Địa chỉ","Loại nhân viên"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhanvien where hoten like ? and diachi like ? and sodienthoai like ? and cmnd like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+ten+"%");
			stm.setString(2,"%"+diachi+"%");
			stm.setString(3,"%"+sodienthoai+"%");
			stm.setString(4,"%"+cmnd+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String t=rs.getString(2);
				String cm=rs.getString(3);
				String gioitinh=rs.getString(4);
				String sdt=rs.getString(5);
				String dc=rs.getString(6);
				int loai=rs.getInt(7);
				String loainv="Quản lý";
				if (loai==1) loainv="Nhân viên";
				String[] rowData= {ma,t,cm,gioitinh,sdt,dc,loainv};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
	@SuppressWarnings("static-access")
	public String docMatKhau(String manv){
		String kq="";
		try {
			
			Connection con=Database.getInstance().getConnection();
			String sql="select matkhau from nhanvien\r\n"
					+ "where manhanvien=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,manv);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mk=rs.getString(1);
				kq=mk;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	@SuppressWarnings("static-access")
	public String docTen(String manv){
		String kq="";
		try {
			
			Connection con=Database.getInstance().getConnection();
			String sql="select hoten from nhanvien\r\n"
					+ "where manhanvien=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,manv);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String mk=rs.getString(1);
				kq=mk;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	@SuppressWarnings("static-access")
	public int docLoai(String manv){
		int kq=0;
		try {
			
			Connection con=Database.getInstance().getConnection();
			String sql="select loainhanvien from nhanvien\r\n"
					+ "where manhanvien=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,manv);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				int mk=rs.getInt(1);
				kq=mk;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
