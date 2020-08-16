package PracticeIt;

public class Ch9_WalkupTicket extends Ch9_Ticket {

	public Ch9_WalkupTicket(int value) {
		super(value);
	}
	
	public Ch9_WalkupTicket() {
		this(0);
	}

	public double getPrice() {
		return 50;
	}

}
