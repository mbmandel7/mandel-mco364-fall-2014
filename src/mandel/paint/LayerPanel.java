package mandel.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPanel extends JPanel {

	private JButton[] layerBtns;
	private BufferedImage[] images;

	public LayerPanel(Canvas2 canvas) {

		this.setLayout(new GridLayout(4, 1));
		
		images = new BufferedImage[4];

		layerBtns = new JButton[4];

		for (int i = 0; i < layerBtns.length; i++) {
			layerBtns[i] = new JButton("Layer" + i);
			this.add(layerBtns[i]);

			BufferedImage image = new BufferedImage(800, 600,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D)image.getGraphics();
			g.setBackground(new Color(255, 255, 0, 0));
			images[i] = image;

			layerBtns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					canvas.setImage(image);
				}
			});
		}
		
		canvas.setImages(images);
		canvas.setImage(images[0]);
	}
	
//	public BufferedImage[] getImages(){
//		return this.images;
//	}

}
