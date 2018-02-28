package com.application;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Chandu A
 *
 */
public class Application {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		JFrame frame = new JFrame("MSAccess Database Connection");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Input DB Connection URL:");

		JTextField textFieldUserName = new JTextField(50);

		JButton button = new JButton();
		button.setText("Connect");

		panel.add(label);
		panel.add(textFieldUserName);
		panel.add(button);

		frame.add(panel);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JDialog d = new JDialog(frame, "Status", true);
				JLabel label = new JLabel("");
				boolean connect = DataBaseConnect.connect(textFieldUserName.getText());

				String status = connect ? "Connection Successful" : "Connection failed";
				label.setText(status);
				d.add(label);
				d.setSize(200, 150);
				d.setLocationRelativeTo(frame);
				d.setVisible(true);
			}
		});

	}

}
