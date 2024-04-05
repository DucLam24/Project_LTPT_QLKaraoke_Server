package entity;

import java.sql.Time;
import java.time.LocalDate;

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
@Table(name = "PhieuDatPhong")
public class PhieuDatPhong {
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
	@Column(columnDefinition = "TIME", nullable = false)
	private Time gioVao;
}
