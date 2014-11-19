package mandel.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel widthLabel;
	
	public ButtonPanel(final Canvas canvas){
		
		//color
		final JButton colorPicker = new JButton();
		colorPicker.setBackground(Color.BLACK);
		colorPicker.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color initialBackground = colorPicker.getBackground();
				Color background = JColorChooser.showDialog(null, "Change Color", initialBackground); 
				if(background != null){
					colorPicker.setBackground(background);
					canvas.setColor(background);
				}
			//	add(picker, BorderLayout.SOUTH);
			}			
		});
		add(colorPicker);
		
		//line width
		widthLabel = new JLabel("WIDTH: " + 1);
		add(widthLabel);		
		
		//draw rectangle
		JButton shape = new JButton("Rectangle");
		shape.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				canvas.("rectangle");
			}			
		});
		add(shape);
		
		//draw line
		JButton line = new JButton("Line");
		shape.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				canvas.setTask("line");
			}			
		});
		add(line);
	}
	
	public void setWidthText(String s){
		widthLabel.setText(s);
	}
	
	
}