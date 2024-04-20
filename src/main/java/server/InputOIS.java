package server;

import java.io.ObjectInputStream;
import java.net.Socket;

public class InputOIS {
	private static InputOIS instance;
	private ObjectInputStream ois;

	public static InputOIS getInstance() {
		if (instance == null) {
			instance = new InputOIS();
		}
		return instance;
	}

	private InputOIS() {
		
	}

	public void start(Socket socket) {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public ObjectInputStream getOis() {
		return ois;
	}
}
