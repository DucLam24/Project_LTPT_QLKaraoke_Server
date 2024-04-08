package dao.impl;

import java.util.List;

import dao.MonAnDAO;
import entity.LoaiMonAn;
import entity.MonAn;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class MonAnImpl implements MonAnDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public MonAnImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<MonAn> findMonAnByLoai(LoaiMonAn loaiMonAn) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("MonAn.findByLoai", MonAn.class).setParameter("loaiMonAn", loaiMonAn).getResultList();
	}
	
}
