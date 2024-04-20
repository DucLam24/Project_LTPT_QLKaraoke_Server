package dao.impl;

import java.util.List;

import dao.PhieuDatMonDAO;
import entity.PhieuDatMon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhieuDatMonImpl implements PhieuDatMonDAO {
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public PhieuDatMonImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public PhieuDatMon getByID(String phieuDatMonID) {
		// TODO Auto-generated method stub
		return em.find(PhieuDatMon.class, phieuDatMonID);
	}

	@Override
	public List<PhieuDatMon> getPhieuDatMonByStartID(String startID) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<PhieuDatMon> list = em.createNamedQuery("PhieuDatMon.getPhieuDatMonByStartID", PhieuDatMon.class)
					.setParameter("phieuDatMonID", startID + "%").getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
			return null;
		} 
	}

	@Override
	public boolean addPhieuDatMon(PhieuDatMon phieuDatMon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phieuDatMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean updatePhieuDatMon(PhieuDatMon phieuDatMon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(phieuDatMon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	
}
