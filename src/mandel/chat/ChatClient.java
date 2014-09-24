package mandel.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	private Socket socket;
	
	public ChatClient() throws UnknownHostException, IOException{
		socket = new Socket("19216811775", 1025);
	}
	
	public Socket getSocket(){
		return socket;
	}
	
}
