package dao.impl;

import java.util.List;

import dao.ChiTietDatMonDAO;
import entity.ChiTietDatMon;
import jakarta.persistence.EntityManager;
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
	
}
