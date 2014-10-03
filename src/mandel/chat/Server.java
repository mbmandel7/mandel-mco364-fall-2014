package mandel.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server(){
		
	}
	
	public static void main(String args[]) throws IOException {
		ServerFrame frame = new ServerFrame();
		frame.setVisible(true);
		
		ServerSocket serverSocket = new ServerSocket(8080);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			frame.setChat(line + "\n");
		}
		serverSocket.close();
		
	}
	
	
	

}
