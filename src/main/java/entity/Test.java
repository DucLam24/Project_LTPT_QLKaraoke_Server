package entity;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuanLyKaraoke_MSSQL");
	}
}
