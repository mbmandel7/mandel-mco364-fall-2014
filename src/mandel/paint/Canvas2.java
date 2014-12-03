package mandel.paint;

import java.awt.Color;
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
	private Color color;

	private DrawListener listener;

	public Canvas2() {
//		DrawListener[] listeners = new DrawListener[6];
//		listeners[0] = new RectangleListener(this);
		
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;
		
		setListener(new StraightLineListener(this, Color.BLACK));
		
		
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public void setListener(DrawListener l) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = l;
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	public DrawListener getListener(){
		return this.listener;
	}
	
	public void setColor(Color c){
		this.color = c;
	}

	@Override
	public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, null);
			listener.drawPreview((Graphics2D) g);
	}

}
