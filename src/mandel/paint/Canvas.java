package mandel.paint;

import java.awt.Color;
import java.awt.Graphics;
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

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.black;
		clicked = false;
	}

	public void setColor(Color c){
		this.color = c;
	}
	
	public void click(boolean b){
		this.clicked = b;
	}
	
	public void setPoint(Point p) {
		Graphics g = image.getGraphics();
		g.setColor(color);
		if (!clicked) {
			g.drawLine(oldPoint.x, oldPoint.y, p.x, p.y);
		}
		oldPoint = p;
		clicked = false;
		//g.drawOval(p.x, p.y, 20, 20);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

}
