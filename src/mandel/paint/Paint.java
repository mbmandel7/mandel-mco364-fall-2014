package mandel.paint;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import mandel.paint.message.PaintMessage;
import mandel.paint.message.PaintMessageFactory;

//draw straight line, pencil, rectangle, oval, fillrect, filloval, clear screen


public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private int width = 0;
	private Canvas2 canvas;
	private Connection con;

	public Paint() throws UnknownHostException, IOException {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		con = new Connection();
		
		canvas = new Canvas2(con);
		add(canvas);
		
		add(new ButtonPanel(canvas, con.getSocket().getOutputStream()), BorderLayout.NORTH);
		
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void networkDraw(PaintMessage msg){
		canvas.networkDraw(msg);
	}

	public static void main(String args[]) throws UnknownHostException, IOException {
		Paint p = new Paint();
		p.setVisible(true);

		PaintMessageFactory factory = new PaintMessageFactory();
		
		InputStream in = p.getConnection().getSocket().getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			PaintMessage message = factory.getMessage(line);
			p.networkDraw(message);
		}
	}
	
}
