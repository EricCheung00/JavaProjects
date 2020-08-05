package PracticeIt;

import java.awt.Point;

public class Ch8_Proj_Hexagon {

	public static void main(String[] args) {
 
		// Client tests the Class we've made
		Ch8_Hexagon h1 = new Ch8_Hexagon(new Point(82,92),10);
		h1.setSide(50);
		h1.area();  // returns 6495.19
		h1.perimeter();   // returns 300.0

		System.out.println(h1.area());
		System.out.println(h1.perimeter());
		System.out.println(h1.getCenter());
	}

}
