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

	private DrawListener listener;
	private Color color;
	private int width;

	public Canvas2() {
		
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.color = Color.BLACK;
		setListener(new PencilListener(this, color));
		
		WidthListener width = new WidthListener(this);
		this.addMouseWheelListener(width);

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setListener(DrawListener l) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = l;
		this.listener.setColor(this.color);
		this.listener.setWidth(this.width);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}
	
	public void setColor(Color c){
		this.color = c;
		this.listener.setColor(color);
	}	

	public void setWidth(int w){
		if(width + w > 0){
			width += w;
		}		
		this.listener.setWidth(width);
//		buttons.setWidthText("WIDTH: " + width);
	}
	
	public DrawListener getListener() {
		return this.listener;
	}


	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		listener.drawPreview((Graphics2D) g);
	}

}
