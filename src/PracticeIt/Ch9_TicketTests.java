package PracticeIt;

//CS210 BC
public class Ch9_TicketTests {
	//testing code for Ticket Classes
	//BJP text Exercises, Chapter 9
	public static void main(String[] args) {
		Ch9_Ticket[] scam = new Ch9_Ticket[15]; // an array of Tickets that don't exist (an array of 15 null instances of Ticket)
		for (@SuppressWarnings("unused") Ch9_Ticket tick : scam) {
			tick = new Ch9_WalkupTicket(); // actually calls a constructor for each
		}
		
		//ticket number 10 is attempted, purchased 20 days in advance
		Ch9_AdvanceTicket one = new Ch9_AdvanceTicket(10, 20);
		// one.setNumber(17); // not allowed, no such method, keeps # unique
		System.out.println(one); // with above, Number: 15, Price: 30.0
		System.out.println("(Should be \"Number: 15, Price: 30.0\")");
		System.out.println("Number of days: " + one.getDays());
		System.out.println("(Should be \"Number of days: 20\")");
		// calls this(0,0);This will have number = 16
		
		System.out.println(new Ch9_AdvanceTicket()); // output should be Number: 16, Price: 40.0
		System.out.println("(Should be \"Number: 16, Price: 40.0\")");
		
		// #2 attempted, but number 2 not available, ticket number set to next available number (17)
		Ch9_WalkupTicket two = new Ch9_WalkupTicket(2);
		System.out.println(two); // output should be Number: 17, Price: 50.0
		System.out.println("(Should be \"Number: 17, Price: 50.0\")");
		// System.out.println("Number of days: " + two.getDays());// should not compile
		// no getDays method on WalkupTicket class
		
		System.out.println(new Ch9_WalkupTicket()); // calls this(0); This will get number = 18
		System.out.println("(Should be \"Number: 18, Price: 50.0\")");
		
		Ch9_StudentAdvanceTicket three = new Ch9_StudentAdvanceTicket(99, 9); // 99 is available, number= 99
		System.out.println(three); // Number: 99, (use toString from Ticket) add (ID Required)
		System.out.println("(Should be \"Number: 99, Price: 20.0 (ID required)\")");
		System.out.println("Number of days: " + three.getDays()); // should print 9
		System.out.println("(Should be \"Number of days: 9\")");
		
		System.out.println(new Ch9_StudentAdvanceTicket()); // must call this(0,0); Number will be set to 19
		System.out.println("(Should be \"Number: 19, Price: 20.0 (ID required)\")");
		
		try {
			@SuppressWarnings("unused")
			Ch9_StudentAdvanceTicket trouble = new Ch9_StudentAdvanceTicket(123, -5);
			System.out.println("Expected IllegalArgumentException not seen?");
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e);
		}
		
		Ch9_StudentAdvanceTicket last = new Ch9_StudentAdvanceTicket(99, 15); // 99 already used? Number set to 100
		System.out.println(last); // with above, Number: 100, Price: 15.0 (Id required)
		System.out.println("(Should be \"Number: 100, Price: 15.0 (ID required)\")");
		
		Ch9_StudentAdvanceTicket five = new Ch9_StudentAdvanceTicket();
		System.out.println(five);
		System.out.println("(Should be \"Number: 20, Price: 20.0 (ID required)\")");
	}
}