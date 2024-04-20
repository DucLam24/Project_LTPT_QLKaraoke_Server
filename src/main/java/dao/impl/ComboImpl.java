package dao.impl;

import java.util.List;

import dao.ComboDAO;
import entity.Combo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
	@Override
	public Combo getComboByID(String comboID) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Combo combo = em.find(Combo.class, comboID);
			tr.commit();
			return combo;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
	}
	@Override
	public boolean updateCombo(Combo combo) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(combo);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

}
