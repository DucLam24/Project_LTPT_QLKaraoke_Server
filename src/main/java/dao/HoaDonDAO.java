package dao;

import java.util.List;

import entity.HoaDon;

public interface HoaDonDAO {
	public List<HoaDon> getHoaDonByPhongIDAndTinhTrang(String phongID, boolean tinhTrang);
	
	public boolean addHoaDon(HoaDon hoaDon);
	
	public List<HoaDon> getHoaDonByStartID(String startID);
	
	public boolean updateHoaDon(HoaDon hoaDon);
}
