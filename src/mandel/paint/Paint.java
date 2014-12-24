package mandel.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen


public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private Canvas2 canvas;

	public Paint() throws IOException {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Connection conn = new Connection();
		
		
		canvas = new Canvas2(conn);
		add(canvas);
		
		add(new ButtonPanel(canvas, new OnlineNetwokModule(conn.getSocket().getOutputStream())), BorderLayout.NORTH);	
		
		
	}

	public static void main(String args[]) throws IOException {
		Paint p = new Paint();
		p.setVisible(true);

	}

}
