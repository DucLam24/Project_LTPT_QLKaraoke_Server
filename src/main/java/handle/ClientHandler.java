package handle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import dao.ChiTietDatComboDAO;
import dao.ChiTietDatMonDAO;
import dao.ComboDAO;
import dao.HoaDonDAO;
import dao.LoginDAO;
import dao.MonAnDAO;
import dao.NhanVienDAO;
import dao.PhieuDatPhongDAO;
import dao.PhongDAO;
import dao.impl.ChiTietDatComboImpl;
import dao.impl.ChiTietDatMonImpl;
import dao.impl.ComboImpl;
import dao.impl.HoaDonImpl;
import dao.impl.LoginImpl;
import dao.impl.MonAnImpl;
import dao.impl.NhanVienImpl;
import dao.impl.PhieuDatPhongImpl;
import dao.impl.PhongImpl;
import entity.ChiTietDatCombo;
import entity.ChiTietDatMon;
import entity.Combo;
import entity.HoaDon;
import entity.LoaiMonAn;
import entity.MonAn;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.Quyen;

public class ClientHandler implements Runnable {
	private Socket socket;
	private DataInputStream dis;
	private ObjectOutputStream oos;
	private DataOutputStream dos;

	private LoginDAO loginDAO;
	private PhongDAO phongDAO;
	private NhanVienDAO nhanVienDAO;
	private PhieuDatPhongDAO phieuDatPhongDAO;
	private MonAnDAO monAnDAO;
	private ComboDAO comboDAO;
	private HoaDonDAO hoaDonDAO;
	private ChiTietDatComboDAO chiTietDatComboDAO;
	private ChiTietDatMonDAO chiTietDatMonDAO;

	public ClientHandler(Socket socket) {
		this.socket = socket;
		loginDAO = new LoginImpl();
		phongDAO = new PhongImpl();
		nhanVienDAO = new NhanVienImpl();
		phieuDatPhongDAO = new PhieuDatPhongImpl();
		monAnDAO = new MonAnImpl();
		comboDAO = new ComboImpl();
		hoaDonDAO=new HoaDonImpl();
		chiTietDatComboDAO =new ChiTietDatComboImpl();
		chiTietDatMonDAO =new ChiTietDatMonImpl();
	}

	@Override
	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			while (true) {
				String request = dis.readUTF();
				System.out.println("Request from client: " + request);

				switch (request) {
				case "login": {
					String username = dis.readUTF();
					String password = dis.readUTF();
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
				case "getNhanVienById": {
					String id = dis.readUTF();
					NhanVien nhanVien = nhanVienDAO.getNhanVienByID(id);
					oos.writeObject(nhanVien);
					oos.flush();
					break;
				}
				case "getPhongByTinhTrang": {
					int tinhTrang = dis.readInt();
					List<Phong> listPhong = phongDAO.getPhongByTinhTrang(tinhTrang);
					oos.writeObject(listPhong);
					oos.flush();
					break;
				}
				case "getPDPByPhongIDAndTinhTrang": {
					String id = dis.readUTF();
					int tinhTrang = dis.readInt();
					List<PhieuDatPhong> listPDP = phieuDatPhongDAO.getPhieuDatPhongByPhongIDAndTinhTrang(id, tinhTrang);
					oos.writeObject(listPDP);
					oos.flush();
					break;
				}
				case "findMonAnByLoai": {
					List<MonAn> listMonAn = null;
					List<Combo> listCombo = null;
					String loai = dis.readUTF();
					LoaiMonAn loaiMonAn = null;
					if (loai.equals("Combo")) {
						listCombo = comboDAO.getAllCombo();
						oos.writeObject(listCombo);
					} else {
						if (loai.equals("Đồ uống"))
							loaiMonAn = LoaiMonAn.doUong;
						else if (loai.equals("Snack"))
							loaiMonAn = LoaiMonAn.snack;
						else if (loai.equals("Trái cây"))
							loaiMonAn = LoaiMonAn.traiCay;
						listMonAn = monAnDAO.findMonAnByLoai(loaiMonAn);
						oos.writeObject(listMonAn);
					}
					break;
				}
				case "getAllCombo": {
					List<Combo> listCombo = comboDAO.getAllCombo();
					oos.writeObject(listCombo);
					break;
				}
				case "getHoaDonByPhongIDAndTinhTrang":{
					String phongID = dis.readUTF();
					boolean tinhTrang = dis.readBoolean();
					List<HoaDon> listHoaDon = hoaDonDAO.getHoaDonByPhongIDAndTinhTrang(phongID, tinhTrang);
					oos.writeObject(listHoaDon);
					break;
				}
				case "Combo.getByPhieuDatMonID":{
					String phieuDatComboID = dis.readUTF();
					List<ChiTietDatCombo> listChiTietDatCombo = chiTietDatComboDAO.getByPhieuDatMonID(phieuDatComboID);
					oos.writeObject(listChiTietDatCombo);
					break;
				}
				case "MonAn.getByPhieuDatMonID":{
                    String phieuDatMonID = dis.readUTF();
                    List<ChiTietDatMon> listChiTietDatMon = chiTietDatMonDAO.getByPhieuDatMonID(phieuDatMonID);
                       oos.writeObject(listChiTietDatMon);
                    break;
				}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
