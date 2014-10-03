package mandel.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class SocketHandler extends Thread {

	private Socket s;
	private BlockingQueue<String> messages;

	public SocketHandler(Socket socket, BlockingQueue<String> messages) {
		this.s = socket;
		this.messages = messages;
	}

	@Override
	public void run() {
		InputStream in;
		try {
			in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));// reading
																					// the
																					// data
																					// off
																					// the
																					// socket
			String line;
			while((line = reader.readLine()) != null){//null means that the socket closed
				// write to all the clients. chatserver has access to all the clients.
				messages.add(line);				
			}//this thread blocks, so can't use it to write
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
