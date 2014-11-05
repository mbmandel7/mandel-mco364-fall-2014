package mandel.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private Point oldPoint;
	private BufferedImage image;
	private Color color;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	public void setColor(Color c){
		this.color = c;
	}
	
	public void setPoint(Point p) {
		Graphics g = image.getGraphics();
		g.setColor(color);
		if (oldPoint != null) {
			g.drawLine(oldPoint.x, oldPoint.y, p.x, p.y);
		}
		oldPoint = p;
		//g.drawOval(p.x, p.y, 20, 20);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

}
