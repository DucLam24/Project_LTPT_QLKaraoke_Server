package dao;

import java.util.List;

import entity.ChiTietDatCombo;

public interface ChiTietDatComboDAO {
	public List<ChiTietDatCombo> getByPhieuDatMonID(String phieuDatMonID);
}
