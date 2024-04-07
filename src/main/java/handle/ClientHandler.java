package handle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import dao.LoginDAO;
import dao.NhanVienDAO;
import dao.PhongDAO;
import dao.impl.LoginImpl;
import dao.impl.NhanVienImpl;
import dao.impl.PhongImpl;
import entity.NhanVien;
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

	public ClientHandler(Socket socket) {
		this.socket = socket;
		loginDAO = new LoginImpl();
		phongDAO = new PhongImpl();
		nhanVienDAO = new NhanVienImpl();
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
				case "getPhongByTinhTrang":{
					int tinhTrang = dis.readInt();
					List<Phong> listPhong = phongDAO.getPhongByTinhTrang(tinhTrang);
					oos.writeObject(listPhong);
					oos.flush();
					break;
				}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
