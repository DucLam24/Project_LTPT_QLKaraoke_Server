package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries({ 
		@NamedQuery(name = "TaiKhoan.findAll", query = "SELECT tk FROM TaiKhoan tk"),
		@NamedQuery(name = "TaiKhoan.findByNhanVienID", query = "SELECT tk FROM TaiKhoan tk WHERE tk.nhanVien.nhanVienID = :nhanVienID"),
		@NamedQuery(name = "TaiKhoan.findByQuyen", query = "SELECT tk FROM TaiKhoan tk WHERE tk.quyen = :quyen"),
		@NamedQuery(name = "TaiKhoan.findByTinhTrang", query = "SELECT tk FROM TaiKhoan tk WHERE tk.tinhTrang = :tinhTrang") }
		)
public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -878579204864420538L;
	@Id
	@OneToOne
	@JoinColumn(name = "nhanVienID")
	private NhanVien nhanVien;
	
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String matKhau;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private Quyen quyen;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
}
