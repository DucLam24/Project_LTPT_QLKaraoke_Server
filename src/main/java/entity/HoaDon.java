package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "HoaDon")
@NamedQueries({
				@NamedQuery(name = "HoaDon.getHoaDonByPhongIDAndTinhTrang", 
						query = "SELECT hd FROM HoaDon hd WHERE hd.phong.phongID = :phongID AND hd.tinhTrang = :tinhTrang"),
})
public class HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4794473952103490764L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String hoaDonID;
	
	@ManyToOne
	@JoinColumn(name = "khachHangID")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "phongID")
	private Phong phong;
	
	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime gioVao;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime gioRa;
	
	@Column(columnDefinition = "DATE")
	private LocalDate ngayLapHoaDon;
	
	@ManyToOne
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;
	
	@ManyToOne
	@JoinColumn(name = "nhanVienID")
	private NhanVien nhanVien;
	
	@ManyToOne
	@JoinColumn(name = "khuyenMaiID")
	private KhuyenMai khuyenMai;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
}
