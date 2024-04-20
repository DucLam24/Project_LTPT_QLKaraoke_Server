package dao;

import java.util.List;

import entity.KhachHang;

public interface KhachHangDAO {
	public List<KhachHang> getKhachHangByStartID(String startID);
	
	public KhachHang getKhachHangBySDT(String soDienThoai);
	
	public boolean addKhachHang(KhachHang khachHang);
	
	public boolean updateKhachHang(KhachHang khachHang);
}
