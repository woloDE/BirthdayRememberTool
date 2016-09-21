package logic;

public class Birthday {
	
	
	private int day;
	private int month;
	private int year;
	
	private String [] birthday = new String[5];
	
	public Birthday(int day, int month, int year){
		setDay(day);
		setMonth(month);
		setYear(year);		
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String[] tellBirthday(){
		birthday[0] = Integer.toString(day);
		birthday[1] = ":";
		birthday[2] = Integer.toString(month);
		birthday[3] = ":";
		birthday[4] = Integer.toString(year);
		
		System.out.println(birthday[0]+birthday[1]+birthday[2]+birthday[3]+birthday[4]);
		
		
		return birthday;
	}
	

}
