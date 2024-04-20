package handle;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import dao.ChiTietDatComboDAO;
import dao.ChiTietDatMonDAO;
import dao.ComboDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.KhuyenMaiDAO;
import dao.LoginDAO;
import dao.MonAnDAO;
import dao.NhanVienDAO;
import dao.PhieuDatMonDAO;
import dao.PhieuDatPhongDAO;
import dao.PhongDAO;
import dao.impl.ChiTietDatComboImpl;
import dao.impl.ChiTietDatMonImpl;
import dao.impl.ComboImpl;
import dao.impl.HoaDonImpl;
import dao.impl.KhachHangImpl;
import dao.impl.KhuyenMaiImpl;
import dao.impl.LoginImpl;
import dao.impl.MonAnImpl;
import dao.impl.NhanVienImpl;
import dao.impl.PhieuDatMonImpl;
import dao.impl.PhieuDatPhongImpl;
import dao.impl.PhongImpl;
import entity.ChiTietDatCombo;
import entity.ChiTietDatMon;
import entity.Combo;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.LoaiMonAn;
import entity.MonAn;
import entity.NhanVien;
import entity.PhieuDatMon;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.Quyen;

public class ClientHandler implements Runnable {
	private Socket socket;
//	private DataInputStream dis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
//	private DataOutputStream dos;

	private LoginDAO loginDAO;
	private PhongDAO phongDAO;
	private NhanVienDAO nhanVienDAO;
	private PhieuDatPhongDAO phieuDatPhongDAO;
	private MonAnDAO monAnDAO;
	private ComboDAO comboDAO;
	private HoaDonDAO hoaDonDAO;
	private ChiTietDatComboDAO chiTietDatComboDAO;
	private ChiTietDatMonDAO chiTietDatMonDAO;
	private PhieuDatMonDAO phieuDatMonDAO;
	private KhuyenMaiDAO khuyenMaiDAO;

	private KhachHangDAO khachHangDAO;

	public ClientHandler(Socket socket) {
		this.socket = socket;
		loginDAO = new LoginImpl();
		phongDAO = new PhongImpl();
		nhanVienDAO = new NhanVienImpl();
		phieuDatPhongDAO = new PhieuDatPhongImpl();
		monAnDAO = new MonAnImpl();
		comboDAO = new ComboImpl();
		hoaDonDAO = new HoaDonImpl();
		chiTietDatComboDAO = new ChiTietDatComboImpl();
		chiTietDatMonDAO = new ChiTietDatMonImpl();
		phieuDatMonDAO = new PhieuDatMonImpl();
		khachHangDAO = new KhachHangImpl();
		khuyenMaiDAO= new KhuyenMaiImpl();
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		try {

//			dis = new DataInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
//			dos = new DataOutputStream(socket.getOutputStream());

			while (true) {
				String request = ois.readUTF();
				System.out.println("Request from client: " + request);

				switch (request) {
				case "login": {
					String username = ois.readUTF();
					String password = ois.readUTF();
//					System.out.println("Username: " + username);
//					System.out.println("Password: " + password);
					Quyen quyen = loginDAO.login(username, password);
					oos.writeObject(quyen);
					oos.flush();
					break;
				}
				case "getAllPhong": {
					List<Phong> listPhong = phongDAO.getAllPhong();
					oos.writeObject(listPhong);
					oos.flush();
					break;
				}
				case "getPhongByTinhTrang": {
					int tinhTrang = ois.readInt();
					List<Phong> listPhong = phongDAO.getPhongByTinhTrang(tinhTrang);
					oos.writeObject(listPhong);
					oos.flush();
					break;
				}
				case "Phong.getPhongByID": {
					String id = ois.readUTF();
					Phong phong = phongDAO.getPhongByID(id);
					oos.writeObject(phong);
					oos.flush();
					break;
				}
				case "getNhanVienById": {
					String id = ois.readUTF();
					NhanVien nhanVien = nhanVienDAO.getNhanVienByID(id);
					oos.writeObject(nhanVien);
					oos.flush();
					break;
				}

				case "getPDPByPhongIDAndTinhTrang": {
					String id = ois.readUTF();
					int tinhTrang = ois.readInt();
					List<PhieuDatPhong> listPDP = phieuDatPhongDAO.getPhieuDatPhongByPhongIDAndTinhTrang(id, tinhTrang);
					oos.writeObject(listPDP);
					oos.flush();
					break;
				}
				case "findMonAnByLoai": {
					List<MonAn> listMonAn = null;
					String loai = ois.readUTF();
					LoaiMonAn loaiMonAn = null;

					if (loai.equals("Đồ uống"))
						loaiMonAn = LoaiMonAn.doUong;
					else if (loai.equals("Snack"))
						loaiMonAn = LoaiMonAn.snack;
					else if (loai.equals("Trái cây"))
						loaiMonAn = LoaiMonAn.traiCay;
					listMonAn = monAnDAO.findMonAnByLoai(loaiMonAn);
					oos.writeObject(listMonAn);
					oos.flush();
					break;
				}
				case "getAllCombo": {
					List<Combo> listCombo = comboDAO.getAllCombo();
					oos.writeObject(listCombo);
					oos.flush();
					break;
				}
				case "getHoaDonByPhongIDAndTinhTrang": {
					String phongID = ois.readUTF();
					boolean tinhTrang = ois.readBoolean();
					List<HoaDon> listHoaDon = hoaDonDAO.getHoaDonByPhongIDAndTinhTrang(phongID, tinhTrang);
					oos.writeObject(listHoaDon);
					oos.flush();
					break;
				}
				case "ChiTietDatCombo.getByPhieuDatMonID": {
					String phieuDatComboID = ois.readUTF();
					List<ChiTietDatCombo> listChiTietDatCombo = chiTietDatComboDAO.getByPhieuDatMonID(phieuDatComboID);
					oos.writeObject(listChiTietDatCombo);
					oos.flush();
					break;
				}
				case "ChiTietDatMon.getByPhieuDatMonID": {
					String phieuDatMonID = ois.readUTF();
					List<ChiTietDatMon> listChiTietDatMon = chiTietDatMonDAO.getByPhieuDatMonID(phieuDatMonID);
					oos.writeObject(listChiTietDatMon);
					oos.flush();
					break;
				}
				case "ChiTietDatCombo.updateSoLuong": {
					ChiTietDatCombo chiTietDatCombo = (ChiTietDatCombo) ois.readObject();
					boolean result = chiTietDatComboDAO.updateSoLuong(chiTietDatCombo);
					oos.writeBoolean(result);
					oos.flush();
					break;

				}
				case "ChiTietDatCombo.addCombo": {
//					String phieuDatMonID = ois.readUTF();
//					PhieuDatMon phieuDatMon = phieuDatMonDAO.getByID(phieuDatMonID);
//					String comboID = ois.readUTF();
//					Combo combo = comboDAO.getComboByID(comboID);
//					int soLuong = ois.readInt();
//
//					ChiTietDatCombo chiTietDatCombo = new ChiTietDatCombo(phieuDatMon, combo, soLuong);
					ChiTietDatCombo chiTietDatCombo = (ChiTietDatCombo) ois.readObject();
					boolean result = chiTietDatComboDAO.addCombo(chiTietDatCombo);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "ChiTietDatMon.updateSoLuong": {
//					String phieuDatMonID = ois.readUTF();
//					PhieuDatMon phieuDatMon = phieuDatMonDAO.getByID(phieuDatMonID);
//					String monAnID = ois.readUTF();
//					MonAn monAn = monAnDAO.getMonAnByID(monAnID);
//					int soLuong = ois.readInt();
//					ChiTietDatMon chiTietDatMon = new ChiTietDatMon(phieuDatMon, monAn, soLuong);

					ChiTietDatMon chiTietDatMon = (ChiTietDatMon) ois.readObject();
					boolean result = chiTietDatMonDAO.updateSoLuong(chiTietDatMon);
					oos.writeBoolean(result);
					oos.flush();
					break;

				}
				case "ChiTietDatMon.addMonAn": {
//					String phieuDatMonID = ois.readUTF();
//					PhieuDatMon phieuDatMon = phieuDatMonDAO.getByID(phieuDatMonID);
//					String monAnID = ois.readUTF();
//					MonAn monAn = monAnDAO.getMonAnByID(monAnID);
//					int soLuong = ois.readInt();
//					ChiTietDatMon chiTietDatMon = new ChiTietDatMon(phieuDatMon, monAn, soLuong);
					ChiTietDatMon chiTietDatMon = (ChiTietDatMon) ois.readObject();
					boolean result = chiTietDatMonDAO.addMonAn(chiTietDatMon);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}

				case "ChiTietDatCombo.deleteChiTietDatComboByPhieuDatMonID": {
					String phieuDatMonID = ois.readUTF();
					String comboID = ois.readUTF();
					boolean result = chiTietDatComboDAO.deleteChiTietDatComboByPhieuDatMonID(phieuDatMonID, comboID);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "ChiTietDatMon.deleteChiTietDatMonAnByPhieuDatMonID": {
					String phieuDatMonID = ois.readUTF();
					String monAnID = ois.readUTF();
					boolean result = chiTietDatMonDAO.deleteChiTietDatMonAnByPhieuDatMonID(phieuDatMonID, monAnID);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "KhachHang.getKhachHangByStartID": {
					String startID = ois.readUTF();
					List<KhachHang> listKhachHang = khachHangDAO.getKhachHangByStartID(startID);
					oos.writeObject(listKhachHang);
					oos.flush();
					break;
				}
				case "PhieuDatPhong.getPhieuDatPhongByStartID": {
					String startID = ois.readUTF();
					List<PhieuDatPhong> listPhieuDatPhong = phieuDatPhongDAO.getPhieuDatPhongByStartID(startID);
					oos.writeObject(listPhieuDatPhong);
					oos.flush();
					break;
				}
				case "PhieuDatPhong.addPhieuDatPhong": {
					PhieuDatPhong phieuDatPhong = (PhieuDatPhong) ois.readObject();
					boolean result = phieuDatPhongDAO.addPhieuDatPhong(phieuDatPhong);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "Phong.updateTinhTrang": {
					Phong phong = (Phong) ois.readObject();
					boolean result = phongDAO.updateTinhTrang(phong);
					System.out.println("Result: " + result);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "ChiTietDatCombo.findByPhieuDatMonIDAndComboID": {
					String phieuDatMonID = ois.readUTF();
					String comboID = ois.readUTF();
					ChiTietDatCombo chiTietDatCombo = chiTietDatComboDAO.findByPhieuDatMonIDAndComboID(phieuDatMonID,
							comboID);
					System.out.println("ChiTietDatCombo : " + chiTietDatCombo);
					oos.writeObject(chiTietDatCombo);
					oos.flush();
					break;
				}
				case "ChiTietDatMon.findByPhieuDatMonIDAndMonAnID": {
					String phieuDatMonID = ois.readUTF();
					String monAnID = ois.readUTF();
					ChiTietDatMon chiTietDatMon = chiTietDatMonDAO.findByPhieuDatMonIDAndMonAnID(phieuDatMonID,
							monAnID);
					oos.writeObject(chiTietDatMon);
					oos.flush();
					break;

				}
				case "PhieuDatPhong.updateTinhTrang": {
					PhieuDatPhong phieuDatPhong = (PhieuDatPhong) ois.readObject();
					boolean result = phieuDatPhongDAO.updatePhieuDatPhong(phieuDatPhong);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "PhieuDatMon.getPhieuDatMonByStartID": {
					String startID = ois.readUTF();
					List<PhieuDatMon> listPhieuDatMon = phieuDatMonDAO.getPhieuDatMonByStartID(startID);
					oos.writeObject(listPhieuDatMon);
					oos.flush();
					break;
				}
				case "PhieuDatMon.addPhieuDatMon": {
					PhieuDatMon phieuDatMon = (PhieuDatMon) ois.readObject();
					boolean result = phieuDatMonDAO.addPhieuDatMon(phieuDatMon);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "HoaDon.getHoaDonByStartID": {
					String startID = ois.readUTF();
					List<HoaDon> listHoaDon = hoaDonDAO.getHoaDonByStartID(startID);
					System.out.println("List HoaDon Server: " + listHoaDon);
					oos.writeObject(listHoaDon);
					oos.flush();
					break;
				}
				case "HoaDon.addHoaDon": {
					HoaDon hoaDon = (HoaDon) ois.readObject();
					boolean result = hoaDonDAO.addHoaDon(hoaDon);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "KhachHang.getKhachHangBySDT": {
					String sdt = ois.readUTF();
					KhachHang khachHang = khachHangDAO.getKhachHangBySDT(sdt);
					oos.writeObject(khachHang);
					oos.flush();
					break;
				}
				case "KhachHang.addKhachHang": {
					KhachHang khachHang = (KhachHang) ois.readObject();
					boolean result = khachHangDAO.addKhachHang(khachHang);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "PhieuDatMon.getByID":{
					String phieuDatMonID = ois.readUTF();
					PhieuDatMon phieuDatMon = phieuDatMonDAO.getByID(phieuDatMonID);
					oos.writeObject(phieuDatMon);
					oos.flush();
					break;
				}
				case "MonAn.getMonAnID":{
					String monAnID = ois.readUTF();
                    MonAn monAn = monAnDAO.getMonAnByID(monAnID);
                    oos.writeObject(monAn);
                    oos.flush();
                    break;
				}
				case "Combo.getByID":{
					String comboID = ois.readUTF();
					Combo combo = comboDAO.getComboByID(comboID);
					oos.writeObject(combo);
					oos.flush();
					break;
				}
				case "KhachHang.updateKhachHang":{
					KhachHang khachHang = (KhachHang) ois.readObject();
					boolean result = khachHangDAO.updateKhachHang(khachHang);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "MonAn.updateMonAn":{
					MonAn monAn = (MonAn) ois.readObject();
					boolean result = monAnDAO.updateMonAn(monAn);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "Combo.updateCombo":{
                    Combo combo = (Combo) ois.readObject();
                    boolean result = comboDAO.updateCombo(combo);
                    oos.writeBoolean(result);
                    oos.flush();
                    break;
				}
				case "PhieuDatMon.updatePhieuDatMon": {
					PhieuDatMon phieuDatMon = (PhieuDatMon) ois.readObject();
					boolean result = phieuDatMonDAO.updatePhieuDatMon(phieuDatMon);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "HoaDon.updateHoaDon": {
					HoaDon hoaDon = (HoaDon) ois.readObject();
					boolean result = hoaDonDAO.updateHoaDon(hoaDon);
					oos.writeBoolean(result);
					oos.flush();
					break;
				}
				case "KhuyenMai.getAllKhuyenMai":{
					List<KhuyenMai> listKhuyenMai = khuyenMaiDAO.getAllKhuyenMai();
					oos.writeObject(listKhuyenMai);
					oos.flush();
					break;
				}
				case "KhuyenMai.getKhuyenMaiByTen":{
					String tenKhuyenMai=ois.readUTF();
					KhuyenMai km = khuyenMaiDAO.getKhuyenMaiByTen(tenKhuyenMai);
					oos.writeObject(km);
					oos.flush();
					break;
				}
			}}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				dis.close();
				oos.close();
//				dos.close();
				ois.close();

				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
