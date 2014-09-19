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
		while (true) {
			Socket socket = serverSocket.accept();

			ResponseThread t = new ResponseThread(socket);
			t.start();
		}

	}

}
