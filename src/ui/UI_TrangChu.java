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
		
		
		if (test.loaiNhanVien==1) lblTen.setText(test.tenNhanVien+" (Nh??n vi??n)");
		if (test.loaiNhanVien==0) lblTen.setText(test.tenNhanVien+" (Qu???n l??)");
		lblTen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblTen);
		
		lblPhnMmQun = new JLabel("Ph???n m???m qu???n l?? linh ki???n c???a h??ng REEBPC - V1.0");
		lblPhnMmQun.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPhnMmQun.setBounds(1400, 1000, 475, 38);
		panel.add(lblPhnMmQun);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng nhanh:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 240, 175, 258);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNHD = new JButton("T???o h??a ????n");
		btnNHD.setBounds(10, 20, 155, 40);
		panel_1.add(btnNHD);
		
		btnNKH = new JButton("Qu???n L?? Kh??ch H??ng");
		btnNKH.setBounds(10, 80, 155, 40);
		panel_1.add(btnNKH);
		
		btnNLK = new JButton("Qu???n L?? Linh Ki???n");
		btnNLK.setBounds(10, 140, 155, 40);
		panel_1.add(btnNLK);
		
		btnNTK = new JButton("Th???ng k?? h??a ????n");
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
		mnHeThong = new JMenu("H??? Th???ng");
		mnHeThong.setBackground(Color.WHITE);
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnQuanLy = new JMenu("Qu???n L??");
		mnQuanLy.setBackground(Color.WHITE);
		mnQuanLy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe = new JMenu("Th???ng K??");
		mnThongKe.setBackground(Color.WHITE);
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHoTro = new JMenu("H??? Tr???");
		mnHoTro.setBackground(Color.WHITE);
		mnHoTro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itTrangChu =new JMenuItem("Trang Ch???");
		itTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itDangXuat =new JMenuItem("????ng Xu???t");
		itDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itThoat = new JMenuItem("Tho??t");
		itThoat.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		itLinhKien=new JMenuItem("Linh Ki???n");
		itLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itKhachHang=new JMenuItem("Kh??ch H??ng");
		itKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itHoaDon=new JMenuItem("H??a ????n");
		itHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itLoaiLinhKien=new JMenuItem("Lo???i Linh Ki???n");
		itLoaiLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhaCungCap=new JMenuItem("Nh?? Cung C???p");
		itNhaCungCap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhanVien=new JMenuItem("Nh??n Vi??n");
		itNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		
		itTKNV=new JMenuItem("Th???ng K?? Nh??n Vi??n");
		itTKNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itTKHD=new JMenuItem("Th???ng k?? H??a ????n");
		itTKHD.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itHuongDan=new JMenuItem("H?????ng D???n");
		itHuongDan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itGioiThieu=new JMenuItem("Gi???i Thi???u");
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
				 JDialog d = new JDialog(this, "Gi???i thi???u"); 
		 
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
					
					JLabel lblNewLabel_1 = new JLabel("Ph???n m???m qu???n l?? mua b??n linh ki???n");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1.setBounds(220, 11, 538, 35);
					pnlTong.add(lblNewLabel_1);
					
					JLabel lblNewLabel_1_1 = new JLabel("Phi??n b???n 0.01");
					lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_1.setBounds(220, 52, 538, 35);
					pnlTong.add(lblNewLabel_1_1);
					
					JLabel lblNewLabel_1_2 = new JLabel("Th??nh vi??n nh??m");
					lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2.setBounds(220, 87, 538, 35);
					pnlTong.add(lblNewLabel_1_2);
					
					JLabel lblNewLabel_1_2_1 = new JLabel("Ng?? Quang Long");
					lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1.setBounds(220, 133, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1);
					
					JLabel lblNewLabel_1_2_1_1 = new JLabel("Nguy???n Th??? ?????t");
					lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1.setBounds(220, 170, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1);
					
					JLabel lblNewLabel_1_2_1_1_1 = new JLabel("L?? D?? Khang");
					lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1_1.setBounds(220, 206, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1_1);
					
					JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Tr???n Minh Ngh??a");
					lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
					lblNewLabel_1_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					lblNewLabel_1_2_1_1_1_1.setBounds(220, 240, 538, 35);
					pnlTong.add(lblNewLabel_1_2_1_1_1_1);
					
					JTextPane txtpnMnHcPht = new JTextPane();
					//txtpnMnHcPht.setEnabled(false);
					txtpnMnHcPht.setEditable(false);
					txtpnMnHcPht.setFont(new Font("Times New Roman", Font.PLAIN, 18));
					txtpnMnHcPht.setText("M??n h???c: Ph??t tri???n ???ng d???ng.\r\nGi???ng vi??n: Tr???n Th??? Anh Thi.\r\nL???p: DHKTPM14.\r\nTr?????ng ?????i h???c C??ng Nghi???p TP.HCM.");
					txtpnMnHcPht.setBounds(220, 133, 376, 128);
					txtpnMnHcPht.setBorder(new TitledBorder(null, "Th??ng tin m??n h???c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
