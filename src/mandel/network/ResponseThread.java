package mandel.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ResponseThread extends Thread{
	
	private Socket socket;

	public ResponseThread(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		int counter = 0;

		try {
			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while (!"".equals(line = reader.readLine())) {
				System.out.println(line);
			}

			OutputStream out = socket.getOutputStream();
			String response = "<h2>This is the " + counter + "th request";
			out.write("HTTP/1.1 200 OK\n".getBytes());
			;
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + "\n\n")
					.getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		counter++;
	}

}
