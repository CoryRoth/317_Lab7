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
	private JButton minusButton; // New class-level variable for the plus button
	private JButton divideButton; // New class-level variable for the plus button
	private JButton multButton; // New class-level variable for the plus button
	private JButton sqButton; // New class-level variable for the plus button
	private JButton sqrtButton; // New class-level variable for the plus button

	private Double firstOperand;
	private String operation;
	private Double secondOperand;
	private boolean resetInfo = false;
	private CalculatorModel model;
	private Color color;

	public CalculatorView() {
		this.model = new CalculatorModel();
		frame = new JFrame("Simple Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setLayout(new BorderLayout());

		displayField = new JTextField();
		displayField.setEditable(false);
		frame.add(displayField, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
		String[] buttonLabels = { "M+", "M-", "MR", "MC", "Del", "Clr", "sqrt", "sq", "7", "8", "9", "/", "4", "5", "6",
				"*", "1", "2", "3", "-", "0", ".", "=", "+" };
		for (String label : buttonLabels) {
			JButton button = new JButton(label);

			button.addActionListener(new ButtonClickListener());
			if (label.equals("+")) {
				plusButton = button;
			} else if (label.equals("-")) {
				minusButton = button;
			} else if (label.equals("*")) {
				multButton = button;
			} else if (label.equals("/")) {
				divideButton = button;
			} else if (label.equals("sq")) {
				sqButton = button;
			} else if (label.equals("sqrt")) {
				sqrtButton = button;
			}
			buttonPanel.add(button);
			color = button.getBackground();
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

			String currentText = displayField.getText();

			// TODO check for errors like DBZ

			if (command.equals("=")) {
				Double output = null;
				divideButton.setBackground(color); // Change the background color of the plus button
				plusButton.setBackground(color); // Change the background color of the plus button
				multButton.setBackground(color); // Change the background color of the plus button
				minusButton.setBackground(color); // Change the background color of the plus button
				sqButton.setBackground(color); // Change the background color of the plus button
				sqrtButton.setBackground(color); // Change the background color of the plus button

				if (operation.equals("sq")) {
					secondOperand = (double) 0;
					output = CalculatorModel.calculate(firstOperand, secondOperand, operation);
				} else if (operation.equals("sqrt")) {
					secondOperand = (double) 0;

					output = CalculatorModel.calculate(firstOperand, secondOperand, operation);
				} else {
					// TODO only one operand enter case
					secondOperand = Double.valueOf(currentText);
					output = CalculatorModel.calculate(firstOperand, secondOperand, operation);
				}
				displayField.setText(output.toString()); // Handle button
				operation = command;
			} else if (command.equals("+")) {
				// frame.getContentPane().getComponent() //possible other fix
				firstOperand = Double.valueOf(currentText);
				operation = command;
				plusButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("-")) {
				firstOperand = Double.valueOf(currentText);
				operation = command;
				minusButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("/")) {
				// frame.getContentPane().getComponent() //possible other fix
				firstOperand = Double.valueOf(currentText);
				operation = command;
				divideButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("*")) {
				// frame.getContentPane().getComponent() //possible other fix
				firstOperand = Double.valueOf(currentText);
				operation = command;
				multButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("sq")) {
				// frame.getContentPane().getComponent() //possible other fix
				firstOperand = Double.valueOf(currentText);
				operation = command;
				sqButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("sqrt")) {
				// frame.getContentPane().getComponent() //possible other fix
				firstOperand = Double.valueOf(currentText);
				operation = command;
				sqrtButton.setBackground(Color.RED); // Change the background color of the plus button
				resetInfo = true;
			} else if (command.equals("Del")) {
				currentText = currentText.substring(0, currentText.length() - 1);
				displayField.setText(currentText);

			} else if (command.equals("Clr")) {
				displayField.setText(" ");

			} else if (command.equals("M+")) {
				if (operation.equals("=")) {
					Double currentMemory = model.getMemory();
					model.setMemory(currentMemory + Double.valueOf(currentText));
				} else {
					// TODO throw error
				}

			} else if (command.equals("M-")) {
				if (operation.equals("=")) {
					Double currentMemory = model.getMemory();
					model.setMemory(currentMemory - Double.valueOf(currentText));
				} else {
					// TODO throw error
				}
			} else if (command.equals("MR")) {
				Double currentMemory = model.getMemory();
				displayField.setText(currentMemory.toString());

			} else if (command.equals("MC")) {
				model.setMemory(0);

			} else {
				if (resetInfo) {
					displayField.setText(command);

					resetInfo = false;
				} else {
					displayField.setText(currentText + command);
				} // Handle button clicks
			}

			// NOTES
			// FEATURES
			// TODO decide on cummative operations or only allowing one operation at a time

			// TODO set button to listen to on release????

			// TODO don't disply operations

			// TODO operations buttons remain clicked

			// TODO all operations must end w/ = to be executed

			// FUNCTIONS
			// TODO MEMORY

			// TODO DELETE

			// possible fix
			// TODO
			// THIS IS WERE LOIGIC Happens

			// do not show operations call
			// instead updaate state of button to active/inactive

			// = means exec (call operate)
			// need to get 2 operands

			// Appsend the button's text to the current text in the display field
		}
	}
}
