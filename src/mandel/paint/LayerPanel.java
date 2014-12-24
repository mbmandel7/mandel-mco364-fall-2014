package mandel.paint;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPanel extends JPanel {
	
	private Canvas2 canvas;
	private JButton[] layerBtns;
	
	public LayerPanel(Canvas2 canvas){
		
		this.setLayout(new GridLayout(4, 1));
		
		layerBtns = new JButton[4];
		
		for(int i = 0; i < layerBtns.length; i++){
			layerBtns[i] = new JButton("Layer" + i);
			add(layerBtns[i]);
		}
	}

}
