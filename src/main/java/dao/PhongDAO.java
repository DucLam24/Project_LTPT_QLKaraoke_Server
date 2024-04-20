package dao;

import java.util.List;

import entity.Phong;

public interface PhongDAO {
	public List<Phong> getAllPhong();
	public Phong getPhongByID(String phongID);
	public List<Phong> getPhongByTinhTrang(int tinhTrang);
	public boolean updateTinhTrang(Phong phong);
}
