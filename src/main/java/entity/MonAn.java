package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "MonAn")
@NamedQueries({ 
		@NamedQuery(name = "MonAn.findAll", query = "SELECT m FROM MonAn m"),
		@NamedQuery(name = "MonAn.findByID", query = "SELECT m FROM MonAn m WHERE m.monAnID = :monAnID") ,
		@NamedQuery(name = "MonAn.findByLoai", query = "SELECT m FROM MonAn m WHERE m.loaiMonAn = :loaiMonAn") 
		})
public class MonAn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String monAnID;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenMonAn;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private LoaiMonAn loaiMonAn;

	@Column(columnDefinition = "MONEY", nullable = false)
	private double donGia;

	@Column(columnDefinition = "INT", nullable = false)
	private int soLuongTon;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String donViTinh;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String hinhAnh;

	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
	
	//Chiều ngược lại
	@OneToMany(mappedBy = "monAn",cascade = CascadeType.MERGE)
	@Transient
	private Set<ChiTietCombo> chiTietCombo;
	
	@OneToMany(mappedBy = "monAn",cascade = CascadeType.MERGE)
	@Transient
	private Set<ChiTietDatMon> chiTietDatMon;

	
	
	
	
	@Override
	public String toString() {
		return "MonAn [monAnID=" + monAnID + ", tenMonAn=" + tenMonAn + ", loaiMonAn=" + loaiMonAn + ", donGia="
				+ donGia + ", soLuongTon=" + soLuongTon + ", donViTinh=" + donViTinh + ", hinhAnh=" + hinhAnh
				+ ", tinhTrang=" + tinhTrang + "]";
	}

	public String getMonAnID() {
		return monAnID;
	}

	public void setMonAnID(String monAnID) {
		this.monAnID = monAnID;
	}

	public String getTenMonAn() {
		return tenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}

	public LoaiMonAn getLoaiMonAn() {
		return loaiMonAn;
	}

	public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
		this.loaiMonAn = loaiMonAn;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public MonAn() {
		super();
	}

	public MonAn(String monAnID, String tenMonAn, LoaiMonAn loaiMonAn, double donGia, int soLuongTon, String donViTinh,
			String hinhAnh, boolean tinhTrang) {
		super();
		this.monAnID = monAnID;
		this.tenMonAn = tenMonAn;
		this.loaiMonAn = loaiMonAn;
		this.donGia = donGia;
		this.soLuongTon = soLuongTon;
		this.donViTinh = donViTinh;
		this.hinhAnh = hinhAnh;
		this.tinhTrang = tinhTrang;
	}
	

	public MonAn(String monAnID, String tenMonAn, LoaiMonAn loaiMonAn, double donGia, int soLuongTon, String donViTinh,
			boolean tinhTrang) {
		super();
		this.monAnID = monAnID;
		this.tenMonAn = tenMonAn;
		this.loaiMonAn = loaiMonAn;
		this.donGia = donGia;
		this.soLuongTon = soLuongTon;
		this.donViTinh = donViTinh;
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, donViTinh, hinhAnh, loaiMonAn, monAnID, soLuongTon, tenMonAn, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonAn other = (MonAn) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(donViTinh, other.donViTinh) && Objects.equals(hinhAnh, other.hinhAnh)
				&& loaiMonAn == other.loaiMonAn && Objects.equals(monAnID, other.monAnID)
				&& soLuongTon == other.soLuongTon && Objects.equals(tenMonAn, other.tenMonAn)
				&& tinhTrang == other.tinhTrang;
	}
	
	
}
