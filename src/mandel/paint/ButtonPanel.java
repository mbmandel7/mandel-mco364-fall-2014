package mandel.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen
	
	private JButton[] buttons;
	private int numButtons;
	
	public ButtonPanel(Canvas2 canvas){
		
		numButtons = 8;
		buttons = new JButton[numButtons];
		String[] buttonsText = {"Pencil", "Line", "Rectangle", "Fill Rect", "Oval", "Fill Oval", "Color", "Clear"};
		
		for(int i = 0; i < numButtons; i++){
			buttons[i] = new JButton(buttonsText[i]);
			buttons[i].addActionListener(new ButtonsListener(i, canvas));
			add(buttons[i]);
		}
		
	}
}