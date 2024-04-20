package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name="KhuyenMai")
@NamedQueries({
	@NamedQuery(name = "KhuyenMai.getAllKhuyenMai", query = "SELECT km FROM KhuyenMai km"),
	//Lấy khuyến mãi theo tên
	@NamedQuery(name="KhuyenMai.getKhuyenMaiByTen", query = "SELECT km FROM KhuyenMai km WHERE km.tenKhuyenMai = :tenKhuyenMai")
})
public class KhuyenMai implements Serializable{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1982723635143866230L;
	@Id
	@Column(columnDefinition = "NVARCHAR(20)", nullable = false)
	private String khuyenMaiID;
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenKhuyenMai;
	@Column(columnDefinition = "INT", nullable = false)
	private int phanTram;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="NVARCHAR(100)")
	private LoaiKhuyenMai loaiKhuyenMai;
	@Column(columnDefinition = "BIT")
	private boolean tinhTrang;
	
	public KhuyenMai() {
		super();
	}

	public KhuyenMai(String khuyenMaiID, String tenKhuyenMai, int phanTram, LoaiKhuyenMai loaiKhuyenMai,
			boolean tinhTrang) {
		super();
		this.khuyenMaiID = khuyenMaiID;
		this.tenKhuyenMai = tenKhuyenMai;
		this.phanTram = phanTram;
		this.loaiKhuyenMai = loaiKhuyenMai;
		this.tinhTrang = tinhTrang;
	}

	public String getKhuyenMaiID() {
		return khuyenMaiID;
	}

	public void setKhuyenMaiID(String khuyenMaiID) {
		this.khuyenMaiID = khuyenMaiID;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public int getPhanTram() {
		return phanTram;
	}

	public void setPhanTram(int phanTram) {
		this.phanTram = phanTram;
	}

	public LoaiKhuyenMai getLoaiKhuyenMai() {
		return loaiKhuyenMai;
	}

	public void setLoaiKhuyenMai(LoaiKhuyenMai loaiKhuyenMai) {
		this.loaiKhuyenMai = loaiKhuyenMai;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(khuyenMaiID, loaiKhuyenMai, phanTram, tenKhuyenMai, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof KhuyenMai))
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(khuyenMaiID, other.khuyenMaiID) && loaiKhuyenMai == other.loaiKhuyenMai
				&& phanTram == other.phanTram && Objects.equals(tenKhuyenMai, other.tenKhuyenMai)
				&& tinhTrang == other.tinhTrang;
	}

	@Override
	public String toString() {
		return "KhuyenMai [khuyenMaiID=" + khuyenMaiID + ", tenKhuyenMai=" + tenKhuyenMai + ", phanTram=" + phanTram
				+ ", loaiKhuyenMai=" + loaiKhuyenMai + ", tinhTrang=" + tinhTrang + "]";
	}
	
}
