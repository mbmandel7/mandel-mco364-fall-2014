package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import mandel.paint.message.ShapeMessage;

public class FillOvalListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;

	private Canvas2 canvas;
	private Color color;
	private int width;
	
	private NetworkModule net;

	public FillOvalListener(Canvas2 canvas, NetworkModule net) {
		this.canvas = canvas;
		this.net = net;
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
		
		ShapeMessage message = new ShapeMessage("OVAL", getStartX(endPoint),
				getStartY(endPoint), getWidth(endPoint), getLength(endPoint),
				color.getRGB(), this.width, true);
		System.out.println(message.toString());
		net.sendMessage(message);

		
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
		
			g.setColor(this.color);
			// width
			g.setStroke(new BasicStroke(this.width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g.fillOval(getStartX(movingPoint), getStartY(movingPoint), getWidth(movingPoint), getLength(movingPoint));

		}
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

}
