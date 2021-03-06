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


import dao.DanhSachNhaCungCap;

import dao.Database;
import javax.swing.border.Border;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_NhaCungCap extends JDialog implements MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi;
	
	private JLabel lblMaNCC,lblTenNCC,lblSoDienThoai,lblDiaChi,lblEmail;
	private JTextField txtMaNCC,txtTenNCC,txtSoDienThoai,txtDiaChi,txtEmail;
	
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

	

	private DanhSachNhaCungCap dsncc=new DanhSachNhaCungCap();
	
	private JLabel lblTenTK;
	private JTextField txtDiaChiTK;
	private JTextField txtSoDienThoaiTK;
	private JTextField txtEmailTK;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut_5;
	private Component horizontalStrut_6;
	
	public UI_NhaCungCap() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Qu???n l?? nh?? cung c???p");
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
		bThongTin.setBorder(new TitledBorder(null, "Th??ng tin nh?? cung c???p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaNCC=new JLabel("M?? nh?? cung c???p: ");
		lblMaNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenNCC=new JLabel("T??n nh?? cung c???p: ");
		lblTenNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai=new JLabel("S??? ??i???n tho???i: ");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi=new JLabel("?????a ch???: ");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail=new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblDiaChi.setPreferredSize(lblTenNCC.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblMaNCC.getPreferredSize());
		lblEmail.setPreferredSize(lblMaNCC.getPreferredSize());
		
		
		
		txtMaNCC=new JTextField();
		txtMaNCC.setColumns(7);
		txtMaNCC.setBackground(Color.WHITE);
		txtMaNCC.setEditable(false);
		txtMaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenNCC=new JTextField();
		txtTenNCC.setColumns(7);
		txtTenNCC.setBackground(Color.WHITE);
		txtTenNCC.setEditable(false);
		txtTenNCC.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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
		txtEmail=new JTextField();
		txtEmail.setColumns(7);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//add vao
		Box b01,b02,b03;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		b03=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b03);
		bThongTin.add(Box.createVerticalStrut(5));
		
		b01.add(lblMaNCC);
		b01.add(txtMaNCC);
		b01.add(lblTenNCC);
		b01.add(txtTenNCC);
	
		b02.add(lblSoDienThoai);
		b02.add(txtSoDienThoai);
		b02.add(lblDiaChi);
		b02.add(txtDiaChi);
		
		b03.add(lblEmail);
		b03.add(txtEmail);
		// hinh an linh kien
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Th??m nh?? cung c???p m???i");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua=new JButton("Thay ?????i th??ng tin");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLuu=new JButton("L??u");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy=new JButton("H???y");
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThongBao=new JLabel("Tr???ng Th??i:        ");
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
		btk.setBorder(new TitledBorder("T??m Ki???m"));
		Box b11;
		
		verticalStrut = Box.createVerticalStrut(20);
		btk.add(verticalStrut);
		b11=Box.createHorizontalBox();
		
		btk.add(b11);
		
		txtTenTK=new JTextField();
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnTimKiem=new JButton("T??m ki???m");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		lblTenTK = new JLabel("T??n nh?? cung c???p:     ");
		lblTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDiaChiTK = new JLabel("?????a Ch???:   ");
		lblDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JLabel lblSoDienThoaiTK = new JLabel("S??? ??i???n Tho???i:   ");
		lblSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JLabel lblEmailTK = new JLabel("Email:   ");
		lblEmailTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtDiaChiTK=new JTextField();
		txtDiaChiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoDienThoaiTK=new JTextField();
		txtSoDienThoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEmailTK=new JTextField();
		txtEmailTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		
		b11.add(lblTenTK);
		b11.add(txtTenTK);
		
		horizontalStrut_3 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_3);
		b11.add(lblDiaChiTK);
		b11.add(txtDiaChiTK);
		
		horizontalStrut_4 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_4);
		b11.add(lblSoDienThoaiTK);
		b11.add(txtSoDienThoaiTK);
		
		horizontalStrut_6 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_6);
		b11.add(lblEmailTK);
		b11.add(txtEmailTK);
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_5);
		b11.add(btnTimKiem);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		btk.add(verticalStrut_1);
		
	
		btk.setMaximumSize(new Dimension(1600, 100));
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh s??ch nh?? cung c???p"));
		String[] headers= {"M?? nh?? cung c???p","T??n nh?? cung c???p","?????a ch???","S??? ??i???n tho???i","Email"};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dsncc.docTableQLNCC());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem th??ng tin nh?? cung c???p");
		xoaRongTextField();
	
		txtTenNCC.addKeyListener(this);
		txtSoDienThoai.addKeyListener(this);
		txtDiaChi.addKeyListener(this);
		txtEmail.addKeyListener(this);
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
			String[] ttam=dsncc.docTextFieldQLNCC(ma);
			txtMaNCC.setText(ttam[0]);
			txtTenNCC.setText(ttam[1]);
		
			txtDiaChi.setText(ttam[2]);
			txtSoDienThoai.setText(ttam[3]);
			txtEmail.setText(ttam[4]);
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
			setTrangThai("Th??m nh?? cung c???p m???i, nh???p th??ng tin tr??n c??c ?? tr???ng v?? b???m l??u.");
			txtMaNCC.setText(" <<T??? ?????ng t???o>>");
		}else
		if (o.equals(btnSua)) {
			if (!txtMaNCC.getText().equals("")) {
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				
				table.setEnabled(false);
				table.clearSelection();
				editTextField();
				
				hanhdong=2;
				setTrangThai("Thay ?????i th??ng tin nh?? cung c???p, s???a ?????i th??ng tin c???n thi???t v?? b???m l??u.");
			}else {
				JOptionPane.showMessageDialog(null, "C???n ch???n nh?? cung c???p trong b???ng tr?????c khi thay ?????i.");
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
			setTrangThai("Xem th??ng tin nh?? cung c???p");
		}else
		
		if (o.equals(btnLuu)) {
			
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "B???n c?? mu???n th??m nh?? cung c???p n??y kh??ng?","C???nh b??o",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					if (themNhaCungCap()) {
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
						table.setModel(dsncc.docTableQLNCC());
						table.setRowHeight(50);
						hanhdong=0;
						setTrangThai("Xem th??ng tin");
						JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng.");
					}
						
			
				}
				}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "B???n c?? mu???n thay ?????i th??ng tin Nh?? cung c???p n??y kh??ng?","C???nh b??o",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						if (suaNhaCungCap()) {
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
							table.setModel(dsncc.docTableQLNCC());
							table.setRowHeight(50);
							hanhdong=0;
							setTrangThai("Xem th??ng tin");
							JOptionPane.showMessageDialog(null, "Thay ?????i th??nh c??ng.");
						}
						
				}
			}
		
			
		}else
		
		if (o.equals(btnTimKiem)) {
			locTK();
		}
	}
	
	
	private boolean themNhaCungCap() {
		if (ktra()) {
			if (dsncc.themNCC(txtTenNCC.getText(),  txtDiaChi.getText(),txtSoDienThoai.getText(),txtEmail.getText())) 
				return true;
		}
		JOptionPane.showMessageDialog(null, "Th??m kh??ng th??nh c??ng.");
		return false;
	}
	private boolean suaNhaCungCap() {
		if (ktra()) {
			if (dsncc.suaNhaCungCap(txtTenNCC.getText(), txtDiaChi.getText(), txtSoDienThoai.getText(), txtEmail.getText(),txtMaNCC.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thay ?????i kh??ng th??nh c??ng.");
		return false;
	}
	private boolean ktra() {
		boolean kq=true;
		if (hanhdong==1 || hanhdong==2) {
			txtTenNCC.setBorder(new LineBorder(Color.BLACK, 1));
			txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
			txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
			txtEmail.setBorder(new LineBorder(Color.BLACK, 1));
			txtThongBao.setForeground(Color.BLACK);
			txtThongBao.setText("Nh???p li???u v?? b???m v??o n??t l??u.");
			
		
		
			if (txtEmail.getText().equals("") || !txtEmail.getText().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
				txtThongBao.setText("L???i nh???p li???u: Email nh???p kh??ng ????ng c?? ph??p. (C???n nh???p theo ????ng c?? ph??p email)");
				txtEmail.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtDiaChi.getText().equals("") ) {
				txtThongBao.setText("L???i nh???p li???u: ?????a ch??? nh???p kh??ng ????ng. (kh??ng ???????c r???ng)");
				txtDiaChi.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtSoDienThoai.getText().equals("")  || !(txtSoDienThoai.getText().matches("^[0-9]{10,11}"))) {
				txtThongBao.setText("L???i nh???p li???u: S??? ??i???n tho???i nh???p kh??ng ????ng. (T??? 10-11 k?? t??? s???)");
				txtSoDienThoai.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtTenNCC.getText().equals("") || !(txtTenNCC.getText().length()>=1) || !(txtTenNCC.getText().length()<=64)) {
				txtThongBao.setText("L???i nh???p li???u: T??n nh?? cung c???p nh???p kh??ng ????ng. (t??? 1 - 64 k?? t???)");
				txtTenNCC.setBorder(new LineBorder(Color.RED, 1));
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
		String dc=txtDiaChiTK.getText();
		String em=txtEmailTK.getText();
		table.setModel(dsncc.locNCC(ten,dc,sdt,em));
		table.setRowHeight(50);
	}

	public void editTextField() {
		txtTenNCC.setEditable(true);
		txtSoDienThoai.setEditable(true);
		txtDiaChi.setEditable(true);
		txtEmail.setEditable(true);
		
	}
	public void falseEditTextField() {
		txtTenNCC.setEditable(false);
		txtSoDienThoai.setEditable(false);
		txtDiaChi.setEditable(false);
		txtEmail.setEditable(false);
		
	}
	public void xoaRongTextField() {
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtThongBao.setForeground(Color.BLACK);
		
		txtTenNCC.setBorder(new LineBorder(Color.BLACK, 1));
		txtSoDienThoai.setBorder(new LineBorder(Color.BLACK, 1));
		txtDiaChi.setBorder(new LineBorder(Color.BLACK, 1));
		txtEmail.setBorder(new LineBorder(Color.BLACK, 1));
		
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
