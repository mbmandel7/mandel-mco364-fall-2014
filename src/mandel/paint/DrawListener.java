package mandel.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseListener, MouseMotionListener {
	
	void drawPreview(Graphics2D g);

	void setColor(Color c);

	void setWidth(int width);
	
}
 