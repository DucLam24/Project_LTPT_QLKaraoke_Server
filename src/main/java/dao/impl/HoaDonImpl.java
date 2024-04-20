package dao.impl;

import java.util.List;

import dao.HoaDonDAO;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDonImpl implements HoaDonDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public HoaDonImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public List<HoaDon> getHoaDonByPhongIDAndTinhTrang(String phongID, boolean tinhTrang) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("HoaDon.getHoaDonByPhongIDAndTinhTrang", HoaDon.class)
                .setParameter("phongID", phongID)
                .setParameter("tinhTrang", tinhTrang)
                .getResultList();
	}

	@Override
	public boolean addHoaDon(HoaDon hoaDon) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(hoaDon);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<HoaDon> getHoaDonByStartID(String startID) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			List<HoaDon> list = em.createNamedQuery("HoaDon.getHoaDonByStartID", HoaDon.class)
					.setParameter("hoaDonID", startID + "%").getResultList();
			System.out.println(list);
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
	}

	@Override
	public boolean updateHoaDon(HoaDon hoaDon) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}
	}
	
}
