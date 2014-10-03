package mandel.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFrame extends JFrame {

	private JTextArea chat;
	private JTextField text;
	private JButton send;

	public ServerFrame() {

		setTitle("Chat Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);

		chat = new JTextArea();
		this.add(BorderLayout.CENTER, chat);

		text = new JTextField();

		send = new JButton("Send");
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				chat.setText(chat.getText() + "\n" + text.getText());
				text.setText(null);
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
}
