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

/**
 * 
 */
@Entity
@Table(name = "HoaDon")
@NamedQueries({
		@NamedQuery(name = "HoaDon.getHoaDonByPhongIDAndTinhTrang", query = "SELECT hd FROM HoaDon hd WHERE hd.phong.phongID = :phongID AND hd.tinhTrang = :tinhTrang"),
		// Lấy tất cả hóa đơn có mã hóa đơn bắt đầu bằng...
		@NamedQuery(name = "HoaDon.getHoaDonByStartID", query = "SELECT hd FROM HoaDon hd WHERE hd.hoaDonID LIKE :hoaDonID"),
})

		
public class HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4794473952103490764L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String hoaDonID;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "khachHangID")
	private KhachHang khachHang;

	@ManyToOne(cascade = { CascadeType.MERGE , CascadeType.DETACH })
	@JoinColumn(name = "phongID")
	private Phong phong;

	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime gioVao;

	@Column(columnDefinition = "DATETIME")
	private LocalDateTime gioRa;

	@Column(columnDefinition = "DATE")
	private LocalDate ngayLapHoaDon;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;

	@ManyToOne
	@JoinColumn(name = "nhanVienID")
	private NhanVien nhanVien;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "khuyenMaiID")
	private KhuyenMai khuyenMai;

	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;

	public String getHoaDonID() {
		return hoaDonID;
	}

	public void setHoaDonID(String hoaDonID) {
		this.hoaDonID = hoaDonID;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public LocalDateTime getGioVao() {
		return gioVao;
	}

	public void setGioVao(LocalDateTime gioVao) {
		this.gioVao = gioVao;
	}

	public LocalDateTime getGioRa() {
		return gioRa;
	}

	public void setGioRa(LocalDateTime gioRa) {
		this.gioRa = gioRa;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public PhieuDatMon getPhieuDatMon() {
		return phieuDatMon;
	}

	public void setPhieuDatMon(PhieuDatMon phieuDatMon) {
		this.phieuDatMon = phieuDatMon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HoaDon(String hoaDonID, KhachHang khachHang, Phong phong, LocalDateTime gioVao, LocalDate ngayLapHoaDon,
			PhieuDatMon phieuDatMon, NhanVien nhanVien, boolean tinhTrang) {
		super();
		this.hoaDonID = hoaDonID;
		this.khachHang = khachHang;
		this.phong = phong;
		this.gioVao = gioVao;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.phieuDatMon = phieuDatMon;
		this.nhanVien = nhanVien;
		this.tinhTrang = tinhTrang;
	}

	public HoaDon(String hoaDonID, KhachHang khachHang, Phong phong, LocalDateTime gioVao, LocalDateTime gioRa,
			LocalDate ngayLapHoaDon, PhieuDatMon phieuDatMon, NhanVien nhanVien, boolean tinhTrang) {
		super();
		this.hoaDonID = hoaDonID;
		this.khachHang = khachHang;
		this.phong = phong;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.phieuDatMon = phieuDatMon;
		this.nhanVien = nhanVien;
		this.tinhTrang = tinhTrang;
	}
	

	public HoaDon(String hoaDonID, KhachHang khachHang, Phong phong, LocalDateTime gioVao, LocalDateTime gioRa,
			LocalDate ngayLapHoaDon, PhieuDatMon phieuDatMon, NhanVien nhanVien, KhuyenMai khuyenMai,
			boolean tinhTrang) {
		super();
		this.hoaDonID = hoaDonID;
		this.khachHang = khachHang;
		this.phong = phong;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.phieuDatMon = phieuDatMon;
		this.nhanVien = nhanVien;
		this.khuyenMai = khuyenMai;
		this.tinhTrang = tinhTrang;
	}

	public HoaDon() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioRa, gioVao, hoaDonID, khachHang,
				khuyenMai, 
				ngayLapHoaDon, nhanVien, phieuDatMon, phong, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(gioRa, other.gioRa) && Objects.equals(gioVao, other.gioVao)
				&& Objects.equals(hoaDonID, other.hoaDonID) && Objects.equals(khachHang, other.khachHang)
				&& Objects.equals(khuyenMai, other.khuyenMai) 
				&& Objects.equals(ngayLapHoaDon, other.ngayLapHoaDon) && Objects.equals(nhanVien, other.nhanVien)
				&& Objects.equals(phieuDatMon, other.phieuDatMon) && Objects.equals(phong, other.phong)
				&& tinhTrang == other.tinhTrang;
	}

}
