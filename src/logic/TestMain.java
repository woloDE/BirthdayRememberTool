package logic;

import org.joda.time.DateTime;

public class TestMain {

	public static void main(String[] args) {
		Birthday test = new Birthday(9, 12, 1992);
		test.tellBirthday();
		DateTime today = new DateTime(2016,12,9,1,1);
		
		DateTime myBirthday = new DateTime();
		
		DaysToBirthday.calculateDaysToBirthday(myBirthday,today );

		
		

	}

}
