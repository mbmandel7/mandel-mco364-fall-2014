package mandel.paint;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PencilListenerObs implements MouseMotionListener, MouseListener{
	
	private DrawListener drawing;
	
	private Point startPoint;
	private Point movingPoint;
	private Point endPoint;
	
	public PencilListenerObs(DrawListener drawing){
		this.drawing = drawing;
		drawing.setEndPoint(endPoint);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.movingPoint = e.getPoint();
		drawing.drawNextPoint(movingPoint);
		
//		// the magic has to happen here
//		canvas.drawLine(e.getPoint());
//		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.startPoint = e.getPoint();
		drawing.setStartPoint(startPoint);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.endPoint = e.getPoint();
	}

}
