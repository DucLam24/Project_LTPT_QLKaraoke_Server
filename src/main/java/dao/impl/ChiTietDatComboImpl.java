package dao.impl;

import java.util.List;

import dao.ChiTietDatComboDAO;
import entity.ChiTietDatCombo;
import jakarta.persistence.EntityManager;
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
	
}
