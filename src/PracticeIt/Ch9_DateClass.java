package PracticeIt;

public class Ch9_DateClass {
	
	private int year;
	private int month;
	private int day;
	
	private static final int DEFAULT_YEAR = 1970;
	private static final int DEFAULT_MONTH = 1;
	private static final int DEFAULT_DAY = 1;
	
	private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] MONTH_NAMES = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	
	/**
	 * Returns an instance of the Date object with the date set to the default date
	 * (1970/01/01). Throws IllegalArgumentException if the input date is not valid.
	 */
	public Ch9_DateClass() {
		this(DEFAULT_YEAR, DEFAULT_MONTH, DEFAULT_DAY);
	}
	
	/**
	 * Returns an instance of the Date object with the date set to the input year,
	 * month, and day. Throws IllegalArgumentException if the input date is not
	 * valid.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Ch9_DateClass(int year, int month, int day) {
		setDate(year, month, day);
	}
	
	/**
	 * Return a new instance of Date with the same date as this.
	 * 
	 * @return Date
	 */
	private Ch9_DateClass getDate() {
		return new Ch9_DateClass(this.year, this.month, this.day);
	}

	/**
	 * Move "this" date one day backward.
	 */
	private void dayIncrement(boolean isMoveFwd) {
		int extraDay = (isLeapYear(year) && this.month==2)? 1:0;
		if (isMoveFwd) {
			// move one day forward
			if ( (this.day == DAYS_IN_MONTH[11]) && (this.month == 12) ) {
				this.year++;
				this.month = 1;
				this.day = 1;
			} else if (this.day == DAYS_IN_MONTH[this.month-1]+extraDay) {
				this.month++;
				this.day = 1;
			} else {
				this.day++;
			}
		} else {
			// move one day backward
			if ( (this.day == 1) && (this.month == 1) ) {
				this.year--;
				this.month = 12;
				this.day = DAYS_IN_MONTH[11];
			} else if (this.day == 1) {
				this.month--;
				this.day = DAYS_IN_MONTH[this.month-1]+extraDay;
			} else {
				this.day--;
			}
		}
	}

	/**
	 * Add a number of days to "this" date. A positive value moves the date forward;
	 * a negative value moves it backward.
	 * 
	 * @param days
	 */
	public void addDays(int days) {
		boolean isMoveFwd = (days > 0)? true:false;
		while (days > 0) {
			dayIncrement(isMoveFwd);
			days--;
		}
		while (days < 0) {
			dayIncrement(isMoveFwd);
			days++;
		}
	}
	
	/**
	 * Add a number of weeks to "this" date. A positive value moves the date
	 * forward; a negative value moves it backward. A week has 7 days.
	 * 
	 * @param weeks
	 */
	public void addWeeks(int weeks) {
		int days = weeks*7;
		addDays(days);
	}
	
	/**
	 * Returns the number of days from "this" date to the input argument "date".
	 * Returns positive value if "date" is in the future relative to "this".
	 * 
	 * @param date
	 * 			target date
	 * @return days
	 */
	public int daysTo(Ch9_DateClass date) {
		return daysTo(getDate(), date);
	}

	/**
	 * Returns the number of days from "date1" to "date2".
	 * Returns positive value if "date2" is in the future of "date1".
	 * 
	 * @param date1
	 * 			base date
	 * @param date2
	 * 			target date
	 * @return days
	 */
	public static int daysTo(Ch9_DateClass date1, Ch9_DateClass date2) {

		int days = 0;
		
		// first, check if date2 is in the future of date1
		boolean isMoveFwd = false;
		if ((date2.getYear() > date1.getYear()) 
				|| ((date2.getYear() == date1.getYear()) && (date2.getMonth() > date1.getMonth()))
				|| ((date2.getYear() == date1.getYear()) && (date2.getMonth() == date1.getMonth()) && (date2.getDay() > date1.getDay()))) {
			isMoveFwd = true;
		}
		
		// then, increment date1 until date1 equals date2, count how many days it takes
		Ch9_DateClass temp = date1.getDate();
		while (!((temp.getYear() == date2.getYear()) 
				&& (temp.getMonth() == date2.getMonth())
				&& (temp.getDay() == date2.getDay())) ) {
			temp.dayIncrement(isMoveFwd);
			days++;
		}
		int sign = (isMoveFwd)? +1:-1;
		return days*sign;
	}
	
	/**
	 * Returns "this" day.
	 * 
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Returns "this" month.
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns "this" year.
	 * 
	 * @return the year.
	 */
	public int getYear() {
		return year;
	}
	
	
	
	/**
	 * Returns true if "this" date is on a leap year.
	 * @return boolean
	 */
	public boolean isLeapYear() {
		return isLeapYear(this.year);
	}
	
	/**
	 * Returns true if the year is a leap year.
	 * 
	 * @param year
	 * @return boolean
	 */
	public boolean isLeapYear(int year) {
		
		boolean isLeap = false;
		
		if ( (year % 4 == 0) && (year % 100 != 0) ) {
			isLeap = true;
		}
		if (year % 400 == 0) {
			isLeap = true;
		}
		return isLeap;
	}

	/**
	 * Return the string of date in long format.
	 * For example, "January 01, 2030".
	 * 
	 * @return the string
	 */
	public String longDate() {
		return String.format("%s %02d, %4d", MONTH_NAMES[this.month-1], this.day, this.year);
	}
	
	/**
	 * Set the "this" date to the input year, month, and day.
	 * Throws IllegalArgumentException if the input date is not valid.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setDate(int year, int month, int day) {
		int leapDay = (isLeapYear(year) && month==2)? 1:0; 
		if ( (month >= 1) && (month <= 12) && (day >= 1) && (day <= DAYS_IN_MONTH[month-1] + leapDay) ) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Set "this" day to the input day. Throws IllegalArgumentException if the input
	 * date is not valid.
	 * 
	 * @param day
	 */
	public void setDay(int day) {
		setDate(this.year, this.month, day);
	}

	/**
	 * Set "this" month to the input month. Throws IllegalArgumentException if the
	 * input date is not valid.
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		setDate(this.year, month, this.day);
	}

	/**
	 * Set "this" year to the input year. Throws IllegalArgumentException if the
	 * input date is not valid.
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		setDate(year, this.month, this.day);
	}
	
	/**
	 * Return the string of the date in short format (10 characters long).
	 * For example, "2030/02/25".
	 * 
	 * @return the string
	 */
	public String toString() {
		return String.format("%4d/%02d/%02d", this.year, this.month, this.day);
	}

}
