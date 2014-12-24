package mandel.paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPanel extends JPanel {

	private JButton[] layerBtns;

	public LayerPanel(Canvas2 canvas) {

		this.setLayout(new GridLayout(4, 1));

		layerBtns = new JButton[4];

		for (int i = 0; i < layerBtns.length; i++) {
			layerBtns[i] = new JButton("Layer" + i);
			add(layerBtns[i]);

			BufferedImage image = new BufferedImage(800, 600,
					BufferedImage.TYPE_INT_ARGB);

			layerBtns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					canvas.setImage(image);
				}
			});
		}
	}

}
