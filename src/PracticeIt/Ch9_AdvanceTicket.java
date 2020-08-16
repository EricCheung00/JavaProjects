package PracticeIt;

public class Ch9_AdvanceTicket extends Ch9_Ticket {
	
	private int days;
	
	public Ch9_AdvanceTicket(int value, int days) {
		super(value);
		this.days = days;
		if (days < 0) {	
			throw new IllegalArgumentException();
		}
	}
	
	public Ch9_AdvanceTicket() {
		this(0, 0);
	}
	
	public double getPrice() {
		double price = 0;
		
		if (this.days >= 10) {
			price = 30;
		} else {
			price = 40;
		}
		return price;
	}
	
	public int getDays() {
		return this.days;
	}

}
