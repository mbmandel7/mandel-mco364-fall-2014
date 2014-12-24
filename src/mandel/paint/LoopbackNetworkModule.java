package mandel.paint;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mandel.paint.message.PaintMessage;

public class LoopbackNetworkModule implements NetworkModule {
	
	private BufferedImage image;

	public LoopbackNetworkModule(BufferedImage image){
		this.image = image;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		message.apply((Graphics2D)image.getGraphics());
	}

}
