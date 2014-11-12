package mandel.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WidthListener implements MouseWheelListener{
	
private Canvas canvas;
	
	public WidthListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotation= e.getWheelRotation();
		canvas.setWidth(rotation);
	}
	
		    
	

}
