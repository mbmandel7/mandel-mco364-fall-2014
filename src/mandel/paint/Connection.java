package mandel.paint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import mandel.paint.message.PaintMessage;
import mandel.paint.message.PaintMessageFactory;

public class Connection {
	
	private Socket socket;
	
	public Connection() throws UnknownHostException, IOException{
//		socket = new Socket("192.168.117.107", 3773);	
		socket = new Socket("192.168.117.167", 3773);	
	}
	
	public Socket getSocket(){
		return socket;
	}
	
	
}
