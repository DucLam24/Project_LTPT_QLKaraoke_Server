package entity;

public enum LoaiMonAn {
	doUong("Đồ uống"),snack("Snack"),traiCay("Trái cây");
	private String value;

	private LoaiMonAn(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}
