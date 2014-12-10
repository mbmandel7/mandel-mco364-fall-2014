package mandel.paint;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen
	
	private JButton[] buttons;
	private int numButtons;
	
	public ButtonPanel(final Canvas2 canvas){
		
		
		numButtons = 8;
		buttons = new JButton[numButtons];
		String[] buttonsText = {"Pencil", "Line", "Rectangle", "Fill Rect", "Oval", "Fill Oval", "Color", "Clear"};
//		DrawListener[] listeners = {new PencilListener(), new StraightLineListener(canvas, color), new RectangleListener(canvas, color)};
		
		for(int i = 0; i < numButtons; i++){
			buttons[i] = new JButton(buttonsText[i]);
//			buttons[i].addActionListener(new ActionListener(){
//
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					// TODO Auto-generated method stub
//					final int a = i;
//					final DrawListener l = listeners[i];
//					canvas.setListener(listeners[i]);
//				}
//				
//			});
			
			
			buttons[i].addActionListener(new ButtonsListener(i, canvas));
			add(buttons[i]);
		}
		
		JLabel width = new JLabel("");
		add(width);
	}
	
//	public Color getColor(){
//			return color;
//		}
}