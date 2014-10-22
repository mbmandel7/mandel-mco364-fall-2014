package mandel.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket socket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(3773);
		socket = serverSocket.accept();
	}
	
	public Socket getSocket(){
		return socket;
	}

	public static void main(String args[]) throws IOException {
		ServerFrame frame = new ServerFrame();
		frame.setVisible(true);

		InputStream in = frame.getSocket().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			frame.setChat(line + "\n");
		}
	}

}
