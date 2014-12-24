package mandel.paint;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen


public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private Canvas2 canvas;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		canvas = new Canvas2();
		add(canvas);
		
		add(new ButtonPanel(canvas, Color.BLACK), BorderLayout.NORTH);	
		
		add(new LayerPanel(canvas), BorderLayout.WEST);
	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
