package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "KhachHang")
public class KhachHang {
	@Id
	@Column(columnDefinition = "VARCHAR(20)")
	private String khachHangID;
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String hoTen;
	@Column(columnDefinition = "BIT")
	private boolean gioiTinh;
	@Column(columnDefinition = "DATE")
	private String ngaySinh;
	@Column(columnDefinition = "VARCHAR(10)")
	private String soDienThoai;
	@Column(columnDefinition = "VARCHAR(100)", nullable = false)
	private String email;
	
	public KhachHang(String khachHangID, String hoTen, String soDienThoai) {
		super();
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}
	
}