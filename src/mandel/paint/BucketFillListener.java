package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.event.MouseEvent;

public class BucketFillListener implements DrawListener {

	private Canvas2 canvas;
	private Color colorFill;
	private Point clickedPoint;
	private Polygon poly;
	private Point polyStartPoint;
	private Color polyColor;
	private Robot robot;

	public BucketFillListener(Canvas2 canvas, Color color) throws AWTException {
		// TODO Auto-generated constructor stub
		this.canvas = canvas;
		this.colorFill = color;
		this.robot = new Robot();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		poly = new Polygon();

		clickedPoint = e.getPoint();
		drawPoly();
		canvas.repaint();
	}

	public void drawPoly() {
		findStartPointUp(new Color(255, 255, 255, 0));
		Point nextPoint;
		do {
			nextPoint = searchLeft(polyStartPoint);
			nextPoint = searchDown(nextPoint);
			nextPoint = searchRight(nextPoint);
			nextPoint = searchUp(nextPoint);
		} while (!polyStartPoint.equals(nextPoint));
	}

	public Point searchLeft(Point p) {
		int tempX = p.x - 1;
		int tempY = p.y;
		while (tempX != -1
				&& polyColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempX--;
		}
		if(tempX == -1){
			//take care of this
			return null;
		}else{
			return new Point(tempX, tempY);
		}
	}

	public Point searchDown(Point p) {
		int tempX = p.x;
		int tempY = p.y + 1;
		while (tempY != canvas.getHeight() + 1
				&& polyColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempY++;
		}
		if(tempY == canvas.getHeight() +1){
			//take care of this
			return null;
		}else{
			return new Point(tempX, tempY);
		}
	}

	public Point searchRight(Point p) {
		int tempX = p.x + 1;
		int tempY = p.y;
		while (tempX != canvas.getWidth() + 1
				&& polyColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempX++;
		}
		if(tempX == canvas.getWidth() + 1){
			//take care of this
			return null;
		}else{
			return new Point(tempX, tempY);
		}
	}

	public Point searchUp(Point p) {
		int tempX = p.x;
		int tempY = p.y - 1;
		while (tempY != -1
				&& polyColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempY--;
		}
		if(tempY == -1){
			//take care of this
			return null;
		}else{
			return new Point(tempX, tempY);
		}
	}

	public void findStartPointUp(Color c) {
		int tempX = clickedPoint.x;
		int tempY = clickedPoint.y - 1;
		while (tempY != -1 && !c.equals(robot.getPixelColor(tempX, tempY))) {
			tempY--;
		}
		if (tempY == -1) {
			// add points going left
		} else {
			polyStartPoint = new Point(tempX, tempY);
			poly.addPoint(tempX, tempY);
		}
	}

	//
	// public boolean findStartPointDown(Color c) {
	// int tempX = clickedPoint.x;
	// int tempY = clickedPoint.y + 1;
	// while (tempY != -1 && !c.equals(robot.getPixelColor(tempX, tempY))) {
	// tempY++;
	// }
	// if (tempY == -1) {
	// return false;
	// } else {
	// startShapePoint = new Point(tempX, tempY);
	// return true;
	// }
	// }

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
		g.setColor(colorFill);
		g.fill(poly);
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
