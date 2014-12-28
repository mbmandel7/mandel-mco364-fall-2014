package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Stack;


import mandel.paint.message.BucketFillMessage;

public class BucketFillListener implements DrawListener {

	private Point clickedPoint;
	private int clickedColor;
	private Canvas canvas;
	private int colorInt;

	private NetworkModule net;

	private Stack<Point> stack;

	public BucketFillListener(Canvas canvas, NetworkModule net)
			throws AWTException {
		// TODO Auto-generated constructor stub
		this.canvas = canvas;
		this.net = net;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clickedPoint = e.getPoint();
		clickedColor = canvas.getImage().getRGB(clickedPoint.x, clickedPoint.y);
		stack = new Stack<Point>();
		
		BucketFillMessage message = new BucketFillMessage(clickedPoint.x,
				clickedPoint.y, colorInt);
		net.sendMessage(message);
		stack.push(clickedPoint);
		Point p;
		while (!stack.isEmpty()) {
			p = stack.pop();
			test(new Point(p.x, p.y - 1));
			test(new Point(p.x - 1, p.y));
			test(new Point(p.x, p.y + 1));
			test(new Point(p.x + 1, p.y));
		}
	}

	public void test(Point temp) {
		if (temp.x < 800 && temp.y < 600 && temp.x > -1 && temp.y > -1
				&& clickedColor == canvas.getImage().getRGB(temp.x, temp.y)) {
//			canvas.getImage().setRGB(temp.x, temp.y, colorInt);
			BucketFillMessage message = new BucketFillMessage(temp.x,
					temp.y, colorInt);
			net.sendMessage(message);
			stack.push(temp);
		}
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
		this.colorInt = c.getRGB();
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub

	}

}
