package mandel.paint;

import java.awt.Color;
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
	private Color color;
	
	public void setColor(Color c){
		this.color = c;
	}

	public RectangleListener(Canvas2 c) {
		this.canvas = c;
		startPoint = new Point(0, 0);
		movingPoint = new Point(50, 50);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLicked");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("CLicked");
		// TODO Auto-generated method stub
		this.startPoint = e.getPoint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("CLicked");
		// TODO Auto-generated method stub
		this.endPoint = e.getPoint();
		
		canvas.imageReady(createImage());

		startPoint = null;
		canvas.repaint();
	}
	
	public BufferedImage createImage(){
		BufferedImage img = new BufferedImage(800, 600,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		
		

		int width = calculateWidth(endPoint);
		int length = calculateLength(endPoint);

		drawRectOnCalculatedCoordinates(endPoint, g, width, length);

		return img;
	}

	public void drawRectOnCalculatedCoordinates(Point p2, Graphics g, int width, int length) {
		if (startPoint.x < p2.x) {
			if (startPoint.y < p2.y) {//top left
				g.drawRect(startPoint.x, p2.y, p2.x, startPoint.y);
				//g.drawRect(startPoint.x, startPoint.y, width, length);
			} else {
				g.drawRect(startPoint.x, startPoint.y, p2.x, p2.y);
				//g.drawRect(p2.x, startPoint.y, width, length);//bottom left
			}
		} else {
			if (startPoint.y > p2.y) {//top right
				//g.drawRect(startPoint.x, p2.y, width, length);
				g.drawRect(p2.x, startPoint.y, startPoint.x, p2.y);
			} else {//bottom right
				//g.drawRect(p2.x, p2.y, width, length);
				g.drawRect(p2.x, p2.y, startPoint.x, startPoint.y);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("CLicked");
		// TODO Auto-generated method stub
		this.movingPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLicked");
	}

	private int calculateWidth(Point p2) {
		int width;
		if (startPoint.x < p2.x) {
			width = p2.x - startPoint.y;
		} else {
			width = startPoint.x - p2.y;
		}
		return width;
	}

	private int calculateLength(Point p2) {
		int length;
		if (startPoint.y < p2.y) {
			length = p2.y - startPoint.y;
		} else {
			length = startPoint.y - p2.y;
		}
		return length;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		if (startPoint != null) {
			drawRectOnCalculatedCoordinates(movingPoint, g, calculateWidth(movingPoint), calculateLength(movingPoint));
		}
	}

}
