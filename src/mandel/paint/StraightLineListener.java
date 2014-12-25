package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import mandel.paint.message.LineMessage;

public class StraightLineListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;
	private Canvas2 canvas;
	private Color color;
	private int width;
	private NetworkModule net;

	public StraightLineListener(Canvas2 canvas, Color color, NetworkModule net) {
		this.canvas = canvas;
		this.color = color;
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
		startPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point endPoint = e.getPoint();

		LineMessage message = new LineMessage("LINE", startPoint.x,
				startPoint.y, endPoint.x, endPoint.y, color.getRGB(), width);
		System.out.println(message.toString());
		net.sendMessage(message);

		startPoint = null;
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
			g.setColor(color);
			g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND));

			g.drawLine(startPoint.x, startPoint.y, movingPoint.x, movingPoint.y);
		}
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.color = c;
	}

	@Override
	public void setWidth(int w) {
		this.width = w;
	}

}
