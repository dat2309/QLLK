package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Database;

public class UI_ThongKeHoaDon extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnChonNgayBatDau;
	private JButton btnChonNgayKetThuc;
	private JButton btnXem;
	private JComboBox<String> cbbLoaiThongKe;
	private JTextField txtChonNgayBatDau;
	private JTextField txtChonNgayKetThuc;
	private JTextField txtVon;
	private JTextField txtDoanhThu;
	private JTextField txtLoiNhuan;
	private JButton btnChiTiet;
	private JButton btnBietDo;
	private JButton btnXuatFile;	
	public UI_ThongKeHoaDon() {
		setTitle("Thống kê theo hóa đơn");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
        setBounds(160, 140, 1600, 830);
        setIconImage(icon);
        buld();
	}
	
	private void buld() {
		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel();
//		JPanel pnlSouth = new JPanel();
//		JPanel pnlSouthBD = new JPanel();
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter,BorderLayout.CENTER);
//		add(pnlSouth,BorderLayout.SOUTH);
		
		
		pnlNorth.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		
		//Phần north
		pnlNorth.setLayout(null);
		pnlNorth.setBackground(Color.WHITE);
		pnlNorth.setPreferredSize(new Dimension(1600,80));
		
		JLabel lblLoaiThongKe = new JLabel("Loại thống kê:");
		JLabel lblNgayBatDau = new JLabel("");
		JLabel lblNgayKetthuc = new JLabel("");
		
		btnChonNgayBatDau = new JButton("Chọn ngày");
		btnChonNgayKetThuc = new JButton("Chọn ngày");
		btnXem = new JButton("Xem");
		
		String [] type =  {"Theo ngày","Theo tháng","Theo năm"};
		
		cbbLoaiThongKe = new JComboBox<String>(type);
		
		txtChonNgayBatDau = new JTextField();
		txtChonNgayKetThuc = new JTextField();
		
		cbbLoaiThongKe.setBackground(Color.WHITE);
		
		btnChonNgayBatDau.setBackground(Color.WHITE);
		btnChonNgayKetThuc.setBackground(Color.WHITE);
		
		btnXem.setBackground(Color.decode("#92bbfc"));
	
		lblLoaiThongKe.setFont(new Font("Times new roman", Font.BOLD,16));
		lblNgayBatDau.setFont(new Font("Times new roman", Font.BOLD,16));
		lblNgayKetthuc.setFont(new Font("Times new roman", Font.BOLD,16));
		
		txtChonNgayBatDau.setFont(new Font("Times new roman", 0, 16));
		txtChonNgayKetThuc.setFont(new Font("Times new roman", 0, 16));
		
		cbbLoaiThongKe.setFont(new Font("Times new roman", 0,14));
		
		btnChonNgayBatDau.setFont(new Font("Times new roman", Font.BOLD,14));
		btnChonNgayKetThuc.setFont(new Font("Times new roman", Font.BOLD,14));
		
		btnXem.setFont(new Font("Times new roman", Font.BOLD,14));

		txtChonNgayBatDau.setEditable(false);
		txtChonNgayKetThuc.setEditable(false);
		
		txtChonNgayBatDau.setBackground(Color.WHITE);
		txtChonNgayKetThuc.setBackground(Color.WHITE);
		
		pnlNorth.add(lblLoaiThongKe);
		pnlNorth.add(cbbLoaiThongKe);
		
		pnlNorth.add(lblNgayBatDau);
		pnlNorth.add(txtChonNgayBatDau);
		pnlNorth.add(btnChonNgayBatDau);
		
		pnlNorth.add(lblNgayKetthuc);
		pnlNorth.add(txtChonNgayKetThuc);
		pnlNorth.add(btnChonNgayKetThuc);
		
		pnlNorth.add(btnXem);
		
		lblLoaiThongKe.setBounds(20, 30, 100, 30);
		cbbLoaiThongKe.setBounds(130, 30, 150, 30);
		
		lblNgayBatDau.setBounds(350, 30, 120, 30);
		txtChonNgayBatDau.setBounds(480, 30, 150, 30);
		btnChonNgayBatDau.setBounds(630, 30, 120, 30);
		
		lblNgayKetthuc.setBounds(820, 30, 120, 30);
		txtChonNgayKetThuc.setBounds(950, 30, 150, 30);
		btnChonNgayKetThuc.setBounds(1100, 30, 120, 30);
		
		btnXem.setBounds(1340, 30, 100, 30);
		
		JDialog f = this ;
		
		//Phần Center
		pnlCenter.setLayout(null);
		pnlCenter.setBackground(Color.WHITE);
		
		JLabel lblDoanhThu = new JLabel("Doanh thu:");
		JLabel lblVon = new JLabel("Vốn:");
		JLabel lblLoiNhuan = new JLabel("Lợi nhuận:");
		
		JLabel lblIconDT = new JLabel();
		JLabel lblIconV = new JLabel();
		JLabel lblIconLN = new JLabel();
		
		lblDoanhThu.setFont(new Font("Times new roman", Font.BOLD, 15));
		lblVon.setFont(new Font("Times new roman", Font.BOLD, 15));
		lblLoiNhuan.setFont(new Font("Times new roman", Font.BOLD, 15));
		
		Icon iconDT = new ImageIcon("./icon/doanhthu.png");
		Icon iconV = new ImageIcon("./icon/von.png");
		Icon iconLN = new ImageIcon("./icon/loinhuan.png");
		
		lblIconDT.setIcon(iconDT);
		lblIconV.setIcon(iconV);
		lblIconLN.setIcon(iconLN);
		
		txtDoanhThu = new JTextField(30);
		txtVon = new JTextField(30);
		txtLoiNhuan = new JTextField(30);
		
		txtDoanhThu.setText("xxx.xxx.xxx VND");
		txtVon.setText("xxx.xxx.xxx VND");
		txtLoiNhuan.setText("xxx.xxx.xxx VND");
		
		txtDoanhThu.setBorder(null);
		txtVon.setBorder(null);
		txtLoiNhuan.setBorder(null);
		
		txtDoanhThu.setEditable(false);
		txtVon.setEditable(false);
		txtLoiNhuan.setEditable(false);
		
		txtDoanhThu.setFont(new Font("Times new roman", 0, 15));
		txtVon.setFont(new Font("Times new roman", 0, 15));
		txtLoiNhuan.setFont(new Font("Times new roman", 0, 15));
		
		txtDoanhThu.setForeground(Color.RED);
		txtVon.setForeground(Color.BLACK);
		txtLoiNhuan.setForeground(Color.BLUE);
		
		txtDoanhThu.setBackground(Color.WHITE);
		txtVon.setBackground(Color.WHITE);
		txtLoiNhuan.setBackground(Color.WHITE);
		
		pnlCenter.add(lblDoanhThu);
		pnlCenter.add(lblVon);
		pnlCenter.add(lblLoiNhuan);
		
		pnlCenter.add(lblIconDT);
		pnlCenter.add(lblIconV);
		pnlCenter.add(lblIconLN);
		
		pnlCenter.add(txtDoanhThu);
		pnlCenter.add(txtVon);
		pnlCenter.add(txtLoiNhuan);
		
		btnChiTiet = new JButton("Chi tiết");
		btnBietDo = new JButton("Biểu đồ");
		btnXuatFile = new JButton("Xuất file Excel");
		
		btnChiTiet.setFont(new Font("Times new roman", Font.BOLD,14));
		btnBietDo.setFont(new Font("Times new roman", Font.BOLD,14));
		btnXuatFile.setFont(new Font("Times new roman", Font.BOLD,14));
		
		btnChiTiet.setBackground(Color.WHITE);
		btnBietDo.setBackground(Color.WHITE);
		
//		btnChiTiet.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		
		pnlCenter.add(btnChiTiet);
		pnlCenter.add(btnBietDo);
	//	pnlCenter.add(btnXuatFile);
		
		btnChiTiet.setBounds(100, 80, 100, 30);
		btnBietDo.setBounds(200, 80, 100, 30);
		btnXuatFile.setBounds(1400, 80, 150, 30);
		//******************************************
		
		lblDoanhThu.setBounds(120,10,100,30);
		lblVon.setBounds(720, 10, 100, 30);
		lblLoiNhuan.setBounds(1320,10,100,30);
		
		lblIconDT.setBounds(60, 10, 60, 60);
		lblIconV.setBounds(660, 10, 60, 60);
		lblIconLN.setBounds(1260, 10, 60, 60);
		
		txtDoanhThu.setBounds(120, 40, 200, 30);
		txtVon.setBounds(720, 40, 200, 30);
		txtLoiNhuan.setBounds(1320, 40, 200, 30);
		
		//Phần Sounth
		btnChiTiet.setEnabled(false);
		btnBietDo.setEnabled(false);
		
		UI_ChiTietThongKrHoaDon TKCT = new UI_ChiTietThongKrHoaDon();
		add(TKCT.pnlSouth,BorderLayout.SOUTH);
		
		UI_BieuDo BD = new UI_BieuDo();
		
		//=================================================================
		cbbLoaiThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cbbLoaiThongKe.getSelectedIndex();
				
				if (index == 0) {
					lblNgayBatDau.setText("Ngày bắt đầu:");
					btnChonNgayBatDau.setText("Chọn ngày");
					btnChonNgayBatDau.setEnabled(true);
					
					
					lblNgayKetthuc.setText("Ngày kết thúc:");
					btnChonNgayKetThuc.setText("Chọn ngày");
					btnChonNgayKetThuc.setEnabled(true);
					
					txtChonNgayBatDau.setText(null);
					txtChonNgayKetThuc.setText(null);
					
					txtChonNgayBatDau.setEditable(false);
					txtChonNgayKetThuc.setEditable(false);
				}
				if (index == 1) {
					lblNgayBatDau.setText("Tháng đầu:");
					btnChonNgayBatDau.setText("Chọn tháng");
					btnChonNgayBatDau.setEnabled(true);
					
					lblNgayKetthuc.setText("Tháng kết thúc:");
					btnChonNgayKetThuc.setText("Chọn tháng");
					btnChonNgayKetThuc.setEnabled(true);
					
					txtChonNgayBatDau.setText(null);
					txtChonNgayKetThuc.setText(null);
					
					txtChonNgayBatDau.setEditable(false);
					txtChonNgayKetThuc.setEditable(false);
				}
				if (index == 2) {
					lblNgayBatDau.setText("Năm đầu:");
					btnChonNgayBatDau.setText("Nhập năm");
					btnChonNgayBatDau.setEnabled(false);
					
					lblNgayKetthuc.setText("Năm kết thúc:");
					btnChonNgayKetThuc.setText("Nhập năm");
					btnChonNgayKetThuc.setEnabled(false);
					
					txtChonNgayBatDau.setText(null);
					txtChonNgayKetThuc.setText(null);
					
					txtChonNgayBatDau.setEditable(true);
					txtChonNgayKetThuc.setEditable(true);
				}
			}
		});
		
		cbbLoaiThongKe.setSelectedIndex(0);
		
		btnChonNgayBatDau.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbbLoaiThongKe.getSelectedIndex();
				if(index == 0) {
					txtChonNgayBatDau.setText(new DatePicker(f).setPickedDate());
				}
				if(index == 1) {
					txtChonNgayBatDau.setText(new DatePicker(f).setPickedMonth());
				}
				if(index == 2) {
					txtChonNgayBatDau.setText(new DatePicker(f).setPickedYear());
				}
			}
		});
		btnChonNgayKetThuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cbbLoaiThongKe.getSelectedIndex();
				if(index == 0) {
					txtChonNgayKetThuc.setText(new DatePicker(f).setPickedDate());
				}
				if(index == 1) {
					txtChonNgayKetThuc.setText(new DatePicker(f).setPickedMonth());
				}
				if(index == 2) {
					txtChonNgayKetThuc.setText(new DatePicker(f).setPickedYear());
				}
			}
		});
		
		btnXem.addActionListener(new ActionListener() {
			@SuppressWarnings({ "static-access", "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cbbLoaiThongKe.getSelectedIndex();
				btnChiTiet.setEnabled(true);
				btnBietDo.setEnabled(true);
				
				if(index == 0) {
					TKCT.pnlSouth.setVisible(true);
					if ((txtChonNgayBatDau.getText().equals("")) || (txtChonNgayKetThuc.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "Cần chọn ngày trước khi thống kê");
					} else
						try {
							if (!ktraNgay()){
								JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải ở trước ngày kết thúc");
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					{
					TKCT.setGiaTriThongKeNgay(txtChonNgayBatDau.getText().trim(), txtChonNgayKetThuc.getText().trim());
					
					String title = "Thống kê hóa đơn theo ngày";
					try {
						Connection con=Database.getInstance().getConnection();
						String sql="SELECT hoadon.ngaylap,sum(cthd.dongia*cthd.soluong*1.05) as doanhthu,count(DISTINCT hoadon.mahoadon) as soluong,sum(linhkien.dongiagoc*cthd.soluong) as von\r\n"
								+ "FROM hoadon,cthd,linhkien\r\n"
								+ "WHERE hoadon.mahoadon=cthd.mahoadon and hoadon.ngaylap BETWEEN ? and ? and linhkien.malinhkien=cthd.malinhkien\r\n"
								+ "GROUP BY hoadon.ngaylap";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setDate(1,java.sql.Date.valueOf(txtChonNgayBatDau.getText()));
						stm.setDate(2,java.sql.Date.valueOf(txtChonNgayKetThuc.getText()));
						ResultSet rs = stm.executeQuery();
						int d=1;
						List<Double> listDoanhThu=new ArrayList<Double>();
						List<Double> listLoiNhuan=new ArrayList<Double>();
						List<Double> listLoiNhuanTB=new ArrayList<Double>();
						List<String> listTrucX=new ArrayList<String>();
						Double loinhuan=0.0;
						Double doanhthu=0.0;
						Double von=0.0;
						while(rs.next()) {
							loinhuan=loinhuan+rs.getDouble(2)/1.05*1.0-rs.getDouble(4);
							doanhthu=doanhthu+rs.getDouble(2);
							von=von+rs.getDouble(4);
							listTrucX.add(rs.getDate(1).toString());
							listDoanhThu.add(rs.getDouble(2));
							listLoiNhuan.add(rs.getDouble(2)/1.05*1.0-rs.getDouble(4));
							listLoiNhuanTB.add((rs.getDouble(2)/1.05*1.0-rs.getDouble(4))/rs.getInt(3));
						}

						Double[] doanhThu=listDoanhThu.toArray(new Double[listDoanhThu.size()]);
						Double[] loiNhuan=listLoiNhuan.toArray(new Double[listLoiNhuan.size()]);
						Double[] loiNhuanTrungBinh=listLoiNhuanTB.toArray(new Double[listLoiNhuanTB.size()]);
						String[] trucX=listTrucX.toArray(new String[listTrucX.size()]);
						BD.setBietDo(title, doanhThu, loiNhuan, loiNhuanTrungBinh, trucX);
						txtDoanhThu.setText(test.formatter.format(doanhthu)+" VND");
						txtLoiNhuan.setText(test.formatter.format(loinhuan)+" VND");
						txtVon.setText(test.formatter.format(von)+" VND");
					}catch (SQLException e3) {
						e3.printStackTrace();
					}
					
					}
					
					
				}
				if(index == 1) {
					TKCT.pnlSouth.setVisible(true);
					if ((txtChonNgayBatDau.getText().equals("")) || (txtChonNgayKetThuc.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "Cần chọn tháng trước khi thống kê");
					} else
						try {
							if (!ktraThang()){
								JOptionPane.showMessageDialog(null, "Tháng bắt đầu phải ở trước hoặc bằng tháng kết thúc");
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} {
					TKCT.setGiaTriThongKeThang(txtChonNgayBatDau.getText()+"-01", txtChonNgayKetThuc.getText()+"-28");
					
					String title = "Thống kê hóa đơn theo tháng";
					try {
						Connection con=Database.getInstance().getConnection();
						String sql="SELECT FORMAT(hoadon.ngaylap, 'yyyy_MM') as thang,sum(cthd.dongia*cthd.soluong*1.05) as doanhthu,count(DISTINCT hoadon.mahoadon) as soluong,sum(linhkien.dongiagoc*cthd.soluong) as von\r\n"
								+ "FROM hoadon,cthd,linhkien\r\n"
								+ "WHERE hoadon.mahoadon=cthd.mahoadon and  DATEADD(month, DATEDIFF(month, 0, hoadon.ngaylap), 0) between DATEADD(month, DATEDIFF(month, 0, ?), 0)  and DATEADD(month, DATEDIFF(month, 0, ?), 0) and linhkien.malinhkien=cthd.malinhkien\r\n"
								+ "GROUP BY FORMAT(hoadon.ngaylap, 'yyyy_MM')";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setDate(1,java.sql.Date.valueOf(txtChonNgayBatDau.getText()+"-01"));
						stm.setDate(2,java.sql.Date.valueOf(txtChonNgayKetThuc.getText()+"-28"));
						ResultSet rs = stm.executeQuery();
						int d=1;
						List<Double> listDoanhThu=new ArrayList<Double>();
						List<Double> listLoiNhuan=new ArrayList<Double>();
						List<Double> listLoiNhuanTB=new ArrayList<Double>();
						List<String> listTrucX=new ArrayList<String>();
						Double loinhuan=0.0;
						Double doanhthu=0.0;
						Double von=0.0;
						while(rs.next()) {
							loinhuan=loinhuan+rs.getDouble(2)/1.05*1.0-rs.getDouble(4);
							doanhthu=doanhthu+rs.getDouble(2);
							von=von+rs.getDouble(4);
							
							listTrucX.add(rs.getString(1));
							listDoanhThu.add(rs.getDouble(2));
							listLoiNhuan.add(rs.getDouble(2)/1.05*1.0-rs.getDouble(4));
							listLoiNhuanTB.add((rs.getDouble(2)/1.05*1.0-rs.getDouble(4))/rs.getInt(3));
						}

						Double[] doanhThu=listDoanhThu.toArray(new Double[listDoanhThu.size()]);
						Double[] loiNhuan=listLoiNhuan.toArray(new Double[listLoiNhuan.size()]);
						Double[] loiNhuanTrungBinh=listLoiNhuanTB.toArray(new Double[listLoiNhuanTB.size()]);
						String[] trucX=listTrucX.toArray(new String[listTrucX.size()]);
						txtDoanhThu.setText(test.formatter.format(doanhthu)+" VND");
						txtLoiNhuan.setText(test.formatter.format(loinhuan)+" VND");
						txtVon.setText(test.formatter.format(von)+" VND");
						BD.setBietDo(title, doanhThu, loiNhuan, loiNhuanTrungBinh, trucX);
					}catch (SQLException e3) {
						e3.printStackTrace();
					}
					
					}
					
					//BD.setBietDo(title, doanhThu, loiNhuan, loiNhuanTrungBinh, trucX);
					
				}
				if(index == 2) {
					TKCT.pnlSouth.setVisible(true);
					if (!(txtChonNgayBatDau.getText().matches("\\d+")) || !(txtChonNgayKetThuc.getText().matches("\\d+"))) {
						JOptionPane.showMessageDialog(null, "Cần điền năm trước khi thống kê");
					} else
						try {
							if (!ktraNam()){
								JOptionPane.showMessageDialog(null, "Năm bắt đầu phải ở trước hoặc bằng năm kết thúc");
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}{
					TKCT.setGiaTriThongKeNam(txtChonNgayBatDau.getText()+"-01-01", txtChonNgayKetThuc.getText()+"-12-31");
					
					String title = "Thống kê hóa đơn theo năm";
					try {
						Connection con=Database.getInstance().getConnection();
						String sql="SELECT FORMAT(hoadon.ngaylap, 'yyyy') as thang,sum(cthd.dongia*cthd.soluong*1.05) as doanhthu,count(DISTINCT hoadon.mahoadon) as soluong,sum(linhkien.dongiagoc*cthd.soluong) as von\r\n"
								+ "FROM hoadon,cthd,linhkien\r\n"
								+ "WHERE hoadon.mahoadon=cthd.mahoadon and  DATEADD(year, DATEDIFF(year, 0, hoadon.ngaylap), 0) between DATEADD(year, DATEDIFF(year, 0, ?), 0)  and DATEADD(year, DATEDIFF(year, 0, ?), 0) and linhkien.malinhkien=cthd.malinhkien\r\n"
								+ "GROUP BY FORMAT(hoadon.ngaylap, 'yyyy')";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setDate(1,java.sql.Date.valueOf(txtChonNgayBatDau.getText()+"-01-01"));
						stm.setDate(2,java.sql.Date.valueOf(txtChonNgayKetThuc.getText()+"-12-31"));
						ResultSet rs = stm.executeQuery();
						int d=1;
						List<Double> listDoanhThu=new ArrayList<Double>();
						List<Double> listLoiNhuan=new ArrayList<Double>();
						List<Double> listLoiNhuanTB=new ArrayList<Double>();
						List<String> listTrucX=new ArrayList<String>();
						Double loinhuan=0.0;
						Double doanhthu=0.0;
						Double von=0.0;
						while(rs.next()) {
							loinhuan=loinhuan+rs.getDouble(2)/1.05*1.0-rs.getDouble(4);
							doanhthu=doanhthu+rs.getDouble(2);
							von=von+rs.getDouble(4);
							listTrucX.add(rs.getString(1));
							listDoanhThu.add(rs.getDouble(2));
							listLoiNhuan.add(rs.getDouble(2)/1.05*1.0-rs.getDouble(4));
							listLoiNhuanTB.add((rs.getDouble(2)/1.05*1.0-rs.getDouble(4))/rs.getInt(3));
						}

						Double[] doanhThu=listDoanhThu.toArray(new Double[listDoanhThu.size()]);
						Double[] loiNhuan=listLoiNhuan.toArray(new Double[listLoiNhuan.size()]);
						Double[] loiNhuanTrungBinh=listLoiNhuanTB.toArray(new Double[listLoiNhuanTB.size()]);
						
						
						
						String[] trucX=listTrucX.toArray(new String[listTrucX.size()]);
						txtDoanhThu.setText(test.formatter.format(doanhthu)+" VND");
						txtLoiNhuan.setText(test.formatter.format(loinhuan)+" VND");
						txtVon.setText(test.formatter.format(von)+" VND");
						BD.setBietDo(title, doanhThu, loiNhuan, loiNhuanTrungBinh, trucX);
					}catch (SQLException e3) {
						e3.printStackTrace();
					}
					
					}
				//	BD.setBietDo(title, doanhThu, loiNhuan, loiNhuanTrungBinh, trucX);
					
				}
			}

			private boolean ktraNgay() throws ParseException {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = sdf.parse(txtChonNgayBatDau.getText()); //date1 là 23/2/1995 
				Date date2 = sdf.parse(txtChonNgayKetThuc.getText()); //date2 là 31/10/2001
		
				date1.compareTo(date2);
				date2.compareTo(date1); 
			
				return (date1.before(date2) ||date1.equals(date2));
			}
			private boolean ktraThang() throws ParseException {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = sdf.parse(txtChonNgayBatDau.getText()+"-01"); //date1 là 23/2/1995 
				Date date2 = sdf.parse(txtChonNgayKetThuc.getText()+"-01"); //date2 là 31/10/2001
		
				date1.compareTo(date2);
				date2.compareTo(date1); 
			
				return (date1.before(date2) ||date1.equals(date2));
			}
			private boolean ktraNam() throws ParseException {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = sdf.parse(txtChonNgayBatDau.getText()+"-01-01"); //date1 là 23/2/1995 
				Date date2 = sdf.parse(txtChonNgayKetThuc.getText()+"-01-01"); //date2 là 31/10/2001
		
				date1.compareTo(date2);
				date2.compareTo(date1); 
			
				return (date1.before(date2) ||date1.equals(date2));
			}
		});
		
		
		///============================		
		
		btnChiTiet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TKCT.pnlSouth.setVisible(true);
			}
		});
		btnBietDo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(BD.pnlSouthBD,BorderLayout.SOUTH);
				TKCT.pnlSouth.setVisible(false);
			}
		});
	}
}
