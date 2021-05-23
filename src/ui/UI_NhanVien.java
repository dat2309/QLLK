package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableModel;



import dao.DanhSachNhanVien;


import dao.Database;

import javax.swing.border.Border;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_NhanVien extends JDialog implements MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi;
	
	private JLabel lblMaNV,lblTenNV,lblCMND,lblGioiTinh,lblDiaChi,lblSoDienThoai,lblLoaiNV;
	private JTextField txtMaNV,txtTenNV,txtCMND,txtDiaChi,txtSoDienThoai,txtLoaiNV;	
	@SuppressWarnings("rawtypes")
	private JComboBox cboGioiTinh;
	
	private JButton btnThem, btnSua,btnLuu,btnHuy;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	public JComboBox<String> cboMoTa3,cboMoTa4;
	private JTextField txtTenTK;
	private JButton btnTimKiem;
	
	private DefaultTableModel dataModel;
	private JTable table;

	private JComboBox<String> cboLoaiNhanVien;
	private JTextField txtMatKhau;
	
	public String maLoai,maNCC;
	public int hanhdong;
	

	private DanhSachNhanVien dsnv=new DanhSachNhanVien();

	private JLabel lblTenTK;
	private JTextField txtCMNDTK;
	private JTextField txtSoDienThoaiTK;
	private JTextField txtDiaChiTK;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut_5;
	private Component horizontalStrut_6;
	private Component horizontalStrut_7;
	
	public UI_NhanVien() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Quản lý nhân viên");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        maLoai=null;
        maNCC=null;
        hanhdong=0;
        buildUI();
        
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "serial", "unused" })
	private void buildUI() {
		// TODO Auto-generated method stub
		
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
		bThongTin.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaNV=new JLabel("Mã nhân viên: ");
		lblMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenNV=new JLabel("Tên nhân viên: ");
		lblTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCMND=new JLabel("CMND: ");
		lblCMND.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinh=new JLabel("Giới tính: ");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai=new JLabel("Số điện thoại: ");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi=new JLabel("Địa chỉ: ");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoaiNV=new JLabel("Loại NV:");
		lblLoaiNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JLabel lblMatKhau=new JLabel("Mật Khẩu: ");
		lblMatKhau.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblGioiTinh.setPreferredSize(lblTenNV.getPreferredSize());
		lblCMND.setPreferredSize(lblMaNV.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblMaNV.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaNV.getPreferredSize());
		lblLoaiNV.setPreferredSize(lblTenNV.getPreferredSize());
		lblMatKhau.setPreferredSize(lblMaNV.getPreferredSize());
		
		
		
		txtMaNV=new JTextField();
		txtMaNV.setColumns(7);
		txtMaNV.setBackground(Color.WHITE);
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenNV=new JTextField();
		txtTenNV.setColumns(7);
		txtTenNV.setBackground(Color.WHITE);
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCMND=new JTextField();
		txtCMND.setColumns(21);
		txtCMND.setBackground(Color.WHITE);
		txtCMND.setEditable(false);
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		String[] gt= {"Nam","Nữ"};
		cboGioiTinh=new JComboBox(gt);
		cboGioiTinh.setBackground(Color.WHITE);
		cboGioiTinh.setEditable(true);
		cboGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoDienThoai=new JTextField();
		txtSoDienThoai.setColumns(7);
		txtSoDienThoai.setBackground(Color.WHITE);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDiaChi=new JTextField();
		txtDiaChi.setColumns(7);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		String[] lnv= {"Quản lý","Nhân viên"};
		cboLoaiNhanVien=new JComboBox(lnv);
		cboLoaiNhanVien.setBackground(Color.WHITE);
		cboLoaiNhanVien.setEditable(true);
		cboLoaiNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		txtLoaiNV=new JTextField();
		txtLoaiNV.setColumns(7);
		txtLoaiNV.setBackground(Color.WHITE);
		txtLoaiNV.setEditable(false);
		txtLoaiNV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtMatKhau=new JTextField();
		txtMatKhau.setColumns(7);
		txtMatKhau.setBackground(Color.WHITE);
		txtMatKhau.setEditable(false);
		txtMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//add vao
		Box b01,b02,b03,b04;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		b03=Box.createHorizontalBox();
		b04=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b03);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b04);
		bThongTin.add(Box.createVerticalStrut(5));
		
		b01.add(lblMaNV);
		b01.add(txtMaNV);
		b01.add(lblTenNV);
		b01.add(txtTenNV);
	
		b02.add(lblCMND);
		b02.add(txtCMND);
		b02.add(lblGioiTinh);
		b02.add(cboGioiTinh);
		
		horizontalStrut_7 = Box.createHorizontalStrut(10);
		b02.add(horizontalStrut_7);
		
	
		b02.add(lblLoaiNV);
		b02.add(cboLoaiNhanVien);
		
		b03.add(lblDiaChi);
		b03.add(txtDiaChi);
		b03.add(lblSoDienThoai);
		b03.add(txtSoDienThoai);
	
		b04.add(lblMatKhau);
		b04.add(txtMatKhau);
		// hinh an linh kien
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Thêm nhân viên mới");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua=new JButton("Thay đổi thông tin");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLuu=new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy=new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
		bChucNang.add(btnThem);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnSua);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnLuu);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnHuy);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(Box.createHorizontalStrut(120));
		bChucNang.add(lblThongBao);
		bChucNang.add(txtThongBao);
		//bduoi
		//tim kiem
		Box btk=Box.createVerticalBox();
		bDuoi.add(btk);
		btk.setBorder(new TitledBorder("Tìm Kiếm"));
		Box b11;
		
		verticalStrut = Box.createVerticalStrut(20);
		btk.add(verticalStrut);
		b11=Box.createHorizontalBox();
		
		btk.add(b11);
		
		txtTenTK=new JTextField();
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnTimKiem=new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		lblTenTK = new JLabel("Tên nhân viên:   ");
		lblTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblCMNDTK = new JLabel("CMND:  ");
		lblCMNDTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JLabel lblSoDienThoaiTK = new JLabel("Số Điện Thoại:   ");
		lblSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JLabel lblDiaChiTK = new JLabel("Địa chỉ: ");
		lblDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtCMNDTK=new JTextField();
		txtCMNDTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoDienThoaiTK=new JTextField();
		txtSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiaChiTK=new JTextField();
		txtDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		
		b11.add(lblTenTK);
		b11.add(txtTenTK);
		
		horizontalStrut_3 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_3);
		b11.add(lblCMNDTK);
		b11.add(txtCMNDTK);
		
		horizontalStrut_4 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_4);
		b11.add(lblSoDienThoaiTK);
		b11.add(txtSoDienThoaiTK);
		
		horizontalStrut_6 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_6);
		b11.add(lblDiaChiTK);
		b11.add(txtDiaChiTK);
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_5);
		b11.add(btnTimKiem);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		btk.add(verticalStrut_1);
		
	
		btk.setMaximumSize(new Dimension(1600, 100));
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách nhân viên"));
		String[] headers= {"Mã nhân viên","Họ tên","CMND","Giới tính","Số điện thoại","Địa chỉ","Loại nhân viên"};
		dataModel=new DefaultTableModel(headers,0);	
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dsnv.docTableQLNV());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin nhân viên");
		xoaRongTextField();
		
		txtTenNV.addKeyListener(this);
		txtCMND.addKeyListener(this);
		txtSoDienThoai.addKeyListener(this);
		txtDiaChi.addKeyListener(this);
		txtMatKhau.addKeyListener(this);
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
			String ma=table.getValueAt(row, 0).toString();
			String[] ttam=dsnv.docTextFieldQLNV(ma);
			//{ma,ten,cmnd,gioitinh,sodienthoai,diachi,loainv};
			txtMaNV.setText(ttam[0]);
			txtTenNV.setText(ttam[1]);
			txtCMND.setText(ttam[2]);
			cboGioiTinh.setSelectedIndex(1);
			if (ttam[3].equals("Nam")) cboGioiTinh.setSelectedIndex(0);
			txtSoDienThoai.setText(ttam[4]);
			txtDiaChi.setText(ttam[5]);
			cboLoaiNhanVien.setSelectedItem(ttam[6]);
		//	txtLoaiNV.setText(ttam[6]);
			txtMatKhau.setText(ttam[7]);
			
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
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			
			table.setEnabled(false);
			table.clearSelection();
			xoaRongTextField();
			editTextField();
			hanhdong=1;
			txtMaNV.setText(" <<Tự động tạo>>");
			setTrangThai("Thêm nhân viên mới, nhập thông tin trên các ô trống và bấm lưu.");
			cboLoaiNhanVien.setSelectedIndex(1);
		}else
		if (o.equals(btnSua)) {
			if (!txtMaNV.getText().equals("")) {
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				
				table.setEnabled(false);
				table.clearSelection();
				editTextField();
				
				hanhdong=2;
				setTrangThai("Thay đổi thông tin nhân viên, sửa đổi thông tin cần thiết và bấm lưu.");
			}else {
				JOptionPane.showMessageDialog(null, "Cần chọn nhân viên trong bảng trước khi thay đổi.");
			}
		
		}else
		if (o.equals(btnHuy)) {
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnHuy.setEnabled(false);
			btnLuu.setEnabled(false);
			table.setEnabled(true);
			xoaRongTextField();
			falseEditTextField();
			hanhdong=0;
			setTrangThai("Xem thông tin nhân viên");
		}else
		
		if (o.equals(btnLuu)) {
			
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn thêm nhân viên này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					if (themNhanVien()) {
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
						btnHuy.setEnabled(false);
						btnLuu.setEnabled(false);
						table.setEnabled(true);
						table.clearSelection();
						xoaRongTextField();
						falseEditTextField();
						table.setEnabled(true);
						dataModel.setRowCount(0);
						table.setModel(dsnv.docTableQLNV());
						table.setRowHeight(50);
						hanhdong=0;
						setTrangThai("Xem thông tin nhân viên");
						JOptionPane.showMessageDialog(null, "Thêm thành công.");
						
					}
						
			
				}
				}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "Bạn có muốn thay đổi thông tin nhân viên này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						@SuppressWarnings("unused")
						String gt="Nam";
						if(suaNhanVien()) {
							btnThem.setEnabled(true);
							btnSua.setEnabled(true);
							btnHuy.setEnabled(false);
							btnLuu.setEnabled(false);
							table.setEnabled(true);
							table.clearSelection();
							xoaRongTextField();
							falseEditTextField();
							table.setEnabled(true);

							dataModel.setRowCount(0);
							table.setModel(dsnv.docTableQLNV());
							table.setRowHeight(50);
							hanhdong=0;
							setTrangThai("Xem thông tin nhân viên");
							JOptionPane.showMessageDialog(null, "thay đổi thành công.");
						}
						
				}
			}
			
			
		}else
		
		if (o.equals(btnTimKiem)) {
			locTK();
		}
		
	}
	
	
	private boolean themNhanVien() {
		if (ktra()) {
			String gt="Nam";
			if (cboGioiTinh.getSelectedIndex()==1) gt="Nữ";
			int loai=0;
			if (cboLoaiNhanVien.getSelectedItem().toString().equals("Nhân viên"))loai=1;
			if (dsnv.themNhanVien(txtTenNV.getText(), txtCMND.getText(), gt, txtSoDienThoai.getText(), txtDiaChi.getText(), loai,txtMatKhau.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thêm không thành công.");
		return false;
	}
	private boolean suaNhanVien() {
		if (ktra()) {
			String gt="Nam";
			if (cboGioiTinh.getSelectedIndex()==1) gt="Nữ";
			@SuppressWarnings("unused")
			int loai=0;
			if (cboLoaiNhanVien.getSelectedItem().toString().equals("Nhân viên"))loai=1;
			if (dsnv.suaNhanVien(txtTenNV.getText(), txtCMND.getText(),gt, txtSoDienThoai.getText(), txtDiaChi.getText(), txtLoaiNV.getText(), txtMaNV.getText(),txtMatKhau.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thay đổi không thành công.");
		return false;
	}
	private boolean ktra() {
		boolean kq=true;
		if (hanhdong==1 || hanhdong==2) {
			txtThongBao.setForeground(Color.BLACK);
			txtMaNV.setBorder(new LineBorder(Color.BLACK, 1));
			txtTenNV.setBorder(new LineBorder(Color.BLACK, 1));
			txtCMND.setBorder(new LineBorder(Color.BLACK, 1));
			txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
			txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
			txtMatKhau.setBorder(new LineBorder(Color.BLACK, 1));
			txtThongBao.setText("Nhập liệu và bấm vào nút lưu.");
			
			
		
			
			
			if (txtMatKhau.getText().equals("") || !(txtMatKhau.getText().length()>=6) || !(txtMatKhau.getText().length()<=12)  ) {
				txtThongBao.setText("Lỗi nhập liệu: Mật khẩu nhập không đúng (không được để trống) (6-12 ký tự).");
				txtMatKhau.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
				
			}
			if (txtSoDienThoai.getText().equals("") || !(txtSoDienThoai.getText().matches("^[0-9]{10,11}"))) {
				txtThongBao.setText( "Lỗi nhập liệu: Số điện thoại nhập không đúng. (Nhập 10 hoặc 11 ký tự số)");
				txtSoDienThoai.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
				
			}
			if (txtDiaChi.getText().equals("")) {
				txtThongBao.setText("Lỗi nhập liệu: Địa chỉ nhập không đúng. (không để trống)");
				txtDiaChi.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtCMND.getText().equals("")|| !(txtCMND.getText().matches("^[0-9]{9}"))) {
				txtThongBao.setText("Lỗi nhập liệu: CMND nhập không đúng. (Nhập 9 chữ số)");
				txtCMND.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtTenNV.getText().equals("") || (txtTenNV.getText().matches(".*\\d.*")) || !(txtTenNV.getText().length()>=1) || !(txtTenNV.getText().length()<=64)  ) {
				txtThongBao.setText("Lỗi nhập liệu: Tên nhân viên nhập không đúng (Không chứa số) (Từ 1 - 64 ký tự).");
				txtTenNV.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (!kq) txtThongBao.setForeground(Color.RED);
		}
		
	
		return kq;
		
	}
	

	private void locTK() {
		// TODO Auto-generated method stub
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String ten=txtTenTK.getText();
		String sdt=txtSoDienThoaiTK.getText();
		String cmnd=txtCMNDTK.getText();
		String dc=txtDiaChiTK.getText();
		table.setModel(dsnv.locNV(ten,dc,sdt,cmnd));
		table.setRowHeight(50);
	}

	public void editTextField() {
		txtTenNV.setEditable(true);
		txtCMND.setEditable(true);
		txtSoDienThoai.setEditable(true);
		txtDiaChi.setEditable(true);
	//	cboLoaiNhanVien.setEditable(true);
		txtMatKhau.setEditable(true);
	//	cboGioiTinh.setEditable(true);
		//cboLoaiNhanVien.setSelectedIndex(1);
	}
	public void falseEditTextField() {
		txtTenNV.setEditable(false);
		txtCMND.setEditable(false);
		txtSoDienThoai.setEditable(false);
		txtDiaChi.setEditable(false);
		cboLoaiNhanVien.setEditable(false);
		txtMatKhau.setEditable(false);
		cboGioiTinh.setEditable(false);
		
		
	}
	public void xoaRongTextField() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtCMND.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtMatKhau.setText("");
		txtThongBao.setForeground(Color.BLACK);
		txtMaNV.setBorder(new LineBorder(Color.BLACK, 1));
		txtTenNV.setBorder(new LineBorder(Color.BLACK, 1));
		txtCMND.setBorder(new LineBorder(Color.BLACK, 1));
		txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
		txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
		txtMatKhau.setBorder(new LineBorder(Color.BLACK, 1));
		txtTenNV.requestFocus();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		ktra();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		ktra();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		ktra();
	}
	
	

}
