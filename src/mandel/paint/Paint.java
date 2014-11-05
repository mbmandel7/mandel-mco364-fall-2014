package mandel.paint;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;

	public Paint() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Canvas canvas = new Canvas();
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
		add(canvas);

	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
