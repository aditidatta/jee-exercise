package joptionpane;

import javax.swing.JOptionPane;



public class TestJOptionPane {

	public static void main(String[] args) {
		
		String input;
		input = JOptionPane.showInputDialog("Enter initial balance:");
		double balance = Double.parseDouble(input);
		
		String init_balance = "Your initial balance is "+balance;
		JOptionPane.showMessageDialog(null, init_balance, "Message", JOptionPane.PLAIN_MESSAGE);
		
		balance = balance - 50;
		String rem_balance = init_balance+"\nYour current balance is "+balance;
		JOptionPane.showMessageDialog(null, rem_balance, "Message", JOptionPane.PLAIN_MESSAGE);

		System.exit(0);
	}

}
