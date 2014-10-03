package mandel.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket;
	
	public Client() throws UnknownHostException, IOException{
		socket = new Socket("192.168.117.112", 8080);
	}
	
	public static void main (String args[]) throws UnknownHostException, IOException{
		ClientFrame frame = new ClientFrame();
		frame.setVisible(true);		
	}
	
	public Socket getSocket(){
		return socket;
	}

}
