package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "MonAn")
@NamedQueries({ 
		@NamedQuery(name = "MonAn.findAll", query = "SELECT m FROM MonAn m"),
		@NamedQuery(name = "MonAn.findByID", query = "SELECT m FROM MonAn m WHERE m.monAnID = :monAnID") ,
		@NamedQuery(name = "MonAn.findByLoai", query = "SELECT m FROM MonAn m WHERE m.loaiMonAn = :loaiMonAn") 
		})
public class MonAn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String monAnID;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenMonAn;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private LoaiMonAn loaiMonAn;

	@Column(columnDefinition = "MONEY", nullable = false)
	private double donGia;

	@Column(columnDefinition = "INT", nullable = false)
	private int soLuongTon;

	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String donViTinh;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String hinhAnh;

	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;

	@Override
	public int hashCode() {
		return Objects.hash(donGia, donViTinh, hinhAnh, loaiMonAn, monAnID, soLuongTon, tenMonAn, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonAn other = (MonAn) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(donViTinh, other.donViTinh) && Objects.equals(hinhAnh, other.hinhAnh)
				&& loaiMonAn == other.loaiMonAn && Objects.equals(monAnID, other.monAnID)
				&& soLuongTon == other.soLuongTon && Objects.equals(tenMonAn, other.tenMonAn)
				&& tinhTrang == other.tinhTrang;
	}
	
	
}
