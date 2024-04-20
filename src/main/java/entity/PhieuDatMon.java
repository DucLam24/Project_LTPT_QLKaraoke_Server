package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@NamedQueries({ 
		@NamedQuery(name = "PhieuDatMon.findByPhieuDatMonID", query = "SELECT p FROM PhieuDatMon p WHERE p.phieuDatMonID = :phieuDatMonID"),
		// Lấy tất cả phiếu đặt món có mã phiếu đặt món bắt đầu bằng...
		@NamedQuery(name = "PhieuDatMon.getPhieuDatMonByStartID", query = "SELECT p FROM PhieuDatMon p WHERE p.phieuDatMonID LIKE :phieuDatMonID"),
        
		})
public class PhieuDatMon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1482120013574723872L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phieuDatMonID;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "phongID")
	private Phong phong;
	
	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime thoiGianDat;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
	
	//Chiều ngược lại
	@OneToMany(mappedBy = "phieuDatMon")
	@Transient
	private Set<ChiTietDatMon> chiTietDatMon;
	
	@OneToMany(mappedBy = "phieuDatMon")
	@Transient
	private Set<ChiTietDatCombo> chiTietDatCombo;
	
	@OneToOne(mappedBy = "phieuDatMon",cascade = CascadeType.MERGE)
	@Transient
	private HoaDon hoaDon;
	
	
	
	
	public PhieuDatMon() {
		super();
	}
	
	public PhieuDatMon(String phieuDatMonID, Phong phong, LocalDateTime thoiGianDat, boolean tinhTrang) {
		super();
		this.phieuDatMonID = phieuDatMonID;
		this.phong = phong;
		this.thoiGianDat = thoiGianDat;
		this.tinhTrang = tinhTrang;
	}
	
	

	@Override
	public String toString() {
		return "PhieuDatMon [phieuDatMonID=" + phieuDatMonID + ", phong=" + phong + ", thoiGianDat=" + thoiGianDat
				+ ", tinhTrang=" + tinhTrang + "]";
	}

	public String getPhieuDatMonID() {
		return phieuDatMonID;
	}

	public void setPhieuDatMonID(String phieuDatMonID) {
		this.phieuDatMonID = phieuDatMonID;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public LocalDateTime getThoiGianDat() {
		return thoiGianDat;
	}

	public void setThoiGianDat(LocalDateTime thoiGianDat) {
		this.thoiGianDat = thoiGianDat;
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

	@Override
	public int hashCode() {
		return Objects.hash(phieuDatMonID, phong, thoiGianDat, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PhieuDatMon))
			return false;
		PhieuDatMon other = (PhieuDatMon) obj;
		return Objects.equals(phieuDatMonID, other.phieuDatMonID) && Objects.equals(phong, other.phong)
				&& Objects.equals(thoiGianDat, other.thoiGianDat) && tinhTrang == other.tinhTrang;
	}
	
	
}
