package entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "HoaDon")
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
	
	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate ngay;
	
	@Column(columnDefinition = "TIME", nullable = false)
	private Time gioVao;
	
	@Column(columnDefinition = "TIME", nullable = false)
	private Time gioRa;
	
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
