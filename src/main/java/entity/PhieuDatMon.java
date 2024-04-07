package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString

public class PhieuDatMon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1482120013574723872L;
	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phieuDatMonID;
	
	@ManyToOne
	@JoinColumn(name = "phongID")
	private Phong phong;
	
	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime thoiGianDat;
	
	@Column(columnDefinition = "BIT", nullable = false)
	private boolean tinhTrang;
}
