import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Mazungumzo extends JFrame implements ActionListener {
	ChatClient client;
	JTextArea pane;
	JTextField input;
	
	public static void main(String[] args){
		new Mazungumzo();
	}
	
	public Mazungumzo(){
		super("Mazungumzo");
		setSize(new Dimension(400, 500));
		setLayout(new BorderLayout());
		initializeComponents();
		setVisible(true);
		String ip = JOptionPane.showInputDialog("What's the server's IP address");
		client = new ChatClient(ip);
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTask(), 0, 500);
		setVisible(true);
		
	}
	private void initializeComponents(){
		pane = new JTextArea(20, 20);
		pane.setEditable(false);
		pane.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(pane);
		add(scroll, BorderLayout.NORTH);
		
		input = new JTextField(30);
		input.addActionListener(this);
		add(input, BorderLayout.SOUTH);
	}
	
	class UpdateTask extends TimerTask{
		@Override
		public void run() {
			update();
		}
	}
	private void update(){
		String text = client.receive();
		while (text != null) {
			pane.setText(pane.getText() + "\n" + text);
			text = client.receive();
		}
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == input){
			client.send(input.getText());
			input.setText("");
		}
	}
	
}
