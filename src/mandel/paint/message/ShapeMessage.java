package mandel.paint.message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class ShapeMessage implements PaintMessage {
	
	private String type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	private int stroke;
	private boolean fill;
	
	public ShapeMessage(String type, int x, int y, int width, int height, int color, int stroke, boolean fill) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.stroke = stroke;
		this.fill = fill;
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub

		g.setColor(new Color(this.color));
		g.setStroke(new BasicStroke(this.stroke, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		switch(type){
		case "RECT":
			if(fill){
				g.fillRect(x, y, width, height);
			}else{
				g.drawRect(x, y, width, height);
			}
			break;
		case "OVAL":
			if(fill){
				g.fillOval(x, y, width, height);
			}else{
				g.drawOval(x, y, width, height);
			}
			break;
		}


	}

}
