package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.Box;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import java.awt.Font;



import javax.swing.JButton;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableModel;


import dao.DanhSachCTHD;
import dao.DanhSachHoaDon;

import dao.Database;

import javax.swing.border.Border;

import javax.swing.SwingConstants;

public class UI_HoaDon extends JDialog implements MouseListener, ActionListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi,bCTHD;
	
	private JLabel lblMaHoaDon,lblNgayLap,lblMaNhanVien,lblMaKhachHang,lblTenKhachHang,lblTenNhanVien,lblSoLuong,lblTongTienHang,lblThue,lblTongCong;
	private JTextField txtMaHoaDon,txtNgayLap,txtMaNhanVien,txtMaKhachHang,txtTenKhachHang,txtTenNhanVien,txtSoLuong,txtTongTienHang,txtThue,txtTongCong;
	private JButton btnThem;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	private DefaultTableModel dataModel;
	private JTable table;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private DanhSachHoaDon dshd=new DanhSachHoaDon();
	public String maLoai,maNCC;
	public int hanhdong;

	private JTextField txtTenNVTK;
	private JButton btnTimKiem;
	private Component horizontalStrut_3;
	private JLabel lblTenNVTK;
	private JLabel lblTenKHTK;
	private JTextField txtTenKHTK;
	private Component horizontalStrut_4;
	
	private DefaultTableModel dataModel2;
	private JTable table2;
	private DanhSachCTHD dsct=new DanhSachCTHD();
	private Component horizontalStrut_5;
	private JTextField txtChonNgayKetThuc;
	private JLabel lblNBD;
	private JTextField txtChonNgayBatDau;
	private JLabel lblNKT;
	private JButton btnChonNgayBatDau;
	private JButton btnChonNgayKetThuc;
	private JButton btnXoaRong;
	private Component horizontalStrut_6;
	private Component horizontalStrut_7;
	public UI_HoaDon() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Quản lý hóa đơn");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        
        hanhdong=0;
        buildUI();
        
	}

	@SuppressWarnings("serial")
	private void buildUI() {
		getContentPane().add(bTong=Box.createVerticalBox());
		
		bTong.add(Box.createVerticalStrut(10));
		bTong.add(bTren=Box.createHorizontalBox());
		bTong.add(Box.createVerticalStrut(20));
		bTong.add(bGiua=Box.createHorizontalBox());
		bTong.add(Box.createVerticalStrut(20));
		bTong.add(bDuoi=Box.createVerticalBox());

		
		//thong tin linh kien
		bThongTin=Box.createVerticalBox();
		bThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bTren.add(bThongTin);
		bThongTin.setBackground(Color.WHITE);
		bThongTin.setBorder(new TitledBorder(null, "Thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaHoaDon=new JLabel("Mã hóa đơn: ");
		lblMaHoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgayLap=new JLabel("Ngày Lập: ");
		lblNgayLap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNhanVien=new JLabel("Mã nhân viên: ");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaKhachHang=new JLabel("Mã khách hàng: ");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenKhachHang=new JLabel("Tên khách hàng: ");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenNhanVien=new JLabel("Tên nhân viên: ");
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuong=new JLabel("Số lượng: ");
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTongTienHang=new JLabel("Tổng tiền hàng: ");
		lblTongTienHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongTienHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThue=new JLabel("Thuế: ");
		lblThue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTongCong=new JLabel("Tổng cộng: ");
		lblTongCong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongCong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
	
		lblMaHoaDon.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblMaNhanVien.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblSoLuong.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblThue.setPreferredSize(lblMaKhachHang.getPreferredSize());
		
		lblNgayLap.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTenNhanVien.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTongTienHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTongCong.setPreferredSize(lblTenKhachHang.getPreferredSize());
		
		
		
		txtMaHoaDon=new JTextField();
		txtMaHoaDon.setColumns(7);
		txtMaHoaDon.setBackground(Color.WHITE);
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNgayLap=new JTextField();
		txtNgayLap.setColumns(7);
		txtNgayLap.setBackground(Color.WHITE);
		txtNgayLap.setEditable(false);
		txtNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaNhanVien=new JTextField();
		txtMaNhanVien.setColumns(7);
		txtMaNhanVien.setBackground(Color.WHITE);
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaKhachHang=new JTextField();
		txtMaKhachHang.setColumns(7);
		txtMaKhachHang.setBackground(Color.WHITE);
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenKhachHang=new JTextField();
		txtTenKhachHang.setColumns(7);
		txtTenKhachHang.setBackground(Color.WHITE);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenNhanVien=new JTextField();
		txtTenNhanVien.setColumns(7);
		txtTenNhanVien.setBackground(Color.WHITE);
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong=new JTextField();
		txtSoLuong.setColumns(7);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTongTienHang=new JTextField();
		txtTongTienHang.setColumns(7);
		txtTongTienHang.setBackground(Color.WHITE);
		txtTongTienHang.setEditable(false);
		txtTongTienHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtThue=new JTextField();
		txtThue.setColumns(7);
		txtThue.setBackground(Color.WHITE);
		txtThue.setEditable(false);
		txtThue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTongCong=new JTextField();
		txtTongCong.setColumns(7);
		txtTongCong.setBackground(Color.WHITE);
		txtTongCong.setEditable(false);
		txtTongCong.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//add vao
		Box b01,b02,b03,b04,b05,b06,b07,b08;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		b03=Box.createHorizontalBox();
		b04=Box.createHorizontalBox();
		b05=Box.createHorizontalBox();
		b06=Box.createHorizontalBox();
		b07=Box.createHorizontalBox();
		b08=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b03);
		bThongTin.add(b04);
		bThongTin.add(b05);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b06);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b07);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b08);
		
		b01.add(lblMaHoaDon);
		b01.add(txtMaHoaDon);
		b01.add(lblNgayLap);
		b01.add(txtNgayLap);
	
		b02.add(lblMaNhanVien);
		b02.add(txtMaNhanVien);
		b02.add(lblTenNhanVien);
		b02.add(txtTenNhanVien);
		b03.add(lblMaKhachHang);
		b03.add(txtMaKhachHang);
		b03.add(lblTenKhachHang);
		b03.add(txtTenKhachHang);
		b06.add(lblSoLuong);
		b06.add(txtSoLuong);
		b06.add(lblTongTienHang);
		b06.add(txtTongTienHang);
		b07.add(lblThue);
		b07.add(txtThue);
		b07.add(lblTongCong);
		b07.add(txtTongCong);
		// hinh an linh kien
		bCTHD=Box.createVerticalBox();
		bTren.add(bCTHD);
		bCTHD.setBackground(Color.WHITE);
		bCTHD.setBorder(new TitledBorder(null, "Chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		//cthd
		
		String[] headers2= {"Tên linh kiện","Số lượng","Đơn giá","Thành tiền"};
		dataModel2=new DefaultTableModel(headers2,0);	
		JScrollPane scroll2;
		bCTHD.add(scroll2=new JScrollPane(table2=new JTable(dataModel2)));
		dataModel2.setRowCount(0);
	//	table2.setModel(dsct.docTableQLCTHD());
		table2.setRowHeight(50);
		scroll2.setPreferredSize(new Dimension(500,300));
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Tạo hóa đơn");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThongBao=new JLabel("Trạng Thái:        ");
		lblThongBao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtThongBao=new JTextField(){
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		txtThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 15));;
		txtThongBao.setBackground(Color.WHITE);
		txtThongBao.setForeground(Color.BLACK);
		txtThongBao.setEditable(false);
		
		horizontalStrut_5 = Box.createHorizontalStrut(50);
		bChucNang.add(horizontalStrut_5);
		bChucNang.add(btnThem);
		bChucNang.add(Box.createHorizontalStrut(120));
		bChucNang.add(lblThongBao);
		bChucNang.add(txtThongBao);
		//bduoi
		//tim kiem
		Box btk=Box.createVerticalBox();
		bDuoi.add(btk);
		btk.setBorder(new TitledBorder("Tìm Kiếm"));
		Box b11,b12;
		b11=Box.createHorizontalBox();
		b12=Box.createHorizontalBox();
		btk.add(b11);
		btk.add(Box.createVerticalStrut(10));
		btk.add(b12);
	   
		@SuppressWarnings("unused")
		String mota1[]= {"Tất cả"};
		
		lblTenNVTK = new JLabel("Tên nhân viên: ");
		lblTenNVTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblTenNVTK);
		
		txtTenNVTK = new JTextField();
		txtTenNVTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(txtTenNVTK);
		
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		b11.add(horizontalStrut_4);
		
		lblTenKHTK = new JLabel("Tên khách hàng: ");
		lblTenKHTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblTenKHTK);
		
		txtTenKHTK = new JTextField();
		txtTenKHTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(txtTenKHTK);
		
		lblNBD = new JLabel("Ngày bắt đầu: ");
		lblNBD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblNBD);
		
		txtChonNgayBatDau = new JTextField();
		txtChonNgayBatDau.setEditable(false);
		txtChonNgayBatDau.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(txtChonNgayBatDau);
		
		btnChonNgayBatDau = new JButton("Chọn");
		btnChonNgayBatDau.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(btnChonNgayBatDau);
		
		lblNKT = new JLabel("Ngày kết thúc: ");
		lblNKT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblNKT);
		
		txtChonNgayKetThuc = new JTextField();
		txtChonNgayKetThuc.setEditable(false);
		txtChonNgayKetThuc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(txtChonNgayKetThuc);
		
		btnChonNgayKetThuc = new JButton("Chọn");
		btnChonNgayKetThuc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(btnChonNgayKetThuc);
		
		horizontalStrut_7 = Box.createHorizontalStrut(20);
		b11.add(horizontalStrut_7);
		
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(btnXoaRong);
		
		horizontalStrut_6 = Box.createHorizontalStrut(20);
		b11.add(horizontalStrut_6);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		b11.add(horizontalStrut_3);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(btnTimKiem);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_1);
		
		horizontalStrut_2 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_2);
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách hóa đơn"));
		String[] headers= {"Mã hóa đơn","Ngày lập","Tên nhân viên","Tên khách hàng","Tổng số lượng","Tổng tiền hàng","Thuế","Tổng cộng"};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dshd.docTableQLHD());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		
		setTrangThai("Xem thông tin hóa đơn");
		btnTimKiem.addActionListener(this);
		JDialog f = this;
		btnChonNgayBatDau.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
			
					txtChonNgayBatDau.setText(new DatePicker(f).setPickedDate());
				
			}
		});
		btnChonNgayKetThuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					txtChonNgayKetThuc.setText(new DatePicker(f).setPickedDate());
			}
		});
		btnXoaRong.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				txtTenKHTK.setText("");
				txtTenNVTK.setText("");
				txtChonNgayBatDau.setText("");
				txtChonNgayKetThuc.setText("");
				
			}
		});
	}

	private void setTrangThai(String string) {
		// TODO Auto-generated method stub
		txtThongBao.setText(string);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		if (row>-1) {
			//	String[] rowData2= {ma,ngaylap+"",manv,nv,makh,kh,sl+"",test.formatter.format(dg)+" VND",test.thue+" %",test.formatter.format(tt)+" VND"};
			String ma=table.getValueAt(row, 0).toString();
			String[] ttam=dshd.docTextFieldQLHD(ma);
			txtMaHoaDon.setText(ttam[0]);
			txtNgayLap.setText(ttam[1]);
			txtMaNhanVien.setText(ttam[2]);
			txtTenNhanVien.setText(ttam[3]);
			txtMaKhachHang.setText(ttam[4]);
			txtTenKhachHang.setText(ttam[5]);
			txtSoLuong.setText(ttam[6]);
			txtTongTienHang.setText(ttam[7]);
			txtThue.setText(ttam[8]);
			txtTongCong.setText(ttam[9]);
			docTableCTHD(ma);
		}
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if (o.equals(btnThem)) {
			UI_ThemHoaDon frm=new UI_ThemHoaDon();
			frm.setVisible(true);
			this.dispose();
		}else if (o.equals(btnTimKiem)) {
			locTK();
		}
	}
	
	private void locTK() {
		// TODO Auto-generated method stub
		
		dataModel.setRowCount(0);
		String nv=txtTenNVTK.getText();
		String kh=txtTenKHTK.getText();
		if ((txtChonNgayBatDau.getText().equals("")) || (txtChonNgayKetThuc.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Cần chọn ngày trước khi tìm kiếm");
		}else {
			table.setModel(dshd.locHD(nv,kh,txtChonNgayBatDau.getText(),txtChonNgayKetThuc.getText()));
			
		}
		table.setRowHeight(50);
		
	}

		
	private void docTableCTHD(String ma) {
		dataModel2.setRowCount(0);
		table2.setModel(dsct.docTableQLCTHD(ma));
		table2.setRowHeight(50);
	}

	
}
