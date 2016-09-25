package logic;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DaysToBirthday {
	
	public static int calculateDaysToBirthday(DateTime now, DateTime birthday){
	
		int daysToBirth;
		System.out.println(Days.daysBetween(now, birthday));
		daysToBirth = Days.daysBetween(now, birthday).getDays();
		System.out.println(daysToBirth);
		return daysToBirth;
	}
	
}
