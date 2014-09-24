package mandel.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame extends JFrame {

	private JLabel chat;
	private JTextArea text;
	private JButton send;
	private ChatClient client;

	public Frame() {

		setTitle("Chat");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);

		chat = new JLabel();
		this.add(BorderLayout.CENTER, chat);

		text = new JTextArea();

		send = new JButton("Send");
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String message = chat.getText() + "\n";
				chat.setText(chat.getText() + message);
				OutputStream out;
				try{
					out = client.getSocket().getOutputStream();
					out.write(message.getBytes());
					out.flush();
				}catch(IOException e){
					e.printStackTrace();
				}
			}

		});

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(send, BorderLayout.EAST);

		this.add(BorderLayout.SOUTH, panel);
	}

	public void setChat(String message) {
		this.chat.setText(chat.getText() + message);
	}

	// public void updateChat(String message) {
	// this.chat.setText(chat.getText() + "\n" + message);
	// //but the message can also come from the other computer
	// }

}
