package webdriver.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Letter {

	private String theme = "";
	private String body = "";
	private Calendar calendar;
	private String senderUsername;
	
	public Letter(String theme, String body, Calendar calendar, String senderUsername) {
		this.theme = theme;
		this.body = body;
		this.calendar = calendar;
		this.senderUsername = senderUsername;
	}

	public Letter(String senderTheme, String body, String senderTime, String senderName) {
		this.theme = senderTheme;
		this.body = body;
		this.calendar = gmailTimeMessageToCalendar(senderTime);
		this.senderUsername = senderName;
	}

	private Calendar gmailTimeMessageToCalendar(String senderTime) {
		Calendar calendarMessage = GregorianCalendar.getInstance();
		
		String[] date = senderTime.split(" ");
		int day = Integer.parseInt(date[0]);
		int month = getNumberByMonth(date[1]);
		int year = Integer.parseInt(date[2]);;
		
		String[] time = date[4].split(":");
		int hour = Integer.parseInt(time[0]);
		int minute  = Integer.parseInt(time[1]);
		
		calendarMessage.set(year, month, day, hour, minute);
		return calendarMessage;
	}

	
	@Override
	public String toString() {
		return "Message [theme=" + theme + ", body=" + body + ", calendar=" + calendar 
				+ ", senderUsername=" + senderUsername + "]";
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Calendar getTime() {
		return calendar;
	}

	public void setTime(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getTimeSend() {
		@SuppressWarnings("deprecation")
		String month = getMonthByNumber(calendar.getTime().getMonth());
		String dateSend = new SimpleDateFormat("d $ yyyy г., HH:mm")
				.format(calendar.getTime());
		return dateSend.replace("$", month);
	};
	
	enum Month{
		января(0),
		февраля(1),
		марта(2),
		апреля(3),
		мая(4),
		июня(5),
		июля(6), 
		августа(7),
		сентября(8),
		октября(9),
		ноября(10),
		декабря(11);
		
		private int value;

        private Month(int value) {
                this.value = value;
        }

		public int getValue() {
			return value;
		}

		
	}
	
	private int getNumberByMonth(String string) {
		Month[] months = Month.values();
		for(Month month : months)
			if(month.toString().equals(string))
				return month.value;
		return 0;
	}


	private String getMonthByNumber(int monthNumber) {
		Month[] months = Month.values();
		for(Month month : months)
			if(month.value == monthNumber)
				return month.toString();
		return " ";
	}

	
	
}
