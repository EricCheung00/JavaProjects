
public class TowerOfHanoi {

	public void move(int numOfDiscs, char from, char to, char via) {
		
		// ending condition: if there is only 1 disc to move
		if (numOfDiscs == 1) {
			System.out.println("Move disc 1 from " + from + " to " + to);
		} else {
			move(numOfDiscs-1, from, via, to);
			System.out.println("Move disc " + numOfDiscs + " from " + from + " to " +  to);
			move(numOfDiscs-1, via, to, from);	
		}		
	}
	
	public static void main(String[] args) {
		TowerOfHanoi toh = new TowerOfHanoi();
		toh.move(10, 'A', 'B', 'C');
	}

}
