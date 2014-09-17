package mandel.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkRequest {

	public static void main(String args[]) throws UnknownHostException, IOException{
		
		Socket socket = new Socket("localhost", 8080);//ipaddress/url, port
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		//three parts of a url: protocol, hostname, path
		String request = "GET /index.html\n\n";
		out.write(request.getBytes());
		out.flush();//need to call flush for the data to get sent out
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		
	}
	
}
