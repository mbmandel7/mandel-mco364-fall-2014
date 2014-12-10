package mandel.paint.message;

import java.awt.Color;
import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {
	
	
	public ClearMessage(){
		
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setBackground(new Color(255, 255, 255, 0));
		g.clearRect(0, 0, 600, 800);
	}

}
