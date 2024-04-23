import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class CalculatorView implements Observer {
	private JFrame frame;
	private JTextField displayField;
    private JButton plusButton; // New class-level variable for the plus button

	public CalculatorView() {
		frame = new JFrame("Simple Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setLayout(new BorderLayout());

		displayField = new JTextField();
		displayField.setEditable(false);
		frame.add(displayField, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
		String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
		for (String label : buttonLabels) {
			JButton button = new JButton(label);
			
			button.addActionListener(new ButtonClickListener());
			if (label.equals("+")) {
                plusButton = button;
            }
			buttonPanel.add(button);
		}
		frame.add(buttonPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	public void update(Observable o, Object arg) {
		if (arg instanceof Double) {
			double result = (double) arg;
			displayField.setText(String.valueOf(result));
		}
	}

	public void addButtonListener(ActionListener listener) {
		Component[] components = frame.getContentPane().getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				((JButton) component).addActionListener(listener);
			}
		}
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			//possible fix
			if (command.equals("+")) {
				//frame.getContentPane().getComponent() //possible other fix
                plusButton.setBackground(Color.RED); // Change the background color of the plus button
            }
			// TODO
			//THIS IS WERE LOIGIC Happens
			
			//do not show operations call
				//instead updaate state of button to active/inactive
			
			// = means exec (call operate)
			// need to get 2 operands
			
			String currentText = displayField.getText();

			// Appsend the button's text to the current text in the display field
			displayField.setText(currentText + command); // Handle button clicks
		}
	}
}
