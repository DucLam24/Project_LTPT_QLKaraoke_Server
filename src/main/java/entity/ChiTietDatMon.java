package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Table(name = "ChiTietDatMon")
public class ChiTietDatMon {
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
