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
		Socket socket = serverSocket.accept();
		
		InputStream in = socket.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		
		OutputStream out = socket.getOutputStream();
		out.write("HelloWorld!---".getBytes());
		out.flush();
		out.close();
		
		
	}

}
