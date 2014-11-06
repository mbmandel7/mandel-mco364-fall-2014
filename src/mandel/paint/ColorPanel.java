package mandel.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	private int max = 6;
	private Color[] colors;
	
	public ColorPanel(Canvas canvas){
		setLayout(new FlowLayout());
		colors = new Color[max];
		buttons = new JButton[max];
		colors[0] = Color.RED;
		colors[1] = Color.ORANGE;
		colors[2] = Color.YELLOW;
		colors[3] = Color.GREEN;
		colors[4] = Color.BLUE;
		colors[5] = Color.MAGENTA;
		
		for(int i = 0; i < max; i++){
			buttons[i] = new JButton();
			buttons[i].setBackground(colors[i]);
			int color = i;
			buttons[i].addActionListener( new ActionListener (){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					canvas.setColor(colors[color]);					
				}
				
			});
			add(buttons[i]);
		}
	}

		
	
	
}
