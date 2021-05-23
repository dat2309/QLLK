package ui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import dao.DanhSachCTHD;
import dao.DanhSachHoaDon;
import dao.DanhSachKhachHang;
import dao.DanhSachLinhKien;
import dao.DanhSachLoaiLinhKien;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiLinhKien;
import dao.Database;

public class UI_ThemHoaDon extends JDialog implements MouseListener, ActionListener, DocumentListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bTren,bDuoi;

	private JLabel lblMaHoaDon,lblNgayLap,lblMaNhanVien,lblMaKhachHang,lblTenKhachHang,lblTenNhanVien,lblSoLuong,lblTongTienHang,lblThue,lblTongCong;
	private JTextField txtMaHoaDon,txtNgayLap,txtMaNhanVien,txtMaKhachHang,txtTenKhachHang,txtTenNhanVien,txtSoLuong,txtTongTienHang,txtThue,txtTongCong;
	
	
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

	public String maLoai,maNCC;
	public int hanhdong;
	
	
	private DanhSachHoaDon dshd=new DanhSachHoaDon();
	private DanhSachCTHD dsct=new DanhSachCTHD();
	private DanhSachLoaiLinhKien dsllk=new DanhSachLoaiLinhKien();
	@SuppressWarnings("unused")
	private ArrayList<LoaiLinhKien> ds_lk;
	private JLabel lblTnLinhKin;
	private Box bCTHD;
	private DefaultTableModel dataModel2;
	private JTable table2;
	private JLabel lblSoDienThoai,lblDiaChi;
	private JTextField txtSoDienThoai,txtDiaChi;
	private Component verticalStrut;
	private JButton btnTaoHoaDon,btnXemTruoc;
	private Component verticalStrut_1;
	private DanhSachKhachHang dskh=new DanhSachKhachHang();
	List<KhachHang> dsK;
	private Box bDuoi2;
	private JButton btnKhachHang;
	private JLabel lblSoDienThoai_1;
	private Component verticalStrut_2;
	private JLabel lblSoDienThoai_2;
	private Component horizontalStrut_3;
	
	
	public UI_ThemHoaDon() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Tạo hóa đơn mới");
		setSize(900, 850);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        maLoai=null;
        maNCC=null;
        hanhdong=0;
        buildUI();
        
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void buildUI() {
		// TODO Auto-generated method stub
		
		getContentPane().add(bTong=Box.createVerticalBox());
		
		bTong.add(Box.createVerticalStrut(10));
		bTong.add(bTren=Box.createVerticalBox());
		bTong.add(bDuoi=Box.createVerticalBox());
		
		bTong.add(bDuoi2=Box.createHorizontalBox());
		Box bt1,bt2;
		bt1=Box.createVerticalBox();
		bt2=Box.createVerticalBox();
		bDuoi2.add(bt1);
		bDuoi2.add(bt2);

		
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
		
		lblSoDienThoai=new JLabel("Số điện thoại: ");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi=new JLabel("Địa chỉ: ");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblSoLuong=new JLabel("Số lượng: ");
		lblSoLuong.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTongTienHang=new JLabel("Tổng tiền hàng: ");
		lblTongTienHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTienHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThue=new JLabel("Thuế: ");
		lblThue.setHorizontalAlignment(SwingConstants.LEFT);
		lblThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTongCong=new JLabel("Tổng cộng: ");
		lblTongCong.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongCong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
	
		lblMaHoaDon.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblMaNhanVien.setPreferredSize(lblMaKhachHang.getPreferredSize());
		lblSoLuong.setPreferredSize(lblMaKhachHang.getPreferredSize());
		
		lblSoDienThoai.setPreferredSize(lblMaKhachHang.getPreferredSize());
		
		lblNgayLap.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblTenNhanVien.setPreferredSize(lblTenKhachHang.getPreferredSize());
	
		
		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());
		
	
		
		
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
		
		
		
		txtSoDienThoai=new JTextField();
		txtSoDienThoai.setColumns(7);
		txtSoDienThoai.setBackground(Color.WHITE);
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtDiaChi=new JTextField();
		txtDiaChi.setColumns(7);
		txtDiaChi.setBackground(Color.WHITE);
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
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

		/*
		txtMaHoaDon.setBorder(null);
		txtNgayLap.setBorder(null);
		txtMaNhanVien.setBorder(null);
		txtMaKhachHang.setBorder(null);
		txtTenKhachHang.setBorder(null);
		//txtSoDienThoai
		txtDiaChi.setBorder(null);
		txtTenNhanVien.setBorder(null);
		txtSoLuong.setBorder(null);
		txtTongTienHang.setBorder(null);
		txtThue.setBorder(null);
		txtTongCong.setBorder(null);
		*/
		txtSoDienThoai.requestFocus();
		
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
		
		verticalStrut = Box.createVerticalStrut(5);
		bThongTin.add(verticalStrut);
		bThongTin.add(b04);
		
		verticalStrut_2 = Box.createVerticalStrut(5);
		bThongTin.add(verticalStrut_2);
		bThongTin.add(b05);
		
		lblSoDienThoai_1 = new JLabel("<<Nhập số điện thoại khách hàng>>");
		lblSoDienThoai_1.setPreferredSize(new Dimension(128, 24));
		lblSoDienThoai_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		b05.add(lblSoDienThoai_1);
		
		horizontalStrut_3 = Box.createHorizontalStrut(500);
		b05.add(horizontalStrut_3);
		
		lblSoDienThoai_2 = new JLabel("<<Nếu thông tin bị lỗi hoặc khách hàng mới, nhấn vào đây>>");
		lblSoDienThoai_2.setPreferredSize(new Dimension(128, 24));
		lblSoDienThoai_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		b05.add(lblSoDienThoai_2);
		
		btnKhachHang = new JButton("Quản lý KH");
		btnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b05.add(btnKhachHang);
		
		
		
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
		
		b04.add(lblSoDienThoai);
		b04.add(txtSoDienThoai);
		b04.add(lblDiaChi);
		b04.add(txtDiaChi);
		
	//	b06.add(lblSoLuong);
	//	b06.add(txtSoLuong);
		b06.add(lblTongTienHang);
		b06.add(txtTongTienHang);
		b07.add(lblThue);
		b07.add(txtThue);
		b08.add(lblTongCong);
		b08.add(txtTongCong);
		// 
		bCTHD=Box.createVerticalBox();
	//	bTren.add(bCTHD);
		bCTHD.setBackground(Color.WHITE);
		bCTHD.setBorder(new TitledBorder(null, "Chi tiết hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		//cthd
		
		String[] headers2= {"Mã linh kiện","Tên linh kiện","Số lượng","Đơn giá","Thành tiền",""};
		dataModel2=new DefaultTableModel(headers2,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll2;
		bCTHD.add(scroll2=new JScrollPane(table2=new JTable(dataModel2){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		    	
		        return (column==4);
		    }
		}));
		table2.getTableHeader().setReorderingAllowed(false);
		
		dataModel2.setRowCount(0);
		table2.setModel(dataModel2);
		
		table2.setRowHeight(50);
		table2.removeColumn(table2.getColumnModel().getColumn(0));

		 table2.getColumnModel().getColumn(4).setCellRenderer(new ClientsTableButtonRenderer());
		  table2.getColumnModel().getColumn(4).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
	//	scroll2.setPreferredSize(new Dimension(500,300));
		  
		//chuc nang - button
		
	
		
		
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
	    ds_lk=dsllk.docTuBang();
		cboLoaiLK=new JComboBox<String>();
		ArrayList<String> dsloai=dsllk.docCBOLoai();
		cboLoaiLK.setModel(new DefaultComboBoxModel(dsloai.toArray()));
		cboLoaiLK.addItem("Tất cả");
		cboLoaiLK.setSelectedIndex(cboLoaiLK.getItemCount()-1);
		cboLoaiLK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboLoaiLK.setBackground(new Color(240, 255, 240));
		cboLoaiLK.setForeground(Color.BLACK);
		txtTimKiem=new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimKiem.setPreferredSize(txtMaHoaDon.getPreferredSize());
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
		
		verticalStrut_1 = Box.createVerticalStrut(10);
		btk.add(verticalStrut_1);
		bDuoi.add(bCTHD);
		bds.setBorder(new TitledBorder("Danh sách linh kiện"));
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành","Mô tả 1","Mô tả 2","Mô tả 3","Mô tả 4",""};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(docTableQLLK());
	 table.getColumnModel().getColumn(11).setCellRenderer(new ClientsTableButtonRenderer());
		   table.getColumnModel().getColumn(11).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		
	
	
		cboLoaiLK.addActionListener(this);
	//	btnXacNhanLoai.addActionListener(this);
		cboMoTa1.setEnabled(false);
		cboMoTa2.setEnabled(false);
		cboMoTa3.setEnabled(false);
		cboMoTa4.setEnabled(false);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin linh kiện");
		txtSoDienThoai.getDocument().addDocumentListener(this);
		dsK=dskh.docTuBang();
		//table2.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		 Action action = new AbstractAction() {
		       /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		       {
		           @SuppressWarnings("unused")
				TableCellListener tcl = (TableCellListener)e.getSource();
		         //  System.out.println("Row   : " + tcl.getRow());
		          // System.out.println("Column: " + tcl.getColumn());
		          // System.out.println("Old   : " + tcl.getOldValue());
		          // System.out.println("New   : " + tcl.getNewValue());
		           
		           capNhatTongTien();
		           
		        
		       }
		   };
		   bt1.add(Box.createVerticalStrut(5));
		   bt1.add(b06);
		   bt1.add(Box.createVerticalStrut(5));
		   bt1.add(b07);
		   bt1.add(Box.createVerticalStrut(5));
		   bt1.add(b08);
		   
		//	lblTongTienHang.setPreferredSize(lblTenKhachHang.getPreferredSize());
			lblThue.setPreferredSize(lblTongTienHang.getPreferredSize());
			lblTongCong.setPreferredSize(lblTongTienHang.getPreferredSize());

		   @SuppressWarnings("unused")
		TableCellListener tcl = new TableCellListener(table2, action);
		 btnTaoHoaDon=new JButton("Tạo hóa đơn trên    ");
		 btnTaoHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 btnXemTruoc=new JButton("Xem trước hóa đơn");
		 btnXemTruoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		 Box bcn=Box.createHorizontalBox();
		 bt2.add(btnXemTruoc);
		 bt2.add(btnTaoHoaDon);
		 btnTaoHoaDon.setPreferredSize(btnXemTruoc.getPreferredSize());
		 bDuoi.add(bcn);
		 docHD();
		 btnTaoHoaDon.addActionListener(this);
		 btnXemTruoc.addActionListener(this);
		 cboLoaiLK.addActionListener(this);
		 cboMoTa1.addActionListener(this);
		 cboMoTa2.addActionListener(this);
		 cboMoTa3.addActionListener(this);
		 cboMoTa4.addActionListener(this);
		 btnKhachHang.addActionListener(this);
		 addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Bạn có muốn hủy tạo hóa đơn?", "Thông báo",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               }else{
                   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
               }
			  }
			});
		 
	}

	private void setTrangThai(String string) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		if (row>-1) {
			
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		                           
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
			}else {
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
		
				
			}
		}else
		if (o.equals(btnTimKiem)) {
			locComboBox();
		}if (o.equals(btnXemTruoc)) {
			xemThu();
		}
		else
		if (o.equals(btnTaoHoaDon)) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn tạo hóa đơn này?","Cảnh báo",JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION) {
					try {
						thanhToan();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
				//	JOptionPane.showMessageDialog(null, ".");
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
				if (o.equals(cboMoTa1) || o.equals(cboMoTa2) || o.equals(cboMoTa3) || o.equals(cboMoTa4)) {
					locComboBox();
				}else
				if (o.equals(btnKhachHang)) {
					UI_KhachHang frmKH=new UI_KhachHang();
					frmKH.setVisible(true);
				}
		}
	
	
	private void locComboBox() {
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String l=cboLoaiLK.getSelectedItem().toString();
		String m1=cboMoTa1.getSelectedItem().toString();
		String m2=cboMoTa2.getSelectedItem().toString();
		String m3=cboMoTa3.getSelectedItem().toString();
		String m4=cboMoTa4.getSelectedItem().toString();
		table.setModel(dslk.locTableQLLK2(l,m1,m2,m3,m4,txtTimKiem.getText()));
		table.setRowHeight(50);
		 table.getColumnModel().getColumn(11).setCellRenderer(new ClientsTableButtonRenderer());
		   table.getColumnModel().getColumn(11).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
	}
	@SuppressWarnings("static-access")
	public void docHD() {
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="SELECT MAX(mahoadon) from hoadon";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				int m=Integer.parseInt(ma.replaceAll("HD", ""));
				String mt="HD"+Integer.toString(m+1);
				while(mt.length()<8) {
					mt=mt.substring(0, 2) + "0" + mt.substring(2, mt.length());
				}
				txtMaHoaDon.setText(mt);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		txtNgayLap.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
		txtMaNhanVien.setText(test.maNhanVien);
		txtTenNhanVien.setText(test.tenNhanVien);
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateT(e);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateT(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		updateT(e);
	}
	private void updateT(DocumentEvent e) {
		// TODO Auto-generated method stub
		dsK=dskh.docTuBang();
		for (KhachHang k:dsK) {
			if (k.getSoDienThoai().equals(txtSoDienThoai.getText())) {
				txtMaKhachHang.setText(k.getMaKhachHang());
				txtTenKhachHang.setText(k.getHoTen());
			//	txtSoDienThoai.setText(k.getSoDienThoai());
				txtDiaChi.setText(k.getDiaChi());
			}
		}
	}
	@SuppressWarnings("static-access")
	public DefaultTableModel docTableQLLK(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành","Mô tả 1","Mô tả 2","Mô tả 3","Mô tả 4",""};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) lk.malinhkien, lk.tenlinhkien, lk.soluong,loai.tenloai,lk.dongiagoc,lk.dongiaban,ncc.tenncc,lk.thoihanbaohanh,lk.mota1,lk.mota2,lk.mota3,lk.mota4\r\n"
					+ "from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai\r\n"
					+ "inner join nhacungcap ncc on lk.manhacungcap=ncc.manhacungcap";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				int sl=rs.getInt(3);
				String loai=rs.getString(4);
				//Double goc=rs.getDouble(5);
				Double ban=rs.getDouble(6);
				String ncc=rs.getString(7);	
				int bh=rs.getInt(8);
				String mt1=rs.getString(9);
				String mt2=rs.getString(10);
				String mt3=rs.getString(11);
				String mt4=rs.getString(12);
				String[] rowData= {ma,ten,sl+"",loai,test.formatter.format(ban)+" VND",ncc,bh+" Tháng",mt1,mt2,mt3,mt4,"Lựa chọn"};
				tableModel.addRow(rowData);
				
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}

	
	 class ClientsTableButtonRenderer extends JButton implements TableCellRenderer
	  {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ClientsTableButtonRenderer()
	    {
	      setOpaque(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	    {
	      setForeground(Color.black);
	      setBackground(UIManager.getColor("Button.background"));
	      setText((value == null) ? "" : value.toString());
	      return this;
	    }
	  }
	
	public class ClientsTableRenderer extends DefaultCellEditor
	  {
	   
		private static final long serialVersionUID = 1L;
		private JButton button;
	    private String label;
	    private boolean clicked;
	   
		@SuppressWarnings("unused")
		private int row, col;
	    private JTable table;

	    public ClientsTableRenderer(JCheckBox checkBox)
	    {
	      super(checkBox);
	      button = new JButton();
	      button.setOpaque(true);
	     
	      button.addActionListener(new ActionListener()
	      {
	        public void actionPerformed(ActionEvent e)
	        {
	          fireEditingStopped();
	        }
	      });
	    }
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	    {
	      this.table = table;
	      this.row = row;
	      this.col = column;
	      

	      button.setForeground(Color.black);
	      button.setBackground(UIManager.getColor("Button.background"));
	      label = (value == null) ? "" : value.toString();
	      button.setText(label);
	     
	      clicked = true;
	      return button;
	    }
	    public Object getCellEditorValue()
	    {
	      if (clicked)
	      {
	       //JOptionPane.showMessageDialog(button, "Column with Value: "+table.getValueAt(row, 1) + " -  Clicked!");
	    	  if (table==UI_ThemHoaDon.this.table) themLinhKien();
	    	  else if (table==UI_ThemHoaDon.this.table2) huyChon();
	      }
	      clicked = false;
	      return new String(label);
	    }

	
		public boolean stopCellEditing()
	    {
	      clicked = false;
	      return super.stopCellEditing();
	    }

	    protected void fireEditingStopped()
	    {
	      super.fireEditingStopped();
	    }
	  }
	  public void themLinhKien() {
		int row=table.getSelectedRow();
		if (row>-1) {
		//DefaultTableModel tableModel = new DefaultTableModel();
		@SuppressWarnings("unused")
		String[] headers2= {"Mã linh kiện","Tên linh kiện","Số lượng","Đơn giá","Thành tiền",""};
		String ma=table.getValueAt(row, 0).toString();
		String ten=table.getValueAt(row, 1).toString();
		String slt=table.getValueAt(row, 2).toString();
		String dg=table.getValueAt(row, 4).toString();
		String nsl=null;
		nsl=JOptionPane.showInputDialog("Nhập số lượng cần thêm vào hóa đơn: ",1);
		if (nsl!=null && Integer.parseInt(nsl)>=0) {
			int soluong=Integer.parseInt(nsl);
			if (soluong>Integer.parseInt(slt)) {
					JOptionPane.showMessageDialog(this, "Số lượng tồn không đủ");
				}else {
					int vt=ktraCo(ma);
					int ht=Integer.parseInt(table.getValueAt(row,2).toString());
					@SuppressWarnings("unused")
					int te=ht-Integer.parseInt(nsl);
					if (vt==-1) {
						String dgg=dg.replace(",", "");
						dgg=dgg.replace(" VND","");
						Double dongia=Double.parseDouble(dgg);
						Double thanhTien=dongia*soluong;
						Object[] rowData= {ma,ten,nsl,dg,test.formatter.format(thanhTien)+"","Thay đổi số lượng - Hủy"};
						dataModel2.addRow(rowData);
						 
					}else {
						JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm vào từ trước.");
					}
					
				}
			}else {
				JOptionPane.showMessageDialog(this, "Lỗi nhập liệu.");
			}
			
			capNhatTongTien();
		}
	
		
	  }
	  private void capNhatTongTien() {
		// TODO Auto-generated method stub
		
			
		  Double tongcong=0.0;
		  Double tongtien=0.0;
		  int sl=0;
			for (int i=0;i<table2.getRowCount();i++) {
				 String dgg=(table2.getValueAt(i,2)).toString().replace(",", "");
				dgg=dgg.replace(" VND","");
				Double dongia=Double.parseDouble(dgg);
				Double thanhTien=dongia*Double.parseDouble(table2.getValueAt(i, 1).toString());
				table2.setValueAt(test.formatter.format(thanhTien)+ " VND", i, 3);
				String tt=table2.getValueAt(i, 3).toString();
				tt=tt.replace(",", "");
				tt=tt.replace(" VND","");
				Double t=Double.parseDouble(tt);
				tongtien=(tongtien+t);
				String sls=(table2.getValueAt(i,1).toString());
				sl=sl+Integer.parseInt(sls);
			}
			tongcong=tongtien*1.05;
			txtTongTienHang.setText(test.formatter.format(tongtien)+" VND");
			txtTongCong.setText(test.formatter.format(tongcong)+" VND");
			txtSoLuong.setText(sl+"");
			txtThue.setText("5%");
			
	}

	private int ktraCo(String ma) {
			for (int i=0;i<table2.getRowCount();i++) {
				String m="";
				m=table2.getModel().getValueAt(i, 0).toString();
				if (m.equals(ma)) return i;
				
			}
			return -1;
			
		}
	
    @SuppressWarnings({ "unused", "static-access" })
	private void huyChon() {
			// TODO Auto-generated method stub
    
    	int row=table2.getSelectedRow();
		if (row>-1) {
			String reply="-1";
			reply = JOptionPane.showInputDialog(null, "Nhập số lượng mới cần thay đổi (nhập 0 để hủy chọn linh kiện trên)","0");
			
			int irep=-1;
			if (reply!=null &&(!reply.equals("")) ){
				irep=Integer.parseInt(reply);
			}
			if (irep==0) {
				dataModel2.removeRow(row);
				JOptionPane.showMessageDialog(null, "Đã hủy chọn thành công");
			}else 
			if (irep<0)
			{
				JOptionPane.showMessageDialog(null, "Nhập liệu sai hoặc đã hủy tác vụ.");
				
			}else
			if (irep>0){
					String malk=table2.getModel().getValueAt(row, 0).toString();
					String sl=table2.getValueAt(row, 1).toString();
					int slt=0;
					String sls="";
					try {
						Connection con=Database.getInstance().getConnection();
						String sql="select soluong from linhkien where malinhkien=?";
						PreparedStatement stm=con.prepareStatement(sql);
						stm.setString(1,malk);
						ResultSet rs = stm.executeQuery();
						while(rs.next()) {
							slt=rs.getInt(1);
						}
					}catch (SQLException e2) {
					e2.printStackTrace();
					}
					if (slt<irep) {
						JOptionPane.showMessageDialog(null, "Số lượng tồn của sản phẩm "+table2.getModel().getValueAt(row, 1).toString()+" hiện không đủ, xem lại dữ liệu số lượng.");
					}else {
						table2.setValueAt(irep+"", row, 1);
						JOptionPane.showMessageDialog(null, "Thay đổi số lượng thành công.");
					}
				}
			}
		capNhatTongTien();
	}

    @SuppressWarnings("static-access")
	private void thanhToan() throws IOException {
	
		// TODO Auto-generated method stub
		if (ktraSL()==true) {
			dshd.themHoaDon(test.maNhanVien,txtMaKhachHang.getText().toString());
		
		List<HoaDon> ds=dshd.docTuBang();
		HoaDon e = ds.get(ds.size() - 1);
		
		String mahd=e.getMaHoaDon();
		//System.out.println(mahd);
		for (int i=0;i<table2.getRowCount();i++) {
			String malk=table2.getModel().getValueAt(i, 0).toString();
			String sl=table2.getModel().getValueAt(i, 2).toString();
			String dg=table2.getModel().getValueAt(i, 3).toString();
			String dgg=dg.replace(",", "");
			dgg=dgg.replace(" VND","");
			dsct.themCTHD(mahd, malk, sl, dgg);
		}
		for (int i=0;i<table2.getRowCount();i++) {
			String malk=table2.getModel().getValueAt(i, 0).toString();
			String sl=table2.getValueAt(i, 1).toString();
			int slt=0;
			String sls="";
			try {
				Connection con=Database.getInstance().getConnection();
				String sql="select soluong from linhkien where malinhkien=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,malk);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					slt=rs.getInt(1);
				}
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			sls=(slt-Integer.parseInt(sl))+"";
			dslk.suaLinhKien2(sls, malk);
		}
		JOptionPane.showMessageDialog(null, "Thêm thành công!");
		UI_ThemHoaDon frm=new UI_ThemHoaDon();
		frm.setVisible(true);
		inThu();
		this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "thất bại.");
		}
		
	}
    @SuppressWarnings({ "unused", "static-access" })
	public boolean ktraSL() {
    	boolean kq=true;
    	
    	
    	for (int i=0;i<table2.getRowCount();i++) {
			String malk=table2.getModel().getValueAt(i, 0).toString();
			String sl=table2.getValueAt(i, 1).toString();
			int slt=0;
			String sls="";
			try {
				Connection con=Database.getInstance().getConnection();
				String sql="select soluong from linhkien where malinhkien=?";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,malk);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					slt=rs.getInt(1);
				}
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			if (slt<Integer.parseInt(sl)) {
				JOptionPane.showMessageDialog(null, "Số lượng tồn của sản phẩm "+table2.getModel().getValueAt(i, 1).toString()+" hiện không đủ, xem lại dữ liệu số lượng.");
				return false;
			}
			
		}
    	
    	if (txtMaKhachHang.getText().trim().equals("")) {
    		JOptionPane.showMessageDialog(null, "Nhập thông tin (số điện thoại) của khách hàng.");
    		return false;
    	}
    	if (txtMaKhachHang.getText().trim()==null) {
    		JOptionPane.showMessageDialog(null, "Nhập thông tin (số điện thoại) của khách hàng.");
    		return false;
    	}
    	if (table2.getRowCount()<=0) {
    		JOptionPane.showMessageDialog(null, "Chưa có linh kiện nào được thêm vào hóa đơn.");
    		return false;
    	}
    	return kq;
    }
    public void xemThu() {
    	JFrame frm=new JFrame();
    	frm.setSize(1600,986);
    	frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frm.setResizable(false);
        frm.setLocationRelativeTo ( null );
        frm.getContentPane().add(pnlXemTruoc());
        frm.setVisible(true);
    	
    }
    public void inThu() throws IOException {
    	
    	
    	ImageIO.write(createImage(pnlXemTruoc(),1600,986), "png",new File("./hoadon.png"));
    }
   public JPanel pnlXemTruoc() {
	  JPanel pnlTong=new JPanel();
   	pnlTong.setBorder(new LineBorder(new Color(0, 0, 0)));
   	pnlTong.setSize(1600, 986);
   	pnlTong.setBackground(Color.white);
   	pnlTong.setLayout(null);
   	
   	JLabel label = new JLabel("Ngày: "+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
   	label.setHorizontalAlignment(SwingConstants.CENTER);
   	label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	label.setBounds(667, 157, 266, 60);
   	pnlTong.add(label);
   	
   	JLabel lblTnKhchHng = new JLabel("Tên khách hàng: "+txtTenKhachHang.getText());
   	lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblTnKhchHng.setBounds(191, 208, 266, 60);
   	pnlTong.add(lblTnKhchHng);
   	
   	JLabel lblaCh = new JLabel("Địa chỉ: "+txtDiaChi.getText());
   	lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblaCh.setBounds(191, 242, 266, 60);
   	pnlTong.add(lblaCh);
   	
   	JLabel lblSinThoi_1 = new JLabel("Số điện thoại: "+txtSoDienThoai.getText());
   	lblSinThoi_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblSinThoi_1.setBounds(191, 280, 266, 60);
   	pnlTong.add(lblSinThoi_1);
   	
 
   	
   	ImageIcon img=new ImageIcon("./anh/logo.png");
   	JLabel lblAnh=new JLabel(img);
   	lblAnh.setLocation(189, 0);
   	lblAnh.setSize(200, 128);
   	pnlTong.add(lblAnh);
   	
   	JLabel lblNewLabel = new JLabel("HÓA ĐƠN BÁN HÀNG");
   	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
   	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
   	lblNewLabel.setBounds(556, 114, 488, 75);
   	pnlTong.add(lblNewLabel);
   	
   	JLabel lblNewLabel_1 = new JLabel("CỬA HÀNG LINH KIỆN MÁY TÍNH REEPBC");
   	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
   	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
   	lblNewLabel_1.setBounds(873, -32, 544, 128);
   	pnlTong.add(lblNewLabel_1);
   	
   	JLabel lblNewLabel_2 = new JLabel("Địa chỉ: 12 Nguyễn Văn Bảo, P.4, Gò Vấp, Hồ Chí Minh");
   	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
   	lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
   	lblNewLabel_2.setBounds(925, 49, 438, 31);
   	pnlTong.add(lblNewLabel_2);
   	
   	JLabel lblNewLabel_2_1_1 = new JLabel("Email: reepbc.govap.12@gmail.com");
   	lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
   	lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
   	lblNewLabel_2_1_1.setBounds(925, 68, 438, 31);
   	pnlTong.add(lblNewLabel_2_1_1);
   	
   	JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại: 082080808");
   	lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
   	lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
   	lblNewLabel_2_1.setBounds(925, 91, 438, 31);
   	pnlTong.add(lblNewLabel_2_1);
   	
   	JLabel lblThu = new JLabel("Thuế: 5%");
   	lblThu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblThu.setBounds(191, 741, 266, 60);
   	pnlTong.add(lblThu);
   	
   	JLabel lblTngTinHng = new JLabel("Tổng tiền hàng: "+txtTongTienHang.getText());
   	lblTngTinHng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblTngTinHng.setBounds(191, 693, 266, 60);
   	pnlTong.add(lblTngTinHng);
   	
   	JLabel lblTngCng = new JLabel("Tổng cộng: "+txtTongCong.getText());
   	lblTngCng.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblTngCng.setBounds(191, 794, 266, 60);
   	pnlTong.add(lblTngCng);
   	
   	JLabel lblTnNhnVin = new JLabel("Người lập hóa đơn");
   	lblTnNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblTnNhnVin.setBounds(334, 851, 266, 60);
   	pnlTong.add(lblTnNhnVin);
   	
   	JLabel lblChKKhch = new JLabel("Khách Hàng");
   	lblChKKhch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   	lblChKKhch.setBounds(1117, 851, 266, 60);
   	pnlTong.add(lblChKKhch);
   	
	String[] headers0= {"","","",""};
   	String[] headers2= {"Tên linh kiện","Số lượng","Đơn giá","Thành tiền"};
   	DefaultTableModel dataModel3=new DefaultTableModel(headers0,0);	
   	dataModel3.addRow(headers2);
   	
   	for (int i=0;i<table2.getRowCount();i++) {
			String mt1=table2.getModel().getValueAt(i, 1).toString();
			String mt2=table2.getModel().getValueAt(i, 2).toString();
			String mt3=table2.getModel().getValueAt(i, 3).toString();
			String mt4=table2.getModel().getValueAt(i, 4).toString();
			String[] rowData= {mt1,mt2,mt3,mt4};
			dataModel3.addRow(rowData);
		}
   	
   	JTable table3 = new JTable(dataModel3);
   	table3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
   	table3.setRowHeight(30);
   	
   	
   	JScrollPane scrollBar = new JScrollPane(table3);
   	scrollBar.setBounds(191, 336, 1226, 358);
   	pnlTong.add(scrollBar);
   	return pnlTong;
   }
    public BufferedImage createImage(JPanel panel, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        panel.setSize(width, height); // or panel.getPreferedSize()
        layoutComponent(panel);
        panel.print(g);
        g.dispose();
        return bi;
    }

    private void layoutComponent(Component component) {
        synchronized (component.getTreeLock()) {
            component.doLayout();

            if (component instanceof Container) {
                for (Component child : ((Container) component).getComponents()) {
                    layoutComponent(child);
                }
            }
        }
    }
}

