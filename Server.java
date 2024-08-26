import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

// SERVER SERVER SERVER SERVER SERVER SERVER SERVER

public class Server {

	static ObjectOutputStream output;
	static ObjectInputStream input;
	static String msg;
	static String serverIP;
	static Socket socket;
	static ServerSocket server;
	static int port = 8888;

	static JLabel l;
	static JTextField tf;

	public static void main(String args[]) {
		System.out.println("Wassuppp");

		createFrame();

		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					output.writeObject(tf.getText());
					output.flush();
				} catch (Exception ed) {System.out.println(ed);}
				tf.setText("");
			}
		});

		try {
			server = new ServerSocket(port, 50);
			System.out.println("Waiting for connection");
			while (true)
				try {
					socket = server.accept();		//estfblishes connection and waits for the client
					System.out.println("Now Connected to " + socket.getInetAddress().getHostName());

					output = new ObjectOutputStream(socket.getOutputStream());
					output.flush();
					input = new ObjectInputStream(socket.getInputStream());

					while (true) {
						msg = (String)input.readObject();
						System.out.println(msg);
					}
				} catch (Exception e) {System.out.println(e);}
		} catch (IOException e) {System.out.println(e);}
	}

	static void createFrame() {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		l = new JLabel("A label");
		tf = new JTextField("An area");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 500);

		p.add(l);
		p.add(tf);
		f.add(p);

		f.setTitle("Chattt");
		f.setVisible(true);
	}
}
