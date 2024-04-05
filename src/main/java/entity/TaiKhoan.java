package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "TaiKhoan")
public class TaiKhoan {
	@Id
	@OneToOne
	@JoinColumn(name = "nhanVienID")
	private NhanVien nhanVien;
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String matKhau;
	@Enumerated(EnumType.STRING)
	private Quyen quyen;
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
}
