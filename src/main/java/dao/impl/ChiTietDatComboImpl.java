package dao.impl;

import java.util.List;

import dao.ChiTietDatComboDAO;
import entity.ChiTietDatCombo;
import entity.Combo;
import entity.PhieuDatMon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDatComboImpl implements ChiTietDatComboDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public ChiTietDatComboImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<ChiTietDatCombo> getByPhieuDatMonID(String phieuDatMonID) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietDatCombo.findByPhieuDatMonID", ChiTietDatCombo.class)
				.setParameter("phieuDatMonID", phieuDatMonID).getResultList();
	}

	



	@Override
	public boolean deleteChiTietDatComboByPhieuDatMonID(String phieuDatMonID, String comboID) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.createNamedQuery("ChiTietDatCombo.deleteByPhieuDatMonIDAndComboID")
					.setParameter("phieuDatMonID", phieuDatMonID).setParameter("comboID", comboID).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	
	
	@Override
	public boolean addCombo(ChiTietDatCombo chiTietDatCombo) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(chiTietDatCombo);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSoLuong(ChiTietDatCombo chiTietDatCombo) {
		EntityTransaction tx = em.getTransaction();
//		PhieuDatMon phieuDatMon = em.find(PhieuDatMon.class, phieuDatMonID);
//		Combo combo = em.find(Combo.class, comboID);
//		ChiTietDatCombo chiTietDatCombo = new ChiTietDatCombo(phieuDatMon, combo, soLuong);
		try {
			tx.begin();
			em.createNamedQuery("ChiTietDatCombo.updateSoLuong").setParameter("soLuong", chiTietDatCombo.getSoLuong())
					.setParameter("phieuDatMonID", chiTietDatCombo.getPhieuDatMon().getPhieuDatMonID())
					.setParameter("comboID", chiTietDatCombo.getCombo().getComboID()).executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ChiTietDatCombo findByPhieuDatMonIDAndComboID(String phieuDatMonID, String comboID) {
		// TODO Auto-generated method stub
//		return em.createNamedQuery("ChiTietDatCombo.findByPhieuDatMonIDAndComboID", ChiTietDatCombo.class)
//				.setParameter("phieuDatMonID", phieuDatMonID).setParameter("comboID", comboID).getSingleResult();
		
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ChiTietDatCombo chiTietDatCombo = em
					.createNamedQuery("ChiTietDatCombo.findByPhieuDatMonIDAndComboID", ChiTietDatCombo.class)
					.setParameter("phieuDatMonID", phieuDatMonID).setParameter("comboID", comboID).getSingleResult();
			tx.commit();
			return chiTietDatCombo;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;
		
	}

	

	
}
