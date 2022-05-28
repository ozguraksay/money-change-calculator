import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
@SuppressWarnings("serial")
public class Change extends JFrame implements ActionListener  {

	private JPanel contentPane;
	private JTextField shoppingCost;
	private JTextField cashOffered;
	private JLabel changeLabel;
	private JLabel shoppingLabel;
	private JLabel cashLabel;
	private JLabel moreMoney;
	private JButton applyButton;
	private JButton cancelButton;
	private JLabel shoppingValue;
	private JLabel cashValue;
	private JLabel pound_10;
	private JLabel pound_5;
	private JLabel pound_2;
	private JLabel pound_1;
	private JLabel coins_50;
	private JLabel coins_20;
	private JLabel coins_10;
	private JLabel coins_5;
	private JLabel coins_2;
	private JLabel coins_1;
	private JLabel change_allocation;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		shoppingCost = new JTextField();
		shoppingCost.setBounds(10, 47, 136, 31);
		contentPane.add(shoppingCost);
		shoppingCost.setColumns(10);
		
		cashOffered = new JTextField();
		cashOffered.setBounds(10, 137, 136, 31);
		contentPane.add(cashOffered);
		cashOffered.setColumns(10);
		
		shoppingLabel = new JLabel("Shopping Cost");
		shoppingLabel.setFont(new Font("Arial", Font.BOLD, 14));
		shoppingLabel.setBounds(26, 21, 110, 31);
		contentPane.add(shoppingLabel);
		
		cashLabel = new JLabel("Cash Offered");
		cashLabel.setFont(new Font("Arial", Font.BOLD, 14));
		cashLabel.setBounds(26, 111, 110, 24);
		contentPane.add(cashLabel);
		
		changeLabel = new JLabel("");
		changeLabel.setForeground(new Color(0, 0, 0));
		changeLabel.setFont(new Font("Arial", Font.BOLD, 14));
		changeLabel.setBounds(10, 195, 257, 24);
		contentPane.add(changeLabel);
		
		moreMoney = new JLabel("");
		moreMoney.setFont(new Font("Arial", Font.BOLD, 14));
		moreMoney.setBounds(10, 216, 202, 24);
		contentPane.add(moreMoney);
		
		applyButton = new JButton("Run");
		applyButton.setForeground(new Color(255, 255, 255));
		applyButton.setBackground(new Color(0, 0, 128));
		applyButton.setFont(new Font("Arial", Font.BOLD, 12));
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String shopCost = shoppingCost.getText();
				String cashOffer = cashOffered.getText();
				
			    try {
		            double shopCost1 = Double.parseDouble(shopCost);
		     	    double cashOffer1 = Double.parseDouble(cashOffer);
			     
			        System.out.println("Cash Offered: " + cashOffer1);
			        System.out.println("Shopping Cost: " + shopCost1);
		        } 
			    catch (NumberFormatException e) {
		            if(shopCost.equals("") || shopCost == null) 
		                shoppingValue.setText("Please enter a value for shopping cost"); 
		            else
		            	shoppingValue.setText("");
		            
		            if(cashOffer.equals("") || cashOffer == null) 
		                cashValue.setText("Please enter a value for cash offered"); 
		            else 
		            	cashValue.setText("");
		       }
				double shopCost1 = Double.parseDouble(shopCost);
				double cashOffer1 = Double.parseDouble(cashOffer);
				
				double change_no_abs=cashOffer1 - shopCost1;
				double change =Math.abs(cashOffer1 - shopCost1);
				double changeInPence =Math.round(change*100);
			    double roundOff = Math.round(changeInPence*100)/100;
				
			 	if (cashOffer1<shopCost1) {
					changeLabel.setForeground(new Color(178, 34, 34));
					changeLabel.setText("Payment Unsuccessful");
					moreMoney.setText("Additional \u00A3 " + (roundOff/100) + " is needed");
					shoppingValue.setText("");
					cashValue.setText("");
					change_allocation.setText("Additional amount needed to pay:");
				}
				else if (shopCost1<cashOffer1) {
					changeLabel.setForeground(new Color(0, 155, 0));
					changeLabel.setText("Payment Successful");
					moreMoney.setText("Your Change: \u00A3 " +roundOff/100);
					shoppingValue.setText("");
					cashValue.setText("");
					change_allocation.setText("Your Change is Made Up Of:");
				}
				if (shopCost1==cashOffer1) {
					changeLabel.setForeground(new Color(0, 155, 0));
					changeLabel.setText("Payment Successful");
					moreMoney.setText("No Change");
					shoppingValue.setText("");
					cashValue.setText("");
					change_allocation.setText("");
				}
		
				if (!(shopCost1==cashOffer1)) {
				//Change is converted from pounds to pence and rounded to the nearest integer
					if(changeInPence >= 1000 ){
						pound_10.setText("10 Pound Notes: 1");
						pound_10.setForeground(new Color(255, 0, 0));
						changeInPence -= 1000;
					}
		         /* This if statements pretty much do the same thing. 
		         It first compares the value of variable changeInPence with the value of pence for that money amount. 
		         If the condition is true that amount is subtracted from the current value of variable changeInPence. 
		         If the condition is false text is printed saying that no change is given in that amount.*/
					else 
						pound_10.setText("10 Pound Notes: 0");
				}
				else
					pound_10.setText("");
				
				if (!(shopCost1==cashOffer1)) {
					if (changeInPence >= 500){
						pound_5.setText("5 Pound Notes: 1");
						pound_5.setForeground(new Color(255, 0, 0));
						changeInPence -= 500;
					}
					else
						pound_5.setText("5 Pound Notes: 0");
				}
				else
					pound_5.setText("");
				
				if (!(shopCost1==cashOffer1)) {
					if (changeInPence >= 400 ){
						pound_2.setText("2 Pound Notes: 2");
						pound_2.setForeground(new Color(255, 0, 0));
						changeInPence -= 400;
					}
		        /*No combination of change gives 4 pounds, 40 pences and 4 pences unless 2 or 20 is doubled
		          and that is why this if statement is written so it can output two cash changes for that amount*/
					else if(changeInPence >= 200){
						pound_2.setText("2 Pound Notes: 1");
						pound_2.setForeground(new Color(255, 0, 0));
						changeInPence -= 200;
					}
					else 
						pound_2.setText("2 Pound Notes: 0");
				}
				else
					pound_2.setText("");
				
				if (!(shopCost1==cashOffer1)) {
					if(changeInPence >= 100){
						pound_1.setText("1 Pound Notes: 1");
						pound_1.setForeground(new Color(255, 0, 0));
						changeInPence -= 100;
					}
					else 
						pound_1.setText("1 Pound Notes: 0");
				}
				else
					pound_1.setText("");
					
				if (!(shopCost1==cashOffer1)) {
					
					if(changeInPence >= 50){
						coins_50.setText("50 Pence Coins: 1");
						coins_50.setForeground(new Color(255, 0, 0));
						changeInPence -= 50;
					}
					else 
						coins_50.setText("50 Pence Coins: 0");
				}
				else
					coins_50.setText("");
					
				if (!(shopCost1==cashOffer1)) {
					if (changeInPence >= 40 ){
						coins_20.setText("20 Pence Coins: 2");
						coins_20.setForeground(new Color(255, 0, 0));
						changeInPence -= 40; 
					}
					else if(changeInPence >= 20){
						coins_20.setText("20 Pence Coins: 1");
						coins_20.setForeground(new Color(255, 0, 0));
						changeInPence -= 20;
					}
					else
						coins_20.setText("20 Pence Coins: 0");
				}
				else
					coins_20.setText("");
				
				
				if (!(shopCost1==cashOffer1)) {
					if(changeInPence >= 10){
						coins_10.setText("10 Pence Coins: 1");
						coins_10.setForeground(new Color(255, 0, 0));
						changeInPence -= 10;
					}
					else 
						coins_10.setText("10 Pence Coins: 0");
				}
				else
					coins_10.setText("");
		
				if (!(shopCost1==cashOffer1)) {
					if(changeInPence >= 5){
						coins_5.setText("5 Pence Coins: 1");
						coins_5.setForeground(new Color(255, 0, 0));
						changeInPence -= 5;
					}
					else 
						coins_5.setText("5 Pence Notes: 0");
				}
				else 
					coins_5.setText("");
				
				if (!(shopCost1==cashOffer1)) {
					if (changeInPence >= 4 ){
						coins_2.setText("2 Pence Coins: 2");
						coins_2.setForeground(new Color(255, 0, 0));
						changeInPence -= 4;
					}   
					else if(changeInPence >= 2){
						coins_2.setText("2 Pence Coins: 1");
						coins_2.setForeground(new Color(255, 0, 0));
						changeInPence -= 2; 
					}
					else 
						coins_2.setText("2 Pence Coins: 0");
				}
				else 
					coins_2.setText("");
				
				
				if (!(shopCost1==cashOffer1)) {
					if(changeInPence >= 1){
						coins_1.setText("1 Pence Coins: 1");
						coins_1.setForeground(new Color(255, 0, 0));
						changeInPence -= 1;
			        }
			        else 
			    		coins_1.setText("1 Pence Coins: 0");
				}
				else 
					coins_1.setText("");
			
			}
			
		});
		applyButton.setBounds(10, 290, 77, 21);
		contentPane.add(applyButton);
		
	    cancelButton = new JButton("Clear");
	    cancelButton.setBackground(new Color(0, 0, 128));
	    cancelButton.setForeground(new Color(255, 255, 255));
	    cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				shoppingCost.setText("");
				cashOffered.setText("");
				changeLabel.setText("");
				moreMoney.setText("");
				shoppingValue.setText("");
				cashValue.setText("");
				
				pound_10.setForeground(new Color(0,0,0));
				pound_10.setText("");
				
				pound_5.setForeground(new Color(0,0,0));
				pound_5.setText("");
				
				pound_2.setForeground(new Color(0,0,0));
				pound_2.setText("");
				
				pound_1.setForeground(new Color(0,0,0));
				pound_1.setText("");
				
				coins_50.setForeground(new Color(0,0,0));
				coins_50.setText("");
				
				coins_20.setForeground(new Color(0,0,0));
				coins_20.setText("");
				
				coins_10.setForeground(new Color(0,0,0));
				coins_10.setText("");
				
				coins_5.setForeground(new Color(0,0,0));
				coins_5.setText("");
				
				coins_2.setForeground(new Color(0,0,0));
				coins_2.setText("");
				
				coins_1.setForeground(new Color(0,0,0));
				coins_1.setText("");
				
				change_allocation.setText("");
			
			}
		});
				
		cancelButton.setBounds(97, 290, 77, 21);
		contentPane.add(cancelButton);
		
		shoppingValue = new JLabel("");
		shoppingValue.setForeground(new Color(178, 34, 34));
		shoppingValue.setFont(new Font("Arial", Font.BOLD, 12));
		shoppingValue.setBounds(10, 77, 257, 24);
		contentPane.add(shoppingValue);
		
		cashValue = new JLabel("");
		cashValue.setForeground(new Color(178, 34, 34));
		cashValue.setFont(new Font("Arial", Font.BOLD, 12));
		cashValue.setBounds(10, 167, 257, 24);
		contentPane.add(cashValue);
		
		change_allocation = new JLabel("");
		change_allocation.setForeground(new Color(0, 0, 128));
		change_allocation.setBackground(new Color(240, 255, 240));
		change_allocation.setFont(new Font("Arial", Font.BOLD, 13));
		change_allocation.setBounds(210, 8, 215, 13);
		contentPane.add(change_allocation);
		
		pound_10 = new JLabel("");
		pound_10.setBounds(278, 30, 105, 13);
		contentPane.add(pound_10);
		
		pound_5 = new JLabel("");
		pound_5.setBounds(278, 60, 105, 13);
		contentPane.add(pound_5);
		
		pound_2 = new JLabel("");
		pound_2.setBounds(278, 90, 105, 13);
		contentPane.add(pound_2);
		
		pound_1 = new JLabel("");
		pound_1.setBounds(278, 120, 105, 13);
		contentPane.add(pound_1);
		
		coins_50 = new JLabel("");
		coins_50.setBounds(278, 150, 105, 13);
		contentPane.add(coins_50);
		
		coins_20 = new JLabel("");
		coins_20.setBounds(277, 180, 105, 13);
		contentPane.add(coins_20);
		
		coins_10 = new JLabel("");
		coins_10.setBounds(277, 210, 105, 13);
		contentPane.add(coins_10);
		
		coins_5 = new JLabel("");
		coins_5.setBounds(277, 240, 105, 13);
		contentPane.add(coins_5);
		
		coins_2 = new JLabel("");
		coins_2.setBounds(277, 270, 105, 13);
		contentPane.add(coins_2);
		
		coins_1 = new JLabel("");
		coins_1.setBounds(278, 300, 105, 13);
		contentPane.add(coins_1);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					Change frame = new Change();
					frame.setVisible(true);
					frame.setTitle("Change Calculator");
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actionPerformed (ActionEvent e) {
	}
}
