package mandel.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientFrame extends JFrame {

	private JTextArea chat;
	private JTextField text;
	private JButton send;
	private Client client;

	public ClientFrame() throws UnknownHostException, IOException {
		
		client = new Client();

		setTitle("Chat Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);

		chat = new JTextArea();
		this.add(BorderLayout.CENTER, chat);

		text = new JTextField();

		send = new JButton("Send");
		send.addActionListener(new ActionListener() {

		OutputStream out = client.getSocket().getOutputStream();
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String message = text.getText() + "\n";
				chat.setText(chat.getText() + message);		
				text.setText(null);
				
				try {
					out.write(message.getBytes());
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
}
