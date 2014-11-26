package mandel.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class RectangleListener implements DrawListener {
	
	private Point startPoint;
	private Point movingPoint;
	private Point endPoint;
	
	private Canvas2 canvas;
	
	public RectangleListener(Canvas2 c){
		this.canvas = c;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.endPoint = e.getPoint();
		BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.drawRect(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
		canvas.imageReady(true, img);
		
		startPoint = null;
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.movingPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		if(startPoint != null){
			g.drawRect(startPoint.x, startPoint.y, movingPoint.x-startPoint.x, movingPoint.y-startPoint.y);
		}
	}

	
	
	
}
