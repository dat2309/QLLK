package ui;

import java.awt.Image;

import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;


import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import java.awt.Font;

import java.awt.Graphics2D;

import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dao.DanhSachLinhKien;
import dao.DanhSachLoaiLinhKien;
import dao.DanhSachNhaCungCap;

import dao.Database;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_LinhKien extends JDialog implements MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi,bHinhAnh;
	private JPanel pnlAnhSanPham;
	private JLabel lblMaLinhKien,lblTenLinhKien,lblSoLuong,lblDonGiaGoc,lblDonGiaBan,lblNhaCungCap,lblThoiHanBaoHanh,lblLoai,lblAnh,lblMoTa1,lblMoTa2,lblMoTa3,lblMoTa4;
	private JTextField txtMaLinhKien,txtTenLinhKien,txtSoLuong,txtDonGiaGoc,txtDonGiaBan,txtThoiHanBaoHanh,txtAnh,txtMoTa1,txtMoTa2,txtMoTa3,txtMoTa4;
	public JComboBox<String> cboLoai;
	public JComboBox<String> cboNhaCungCap;

	private JButton btnThem, btnSua,btnLuu,btnHuy;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	private JLabel lblLoaiTK,lblMoTa1TK,lblMoTa2TK,lblMoTa3TK,lblMoTa4TK;
	public JComboBox<String> cboLoaiLK;
	public JComboBox<String> cboMoTa1,cboMoTa2,cboMoTa3,cboMoTa4;
	private JTextField txtTimKiem;
	private JButton btnTimKiem;
	
	private DefaultTableModel dataModel;
	private JTable table;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private DanhSachLinhKien dslk=new DanhSachLinhKien();
	private JLabel lblAnhSP;
	
	private JButton btnThemLoai;
	private JButton btnThemNCC;
	private JButton btnChonAnh;
	
	
	public String maLoai,maNCC;
	public int hanhdong;
	private ImageIcon imiAnh;
	
	private boolean ktt;
	
	private DanhSachLoaiLinhKien dsllk=new DanhSachLoaiLinhKien();
	private DanhSachNhaCungCap dsncc=new DanhSachNhaCungCap();
	private JLabel lblTnLinhKin;
	private JLabel lblThng;
	private JLabel lblng;
	private JLabel lblVn;
	
	public UI_LinhKien() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Quản lý linh kiện");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        maLoai=null;
        maNCC=null;
        hanhdong=0;
        buildUI();
        
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		bThongTin.setBorder(new TitledBorder(null, "Thông tin linh kiện", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaLinhKien=new JLabel("Mã linh kiện: ");
		lblMaLinhKien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenLinhKien=new JLabel("Tên linh kiện: ");
		lblTenLinhKien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuong=new JLabel("Số lượng: ");
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDonGiaGoc=new JLabel("Đơn giá gốc: ");
		lblDonGiaGoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDonGiaBan=new JLabel("Đơn giá bán: ");
		lblDonGiaBan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNhaCungCap=new JLabel("Nhà cung cấp: ");
		lblNhaCungCap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThoiHanBaoHanh=new JLabel(" Thời hạn bảo hành: ");
		lblThoiHanBaoHanh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThoiHanBaoHanh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoai=new JLabel("Loại: ");
		lblLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAnh=new JLabel("Ảnh: ");
		lblAnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa1=new JLabel("Mô tả 1: ");
		lblMoTa1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa2=new JLabel("Mô tả 2: ");
		lblMoTa2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa3=new JLabel("Mô tả 3: ");
		lblMoTa3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa4=new JLabel("Mô tả 4: ");
		lblMoTa4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblMaLinhKien.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblDonGiaGoc.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblAnh.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblMoTa1.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblMoTa3.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblLoai.setPreferredSize(lblNhaCungCap.getPreferredSize());
		
		lblTenLinhKien.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
	
		lblDonGiaBan.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		lblMoTa2.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		lblMoTa4.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		
		
		txtMaLinhKien=new JTextField(){
		    /**
			 * 
			 */
			private static final long serialVersionUID = -6239941321899832377L;

			@Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtMaLinhKien.setColumns(3);
		txtMaLinhKien.setBackground(Color.WHITE);
		txtMaLinhKien.setEditable(false);
		txtMaLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenLinhKien=new JTextField();
		txtTenLinhKien.setColumns(3);
		txtTenLinhKien.setBackground(Color.WHITE);
		txtTenLinhKien.setEditable(false);
		txtTenLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong=new JTextField();
		txtSoLuong.setColumns(7);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGiaGoc=new JTextField();
		txtDonGiaGoc.setColumns(7);
		txtDonGiaGoc.setBackground(Color.WHITE);
		txtDonGiaGoc.setEditable(false);
		txtDonGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGiaBan=new JTextField();
		txtDonGiaBan.setColumns(7);
		txtDonGiaBan.setBackground(Color.WHITE);
		txtDonGiaBan.setEditable(false);
		txtDonGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		cboNhaCungCap=new JComboBox<String>();
		cboNhaCungCap.setEditable(true);
		
		cboNhaCungCap.setBackground(Color.WHITE);
	
		cboNhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		
		txtThoiHanBaoHanh=new JTextField();
		txtThoiHanBaoHanh.setColumns(3);
		txtThoiHanBaoHanh.setBackground(Color.WHITE);
		txtThoiHanBaoHanh.setEditable(false);
		txtThoiHanBaoHanh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboLoai=new JComboBox<String>();
		
		cboLoai.setBackground(Color.WHITE);
		cboLoai.setEditable(true);
		cboLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAnh=new JTextField();
		txtAnh.setBackground(Color.WHITE);
		txtAnh.setEditable(false);
		txtAnh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa1=new JTextField();
		txtMoTa1.setColumns(7);
		txtMoTa1.setBackground(Color.WHITE);
		txtMoTa1.setEditable(false);
		txtMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa2=new JTextField();
		txtMoTa2.setColumns(7);
		txtMoTa2.setBackground(Color.WHITE);
		txtMoTa2.setEditable(false);
		txtMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa3=new JTextField();
		txtMoTa3.setColumns(7);
		txtMoTa3.setBackground(Color.WHITE);
		txtMoTa3.setEditable(false);
		txtMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa4=new JTextField();
		txtMoTa4.setColumns(7);
		txtMoTa4.setBackground(Color.WHITE);
		txtMoTa4.setEditable(false);
		txtMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboNhaCungCap.setPreferredSize(txtMaLinhKien.getPreferredSize());
		btnThemLoai=new JButton("Thêm Loại Linh Kiện Mới ");
		btnThemLoai.setEnabled(false);
		btnThemNCC=new JButton("Thêm Nhà Cung Cấp Mới");
		btnThemNCC.setEnabled(false);
		btnChonAnh=new JButton("Chọn Ảnh");
		btnChonAnh.setEnabled(false);

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
		Box b021=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b03);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b04);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b05);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b06);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b07);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b08);
		
		b01.add(lblMaLinhKien);
		b01.add(txtMaLinhKien);
		b01.add(lblTenLinhKien);
		b01.add(txtTenLinhKien);
	
		b02.add(lblSoLuong);
		b02.add(txtSoLuong);
		b02.add(lblThoiHanBaoHanh);
		b02.add(b021);
		
		
		b021.add(txtThoiHanBaoHanh);
		
		lblThng = new JLabel(" Tháng");
		
		lblThng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b021.add(lblThng);
	
		
		b03.add(lblDonGiaGoc);
		b03.add(txtDonGiaGoc);
		
		lblng = new JLabel("  VNĐ");
		lblng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b03.add(lblng);
		b03.add(lblDonGiaBan);
		b03.add(txtDonGiaBan);
		
		lblVn = new JLabel("  VNĐ");
		lblVn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b03.add(lblVn);
		b04.add(lblNhaCungCap);
		b04.add(cboNhaCungCap);
		b04.add(btnThemNCC);
		
		b05.add(lblLoai);
		b05.add(cboLoai);
		b05.add(btnThemLoai);
		b06.add(lblMoTa1);
		b06.add(txtMoTa1);
		b06.add(lblMoTa2);
		b06.add(txtMoTa2);
		b07.add(lblMoTa3);
		b07.add(txtMoTa3);
		b07.add(lblMoTa4);
		b07.add(txtMoTa4);
		b08.add(lblAnh);
		b08.add(txtAnh);
		b08.add(btnChonAnh);
		// hinh an linh kien
		bHinhAnh=Box.createVerticalBox();
		bTren.add(bHinhAnh);
		bHinhAnh.setBackground(Color.WHITE);
		bHinhAnh.setBorder(new TitledBorder(null, "Hình ảnh minh họa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAnhSanPham = new JPanel();
		pnlAnhSanPham.setPreferredSize(new Dimension(450, 300));	
		pnlAnhSanPham.setBackground(Color.WHITE);
		bHinhAnh.add(pnlAnhSanPham);
		pnlAnhSanPham.add(lblAnhSP=new JLabel(new ImageIcon("./anh/0.jpg")));
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bChucNang.setBorder(new TitledBorder(null, "Nh\u1EA5n n\u00FAt \u0111\u1EC3 ch\u1ECDn ch\u1EE9c n\u0103ng c\u1EA7n th\u1EF1c hi\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bGiua.add(bChucNang);
		btnThem=new JButton("Thêm Linh Kiện");
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
		    /**
			 * 
			 */
			private static final long serialVersionUID = -8034424079327761833L;

			@Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		txtThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 16));;
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
		Box bThongBao=Box.createHorizontalBox();
		bGiua.add(bThongBao);
		bThongBao.add(lblThongBao);
		bThongBao.add(txtThongBao);
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
		lblLoaiTK=new JLabel("Loại:      ");
		lblLoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ArrayList<String> dsloai=dsllk.docCBOLoai();
		cboLoaiLK=new JComboBox<String>();
		cboLoaiLK.setModel(new DefaultComboBoxModel(dsloai.toArray()));
		cboLoaiLK.addItem("Tất cả");
		cboLoaiLK.setSelectedIndex(cboLoaiLK.getItemCount()-1);
		cboLoaiLK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboLoaiLK.setBackground(new Color(240, 255, 240));
		cboLoaiLK.setForeground(Color.BLACK);
		txtTimKiem=new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimKiem.setPreferredSize(txtMaLinhKien.getPreferredSize());
		btnTimKiem=new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMoTa1TK=new JLabel("Mô tả 1: ");
		lblMoTa1TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		String mota1[]= {"Tất cả"};
		cboMoTa1=new JComboBox(mota1);
		cboMoTa1.setEnabled(false);
		cboMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa1.setBackground(new Color(240, 255, 240));
		lblMoTa2TK=new JLabel("Mô tả 2: ");
		lblMoTa2TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa2=new JComboBox(mota1);
		cboMoTa2.setEnabled(false);
		cboMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa2.setBackground(new Color(240, 255, 240));
		lblMoTa3TK=new JLabel("Mô tả 3: ");
		lblMoTa3TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa3=new JComboBox(mota1);
		cboMoTa3.setEnabled(false);
		cboMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa3.setBackground(new Color(240, 255, 240));
		lblMoTa4TK=new JLabel("Mô tả 4: ");
		lblMoTa4TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa4=new JComboBox(mota1);
		cboMoTa4.setEnabled(false);
		cboMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa4.setBackground(new Color(240, 255, 240));
		b11.add(lblLoaiTK);
		b11.add(cboLoaiLK);
		b11.add(Box.createHorizontalStrut(20));
		
		lblTnLinhKin = new JLabel("Tên Linh Kiện:    ");
		lblTnLinhKin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblTnLinhKin);
		b11.add(txtTimKiem);
		b11.add(btnTimKiem);
		b12.add(lblMoTa1TK);
		b12.add(cboMoTa1);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut);
		b12.add(lblMoTa2TK);
		b12.add(cboMoTa2);
		
		horizontalStrut_1 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_1);
		b12.add(lblMoTa3TK);
		b12.add(cboMoTa3);
		
		horizontalStrut_2 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_2);
		b12.add(lblMoTa4TK);
		b12.add(cboMoTa4);
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách linh kiện"));
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá gốc","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành"};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dslk.docTableQLLK());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnThemLoai.addActionListener(this);
		btnThemNCC.addActionListener(this);
		btnChonAnh.addActionListener(this);
		lblAnhSP.setIcon(new ImageIcon("./anh/0.jpg"));
		cboLoaiLK.addActionListener(this);
	//	btnXacNhanLoai.addActionListener(this);
		cboMoTa1.setEnabled(false);
		cboMoTa2.setEnabled(false);
		cboMoTa3.setEnabled(false);
		cboMoTa4.setEnabled(false);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin linh kiện");
		AutoCompleteDecorator.decorate(cboLoai);
		AutoCompleteDecorator.decorate(cboNhaCungCap);
		//ArrayList<String> dsloai=dsllk.docCBOLoai();
		cboLoai.setModel(new DefaultComboBoxModel(dsloai.toArray()));
		ArrayList<String> dsnc=dsncc.docCBONCC();
		cboNhaCungCap.setModel(new DefaultComboBoxModel(dsnc.toArray()));
		cboMoTa1.addActionListener(this);
		cboMoTa2.addActionListener(this);
		cboMoTa3.addActionListener(this);
		cboMoTa4.addActionListener(this);

		
		txtTenLinhKien.setBorder(new LineBorder(Color.BLACK, 1));
		txtSoLuong.setBorder(new LineBorder(Color.BLACK, 1));
		txtDonGiaGoc.setBorder(new LineBorder(Color.BLACK, 1));
		txtDonGiaBan.setBorder(new LineBorder(Color.BLACK, 1));
		txtThoiHanBaoHanh.setBorder(new LineBorder(Color.BLACK, 1));
		txtAnh.setBorder(new LineBorder(Color.BLACK, 1));
		cboLoai.setBorder(new LineBorder(Color.BLACK, 1));
		cboNhaCungCap.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa1.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa2.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa3.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa4.setBorder(new LineBorder(Color.BLACK, 1));
		
		
		txtTenLinhKien.addKeyListener(this);
		txtSoLuong.addKeyListener(this);
		txtDonGiaGoc.addKeyListener(this);
		txtDonGiaBan.addKeyListener(this);
		txtThoiHanBaoHanh.addKeyListener(this);
		txtMoTa1.addKeyListener(this);
		txtMoTa2.addKeyListener(this);
		txtMoTa3.addKeyListener(this);
		txtMoTa4.addKeyListener(this);
		txtAnh.addKeyListener(this);
		
		
		cboNhaCungCap.getEditor().getEditorComponent().addKeyListener(this);
		cboLoai.getEditor().getEditorComponent().addKeyListener(this);
		cboLoai.addActionListener(this);
		cboNhaCungCap.addActionListener(this);
		cboLoai.setEditable(false);
		cboNhaCungCap.setEditable(false);
	}

	private void setTrangThai(String string) {
		txtThongBao.setText(string);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row=table.getSelectedRow();
		if (row>-1) {
			String ma=table.getValueAt(row, 0).toString();
			String[] ttam=dslk.docTextFieldQLLK(ma);
			
			
			txtMaLinhKien.setText(ttam[0]);
			txtTenLinhKien.setText(ttam[1]);
			txtSoLuong.setText(ttam[2]);
			
			
			txtDonGiaGoc.setText(ttam[4]);
			txtDonGiaBan.setText(ttam[5]);
			cboLoai.setEditable(true);
			cboLoai.setSelectedItem(ttam[3]);
			cboNhaCungCap.setEditable(true);
			cboNhaCungCap.setSelectedItem(ttam[6]);
			txtThoiHanBaoHanh.setText(ttam[7]);
			
			cboLoai.setEditable(false);
			cboNhaCungCap.setEditable(false);
			
			txtAnh.setText(ttam[8]);
			txtMoTa1.setText(ttam[9]);
			txtMoTa2.setText(ttam[10]);
			txtMoTa3.setText(ttam[11]);
			txtMoTa4.setText(ttam[12]);
			lblAnhSP.setIcon(new ImageIcon("./anh/"+ttam[8]+".jpg"));
			
			String[] mtt=dsllk.docMoTaLoai(cboLoai.getSelectedItem().toString());
			lblMoTa1.setText(mtt[0]+": ");
			lblMoTa2.setText(mtt[1]+": ");
			lblMoTa3.setText(mtt[2]+": ");
			lblMoTa4.setText(mtt[3]+": ");
			
			cboLoai.setEditable(false);
			cboNhaCungCap.setEditable(false);
		}
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o=e.getSource();
		
		if (o.equals(btnThem)) {
			
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			btnThemLoai.setEnabled(true);
			btnThemNCC.setEnabled(true);
			btnChonAnh.setEnabled(true);
			table.setEnabled(false);
			table.clearSelection();
			xoaRongTextField();
			editTextField();
			cboLoai.setEditable(true);
			cboLoai.setSelectedItem("");
			cboNhaCungCap.setEditable(true);
			cboNhaCungCap.setSelectedItem("");
			AutoCompleteDecorator.decorate(cboLoai);
			AutoCompleteDecorator.decorate(cboNhaCungCap);
			
			ArrayList<String> dsloai=dsllk.docCBOLoai();
			cboLoai.setModel(new DefaultComboBoxModel(dsloai.toArray()));
			ArrayList<String> dsnc=dsncc.docCBONCC();
			cboNhaCungCap.setModel(new DefaultComboBoxModel(dsnc.toArray()));
			
			hanhdong=1;
			setTrangThai("");
			ktra2();
			txtMaLinhKien.setText(" <<Tự động tạo>>");
			JOptionPane.showMessageDialog(null, "Khi nhập liệu, có thể bấm phím Enter để xác nhận nhập liệu.");
			txtTenLinhKien.requestFocus();
		}else
		if (o.equals(btnSua)) {
			if (!txtMaLinhKien.getText().equals("")) {
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				btnThemLoai.setEnabled(true);
				btnThemNCC.setEnabled(true);
				btnChonAnh.setEnabled(true);
				table.setEnabled(false);
				table.clearSelection();
				AutoCompleteDecorator.decorate(cboLoai);
				AutoCompleteDecorator.decorate(cboNhaCungCap);
				editTextField();
				suaTextField();
				hanhdong=2;
				setTrangThai("");
				ktra2();
			}else {
				JOptionPane.showMessageDialog(null, "Cần chọn linh kiện trong bảng trước khi thay đổi.");
			}
		
		}else
		if (o.equals(btnHuy)) {
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnHuy.setEnabled(false);
			btnLuu.setEnabled(false);
			btnThemLoai.setEnabled(false);
			btnThemNCC.setEnabled(false);
			btnChonAnh.setEnabled(false);
			table.setEnabled(true);
			xoaRongTextField();
			falseEditTextField();
			hanhdong=0;
			setTrangThai("Xem thông tin linh kiện");
		}else
		if (o.equals(btnThemLoai)) {
			chonLoai();
		}else
		
		
		if (o.equals(btnThemNCC)) {
			chonNCC();
		}else
			if (o.equals(btnChonAnh)) {
				String a="";
				a=chonHinhAnh();
				imiAnh=new ImageIcon(a); 
				
				Image image = imiAnh.getImage(); // transform it 
				Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				imiAnh = new ImageIcon(newimg);  // trasform it back
				
				lblAnhSP.setIcon(imiAnh);
				ktra2();
		}else
		if (o.equals(btnLuu)) {
		
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn thêm Linh Kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
						if (themLinhKien()) {
							hanhdong=0;
							btnThem.setEnabled(true);
							btnSua.setEnabled(true);
							btnHuy.setEnabled(false);
							btnLuu.setEnabled(false);
							btnThemLoai.setEnabled(false);
							btnThemNCC.setEnabled(false);
							btnChonAnh.setEnabled(false);
							table.setEnabled(true);
							table.clearSelection();
							xoaRongTextField();
							falseEditTextField();
							table.setEnabled(true);
							setTrangThai("Xem thông tin linh kiện");
						//	JOptionPane.showMessageDialog(null, "Thêm thành công.");
							
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "Bạn có muốn thay đổi thông tin Linh Kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						try {
							if (suaLinhKien()==true) {
								hanhdong=0;
								btnThem.setEnabled(true);
								btnSua.setEnabled(true);
								btnHuy.setEnabled(false);
								btnLuu.setEnabled(false);
								btnThemLoai.setEnabled(false);
								btnThemNCC.setEnabled(false);
								btnChonAnh.setEnabled(false);
								table.setEnabled(true);
								table.clearSelection();
								xoaRongTextField();
								falseEditTextField();
								table.setEnabled(true);
								setTrangThai("Xem thông tin linh kiện");
							//	JOptionPane.showMessageDialog(null, "Thay đổi thành công.");
							}
							
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					
				}
			}
			
		}else
		if (o.equals(cboLoaiLK)) {
			if ((cboLoaiLK.getSelectedIndex())==(cboLoaiLK.getItemCount()-1)) {
				cboMoTa1.setEnabled(false);
				cboMoTa2.setEnabled(false);
				cboMoTa3.setEnabled(false);
				cboMoTa4.setEnabled(false);
				cboMoTa1.setSelectedIndex(cboMoTa1.getItemCount()-1);
				cboMoTa2.setSelectedIndex(cboMoTa2.getItemCount()-1);
				cboMoTa3.setSelectedIndex(cboMoTa3.getItemCount()-1);
				cboMoTa4.setSelectedIndex(cboMoTa4.getItemCount()-1);
				lblMoTa1TK.setText("Mô tả 1: ");
				lblMoTa2TK.setText("Mô tả 2: ");
				lblMoTa3TK.setText("Mô tả 3: ");
				lblMoTa4TK.setText("Mô tả 4: ");
				locComboBox();
			}else {
				String[] mtttk=dsllk.docMoTaLoai(cboLoaiLK.getSelectedItem().toString());
				lblMoTa1TK.setText(mtttk[0]+": ");
				lblMoTa2TK.setText(mtttk[1]+": ");
				lblMoTa3TK.setText(mtttk[2]+": ");
				lblMoTa4TK.setText(mtttk[3]+": ");
				
				cboMoTa1.setEnabled(true);
				cboMoTa2.setEnabled(true);
				cboMoTa3.setEnabled(true);
				cboMoTa4.setEnabled(true);
				
				ArrayList<String> ds_mt1=dslk.docMoTa1(cboLoaiLK.getSelectedItem().toString());
				cboMoTa1.setModel(new DefaultComboBoxModel(ds_mt1.toArray()));
				cboMoTa1.addItem("Tất cả"); 
				cboMoTa1.setSelectedIndex(cboMoTa1.getItemCount()-1);
				
				ArrayList<String> ds_mt2=dslk.docMoTa2(cboLoaiLK.getSelectedItem().toString());
				cboMoTa2.setModel(new DefaultComboBoxModel(ds_mt2.toArray()));
				cboMoTa2.addItem("Tất cả");
				cboMoTa2.setSelectedIndex(cboMoTa2.getItemCount()-1);
				
				ArrayList<String> ds_mt3=dslk.docMoTa3(cboLoaiLK.getSelectedItem().toString());
				cboMoTa3.setModel(new DefaultComboBoxModel(ds_mt3.toArray()));
				cboMoTa3.addItem("Tất cả");
				cboMoTa3.setSelectedIndex(cboMoTa3.getItemCount()-1);

				ArrayList<String> ds_mt4=dslk.docMoTa4(cboLoaiLK.getSelectedItem().toString());
				cboMoTa4.setModel(new DefaultComboBoxModel(ds_mt4.toArray()));
				cboMoTa4.addItem("Tất cả");
				cboMoTa4.setSelectedIndex(cboMoTa4.getItemCount()-1);
				locComboBox();
				
			}
		}else
		if (o.equals(btnTimKiem)) {
			locComboBox();
		}else
		if (o.equals(cboMoTa1) || o.equals(cboMoTa2) || o.equals(cboMoTa3) || o.equals(cboMoTa4)) {
			locComboBox();
		}else
		if (hanhdong==1 &&(o.equals(cboLoai) || o.equals(cboNhaCungCap))){
			//ktra2();
		}
		
	}
	private boolean themLinhKien() throws IOException {
		if (ktra()) {
			String ncca=cboNhaCungCap.getSelectedItem().toString();
			maNCC=null;
			maNCC=dsncc.docMaByTen(ncca);
			
			String loaia=cboLoai.getSelectedItem().toString();
			maLoai=null;
			maLoai=dsllk.docMaLoaiByTen(loaia);
			
			Image img = imiAnh.getImage();
			BufferedImage bi = new BufferedImage(250,250,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(img, 0, 0, null);
			g2.dispose();
			ImageIO.write(bi, "jpg",new File("./anh/"+txtAnh.getText()+".jpg"));
			if(dslk.themLinhKien(txtTenLinhKien.getText(), txtSoLuong.getText(), txtDonGiaGoc.getText(), txtDonGiaBan.getText(), maNCC,txtThoiHanBaoHanh.getText(), maLoai, txtAnh.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText())) {
				dataModel.setRowCount(0);
				table.setModel(dslk.docTableQLLK());
				JOptionPane.showMessageDialog(null, "Đã thêm Linh Kiện thành công.");
				xoaRongTextField();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Thêm không thành công, lỗi nhập liệu.");
			return false;
		}
		return true;
	}
	private boolean suaLinhKien() throws IOException {
		if (ktra()) {
			if (imiAnh==null) imiAnh=new ImageIcon("./anh/"+txtAnh.getText()+".jpg");
			Image img = imiAnh.getImage();
			BufferedImage bi = new BufferedImage(250,250,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(img, 0, 0, null);
			g2.dispose();
			ImageIO.write(bi, "jpg",new File("./anh/"+txtAnh.getText()+".jpg"));
			if (ktra())
			if(dslk.suaLinhKien(txtTenLinhKien.getText(), txtSoLuong.getText(), txtDonGiaGoc.getText(), txtDonGiaBan.getText(), maNCC,txtThoiHanBaoHanh.getText(), maLoai, txtAnh.getText(),txtMaLinhKien.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText())) {
				dataModel.setRowCount(0);
				table.setModel(dslk.docTableQLLK());
				JOptionPane.showMessageDialog(null, "Đã thay đổi thành công thông tin linh kiện.");
				//xoaRongTextField();
				return true;
			}
		}else {
			JOptionPane.showMessageDialog(null, "Thay đổi không thành công, lỗi nhập liệu.");
			return false;
		}
		return true;
		
	}
	public boolean ktra() {
		if (ktt==true) return true;
		return false;
		
	}
	
	public void suaTextField() {
		String goc,ban;
		goc=txtDonGiaGoc.getText();
		goc = goc.replace(",", "");
		goc = goc.replaceAll(" VND", "");
		txtDonGiaGoc.setText(goc);
		ban=txtDonGiaBan.getText();
		ban = ban.replace(",", "");
		ban = ban.replaceAll(" VND", "");
		txtDonGiaBan.setText(ban);
		txtThoiHanBaoHanh.setText(txtThoiHanBaoHanh.getText().replaceAll(" Tháng", ""));
	}
		

	public void editTextField() {
		txtTenLinhKien.setEditable(true);
		txtSoLuong.setEditable(true);
		txtDonGiaGoc.setEditable(true);
		txtDonGiaBan.setEditable(true);
		txtThoiHanBaoHanh.setEditable(true);
		txtMoTa1.setEditable(true);
		txtMoTa2.setEditable(true);
		txtMoTa3.setEditable(true);
		txtMoTa4.setEditable(true);
	}
	public void falseEditTextField() {
		txtTenLinhKien.setEditable(false);
		txtSoLuong.setEditable(false);
		txtDonGiaGoc.setEditable(false);
		txtDonGiaBan.setEditable(false);
		txtThoiHanBaoHanh.setEditable(false);
		txtMoTa1.setEditable(false);
		txtMoTa2.setEditable(false);
		txtMoTa3.setEditable(false);
		txtMoTa4.setEditable(false);
	}
	public void xoaRongTextField() {
		txtTenLinhKien.setBorder(new LineBorder(Color.BLACK, 1));
		txtSoLuong.setBorder(new LineBorder(Color.BLACK, 1));
		txtDonGiaGoc.setBorder(new LineBorder(Color.BLACK, 1));
		txtDonGiaBan.setBorder(new LineBorder(Color.BLACK, 1));
		txtThoiHanBaoHanh.setBorder(new LineBorder(Color.BLACK, 1));
		txtAnh.setBorder(new LineBorder(Color.BLACK, 1));
		cboLoai.setBorder(new LineBorder(Color.BLACK, 1));
		cboNhaCungCap.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa1.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa2.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa3.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa4.setBorder(new LineBorder(Color.BLACK, 1));
		txtThongBao.setForeground(Color.BLACK);
		txtMaLinhKien.setText("");
		txtTenLinhKien.setText("");
		txtSoLuong.setText("");
		cboLoai.setSelectedItem("");
		txtDonGiaGoc.setText("");
		txtDonGiaBan.setText("");
		cboNhaCungCap.setSelectedItem("");
		txtThoiHanBaoHanh.setText("");
		txtAnh.setText("");
		txtMoTa1.setText("");
		txtMoTa2.setText("");
		txtMoTa3.setText("");
		txtMoTa4.setText("");
		lblAnhSP.setIcon(new ImageIcon("./anh/0.jpg"));
	}
	private String chonHinhAnh() {
		
		 String l="";
		 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
         j.setAcceptAllFileFilterUsed(false); 
         j.setDialogTitle("Select a .jpg file"); 
         FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .jpg files", "jpg"); 
         j.addChoosableFileFilter(restrict); 
         int r = j.showOpenDialog(null); 
           if (r == JFileChooser.APPROVE_OPTION) { 
              l=j.getSelectedFile().getAbsolutePath(); 
              txtAnh.setText(j.getSelectedFile().getName());
              txtAnh.setText(txtAnh.getText().replaceAll(".jpg", ""));
           } 
           else {
              l="./anh/0.jpg";
           	 txtAnh.setText("0.jpg");
           	}
		return l;
	}
	private void chonNCC() {
		UI_NhaCungCap frmNCC=new UI_NhaCungCap();
		frmNCC.setVisible(true);
	}
	
	private void chonLoai() {
		UI_LoaiLinhKien frmLoaiLinhKien=new UI_LoaiLinhKien();
		frmLoaiLinhKien.setVisible(true);
	
	}
	@SuppressWarnings("unused")
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	private void locComboBox() {
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String l=cboLoaiLK.getSelectedItem().toString();
		String m1=cboMoTa1.getSelectedItem().toString();
		String m2=cboMoTa2.getSelectedItem().toString();
		String m3=cboMoTa3.getSelectedItem().toString();
		String m4=cboMoTa4.getSelectedItem().toString();
		table.setModel(dslk.locTableQLLK(l,m1,m2,m3,m4,txtTimKiem.getText()));
		table.setRowHeight(50);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		ktra2();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		ktra2();
	}   

	private void ktra2() {
		// TODO Auto-generated method stub
		if (hanhdong==1 || hanhdong== 2) {
			ktt=true;
			maNCC=null;
			if (cboNhaCungCap.getSelectedItem()!=null){
				String ncca=cboNhaCungCap.getSelectedItem().toString();
				maNCC=dsncc.docMaByTen(ncca);
			}
			
			
			maLoai=null;
			if (cboLoai.getSelectedItem()!=null) {
				String loaia=cboLoai.getSelectedItem().toString();
				maLoai=dsllk.docMaLoaiByTen(loaia);
			}
			
			String[] mtttk=dsllk.docMoTaLoaiByMa(maLoai);
			if (mtttk.length>0) {
				
				lblMoTa1.setText(mtttk[0]+": ");
				lblMoTa2.setText(mtttk[1]+": ");
				lblMoTa3.setText(mtttk[2]+": ");
				lblMoTa4.setText(mtttk[3]+": ");
			}else {
				lblMoTa1.setText("Mô tả 1: ");
				lblMoTa2.setText("Mô tả 2: ");
				lblMoTa3.setText("Mô tả 3: ");
				lblMoTa4.setText("Mô tả 4: ");
			}
			
			txtTenLinhKien.setBorder(new LineBorder(Color.BLACK, 1));
			txtSoLuong.setBorder(new LineBorder(Color.BLACK, 1));
			txtDonGiaGoc.setBorder(new LineBorder(Color.BLACK, 1));
			txtDonGiaBan.setBorder(new LineBorder(Color.BLACK, 1));
			txtThoiHanBaoHanh.setBorder(new LineBorder(Color.BLACK, 1));
			txtAnh.setBorder(new LineBorder(Color.BLACK, 1));
			cboLoai.setBorder(new LineBorder(Color.BLACK, 1));
			cboNhaCungCap.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa1.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa2.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa3.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa4.setBorder(new LineBorder(Color.BLACK, 1));
			
			maNCC=null;
			if (cboNhaCungCap.getSelectedItem()!=null){
				String ncca=cboNhaCungCap.getSelectedItem().toString();
				maNCC=dsncc.docMaByTen(ncca);
			}
			
			
			maLoai=null;
			if (cboLoai.getSelectedItem()!=null) {
				String loaia=cboLoai.getSelectedItem().toString();
				maLoai=dsllk.docMaLoaiByTen(loaia);
			}
		
			
		
			txtThongBao.setText("Nhập thông tin linh kiện (Bấm Enter để xác nhận) và bấm Lưu.");
			txtThongBao.setForeground(Color.BLACK);
			
			if (txtAnh.getText().equals("")) {
				txtThongBao.setText("Lỗi lựa chọn: Ảnh chưa được chọn.");
				txtAnh.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			if (txtMoTa4.getText().equals("")) {
				txtThongBao.setText("Lỗi nhập liệu: Mô tả. (không để trống)");
				txtMoTa4.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			if (txtMoTa3.getText().equals("")) {
				txtThongBao.setText("Lỗi nhập liệu: Mô tả. (không để trống)");
				txtMoTa3.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			if (txtMoTa2.getText().equals("")) {
				txtThongBao.setText("Lỗi nhập liệu: Mô tả. (không để trống)");
				txtMoTa2.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
		
			if (txtMoTa1.getText().equals("")) {
				txtThongBao.setText("Lỗi nhập liệu: Mô tả. (không để trống)");
				txtMoTa1.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			
			
			
			

			if ((maLoai==null)) {
				txtThongBao.setText("Lỗi nhập liệu: Loại không chọn đúng.");
				cboLoai.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			if ((maNCC==null)) {
				txtThongBao.setText("Lỗi nhập liệu: Nhà cung cấp không chọn đúng.");
				cboNhaCungCap.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			
			if (txtDonGiaBan.getText().equals("") || !(txtDonGiaBan.getText().matches("[1-9][0-9]*"))) {
				txtThongBao.setText("Lỗi nhập liệu: Đơn giá bán không nhập đúng cú pháp. (Nhập Số và không được để trống)");
				txtDonGiaBan.setBorder(new LineBorder(Color.RED, 2));
				txtThongBao.setForeground(Color.RED);
				ktt=false;
			}
			if (txtDonGiaGoc.getText().equals("") || !(txtDonGiaGoc.getText().matches("[1-9][0-9]*"))) {
				txtThongBao.setText("Lỗi nhập liệu: Đơn giá gốc không nhập đúng cú pháp. (Không được để trống) (nhập số lớn hơn 0)");
				txtThongBao.setForeground(Color.RED);
				txtDonGiaGoc.setBorder(new LineBorder(Color.RED, 2));
				ktt=false;
			}
			if (txtThoiHanBaoHanh.getText().equals("") || !(txtThoiHanBaoHanh.getText().matches("[0-9]+"))) {
				txtThongBao.setText("Lỗi nhập liệu: Thời hạn bảo hành không đúng. (Nhập ký tự số) (không được để trống)");
				txtThongBao.setForeground(Color.RED);
				txtThoiHanBaoHanh.setBorder(new LineBorder(Color.RED, 2));
				ktt=false;
			}
			if (txtSoLuong.getText().equals("") || !(txtSoLuong.getText().matches("[0-9]+"))) {
				txtThongBao.setText("Lỗi nhập liệu: Số lượng không nhập đúng cú pháp. (Không được để trống) (Nhập Số >=0)");
				txtThongBao.setForeground(Color.RED);
				txtSoLuong.setBorder(new LineBorder(Color.RED, 2));
				ktt=false;
			}
			if (txtTenLinhKien.getText().equals("") || !(txtTenLinhKien.getText().length()>=1) || !(txtTenLinhKien.getText().length()<=64)) {
				txtThongBao.setText("Lỗi nhập liệu: Tên linh kiện không nhập đúng cú pháp. (từ 1-64 ký tự)");
				txtThongBao.setForeground(Color.RED);
				txtTenLinhKien.setBorder(new LineBorder(Color.RED, 2));
				ktt=false;
			}
			
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		ktra2();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setDanhSach() {
		ArrayList<String> dsloai=dsllk.docCBOLoai();
		cboLoai.setModel(new DefaultComboBoxModel(dsloai.toArray()));
		ArrayList<String> dsnc=dsncc.docCBONCC();
		cboNhaCungCap.setModel(new DefaultComboBoxModel(dsnc.toArray()));
	}
}
