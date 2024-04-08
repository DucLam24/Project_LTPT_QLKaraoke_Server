package dao.impl;

import java.util.List;

import dao.ComboDAO;
import entity.Combo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ComboImpl implements ComboDAO{
	private static final String PERSISTENCE_UNIT_NAME = "QuanLyKaraoke_MSSQL";
	private EntityManager em;
	
	public ComboImpl() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}
	@Override
	public List<Combo> getAllCombo() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Combo.findAll", Combo.class).getResultList();
	}

}
