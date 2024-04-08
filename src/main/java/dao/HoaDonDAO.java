package dao;

import java.util.List;

import entity.HoaDon;

public interface HoaDonDAO {
	public List<HoaDon> getHoaDonByPhongIDAndTinhTrang(String phongID, boolean tinhTrang);
}
