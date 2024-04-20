package entity;

public enum LoaiKhuyenMai {
	monAn("Món ăn"),phong("Phòng"),tongTien("Tổng tiền");
	private String value;
	
	private LoaiKhuyenMai(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}
