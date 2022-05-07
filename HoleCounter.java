//************************************************************************
// HoleCounter.java		
// Author: Victoria Griffin
// CPSC 21000: Programming Fundamentals
// Spring 2022
//
// Create a program in Java that asks the user to to load a 2D grid of 1s 
// and 0s (rules applied) and should output the count of the number of holes.
//************************************************************************
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class HoleCounter {
	
	//Main Method: Inputs grid file and calls methods
	public static void main(String[] args) throws FileNotFoundException {
		
		//Required output
		System.out.println("-------------------------------------------------");
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: VICTORIA GRIFFIN");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();
		
		//File input
		File inputFile = new File("grid2.txt");
		
		
		//Print number of holes to console by calling numberOfHoles method
		System.out.println("Number of holes is " + numberOfHoles(create2DArray(inputFile)));
		System.out.println("-------------------------------------------------");
	}
	
	//Method for creating 2D array
	public static int[][] create2DArray (File inputFile) throws FileNotFoundException {
		
		//Input eclipse text file using Scanner
				Scanner input = new Scanner(inputFile);
						
				int x = input.nextInt();
				int y = input.nextInt();
						
				//read file and assign row and column based on first two integers
				int[][] numArray = new int[x][y]; 
		
		int row = 0;
		 
		//While loop for printing grid to console and storing as a 2D array
		while (input.hasNextLine()) {
			String line = input.next(); //reads next line from file
			System.out.println (line);  //print entire line first
			
			//Split the printed grid line into a single line array
			String [] strArr = line.split(""); 
	 	    
			//For loop for building 2D array from individual line arrays
	        for (int col = 0; col < 10; col++) {
	 	       numArray[row][col] = Integer.parseInt(strArr[col]);   
	 	    }
	        row++;  
		}
		System.out.println();
		return numArray;
	}
	
	//Method for "trecking' through the grid to find the holes
	public static void trecker(int[][] arr, int row, int col) {
		
		//Checks to make sure not out of bounds
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length ||arr[row][col] != 0) {
			return;
		}
		if (arr[row][col] == 0){  //double checks that position does ==0
			arr[row][col] = 1; 	  //marks the spot as visited
			trecker(arr, row+1, col); //go right
			trecker(arr, row, col+1); //go down
			trecker(arr, row-1, col); //go up
			trecker(arr, row, col-1); //go left
		}
	}
	
	//Method for counting the number of holes
	public static int numberOfHoles(int[][]arr) {
		
		//Checks to make sure that the number of rows are greater than zer0
		if (arr.length == 0) {
			return 0;
		}
		int result = 0; //number of holes initialized to zero
		
		//nested for loop for iterating through the grid
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					trecker(arr, i, j);//trecker method called when position == 0
					result++;	
				}
			}
		}
		return result;
	}
}

