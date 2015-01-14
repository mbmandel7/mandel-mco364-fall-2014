package mandel.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import mandel.paint.message.PaintMessage;
import mandel.paint.message.PaintMessageFactory;

public class ConnectionThread extends Thread {

	private Canvas canvas;
	private OnlineNetworkModule net;

	public ConnectionThread(Canvas canvas, OnlineNetworkModule net) throws UnknownHostException, IOException {
		this.canvas = canvas;
		this.net = net;
	}

	@Override
	public void run() {
		InputStream in;
		try {
			in = net.getConnection().getSocket().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PaintMessageFactory messageFactory = new PaintMessageFactory(canvas);
			PaintMessage message;
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					message = messageFactory.getMessage(line);
					message.apply((Graphics2D) canvas.getImage().getGraphics());
					canvas.repaint();
				} catch (Exception e) {

				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
