package mandel.paint;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{

	private JButton[] buttons;
	private int max = 6;
	private Color[] colors;
	
	public ColorPanel(){
		setLayout(new FlowLayout());
		colors[0] = Color.RED;
		colors[1] = Color.ORANGE;
		colors[2] = Color.YELLOW;
		
		for(int i = 0; i < max; i++){
			buttons[i] = new JButton();
			buttons[i].addActionListener(new ButtonListener() implements ActionListener{
				
			});
			add(buttons[i]);
		}
	}

		
	}
	
}
