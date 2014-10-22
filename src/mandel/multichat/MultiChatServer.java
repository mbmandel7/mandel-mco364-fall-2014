package mandel.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MultiChatServer {

	public static void main(String args[]) throws IOException {
		Frame frame = new Frame();

		ServerSocket serverSocket = new ServerSocket(3773);
		BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
		List<Socket> sockets = new LinkedList<Socket>();
		MessageSender sender = new MessageSender(messages, sockets, frame);
		sender.start();
		
		frame.setVisible(true);
		
		while (true) {// handle multiple sockets
			Socket socket = serverSocket.accept();
			sockets.add(socket);
			SocketHandler handler = new SocketHandler(socket, messages);
			handler.start();
		}
	}

}
