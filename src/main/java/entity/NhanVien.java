package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "NhanVien")
@NamedQueries({ 
		@NamedQuery(name = "getAllNhanVien", query = "SELECT nv FROM NhanVien nv"),
		@NamedQuery(name = "getNhanVienByID", query = "SELECT nv FROM NhanVien nv WHERE nv.nhanVienID = :nhanVienID") 
		})
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String nhanVienID;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String hoTen;
	
	@Column(columnDefinition = "BIT")
	private boolean gioiTinh;
	
	@Column(columnDefinition = "DATE")
	private LocalDate ngaySinh;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String soDienThoai;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String viTri;
	
	@Column(columnDefinition = "BIT")
	private boolean tinhTrang;
	//Chiều ngược lại
	@OneToOne(mappedBy = "nhanVien")
	@Transient
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "nhanVien")
	@Transient
	private Set<HoaDon> hoaDon;
	
	
	public NhanVien() {
		super();
	}
	
	public NhanVien(String nhanVienID, String hoTen, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai,
			String viTri, boolean tinhTrang) {
		super();
		this.nhanVienID = nhanVienID;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.viTri = viTri;
		this.tinhTrang = tinhTrang;
	}
	
	

	@Override
	public String toString() {
		return "NhanVien [nhanVienID=" + nhanVienID + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", soDienThoai=" + soDienThoai + ", viTri=" + viTri + ", tinhTrang=" + tinhTrang + "]";
	}

	public String getNhanVienID() {
		return nhanVienID;
	}

	public void setNhanVienID(String nhanVienID) {
		this.nhanVienID = nhanVienID;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, hoTen, ngaySinh, nhanVienID, soDienThoai, tinhTrang, viTri);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return gioiTinh == other.gioiTinh && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(nhanVienID, other.nhanVienID)
				&& Objects.equals(soDienThoai, other.soDienThoai) && tinhTrang == other.tinhTrang
				&& Objects.equals(viTri, other.viTri);
	}
	
	
}
