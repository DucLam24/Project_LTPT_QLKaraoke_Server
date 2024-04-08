package dao;

import java.util.List;

import entity.LoaiMonAn;
import entity.MonAn;

public interface MonAnDAO {
	public List<MonAn> findMonAnByLoai(LoaiMonAn loaiMonAn);
}
