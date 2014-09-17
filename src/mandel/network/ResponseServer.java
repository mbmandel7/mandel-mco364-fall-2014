package mandel.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {
	
	public static void main(String args[]) throws IOException {

		// makes this program listen
		ServerSocket serverSocket = new ServerSocket(8080);// we don't put in
															// the url because
															// we know what it
															// is - it's this
															// computer! but we
															// need to say what
															// port will be used
															// for listening.
															// 8080 is standard
															// for listening
		int counter = 0;
		while (true) {
			Socket socket = serverSocket.accept();

			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while (!"".equals(line = reader.readLine())) {
				System.out.println(line);
			}

			OutputStream out = socket.getOutputStream();
			String response = "<h2>This is the " + counter + "th request";
			out.write("HTTP/1.1 200 OK\n".getBytes());;
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + "\n\n").getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();
			
			counter++;
		}

	}

}
