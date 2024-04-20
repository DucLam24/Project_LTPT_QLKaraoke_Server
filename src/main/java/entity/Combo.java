package entity;

import java.io.Serializable;
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
@Table(name = "Combo")
@NamedQueries({
		@NamedQuery(name = "Combo.findAll", query = "SELECT c FROM Combo c"),
		@NamedQuery(name = "Combo.findByID", query = "SELECT c FROM Combo c WHERE c.comboID = :comboID") })
public class Combo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8813396632475370467L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String comboID;
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenCombo;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String moTa;
	@Column(columnDefinition = "MONEY", nullable = false)
	private double giaTien;
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuongTon;
	@Column(columnDefinition = "VARCHAR(100)")
	private String hinhAnh;
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
	
	//Chiều ngược lại
	@OneToMany(mappedBy = "combo")
	@Transient
	private Set<ChiTietCombo> chiTietCombo;
	
	@OneToMany(mappedBy = "combo",cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	@Transient
	private Set<ChiTietDatCombo> chiTietDatCombo;
	
	
	public Combo(String comboID, String tenCombo, String moTa, double giaTien, int soLuongTon, boolean tinhTrang) {
		super();
		this.comboID = comboID;
		this.tenCombo = tenCombo;
		this.moTa = moTa;
		this.giaTien = giaTien;
		this.soLuongTon = soLuongTon;
		this.tinhTrang = tinhTrang;
	}


	public Combo() {
		super();
	}
	
	
	public Combo(String comboID, String tenCombo, String moTa, double giaTien, int soLuongTon, String hinhAnh,
			boolean tinhTrang) {
		super();
		this.comboID = comboID;
		this.tenCombo = tenCombo;
		this.moTa = moTa;
		this.giaTien = giaTien;
		this.soLuongTon = soLuongTon;
		this.hinhAnh = hinhAnh;
		this.tinhTrang = tinhTrang;
	}


	@Override
	public String toString() {
		return "Combo [comboID=" + comboID + ", tenCombo=" + tenCombo + ", moTa=" + moTa + ", giaTien=" + giaTien
				+ ", soLuongTon=" + soLuongTon + ", hinhAnh=" + hinhAnh + ", tinhTrang=" + tinhTrang + "]";
	}


	public String getComboID() {
		return comboID;
	}


	public void setComboID(String comboID) {
		this.comboID = comboID;
	}


	public String getTenCombo() {
		return tenCombo;
	}


	public void setTenCombo(String tenCombo) {
		this.tenCombo = tenCombo;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public double getGiaTien() {
		return giaTien;
	}


	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}


	public int getSoLuongTon() {
		return soLuongTon;
	}


	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public boolean isTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	@Override
	public int hashCode() {
		return Objects.hash(comboID, giaTien, hinhAnh, moTa, soLuongTon, tenCombo, tinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combo other = (Combo) obj;
		return Objects.equals(comboID, other.comboID)
				&& Double.doubleToLongBits(giaTien) == Double.doubleToLongBits(other.giaTien)
				&& Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(moTa, other.moTa)
				&& soLuongTon == other.soLuongTon && Objects.equals(tenCombo, other.tenCombo)
				&& tinhTrang == other.tinhTrang;
	}
	
	
	
}
