package mandel.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RectangleListener implements DrawListener {

	private Point startPoint;
	private Point movingPoint;

	private Canvas2 canvas;

	public RectangleListener(Canvas2 c) {
		this.canvas = c;
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point endPoint = e.getPoint();		
		Graphics g = canvas.getImage().getGraphics();
		
		int width = Math.abs(startPoint.x - endPoint.x);
		int length = Math.abs(startPoint.y - endPoint.y);
		
		if(endPoint.x < startPoint.x){//2 and 3
			if(endPoint.y < startPoint.y){//2
				g.drawRect(endPoint.x, endPoint.y, width, length);//2				
			}else{//3
				g.drawRect(endPoint.x, startPoint.y, width, length);//3				
			}			
		}else{
			if(endPoint.y < startPoint.y){//4
				g.drawRect(startPoint.x, endPoint.y, width, length);//4				
			}else{//1
				g.drawRect(startPoint.x, startPoint.y, width, length);//1				
			}
		}
		startPoint = null;
		canvas.repaint();
	}

	public void drawRectOnCalculatedCoordinates(Point p2) {
		Graphics g = canvas.getImage().getGraphics();
		if(p2.x < startPoint.x){//2 and 3
			if(p2.y < startPoint.y){//2
				g.drawRect(p2.x, p2.y, Math.abs(startPoint.x - p2.x), Math.abs(startPoint.y - p2.y));//2				
			}else{//3
				g.drawRect(p2.x, startPoint.y, Math.abs(startPoint.x - p2.x), Math.abs(startPoint.y - p2.y));//3				
			}			
		}else{
			if(p2.y < startPoint.y){//4
				g.drawRect(startPoint.x, p2.y, Math.abs(startPoint.x - p2.x), Math.abs(startPoint.y - p2.y));//4				
			}else{//1
				g.drawRect(startPoint.x, startPoint.y, Math.abs(startPoint.x - p2.x), Math.abs(startPoint.y - p2.y));//1				
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.movingPoint = e.getPoint();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		if (startPoint != null) {
			if(movingPoint.x < startPoint.x){//2 and 3
				if(movingPoint.y < startPoint.y){//2
					g.drawRect(movingPoint.x, movingPoint.y, Math.abs(startPoint.x - movingPoint.x), Math.abs(startPoint.y - movingPoint.y));//2				
				}else{//3
					g.drawRect(movingPoint.x, startPoint.y, Math.abs(startPoint.x - movingPoint.x), Math.abs(startPoint.y - movingPoint.y));//3				
				}			
			}else{
				if(movingPoint.y < startPoint.y){//4
					g.drawRect(startPoint.x, movingPoint.y, Math.abs(startPoint.x - movingPoint.x), Math.abs(startPoint.y - movingPoint.y));//4				
				}else{//1
					g.drawRect(startPoint.x, startPoint.y, Math.abs(startPoint.x - movingPoint.x), Math.abs(startPoint.y - movingPoint.y));//1				
				}
			}
		}
	}

}
