package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;	
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculatorView extends JFrame implements ActionListener {
	JTextArea area;
	JTextField input;
	Calculator calc;

	public static void main(String [] args){
		new CalculatorView();

	}

	public CalculatorView(){
		super("Calculator");
		setSize(new Dimension(402, 402));
		setLayout(new BorderLayout());
		initializeComponents();

		setVisible(true);
	}
	private void initializeComponents() {
		calc = new Calculator();
		area = new JTextArea(20, 15);
		area.setEditable(false);
		area.setLineWrap(true);
		JScrollPane pane = new JScrollPane(area);
		
		
		
		input = new JTextField(15);
		input.addActionListener(this);
		add(pane, BorderLayout.NORTH);
		add(input, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input){
			area.setText(area.getText() + calc.calculate(input.getText()));
			input.setText("");
		}

	}
}
