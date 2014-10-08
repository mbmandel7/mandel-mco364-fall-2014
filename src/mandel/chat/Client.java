package mandel.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.107", 3773);
	}

	public Socket getSocket() {
		return socket;
	}

}
