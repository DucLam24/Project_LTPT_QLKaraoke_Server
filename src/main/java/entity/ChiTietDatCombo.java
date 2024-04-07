package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString

@Entity
@Table(name = "ChiTietDatCombo")
public class ChiTietDatCombo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4775336976087078609L;
	@Id
	@ManyToOne
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;
	@Id
	@ManyToOne
	@JoinColumn(name = "comboID")
	private Combo combo;
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuong;
}
