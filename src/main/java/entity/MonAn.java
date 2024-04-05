package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "MonAn")
public class MonAn {
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String monAnID;
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenMonAn;
	@Enumerated(EnumType.STRING)
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
}
