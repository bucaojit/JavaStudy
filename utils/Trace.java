package com.bucaojit.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


//TODO: Add a way to choose log level by configuration file
//TODO: Add logging to a file

public class Trace {
	String className;
	Level logLevel;
	
	final Level DEFAULT_LEVEL = Level.DEBUG;
	
	public enum Level {
		NONE(0), ERROR(1), WARNING(2), DEBUG(3), TRACE(4);
		private int code;
		private Level(int code) {
			this.code = code;
		}
		public int get() {
			return this.code;
		}
	}
	
	public Trace(String className, Level logLevel) {
		this.className = className;
		this.logLevel = logLevel;
	}
	
	public Trace(String className) {
		this.className = className;
		this.logLevel = DEFAULT_LEVEL;
	}
	
	private void printDateTime() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm.ss").format(Calendar.getInstance().getTime());
		System.out.print(timeStamp + " ");
	}
	
	public void logTrace(String msg) {
		if (logLevel.get() >= 4) {	
			printDateTime();
			System.out.println(className + " TRACE " + msg);
		}
	}
	
	public void logDebug(String msg) {
		if (logLevel.get() >= 3) {	
			printDateTime();
			System.out.println(className + " DEBUG " + msg);
		}
	}
	
	public void logWarn(String msg) {
		if (logLevel.get() >= 2) {	
			printDateTime();
			System.out.println(className + " WARN " + msg);
		}
	}
	
	public void logError(String msg) {
		if (logLevel.get() >= 1) {	
			printDateTime();
			System.out.println(className + " ERROR " + msg);
		}
	}
	
	public void logEntry() {
		if (logLevel.get() >= 4) {	
			printDateTime();
			System.out.println(className + " TRACE ENTRY");
		}
	}
	
	public void logExit() {
		if (logLevel.get() >= 4) {	
			printDateTime();
			System.out.println(className + " TRACE EXIT");
		}
	}
	
}
