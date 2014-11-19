package mandel.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PencilListener implements MouseMotionListener{
	
	private Canvas canvas;
	
	public PencilListener(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// the magic has to happen here
		canvas.drawLine(e.getPoint());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
