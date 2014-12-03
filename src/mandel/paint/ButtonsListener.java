package mandel.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ButtonsListener implements ActionListener {

	private Canvas2 canvas;
	private int index;
	private Color color;
	
	public ButtonsListener(int i, Canvas2 canvas){
		this.index = i;
		this.canvas = canvas;
		this.color = Color.BLACK;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(index){
		case 0://pencil
			canvas.setListener(new PencilListener());
			break;
		case 1://line
			canvas.setListener(new StraightLineListener(canvas, color));
			break;
		case 2://rect
			canvas.setListener(new RectangleListener(canvas, color));
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
				this.color = background;
			}
			break;
		case 7://clear
			Graphics2D g = (Graphics2D)canvas.getImage().getGraphics();
			g.setBackground(new Color(255, 255, 255, 0));
			g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			break;
			
		}
		
		
		
		
	}

}
