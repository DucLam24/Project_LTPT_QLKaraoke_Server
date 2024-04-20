package dao;

import java.util.List;

import entity.PhieuDatMon;

public interface PhieuDatMonDAO {
	public PhieuDatMon getByID(String phieuDatMonID);
	
	public List<PhieuDatMon> getPhieuDatMonByStartID(String startID);
	
	public boolean addPhieuDatMon(PhieuDatMon phieuDatMon);
	
	public boolean updatePhieuDatMon(PhieuDatMon phieuDatMon);
	

}
