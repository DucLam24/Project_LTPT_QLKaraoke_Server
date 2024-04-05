package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "Phong")
public class Phong {
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phongID;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenPhong;
	
    @Enumerated(EnumType.STRING)
	private LoaiPhong loaiPhong;
    
    @Column(columnDefinition = "INT")
	private int soNguoi;
    
    @Column(columnDefinition = "MONEY",nullable = false)
	private int giaTien;
    
    @Column(columnDefinition = "INT", nullable = false)
	private int tinhTrang;
}
