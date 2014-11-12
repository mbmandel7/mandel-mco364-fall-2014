package mandel.paint;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		
		ColorPicker picker = new ColorPicker(canvas);
		JButton colorPicker = new JButton();
		colorPicker.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	add(picker, BorderLayout.SOUTH);
			}			
		});
		add(colorPicker, BorderLayout.NORTH);
		
		
		
		WidthListener width = new WidthListener(canvas);
		canvas.addMouseWheelListener(width);
	}

	public static void main(String args[]) {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
