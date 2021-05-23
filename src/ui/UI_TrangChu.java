package ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;


public class UI_TrangChu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mnHeThong;
	private JMenu mnQuanLy;
	private JMenu mnThongKe;
	private JMenu mnHoTro;

	private JMenuItem itTrangChu;
	private JMenuItem itDangXuat;
	private JMenuItem itThoat;
	
	private JMenuItem itLinhKien;
	private JMenuItem itKhachHang;
	private JMenuItem itHoaDon;
	private JMenuItem itLoaiLinhKien;
	private JMenuItem itNhaCungCap;
	private JMenuItem itNhanVien;
	
	
	private JMenuItem itTKNV;
	private JMenuItem itTKHD;
	
	private JMenuItem itHuongDan;
	private JMenuItem itGioiThieu;
	public static UI_LinhKien frmLK=new UI_LinhKien();
	public  static UI_KhachHang frmKH=new UI_KhachHang();
	public  static UI_LoaiLinhKien frmLLK=new UI_LoaiLinhKien();
	public  static UI_NhaCungCap frmNCC=new UI_NhaCungCap();
	public static UI_NhanVien frmNV=new UI_NhanVien();
	public static UI_HoaDon frmHD=new UI_HoaDon();
	public static UI_ThemHoaDon frmTHD=new UI_ThemHoaDon();
	public static UI_ThongKeHoaDon frmTKHD=new UI_ThongKeHoaDon();
	
	
	private JPanel panel;
	private JLabel lblPhnMmQun;
	private JButton btnNHD;
	private JButton btnNKH;
	private JButton btnNLK;
	private JButton btnNTK;

		
	
	public UI_TrangChu() {
		getContentPane().setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTen = new JLabel("New label");
		lblTen.setBounds(10, 1000, 475, 38);
		
		
		if (test.loaiNhanVien==1) lblTen.setText(test.tenNhanVien+" (Nhân viên)");
		if (test.loaiNhanVien==0) lblTen.setText(test.tenNhanVien+" (Quản lý)");
		lblTen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblTen);
		
		lblPhnMmQun = new JLabel("Phần mềm quản lý linh kiện cửa hàng REEBPC - V1.0");
		lblPhnMmQun.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPhnMmQun.setBounds(1400, 1000, 475, 38);
		panel.add(lblPhnMmQun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng nhanh:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 240, 175, 258);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNHD = new JButton("Tạo hóa đơn");
		btnNHD.setBounds(10, 20, 155, 40);
		panel_1.add(btnNHD);
		
		btnNKH = new JButton("Quản Lý Khách Hàng");
		btnNKH.setBounds(10, 80, 155, 40);
		panel_1.add(btnNKH);
		
		btnNLK = new JButton("Quản Lý Linh Kiện");
		btnNLK.setBounds(10, 140, 155, 40);
		panel_1.add(btnNLK);
		
		btnNTK = new JButton("Thống kê hóa đơn");
		btnNTK.setBounds(10, 200, 155, 40);
		panel_1.add(btnNTK);
		
 
		
		ImageIcon img=new ImageIcon("./anh/logo.png");
	   	JLabel lblAnh=new JLabel(img);
	   	lblAnh.setBounds(250, 240, 1400, 400);
	   	
		panel.add(lblAnh);
		
		setTitle("REEBPC");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
        setIconImage(icon);
        buildUI();
        
        btnNHD.addActionListener(this);
        btnNLK.addActionListener(this);
        btnNKH.addActionListener(this);
        btnNTK.addActionListener(this);
        
	}
	private void buildUI() {
		setJMenuBar(taoMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
	}
	public JMenuBar taoMenu() {
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Color.WHITE);
		mnHeThong = new JMenu("Hệ Thống");
		mnHeThong.setBackground(Color.WHITE);
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnQuanLy = new JMenu("Quản Lý");
		mnQuanLy.setBackground(Color.WHITE);
		mnQuanLy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setBackground(Color.WHITE);
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHoTro = new JMenu("Hỗ Trợ");
		mnHoTro.setBackground(Color.WHITE);
		mnHoTro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itTrangChu =new JMenuItem("Trang Chủ");
		itTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itDangXuat =new JMenuItem("Đăng Xuất");
		itDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itThoat = new JMenuItem("Thoát");
		itThoat.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		itLinhKien=new JMenuItem("Linh Kiện");
		itLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itKhachHang=new JMenuItem("Khách Hàng");
		itKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itHoaDon=new JMenuItem("Hóa Đơn");
		itHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itLoaiLinhKien=new JMenuItem("Loại Linh Kiện");
		itLoaiLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhaCungCap=new JMenuItem("Nhà Cung Cấp");
		itNhaCungCap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhanVien=new JMenuItem("Nhân Viên");
		itNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		
		itTKNV=new JMenuItem("Thống Kê Nhân Viên");
		itTKNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itTKHD=new JMenuItem("Thống kê Hóa Đơn");
		itTKHD.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itHuongDan=new JMenuItem("Hướng Dẫn");
		itHuongDan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itGioiThieu=new JMenuItem("Giới Thiệu");
		itGioiThieu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		mnHeThong.setIcon(new ImageIcon("./icon/home.png"));
		mnQuanLy.setIcon(new ImageIcon("./icon/quanly.png"));
		mnThongKe.setIcon(new ImageIcon("./icon/statistical.png"));
		mnHoTro.setIcon(new ImageIcon("./icon/huongdan.png"));
		
		itTrangChu.setIcon(new ImageIcon("./icon/dangxuat.png"));
		itDangXuat.setIcon(new ImageIcon("./icon/dangxuat.png"));
		itThoat.setIcon(new ImageIcon("./icon/thoat.png"));
		
		itLinhKien.setIcon(new ImageIcon("./icon/computer.png"));
		itKhachHang.setIcon(new ImageIcon("./icon/customer.png"));
		itHoaDon.setIcon(new ImageIcon("./icon/bill.png"));
		itLoaiLinhKien.setIcon(new ImageIcon("./icon/plus.png"));
		itNhaCungCap.setIcon(new ImageIcon("./icon/ncc.png"));
		itNhanVien.setIcon(new ImageIcon("./icon/staff.png"));

		
		itTKNV.setIcon(new ImageIcon("./icon/maintenance.png"));
		itTKHD.setIcon(new ImageIcon("./icon/maintenance.png"));
		
		itHuongDan.setIcon(new ImageIcon("./icon/huongdan.png"));
		itGioiThieu.setIcon(new ImageIcon("./icon/about.png"));
		
		mb.add(mnHeThong);
		mb.add(mnQuanLy);
		mb.add(mnThongKe);
		mb.add(mnHoTro);
		
		mnHeThong.add(itDangXuat);
		mnHeThong.add(itThoat);
		
		mnQuanLy.add(itLinhKien);
		mnQuanLy.add(itKhachHang);
		mnQuanLy.add(itHoaDon);
		mnQuanLy.add(itLoaiLinhKien);
		mnQuanLy.add(itNhaCungCap);
		if (test.loaiNhanVien==0) mnQuanLy.add(itNhanVien);
	
		
		//mnThongKe.add(itTKNV);
		mnThongKe.add(itTKHD);
		
		mnHoTro.add(itHuongDan);
		mnHoTro.add(itGioiThieu);
		
		itLinhKien.addActionListener(this);
		itKhachHang.addActionListener(this);
		itLoaiLinhKien.addActionListener(this);
		itNhaCungCap.addActionListener(this);
		itThoat.addActionListener(this);
		itNhanVien.addActionListener(this);
		itHoaDon.addActionListener(this);
		itDangXuat.addActionListener(this);
		itHuongDan.addActionListener(this);
		itTKHD.addActionListener(this);
		itGioiThieu.addActionListener(this);
		itTKNV.addActionListener(this);
		return mb;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if (o.equals(itLinhKien)) {
		//	xoaHet();
			frmLK=new UI_LinhKien();
			frmLK.setVisible(true);
		}else
		if (o.equals(itKhachHang)) {
			//xoaHet();
			frmKH=new UI_KhachHang();
			frmKH.setVisible(true);
		}else
		if (o.equals(itLoaiLinhKien)) {
			xoaHet();
			frmLLK=new UI_LoaiLinhKien();
			frmLLK.setVisible(true);
		}
		else
		if (o.equals(itNhaCungCap)) {
			xoaHet();
			frmNCC=new UI_NhaCungCap();
			frmNCC.setVisible(true);
		}else
		if (o.equals(itNhanVien)) {
			xoaHet();
			frmNV=new UI_NhanVien();
			frmNV.setVisible(true);
		}
		else
		if (o.equals(itHoaDon)) {
			xoaHet();
			frmHD=new UI_HoaDon();
			frmHD.setVisible(true);
		}
		else
		if (o.equals(itThoat)) {
			  System.exit(0);
		}else
		if (o.equals(itDangXuat)) {
				xoaHet();
				UI_DangNhap frm=new UI_DangNhap();
				frm.setVisible(true);
				
				test.maNhanVien="";
				test.tenNhanVien="";
				this.dispose();
		}else
		if (o.equals(itTKHD)) {
			xoaHet();
			frmTKHD=new UI_ThongKeHoaDon();
			frmTKHD.setVisible(true);
		}
		else
			if (o.equals(itGioiThieu)) {
				 JDialog d = new JDialog(this, "Giới thiệu"); 
		 
					JPanel pnlTong = new JPanel();
					pnlTong.setBackground(Color.WHITE);
					pnlTong.setForeground(Color.BLACK);
					getContentPane().add(pnlTong, BorderLayout.CENTER);
					pnlTong.setLayout(null);
					
					ImageIcon img=new ImageIcon("./anh/logo.png");
				   	@SuppressWarnings("unused")
					JLabel lblAnh=new JLabel(img);
				   	
					JLabel lblNewLabel = new JLabel(img);
					lblNewLabel.setBounds(10, 11, 200, 128);
					pnlTong.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("Phần mềm quản lý mua bán linh kiện");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1.setBounds(220, 11, 538, 35);
					pnlTong.add(lblNewLabel_1);
					
					JLabel lblNewLabel_1_1 = new JLabel("Phiên bản 0.01");
					lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_1.setBounds(220, 52, 538, 35);
					pnlTong.add(lblNewLabel_1_1);
					
					JLabel lblNewLabel_1_2 = new JLabel("Thành viên nhóm");
					lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2.setBounds(220, 87, 538, 35);
					pnlTong.add(lblNewLabel_1_2);
					
					JLabel lblNewLabel_1_2_1 = new JLabel("Ngô Quang Long");
					lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1.setBounds(220, 133, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1);
					
					JLabel lblNewLabel_1_2_1_1 = new JLabel("Nguyễn Thế Đạt");
					lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1.setBounds(220, 170, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1);
					
					JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Lê Dĩ Khang");
					lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1_1.setBounds(220, 206, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1_1);
					
					JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Trần Minh Nghĩa");
					lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1_1_1.setBounds(220, 240, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1_1_1);
					
					JTextPane txtpnMnHcPht = new JTextPane();
					//txtpnMnHcPht.setEnabled(false);
					txtpnMnHcPht.setEditable(false);
					txtpnMnHcPht.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					txtpnMnHcPht.setText("Môn học: Phát triển ứng dụng.\r\nGiảng viên: Trần Thị Anh Thi.\r\nLớp: DHKTPM14.\r\nTrường Đại học Công Nghiệp TP.HCM.");
					txtpnMnHcPht.setBounds(220, 133, 376, 128);
					txtpnMnHcPht.setBorder(new TitledBorder(null, "Thông tin môn học", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					pnlTong.add(txtpnMnHcPht);
					
				d.getContentPane().add(pnlTong);
		         d.setSize(780, 332); 
		     	 d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		         d.setResizable(false);
		         d.setLocationRelativeTo ( null );
		         d.setVisible(true); 
			}
		else
		if (o.equals(itHuongDan)) {
			File file = new java.io.File("./html/index.html").getAbsoluteFile();
            try {
				Desktop.getDesktop().open(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
		}else
		if (o.equals(btnNHD)) {
			xoaHet();
			UI_ThemHoaDon frmThemHoaDon=new UI_ThemHoaDon();
			frmThemHoaDon.setVisible(true);
		}else
		if (o.equals(btnNLK)) {
			xoaHet();
			UI_LinhKien frmLinhKien= new UI_LinhKien();
			frmLinhKien.setVisible(true);
		}else
		if (o.equals(btnNKH)) {
			xoaHet();
			UI_KhachHang frmKhachHang=new UI_KhachHang();
			frmKhachHang.setVisible(true);
			
		}else
		if (o.equals(btnNTK)) {
			xoaHet();
			UI_ThongKeHoaDon frmTKHDon=new UI_ThongKeHoaDon();
			frmTKHDon.setVisible(true);
		}
	}
	public void xoaHet() {
		frmLK.dispose();
		frmKH.dispose();
		frmLLK.dispose();
		frmNCC.dispose();
		frmNV.dispose();
		frmHD.dispose();
		frmTHD.dispose();
		frmTKHD.dispose();
	}
}
