package mandel.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WidthListener implements MouseWheelListener{
	
private Paint frame;
	
	public WidthListener(Paint frame) {
		this.frame = frame;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotation= e.getWheelRotation();
		frame.setLineWidth(rotation);
	}
	
		    
	

}
