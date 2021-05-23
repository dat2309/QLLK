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


import dao.DanhSachKhachHang;

import dao.Database;

import javax.swing.border.Border;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_KhachHang extends JDialog implements MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi;
	
	private JLabel lblMaKhachHang,lblTenKhachHang,lblSoDienThoai,lblDiaChi;
	private JTextField txtMaKhachHang,txtTenKhachHang,txtSoDienThoai,txtDiaChi;
	
	private JButton btnThem, btnSua,btnLuu,btnHuy;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	public JComboBox<String> cboMoTa3,cboMoTa4;
	private JTextField txtTenTK;
	private JButton btnTimKiem;
	
	private DefaultTableModel dataModel;
	private JTable table;



	public String maLoai,maNCC;
	public int hanhdong;

	

	private DanhSachKhachHang dskh=new DanhSachKhachHang();
	
	private JLabel lblTnKH;
	private JTextField txtDiaChiTK;
	private JTextField txtSoDienThoaiTK;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut_5;
	
	public UI_KhachHang() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Quản lý khách hàng");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        maLoai=null;
        maNCC=null;
        hanhdong=0;
        buildUI();
        
	}

	@SuppressWarnings("serial")
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
		bThongTin.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaKhachHang=new JLabel("Mã khách hàng: ");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenKhachHang=new JLabel("Tên khách hàng: ");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai=new JLabel("Số điện thoại: ");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi=new JLabel("Địa chỉ: ");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblMaKhachHang.getPreferredSize());
		
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

		//add vao
		Box b01,b02;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		
		b01.add(lblMaKhachHang);
		b01.add(txtMaKhachHang);
		b01.add(lblTenKhachHang);
		b01.add(txtTenKhachHang);
	
		b02.add(lblSoDienThoai);
		b02.add(txtSoDienThoai);
		b02.add(lblDiaChi);
		b02.add(txtDiaChi);
		// hinh an linh kien
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Thêm khách hàng mới");
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
		
		
		lblTnKH = new JLabel("Tên Khách Hàng:   ");
		lblTnKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDiaChiTK = new JLabel("Địa Chỉ:   ");
		lblDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JLabel lblSoDienThoaiTK = new JLabel("Số Điện Thoại:   ");
		lblSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiaChiTK=new JTextField();
		txtDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoDienThoaiTK=new JTextField();
		txtSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		
		b11.add(lblTnKH);
		b11.add(txtTenTK);
		
		horizontalStrut_3 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_3);
		b11.add(lblDiaChiTK);
		b11.add(txtDiaChiTK);
		
		horizontalStrut_4 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_4);
		b11.add(lblSoDienThoaiTK);
		b11.add(txtSoDienThoaiTK);
		
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_5);
		b11.add(btnTimKiem);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		btk.add(verticalStrut_1);
		
	
		btk.setMaximumSize(new Dimension(1600, 100));
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách khách hàng"));
		String[] headers= {"Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ"};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dskh.docTableQLKH());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin khách hàng");
		xoaRongTextField();
		txtTenKhachHang.addKeyListener(this);
		txtSoDienThoai.addKeyListener(this);
		txtDiaChi.addKeyListener(this);
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
			String[] ttam=dskh.docTextFieldQLKH(ma);
			txtMaKhachHang.setText(ttam[0]);
			txtTenKhachHang.setText(ttam[1]);
			txtSoDienThoai.setText(ttam[2]);
			txtDiaChi.setText(ttam[3]);
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
			setTrangThai("Thêm khách hàng mới, nhập thông tin trên các ô trống và bấm lưu.");
			txtMaKhachHang.setText(" <<Tự động tạo>>");
			txtTenKhachHang.requestFocus();
		}else
		if (o.equals(btnSua)) {
			if (!txtMaKhachHang.getText().equals("")) {
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				
				table.setEnabled(false);
				table.clearSelection();
				editTextField();
				hanhdong=2;
				setTrangThai("Thay đổi thông tin khách hàng, sửa đổi thông tin cần thiết và bấm lưu.");
			}else {
				JOptionPane.showMessageDialog(null, "Cần chọn khách hàng trong bảng trước khi thay đổi.");
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
			setTrangThai("Xem thông tin khách hàng");
		}else
		
		if (o.equals(btnLuu)) {
			
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn thêm Khách Hàng này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					if (themKhachHang()) {
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
						table.setModel(dskh.docTableQLKH());
						table.setRowHeight(50);
						hanhdong=0;
						//JOptionPane.showMessageDialog(null, "Cần chọn khách hàng trong bảng trước khi thay đổi.");
						setTrangThai("Xem thông tin khách hàng");
						JOptionPane.showMessageDialog(null, "Thêm thành công.");
					}
						
			
				}
				}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "Bạn có muốn thay đổi thông tin Khách Hàng này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						if (suaKhachHang()) {
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
							table.setModel(dskh.docTableQLKH());
							table.setRowHeight(50);
							hanhdong=0;
							setTrangThai("Xem thông tin khách hàng");
							JOptionPane.showMessageDialog(null, "Thay đổi thành công.");
						}
						
				}
			}
		
			
		}else
		
		if (o.equals(btnTimKiem)) {
			locTK();
		}
	}
	
	
		

	private void locTK() {
		// TODO Auto-generated method stub
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String ten=txtTenTK.getText();
		String sdt=txtSoDienThoaiTK.getText();
		String dc=txtDiaChiTK.getText();
		table.setModel(dskh.locKH(ten,sdt,dc));
		table.setRowHeight(50);
	}

	public void editTextField() {
		txtTenKhachHang.setEditable(true);
		txtSoDienThoai.setEditable(true);
		txtDiaChi.setEditable(true);
		
	}
	public void falseEditTextField() {
		txtTenKhachHang.setEditable(false);
		txtSoDienThoai.setEditable(false);
		txtDiaChi.setEditable(false);
		
	}
	private boolean themKhachHang() {
		if (!dskh.ktraSDTKhachHang(txtSoDienThoai.getText())) {
			JOptionPane.showMessageDialog(null, "Số điện thoại này đã thuộc một khách hàng khác.");
			return false;
		}
		if (ktra()) {
			if (dskh.themKhachHang(txtTenKhachHang.getText(), txtSoDienThoai.getText(), txtDiaChi.getText())) 
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thêm không thành công.");
		return false;
	}
	private boolean suaKhachHang() {
		if (!dskh.ktraSDTSua(txtSoDienThoai.getText(),txtMaKhachHang.getText())) {
			JOptionPane.showMessageDialog(null, "Số điện thoại này đã thuộc một khách hàng khác.");
			return false;
		}
		if (ktra()) {
			if (dskh.suaKhachHang(txtTenKhachHang.getText(), txtSoDienThoai.getText(), txtDiaChi.getText(), txtMaKhachHang.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thay đổi không thành công.");
		return false;
	}
	private boolean ktra() {
		boolean kq=true;
		if (hanhdong==1 || hanhdong==2) {
			txtTenKhachHang.setBorder(new LineBorder(Color.BLACK, 1));
			txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
			txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
			
			txtThongBao.setForeground(Color.BLACK);
			txtThongBao.setText("Nhập liệu và bấm vào nút lưu.");
			if (txtDiaChi.getText().equals("") ) {
				txtThongBao.setText("Lỗi nhập liệu: Địa chỉ nhập không đúng. (không để rỗng).");
				txtDiaChi.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtSoDienThoai.getText().equals("") || !(txtSoDienThoai.getText().matches("^[0-9]{10,11}"))) {
				txtThongBao.setText("Lỗi nhập liệu: Số điện thoại nhập không đúng. (từ 10-11 ký tự số)");
				txtSoDienThoai.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			
			if (txtTenKhachHang.getText().equals("") || (txtTenKhachHang.getText().matches(".*\\d.*"))  || !(txtTenKhachHang.getText().length()>=1) || !(txtTenKhachHang.getText().length()<=64)) {
				txtThongBao.setText("Lỗi nhập liệu: Tên khách hàng nhập chưa đúng. (không để rỗng) (từ 1-64 ký tự không chứa số)");
				txtTenKhachHang.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (!kq) txtThongBao.setForeground(Color.RED);
		}
		
		return kq;
		
	}
	public void xoaRongTextField() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		
		txtThongBao.setForeground(Color.BLACK);
		
		txtTenKhachHang.setBorder(new LineBorder(Color.BLACK, 1));
		txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
		txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
		
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
