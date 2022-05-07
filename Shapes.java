//************************************************************************
// Shapes.java		
// Author: Victoria Griffin
// CPSC 21000: Programming Fundamentals
// Spring 2022
//
// Create a program in Java that asks the user to enter the size of a shape 
// (must be odd), then displays a menu of 4 options. Options 1-3 will print 
// various shapes: closed square, open square, and diamond. 
// Option 4 will allow the user to quit the program. 
//************************************************************************
import java.util.Scanner;

public class Shapes {
//------------------------------------------------------------------------
// Shapes Program
//------------------------------------------------------------------------

	//Method getShapeSize for determining if user input is odd and to correct if not
	public static int getShapeSize(int num) 
	{
		Scanner scan = new Scanner(System.in);
			
		do 
		{	
			// If statement to check if the user number is odd 
			if (num % 2 != 0)  
			{
				System.out.println();
			}
			else 
			{	
				System.out.println("Ivalid figure size - must be an odd number");
				System.out.println();
				System.out.print("Re-enter the size of the figure: ");
				num = scan.nextInt();
				System.out.println();
			} 
		}
		while (num % 2 == 0);
		return num;
	}
	
	// Menu option #1: will print a closed square
	public static void printClosedSquare (int size) 
	{
		int i, j;
		
		// Simple nested for loop to make 2D array of X's of wanted size
		for(i = 0; i < size; i++) // this is the iteration for the rows
		{
			for(j = 0; j < size; j++) //this is the iteration for the columns
			{
				System.out.print("X"); //prints character X to make shape 
			}
			System.out.print("\n"); 
		}
		System.out.println();
	}
	
	// Menu option #2: will print an open square
	public static void printOpenSquare (int size)
	{
		int i, j;
		
		// Same as closed square code with added if-else to determine X or " "
		for(i = 0; i < size; i++)
		{		
			for(j = 0; j < size; j++)
			{
		        if(i==0 || i == size-1 || j == 0 || j == size-1)
		        {
		        	System.out.print("X");
		        }
		        else 
		        {
		        	System.out.print(" ");
		        }
		     }
			System.out.println();
		} 	 
	}

	public static void printDiamond (int size) 
	{
		int i, j;
		
		 // Top half of the diamond
	     for(i=1; i <= size/2+1; i++) //height is "size/2+1", so the widest section of diamond is in the top
	     {  
	    	// Determines outer spaces of the diamond when iterating through columns
	    	for(j = i; j <= size/2; j++) 
	        {
	           System.out.print(" ");
	        }

	        // Will determine inner spaces of the diamond 
	        for (int k = 1; k <= 2*i; k++) //total spaces inside: 2, 4, 6, 8 respectively
	        {
	        	if((k==1 || k== 2*i)) //determines when to place X - this gives the diamond its shape
	        	{
	        		System.out.print("X");
	        	}
	        	else 
	        	{
	        		System.out.print(" ");
	        	}
	        }
			 
	         // Next line
	         System.out.println();
	      }
	    
	      // Bottom half of diamond
	      for(i=size/2; i >= 1; i--) //height of bottom diamond is now size/2
	      {
			 
	         
	         for(j=size/2; j >= i; j--) //same as j above only now is shrinking
	         {
	            System.out.print(" ");
	         }
			 
	         // print space
	         for(int k=1; k <=2*i; k++) //total spaces inside: 6, 4, 2 respectively 
	         {
	            if(k==1 || k==(2*i)) //determines when to place an X
	            {
	            	 System.out.print("X");
	            }
	            else {
	            System.out.print(" ");
		        }
	         }
	         // New line printed at end to separate shape from reloaded menu
	         System.out.println();
	      }
	}
	   
		
	public static void main(String[] args) {
	
		//Required output
		System.out.println("-------------------------------------------------");
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: VICTORIA GRIFFIN");
		System.out.println("PROGRAMMING ASSIGNMENT 2");
		
		Scanner scan = new Scanner(System.in);
		
		//Declaration of variables
		int userNum = 0;
		int userChoice;
		
		do 
		{	
			// Prints menu and prompts user to pick an option
			System.out.println();
			System.out.println("Menu: ");
			System.out.println("1. Print closed square");
			System.out.println("2. Print open square");
			System.out.println("3. Print diamond");
			System.out.println("4. Quit program");
			System.out.println();
			System.out.print("Please select an option: ");
			userChoice = scan.nextInt(); //option saved to variable userChoice
			
			if (userChoice == 4) //if 4 is chosen, do loop is broken and program ends 
			{
				break;
			}
			
			//Initial input for size and getShapeSize is called
			System.out.println();
			System.out.print("Enter the size of the figure (odd number): ");
			userNum = scan.nextInt();
			int finalUserNum = getShapeSize(userNum);
			
			//If 1 is chosen: printClosedSquare is called and shape is printed
			if (userChoice == 1) {
				
				printClosedSquare(finalUserNum);
			}
			//If 2 is chosen: printOpenSquare is called and shape is printed
			if (userChoice == 2) {
				
				printOpenSquare(finalUserNum);
			}
			//If 3 is chosen: printDiamond is called
			if (userChoice == 3) {
				
				printDiamond(finalUserNum);
			}
		}
		while (userChoice != 4); //keeps the do loop iterating as long as user does not choose 4
	
		//This will print when 4 is chosen by user - program is ended
		System.out.println();
		System.out.println("Good bye!");
		System.out.println("-------------------------------------------------");

	}

}
