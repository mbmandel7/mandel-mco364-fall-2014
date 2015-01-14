package mandel.paint;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class WidthListener implements MouseWheelListener{
	
private Paint paint;
private int width;
	
	public WidthListener(Paint p) {
		this.paint = p;
		width = 1;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotation= e.getWheelRotation();
		if (width + rotation > 0) {
			width += rotation;
		}
		paint.setWidth(width);
	}
	
		    
	

}
