package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "KhachHang")
@NamedQueries({
	//Lấy tất cả khách hàng có mã khách hàng bắt đầu bằng...
	@NamedQuery(name = "KhachHang.getKhachHangByStartID", query = "SELECT k FROM KhachHang k WHERE k.khachHangID LIKE :khachHangID"),
})
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4115135444853705240L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)")
	private String khachHangID;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String hoTen;

	@Column(columnDefinition = "BIT")
	private boolean gioiTinh;

	@Column(columnDefinition = "DATE")
	private LocalDate ngaySinh;

	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String soDienThoai;

	@Column(columnDefinition = "VARCHAR(100)")
	private String email;
	
	//Chiều nguoc lai
	@Transient
	@OneToMany(mappedBy = "khachHang", cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private Set<PhieuDatPhong> phieuDatPhong;
	
	@OneToMany(mappedBy = "khachHang")
	@Transient
	private Set<HoaDon> hoaDon;

	public KhachHang(String khachHangID, String hoTen, String soDienThoai) {
		super();
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}

	public KhachHang() {
		super();
	}

	public KhachHang(String khachHangID, String hoTen, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai,
			String email) {
		super();
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getKhachHangID() {
		return khachHangID;
	}

	public void setKhachHangID(String khachHangID) {
		this.khachHangID = khachHangID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, gioiTinh, hoTen, khachHangID, ngaySinh, soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(email, other.email) && gioiTinh == other.gioiTinh && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(khachHangID, other.khachHangID) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(soDienThoai, other.soDienThoai);
	}

}
