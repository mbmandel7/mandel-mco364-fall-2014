package mandel.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.42", 3773);
	}

	public Socket getSocket() {
		return socket;
	}
	
	public static void main (String args[]) throws IOException{
		
		ClientFrame frame = new ClientFrame();
		frame.setVisible(true);
		
		InputStream in = frame.getSocket().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			frame.setChat(line + "\n");
		}
	}

}
