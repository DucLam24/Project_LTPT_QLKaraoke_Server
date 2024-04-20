package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietDatMon")
@NamedQueries({
		@NamedQuery(name = "ChiTietDatMon.findByPhieuDatMonID", query = "SELECT c FROM ChiTietDatMon c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID"),
		@NamedQuery(name = "ChiTietDatMon.updateSoLuong", query = "UPDATE ChiTietDatMon c SET c.soLuong = :soLuong WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.monAn.monAnID = :monAnID"),
		@NamedQuery(name = "ChiTietDatMon.deleteByPhieuDatMonIDAndMonAnID", query = "DELETE FROM ChiTietDatMon c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.monAn.monAnID = :monAnID"), 
		// Lấy tất cả các chi tiết đặt món theo phieuDatMonID và monAnID
        @NamedQuery(name = "ChiTietDatMon.findByPhieuDatMonIDAndMonAnID", query = "SELECT c FROM ChiTietDatMon c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.monAn.monAnID = :monAnID"), })
public class ChiTietDatMon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6068599397919228759L;
	@Id
	@ManyToOne
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;
	@Id
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "monAnID")
	private MonAn monAn;
	
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuong;

	public ChiTietDatMon(PhieuDatMon phieuDatMon, MonAn monAn, int soLuong) {
		super();
		this.phieuDatMon = phieuDatMon;
		this.monAn = monAn;
		this.soLuong = soLuong;
	}

	public MonAn getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn monAn) {
		this.monAn = monAn;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPhieuDatMon(PhieuDatMon phieuDatMon) {
		this.phieuDatMon = phieuDatMon;
	}

	public ChiTietDatMon() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(monAn, phieuDatMon, soLuong);
	}

	public PhieuDatMon getPhieuDatMon() {
		return phieuDatMon;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDatMon other = (ChiTietDatMon) obj;
		return Objects.equals(monAn, other.monAn) && Objects.equals(phieuDatMon, other.phieuDatMon)
				&& soLuong == other.soLuong;
	}

}
