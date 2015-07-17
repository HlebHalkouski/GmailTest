package webdriver.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


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
		String dateSend = new SimpleDateFormat("dd $ yyyy г., HH:mm")
				.format(calendar.getTime());
		return dateSend.replace("$", month);
	};

	private String getMonthByNumber(int month) {
		switch(month){
		case 0:
			return "января";
		case 1:
			return "февраля";
		case 2:
			return "марта";
		case 3:
			return "апреля";
		case 4:
			return "мая";
		case 5:
			return "июня";
		case 6:
			return "июля";
		case 7:
			return "августа";
		case 8:
			return "сентября";
		case 9:
			return "октября";
		case 10:
			return "ноября";
		case 11:
			return "декабря";
		}
		return " ";
	}

	
	
}
