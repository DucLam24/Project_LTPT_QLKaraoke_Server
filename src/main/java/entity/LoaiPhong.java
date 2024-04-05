package entity;

public enum LoaiPhong {
	phongThuong("Phòng thường"), phongVip("Phòng VIP");
	private String value;

	private LoaiPhong(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}
