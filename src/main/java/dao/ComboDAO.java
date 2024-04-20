package dao;

import java.util.List;

import entity.Combo;

public interface ComboDAO {
	public List<Combo> getAllCombo();
	public Combo getComboByID(String comboID);
	public boolean updateCombo(Combo combo);
}
