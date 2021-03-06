package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Stack;


public class BucketFillListener implements DrawListener {

	private Point clickedPoint;
	private int clickedColor;
	private Canvas2 canvas;
	private int colorInt;
	
	private Stack<Point> stack;

	public BucketFillListener(Canvas2 canvas, Color color) throws AWTException {
		// TODO Auto-generated constructor stub
		this.canvas = canvas;
		this.colorInt = color.getRGB();
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
			test(new Point(p.x, p.y-1));
			test(new Point(p.x-1, p.y));
			test(new Point(p.x, p.y+1));
			test(new Point(p.x+1, p.y));
		}
		canvas.repaint();
	}

	public void test(Point temp) {
		if (temp.x < 800 && temp.y < 600 && temp.x > -1 && temp.y > -1
				&& clickedColor == canvas.getImage().getRGB(temp.x, temp.y)) {
			canvas.getImage().setRGB(temp.x, temp.y, colorInt);
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
