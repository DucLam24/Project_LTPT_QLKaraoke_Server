package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TaiKhoan")
@NamedQueries({ 
		@NamedQuery(name = "TaiKhoan.findAll", query = "SELECT tk FROM TaiKhoan tk"),
		@NamedQuery(name = "TaiKhoan.findByNhanVienID", query = "SELECT tk FROM TaiKhoan tk WHERE tk.nhanVien.nhanVienID = :nhanVienID"),
		@NamedQuery(name = "TaiKhoan.findByQuyen", query = "SELECT tk FROM TaiKhoan tk WHERE tk.quyen = :quyen"),
		@NamedQuery(name = "TaiKhoan.findByTinhTrang", query = "SELECT tk FROM TaiKhoan tk WHERE tk.tinhTrang = :tinhTrang") }
		)
public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -878579204864420538L;
	@Id
	@OneToOne
	@JoinColumn(name = "nhanVienID")
	private NhanVien nhanVien;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String matKhau;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private Quyen quyen;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;

	
	
	
	
	@Override
	public String toString() {
		return "TaiKhoan [nhanVien=" + nhanVien + ", matKhau=" + matKhau + ", quyen=" + quyen + ", tinhTrang="
				+ tinhTrang + "]";
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public TaiKhoan(NhanVien nhanVien, String matKhau, Quyen quyen, boolean tinhTrang) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.tinhTrang = tinhTrang;
	}

	public TaiKhoan() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(matKhau, nhanVien, quyen, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TaiKhoan))
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(matKhau, other.matKhau) && Objects.equals(nhanVien, other.nhanVien)
				&& quyen == other.quyen && tinhTrang == other.tinhTrang;
	}
	
	
}
