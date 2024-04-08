package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@Entity
@Table(name = "PhieuDatPhong")
@NamedQueries({ 
		@NamedQuery(name = "PhieuDatPhong.findByPhongIDAndTinhTrang", 
				query = "SELECT p FROM PhieuDatPhong p WHERE p.phong.phongID = :phongID and p.tinhTrang = :tinhTrang"), 
		})
public class PhieuDatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 285156758338642117L;

	@Id
	@Column(columnDefinition = "VARCHAR(20)", nullable = false)
	private String phieuDatPhongID;

	@ManyToOne
	@JoinColumn(name = "phongID")
	private Phong phong;

	@ManyToOne
	@JoinColumn(name = "khachHangID")
	private KhachHang khachHang;

	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate ngayDat;

	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime gioVao;
	
	@Column(columnDefinition = "INT", nullable = false)
	private int tinhTrang;
}
