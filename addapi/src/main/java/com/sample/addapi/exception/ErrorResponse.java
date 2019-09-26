package com.sample.addapi.exception;

import java.util.Date;

public class ErrorResponse {
	private String msg;
	private Date timeStamp;
	private String details;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorResponse(String msg, Date date, String details) {
		super();
		this.msg = msg;
		this.timeStamp = date;
		this.details = details;
	}

	public void setmsg(String msg) {
		msg = msg;
	}

	public String getmsg() {
		return msg;
	}

}
