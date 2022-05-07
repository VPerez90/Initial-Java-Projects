//************************************************************************
// CalcTime.java		
// Author: Victoria Griffin
// CPSC 21000: Programming Fundamentals
// Spring 2022
//
// Create a Java program that reads a value representing a number of seconds, 
// and then prints the equivalent amount of time as a combination of 
// days, hours, minutes, and seconds.
//************************************************************************
import java.util.Scanner;

public class CalcTime 
{
//------------------------------------------------------------------------
// Conversion to Days, Hours, Minutes, and Seconds Program
//------------------------------------------------------------------------
	public static void main(String[] args) 
	{
		//Required output
		System.out.println("----------------------------------------------------------------------");
		System.out.println("CPSC 21000");
		System.out.println("NAME: Victoria Griffin");
		System.out.println("PROGRAMMING ASSIGNMENT 1");
		
		//Create variables
		int userNum, numOfDays, numOfHours, numOfMinutes, numOfSeconds;
		
		// Create new Scanner object to get # of seconds from user
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.print("Enter the number of seconds: ");
		userNum = scan.nextInt();
		
		//Close Scanner
		scan.close();
		
		// Calculations for finding # of days, minutes, hours, and seconds
		numOfDays = userNum / 86400;
		numOfHours = (userNum-(numOfDays*86400))/3600;
		numOfMinutes = (userNum-((numOfDays*86400)+(numOfHours*3600)))/60;
		numOfSeconds = (userNum-(((numOfDays*86400)+(numOfHours*3600)+(numOfMinutes*60))))/1;
		
		System.out.println();
		System.out.println("The equivalent time is " + numOfDays + " days, " + numOfHours + 
				" hours, " + numOfMinutes + " minutes, and " + numOfSeconds + " seconds.");
		System.out.println("----------------------------------------------------------------------");
	}
}