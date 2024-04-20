package dao.impl;

import java.util.List;

import dao.ChiTietDatMonDAO;
import entity.ChiTietDatMon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDatMonImpl implements ChiTietDatMonDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public ChiTietDatMonImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<ChiTietDatMon> getByPhieuDatMonID(String phieuDatMonID) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietDatMon.findByPhieuDatMonID", ChiTietDatMon.class)
				.setParameter("phieuDatMonID", phieuDatMonID).getResultList();
	}

	

	@Override
	public boolean addMonAn(ChiTietDatMon chiTietDatMon) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(chiTietDatMon);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteChiTietDatMonAnByPhieuDatMonID(String phieuDatMonID, String monAnID) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createNamedQuery("ChiTietDatMon.deleteByPhieuDatMonIDAndMonAnID")
					.setParameter("phieuDatMonID", phieuDatMonID).setParameter("monAnID", monAnID).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSoLuong(ChiTietDatMon chiTietDatMon) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(chiTietDatMon);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ChiTietDatMon findByPhieuDatMonIDAndMonAnID(String phieuDatMonID, String monAnID) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ChiTietDatMon chiTietDatMon = em
					.createNamedQuery("ChiTietDatMon.findByPhieuDatMonIDAndMonAnID", ChiTietDatMon.class)
					.setParameter("phieuDatMonID", phieuDatMonID).setParameter("monAnID", monAnID).getSingleResult();
			tx.commit();
			return chiTietDatMon;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	
}
