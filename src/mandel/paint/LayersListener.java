package mandel.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class LayersListener implements ActionListener {

	private int index;
	private Canvas2 canvas;
	private BufferedImage image;

	public LayersListener(int i, Canvas2 canvas, BufferedImage image) {
		this.index = i;
		this.canvas = canvas;
		this.image = image;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		canvas.setImage(image);
	}

}
