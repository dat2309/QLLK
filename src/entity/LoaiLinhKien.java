package entity;

public class LoaiLinhKien {
	private String maLoai;
	private String tenLoai;
	private String moTa1;
	private String moTa2;
	private String moTa3;
	private String moTa4;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getMoTa1() {
		return moTa1;
	}
	public void setMoTa1(String moTa1) {
		this.moTa1 = moTa1;
	}
	public String getMoTa2() {
		return moTa2;
	}
	public void setMoTa2(String moTa2) {
		this.moTa2 = moTa2;
	}
	public String getMoTa3() {
		return moTa3;
	}
	public void setMoTa3(String moTa3) {
		this.moTa3 = moTa3;
	}
	public String getMoTa4() {
		return moTa4;
	}
	public void setMoTa4(String moTa4) {
		this.moTa4 = moTa4;
	}
	public LoaiLinhKien(String maLoai, String tenLoai, String moTa1, String moTa2, String moTa3, String moTa4) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa1 = moTa1;
		this.moTa2 = moTa2;
		this.moTa3 = moTa3;
		this.moTa4 = moTa4;
	}
	public LoaiLinhKien() {
	
	}
	@Override
	public String toString() {
		return "LoaiLinhKien [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", moTa1=" + moTa1 + ", moTa2=" + moTa2
				+ ", moTa3=" + moTa3 + ", moTa4=" + moTa4 + "]";
	}

}
