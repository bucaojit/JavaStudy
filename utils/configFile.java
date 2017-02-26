package com.bucaojit.utils;

import java.util.Properties;

public class configFile {
	Properties configuration;
	
	public  configFile(String filename) {
		configuration = new Properties();
		try {
			configuration.load(this.getClass().getClassLoader().
					getResourceAsStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String property) {
		return configuration.getProperty(property);
	}
}
