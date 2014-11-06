package mandel.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Canvas canvas = new Canvas();
		add(canvas);

		DrawListener draw = new DrawListener(canvas);
		canvas.addMouseMotionListener(draw);
		
		ClickListener click = new ClickListener(canvas);
		canvas.addMouseListener(click);
		
		ColorPanel colors = new ColorPanel(canvas);
		add(colors, BorderLayout.NORTH);

	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
