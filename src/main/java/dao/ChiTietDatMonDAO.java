package dao;

import java.util.List;

import entity.ChiTietDatMon;

public interface ChiTietDatMonDAO {
	public List<ChiTietDatMon> getByPhieuDatMonID(String phieuDatMonID);
}
