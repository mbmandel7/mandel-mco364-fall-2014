package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class PencilListener implements DrawListener {

	private Point oldPoint;
	private Point newPoint;

	private Canvas2 canvas;
	private Color color;
	private int width;

	public PencilListener(Canvas2 canvas, Color color) {
		this.canvas = canvas;
		this.color = color;
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
		Graphics g = canvas.getImage().getGraphics();
		g.setColor(this.color);
		// width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));

		g.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
		canvas.repaint();
		oldPoint = null;
		newPoint = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		newPoint = arg0.getPoint();
		Graphics g = canvas.getImage().getGraphics();
		g.setColor(this.color);
		// width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		
		g.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
		canvas.repaint();
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
