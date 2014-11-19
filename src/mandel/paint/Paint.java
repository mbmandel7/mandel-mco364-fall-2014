package mandel.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen


public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private int width = 0;
	private Canvas canvas;
	private ButtonPanel buttons;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		canvas = new Canvas();
		add(canvas);

		PencilListener draw = new PencilListener(canvas);
		canvas.addMouseMotionListener(draw);
		
		ClickListener click = new ClickListener(canvas);
		canvas.addMouseListener(click);
		
		WidthListener width = new WidthListener(this);
		canvas.addMouseWheelListener(width);
		
		buttons = new ButtonPanel(canvas);
		add(buttons, BorderLayout.NORTH);
	}
	
	public void setLineWidth(int w){
		if(width + w > 0){
			width += w;
		}		
		canvas.setWidth(width);
		buttons.setWidthText("WIDTH: " + width);
	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
