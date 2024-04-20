package dao.impl;

import java.util.List;

import dao.PhieuDatPhongDAO;
import entity.PhieuDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatPhongImpl implements PhieuDatPhongDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public PhieuDatPhongImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByPhongIDAndTinhTrang(String phongID, int tinhTrang) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("PhieuDatPhong.findByPhongIDAndTinhTrang", PhieuDatPhong.class)
				.setParameter("phongID", phongID)
				.setParameter("tinhTrang", tinhTrang)
				.getResultList();
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByStartID(String startID) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("PhieuDatPhong.getPhieuDatPhongByStartID", PhieuDatPhong.class)
				.setParameter("phieuDatPhongID", startID + "%").getResultList();
	}

	@Override
	public boolean addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phieuDatPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(phieuDatPhong);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}

}
