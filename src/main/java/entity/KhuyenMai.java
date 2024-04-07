package entity;

import java.io.Serializable;

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
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 220104775439074697L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String khuyenMaiID;
	
	@Column(columnDefinition = "NVARCHAR(50)", nullable = false)
	private String tenKhuyenMai;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String moTa;
	
	@Column(columnDefinition = "MONEY", nullable = false)
	private double giaTri;
	
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String noiApDung;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
}
