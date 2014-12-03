package mandel.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StraightLineListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;
	private Point endPoint;
	private Canvas2 canvas;
	private Graphics g;
	private BufferedImage img;

	public StraightLineListener(Canvas2 c) {
		this.canvas = c;
		 img = new BufferedImage(800, 600,
				BufferedImage.TYPE_INT_ARGB);
		g = img.getGraphics();
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
		startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		endPoint = e.getPoint();
		canvas.imageReady(createImage());
		canvas.repaint();
		startPoint = null;
	}

	public BufferedImage createImage() {
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		startPoint = null;
		endPoint = null;
		return img;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		movingPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		if (startPoint != null) {
			g.drawLine(startPoint.x, startPoint.y, movingPoint.x, movingPoint.y);
		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		g.setColor(c);
	}

}
