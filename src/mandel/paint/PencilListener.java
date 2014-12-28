package mandel.paint;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import mandel.paint.message.LineMessage;

public class PencilListener implements DrawListener {

	private Point oldPoint;
	private Point newPoint;

	private Color color;
	private int width;
	private NetworkModule net;

	public PencilListener(NetworkModule net) {
		this.net = net;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.oldPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		newPoint = arg0.getPoint();
		
		LineMessage message = new LineMessage(oldPoint.x,
				oldPoint.y, newPoint.x, newPoint.y, color.getRGB(), width);
		System.out.println(message.toString());
		net.sendMessage(message);
		
		oldPoint = null;
		newPoint = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		newPoint = arg0.getPoint();
				
		LineMessage message = new LineMessage(oldPoint.x,
				oldPoint.y, newPoint.x, newPoint.y, color.getRGB(), width);
		System.out.println(message.toString());
		net.sendMessage(message);
		
		
		oldPoint = newPoint;
		newPoint = null;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		color = c;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;
	}

}
