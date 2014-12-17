package mandel.paint;

import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen
	
	private JButton[] buttons;
	private int numButtons;
	private JLabel width;
	
	public ButtonPanel(final Canvas2 canvas, OutputStream out){
		
		
		numButtons = 9;
		buttons = new JButton[numButtons];
		String[] buttonsText = {"Pencil", "Line", "Rectangle", "Fill Rect", "Oval", "Fill Oval", "Fill Bucket", "Color", "Clear"};
		
		for(int i = 0; i < numButtons; i++){
			buttons[i] = new JButton(buttonsText[i]);	
			buttons[i].addActionListener(new ButtonsListener(i, canvas, out));
			add(buttons[i]);
		}
		
		width = new JLabel("");
		add(width);
	}
	
	public void setWidthText(int w){
		width.setText("WIDTH: " + w);
	}
	
//	public Color getColor(){
//			return color;
//		}
}