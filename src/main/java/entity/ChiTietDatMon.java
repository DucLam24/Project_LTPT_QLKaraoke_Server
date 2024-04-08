package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Table(name = "ChiTietDatMon")
@NamedQueries({
		@NamedQuery(name = "ChiTietDatMon.findByPhieuDatMonID", query = "SELECT c FROM ChiTietDatMon c WHERE c.phieuDatMon.phieuDatMonID = :phieuDatMonID"),
		 })
public class ChiTietDatMon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6068599397919228759L;
	@Id
	@ManyToOne
	@JoinColumn(name = "phieuDatMonID")
	private PhieuDatMon phieuDatMon;
	@Id
	@ManyToOne
	@JoinColumn(name = "monAnID")
	private MonAn monAn;
	@Column(columnDefinition = "INT", nullable = false)
	private int soLuong;
}
