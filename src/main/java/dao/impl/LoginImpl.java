package dao.impl;

import dao.LoginDAO;
import dao.TaiKhoanDAO;
import entity.Quyen;
import entity.TaiKhoan;

public class LoginImpl implements LoginDAO{
	private TaiKhoanImpl taiKhoanDAO;

	public LoginImpl() {
		taiKhoanDAO = new TaiKhoanImpl();
	}
	
	@Override
	public Quyen login(String username, String password) {
		TaiKhoan taiKhoan = taiKhoanDAO.findTaiKhoanByID(username);
		if (taiKhoan != null) {
			if (taiKhoan.getMatKhau().equals(password)) {
				return taiKhoan.getQuyen();
			}
		}
		return null;
	}

	
}
