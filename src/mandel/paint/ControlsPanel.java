package mandel.paint;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlsPanel extends JPanel{
	//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen

	private JButton[] buttons;
	private final int numButtons;
	
	public ControlsPanel(){
		
		numButtons = 7;
		buttons[0] = new JButton("Straight Line");
		buttons[1] = new JButton("Pencil");
		buttons[2] = new JButton("Rectangle");
		buttons[3] = new JButton("Oval");
		buttons[4] = new JButton("Fill Rectangle");
		buttons[5] = new JButton("Fill Oval");
		buttons[6] = new JButton("Clear Screen");
		
		for(JButton b: buttons){
			b.addActionListener(new ButtonsListener());
		}
	}
	

}
