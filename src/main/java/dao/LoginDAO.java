package dao;

import entity.Quyen;

public interface LoginDAO {
	public Quyen login(String username, String password);
}
