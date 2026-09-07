package cop2805;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalc {
	
	public static void constructGUI()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		
	}	
		

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() {
				constructGUI();
			}
		});

	}

}

	class MyButtonListener implements ActionListener {
		MyFrame fr;
		public MyButtonListener(MyFrame frame)
		{
			fr = frame;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton) e.getSource();
			String firstNum = fr.firstNumber.getText();
			String secondNum = fr.secondNumber.getText();
			String math = (String) fr.math.getSelectedItem();
			
			double firstNumber = Double.parseDouble(firstNum);
			double secondNumber = Double.parseDouble(secondNum);
			double result;
			
			if (math == "Add") {
				result = firstNumber + secondNumber;
			} else if (math == "Subtract") {
				result = firstNumber - secondNumber;
			} else if (math == "Multiply") {
				result = firstNumber * secondNumber;
			} else {
				result = firstNumber / secondNumber;
			}
			
			fr.result.setText("Result: " + result);
		}
}
	
	class MyFrame extends JFrame {
		public JTextField firstNumber;
		public JTextField secondNumber;
		public JComboBox math;
		public JLabel result;
		
		public MyFrame() {
					super();
					init();
		}
		
		private void init(){
			this.setTitle("Simple Calculator");
			this.add(new JLabel("First Number:"));
			firstNumber = new JTextField();
			this.add(firstNumber);
			this.add(new JLabel ("Second Number:"));
			secondNumber = new JTextField();
			this.add(secondNumber);
			this.add(new JLabel(""));
		    String[] operations = { "Add", "Subtract", "Multiply", "Divide"};
		    
		    math = new JComboBox(operations);
		    math.setSelectedIndex(0);
		    this.add(math);
			
		    this.add(new JLabel(""));
		    JButton calcButton = new JButton("Calculate");
		    calcButton.addActionListener(new MyButtonListener(this));
		    this.add(calcButton);
		    result = new JLabel("Result: ");
		    this.add(result);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new GridLayout(5, 2));
			this.setSize(225, 150);
			this.setVisible(true);
		}
}