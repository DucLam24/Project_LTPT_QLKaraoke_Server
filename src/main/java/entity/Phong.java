package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Phong")
@NamedQueries({ @NamedQuery(name = "Phong.getAllPhong", query = "SELECT p FROM Phong p"),
		@NamedQuery(name = "Phong.getPhongByID", query = "SELECT p FROM Phong p WHERE p.phongID = :phongID"),
		@NamedQuery(name = "Phong.getPhongByLoaiPhong", query = "SELECT p FROM Phong p WHERE p.loaiPhong = :loaiPhong"),
		@NamedQuery(name = "Phong.getPhongByTinhTrang", query = "SELECT p FROM Phong p WHERE p.tinhTrang = :tinhTrang"), 
		@NamedQuery(name = "Phong.updateTinhTrang", query = "UPDATE Phong p SET p.tinhTrang = :tinhTrang WHERE p.phongID = :phongID")
})
public class Phong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8563599570419612890L;

	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phongID;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenPhong;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private LoaiPhong loaiPhong;

	@Column(columnDefinition = "INT")
	private int soNguoi;

	@Column(columnDefinition = "MONEY", nullable = false)
	private double giaTien;

	@Column(columnDefinition = "INT", nullable = false)
	private int tinhTrang;
	
	

	// Chiều ngược lại

	@OneToMany(mappedBy = "phong", cascade = { CascadeType.REMOVE , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch = jakarta.persistence.FetchType.LAZY)
//	@Cascade(value = { org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH, org.hibernate.annotations.CascadeType.DETACH })
	@Transient
	private Set<PhieuDatPhong> phieuDatPhong;
	
	@OneToMany(mappedBy = "phong", cascade = { CascadeType.REMOVE , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch = jakarta.persistence.FetchType.LAZY)
	@Transient
	private Set<HoaDon> hoaDon;
	
	
	

	public String getPhongID() {
		return phongID;
	}

	public void setPhongID(String phongID) {
		this.phongID = phongID;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Phong() {
		super();
	}

	public Phong(String phongID, String tenPhong, LoaiPhong loaiPhong, int soNguoi, double giaTien, int tinhTrang) {
		super();
		this.phongID = phongID;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.soNguoi = soNguoi;
		this.giaTien = giaTien;
		this.tinhTrang = tinhTrang;
	}
	

	@Override
	public String toString() {
		return "Phong [phongID=" + phongID + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", soNguoi="
				+ soNguoi + ", giaTien=" + giaTien + ", tinhTrang=" + tinhTrang + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaTien, loaiPhong, phongID, soNguoi, tenPhong, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Phong))
			return false;
		Phong other = (Phong) obj;
		return giaTien == other.giaTien && loaiPhong == other.loaiPhong && Objects.equals(phongID, other.phongID)
				&& soNguoi == other.soNguoi && Objects.equals(tenPhong, other.tenPhong) && tinhTrang == other.tinhTrang;
	}

}
