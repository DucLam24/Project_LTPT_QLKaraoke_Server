package dao.impl;

import java.util.List;

import dao.HoaDonDAO;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
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
}
