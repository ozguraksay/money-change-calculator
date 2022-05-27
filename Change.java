/* This program is written to return the amount of change the customers will get according to the input they give after their shopping
    Written by: Ozgur Tekin Aksay
*/ 
import sheffield.*;
public class Change{
    public static void main(String[] args){     	 
    	EasyReader input = new EasyReader();
    	double cost = input.readDouble("How much is your shopping? ");       // This line gets input from the user for cost of shopping   
    	double cash = input.readDouble("How much cash did you offer? ");     // This line gets input from the user about the amount of cash they offered
    	double change = (cash-cost); //This variable calculates the change that will be given to the customer by substracting shopping cost from the cash offered
    	EasyWriter screen = new EasyWriter();
    	screen.print("Your change should be ");
    	screen.println(change,2);// This method gives an output for the variable change to 2 decimal places
    	screen.println("Made up of");
    	double changeInPence = Math.round(change*100);     //Change is converted from pounds to pence and rounded to the nearest integer
    	if(changeInPence >= 1000){
    		screen.println("10 pound notes:  1");
    		changeInPence -= 1000;
        }
         /* This if statements pretty much do the same thing. 
         It first compares the value of variable changeInPence with the value of pence for that money amount. 
         If the condition is true that amount is subtracted from the current value of variable changeInPence. 
         If the condition is false text is printed saying that no change is given in that amount.*/
        else 
        	screen.println("10 pound notes:  0");
        if (changeInPence >= 500){
        	screen.println("5 pound notes:   1");
            changeInPence -= 500;
        }
        else
          	screen.println("5 pound notes:   0");
        if (changeInPence >= 400 ){
        	screen.println("2 pound coins:   2");
            changeInPence -= 400;
        }
        /*No combination of change gives 4 pounds, 40 pences and 4 pences unless 2 or 20 is doubled
          and that is why this if statement is written so it can output two cash changes for that amount*/
        else if(changeInPence >= 200){
        	screen.println("2 pound coins:   1");
            changeInPence -= 200;
        }
        else 
           	screen.println("2 pound coins:   0");
        if(changeInPence >= 100){
           	screen.println("1 pound coins:   1");
           	changeInPence -= 100;
        }
        else 
           	screen.println("1 pound coins:   0");
        if(changeInPence >= 50){
           	screen.println("50 pence coins:  1");
           	changeInPence -= 50;
        }
        else 
           	screen.println("50 pence coins:  0");
        if (changeInPence >= 40 ){
        	screen.println("20 pence coins:  2");
            changeInPence -= 40; 
        }
        else if(changeInPence >= 20){
        	screen.println("20 pence coins:  1");
            changeInPence -= 20;
        }
        else 
           	screen.println("20 pence coins:  0");
        if(changeInPence >= 10){
           	screen.println("10 pence coins:  1");
           	changeInPence -= 10;
        }
        else 
           	screen.println("10 pence coins:  0");
        if(changeInPence >= 5){
           	screen.println("5 pence coins:   1");
           	changeInPence -= 5;
        }
        else 
           	screen.println("5 pence coins:   0");
        if (changeInPence >= 4 ){
        	screen.println("2 pence coins:   2");
            changeInPence -= 4;
        }   
        else if(changeInPence >= 2){
        	screen.println("2 pence coins:   1");
            changeInPence -= 2; 
        }
        else 
           	screen.println("2 pence coins:   0");
        if(changeInPence >= 1){
           	screen.println("1 pence coins:   1");
           	changeInPence -= 1;
        }
        else 
           	screen.println("1 pence coins:   0");     
             	
    } 
}     