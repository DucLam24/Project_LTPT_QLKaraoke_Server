package dao;

import java.util.List;

import entity.LoaiMonAn;
import entity.MonAn;

public interface MonAnDAO {
	public List<MonAn> findMonAnByLoai(LoaiMonAn loaiMonAn);
	
	public MonAn getMonAnByID(String monAnID);
	
	public boolean updateMonAn(MonAn monAn);
}
