/**
 * Date Class (Sample Solution for assignment 4, exercise 3)
 * 
 * @author Tobias Lauer, Hochschule Offenburg
 * @editor Juergen Prinzbach, Hochschule Offenburg
 */
public class Date implements Vergleichbar {

	// Declaration of variables
	private int day, month, year;

	/**
	 * Generates a date object with date 01.01.2000
	 */
	public Date() {
		setDate(1, 1, 2000);
	}
	
	/**
	 * Generates a date object or 01.01.2000 in case the given parameters aren't
	 * valid
	 * 
	 * @param myDay
	 *            The day of this date
	 * @param myMonth
	 *            The month of this date
	 * @param myYear
	 *            The year of this date
	 */
	public Date(int myDay, int myMonth, int myYear)  {
		this(); // Default-Date erzeugen (1.1.2000)
		
		setDate(myDay, myMonth, myYear); // Ändern auf übergebene Daten (falls diese gültig sind)
	}

	public int getDay() {
		return day;
	}
	 
	public int getMonth() {
		return month;
	}
	 
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the values of this Date object to the given values
	 * if they form a valid date.
	 * 
	 * @param newDay
	 * @param newMonth
	 * @param newYear
	 * @return true if the date was set to the given values, false otherwise
	 */
	public boolean setDate(int newDay, int newMonth, int newYear) {
		if(isValidDate(newDay, newMonth, newYear)) {
			day = newDay;
			month = newMonth;
			year = newYear;
			return true;
		} else {
            return false;
        }
	}

	/**
	 * Checks whether a specific year was, is or will be a leap year
	 * 
	 * @param year
	 *            The year to be checked
	 * @return {boolean} true if the specified year was, is or will be a leap
	 *         year
	 */
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

	/**
	 * Calculates the number of days of a specific month
	 * 
	 * @param month
	 *            The month to be checked
	 * @param year
	 *            The year of said month
	 * @return {integer} The number of days
	 */
	public static int getNumberOfDays(int month, int year) {
		// Calculate number of days
		switch (month) {
		case 2:
			if (isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	/**
	 * Checks whether a specific date is a valid date
	 * 
	 * @param day
	 *            The day of this date
	 * @param month
	 *            The month of this date
	 * @param year
	 *            The year of this date
	 * @return {boolean} True, when the date is valid
	 */
	public static boolean isValidDate(int day, int month, int year) {
		return (day >= 1 && day <= getNumberOfDays(month, year) 
				&& month >= 1 && month <= 12);
	}
	
	/**
	 * Returns true if this Date object represents a date that is before the date
	 * of the given Date object, and false otherwise.
	 * 
	 * @param other the Date to compare with
	 * @return true iff this date is before the other date
	 */
	public boolean isBefore(Date other) {
		return this.year < other.year 
			|| (this.year == other.year && this.month < other.month)
			|| (this.year == other.year && this.month == other.month && this.day < other.day);	
	}
	
	/**
	 * Converts the date of this object to a string in the following format:
	 * "dd.mm.yyyy"
	 * 
	 * @return {String} This date as a string
	 */
	public String toString() {
        // return String.format("%02d.%02d.%04d", day, month, year);
        String output = "";
        if (day < 10) {
            output = output + "0";  // damit ausgabe zweistellig wird
        }
        output = output + day + ".";

        if (month < 10) {
            output = output + "0";  // damit ausgabe zweistellig wird
        }
        output = output + month + ".";
        
        String jahr = "" + year;
        while (jahr.length() < 4) {     // evtl. mit Nullen füllen
            jahr = "0" + jahr;
        }
        jahr = jahr.substring(jahr.length()-4, jahr.length());  // letzte 4 Stellen von Jahr nehmen

        output = output + jahr;

        return output;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Date) {
			Date otherDate = (Date)other;
			if (this.day == otherDate.getDay() && this.month == otherDate.getMonth() && this.year == otherDate.getYear()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
 	}

	@Override
	public boolean isKleinerAls(Object other) {
		return this.isBefore((Date)other);
	}

}
