package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import entity.LoaiLinhKien;

public class DanhSachLoaiLinhKien {
	ArrayList<LoaiLinhKien> ds;
	LoaiLinhKien llk;
	public DanhSachLoaiLinhKien() {
		ds=new ArrayList<LoaiLinhKien>();
		llk=new LoaiLinhKien();
	}
	@SuppressWarnings("static-access")
	public ArrayList<LoaiLinhKien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String mt1=rs.getString(3);
				String mt2=rs.getString(4);
				String mt3=rs.getString(5);
				String mt4=rs.getString(6);
				LoaiLinhKien llk= new LoaiLinhKien(ma,ten,mt1,mt2,mt3,mt4);
				ds.add(llk);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	@SuppressWarnings({ "static-access", "finally" })
	public boolean themllk(String ten, String mt1,String mt2,String mt3,String mt4) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO LOAILINHKIEN (TENLOAI,MOTA1,MOTA2,MOTA3,MOTA4) VALUES(?,?,?,?,?)");
			stmt.setString(1,ten);
			stmt.setString(2,mt1);
			stmt.setString(3,mt2);
			stmt.setString(4,mt3);
			stmt.setString(5,mt4);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	@SuppressWarnings("static-access")
	public DefaultTableModel docTableQLLLK(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã loại","Tên loại","Mô tả 1","Mô tả 2","Mô tả 3","Mô tả 4"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) *from loailinhkien order by maloai desc";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String mt1=rs.getString(3);
				String mt2=rs.getString(4);
				String mt3=rs.getString(5);
				String mt4=rs.getString(6);
				
				String[] rowData= {ma,ten,mt1,mt2,mt3,mt4};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	@SuppressWarnings("static-access")
	public String[] docTextFieldQLLLK(String mal){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien\r\n"
					+ "where maloai=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,mal);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String mt1=rs.getString(3);
				String mt2=rs.getString(4);
				String mt3=rs.getString(5);
				String mt4=rs.getString(6);
				String[] rowData2= {ma,ten,mt1,mt2,mt3,mt4};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	@SuppressWarnings({ "static-access", "finally" })
	public boolean suaLoai(String ten,String mt1,String mt2,String mt3,String mt4,String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update loailinhkien set tenloai=?, mota1=?,mota2=?,mota3=?,mota4=? where maloai=?");
			stmt.setString(1,ten);
			stmt.setString(2,mt1);
			stmt.setString(3,mt2);
			stmt.setString(4,mt3);
			stmt.setString(5,mt4);
			stmt.setString(6,ma);
			
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	@SuppressWarnings("static-access")
	public DefaultTableModel locLLK(String ten){
		DefaultTableModel tableModel;
		String[] headers= {"Mã loại","Tên loại","Mô tả 1","Mô tả 2","Mô tả 3","Mô tả 4"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien where tenloai like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+ten+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String tenloai=rs.getString(2);
				String mt1=rs.getString(3);
				String mt2=rs.getString(4);
				String mt3=rs.getString(5);
				String mt4=rs.getString(6);
				
				String[] rowData= {ma,tenloai,mt1,mt2,mt3,mt4};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	@SuppressWarnings("static-access")
	public ArrayList<String> docCBOLoai(){
		ArrayList<String> kq=new ArrayList<String>();
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select tenloai from loailinhkien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ten=rs.getString(1);
				kq.add(ten);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	@SuppressWarnings("static-access")
	public String[] docMoTaLoai(String tenloai){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select mota1,mota2,mota3,mota4 from loailinhkien where tenloai=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenloai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String m1=rs.getString(1);
				String m2=rs.getString(2);
				String m3=rs.getString(3);
				String m4=rs.getString(4);
				String[] rowData2= {m1,m2,m3,m4};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	@SuppressWarnings("static-access")
	public String docMaLoaiByTen(String tenloai){
		String kq=null;
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select maloai from loailinhkien where tenloai=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenloai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String m1=rs.getString(1);
				kq=m1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	@SuppressWarnings("static-access")
	public String[] docMoTaLoaiByMa(String maloai){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select mota1,mota2,mota3,mota4 from loailinhkien where maloai=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,maloai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String m1=rs.getString(1);
				String m2=rs.getString(2);
				String m3=rs.getString(3);
				String m4=rs.getString(4);
				String[] rowData2= {m1,m2,m3,m4};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
}
