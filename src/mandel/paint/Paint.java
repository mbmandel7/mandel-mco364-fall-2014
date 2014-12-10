package mandel.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen


public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private int width = 0;
	private Canvas2 canvas;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		canvas = new Canvas2();
		add(canvas);
		
		add(new ButtonPanel(canvas), BorderLayout.NORTH);
		
		
		
//		//draw with pencil
//		PencilListener draw = new PencilListener(canvas);
//		canvas.addMouseMotionListener(draw);
//		
//		ClickListener click = new ClickListener(canvas);
//		canvas.addMouseListener(click);
//		
//		//change width
//		WidthListener width = new WidthListener(this);
//		canvas.addMouseWheelListener(width);
//		
//		//change color
//		colors = new ColorPicker(canvas);
//		add(colors, BorderLayout.NORTH);
	}
	
//	public void setLineWidth(int w){
//		if(width + w > 0){
//			width += w;
//		}		
//		canvas.setWidth(width);
//		buttons.setWidthText("WIDTH: " + width);
//	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
