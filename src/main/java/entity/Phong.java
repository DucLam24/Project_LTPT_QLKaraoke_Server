package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Phong")
@NamedQueries({
		@NamedQuery(name = "getAllPhong", query = "SELECT p FROM Phong p"),
		@NamedQuery(name = "getPhongByID", query = "SELECT p FROM Phong p WHERE p.phongID = :phongID") ,
		@NamedQuery(name = "getPhongByLoaiPhong", query = "SELECT p FROM Phong p WHERE p.loaiPhong = :loaiPhong"),
		@NamedQuery(name = "getPhongByTinhTrang", query = "SELECT p FROM Phong p WHERE p.tinhTrang = :tinhTrang")
		})
public class Phong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8563599570419612890L;

	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phongID;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenPhong;
	
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private LoaiPhong loaiPhong;
    
    @Column(columnDefinition = "INT")
	private int soNguoi;
    
    @Column(columnDefinition = "MONEY",nullable = false)
	private int giaTien;
    
    @Column(columnDefinition = "INT", nullable = false)
	private int tinhTrang;
}
