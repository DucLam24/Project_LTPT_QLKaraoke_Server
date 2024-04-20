package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ChiTietCombo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 763132077231141697L;
	@Id
	@ManyToOne()
	@JoinColumn(name = "comboID")
	private Combo combo;
	@Id
	@ManyToOne()
	@JoinColumn(name = "monAnID")
    private MonAn monAn;
	@Column(columnDefinition = "INT", nullable = false)
    private int soLuong;
	
	
	
	
	
	@Override
	public String toString() {
		return "ChiTietCombo [combo=" + combo + ", monAn=" + monAn + ", soLuong=" + soLuong + "]";
	}
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
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
	public ChiTietCombo(Combo combo, MonAn monAn, int soLuong) {
		super();
		this.combo = combo;
		this.monAn = monAn;
		this.soLuong = soLuong;
	}
	public ChiTietCombo() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(combo, monAn, soLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietCombo other = (ChiTietCombo) obj;
		return Objects.equals(combo, other.combo) && Objects.equals(monAn, other.monAn) && soLuong == other.soLuong;
	}
	
	
}
