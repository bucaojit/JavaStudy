package com.oliver.mapobj;

public class AppState {
	private String name;
	private Integer myid;
	private static Integer counter = 0;
	
	public static Integer getCounter() {
		return counter++;
	}
	
	AppState(String name, Integer id) {
		this.name = name;
		this.myid = id;
	}
	
	public Integer getId() {
		return myid;
	}
	public String getName() {
		return name;
	}
}
