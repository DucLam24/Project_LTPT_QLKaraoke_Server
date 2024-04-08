package dao;

import java.util.List;

import entity.PhieuDatPhong;

public interface PhieuDatPhongDAO {
	public List<PhieuDatPhong> getPhieuDatPhongByPhongIDAndTinhTrang(String phongID, int tinhTrang);
}
