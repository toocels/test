import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

// CLIENT CLIENT CLIENT CLIENT CLIENT CLIENT CLIENT

public class Client {

	static ObjectOutputStream output;
	static ObjectInputStream input;
	static String msg;
	static String serverIP = "";
	static Socket socket;
	static int port = 8888;

	static JLabel l;
	static JTextField tf;

	public static void main(String args[]) {
		System.out.println("Wassuppp");

		createFrame();

		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), port);
			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {System.out.println(e);}
		System.out.println("Conencted!");

		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					output.writeObject(tf.getText());
					output.flush();
				} catch (Exception ex) {System.out.println(ex);}
				tf.setText("");
			}
		});

		while (true) {
			try {
				msg = (String)input.readObject();
				System.out.println(msg);
			} catch (Exception e) {System.out.println(e);}
		}
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

