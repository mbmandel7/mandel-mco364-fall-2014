package mandel.paint;

import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

import mandel.paint.message.PaintMessage;

public class OnlineNetwokModule implements NetworkModule{
	
	private Connection conn;
	
	public OnlineNetwokModule() throws UnknownHostException, IOException{
		conn = new Connection();		
	}
	
	public Connection getConnection(){
		return this.conn;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		try {
			conn.getSocket().getOutputStream().write(message.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
