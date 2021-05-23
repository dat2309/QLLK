package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.CTHD;
import ui.test;

public class DanhSachCTHD {
	ArrayList<CTHD> ds;
	CTHD ct;
	public DanhSachCTHD() {
		ds=new ArrayList<CTHD>();
		ct=new CTHD();
	}
	public ArrayList<CTHD> docTuBang(){
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="select *from cthd";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String mahd=rs.getString(1);
				String malk=rs.getString(2);
				int sl=rs.getInt(3);
				Double dg=rs.getDouble(4);
				CTHD s=new CTHD(mahd,malk,sl,dg);
				ds.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@SuppressWarnings("finally")
	public boolean themCTHD(String mahd, String malk, String sl, String dg) {
		@SuppressWarnings("static-access")
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO CTHD (MAHOADON,MALINHKIEN,SOLUONG,DONGIA) VALUES (?,?,?,?)");	
			int soluong=Integer.parseInt(sl);
			Double dongia=Double.parseDouble(dg);
			stmt.setString(1,mahd);
			stmt.setString(2, malk);
			stmt.setInt(3, soluong);
			stmt.setDouble(4, dongia);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	public DefaultTableModel docTableQLCTHD(String ma){
		DefaultTableModel tableModel;
		String[] headers= {"Tên linh kiện","Số lượng","Đơn giá","Thành tiền"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			@SuppressWarnings("static-access")
			Connection con=Database.getInstance().getConnection();
			String sql="select  lk.tenlinhkien, ct.soluong, ct.dongia, ct.soluong*ct.dongia*1.05\r\n"
					+ "from cthd ct inner join linhkien lk on lk.malinhkien=ct.malinhkien \r\n"
					+ "where ct.mahoadon=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,ma);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String tenlk=rs.getString(1);
				int sl=rs.getInt(2);
				Double dg=rs.getDouble(3);
				Double tt=rs.getDouble(4);
				String[] rowData= {tenlk,sl+"",test.formatter.format(dg) +" VND",test.formatter.format(tt) +" VND"};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}

	

}
