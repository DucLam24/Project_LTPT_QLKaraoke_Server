package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "NhanVien")
@NamedQueries({ 
		@NamedQuery(name = "getAllNhanVien", query = "SELECT nv FROM NhanVien nv"),
		@NamedQuery(name = "getNhanVienByID", query = "SELECT nv FROM NhanVien nv WHERE nv.nhanVienID = :nhanVienID") 
		})
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String nhanVienID;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String hoTen;
	
	@Column(columnDefinition = "BIT")
	private boolean gioiTinh;
	
	@Column(columnDefinition = "DATE")
	private LocalDate ngaySinh;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
	private String soDienThoai;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String viTri;
	
	@Column(columnDefinition = "BIT")
	private boolean tinhTrang;
}
