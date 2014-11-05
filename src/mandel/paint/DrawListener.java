package mandel.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener{
	
	private Canvas canvas;
	
	public DrawListener(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// the magic has to happen here
		canvas.setPoint(e.getPoint());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
