package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ChiTietCombo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 763132077231141697L;
	@Id
	@ManyToOne
	@JoinColumn(name = "comboID")
	private Combo combo;
	@Id
	@ManyToOne
	@JoinColumn(name = "monAnID")
    private MonAn monAn;
	@Column(columnDefinition = "INT", nullable = false)
    private int soLuong;
}
