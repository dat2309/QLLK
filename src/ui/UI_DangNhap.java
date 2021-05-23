package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.Database;

import dao.DanhSachNhanVien;


public class UI_DangNhap extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JPanel pnlDangNhap;
	private JButton btnDangNhap;

	public UI_DangNhap() {
		setTitle("REEBPC");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
        setIconImage(icon);
        Database.getInstance().connect();
        buildUI();
	}
	
	private void buildUI() {
		pnlDangNhap = new JPanel();
		
		add(pnlDangNhap,BorderLayout.CENTER);
		
		pnlDangNhap.setBackground(Color.WHITE);
		pnlDangNhap.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		
		txtTaiKhoan = new JTextField(300);
		txtMatKhau = new JPasswordField(300);
		
		btnDangNhap = new JButton("Đăng nhập");
		
	    Icon iconDangNhap = new ImageIcon("./icon/dangnhap.png");
		
		lblDangNhap.setFont(new Font("Times new roman", Font.BOLD,25));
		lblTaiKhoan.setFont(new Font("Times new roman", Font.BOLD,20));
		lblMatKhau.setFont(new Font("Times new roman", Font.BOLD,20));
		btnDangNhap.setFont(new Font("Times new roman", Font.BOLD,16));
		txtTaiKhoan.setFont(new Font("Times new roman", Font.HANGING_BASELINE, 18));
		txtMatKhau.setFont(new Font("Times new roman", Font.HANGING_BASELINE, 18));
		
		lblDangNhap.setOpaque(true);
		
		lblDangNhap.setBackground(Color.decode("#92bbfc"));
		btnDangNhap.setBackground(Color.decode("#4688f2"));
//		lblDangNhap.setPreferredSize(new Dimension(850,100));
		lblDangNhap.setHorizontalAlignment(JLabel.CENTER);
	    lblDangNhap.setVerticalAlignment(JLabel.CENTER);
	    
	    btnDangNhap.setIcon(iconDangNhap);
	    btnDangNhap.setForeground(Color.WHITE);
	    
		pnlDangNhap.add(lblDangNhap);
		pnlDangNhap.add(lblTaiKhoan);
		pnlDangNhap.add(txtTaiKhoan);
		pnlDangNhap.add(lblMatKhau);
		pnlDangNhap.add(txtMatKhau);
		pnlDangNhap.add(btnDangNhap);
		
		lblDangNhap.setBounds(5, 30, 600,50);
		lblTaiKhoan.setBounds(80, 120, 100, 30);
		txtTaiKhoan.setBounds(200, 120, 300, 25);
		lblMatKhau.setBounds(80, 170, 100, 30);
		txtMatKhau.setBounds(200, 170, 300, 25);
		btnDangNhap.setBounds(350, 250, 150, 40);
		txtTaiKhoan.setText("NV0001");
		//
		btnDangNhap.addActionListener(this);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean kt=false;
		Object o=e.getSource();
		if (o.equals(btnDangNhap)) {
			DanhSachNhanVien ds=new DanhSachNhanVien();
			String mk=ds.docMatKhau(txtTaiKhoan.getText());
			if (mk.equals(txtMatKhau.getText())) {
				test.maNhanVien=txtTaiKhoan.getText();
				test.tenNhanVien=ds.docTen(txtTaiKhoan.getText());
				test.loaiNhanVien=ds.docLoai(txtTaiKhoan.getText());
				UI_TrangChu frm=new UI_TrangChu();
				frm.setVisible(true);
				this.dispose();
			}else
			if (kt==false) {
				 JOptionPane.showMessageDialog(this, "Mật Khẩu hoặc Tài Khoản không chính xác.\nVui lòng kiểm tra lại.", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
			
			
		}
	}
	

