package dao;

import java.util.List;

import entity.PhieuDatPhong;

public interface PhieuDatPhongDAO {
	public List<PhieuDatPhong> getPhieuDatPhongByPhongIDAndTinhTrang(String phongID, int tinhTrang);
	
	public List<PhieuDatPhong> getPhieuDatPhongByStartID(String startID);
	
	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong);
	
	public boolean updatePhieuDatPhong(PhieuDatPhong phieuDatPhong);
	
}
