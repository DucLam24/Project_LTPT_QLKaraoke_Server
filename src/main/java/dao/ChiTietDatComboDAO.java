package dao;

import java.util.List;

import entity.ChiTietDatCombo;

public interface ChiTietDatComboDAO {
	public List<ChiTietDatCombo> getByPhieuDatMonID(String phieuDatMonID);
	public boolean updateSoLuong(ChiTietDatCombo chiTietDatCombo);
	public boolean addCombo(ChiTietDatCombo chiTietDatCombo);
	public boolean deleteChiTietDatComboByPhieuDatMonID(String phieuDatMonID, String comboID);
	public ChiTietDatCombo findByPhieuDatMonIDAndComboID(String phieuDatMonID, String comboID);
}
