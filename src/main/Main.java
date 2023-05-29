package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main implements ActionListener{

	// Frame Declaration
	private JFrame frame;
	
	// Sub-title Declaration
	private JLabel standardLabel;
	
	// Unknown Area Declaration
	private JLabel mcLabel;
	private JLabel mrLabel;
	private JLabel mPlusLabel;
	private JLabel mMinusLabel;
	private JLabel msLabel;
	private JLabel mdownLabel;
	
	// Display Declaration
	private JTextField displayTextField;
	private JTextField resultTextField;
	
	// First Column Declaration
	private JButton percentButton;
	private JButton divideXButton;
	private JButton sevenButton;
	private JButton fourButton;
	private JButton oneButton;
	private JButton negateButton;
	
	// Second Column Declaration
	private JButton clearButton;
	private JButton xSquaredButton;
	private JButton eightButton;
	private JButton fiveButton;
	private JButton twoButton;
	private JButton zeroButton;
	
	// Third Column Declaration
	private JButton clearAllButton;
	private JButton squareRootButton;
	private JButton nineButton;
	private JButton sixButton;
	private JButton threeButton;
	private JButton pointButton;
	
	// Fourth Column Declaration
	private JButton deleteButton;
	private JButton divideButton;
	private JButton timesButton;
	private JButton minusButton;
	private JButton plusButton;
	private JButton equalButton;
	
	// Calculation Declaration
	// Use Double class to use null instead double primitive type
	Double num1 = null;
	// Num2 is double primitive type only since there's doesn't need to check if num2 is null
	// We only check for null to know where to input the value inputed
	// If num1 is not null then automatically we need to input it to num2
	double num2;
	double res;
	char op;
	boolean isDisplayed;
	String input;
	
	boolean isClearNeeded;
    
	Main(){
		// To create the frame
		frame = new JFrame("Calculator");  
		
		// To create sub-title
		standardLabel = new JLabel("Standard");
		standardLabel.setBounds(5,10, 90, 39);
		standardLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		// To create result area
	    resultTextField = new JTextField("");  
	    resultTextField.setHorizontalAlignment(SwingConstants.RIGHT);
	    resultTextField.setBounds(5,50, 335, 40); 
	    resultTextField.setFont(new Font("Arial", Font.PLAIN, 13));
	    resultTextField.setForeground(Color.gray);
	    resultTextField.setEditable(false);
	    resultTextField.setBorder(BorderFactory.createLineBorder(Color.white));
	    resultTextField.setBackground(Color.white);
		
	    // To create display area
		displayTextField = new JTextField("0");  
		displayTextField.setHorizontalAlignment(SwingConstants.RIGHT);
	    displayTextField.setBounds(5,90, 335, 50); 
	    displayTextField.setFont(new Font("Arial", Font.PLAIN, 20));
	    displayTextField.setEditable(false);
	    displayTextField.setBorder(BorderFactory.createLineBorder(Color.white));
	    displayTextField.setBackground(Color.white);
	    
	    // To create the unknown area
	    mcLabel = new JLabel("MC");
	    mcLabel.setBounds(0,140, 58, 39);
	    mcLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    mcLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mrLabel = new JLabel("MR");
	    mrLabel.setBounds(58,140, 58, 39);
	    mrLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    mrLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mPlusLabel = new JLabel("M+");
	    mPlusLabel.setBounds(116,140, 58, 39);
	    mPlusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    mPlusLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mMinusLabel = new JLabel("M-");
	    mMinusLabel.setBounds(174,140, 58, 39);
	    mMinusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    mMinusLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    msLabel = new JLabel("MS");
	    msLabel.setBounds(232,140, 58, 39);
	    msLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    msLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mdownLabel = new JLabel("Mv");
	    mdownLabel.setBounds(290,140, 58, 39);
	    mdownLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    mdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    // To create first column
	    percentButton = new JButton("%");  
	    percentButton.setBounds(5,180,80,50);  
	    percentButton.setFocusable(false);
	    percentButton.addActionListener(this);
	    
	    divideXButton = new JButton("1/x");  
	    divideXButton.setBounds(5,235,80,50);  
	    divideXButton.setFocusable(false);
	    divideXButton.addActionListener(this);
	    
	    sevenButton = new JButton("7");  
	    sevenButton.setBounds(5,290,80,50);
	    sevenButton.setFocusable(false);
	    sevenButton.addActionListener(this);
	    
	    fourButton = new JButton("4");  
	    fourButton.setBounds(5,345,80,50);  
	    fourButton.setFocusable(false);
	    fourButton.addActionListener(this);
	    
	    oneButton = new JButton("1");  
	    oneButton.setBounds(5,400,80,50);  
	    oneButton.setFocusable(false);
	    oneButton.addActionListener(this);
	    
	    negateButton = new JButton("+/-");  
	    negateButton.setBounds(5,455,80,50);  
	    negateButton.setFocusable(false);
	    negateButton.addActionListener(this);
	    
	    // To create second column
	    clearButton = new JButton("CE");  
	    clearButton.setBounds(90,180,80,50);  
	    clearButton.setFocusable(false);
	    clearButton.addActionListener(this);
	    
	    xSquaredButton = new JButton("x²");  
	    xSquaredButton.setBounds(90,235,80,50);  
	    xSquaredButton.setFocusable(false);
	    xSquaredButton.addActionListener(this);
	    
	    eightButton = new JButton("8");  
	    eightButton.setBounds(90,290,80,50);  
	    eightButton.setFocusable(false);
	    eightButton.addActionListener(this);
	    
	    fiveButton = new JButton("5");  
	    fiveButton.setBounds(90,345,80,50);  
	    fiveButton.setFocusable(false);
	    fiveButton.addActionListener(this);
	    
	    twoButton = new JButton("2");  
	    twoButton.setBounds(90,400,80,50);  
	    twoButton.setFocusable(false);
	    twoButton.addActionListener(this);
	    
	    zeroButton = new JButton("0");  
	    zeroButton.setBounds(90,455,80,50);
	    zeroButton.setFocusable(false);
	    zeroButton.addActionListener(this);
	    
	    // To create third column
	    clearAllButton = new JButton("C");  
	    clearAllButton.setBounds(175,180,80,50); 
	    clearAllButton.setFocusable(false);
	    clearAllButton.addActionListener(this);
	    
	    squareRootButton = new JButton("√x");  
	    squareRootButton.setBounds(175,235,80,50); 
	    squareRootButton.setFocusable(false);
	    squareRootButton.addActionListener(this);
	    
	    nineButton = new JButton("9");  
	    nineButton.setBounds(175,290,80,50);  
	    nineButton.setFocusable(false);
	    nineButton.addActionListener(this);
	    
	    sixButton = new JButton("6");  
	    sixButton.setBounds(175,345,80,50);  
	    sixButton.setFocusable(false);
	    sixButton.addActionListener(this);
	    
	    threeButton = new JButton("3");  
	    threeButton.setBounds(175,400,80,50);  
	    threeButton.setFocusable(false);
	    threeButton.addActionListener(this);
	    
	    pointButton = new JButton(".");  
	    pointButton.setBounds(175,455,80,50); 
	    pointButton.setFocusable(false);
	    pointButton.addActionListener(this);
	    
	    // To create fourth column
	    deleteButton = new JButton("⌫");  
	    deleteButton.setBounds(260,180,80,50); 
	    deleteButton.setFocusable(false);
	    deleteButton.addActionListener(this);
	    
	    divideButton = new JButton("/");  
	    divideButton.setBounds(260,235,80,50); 
	    divideButton.setFocusable(false);
	    divideButton.addActionListener(this);
	    
	    timesButton = new JButton("x");  
	    timesButton.setBounds(260,290,80,50);  
	    timesButton.setFocusable(false);
	    timesButton.addActionListener(this);
	    
	    minusButton = new JButton("-");  
	    minusButton.setBounds(260,345,80,50); 
	    minusButton.setFocusable(false);
	    minusButton.addActionListener(this);
	    
	    plusButton = new JButton("+");  
	    plusButton.setBounds(260,400,80,50); 
	    plusButton.setFocusable(false);
	    plusButton.addActionListener(this);
	    
	    equalButton = new JButton("=");  
	    equalButton.setBounds(260,455,80,50);  
	    equalButton.setFocusable(false);
	    equalButton.addActionListener(this);
	    
	    // To add sub-title
	    frame.add(standardLabel);
	    
	    // To add result area
	    frame.add(displayTextField);  
	    frame.add(resultTextField);  
	    
	    // To add unknown area
	    frame.add(mcLabel);
	    frame.add(mrLabel);
	    frame.add(mPlusLabel);
	    frame.add(mMinusLabel);
	    frame.add(msLabel);
	    frame.add(mdownLabel);
	    
	    // To add first column
	    frame.add(percentButton);
	    frame.add(divideXButton);
	    frame.add(sevenButton);
	    frame.add(fourButton);
	    frame.add(oneButton);
	    frame.add(negateButton);
	    
	    // To add second column
	    frame.add(clearButton);
	    frame.add(xSquaredButton);
	    frame.add(eightButton);
	    frame.add(fiveButton);
	    frame.add(twoButton);
	    frame.add(zeroButton);
	    
	    // To add third column
	    frame.add(clearAllButton);
	    frame.add(squareRootButton);
	    frame.add(nineButton);
	    frame.add(sixButton);
	    frame.add(threeButton);
	    frame.add(pointButton);
	    
	    // To add fourth column
	    frame.add(deleteButton);
	    frame.add(divideButton);
	    frame.add(timesButton);
	    frame.add(minusButton);
	    frame.add(plusButton);
	    frame.add(equalButton);
	    
	    // To edit frame
	    frame.getContentPane().setBackground(Color.white);
	    frame.setSize(360,550);  
	    frame.setLayout(null); 
	    frame.setResizable(false);
	    frame.setVisible(true); 
	    frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// First Column
		input = displayTextField.getText();
		
		// To remove the unnecessary value in the display text field
		if(input.equals("0") || isClearNeeded) {
			input = "";
		}
		
		// To check if a user click an operator if operator was clicked it means that the program must remove first the input value before entering new value
		if(isOperator(e)) {
			isClearNeeded = true;
		} else {
			isClearNeeded = false;
		}
		
		// To check if plusButton is disabled and to enabled all the button
		// after clicking a number
		if(!plusButton.isEnabled()) {
			enableOpButton(true);
			// This is to display the result in the result text field
			resultTextField.setText("");
		}
		
		if(e.getSource() == percentButton) { // First Column
			// We need to get the input again since we click a operator if we click anything again old input will become empty
			double number = Double.valueOf(displayTextField.getText());
			res = Double.valueOf(number)/100;
			resultTextField.setText(format(res));
			displayTextField.setText(format(res));
			
		}  else if(e.getSource() == sevenButton) { 
			
			displayTextField.setText(input + "7");
			
		} else if(e.getSource() == divideXButton) {
			// We need to get the input again since we click a operator if we click anything again old input will become empty
			double number = Double.valueOf(displayTextField.getText());
			
			// This is to display the result in the result text field
			resultTextField.setText("1/(" + format(number) + ")" );
			
			if(number != 0) {
				res = 1/Double.valueOf(number);
				displayTextField.setText(format(res));
			} else {
				// This is to reformat the displayTextField to prepare for the next value to be inputed
				displayTextField.setText("Cannot devide by zero");
			
				res = 0;
				
				enableOpButton(false);
			}
			
			
		} else if(e.getSource() == fourButton) {
			
			displayTextField.setText(input + "4");
			
		} else if(e.getSource() == oneButton) {
			
			displayTextField.setText(input + "1");
			
		} else if(e.getSource() == negateButton) {
			
			if(!input.contains("-") && !input.contains("+")) {
				input = "-" + input;
			} else if(input.contains("-")) {
				input = input.substring(1, input.length());  
				input = "+" + input;
			} else {
				input = input.substring(1, input.length());  
				input.contains("-");
			}
			displayTextField.setText(input);
			
		} else if(e.getSource() == clearButton) { // Second Column
			
			displayTextField.setText("0");
			
		} else if(e.getSource() == xSquaredButton) {
			// We need to get the input again since we click a operator if we click anything again old input will become empty
			double number = Double.valueOf(displayTextField.getText());
			resultTextField.setText("sqr(" + format(number) + ")" );
			res = Double.valueOf(number) * Double.valueOf(number);
			displayTextField.setText(format(res));
			
		} else if(e.getSource() == eightButton) {
			
			displayTextField.setText(input + "8");
			
		} else if(e.getSource() == fiveButton) {
			
			displayTextField.setText(input + "5");
			
		} else if(e.getSource() == twoButton) {
			
			displayTextField.setText(input + "2");
			
		} else if(e.getSource() == zeroButton) {
			
			displayTextField.setText(input + "0");
			
		} else if(e.getSource() == clearAllButton) { // Third Column
			
			num1 = null;
			num2 = 0d;
			res = 0d;
			resultTextField.setText("");
			displayTextField.setText("0");
			
		} else if(e.getSource() == squareRootButton) {
			// We need to get the input again since we click a operator if we click anything again old input will become empty
			double number = Double.valueOf(displayTextField.getText());
			resultTextField.setText("√(" + format(number) + ")" );
			res = Math.sqrt(Double.valueOf(number));
			displayTextField.setText(format(res));
			
		} else if(e.getSource() == nineButton) { 
			
			displayTextField.setText(input+ "9");
			
		}  else if(e.getSource() == sixButton) {
			
			displayTextField.setText(input + "6");
			
		}  else if(e.getSource() == threeButton) {
			
			displayTextField.setText(input + "3");
			
		} else if(e.getSource() == pointButton) {
			
			if(!input.contains(".")) {
				displayTextField.setText(input + ".");
			}
			
		} else if(e.getSource() == deleteButton) { // Fourth Column
			// We need to get the input again since we click a operator if we click anything again old input will become empty
			String number = displayTextField.getText();
			if(number.length() == 1 || number.equals("Cannot devide by zero")) {
				displayTextField.setText("0");
			} else {
				number = number.substring(0, number.length() - 1);
				displayTextField.setText(number);
			} 
		} else if(e.getSource() == divideButton) {
			
			opCalculate('/');
			
		} else if(e.getSource() == timesButton) {
			
			opCalculate('*');
			
		} else if(e.getSource() == minusButton) {
			
			opCalculate('-');
			
		} else if(e.getSource() == plusButton) {
			
			opCalculate('+');
			
		} else if(e.getSource() == equalButton) {
			
			equalCalculate();
			
		}
	}
	// This is use when the user click operators
	// Save the numbers and operator inputed by the user
	// This also perform a calculation when the user click an operator instead of equals
	public void opCalculate(char op2) {
		// We need to get the input again since we click a operator if we click anything again old input will become empty
		double number = Double.valueOf(displayTextField.getText());
		if(num1 == null) { // Check if there is still no first number
			num1 = number; // If there is not then get the value and store to num1
			// This is to display the result in the result text field
			resultTextField.setText(format(num1) + " " + op2 + " ");
			// This is to reformat the displayTextField to prepare for the next value to be inputed
			displayTextField.setText(format(num1));
		} else { // If there is num1 then the new number that will be added will be add to the second number num1 and then calculate
			num2 = number;
			// This is to check if the user already calculated a value and just wanted to add more calculation base on the previous result of
			// their calculation.
			// Keep note this is only use when the user click equals since equal is displaying the result
			// in the display text box we need to remove the result first and not do any calculation on the result.
			if(num2 != 0) { // This is to check that the user is not dividing by zero
				if(!isDisplayed) {
					// Since we already have num1 and num2 we can directly calculate here
					calculate();
				} else {
					// This is use to display the new input value. This is use in case the user edited the result displayed 
					// And we need to use the new inputed value instead the result of the previous calculation for our next calculation.
					res = number;
				}
				// Then assign the res to num1 for the res to use for the next calculation
				num1 = res;
				// Then reformat num2 this variable will store the next value that will be inputed
				num2 = 0;
				// This is to display the result in the result text field
				resultTextField.setText(format(res) + " " + op2 + " ");
				// This is to reformat the displayTextField to prepare for the next value to be inputed
				displayTextField.setText(format(res));
			} else { // If the user is dividing by zero then we need to send a error message 
				if(Character.compare(op, '/') == 0) {
					// This is to display the result in the result text field
					resultTextField.setText(format(num1) + " " + op + " " + format(num2) + " " + op2);
					// This is to reformat the displayTextField to prepare for the next value to be inputed
					displayTextField.setText("Cannot devide by zero");
					
					num1 = null;
					num2 = 0;
					res = 0;
					
					enableOpButton(false);
				}
			}
		}
		
		// Calculate first before adding the new operator for the previous operator to be use in the calculation not the new one.
		op = op2; 
		
		// Then set displayed to false 
		isDisplayed = false;
	}
	
	// This is use to calculate when the user click equals
	public void equalCalculate() {
		// To get the new number
		// We need to get the input again since we click a operator if we click anything again old input will become empty
		num2 = Double.valueOf(displayTextField.getText());
		
		if(Character.compare(op, '/') == 0 && num2 == 0) {
			// This is to display the result in the result text field
			resultTextField.setText(format(num1) + " " + op + " ");
			// This is to reformat the displayTextField to prepare for the next value to be inputed
			displayTextField.setText("Cannot devide by zero");
			
			num1 = null;
			num2 = 0;
			res = 0;
			
			enableOpButton(false);
		} else {
			// To calculate
			calculate();
			
			// To display
			resultTextField.setText(format(num1) + " " + op + " " + format(num2) + " = ");
			displayTextField.setText(format(res));
			isDisplayed = true;
			
			// Then assign the res to num1 for the res to use for the next calculation
			num1 = res;
			// Then reformat num2 this variable will store the next value that will be inputed
			num2 = 0;
		}
		
	}
	
	// To do the actual calculation
	public void calculate() {
		switch(op) {
			case '/':
				res = num1 / num2;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '-':
				res = num1 - num2;
				break;
			case '+':
				res = num1 + num2;
				break;
		}
	}
	
	public boolean isOperator(ActionEvent e) {
		if(e.getSource() == divideButton
			|| e.getSource() == minusButton
			|| e.getSource() == timesButton
			|| e.getSource() == plusButton
			|| e.getSource() == equalButton
			|| e.getSource() == divideXButton
			|| e.getSource() == xSquaredButton
			|| e.getSource() == squareRootButton
			|| e.getSource() == percentButton) {
			return true;
		}
		return false;
	}
	
	// This is use to disable a button when the user divided by zero
	// And also use to enable button when the user click a number 
	public void enableOpButton(boolean b) {
		divideButton.setEnabled(b);
		minusButton.setEnabled(b);
		timesButton.setEnabled(b);
		plusButton.setEnabled(b);
		equalButton.setEnabled(b);
		divideXButton.setEnabled(b);
		xSquaredButton.setEnabled(b);
		squareRootButton.setEnabled(b);
		percentButton.setEnabled(b);
	}
	
	// To convert double to string without trailing zero example 2.0 to 2
	public static String format(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
}
