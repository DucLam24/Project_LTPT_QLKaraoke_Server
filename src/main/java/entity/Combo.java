package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
