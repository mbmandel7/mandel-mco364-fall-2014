package mandel.paint;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker extends JColorChooser implements ChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public ColorPicker(Canvas canvas){
		this.canvas = canvas;
		this.getSelectionModel().addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		Color color = this.getColor();
		canvas.setColor(color);
	}	
}