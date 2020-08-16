 package PracticeIt;

public class Ch9_DateTests {
	 /*
	* Bellevue College CS210
	* from Building Java Programs text
	* by Reges and Stepp (Pearson pub.)
	*
	* Programming Project #2, Chapter 8
	*   also note text examples for output format
	*/
	//public class Assign8B {
		// Part of the main method used to test the Date class
		// NO imports allowed from the JAVA API
	  public static void main(String[] a) {
		 Ch9_DateClass one = new Ch9_DateClass(1582,10,15);	// start of Gregorian
	     Ch9_DateClass two = new Ch9_DateClass(2020,1,28); // 2020 is a leap year
	  	
	     one.addDays(1);		// advance one day (negative subtracts days)
	     System.out.println(one);	// toString will be called, style is 1582/10/16
	     one.addWeeks(10);	// advance by 10 weeks (negative allowed, yes)
	     System.out.println(one);	// toString will be called, style is 1582/12/25
	     System.out.println(two.daysTo(one)); // -159645 days (negative)
	     System.out.println(one.daysTo(two)); //  159645 days (positive)
	     two.addDays(-5); // negative days allowed
	     System.out.println(two);	// toString will be called, style is 2020/01/23
	     two.addWeeks(-4); // negative weeks allowed
	     System.out.println(two);// toString will be called, style is 2019/12/26
	     two.addWeeks(-8); // negative days allowed
	     System.out.println(two);// toString will be called, style is 2019/10/31
	     System.out.println(one.getDay());	// day is now the 25th (advanced)
	     System.out.println(one.getMonth());	// returns 12, January is 1
	     System.out.println(one.getYear());	// still 1582 from start
	     System.out.println(one.isLeapYear());	// false for 1582
	     System.out.println(one);	// toString will be called, style is 1582/12/25
	  	
	     try {
	        @SuppressWarnings("unused")
			Ch9_DateClass three = new Ch9_DateClass(12,34,1956); // obviously illegal
	     }
	     catch (IllegalArgumentException e) {
	        System.out.println("Illegal day attempted");
	     }
	  	
	     Ch9_DateClass four = new Ch9_DateClass();
	  	// create "longDate" output
	  	// I thought a long date was dinner with a person you don't like?
	     System.out.println(four.longDate());  // January 1, 1970
	 
	     try {
	        four.setDate(2019,2,29);// Attempt to set an illegal date
	     }
	     catch (IllegalArgumentException e) {
	        System.out.println("Illegal day attempted");
	     }
	  	
	  	 // Finally, let's understand what static methods are most commonly used for:
	     System.out.println(Ch9_DateClass.daysTo(one, two));	// 159556 days (positive)
	  }

}
