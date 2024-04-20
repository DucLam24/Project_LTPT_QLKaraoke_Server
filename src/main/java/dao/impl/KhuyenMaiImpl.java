package dao.impl;

import java.util.List;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhuyenMaiImpl implements KhuyenMaiDAO {
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;

	public KhuyenMaiImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<KhuyenMai> getAllKhuyenMai() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("KhuyenMai.getAllKhuyenMai", KhuyenMai.class).getResultList();
	}

	@Override
	public KhuyenMai getKhuyenMaiByTen(String tenKhuyenMai) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			KhuyenMai km = em.createNamedQuery("KhuyenMai.getKhuyenMaiByTen", KhuyenMai.class)
					.setParameter("tenKhuyenMai", tenKhuyenMai).getSingleResult();
			tr.commit();
			return km;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
}
