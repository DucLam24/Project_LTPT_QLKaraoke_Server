package server;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(9999)){
			System.out.println("Server is listening on port 9999");
			while (true) {
				Socket socket = serverSocket.accept();
			    System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
			    
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
