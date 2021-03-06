//Authors: YOUR NAME HERE
//Date: 6/24/2021
//Description: YOUR DESCRIPTION HERE

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CalcGUI implements ActionListener {
	
	// You can change the name of these variables if you would like
	// We will need these Strings later to set up the action listener
	String firstNum;
	String operand;
	String secondNum;
	
	
	// You can change this variable "input" name as well if you would like
	static JTextField input;
	
	public static void main(String[] args) throws IOException  {
		
		//Color
		Color Background = new Color(50, 50, 50);
		
		
		//Create a CalcGUI object called myCalculator
		CalcGUI myCalculator = new CalcGUI();
		
		//Create the JFrame
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(265, 570);
		
		//Create the JTextField
		input = new JTextField();
		input.setEditable(false);
		input.setVisible(true);
		input.setPreferredSize(new Dimension(235, 40));
		
		//Image
		ImageIcon image = new ImageIcon("/Users/totallyfarhan/Desktop/Programming/Projects/Java/four_function_calculator/four_function_calculator/pics/icon.png");
		JLabel picture = new JLabel(image);
		
		//Create a JPanel
		JPanel panel = new JPanel();
		panel.setVisible(true);
		
		//Title
		JLabel title = new JLabel("Calculator");
		title.setFont(new Font("Roboto", 20, 20));
		title.setForeground(Color.white);
		
		//Create JButtons
		JButton zeroButton = new JButton("0");
		zeroButton.setPreferredSize(new Dimension(57, 57));
		JButton oneButton = new JButton("1");
		oneButton.setPreferredSize(new Dimension(57, 57));
		JButton twoButton = new JButton("2");
		twoButton.setPreferredSize(new Dimension(57, 57));
		JButton threeButton = new JButton("3");
		threeButton.setPreferredSize(new Dimension(57, 57));
		JButton fourButton = new JButton("4");
		fourButton.setPreferredSize(new Dimension(57, 57));
		JButton fiveButton = new JButton("5");
		fiveButton.setPreferredSize(new Dimension(57, 57));
		JButton sixButton = new JButton("6");
		sixButton.setPreferredSize(new Dimension(57, 57));
		JButton sevenButton = new JButton("7");
		sevenButton.setPreferredSize(new Dimension(57, 57));
		JButton eightButton = new JButton("8");
		eightButton.setPreferredSize(new Dimension(57, 57));
		JButton nineButton = new JButton("9");
		nineButton.setPreferredSize(new Dimension(57, 57));
		JButton addButton = new JButton("+");
		addButton.setPreferredSize(new Dimension(57, 57));
		JButton subtractButton = new JButton("-");
		subtractButton.setPreferredSize(new Dimension(57, 57));
		JButton multiplyButton = new JButton("??");
		multiplyButton.setPreferredSize(new Dimension(57, 57));
		JButton divideButton = new JButton("??");
		divideButton.setPreferredSize(new Dimension(57, 57));
		JButton clearButton = new JButton("AC");
		clearButton.setPreferredSize(new Dimension(57, 57));
		JButton enterButton = new JButton("=");
		enterButton.setPreferredSize(new Dimension(235, 57));
		JButton decimalButton = new JButton(".");
		decimalButton.setPreferredSize(new Dimension(57, 57));
		
		//Add the buttons and text field to the panel
		panel.add(title);
		panel.add(input);
		panel.add(sevenButton);
		panel.add(eightButton);
		panel.add(nineButton);
		panel.add(addButton);
		panel.add(fourButton);
		panel.add(fiveButton);
		panel.add(sixButton);
		panel.add(subtractButton);
		panel.add(oneButton);
		panel.add(twoButton);
		panel.add(threeButton);
		panel.add(multiplyButton);
		panel.add(decimalButton);
		panel.add(zeroButton);
		panel.add(clearButton);
		panel.add(divideButton);
		panel.add(enterButton);
		panel.add(picture);
		
		panel.setBackground(Background);
		
		//Add the panel to the frame
		frame.add(panel);
		frame.setVisible(true);
		
		//Add action listener to all off the buttons
		zeroButton.addActionListener(myCalculator);
		oneButton.addActionListener(myCalculator);
		twoButton.addActionListener(myCalculator);
		threeButton.addActionListener(myCalculator);
		fourButton.addActionListener(myCalculator);
		fiveButton.addActionListener(myCalculator);
		sixButton.addActionListener(myCalculator);
		sevenButton.addActionListener(myCalculator);
		eightButton.addActionListener(myCalculator);
		nineButton.addActionListener(myCalculator);
		addButton.addActionListener(myCalculator);
		subtractButton.addActionListener(myCalculator);
		multiplyButton.addActionListener(myCalculator);
		divideButton.addActionListener(myCalculator);
		decimalButton.addActionListener(myCalculator);
		clearButton.addActionListener(myCalculator);
		enterButton.addActionListener(myCalculator);
	}
	
	//Default constructor
	CalcGUI() {
		firstNum = secondNum = operand = "";
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		double result;
		
		if ((buttonPressed.charAt(0) >= '0' && buttonPressed.charAt(0) <= '9') || buttonPressed.charAt(0) == '.') {
			if (operand.equals("")) {
				firstNum = firstNum + buttonPressed;
				input.setText(firstNum);
			}
			else {
				secondNum = secondNum + buttonPressed;
				input.setText(firstNum + operand + secondNum);
			}
		}
		
		else if (buttonPressed.equals("??") || buttonPressed.equals("+") || buttonPressed.equals("-") || buttonPressed.equals("??")) {
			if (operand.equals("")) {				
				operand = operand + buttonPressed;
				input.setText(firstNum + operand);
			}
			
		}
			
		
		else if (buttonPressed.equals("=")) {
			if (operand.equals("+") ) {
				result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
			}
			else if (operand.equals("-")) {
				result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
			}
			else if (operand.equals("??")) {
				result = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
			}
			else {
				result = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
			}
			input.setText(Double.toString(result));
			firstNum = Double.toString(result);
			operand = "";
			secondNum = "";
		}
		
		else if (buttonPressed.equals("AC")) {
			input.setText("");
			firstNum = "";
			secondNum = "";
			operand = "";
		}
	}
}