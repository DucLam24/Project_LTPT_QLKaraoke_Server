package dao.impl;

import java.util.List;

import dao.PhongDAO;
import entity.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PhongImpl implements PhongDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public PhongImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	
	@Override
	public List<Phong> getAllPhong() {
		return em.createNamedQuery("getAllPhong", Phong.class).getResultList();
	}

	@Override
	public Phong getPhongByID(String phongID) {
		return em.createNamedQuery("getPhongByID", Phong.class)
				.setParameter("phongID", phongID)
				.getSingleResult();
	}

	@Override
	public List<Phong> getPhongByTinhTrang(int tinhTrang) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getPhongByTinhTrang", Phong.class)
				.setParameter("tinhTrang", tinhTrang)
				.getResultList();
	}

}
