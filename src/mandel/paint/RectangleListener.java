package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class RectangleListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;

	private Canvas2 canvas;
	private Color color;
	private int width;

	public RectangleListener(Canvas2 canvas, Color color) {
		this.canvas = canvas;
		this.color = color;
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
		Point endPoint = e.getPoint();
		Graphics g = canvas.getImage().getGraphics();
		g.setColor(color);
		// width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(this.width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		g.drawRect(getStartX(endPoint), getStartY(endPoint), getWidth(endPoint), getLength(endPoint));
		canvas.repaint();
		startPoint = null;

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
		if (startPoint != null) {

			g.setColor(color);
			// width
			g.setStroke(new BasicStroke(this.width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g.drawRect(getStartX(movingPoint), getStartY(movingPoint), getWidth(movingPoint), getLength(movingPoint));

		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.color = c;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;
	}

	public int getWidth(Point p) {
		return Math.abs(startPoint.x - p.x);
	}

	public int getLength(Point p) {
		return Math.abs(startPoint.y - p.y);
	}

	public int getStartX(Point p) {
		return Math.min(startPoint.x, p.x);
	}

	public int getStartY(Point p) {
		return Math.min(startPoint.y, p.y);
	}

}
