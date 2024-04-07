package dao.impl;

import entity.Quyen;

public class Test {
	public static void main(String[] args) {
		LoginImpl loginImpl = new LoginImpl();
		Quyen quyen = loginImpl.login("NV240001", "12345678");
		System.out.println(quyen);
	}
}
