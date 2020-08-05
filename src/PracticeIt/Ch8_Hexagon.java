package PracticeIt;

import java.awt.Point;

public class Ch8_Hexagon {
	
	private Point center;
	
	private double side;
	
	public static final Point DEFAULT_CENTER = new Point(0, 0);
	
	public static final double DEFAULT_SIDE = 0.0;
	
	/**
	 * Construct a default hexagon centered at the origin (0, 0) with sides of length 0.0.
	 */
	public Ch8_Hexagon() {
		this(DEFAULT_CENTER, DEFAULT_SIDE);
	}
	
	/**
	 * Construct a hexagon with center at point c and sides of length s.
	 * 
	 * @param c
	 * 		the center point
	 * @param s
	 * 		the length of the sides
	 */
	public Ch8_Hexagon(Point c, double s) {
		this.setCenter(c);
		this.setSide(s);
	}

	/**
	 * Return the area of the hexagon.
	 * 
	 * @return area
	 */
	public double area() {
		double a = 3.*Math.sqrt(3.)/2.*Math.pow(getSide(), 2.);	
		return a;		
	}

	/**
	 * Return the perimeter of the hexagon.
	 * 
	 * @return perimeter
	 */
	public double perimeter() {
		double p = 6.*getSide();
		return p;
	}

	/**
	 * Return the center of the hexagon as a point object.
	 * 
	 * @return the center point
	 */
	public Point getCenter() {
		return this.center;
	}

	/**
	 * Return the length of the side of the hexagon.
	 * 
	 * @return the length of the sides
	 */
	public double getSide() {
		return this.side;
	}
	
	/**
	 * Set the center of the hexagon to this point.
	 * 
	 * @param c
	 * 		the center point				
	 */
	public void setCenter(Point c) {
		this.center = c;
	}

	/**
	 * Set the length of the side of the hexagon to this value.
	 * 
	 * @param r
	 * 		the length of the sides
	 */
	public void setSide(double r) {
		this.side = r;
	}	

}
