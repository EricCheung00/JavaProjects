package PracticeIt;

public class Ch9_StudentAdvanceTicket extends Ch9_AdvanceTicket {
	
	public Ch9_StudentAdvanceTicket(int value, int days) {
		super(value, days);
	}

	public Ch9_StudentAdvanceTicket() {
		this(0, 0);
	}
	
	public double getPrice() {
		return super.getPrice()/2.0;
	}
	
	public String toString() {
		return super.toString() + " (ID required)";
	}

}
