package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketFillListener implements DrawListener {

	private Canvas2 canvas;

	private Color colorFill;
	private int colorFillInt;

	private Point clickedPoint;
	private Color clickedColor;

	private Point polyStartPoint;

	private Robot robot;
	
	private Stack<Point> points;

	public BucketFillListener(Canvas2 canvas, Color color) throws AWTException {
		// TODO Auto-generated constructor stub
		this.canvas = canvas;
		this.colorFill = color;
		this.robot = new Robot();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
//		g.setColor(colorFill);
		
		clickedPoint = e.getPoint();
		clickedColor = robot.getPixelColor(clickedPoint.x, clickedPoint.y);
		this.colorFillInt = clickedColor.getRGB();
		
		drawPoly();

		canvas.repaint();
	}

	public void drawPoly() {

		points = new Stack<Point>();
		addPoint(clickedPoint);
		
		
	}	
	
	public void addPoint(Point p){
		points.add(p);
		canvas.getImage().setRGB(p.x, p.y, colorFillInt);
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
		// g.setColor(colorFill);
		// g.fill(poly);
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		this.colorFill = c;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub

	}

}
