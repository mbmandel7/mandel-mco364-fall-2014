package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class FillRectListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;

	private Canvas2 canvas;
	private Color color;
	private int width;

	public FillRectListener(Canvas2 canvas, Color color) {
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
		g.setColor(this.color);
		// width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));

		int width = Math.abs(startPoint.x - endPoint.x);
		int length = Math.abs(startPoint.y - endPoint.y);

		g.fillRect(Math.min(startPoint.x, endPoint.x),
				Math.min(startPoint.y, endPoint.y), width, length);

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
		if (startPoint != null) {
			int width = Math.abs(startPoint.x - movingPoint.x);
			int length = Math.abs(startPoint.y - movingPoint.y);

			g.setColor(this.color);
			// width
			g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND));
			g.fillRect(Math.min(startPoint.x, movingPoint.x),
					Math.min(startPoint.y, movingPoint.y), width, length);

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

}
