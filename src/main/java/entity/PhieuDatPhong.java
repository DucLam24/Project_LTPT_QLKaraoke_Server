package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "PhieuDatPhong")
@NamedQueries({ 
		@NamedQuery(name = "PhieuDatPhong.findByPhongIDAndTinhTrang", 
				query = "SELECT p FROM PhieuDatPhong p WHERE p.phong.phongID = :phongID and p.tinhTrang = :tinhTrang"), 
		// Lấy tất cả phiếu đặt phòng có mã phiếu đặt phòng bắt đầu bằng...
		@NamedQuery(name = "PhieuDatPhong.getPhieuDatPhongByStartID", query = "SELECT p FROM PhieuDatPhong p WHERE p.phieuDatPhongID LIKE :phieuDatPhongID"),
		})
public class PhieuDatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 285156758338642117L;

	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phieuDatPhongID;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//	@Cascade(value = { org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH, org.hibernate.annotations.CascadeType.DETACH })
	@JoinColumn(name = "phongID")
	private Phong phong;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "khachHangID")
	private KhachHang khachHang;

	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate ngayDat;

	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime gioVao;
	
	@Column(columnDefinition = "INT", nullable = false)
	private int tinhTrang;
	
	// chiều ngược lại
	@OneToOne(mappedBy = "phieuDatPhong", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@Transient
	private HoaDon hoaDon;
	
	public PhieuDatPhong() {
		super();
	}
	
	public PhieuDatPhong(String phieuDatPhongID, Phong phong, KhachHang khachHang, LocalDate ngayDat,
			LocalDateTime gioVao, int tinhTrang) {
		super();
		this.phieuDatPhongID = phieuDatPhongID;
		this.phong = phong;
		this.khachHang = khachHang;
		this.ngayDat = ngayDat;
		this.gioVao = gioVao;
		this.tinhTrang = tinhTrang;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "PhieuDatPhong [phieuDatPhongID=" + phieuDatPhongID + ", phong=" + phong + ", khachHang=" + khachHang
				+ ", ngayDat=" + ngayDat + ", gioVao=" + gioVao + ", tinhTrang=" + tinhTrang + "]";
	}

	public String getPhieuDatPhongID() {
		return phieuDatPhongID;
	}

	public void setPhieuDatPhongID(String phieuDatPhongID) {
		this.phieuDatPhongID = phieuDatPhongID;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public LocalDate getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}

	public LocalDateTime getGioVao() {
		return gioVao;
	}

	public void setGioVao(LocalDateTime gioVao) {
		this.gioVao = gioVao;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioVao, khachHang, ngayDat, phieuDatPhongID, phong, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PhieuDatPhong))
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(gioVao, other.gioVao) && Objects.equals(khachHang, other.khachHang)
				&& Objects.equals(ngayDat, other.ngayDat) && Objects.equals(phieuDatPhongID, other.phieuDatPhongID)
				&& Objects.equals(phong, other.phong) && tinhTrang == other.tinhTrang;
	}
	
	
}
