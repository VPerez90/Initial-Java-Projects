//************************************************************************
// CircularArraySortedList.java		
// Author: Victoria Perez-Griffin
// CPSC 21000: Programming Fundamentals
// Spring 2022
//
// Create a program in Java which implements a Sorted List data structure 
// using a circular array-based implementation and a driver program that
// will test this implementation.
//************************************************************************
import java.util.Scanner;

//------------------------------------------------------------------------
// CircularArraySortedList Class
//------------------------------------------------------------------------
public class CircularArraySortedList {

	//Instance variables
	private int front, rear; 
	private static final int CAPACITY = 20;
	private static int[] list;
		
	//------------------------------------------------------------------------
	// Constructor Method
	//------------------------------------------------------------------------
	public CircularArraySortedList() {
		front = -1;
		rear = -1;
		this.list = new int[CAPACITY];
	}
			
	//------------------------------------------------------------------------
	// Add Method:
	// Adds the int element and returns the updated list in sorted order
	// *Time Complexity O(N)*
	//------------------------------------------------------------------------
	public void add(int x) {
		
		if(front == -1) {
			front = 0;
		}
		rear = (rear + 1) % CAPACITY;
		list[rear] = x; //adds int x to the end of the list
	
		//Will sort list
		if (rear > 0) {
			for (int i = front; i <= rear; i = (i + 1) % CAPACITY) {
				if(list[rear] > list[i]) {
					continue;
				}
				else {
					int temp = list[i];
					list[i] = list[rear];
					list[rear] = temp;
				}
			}
		}
		//count++; //increments index for list
	}
			
	//------------------------------------------------------------------------
	// RemoveFirst Method:
	// Deletes the first int from the list (stays sorted) and returns the value
	// *Time Complexity O(1)*
	//------------------------------------------------------------------------
	public int removeFirst() {
			
		int item = list[front]; //assigns list at index "front" to int item
	
		front = (front +1) % CAPACITY; //shifts list
	
		System.out.println("removed " + item);//prints element removed
		
		return (item); 
	}
	
	//------------------------------------------------------------------------
	// RemovesLast Method:
	// Deletes the last int from the list (stays sorted) and returns its value
	// *Time Complexity O(1)*
	//------------------------------------------------------------------------
	public int removeLast() {
						
		//variable
		int result = 0;
			
		result = list[rear];
		System.out.println("removed " + list[rear]);//prints element removed
		rear--; //decrements index for end of list
		
		
		return result;	
	}
		
	//------------------------------------------------------------------------
	// Exists Method:
	// Returns true of the int x exists in the list and false otherwise
	//*Time Complexity O(logN)*
	//------------------------------------------------------------------------
	public boolean exists (int x) {
		int left = 0;
		int right = rear;
			
		//Uses binary search method ---> cuts list in half with each iteration
		while (left <= right) {
			int mid = left + (right-left)/2;
				
			if (list[mid] == x) {
				return true;
			}
			if (list[mid] < x) {
				left = mid +1;
			}
			else {
				right = mid - 1;
			}
		}
		return false;
	}
					
	//------------------------------------------------------------------------
	// ToString Method:
	// Returns a string representing the sorted set as a space separated list
	//*Time Complexity O(N)*
	//------------------------------------------------------------------------
	public String toString() {
		String result = "";
		if (front > -1) {
			for (int i = front; i <= rear; i = (i + 1) % CAPACITY) {
				result += list[i]+ " "; //adds each number to end of list
			}
		}
		return result;
	}
		
	//------------------------------------------------------------------------
	// Main Method:
	// Creates an empty list, then repeatedly prompts the user for an input
	// command, performs the corresponding operation, and prints the list to
	// the screen. The program will end when the user types "q"
	//------------------------------------------------------------------------
	public static void main(String[] args) {
				
		//Required output
		System.out.println("-------------------------------------------------");
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: VICTORIA GRIFFIN");
		System.out.println("PROGRAMMING ASSIGNMENT 4");
		System.out.println();
				
				
		//new object initialized
		CircularArraySortedList values = new CircularArraySortedList();
			
		//Initialize scanner
		Scanner scan = new Scanner(System.in);
			
		//Output to console for user interaction
		System.out.print("Enter command: ");
		String input = scan.nextLine();
		
		//While loop for running entire program 	
		while (!input.equals("q")) {
		
			//Take first two characters and save them in variables
			if (input.length() > 1) {
				char ch1 = input.charAt(0);
				char ch2 = input.charAt(1);
	
				//If statement for when numbers are not parameter ---> rf and rl
				if (ch1 == 'r') {
					//Calls removeFirst method
					if (ch2 == 'f') {
						values.removeFirst();
						System.out.println(values);
					}
					else {
						//Calls removeLast method
						values.removeLast();
						System.out.println(values);
					}
				}
				//If statement for when numbers are parameter ---> a and e
				if (ch1 == 'a' || ch1 == 'e') {
					
					//Steps for pulling number out of string
					input = input.replaceAll("[^\\d]", " ");
					input = input.trim();
					int number = Integer.parseInt(input);
					
					//Calls add method
					if (ch1 == 'a') {
						values.add(number);
						System.out.println(values);
					}
					//Calls exists method
					else {
						System.out.println(values.exists(number));
					}
				}
				//loops back to beginning with output to console
				System.out.print("Enter command: ");
				input = scan.nextLine();
				}	
			}
		//prints end of program statement when "q" has been entered
		System.out.println();	
		System.out.println("Good bye!");
		System.out.println("-------------------------------------------------");
	}
}
