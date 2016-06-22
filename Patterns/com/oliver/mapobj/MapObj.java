package com.oliver.mapobj;

import java.util.HashMap;

//  This class will have a Map that will be used by all
//  Generally this would be a 'global' type object so 
//  the main thread and other threads will have access
//  to a common state
public class MapObj {
	HashMap<Integer, AppState> map;
	
	MapObj() {
		map = new HashMap<Integer, AppState>();
	}

	// OSB -- stuck here in the put pattern
	public Boolean insertAppState(Integer appID, AppState appInput) {
		AppState state = map.get(appID);
		if(state != null) {
			// update the state with current app
			map.put(appID, appInput);
			return false;
		}
		else {
			//Integer appID = AppState.getCounter();
			//map.put(appID, new AppState(appName, appID));
			return true;
		}
	}
	
	public static void main(String[] args) {
		MapObj myMap = new MapObj();
		/*
		Boolean insertfirst = myMap.insertAppState("FirstApp");
		Boolean insertsecond = myMap.insertAppState("Clash of Clans");
		Boolean insertthird = myMap.insertAppState("FirstApp");
		*/
		
	}
}
