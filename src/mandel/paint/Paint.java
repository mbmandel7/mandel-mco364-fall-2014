package mandel.paint;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import mandel.paint.message.PaintMessage;
import mandel.paint.message.PaintMessageFactory;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private ButtonPanel btns;
	private NetworkModule net;
	
	public Paint() throws IOException {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		canvas = new Canvas(this);
		add(canvas);

		 net = new LoopbackNetworkModule(canvas);
//		net = new OnlineNetworkModule(canvas);

		btns = new ButtonPanel(canvas, net);
		add(btns, BorderLayout.NORTH);

		
	}
	
	public void setWidth(int width){
		btns.setWidthText(width);
		canvas.setWidth(width);
	}

	public Canvas getCanvas() {
		return this.canvas;
	}

	public static void main(String args[]) throws IOException {
		Paint p = new Paint();
		p.setVisible(true);
	}
}
