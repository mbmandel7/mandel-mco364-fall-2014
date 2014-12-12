package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class BucketFillListener implements DrawListener {

	private Canvas2 canvas;

	private Color colorFill;
	private Polygon poly;

	private Point clickedPoint;
	private Color clickedColor;

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
		clickedColor = robot.getPixelColor(clickedPoint.x, clickedPoint.y);

		System.out.println("Found\nClicked Point: " + clickedPoint
				+ "\nClicked Color: " + clickedColor);

		drawPoly();

		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		g.setColor(colorFill);
		g.fill(poly);
		canvas.repaint();
	}

	public void drawPoly() {
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		g.setColor(colorFill);
		
		findStartPointUp();
		Point nextPoint;
		nextPoint = polyStartPoint;
		do {
			Point p = searchLeft(nextPoint);
			g.drawLine(nextPoint.x, nextPoint.y, p.x, p.y);
			System.out.println("Found\nNext Point: " + nextPoint + "\n Color: "
					+ robot.getPixelColor(nextPoint.x, nextPoint.y));
			nextPoint = p;
			canvas.repaint();

			p = searchDown(nextPoint);
			g.drawLine(nextPoint.x, nextPoint.y, p.x, p.y);
			System.out.println("Found\nNext Point: " + nextPoint + "\n Color: "
					+ robot.getPixelColor(nextPoint.x, nextPoint.y));
			nextPoint = p;
			canvas.repaint();

			p = searchRight(nextPoint);
			g.drawLine(nextPoint.x, nextPoint.y, p.x, p.y);
			System.out.println("Found\nNext Point: " + nextPoint + "\n Color: "
					+ robot.getPixelColor(nextPoint.x, nextPoint.y));
			nextPoint = p;
			canvas.repaint();
			
			p = searchUp(nextPoint);
			g.drawLine(nextPoint.x, nextPoint.y, p.x, p.y);
			System.out.println("Found\nNext Point: " + nextPoint + "\n Color: "
					+ robot.getPixelColor(nextPoint.x, nextPoint.y));
			nextPoint = p;
			canvas.repaint();

		} while (!polyStartPoint.equals(nextPoint));

		JOptionPane.showMessageDialog(null, "Found\nLast Point: " + nextPoint
				+ "\n Color: " + robot.getPixelColor(nextPoint.x, nextPoint.y));
		System.out.println("Found\nLast Point: " + nextPoint + "\n Color: "
				+ robot.getPixelColor(nextPoint.x, nextPoint.y));
	}

	public void findStartPointUp() {
		int tempX = clickedPoint.x;
		int tempY = clickedPoint.y;
		tempY--;
		Color tempColor = robot.getPixelColor(tempX, tempY);
		while (tempY != -1 && clickedColor.equals(tempColor)) {
			tempColor = robot.getPixelColor(tempX, tempY);
			tempY--;
		}
		if (tempY == -1) {
			polyStartPoint = new Point(tempX, 0);
			// add points going left
		} else {
			polyStartPoint = new Point(tempX, tempY);
		}
		polyColor = robot.getPixelColor(polyStartPoint.x, polyStartPoint.y);

		poly.addPoint(polyStartPoint.x, polyStartPoint.y);

		System.out.println("Found\nStart Point: " + polyStartPoint.x + " "
				+ polyStartPoint.y + "\nColor: " + polyColor);
	}

	public Point searchLeft(Point p) {
		int tempX = p.x - 1;
		int tempY = p.y;
		Color rc = robot.getPixelColor(tempX, tempY);
		while (tempX > -1 && !clickedColor.equals(rc)) {
			poly.addPoint(tempX, tempY);
			tempX--;
			rc = robot.getPixelColor(tempX, tempY);
		}
		if (tempX == -1) {
			// take care of this
			return null;
		} else {
			return new Point(tempX + 1, tempY);
		}
	}

	public Point searchDown(Point p) {
		int tempX = p.x;
		int tempY = p.y + 1;
		Color rc = robot.getPixelColor(tempX, tempY);
		while (tempY < canvas.getHeight() + 1
				&& !clickedColor.equals(rc)) {
			poly.addPoint(tempX, tempY);
			tempY++;
			rc = robot.getPixelColor(tempX, tempY);
		}
		if (tempY == canvas.getHeight() + 1) {
			// take care of this
			return null;
		} else {
			return new Point(tempX, tempY - 1);
		}
	}

	public Point searchRight(Point p) {
		int tempX = p.x + 1;
		int tempY = p.y;
		while (tempX != canvas.getWidth() + 1
				&& !clickedColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempX++;
		}
		if (tempX == canvas.getWidth() + 1) {
			// take care of this
			return null;
		} else {
			return new Point(tempX - 1, tempY);
		}
	}

	public Point searchUp(Point p) {
		int tempX = p.x;
		int tempY = p.y - 1;
		while (tempY != -1
				&& !clickedColor.equals(robot.getPixelColor(tempX, tempY))) {
			poly.addPoint(tempX, tempY);
			tempY--;
		}
		if (tempY == -1) {
			// take care of this
			return null;
		} else {
			return new Point(tempX, tempY + 1);
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
