package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Combo")
public class Combo {
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String comboID;
	@Column(columnDefinition = "NVARCHAR(100)", nullable = false)
	private String tenCombo;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String moTa;
	@Column(columnDefinition = "MONEY", nullable = false)
	private double giaTien;
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuongTon;
	@Column(columnDefinition = "NVARCHAR(100)")
	private String hinhAnh;
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
	
	
	
}
