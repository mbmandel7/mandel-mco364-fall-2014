package mandel.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class ButtonsListener implements ActionListener {

	private Canvas2 canvas;
	private int index;
	private Color color;
	
	public ButtonsListener(int i, Canvas2 canvas, Color color){
		this.index = i;
		this.canvas = canvas;
		this.color = color;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(index){
		case 0://pencil
			canvas.setListener(new PencilListener(canvas, this.color));
			break;
		case 1://line
			canvas.setListener(new StraightLineListener(canvas, color));
			break;
		case 2://rect
			canvas.setListener(new RectangleListener(canvas, color));
			break;
		case 3://fill rect
			canvas.setListener(new FillRectListener(canvas, color));
			break;
		case 4://oval
			canvas.setListener(new OvalListener(canvas, color));
			break;
		case 5://fill oval
			canvas.setListener(new FillOvalListener(canvas, this.color));			
			break;
		case 6://fill bucket
			try {
				canvas.setListener(new BucketFillListener(canvas, this.color));
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Bucket Fill does not work");
			}
			break;
		case 7://color
			Color newColor = JColorChooser.showDialog(null, "Change Color", color); 
			if(newColor != null){
//				this.color = background;
				this.color = newColor;
				canvas.setColor(color);
			}
			break;
		case 8://clear
			Graphics2D g = (Graphics2D)canvas.getImage().getGraphics();
			g.setBackground(new Color(255, 255, 255, 1));
			g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			canvas.repaint();
			break;
			
		}
		
		
		
		
	}

}
