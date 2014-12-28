package mandel.paint;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mandel.paint.message.PaintMessage;

public class LoopbackNetworkModule implements NetworkModule {
	
	private Canvas canvas;

	public LoopbackNetworkModule(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		message.apply((Graphics2D)canvas.getImage().getGraphics());
		canvas.repaint();
	}

}
