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
@Table(name = "ChiTietDatCombo")
@NamedQueries({
		@NamedQuery(name = "ChiTietDatCombo.findByPhieuDatMonID", query = "SELECT c FROM ChiTietDatCombo c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID"),
		@NamedQuery(name = "ChiTietDatCombo.updateSoLuong", 
			query = "UPDATE ChiTietDatCombo c SET c.soLuong = :soLuong WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.combo.comboID = :comboID"),
		@NamedQuery(name = "ChiTietDatCombo.deleteByPhieuDatMonIDAndComboID",
			query = "DELETE FROM ChiTietDatCombo c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.combo.comboID = :comboID"),
		//Lấy tất cả các chi tiết đặt combo theo phieuDatMonID và comboID
		@NamedQuery(name = "ChiTietDatCombo.findByPhieuDatMonIDAndComboID",
			query = "SELECT c FROM ChiTietDatCombo c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID AND c.combo.comboID = :comboID"),
})

public class ChiTietDatCombo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4775336976087078609L;
	@Id
	@ManyToOne
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;
	@Id
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "comboID")
	private Combo combo;
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuong;
	
	
	
	public PhieuDatMon getPhieuDatMon() {
		return phieuDatMon;
	}
	public void setPhieuDatMon(PhieuDatMon phieuDatMon) {
		this.phieuDatMon = phieuDatMon;
	}
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
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
	public ChiTietDatCombo() {
		super();
	}
	public ChiTietDatCombo(PhieuDatMon phieuDatMon, Combo combo, int soLuong) {
		super();
		this.phieuDatMon = phieuDatMon;
		this.combo = combo;
		this.soLuong = soLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(combo, phieuDatMon, soLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDatCombo other = (ChiTietDatCombo) obj;
		return Objects.equals(combo, other.combo) && Objects.equals(phieuDatMon, other.phieuDatMon)
				&& soLuong == other.soLuong;
	}
	
	
}
