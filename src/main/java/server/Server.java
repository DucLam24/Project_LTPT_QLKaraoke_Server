package server;

import java.net.ServerSocket;
import java.net.Socket;

import handle.ClientHandler;

public class Server {
	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(9999)){
			System.out.println("Server is listening on port 9999");
			while (true) {
				Socket socket = serverSocket.accept();
			    System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
			    Thread thread = new Thread(new ClientHandler(socket));
			    thread.start();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
