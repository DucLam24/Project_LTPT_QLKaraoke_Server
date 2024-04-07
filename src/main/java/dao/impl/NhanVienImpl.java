package dao.impl;

import dao.NhanVienDAO;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class NhanVienImpl implements NhanVienDAO {
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public NhanVienImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	@Override
	public NhanVien getNhanVienByID(String nhanVienID) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getNhanVienByID", NhanVien.class).setParameter("nhanVienID", nhanVienID)
				.getSingleResult();
	}

}
