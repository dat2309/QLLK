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

import dao.DanhSachLoaiLinhKien;

import dao.Database;
import javax.swing.border.Border;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_LoaiLinhKien extends JDialog implements MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bChucNang,bTren,bDuoi;
	
	private JLabel lblMaLoai,lblTenLoai;
	private JTextField txtMaLoai,txtTenLoai;
	
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

	

	private DanhSachLoaiLinhKien dsllk=new DanhSachLoaiLinhKien();
	
	private JLabel lblTnKH;

	private Component verticalStrut_1;
	private Component horizontalStrut_5;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	
	private JLabel lblMoTa1;
	private JLabel lblMoTa2;
	private JLabel lblMoTa3;
	private JLabel lblMoTa4;
	private JTextField txtMoTa1;
	private JTextField txtMoTa2;
	private JTextField txtMoTa3;
	private JTextField txtMoTa4;
	private Component verticalStrut_5;
	private Component verticalStrut_6;
	
	public UI_LoaiLinhKien() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Qu???n l?? lo???i linh ki???n");
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
		bTong.add(bGiua=Box.createHorizontalBox());
		bTong.add(bDuoi=Box.createVerticalBox());

		
		//thong tin linh kien
		bThongTin=Box.createVerticalBox();
		bThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bTren.add(bThongTin);
		bThongTin.setBackground(Color.WHITE);
		bThongTin.setBorder(new TitledBorder(null, "Th??ng tin lo???i linh ki???n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaLoai=new JLabel("M?? Lo???i:   ");
		lblMaLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenLoai=new JLabel(" T??n Lo???i:  ");
		lblTenLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa1=new JLabel(" M?? T??? 1:  ");
		lblMoTa1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa2=new JLabel(" M?? T??? 2:  ");
		lblMoTa2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa3=new JLabel(" M?? T??? 3:  ");
		lblMoTa3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa4=new JLabel(" M?? T??? 4:  ");
		lblMoTa4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		
		txtMaLoai=new JTextField();
		txtMaLoai.setColumns(7);
		txtMaLoai.setBackground(Color.WHITE);
		txtMaLoai.setEditable(false);
		txtMaLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenLoai=new JTextField();
		txtTenLoai.setColumns(7);
		txtTenLoai.setBackground(Color.WHITE);
		txtTenLoai.setEditable(false);
		txtTenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
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
		

		//add vao
		Box b01,b02,b03,b04;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		b03=Box.createHorizontalBox();
		b04=Box.createHorizontalBox();
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_3);
		bThongTin.add(b01);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_2);
		bThongTin.add(b02);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_5);
		bThongTin.add(b03);
		
		verticalStrut_6 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_6);
		bThongTin.add(b04);
		
		
		b01.add(lblMaLoai);
		b01.add(txtMaLoai);
		b01.add(lblTenLoai);
		b01.add(txtTenLoai);
		
		b02.add(lblMoTa1);
		b02.add(txtMoTa1);
		b02.add(lblMoTa2);
		b02.add(txtMoTa2);
		
		b03.add(lblMoTa3);
		b03.add(txtMoTa3);
		b03.add(lblMoTa4);
		b03.add(txtMoTa4);
		// hinh an linh kien
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Th??m lo???i linh ki???n m???i");
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
		
	

		b11=Box.createHorizontalBox();
		
		btk.add(b11);
		
		txtTenTK=new JTextField();
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnTimKiem=new JButton("T??m ki???m");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		lblTnKH = new JLabel("T??n Lo???i:   ");
		lblTnKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		
		b11.add(lblTnKH);
		b11.add(txtTenTK);
		
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_5);
		b11.add(btnTimKiem);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		btk.add(verticalStrut_1);
		
	
		btk.setMaximumSize(new Dimension(1600, 100));
		bThongTin.setMaximumSize(new Dimension(1600, 600));
		bGiua.setMaximumSize(new Dimension(1600, 600));
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh s??ch lo???i linh ki???n"));
		String[] headers= {"M?? lo???i","T??n lo???i","M?? t??? 1","M?? t??? 2","M?? t??? 3","M?? t??? 4"};
		dataModel=new DefaultTableModel(headers,0);	
		@SuppressWarnings("unused")
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dsllk.docTableQLLLK());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem th??ng tin lo???i linh ki???n");
		xoaRongTextField();
		
		txtTenLoai.addKeyListener(this);
		txtMoTa1.addKeyListener(this);
		txtMoTa2.addKeyListener(this);
		txtMoTa3.addKeyListener(this);
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
			String[] ttam=dsllk.docTextFieldQLLLK(ma);
			txtMaLoai.setText(ttam[0]);
			txtTenLoai.setText(ttam[1]);
			txtMoTa1.setText(ttam[2]);
			txtMoTa2.setText(ttam[3]);
			txtMoTa3.setText(ttam[4]);
			txtMoTa4.setText(ttam[5]);
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
			setTrangThai("Th??m lo???i linh ki???n m???i, nh???p th??ng tin tr??n c??c ?? tr???ng v?? b???m l??u.");
			txtMaLoai.setText(" <<T??? ?????ng t???o>>");
			txtTenLoai.requestFocus();
		}else
		if (o.equals(btnSua)) {
			if (!txtMaLoai.getText().equals("")) {
				btnThem.setEnabled(false);
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				btnLuu.setEnabled(true);
				
				table.setEnabled(false);
				table.clearSelection();
				editTextField();
				
				hanhdong=2;
				setTrangThai("Thay ?????i th??ng tin lo???i linh ki???n, s???a ?????i th??ng tin c???n thi???t v?? b???m l??u.");
			}else {
				JOptionPane.showMessageDialog(null, "C???n ch???n lo???i linh ki???n trong b???ng tr?????c khi thay ?????i.");
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
			setTrangThai("Xem th??ng tin lo???i linh ki???n");
		}else
		
		if (o.equals(btnLuu)) {
			
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "B???n c?? mu???n th??m lo???i linh ki???n n??y kh??ng?","C???nh b??o",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					if (themLoai()) {
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
						table.setModel(dsllk.docTableQLLLK());
						table.setRowHeight(50);
						hanhdong=0;
						setTrangThai("Xem th??ng tin lo???i linh ki???n");
						JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng.");
					}
						
			
				}
				}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "B???n c?? mu???n thay ?????i th??ng tin lo???i linh ki???n n??y kh??ng?","C???nh b??o",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						if (suaLoai()) {
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
							table.setModel(dsllk.docTableQLLLK());
							table.setRowHeight(50);
							hanhdong=0;
							setTrangThai("Xem th??ng tin lo???i linh ki???n");
							JOptionPane.showMessageDialog(null, "Thay ?????i th??nh c??ng.");
						}
						
				}
			}
		
			
		}else
		
		if (o.equals(btnTimKiem)) {
			locTK();
		}
	}
	
	private boolean themLoai() {
		if (ktra()) {
			if (dsllk.themllk(txtTenLoai.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Th??m kh??ng th??nh c??ng.");
		return false;
	}
	private boolean suaLoai() {
		if (ktra()) {
			if (dsllk.suaLoai(txtTenLoai.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText(), txtMaLoai.getText()))
				return true;
		}
		JOptionPane.showMessageDialog(null, "Thay ?????i kh??ng th??nh c??ng.");
		return false;
	}
	
	private boolean ktra() {
		boolean kq=true;
		if (hanhdong==1 || hanhdong==2) {
			txtTenLoai.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa1.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa2.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa3.setBorder(new LineBorder(Color.BLACK, 1));
			txtMoTa4.setBorder(new LineBorder(Color.BLACK, 1));
			txtThongBao.setForeground(Color.BLACK);
			txtThongBao.setText("Nh???p li???u v?? b???m v??o n??t l??u.");
			
			
			
		
			if (txtMoTa4.getText().equals("")) {
				txtThongBao.setText( "L???i nh???p li???u: B???n ch??a nh???p t??n c???a m?? t??? 4 cho lo???i linh ki???n.");
				txtMoTa4.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtMoTa3.getText().equals("")) {
				txtThongBao.setText( "L???i nh???p li???u: B???n ch??a nh???p t??n c???a m?? t??? 3 cho lo???i linh ki???n.");
				txtMoTa3.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtMoTa2.getText().equals("")) {
				txtThongBao.setText( "L???i nh???p li???u: B???n ch??a nh???p t??n c???a m?? t??? 2 cho lo???i linh ki???n.");
				txtMoTa2.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtMoTa1.getText().equals("")) {
				txtThongBao.setText( "L???i nh???p li???u: B???n ch??a nh???p t??n c???a m?? t??? 1 cho lo???i linh ki???n.");
				txtMoTa1.setBorder(new LineBorder(Color.RED, 1));
				kq=false;
			}
			if (txtTenLoai.getText().equals("") || !(txtTenLoai.getText().length()>=1) || !(txtTenLoai.getText().length()<=64)) {
				txtThongBao.setText("L???i nh???p li???u: B???n ch??a nh???p t??n lo???i linh ki???n. (t??? 1 - 64 k?? t???)");
				txtTenLoai.setBorder(new LineBorder(Color.RED, 1));
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
	
		table.setModel(dsllk.locLLK(ten));
		table.setRowHeight(50);
	}

	public void editTextField() {
		txtTenLoai.setEditable(true);
		txtMoTa1.setEditable(true);
		txtMoTa2.setEditable(true);
		txtMoTa3.setEditable(true);
		txtMoTa4.setEditable(true);
	
		
	}
	public void falseEditTextField() {
		txtTenLoai.setEditable(false);
		txtMoTa1.setEditable(false);
		txtMoTa2.setEditable(false);
		txtMoTa3.setEditable(false);
		txtMoTa4.setEditable(false);
		
	}
	public void xoaRongTextField() {
		txtMaLoai.setText("");
		txtTenLoai.setText("");
		txtMoTa1.setText("");
		txtMoTa2.setText("");
		txtMoTa3.setText("");
		txtMoTa4.setText("");
		txtThongBao.setForeground(Color.BLACK);
		txtTenLoai.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa1.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa2.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa3.setBorder(new LineBorder(Color.BLACK, 1));
		txtMoTa4.setBorder(new LineBorder(Color.BLACK, 1));
		
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
