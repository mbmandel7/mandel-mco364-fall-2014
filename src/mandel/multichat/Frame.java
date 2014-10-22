package mandel.multichat;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Frame extends JFrame {

	private static final long serialVersionUID = -8212878251981742233L;
	private JTextArea chat;

	public Frame() throws IOException {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);

		chat = new JTextArea();
		this.add(chat);
	}

	public void setText(String msg) {
		chat.setText(chat.getText() + msg);
	}

}
