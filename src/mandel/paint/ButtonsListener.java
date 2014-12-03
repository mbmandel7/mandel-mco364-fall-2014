package mandel.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;

public class ButtonsListener implements ActionListener {

	private Canvas2 canvas;
	private int index;
	
	public ButtonsListener(int i, Canvas2 canvas){
		this.index = i;
		this.canvas = canvas;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(index){
		case 0://pencil
			canvas.setListener(new PencilListener());
			break;
		case 1://line
			canvas.setListener(new StraightLineListener(canvas));
			break;
		case 2://rect
			canvas.setListener(new RectangleListener(canvas));
			break;
		case 3://fill rect
			
			break;
		case 4://oval
			
			break;
		case 5://fill oval
			
			break;
		case 6://color
			Color background = JColorChooser.showDialog(null, "Change Color", Color.BLACK); 
			if(background != null){
				canvas.setColor(background);
			}
			break;
		case 7://clear
			//canvas.setListener(new ClearListener(canvas));
			break;
			
		}
		
		
		
		
	}

}
