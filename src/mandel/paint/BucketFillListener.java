package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JOptionPane;

import mandel.paint.message.BucketFillMessage;

public class BucketFillListener implements DrawListener {

	private Point clickedPoint;
	private int clickedColor;
	private Canvas2 canvas;
	private int colorInt;
	
	private NetworkModule net;
	
	private Stack<Point> stack;

	public BucketFillListener(Canvas2 canvas, Color color, NetworkModule net) throws AWTException {
		// TODO Auto-generated constructor stub
		this.canvas = canvas;
		this.colorInt = color.getRGB();
		this.net = net;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clickedPoint = e.getPoint();
		clickedColor = canvas.getImage().getRGB(clickedPoint.x, clickedPoint.y);
		stack = new Stack<Point>();
		// change color
		canvas.getImage().setRGB(clickedPoint.x, clickedPoint.y, colorInt);
		stack.push(clickedPoint);
		Point p;
		while (!stack.isEmpty()) {
			p = stack.pop();
			up(p);
			left(p);
			down(p);
			right(p);
		}
		canvas.repaint();
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
