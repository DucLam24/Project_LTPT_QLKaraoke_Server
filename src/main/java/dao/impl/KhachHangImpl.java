package dao.impl;

import java.util.List;

import dao.KhachHangDAO;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class KhachHangImpl implements KhachHangDAO {
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;

	public KhachHangImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<KhachHang> getKhachHangByStartID(String startID) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<KhachHang> list = em.createNamedQuery("KhachHang.getKhachHangByStartID", KhachHang.class)
					.setParameter("khachHangID", startID + "%").getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
		
//		// TODO Auto-generated method stub
//		return em.createNamedQuery("KhachHang.getKhachHangByStartID", KhachHang.class)
//				.setParameter("khachHangID", startID + "%").getResultList();
	}

	@Override
	public KhachHang getKhachHangBySDT(String soDienThoai) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			KhachHang kh = em
					.createQuery("SELECT k FROM KhachHang k WHERE k.soDienThoai = :soDienThoai", KhachHang.class)
					.setParameter("soDienThoai", soDienThoai).getSingleResult();
			tr.commit();
			return kh;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
	}

	@Override
	public boolean addKhachHang(KhachHang khachHang) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	@Override
	public boolean updateKhachHang(KhachHang khachHang) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

}
