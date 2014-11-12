package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point oldPoint;
	private BufferedImage image;
	private Color color;
	private boolean clicked;
	private Graphics g;
	private int width;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.BLACK;
		clicked = false;
		width = 5;
		g = image.getGraphics();
	}

	public void setWidth(int w) {
		if(width + w > 0){
			width += w;
		}		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(width));
		
	}

	public void setColor(Color c) {
		this.color = c;
	}

	public void click(boolean b) {
		this.clicked = b;
	}

	public void setPoint(Point p) {
		g.setColor(color);
		if (!clicked) {
			g.drawLine(oldPoint.x, oldPoint.y, p.x, p.y);
		}
		oldPoint = p;
		clicked = false;
		// g.drawOval(p.x, p.y, 20, 20);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

}
