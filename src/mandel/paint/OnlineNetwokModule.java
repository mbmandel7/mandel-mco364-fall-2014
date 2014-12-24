package mandel.paint;

import java.io.IOException;
import java.io.OutputStream;

import mandel.paint.message.PaintMessage;

public class OnlineNetwokModule implements NetworkModule{
	
	private OutputStream out;
	
	public OnlineNetwokModule(OutputStream out){
		this.out = out;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		try {
			out.write(message.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
