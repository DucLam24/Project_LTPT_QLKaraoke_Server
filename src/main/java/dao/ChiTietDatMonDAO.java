package dao;

import java.util.List;

import entity.ChiTietDatMon;

public interface ChiTietDatMonDAO {
	public List<ChiTietDatMon> getByPhieuDatMonID(String phieuDatMonID);
	public boolean updateSoLuong(ChiTietDatMon chiTietDatMon);
	public boolean addMonAn(ChiTietDatMon chiTietDatMon);
	public boolean deleteChiTietDatMonAnByPhieuDatMonID(String phieuDatMonID, String monAnID);
	public ChiTietDatMon findByPhieuDatMonIDAndMonAnID(String phieuDatMonID, String monAnID);
}
