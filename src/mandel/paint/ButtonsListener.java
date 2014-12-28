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
	private NetworkModule net;
	
	public ButtonsListener(int i, Canvas2 canvas, NetworkModule net){
		this.index = i;
		this.canvas = canvas;
		this.net = net;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(index){
		case 0://pencil
			canvas.setListener(new PencilListener(net));
			break;
		case 1://line
			canvas.setListener(new StraightLineListener(canvas, net));
			break;
		case 2://rect
			canvas.setListener(new RectangleListener(canvas, net));
			break;
		case 3://fill rect
			canvas.setListener(new FillRectListener(canvas, net));
			break;
		case 4://oval
			canvas.setListener(new OvalListener(canvas, net));
			break;
		case 5://fill oval
			canvas.setListener(new FillOvalListener(canvas, net));			
			break;
		case 6://fill bucket
			try {
				canvas.setListener(new BucketFillListener(canvas));
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
			g.setBackground(new Color(255, 255, 255, 0));
			g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			canvas.repaint();
			break;
			
		}
		
		
		
		
	}

}
