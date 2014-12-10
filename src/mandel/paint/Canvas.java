package mandel.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
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
	private Graphics2D g2;
	private DrawListener listener;
	

	public Canvas() {
		
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		clicked = false;
		g = image.getGraphics();
		g2 = (Graphics2D) g;
	}

	public void setWidth(int w) {
		g2.setStroke(new BasicStroke(w, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	}

	public void setColor(Color c) {
		this.color = c;
		g.setColor(color);
	}

	public void click(boolean b) {
		this.clicked = b;
	}
	
	public void drawRect(Point p){
		if(!clicked){
			g.drawRect(oldPoint.x, oldPoint.y, p.x, p.y);
			repaint();
		}
		oldPoint = p;
		clicked = false;
	}
	
	public void drawLine(Point p){
		if (!clicked) {
			g.drawLine(oldPoint.x, oldPoint.y, p.x, p.y);
			repaint();
		}
		oldPoint = p;
		clicked = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		listener.drawPreview((Graphics2D)g);
	}
}
