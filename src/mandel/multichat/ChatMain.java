package mandel.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import mandel.chat.ClientFrame;

public class ChatMain {

	public static void main(String args[]) throws UnknownHostException, IOException {

		ClientFrame frame = new ClientFrame();
		frame.setVisible(true);

		InputStream in = frame.getSocket().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			frame.setChat(line + "\n");
		}
	}
}
