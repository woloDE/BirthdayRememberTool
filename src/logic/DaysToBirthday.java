package logic;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DaysToBirthday {
	
	public static int calculateDaysToBirthday(DateTime now, DateTime birthday){
	
		
		DateTime timeToday = new DateTime(DateTime.now().getYear(), now.getMonthOfYear(), now.getDayOfMonth(), now.getMinuteOfHour(), now.getSecondOfMinute());
		DateTime timeOfBirth = new DateTime(DateTime.now().getYear(), birthday.getMonthOfYear(), birthday.getDayOfMonth(), birthday.getMinuteOfHour(), birthday.getSecondOfMinute());
		
		
		int daysToBirth;
		System.out.println(Days.daysBetween(timeToday, timeOfBirth));
		daysToBirth = Days.daysBetween(timeToday, timeOfBirth).getDays();
		System.out.println(daysToBirth);
		
		return daysToBirth;
	}
	
}
