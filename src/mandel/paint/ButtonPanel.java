package mandel.paint;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen
	
	private JButton[] buttons;
	private int numButtons;
	private JLabel width;
	
	public ButtonPanel(final Canvas canvas, NetworkModule net){
		
		
		numButtons = 9;
		buttons = new JButton[numButtons];
		String[] buttonsText = {"Pencil", "Line", "Rectangle", "Fill Rect", "Oval", "Fill Oval", "Bucket Fill", "Color", "Clear"};
		
		for(int i = 0; i < numButtons; i++){
			buttons[i] = new JButton(buttonsText[i]);	
			buttons[i].addActionListener(new ButtonsListener(i, canvas, net));
			add(buttons[i]);
		}
		
		width = new JLabel("WIDTH: 1");
		add(width);
		
		canvas.setListener(new PencilListener(net));
	}
	
	public void setWidthText(int w){
		this.width.setText("WIDTH: " + w);
	}
	
//	public Color getColor(){
//			return color;
//		}
}