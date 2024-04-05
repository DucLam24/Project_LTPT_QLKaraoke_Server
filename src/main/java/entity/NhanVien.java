package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "NhanVien")

public class NhanVien {
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
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String viTri;
	@Column(columnDefinition = "BIT")
	private boolean tinhTrang;
}
