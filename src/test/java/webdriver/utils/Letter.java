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
	
	public Letter(Calendar calendar, String forwardingNoreplyGoogleCom) {
		this.calendar = calendar;
		this.senderUsername = forwardingNoreplyGoogleCom;
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
		return new SimpleDateFormat("HH:mm")
				.format(calendar.getTime());
	}
	
}
