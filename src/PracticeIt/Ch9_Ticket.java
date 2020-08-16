package PracticeIt;

/**
 * Course: CS210 Assignment: #9 Ticket Exercises from text
 */
// DO NOT Change this code, it will be used as base for all grading
public class Ch9_Ticket {
	//INSTANCE VARIABLES
	private int number; // The ticket number defined by constructor
	// protected double price;  // Price determined only in sub-class
	// STATIC FIELDS: Only one for the whole Class
	private static int numSold = 0;
	public static int maxSales = 1000;
	private static boolean[] sold = new boolean[maxSales];

	// Tells us if that index (number) is sold
	// CONSTRUCTORS
	public Ch9_Ticket(int value) {
		if (Ch9_Ticket.numSold == maxSales) {
			throw new IllegalArgumentException("Reached maximum number of tickets.");
		}
		if (value < 0 || value >= maxSales)
			value = 0; // reset the value to a valid number
		while (sold[value]) {
			value++; // find next available unique ticket number
			value = value % maxSales; // reset if reached the end of array index
		}
		// Found a valid, unused ticket number
		Ch9_Ticket.numSold++;
		sold[value] = true;
		number = value; // Ticket constructor sets number
	}

	// ALWAYS use existing constructors as much as possible
	public Ch9_Ticket() {
		this(0);
	}

	// ACCESSORS
	public double getPrice() {
		return 0; // method should be overriden by sub classes
	}

	// JAVA standard toString
	public String toString() {
		return "Number: " + this.number + ", Price: " + this.getPrice();
	}
}
