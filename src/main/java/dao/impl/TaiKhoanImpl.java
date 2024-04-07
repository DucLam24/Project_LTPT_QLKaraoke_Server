package dao.impl;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TaiKhoanImpl implements TaiKhoanDAO {
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public TaiKhoanImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	@Override
	public TaiKhoan findTaiKhoanByID(String username) {
		return em.find(TaiKhoan.class, username);
	}
	
}
