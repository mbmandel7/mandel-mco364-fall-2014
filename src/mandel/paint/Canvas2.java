package mandel.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas2 extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private Graphics g;

	private DrawListener listener;

	public Canvas2() {
		DrawListener[] listeners = new DrawListener[6];
		listeners[0] = new RectangleListener(this);
		
		
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();
		
		this.listener = listeners[0];
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		
	}

	public void setListener(DrawListener l) {
		this.listener = l;
	}

	public void imageReady(boolean ready, BufferedImage img) {
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, null);
			listener.drawPreview((Graphics2D) g);
	}

}
