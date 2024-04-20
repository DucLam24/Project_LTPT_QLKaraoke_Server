package dao;

import java.util.List;

import entity.KhuyenMai;

public interface KhuyenMaiDAO {
	public List<KhuyenMai> getAllKhuyenMai();
	
	public KhuyenMai getKhuyenMaiByTen(String tenKhuyenMai);
}
