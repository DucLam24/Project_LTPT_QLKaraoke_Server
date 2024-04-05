package entity;

public enum Quyen {
	nhanVien("Nhân viên"), quanLy("Quản lý");
	private String value;
	private Quyen(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}
